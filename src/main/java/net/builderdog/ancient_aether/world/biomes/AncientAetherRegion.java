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

        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-1.5F, -0.5F), fullRange, Climate.Parameter.span(-1.5F, 1.1F), Climate.Parameter.span(1F, 1F), 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-1.5F, -0.5F), fullRange, Climate.Parameter.span(1.1F, 1.35F), Climate.Parameter.span(1F, 1F), 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-1.5F, -0.5F), fullRange, Climate.Parameter.span(1.35F, 1.5F), Climate.Parameter.span(1F, 1F), 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);

        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-0.5F, 0.5F), fullRange, fullRange, Climate.Parameter.span(1F, 1F), 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(0.5F, 1.5F), fullRange, fullRange, Climate.Parameter.span(1F, 1F), 0),
                AncientAetherBiomes.SAKURA_JUNGLE);


        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-1.5F, -0.5F), fullRange, fullRange, Climate.Parameter.span(5F, 5F), 0),
                AncientAetherBiomes.CLOUD_OCEAN);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-0.5F, 0.5F), fullRange, fullRange, Climate.Parameter.span(5F, 5F), 0),
                AncientAetherBiomes.CLOUD_OCEAN);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(0.5F, 1.5F), fullRange, fullRange, Climate.Parameter.span(5F, 5F), 0),
                AncientAetherBiomes.CLOUD_OCEAN);
    }
}