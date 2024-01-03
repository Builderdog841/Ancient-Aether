package net.builderdog.ancient_aether.client.renderer.entity.renderer;

import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientCoreLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.AncientCoreModel;
import net.builderdog.ancient_aether.entity.monster.boss.ancient_core.AncientCore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class AncientCoreRenderer extends MobRenderer<AncientCore, AncientCoreModel<AncientCore>> {
    private static final ResourceLocation ANCIENT_GUARDIAN_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_core/ancient_core.png");

    public AncientCoreRenderer(EntityRendererProvider.Context context) {
        super(context, new AncientCoreModel<>(context.bakeLayer(AncientAetherModelLayers.ANCIENT_CORE)), 0.5F);
        addLayer(new AncientCoreLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull AncientCore ancientCore) {
        return ANCIENT_GUARDIAN_TEXTURE;
    }
}
