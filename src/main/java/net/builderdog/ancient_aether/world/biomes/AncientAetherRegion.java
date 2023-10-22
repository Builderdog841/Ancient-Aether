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

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1F, -0.5F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.5F, -0.375F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-1F, -0.35F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(0.35F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.35F, 0.35F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.5F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.5F, 1F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
    }
}