package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.model.AncientGuardianModel;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AncientGuardianRenderer extends GeoEntityRenderer<AncientGuardian> {
    public AncientGuardianRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AncientGuardianModel());
    }
    @Override
    public ResourceLocation getTextureLocation(AncientGuardian animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/boss/ancient_guardian.png");
    }
    @Override
    public void render(AncientGuardian entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}