package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.model.WyndZephyrModel;
import net.builderdog.ancient_aether.entity.monster.WyndZephyr;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class WyndZephyrTransparencyLayer extends RenderLayer<WyndZephyr, EntityModel<WyndZephyr>> {
    private static final ResourceLocation VELOX_ZEPHYR_TRANSPARENCY_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/wynd_zephyr/wynd_zephyr_layer.png");

    private final WyndZephyrModel transparency;

    public WyndZephyrTransparencyLayer(RenderLayerParent<WyndZephyr, EntityModel<WyndZephyr>> entityRenderer, WyndZephyrModel transparencyModel) {
        super(entityRenderer);
        this.transparency = transparencyModel;
    }

    @Override
    public void render(@Nonnull PoseStack poseStack, @Nonnull MultiBufferSource buffer, int packedLight, @Nonnull WyndZephyr wyndZephyr, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (this.getParentModel() instanceof WyndZephyrModel && !wyndZephyr.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.transparency);
            this.transparency.prepareMobModel(wyndZephyr, limbSwing, limbSwingAmount, partialTicks);
            this.transparency.setupAnim(wyndZephyr, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer consumer = buffer.getBuffer(RenderType.entityTranslucent(VELOX_ZEPHYR_TRANSPARENCY_TEXTURE));
            this.transparency.renderToBuffer(poseStack, consumer, packedLight, LivingEntityRenderer.getOverlayCoords(wyndZephyr, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}