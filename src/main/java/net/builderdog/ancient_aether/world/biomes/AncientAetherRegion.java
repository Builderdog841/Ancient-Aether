package net.builderdog.ancient_aether.world.biomes;

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
        Climate.Parameter fullRange = Climate.Parameter.span(-1.0F, 1.0F);

        //SAKURA JUNGLE
        Climate.Parameter temps1 = Climate.Parameter.span(-1F, 0F);

        //QUICKSOIL DESERT
        Climate.Parameter temps2 = Climate.Parameter.span(0.5F, 1F);

        this.addBiome(mapper, new Climate.ParameterPoint(temps1, Climate.Parameter.span(-1F, -0.45F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        this.addBiome(mapper, new Climate.ParameterPoint(temps2, Climate.Parameter.span(0.6F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.QUICKSOIL_DESERT);

        this.addBiome(mapper, new Climate.ParameterPoint(temps1, Climate.Parameter.span(-0.45F, -0.1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);
    }
}