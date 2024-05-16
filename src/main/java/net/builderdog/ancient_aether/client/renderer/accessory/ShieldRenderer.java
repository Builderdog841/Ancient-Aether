package net.builderdog.ancient_aether.client.renderer.accessory;

import com.aetherteam.aether.client.renderer.AetherModelLayers;
import com.aetherteam.aether.mixin.mixins.client.accessor.PlayerModelAccessor;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.item.equipment.accessories.shields.ShieldAccessoryItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class ShieldRenderer implements ICurioRenderer {
    private final HumanoidModel<LivingEntity> shieldModel;
    private final PlayerModel<LivingEntity> shieldModelSlim;
    public final HumanoidModel<LivingEntity> shieldModelArm;
    public final PlayerModel<LivingEntity> dummyArm;
    public final PlayerModel<LivingEntity> dummyArmSlim;

    public ShieldRenderer() {
        shieldModel = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(AetherModelLayers.SHIELD_OF_REPULSION));
        shieldModelSlim = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(AetherModelLayers.SHIELD_OF_REPULSION_SLIM) , true);
        shieldModelArm = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(AetherModelLayers.SHIELD_OF_REPULSION_ARM));
        dummyArm = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        dummyArmSlim = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER_SLIM), true);
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        LivingEntity livingEntity = slotContext.entity();
        ShieldAccessoryItem shield = (ShieldAccessoryItem) stack.getItem();
        ResourceLocation texture;
        HumanoidModel<LivingEntity> model;

        if (livingEntity instanceof Player && renderLayerParent.getModel() instanceof PlayerModel<?> playerModel) {
            PlayerModelAccessor playerModelAccessor = (PlayerModelAccessor) playerModel;
            model = playerModelAccessor.aether$getSlim() ? shieldModelSlim : shieldModel;
            texture = playerModelAccessor.aether$getSlim() ? shield.getShieldSlimTexture() : shield.getShieldTexture();
        } else {
            model = shieldModel;
            texture = shield.getShieldTexture();
        }

        ICurioRenderer.followHeadRotations(slotContext.entity(), model.head);
        ICurioRenderer.followBodyRotations(slotContext.entity(), model);
        VertexConsumer consumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityTranslucent(texture), false, false);
        model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderFirstPerson(ItemStack stack, PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, HumanoidArm arm) {
        boolean isSlim = player.getSkin().model() == PlayerSkin.Model.SLIM;
        if (!player.isInvisible()) {
            setupHand(isSlim ? dummyArmSlim : dummyArm, poseStack, buffer, packedLight, player, arm, isSlim);
        }
        setupShieldOnHand(stack, shieldModelArm, poseStack, buffer, packedLight, player, arm, isSlim);
    }

    private void setupShieldOnHand(ItemStack stack, HumanoidModel<LivingEntity> model, PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, HumanoidArm arm, boolean isSlim) {
        setupModel(model, player);
        ShieldAccessoryItem shield = (ShieldAccessoryItem) stack.getItem();
        VertexConsumer consumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityTranslucent(shield.getShieldTexture()), false, stack.isEnchanted());
        if (isSlim) {
            poseStack.translate((arm != HumanoidArm.LEFT ? 1.0F : -1.0F) * 0.05F, 0.0F, 0.0F);
        }
        if (arm == HumanoidArm.RIGHT) {
            renderShieldOnHand(model.rightArm, poseStack, packedLight, consumer);
        } else if (arm == HumanoidArm.LEFT) {
            renderShieldOnHand(model.leftArm, poseStack, packedLight, consumer);
        }
    }

    private void setupHand(PlayerModel<LivingEntity> model, PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, HumanoidArm arm, boolean isSlim) {
        setupModel(model, player);

        VertexConsumer consumer = buffer.getBuffer(RenderType.entityTranslucent(player.getSkin().texture()));
        if (isSlim) {
            poseStack.translate((arm != HumanoidArm.LEFT ? 1.0F : -1.0F) * -0.05F, 0.0F, 0.0F);
        }
        if (arm == HumanoidArm.RIGHT) {
            renderHand(model.rightArm, model.rightSleeve, poseStack, packedLight, consumer);
        } else if (arm == HumanoidArm.LEFT) {
            renderHand(model.leftArm, model.leftSleeve, poseStack, packedLight, consumer);
        }
    }

    private void setupModel(HumanoidModel<LivingEntity> model, AbstractClientPlayer player) {
        model.setAllVisible(false);
        model.attackTime = 0.0F;
        model.crouching = false;
        model.swimAmount = 0.0F;
        model.setupAnim(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    }

    private void renderShieldOnHand(ModelPart shieldArm, PoseStack poseStack, int packedLight, VertexConsumer consumer) {
        shieldArm.visible = true;
        shieldArm.xRot = 0.0F;
        shieldArm.render(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void renderHand(ModelPart dummyArm, ModelPart dummySleeve, PoseStack poseStack, int packedLight, VertexConsumer consumer) {
        dummyArm.visible = true;
        dummySleeve.visible = true;
        dummyArm.xRot = 0.0F;
        dummySleeve.xRot = 0.0F;
        dummyArm.render(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        dummySleeve.render(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}