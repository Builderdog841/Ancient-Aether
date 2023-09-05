package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.HighlandBuffaloModel;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class HighlandBuffaloRenderer extends MobRenderer<HighlandBuffalo, HighlandBuffaloModel<HighlandBuffalo>> {
    private static final ResourceLocation HIGHLAND_BUFFALO_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/highland_buffalo.png");

    public HighlandBuffaloRenderer(EntityRendererProvider.Context context) {
        super(context, new HighlandBuffaloModel(context.bakeLayer(AncientAetherModelLayers.HIGHLAND_BUFFALO)), 0.7F);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull HighlandBuffalo buffalo) {
        return HIGHLAND_BUFFALO_TEXTURE;
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
