package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.entity.projectile.PoisonBomb;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class PoisonBombRenderer extends EntityRenderer<PoisonBomb> {
    private static final ResourceLocation POISON_BOMB_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/projectile/poison_bomb.png");
    private final ModelPart poisonBomb;

    public PoisonBombRenderer(EntityRendererProvider.Context context) {
        super(context);
        poisonBomb = context.bakeLayer(AncientAetherModelLayers.POISON_BOMB);
    }

    @Override
    public void render(@NotNull PoisonBomb poisonBomb, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, poisonBomb.xRotO, poisonBomb.getXRot()) + 180.0F));
        poseStack.translate(0.0, -1.5, 0.0);
        VertexConsumer iVertexBuilder = buffer.getBuffer(RenderType.entityTranslucent(getTextureLocation(poisonBomb)));
        this.poisonBomb.render(poseStack, iVertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(poisonBomb, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull PoisonBomb poisonBomb) {
        return POISON_BOMB_TEXTURE;
    }
}