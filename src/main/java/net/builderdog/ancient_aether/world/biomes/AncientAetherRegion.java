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
        Climate.Parameter fullRange = Climate.Parameter.span(-1.0F, 1.0F);

        Climate.Parameter tempDefault1 = Climate.Parameter.span(-1.0F, -0.8F);
        Climate.Parameter tempDefault2 = Climate.Parameter.span(-0.4F, 0.35F);
        Climate.Parameter tempDefault3 = Climate.Parameter.span(0.93F, 0.94F);
        Climate.Parameter tempDefault4 = Climate.Parameter.span(0.94F, 1.0F);

        Climate.Parameter tempSakura1 = Climate.Parameter.span(-0.7F, -0.3F);
        Climate.Parameter tempSakura2 = Climate.Parameter.span(-0.325F, -0.2F);
        Climate.Parameter tempSakura3 = Climate.Parameter.span(-0.65F, -0.325F);
        Climate.Parameter tempSakura4 = Climate.Parameter.span(-0.8F, -0.65F);

        Climate.Parameter tempWyndcaps1 = Climate.Parameter.span(0.35F, 0.5F);
        Climate.Parameter tempWyndcaps2 = Climate.Parameter.span(0.5F, 0.8F);
        Climate.Parameter tempWyndcaps3 = Climate.Parameter.span(0.8F, 0.93F);
        Climate.Parameter tempWyndcaps4 = Climate.Parameter.span(0.35F, 0.93F);

        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(0.3F, 0.8F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(-0.3F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(0.8F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(tempDefault1, Climate.Parameter.span(0.0F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault1, fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(-1.0F, 0.0F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault4, Climate.Parameter.span(-1.0F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(-1.0F, 0.0F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(0.8F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(-0.6F, -0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);

        addBiome(mapper, new Climate.ParameterPoint(tempDefault4, Climate.Parameter.span(-0.1F, 0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps1, Climate.Parameter.span(-1.0F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-0.35F, 1.0F), fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps2, Climate.Parameter.span(-1.0F, 0.2F), fullRange, fullRange, Climate.Parameter.span(-0.35F, 1.0F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps2, Climate.Parameter.span(0.2F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-0.35F, 1.0F), fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps4, Climate.Parameter.span(-1.0F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-0.6F, -0.35F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps4, Climate.Parameter.span(-1.0F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-1.5F, -0.6F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps3, Climate.Parameter.span(-1.0F, 1.0F), fullRange, fullRange, Climate.Parameter.span(-0.35F, 1.0F), fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(0.0F, 0.3F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.3F), fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(tempSakura1, Climate.Parameter.span(-1.0F, 0.5F), fullRange, fullRange, Climate.Parameter.span(0.2F, 1.0F), fullRange, 0),
                AncientAetherBiomes.OVERGROWN_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura2, Climate.Parameter.span(-1.0F, 0.5F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.2F), fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura3, Climate.Parameter.span(-1.0F, 0.5F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.2F), fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura4, Climate.Parameter.span(-1.0F, 0.5F), fullRange, fullRange, Climate.Parameter.span(-1.0F, 0.2F), fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(0.0F, 0.8F), fullRange, fullRange, Climate.Parameter.span(0.3F, 1.0F), fullRange, 0),
                AncientAetherBiomes.AEROGEL_CAVES);
    }
}