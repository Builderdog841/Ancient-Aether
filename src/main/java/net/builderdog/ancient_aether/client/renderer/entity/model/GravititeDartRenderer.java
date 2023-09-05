package net.builderdog.ancient_aether.client.renderer.entity.model;

import net.builderdog.ancient_aether.entity.misc.GravititeDart;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class GravititeDartRenderer extends ArrowRenderer<GravititeDart> {
    public static final ResourceLocation GRAVITITE_DART_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/projectile/gravitite_dart.png");

    public GravititeDartRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull GravititeDart dart) {
        return GRAVITITE_DART_TEXTURE;
    }
}
