package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.model.MutatedAechorPlantModel;
import net.builderdog.ancient_aether.entity.monster.boss.MutatedAechorPlant;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MutatedAechorPlantEmissiveLayer extends EyesLayer<MutatedAechorPlant, MutatedAechorPlantModel> {
    private static final RenderType MUTATED_AECHOR_PLANT_EMISSIVE = RenderType.eyes(new ResourceLocation(AncientAether.MOD_ID, "textures/entity/mobs/mutated_aechor_plant/mutated_aechor_plant_emissive.png"));

    public MutatedAechorPlantEmissiveLayer(RenderLayerParent<MutatedAechorPlant, MutatedAechorPlantModel> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public @NotNull RenderType renderType() {
        return MUTATED_AECHOR_PLANT_EMISSIVE;
    }
}