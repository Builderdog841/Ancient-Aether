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
        Climate.Parameter inland = Climate.Parameter.span(0.3F, 1.5F);
        Climate.Parameter coast = Climate.Parameter.span(0.2F, 0.3F);
        Climate.Parameter inlandBlended = Climate.Parameter.span(-1.5F, 0.38F);
        Climate.Parameter coastBlended = Climate.Parameter.span(0.38F, 1.5F);
        Climate.Parameter wyndcaps1 = Climate.Parameter.span(-1.5F, -0.65F);
        Climate.Parameter wyndcaps2 = Climate.Parameter.span(-0.65F, -0.575F);
        Climate.Parameter skyroot1 = Climate.Parameter.span(-0.575F, -0.5F);
        Climate.Parameter skyroot2 = Climate.Parameter.span(-0.5F, -0.25F);
        Climate.Parameter skyroot3 = Climate.Parameter.span(-0.25F, 0.25F);
        Climate.Parameter skyroot4 = Climate.Parameter.span(0.25F, 0.5F);
        Climate.Parameter skyroot5 = Climate.Parameter.span(0.5F, 0.575F);
        Climate.Parameter skyrootFullRange = Climate.Parameter.span(-0.575F, 0.575F);
        Climate.Parameter sakura = Climate.Parameter.span(0.575F, 1.5F);
        Climate.Parameter mythicalErosion1 = Climate.Parameter.span(0.45F, 1.5F);
        Climate.Parameter mythicalErosion2 = Climate.Parameter.span(0.35F, 0.45F);


        //Skyroot Biomes

        addBiome(mapper, new Climate.ParameterPoint(skyroot2, Climate.Parameter.span(-1.5F, -0.25F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_FIELDS);
        addBiome(mapper, new Climate.ParameterPoint(skyroot2, Climate.Parameter.span(-0.25F, 0.25F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(skyroot2, Climate.Parameter.span(0.25F, 1.5F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_FIELDS);

        addBiome(mapper, new Climate.ParameterPoint(skyroot3, Climate.Parameter.span(-1.5F, -0.25F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(skyroot3, Climate.Parameter.span(-0.25F, -0.05F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(skyroot3, Climate.Parameter.span(-0.05F, 0.1F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(skyroot3, Climate.Parameter.span(0.1F, 0.2F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(skyroot3, Climate.Parameter.span(0.2F, 1.5F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(skyroot4, Climate.Parameter.span(-1.5F, -0.2F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(skyroot4, Climate.Parameter.span(-0.2F, -0.1F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(skyroot4, Climate.Parameter.span(-0.1F, -0.03F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(skyroot4, Climate.Parameter.span(-0.03F, 0.17F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(skyroot4, Climate.Parameter.span(0.17F, 1.5F), inland, Climate.Parameter.span(-1.5F, 0.25F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
    }
}