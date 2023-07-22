package net.builderdog.ancient_aether.client.renderer.model;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.monster.Rootling;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RootlingModel extends GeoModel<Rootling> {
    @Override
    public ResourceLocation getModelResource(Rootling animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "geo/rootling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Rootling animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/rootling.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Rootling animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "animations/rootling.animation.json");
    }
}