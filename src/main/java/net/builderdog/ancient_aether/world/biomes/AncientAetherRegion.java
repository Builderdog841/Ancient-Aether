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

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.525F, 1F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.45F, 0.525F), Climate.Parameter.span(-1.0F, -0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                    AncientAetherBiomes.SKYROOT_PINE_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.45F, 0.525F), Climate.Parameter.span(-0.5F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(-1F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(-0.6F, -0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(-0.4F, 0.0F), fullRange, fullRange, Climate.Parameter.span(-1.5F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(0F, 0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(0.2F, 0.75F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(0.75F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.15F), Climate.Parameter.span(-1F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.15F), Climate.Parameter.span(-0.6F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.15F), Climate.Parameter.span(0.3F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.35F, -0.25F), Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.35F, -0.25F), Climate.Parameter.span(-0.3F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.35F, -0.25F), Climate.Parameter.span(-0.55F, -0.3F), fullRange, fullRange, Climate.Parameter.span(-1.5F, 0.3F), fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.35F, -0.25F), Climate.Parameter.span(-1F, -0.55F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_PINE_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.45F, -0.35F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.COLD_SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.6F, -0.45F), fullRange, fullRange, Climate.Parameter.span(-0.65F, 1.0F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.75F, -0.6F), fullRange, fullRange, Climate.Parameter.span(-0.65F, 1.0F), fullRange, fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1F, -0.75F), fullRange, fullRange, Climate.Parameter.span(-0.65F, 1.0F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.55F, -0.45F), fullRange, fullRange, Climate.Parameter.span(-0.7F, -0.65F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.F, -0.55F), fullRange, fullRange, Climate.Parameter.span(-0.7F, -0.65F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.55F, -0.45F), fullRange, fullRange, Climate.Parameter.span(-1F, -0.7F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1F, -0.55F), fullRange, fullRange, Climate.Parameter.span(-1F, -0.7F), fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.15F), Climate.Parameter.span(-0.6F, 0.3F), fullRange, fullRange, Climate.Parameter.span(0.3F, 1.5F), fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.15F, 0.45F), Climate.Parameter.span(-0.4F, 0.0F), fullRange, fullRange, Climate.Parameter.span(0.3F, 1.5F), fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);
    }
}