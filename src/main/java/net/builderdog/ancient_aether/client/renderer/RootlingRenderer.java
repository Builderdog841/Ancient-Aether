package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.RootlingModel;
import net.builderdog.ancient_aether.entity.monster.Rootling;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RootlingRenderer extends GeoEntityRenderer<Rootling> {
    public RootlingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RootlingModel());
    }
    @Override
    public ResourceLocation getTextureLocation(Rootling animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/rootling.png");
    }
    @Override
    public void render(Rootling entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}