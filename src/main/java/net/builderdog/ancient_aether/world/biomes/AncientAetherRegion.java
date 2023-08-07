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

        //HIGHLAND TAIGA
        Climate.Parameter tempTaiga1 = Climate.Parameter.span(0.6F, 1F);
        Climate.Parameter tempTaiga2 = Climate.Parameter.span(0.4F, 0.6F);


        this.addBiome(mapper, new Climate.ParameterPoint(tempTaiga1, Climate.Parameter.span(-1F, 0F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);
        this.addBiome(mapper, new Climate.ParameterPoint(tempTaiga2, Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.HIGHLAND_TAIGA);

        this.addBiome(mapper, new Climate.ParameterPoint(tempTaiga1, Climate.Parameter.span(0F, 1F), fullRange, fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.FESTIVE_HIGHLAND_TAIGA);
    }
}