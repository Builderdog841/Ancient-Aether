package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.builderdog.ancient_aether.data.registries.AncientAetherBiomeRegistry;
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
        Climate.Parameter tempSkyroot = Climate.Parameter.span(-0.5F, 0.5F);
        Climate.Parameter tempSakura = Climate.Parameter.span(0.5F, 1.5F);

        Climate.Parameter erosionDefault = Climate.Parameter.span(-1.5F, 0.5F);
        Climate.Parameter erosionElevated = Climate.Parameter.span(0.5F, 1.5F);

        Climate.Parameter forestDistCrystal1 = Climate.Parameter.span(-1.5F, -0.4F);
        Climate.Parameter forestDistCrystal2 = Climate.Parameter.span(-0.4F, -0.3F);
        Climate.Parameter forestDistSkyroot1 = Climate.Parameter.span(-0.3F, 0.0F);
        Climate.Parameter forestDistSkyroot2 = Climate.Parameter.span(0.0F, 0.3F);
        Climate.Parameter forestDistGolden1 = Climate.Parameter.span(0.3F, 0.4F);
        Climate.Parameter forestDistGolden2 = Climate.Parameter.span(0.4F, 0.65F);
        Climate.Parameter forestDistGolden3 = Climate.Parameter.span(0.65F, 1.5F);

        //Wyndcaps
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, Climate.Parameter.span(0.05F, 1.5F), fullRange, 0),
                AncientAetherBiomeRegistry.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, Climate.Parameter.span(0.05F, 1.5F), fullRange, 0),
                AncientAetherBiomeRegistry.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-0.15F, 0.05F), fullRange, 0),
                AncientAetherBiomeRegistry.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-1.5F, -0.15F), fullRange, 0),
                AncientAetherBiomeRegistry.WYNDCAP_PEAKS);

        //Skyroot Forests
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, forestDistCrystal1, 0),
                AncientAetherBiomeRegistry.CRYSTAL_SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.25F, 0.35F), fullRange, erosionDefault, fullRange, forestDistCrystal1, 0),
                AncientAetherBiomeRegistry.CRYSTAL_SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.35F, 1.5F), fullRange, erosionDefault, fullRange, forestDistCrystal1, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.35F), fullRange, erosionDefault, fullRange, forestDistCrystal2, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.35F, 0.45F), fullRange, erosionDefault, fullRange, forestDistCrystal2, 0),
                AncientAetherBiomeRegistry.CRYSTAL_SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.45F, 1.5F), fullRange, erosionDefault, fullRange, forestDistCrystal2, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.3F), fullRange, erosionDefault, fullRange, forestDistSkyroot1, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.3F, -0.15F), fullRange, erosionDefault, fullRange, forestDistSkyroot1, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.15F, 0.3F), fullRange, erosionDefault, fullRange, forestDistSkyroot1, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.3F, 1.5F), fullRange, erosionDefault, fullRange, forestDistSkyroot1, 0),
                AetherBiomes.SKYROOT_GROVE);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.2F), fullRange, erosionDefault, fullRange, forestDistSkyroot2, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.2F, -0.15F), fullRange, erosionDefault, fullRange, forestDistSkyroot2, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.15F, 0.25F), fullRange, erosionDefault, fullRange, forestDistSkyroot2, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, forestDistSkyroot2, 0),
                AetherBiomes.SKYROOT_GROVE);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.2F), fullRange, erosionDefault, fullRange, forestDistGolden1, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.2F, 0.0F), fullRange, erosionDefault, fullRange, forestDistGolden1, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.0F, 1.5F), fullRange, erosionDefault, fullRange, forestDistGolden1, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, forestDistGolden2, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.25F, 0.35F), fullRange, erosionDefault, fullRange, forestDistGolden2, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.35F, 1.5F), fullRange, erosionDefault, fullRange, forestDistGolden2, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, forestDistGolden3, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(-0.25F, 0.0F), fullRange, erosionDefault, fullRange, forestDistGolden3, 0),
                AncientAetherBiomeRegistry.GOLDEN_SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.0F, 0.3F), fullRange, erosionDefault, fullRange, forestDistGolden3, 0),
                AncientAetherBiomeRegistry.GOLDEN_THICKET);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot, Climate.Parameter.span(0.3F, 1.5F), fullRange, erosionDefault, fullRange, forestDistGolden3, 0),
                AetherBiomes.SKYROOT_MEADOW);

        //Sakura Jungle
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomeRegistry.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(tempSakura, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomeRegistry.SKYROOT_JUNGLE);

        //Elevated Islands
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomeRegistry.ELEVATED_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomeRegistry.ELEVATED_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionElevated, fullRange, fullRange, 0),
                AncientAetherBiomeRegistry.ELEVATED_CLEARING);
    }
}