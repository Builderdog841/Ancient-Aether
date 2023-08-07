package net.builderdog.ancient_aether.world.biomes;

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

        //SAKURA JUNGLE
        Climate.Parameter temps1 = Climate.Parameter.span(0.6F, 0.94F);

        //SPARSE_SAKURA JUNGLE
        Climate.Parameter temps2 = Climate.Parameter.span(0.5F, 0.6F);
        Climate.Parameter temps3 = Climate.Parameter.span(0.94F, 1F);

        //QUICKSOIL DESERT
        Climate.Parameter temps4 = Climate.Parameter.span(-0.8F, -0.3F);

        //GILDED QUICKSOIL DESERT
        Climate.Parameter temps5 = Climate.Parameter.span(-0.8F, -0.4F);

        //HIGHLANDS TAIGA
        Climate.Parameter temps6 = Climate.Parameter.span(0.2F, 0.5F);

        this.addBiome(mapper, new Climate.ParameterPoint(temps1, Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        this.addBiome(mapper, new Climate.ParameterPoint(temps2, Climate.Parameter.span(-1F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SPARSE_SAKURA_JUNGLE);

        this.addBiome(mapper, new Climate.ParameterPoint(temps3, Climate.Parameter.span(-1F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SPARSE_SAKURA_JUNGLE);

        this.addBiome(mapper, new Climate.ParameterPoint(temps4, Climate.Parameter.span(-1F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.QUICKSOIL_DESERT);

        this.addBiome(mapper, new Climate.ParameterPoint(temps5, Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.GILDED_QUICKSOIL_DESERT);

        this.addBiome(mapper, new Climate.ParameterPoint(temps6, Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);
    }
}