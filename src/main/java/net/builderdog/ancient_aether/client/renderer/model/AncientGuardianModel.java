package net.builderdog.ancient_aether.client.renderer.model;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AncientGuardianModel extends GeoModel<AncientGuardian> {
    @Override
    public ResourceLocation getModelResource(AncientGuardian animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "geo/ancient_guardian.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AncientGuardian animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/ancient_guardian.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AncientGuardian animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "animations/roothyrn.animation.json");
    }
}