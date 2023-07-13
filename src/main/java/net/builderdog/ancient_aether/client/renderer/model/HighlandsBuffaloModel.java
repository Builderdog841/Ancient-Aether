package net.builderdog.ancient_aether.client.renderer.model;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.custom.animals.HighlandsBuffaloEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HighlandsBuffaloModel extends GeoModel<HighlandsBuffaloEntity> {
    @Override
    public ResourceLocation getModelResource(HighlandsBuffaloEntity animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "geo/highlands_buffalo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HighlandsBuffaloEntity animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "textures/entity/highlands_buffalo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HighlandsBuffaloEntity animatable) {
        return new ResourceLocation(AncientAether.MOD_ID, "animations/highlands_buffalo.animation.json");
    }

    @Override
    public void setCustomAnimations(HighlandsBuffaloEntity animatable, long instanceId, AnimationState<HighlandsBuffaloEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}