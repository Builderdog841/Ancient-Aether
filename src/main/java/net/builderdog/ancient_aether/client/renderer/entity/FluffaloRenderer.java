package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.FluffaloModel;
import net.builderdog.ancient_aether.entity.passive.Fluffalo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class FluffaloRenderer extends MobRenderer<Fluffalo, FluffaloModel<Fluffalo>> {
    private static final ResourceLocation FLUFFALO_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/mob/fluffalo/fluffalo.png");
    private static final ResourceLocation FLUFFALO_SHEARED_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/mob/fluffalo/fluffalo_sheared.png");

    public FluffaloRenderer(EntityRendererProvider.Context context) {
        super(context, new FluffaloModel<>(context.bakeLayer(AncientAetherModelLayers.FLUFFALO)), 0.7F);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull Fluffalo fluffalo) {
        return fluffalo.isSheared() ? FLUFFALO_SHEARED_TEXTURE : FLUFFALO_TEXTURE;
    }
    @Override
    public void render(Fluffalo fluffalo, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        if(fluffalo.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(fluffalo, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}