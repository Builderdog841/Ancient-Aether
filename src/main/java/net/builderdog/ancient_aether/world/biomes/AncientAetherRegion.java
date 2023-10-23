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

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(-1.5F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(-0.6F, -0.35F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(-0.35F, 0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(0.6F, 0.85F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(0.85F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(-0.6F, -0.35F), fullRange, Climate.Parameter.span(0.4F, 1.5F), fullRange, fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-1.5F, -0.5F), Climate.Parameter.span(0.6F, 0.85F), fullRange, Climate.Parameter.span(0.4F, 1.5F), fullRange, fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.5F, -0.465F), Climate.Parameter.span(-1.5F, 0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_JUNGLE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.5F, -0.465F), Climate.Parameter.span(0.6F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(-1.5F, -0.7F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(-0.7F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(-0.6F, -0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(-0.3F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(-0.1F, 0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.1F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.3F, 0.45F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.45F, 0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.6F, 0.75F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.75F, 0.9F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.9F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.465F, -0.375F), Climate.Parameter.span(0.6F, 0.9F), fullRange, Climate.Parameter.span(0.4F, 1.5F), fullRange, fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-1.5F, -0.9F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.9F, -0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.8F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.6F, -0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.5F, -0.45F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.45F, -0.3F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.3F, -0.25F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.25F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(-0.1F, 0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(0.1F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(0.3F, 0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(0.5F, 0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(0.8F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-1.5F, -0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.8F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.6F, -0.45F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.45F, -0.4F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.4F, -0.25F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.25F, -0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_CLEARING);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.2F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.MYTHICAL_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(-0.1F, 0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(0.2F, 0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(0.4F, 0.65F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.25F, 0.25F), Climate.Parameter.span(0.65F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(-0.375F, 0.25F), Climate.Parameter.span(-0.45F, -0.25F), fullRange, Climate.Parameter.span(0.4F, 1.5F), fullRange, fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(-1.5F, -0.7F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(-0.7F, -0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(-0.4F, -0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(-0.3F, -0.15F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(-0.15F, 0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(0.2F, 0.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(0.5F, 0.8F), fullRange, Climate.Parameter.span(-1.5F, 0.4F), fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(0.8F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.25F, 0.375F), Climate.Parameter.span(0.5F, 0.8F), fullRange, Climate.Parameter.span(0.4F, 1.5F), fullRange, fullRange, 0),
                AncientAetherBiomes.CRYSTAL_HOLLOWS);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(-1.5F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(-0.6F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(-0.1F, 0.2F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(0.2F, 0.4F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(0.4F, 0.7F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.375F, 0.475F), Climate.Parameter.span(0.7F, 1.5F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.475F, 0.5F), fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.COLD_SKYROOT_FOREST);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.5F, 0.6F), fullRange, fullRange, fullRange, Climate.Parameter.span(-0.75F, 1.5F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.6F, 1.5F), Climate.Parameter.span(-1.5F, 0.2F), fullRange, fullRange, Climate.Parameter.span(-0.8F, 1.5F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.6F, 1.5F), Climate.Parameter.span(0.2F, 1.5F), fullRange, fullRange, Climate.Parameter.span(-0.8F, 1.5F), fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);

        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.5F, 1.5F), fullRange, fullRange, fullRange, Climate.Parameter.span(-1.1F, -0.8F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(Climate.Parameter.span(0.5F, 1.5F), fullRange, fullRange, fullRange, Climate.Parameter.span(-1.5F, -1.1F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);
    }
}