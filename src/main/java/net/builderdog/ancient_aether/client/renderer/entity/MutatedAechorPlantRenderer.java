package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.AncientModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.MutatedAechorPlantEmissiveLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.MutatedAechorPlantModel;
import net.builderdog.ancient_aether.entity.monster.boss.MutatedAechorPlant;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class MutatedAechorPlantRenderer extends MobRenderer<MutatedAechorPlant, MutatedAechorPlantModel> {
    private static final ResourceLocation MUTATED_AECHOR_PLANT_TEXTURE = new ResourceLocation(AncientAether.MODID, "textures/entity/mob/mutated_aechor_plant/mutated_aechor_plant.png");

    public MutatedAechorPlantRenderer(EntityRendererProvider.Context context) {
        super(context, new MutatedAechorPlantModel(context.bakeLayer(AncientModelLayers.MUTATED_AECHOR_PLANT)), 0.3F);
        addLayer(new MutatedAechorPlantEmissiveLayer(this));
    }

    @Override
    protected void scale(@NotNull MutatedAechorPlant aechor, PoseStack poseStack, float partialTicks) {
        float f2 = size(aechor) + aechor.getSize() / 6.0F;
        poseStack.scale(f2, f2, f2);
        poseStack.translate(0.0, 1.2, 0.0);
        shadowRadius = f2 - size(aechor);
    }

    @Override
    protected float getBob(MutatedAechorPlant aechor, float partialTicks) {
        return Mth.lerp(partialTicks, aechor.getSinage(), aechor.getSinage() + aechor.getSinageAdd());
    }

    private float size(MutatedAechorPlant aechor) {
        return aechor.isCritical() ? 7.5F : 5.0F;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MutatedAechorPlant mutatedAechorPlant) {
        return MUTATED_AECHOR_PLANT_TEXTURE;
    }
}