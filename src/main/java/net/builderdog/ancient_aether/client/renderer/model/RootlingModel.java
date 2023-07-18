package net.builderdog.ancient_aether.client.renderer.model;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.animals.HighlandsBuffalo;
import net.builderdog.ancient_aether.entity.mobs.Rootling;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

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