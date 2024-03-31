package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.SlammrootModel;
import net.builderdog.ancient_aether.entity.monster.Slammroot;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class SlammrootRenderer extends MobRenderer<Slammroot, SlammrootModel<Slammroot>> {
    private static final ResourceLocation SLAMMROOT_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/mobs/slammroot/slammroot.png");

    public SlammrootRenderer(EntityRendererProvider.Context context) {
        super(context, new SlammrootModel<>(context.bakeLayer(AncientAetherModelLayers.SLAMMROOT)), 0.3F);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull Slammroot slammroot) {
        return SLAMMROOT_TEXTURE;
    }
}