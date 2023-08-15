package net.builderdog.ancient_aether.client.renderer.model;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RoothyrnModel extends GeoModel<Roothyrn> {
    @Override
    public ResourceLocation getModelResource(Roothyrn animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "geo/roothyrn.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Roothyrn animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/roothyrn.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Roothyrn animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "animations/roothyrn.animation.json");
    }
}