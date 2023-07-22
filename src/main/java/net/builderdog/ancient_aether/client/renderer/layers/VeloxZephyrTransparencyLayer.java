package net.builderdog.ancient_aether.client.renderer.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.VeloxZephyrModel;
import net.builderdog.ancient_aether.entity.monster.VeloxZephyr;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class VeloxZephyrTransparencyLayer extends RenderLayer<VeloxZephyr, EntityModel<VeloxZephyr>> {
    private static final ResourceLocation VELOX_ZEPHYR_TRANSPARENCY_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/velox_zephyr/velox_zephyr_layer.png");

    private final VeloxZephyrModel transparency;

    public VeloxZephyrTransparencyLayer(RenderLayerParent<VeloxZephyr, EntityModel<VeloxZephyr>> entityRenderer, VeloxZephyrModel transparencyModel) {
        super(entityRenderer);
        this.transparency = transparencyModel;
    }

    @Override
    public void render(@Nonnull PoseStack poseStack, @Nonnull MultiBufferSource buffer, int packedLight, @Nonnull VeloxZephyr veloxzephyr, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (this.getParentModel() instanceof VeloxZephyrModel && !veloxzephyr.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.transparency);
            this.transparency.prepareMobModel(veloxzephyr, limbSwing, limbSwingAmount, partialTicks);
            this.transparency.setupAnim(veloxzephyr, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer consumer = buffer.getBuffer(RenderType.entityTranslucent(VELOX_ZEPHYR_TRANSPARENCY_TEXTURE));
            this.transparency.renderToBuffer(poseStack, consumer, packedLight, LivingEntityRenderer.getOverlayCoords(veloxzephyr, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}