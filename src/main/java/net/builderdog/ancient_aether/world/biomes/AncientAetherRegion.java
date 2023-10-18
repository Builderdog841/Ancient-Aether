package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

import java.util.function.Consumer;


public class AncientAetherRegion extends Region {

    public AncientAetherRegion(ResourceLocation name, int weight)
    {
        super(name, AetherRegionType.THE_AETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.5F, 1.5F);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(-1F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(-0.6F, -0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(-0.2F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(0.3F, 0.45F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(0.45F, 0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.4F, -0.1F), Climate.Parameter.span(0.6F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(-1F, -0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(-0.5F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.3F, 0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.4F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(-1F, -0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(-0.5F, -0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(-0.4F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(-0.1F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(0F,  0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(0.3F,  0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.ENCHANTED_MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.1F, 0.35F), Climate.Parameter.span(0.8F,  1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.35F, 0.5F), Climate.Parameter.span(-1F,  -0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.35F, 0.5F), Climate.Parameter.span(-0.2F,  1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.5F, 0.575F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.COLD_SKYROOT_FOREST);
    }
}