package net.builderdog.ancient_aether.world.biomemodifier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.common.world.BiomeModifier.Phase;

public record CarverModifier(HolderSet<Biome> biomes, Holder<ConfiguredWorldCarver<?>> carver) implements BiomeModifier {

    //Credit for this code goes to Zepalesque
    public CarverModifier(HolderSet<Biome> biomes, Holder<ConfiguredWorldCarver<?>> carver) {
        this.biomes = biomes;
        this.carver = carver;
    }

    public void modify(Holder<Biome> biome, BiomeModifier.Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.AFTER_EVERYTHING && this.biomes.contains(biome)) {
            builder.getGenerationSettings().addCarver(Carving.AIR, this.carver);
        }

    }

    public Codec<? extends BiomeModifier> codec() {
        return null;
    }

    public HolderSet<Biome> biomes() {
        return this.biomes;
    }

    public Holder<ConfiguredWorldCarver<?>> carver() {
        return this.carver;
    }
}