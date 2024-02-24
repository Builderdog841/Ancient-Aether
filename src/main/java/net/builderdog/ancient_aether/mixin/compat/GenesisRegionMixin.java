package net.builderdog.ancient_aether.mixin.compat;

import com.aetherteam.aether_genesis.data.resources.registries.GenesisBiomes;
import com.aetherteam.aether_genesis.world.GenesisRegion;
import com.mojang.datafixers.util.Pair;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

import java.util.function.Consumer;

@Pseudo
@Mixin(value = GenesisRegion.class, remap = false)
public class GenesisRegionMixin extends Region {

    public GenesisRegionMixin(ResourceLocation name, int weight) {
        super(name, AetherRegionType.THE_AETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.5F, 1.5F);

        Climate.Parameter tempWyndcaps = Climate.Parameter.span(-1.5F, -0.5F);
        Climate.Parameter tempSkyroot = Climate.Parameter.span(-0.5F, 0.5F);
        Climate.Parameter tempSakura = Climate.Parameter.span(0.5F, 1.5F);
        Climate.Parameter tempAtmosine = Climate.Parameter.span(-1.5F, 0.5F);

        Climate.Parameter continentDefault = Climate.Parameter.span(-1.5F, 0.3F);
        Climate.Parameter continentAtmosine = Climate.Parameter.span(0.3F, 1.5F);

        Climate.Parameter erosionDefault = Climate.Parameter.span(0F, 0.5F);
        Climate.Parameter erosionElevated = Climate.Parameter.span(0.5F, 1.5F);

        Climate.Parameter depthSurface = Climate.Parameter.span(-1.5F, 0.55F);
        Climate.Parameter depthUnderground = Climate.Parameter.span(0.55F, 1.5F);
        Climate.Parameter depthElevated = Climate.Parameter.span(-1.5F, 0.4F);

        Climate.Parameter forestDistWooded1 = Climate.Parameter.span(-1.5F, 0.1F);
        Climate.Parameter forestDistWooded2 = Climate.Parameter.span( 0.5F, 1.5F);
        Climate.Parameter forestDistBarren = Climate.Parameter.span(0.1F, 0.5F);

        //Wyndcaps
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, 0.25F), continentDefault, erosionDefault, Climate.Parameter.span(0.05F, 0.55F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(0.25F, 1.5F), continentDefault, erosionDefault, Climate.Parameter.span(0.05F, 0.55F), fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, continentDefault, erosionDefault, Climate.Parameter.span(-0.15F, 0.05F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, continentDefault, erosionDefault, Climate.Parameter.span(-1.5F, -0.15F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);

        //Skyroot Forests
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.2F), continentDefault, erosionDefault, depthSurface, forestDistWooded1, 0),
                GenesisBiomes.VIBRANT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.2F, 0.0F), continentDefault, erosionDefault, depthSurface, forestDistWooded1, 0),
                GenesisBiomes.VIBRANT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.0F, 1.5F), continentDefault, erosionDefault, depthSurface, forestDistWooded1, 0),
                GenesisBiomes.VIBRANT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.5F), continentDefault, erosionDefault, depthSurface, forestDistBarren, 0),
                GenesisBiomes.VIBRANT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.5F, -0.1F), continentDefault, erosionDefault, depthSurface, forestDistBarren, 0),
                GenesisBiomes.VIBRANT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.1F,  0.3F), continentDefault, erosionDefault, depthSurface, forestDistBarren, 0),
                GenesisBiomes.VIBRANT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.3F,  1.5F), continentDefault, erosionDefault, depthSurface, forestDistBarren, 0),
                GenesisBiomes.VIBRANT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F,  0.0F), continentDefault, erosionDefault, depthSurface, forestDistWooded2, 0),
                GenesisBiomes.VIBRANT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.0F,  1.5F), continentDefault, erosionDefault, depthSurface, forestDistWooded2, 0),
                GenesisBiomes.VIBRANT_WOODLAND);

        //Sakura Jungle
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);

        //Elevated Islands
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionElevated, depthElevated, fullRange, 0),
                AncientAetherBiomes.ELEVATED_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionElevated, depthElevated, fullRange, 0),
                AncientAetherBiomes.ELEVATED_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionElevated, depthElevated, fullRange, 0),
                AncientAetherBiomes.ELEVATED_CLEARING);

        //Caves
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, fullRange, continentDefault, erosionDefault, depthUnderground, fullRange, 0),
                AncientAetherBiomes.HOLYSTONE_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, continentDefault, erosionElevated, Climate.Parameter.span(0.4F, 1.5F), fullRange, 0),
                AncientAetherBiomes.ELEVATED_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, continentDefault, erosionDefault, depthUnderground, fullRange, 0),
                AncientAetherBiomes.FROZEN_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempAtmosine, fullRange, continentAtmosine, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.ATMOSINE_GROTTO);
    }
}