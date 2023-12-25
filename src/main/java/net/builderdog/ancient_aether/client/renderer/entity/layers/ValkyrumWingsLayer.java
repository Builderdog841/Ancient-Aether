package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.client.renderer.entity.model.ValkyrieWingsModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.item.equipment.armor.EquipmentUtil;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class ValkyrumWingsLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation WINGS_TEXTURE = new ResourceLocation(Aether.MODID, "textures/entity/mobs/valkyrie/valkyrie.png");
    private final ValkyrieWingsModel<Player> wings;

    public ValkyrumWingsLayer(RenderLayerParent<T, M> entityRenderer, EntityModelSet modelSet) {
        super(entityRenderer);
        this.wings = new ValkyrieWingsModel<>(modelSet.bakeLayer(AncientAetherModelLayers.VALKYRUM_WINGS));
    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (EquipmentUtil.hasFullValkyrumSet(entity)) {
            AetherPlayer.get(entity).ifPresent((aetherPlayer) -> {
                this.setupWingRotation(entity, Mth.lerp(partialTicks, aetherPlayer.getWingRotationO(), aetherPlayer.getWingRotation()));
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(WINGS_TEXTURE));
                this.wings.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            });
        }
    }

    public void setupWingRotation(T entity, float sinage) {
        if (!entity.onGround() && !entity.isInFluidType() && (entity.getVehicle() != null && !entity.getVehicle().onGround())) {
            sinage *= 1.5F;
        } else {
            sinage *= 0.3F;
        }

        this.wings.rightWing.yRot = 0.4F;
        this.wings.rightWing.zRot = 0.125F;
        this.wings.leftWing.yRot = -0.4F;
        this.wings.leftWing.zRot = -0.125F;

        if (entity.isCrouching()) {
            this.wings.rightWing.xRot = 0.45F;
            this.wings.rightWing.y = 3.33F;
            this.wings.rightWing.z = 3.388F;
            this.wings.leftWing.xRot = 0.45F;
            this.wings.leftWing.y = 3.33F;
            this.wings.leftWing.z = 3.388F;
        } else {
            this.wings.rightWing.xRot = 0.0F;
            this.wings.leftWing.xRot = 0.0F;
        }

        this.wings.rightWing.yRot -= Mth.sin(sinage) / 6.0F;
        this.wings.rightWing.zRot -= Mth.cos(sinage) / (entity.onGround() || entity.isInFluidType() ? 8.0F : 3.0F);
        this.wings.leftWing.yRot += Mth.sin(sinage) / 6.0F;
        this.wings.leftWing.zRot += Mth.cos(sinage) / (entity.onGround() || entity.isInFluidType() ? 8.0F : 3.0F);
    }
}