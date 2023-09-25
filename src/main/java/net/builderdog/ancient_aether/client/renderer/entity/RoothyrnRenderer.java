package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.RoothyrnModel;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class RoothyrnRenderer extends MobRenderer<Roothyrn, RoothyrnModel<Roothyrn>> {
    private static final ResourceLocation ROOTHYRN_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/roothyrn.png");

    public RoothyrnRenderer(EntityRendererProvider.Context context) {
        super(context, new RoothyrnModel<>(context.bakeLayer(AncientAetherModelLayers.ROOTHYRN)), 0.7F);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull Roothyrn roothyrn) {
        return ROOTHYRN_TEXTURE;
    }
}
