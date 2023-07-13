package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.HighlandsBuffaloModel;
import net.builderdog.ancient_aether.entity.custom.animals.HighlandsBuffaloEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HighlandsBuffaloRenderer extends GeoEntityRenderer<HighlandsBuffaloEntity> {
    public HighlandsBuffaloRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HighlandsBuffaloModel());
    }

    @Override
    public ResourceLocation getTextureLocation(HighlandsBuffaloEntity animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/highlands_buffalo.png");
    }

    @Override
    public void render(HighlandsBuffaloEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}