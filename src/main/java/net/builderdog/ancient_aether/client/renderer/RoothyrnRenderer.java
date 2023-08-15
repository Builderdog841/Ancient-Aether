package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.RoothyrnModel;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RoothyrnRenderer extends GeoEntityRenderer<Roothyrn> {
    public RoothyrnRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RoothyrnModel());
    }
    @Override
    public ResourceLocation getTextureLocation(Roothyrn animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/roothyrn.png");
    }
    @Override
    public void render(Roothyrn entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}