package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.ParameterUtils;
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
        Climate.Parameter tempDefault2 = Climate.Parameter.span(-0.8F, -0.4F);
        Climate.Parameter tempDefault3 = Climate.Parameter.span(0.0F, 0.35F);
        Climate.Parameter tempDefault4 = Climate.Parameter.span(0.4F, 0.93F);
        Climate.Parameter tempDefault5 = Climate.Parameter.span(0.93F, 0.94F);
        Climate.Parameter tempDefault6 = Climate.Parameter.span(0.94F, 1.0F);

        Climate.Parameter tempSakura1 = Climate.Parameter.span(0.15F, 0.2F); //Sparse Sakura Jungle
        Climate.Parameter tempSakura2 = Climate.Parameter.span(-0.15F, -0.075F); //Sakura Jungle
        Climate.Parameter tempSakura3 = Climate.Parameter.span(-0.075F, 0.075F); //Deep Sakura Jungle
        Climate.Parameter tempSakura4 = Climate.Parameter.span(0.075F, 0.15F); //Sakura Jungle
        Climate.Parameter tempSakura5 = Climate.Parameter.span(-0.2F, -0.15F); //Sparse Sakura Jungle

        Climate.Parameter tempHighland1 = Climate.Parameter.span(-0.5F, -0.4F); //Highland Taiga
        Climate.Parameter tempHighland2 = Climate.Parameter.span(-0.6F, -0.5F); //Festive Highland Taiga
        Climate.Parameter tempHighland3 = Climate.Parameter.span(-0.8F, -0.6F); //Highland Taiga

        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault2, Climate.Parameter.span(0.0F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(0.0F, 0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault4, Climate.Parameter.span(-0.1F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.QUICKSOIL_DESERT);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault5, Climate.Parameter.span(-0.3F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault5, Climate.Parameter.span(0.8F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        this.addBiome(mapper, new Climate.ParameterPoint(tempHighland1, Climate.Parameter.span(-0.1F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);
        this.addBiome(mapper, new Climate.ParameterPoint(tempHighland2, Climate.Parameter.span(-0.1F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.FESTIVE_HIGHLAND_TAIGA);
        this.addBiome(mapper, new Climate.ParameterPoint(tempHighland3, Climate.Parameter.span(-0.1F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);

        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault1, fullRange, fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault4, Climate.Parameter.span(-1.0F, 0.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault6, Climate.Parameter.span(-1.0F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);

        this.addBiome(mapper, new Climate.ParameterPoint(tempSakura1, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SPARSE_SAKURA_JUNGLE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempSakura2, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempSakura3, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.DEEP_SAKURA_JUNGLE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempSakura4, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempSakura5, Climate.Parameter.span(-1.0F, -0.6F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SPARSE_SAKURA_JUNGLE);


        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault3, Climate.Parameter.span(0.8F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault4, Climate.Parameter.span(-1.0F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault5, Climate.Parameter.span(-0.6F, -0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);

        this.addBiome(mapper, new Climate.ParameterPoint(tempDefault6, Climate.Parameter.span(-0.1F, 0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
    }
}