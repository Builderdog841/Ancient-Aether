package net.builderdog.ancient_aether.mixin.compat;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.zepalesque.redux.data.resource.biome.registry.ReduxBiomes;
import net.zepalesque.redux.world.biome.ReduxRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

import java.util.function.Consumer;

@Pseudo
@Mixin(value = ReduxRegion.class, remap = false)
public class ReduxRegionMixin extends Region {

    public ReduxRegionMixin(ResourceLocation name, int weight) {
        super(name, AetherRegionType.THE_AETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.5F, 1.5F);

        Climate.Parameter tempWyndcaps = Climate.Parameter.span(-1.5F, -0.5F);
        Climate.Parameter tempSkyroot1 = Climate.Parameter.span(-0.5F, 0.2F);
        Climate.Parameter tempSkyroot2 = Climate.Parameter.span(-0.2F, 0.2F);
        Climate.Parameter tempSkyroot3 = Climate.Parameter.span(0.2F, 0.5F);
        Climate.Parameter tempSakura = Climate.Parameter.span(0.5F, 1.5F);

        Climate.Parameter erosionDefault = Climate.Parameter.span(0.0F, 0.5F);
        Climate.Parameter erosionSkyrootForest = Climate.Parameter.span(0.0F, 0.25F);
        Climate.Parameter erosionSunForest = Climate.Parameter.span(0.25F, 0.5F);
        Climate.Parameter erosionElevated = Climate.Parameter.span(0.5F, 1.5F);

        Climate.Parameter depthSurface = Climate.Parameter.span(-1.5F, 0.55F);
        Climate.Parameter depthUnderground = Climate.Parameter.span(0.55F, 1.5F);
        Climate.Parameter depthElevated = Climate.Parameter.span(-1.5F, 0.4F);
        Climate.Parameter depthWyndcapsRedux = Climate.Parameter.span(-0.15F, 0.55F);

        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, depthWyndcapsRedux, fullRange, 0), ReduxBiomes.GLACIAL_TUNDRA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionDefault, depthWyndcapsRedux, fullRange, 0), ReduxBiomes.FROSTED_FORESTS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, depthWyndcapsRedux, fullRange, 0), ReduxBiomes.CLOUDCAPS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-1.5F, -0.15F), fullRange, 0), AncientAetherBiomes.WYNDCAP_PEAKS);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-1.5F, -0.2F), fullRange, erosionDefault, depthSurface, fullRange, 0), AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-0.2F, 0.1F), fullRange, erosionDefault, depthSurface, fullRange, 0), ReduxBiomes.SKYROOT_SHRUBLANDS);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(0.1F, 1.5F), fullRange, erosionSkyrootForest, depthSurface, fullRange, 0), AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(0.1F, 1.5F), fullRange, erosionSunForest, depthSurface, fullRange, 0), ReduxBiomes.GILDED_GROVES);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-1.5F, -0.1F), fullRange, erosionSkyrootForest, depthSurface, fullRange, 0), AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-1.5F, -0.1F), fullRange, erosionSunForest, depthSurface, fullRange, 0), ReduxBiomes.GILDED_GRASSLANDS);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-0.1F, 0.25F), fullRange, erosionDefault, depthSurface, fullRange, 0), ReduxBiomes.SKYFIELDS);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, depthSurface, fullRange, 0), ReduxBiomes.SKYROOT_SHRUBLANDS);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, depthSurface, fullRange, 0), ReduxBiomes.SKYROOT_SHRUBLANDS);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-0.25F, -0.05F), fullRange, erosionDefault, depthSurface, fullRange, 0), AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-0.05F, 0.2F), fullRange, erosionSkyrootForest, depthSurface, fullRange, 0), AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-0.05F, 0.2F), fullRange, erosionSunForest, depthSurface, fullRange, 0), ReduxBiomes.GILDED_GROVES);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(0.2F, 1.5F), fullRange, erosionDefault, depthSurface, fullRange, 0), ReduxBiomes.SKYFIELDS);

        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, fullRange, 0), AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(-0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0), ReduxBiomes.THE_BLIGHT);

        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionElevated, depthElevated, fullRange, 0), AncientAetherBiomes.ELEVATED_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionElevated, depthElevated, fullRange, 0), AncientAetherBiomes.ELEVATED_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionElevated, depthElevated, fullRange, 0), AncientAetherBiomes.ELEVATED_CLEARING);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.5F, 0.5F), fullRange, fullRange, erosionDefault, depthUnderground, fullRange, 0), AncientAetherBiomes.HOLYSTONE_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, fullRange, erosionElevated, Climate.Parameter.span(0.4F, 1.5F), fullRange, 0), AncientAetherBiomes.ELEVATED_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, depthUnderground, fullRange, 0), AncientAetherBiomes.FROZEN_CAVERNS);

        /*
        [Unimplemented]
        Climate.Parameter tempAtmosine = Climate.Parameter.span(-1.5F, 0.5F);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, 0.15F), fullRange, erosionDefault, depthUnderground, fullRange, 0), AncientAetherBiomes.HOLYSTONE_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-1.5F, 0.075F), fullRange, erosionElevated, Climate.Parameter.span(0.4F, 1.5F), fullRange, 0), AncientAetherBiomes.ELEVATED_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, 0.15F), fullRange, erosionDefault, depthUnderground, fullRange, 0), AncientAetherBiomes.FROZEN_CAVERNS);
        addBiome(mapper, new Climate.ParameterPoint(tempAtmosine, Climate.Parameter.span(0.15F, 1.5F), fullRange, erosionDefault, depthUnderground, fullRange, 0), AncientAetherBiomes.ATMOSINE_GROTTO);
        addBiome(mapper, new Climate.ParameterPoint(tempAtmosine, Climate.Parameter.span(0.075F, 1.5F), fullRange, erosionElevated, Climate.Parameter.span(0.4F, 1.5F), fullRange, 0), AncientAetherBiomes.ATMOSINE_GROTTO);
         */
    }
}