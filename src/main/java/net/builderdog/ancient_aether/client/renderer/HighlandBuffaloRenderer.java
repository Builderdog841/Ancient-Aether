package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.HighlandBuffaloModel;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HighlandBuffaloRenderer extends GeoEntityRenderer<HighlandBuffalo> {
    public HighlandBuffaloRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HighlandBuffaloModel());
    }

    @Override
    public ResourceLocation getTextureLocation(HighlandBuffalo animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/highland_buffalo.png");
    }

    @Override
    public void render(HighlandBuffalo entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}