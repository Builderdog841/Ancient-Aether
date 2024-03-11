package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.entity.projectile.AeronauticDart;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class AeronauticDartRenderer extends ArrowRenderer<AeronauticDart> {
    public static final ResourceLocation AERONAUTIC_DART_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/projectile/aeronautic_dart.png");

    public AeronauticDartRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull AeronauticDart dart) {
        return AERONAUTIC_DART_TEXTURE;
    }
}