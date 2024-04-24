package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.MutatedAechorPlantEmissiveLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.MutatedAechorPlantModel;
import net.builderdog.ancient_aether.entity.monster.boss.MutatedAechorPlant;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class MutatedAechorPlantRenderer extends MobRenderer<MutatedAechorPlant, MutatedAechorPlantModel> {
    private static final ResourceLocation MUTATED_AECHOR_PLANT_TEXTURE = new ResourceLocation(AncientAether.MODID, "textures/entity/mobs/mutated_aechor_plant/mutated_aechor_plant.png");

    public MutatedAechorPlantRenderer(EntityRendererProvider.Context context) {
        super(context, new MutatedAechorPlantModel(context.bakeLayer(AncientAetherModelLayers.MUTATED_AECHOR_PLANT)), 0.3F);
        addLayer(new MutatedAechorPlantEmissiveLayer(this));
    }

    @Override
    protected void scale(@NotNull MutatedAechorPlant mutatedAechorPlant, PoseStack poseStack, float partialTicks) {
        float f2 = size(mutatedAechorPlant) + mutatedAechorPlant.getSize() / 6.0F;
        poseStack.scale(f2, f2, f2);
        poseStack.translate(0.0, 1.2, 0.0);
        shadowRadius = f2 - size(mutatedAechorPlant);
    }

    @Override
    protected float getBob(MutatedAechorPlant mutatedAechorPlant, float partialTicks) {
        return Mth.lerp(partialTicks, mutatedAechorPlant.getSinage(), mutatedAechorPlant.getSinage() + mutatedAechorPlant.getSinageAdd());
    }

    private float size(MutatedAechorPlant mutatedAechorPlant) {
        if (mutatedAechorPlant.getHealth() < 250) {
            return 7.5F;
        }
        return 5.0F;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MutatedAechorPlant mutatedAechorPlant) {
        return MUTATED_AECHOR_PLANT_TEXTURE;
    }
}