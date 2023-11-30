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
        Climate.Parameter tempWyndcaps = Climate.Parameter.span(-1.5F, -0.5F);
        Climate.Parameter tempSkyroot1 = Climate.Parameter.span(-0.5F, -0.25F);
        Climate.Parameter tempSkyroot2 = Climate.Parameter.span(-0.25F, 0.25F);
        Climate.Parameter tempSkyroot3 = Climate.Parameter.span(0.25F, 0.5F);
        Climate.Parameter tempElevated = Climate.Parameter.span(-0.5F, 0.5F);
        Climate.Parameter tempSakura = Climate.Parameter.span(0.5F, 1.5F);
        Climate.Parameter erosionDefault = Climate.Parameter.span(-1.5F, 0.5F);
        Climate.Parameter erosionElevated = Climate.Parameter.span(0.5F, 1.5F);


        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, Climate.Parameter.span(0F, 1.5F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, Climate.Parameter.span(0F, 1.5F), fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-0.2F, 0F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-1.5F, -0.2F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-1.5F, -0.3F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-0.3F, -0.15F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-0.15F, 0F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(0F, 0.2F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(0.2F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_GRASSLAND);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-1.5F, -0.1F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-0.1F, 0F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span( 0F, 0.15F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(0.15F, 0.22F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(0.22F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_GRASSLAND);

        addBiome(mapper, new Climate.ParameterPoint(tempElevated, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomes.ELEVATED_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(tempElevated, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomes.ELEVATED_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempElevated, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomes.ELEVATED_CLEARING);

        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);
    }
}