package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.entity.projectile.MutatedAechorNeedle;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class MutatedAechorNeedleRenderer extends ArrowRenderer<MutatedAechorNeedle> {
    public static final ResourceLocation MUTATED_AECHOR_NEEDLE_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/projectile/mutated_aechor_needle.png");

    public MutatedAechorNeedleRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull MutatedAechorNeedle dart) {
        return MUTATED_AECHOR_NEEDLE_TEXTURE;
    }
}