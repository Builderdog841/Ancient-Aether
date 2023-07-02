package net.builderdog.aether_crystallium.world.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

import java.util.function.Consumer;


public class ModRegion extends Region {

    public ModRegion(ResourceLocation name, int weight)
    {
        super(name, AetherRegionType.THE_AETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.0F, 1.0F);

        //ENCHANTED WOODS
        Climate.Parameter temps1 = Climate.Parameter.span(0.7F, 0.93F);

        //QUICKSOIL DESERT
        Climate.Parameter temps2 = Climate.Parameter.span(-1.0F, -0.65F);

        //HIGHLANDS TAIGA
        Climate.Parameter temps3 = Climate.Parameter.span(0F, 0.4F);

        //HIGHFIELDS
        Climate.Parameter temps4 = Climate.Parameter.span(0.4F, 0.93F);


        this.addBiome(mapper, new Climate.ParameterPoint(temps1, Climate.Parameter.span(0.0F, 1.0F), fullRange, fullRange, fullRange, fullRange, 0),
                ModBiomes.ENCHANTED_WOODS);

        this.addBiome(mapper, new Climate.ParameterPoint(temps2, Climate.Parameter.span(-1.0F, 0.0F), fullRange, fullRange, fullRange, fullRange, 0),
                ModBiomes.QUICKSOIL_DESERT);

        this.addBiome(mapper, new Climate.ParameterPoint(temps3, Climate.Parameter.span(-1.0F, 0.3F), fullRange, fullRange, fullRange, fullRange, 0),
                ModBiomes.HIGHLANDS_TAIGA);

        this.addBiome(mapper, new Climate.ParameterPoint(temps4, Climate.Parameter.span(0.3F, 0.8F), fullRange, fullRange, fullRange, fullRange, 0),
                ModBiomes.HIGHFIELDS);
    }
}