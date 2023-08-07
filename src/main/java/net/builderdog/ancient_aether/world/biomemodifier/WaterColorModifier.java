package net.builderdog.ancient_aether.world.biomemodifier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record WaterColorModifier(HolderSet<Biome> biomes, int water, int fog) implements BiomeModifier {

    //Credit for this code goes to Zepalesque
    public WaterColorModifier(HolderSet<Biome> biomes, int water, int fog) {
        this.biomes = biomes;
        this.water = water;
        this.fog = fog;
    }

    public void modify(Holder<Biome> biome, BiomeModifier.Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.AFTER_EVERYTHING && this.biomes.contains(biome)) {
            builder.getSpecialEffects().waterColor(this.water).waterFogColor(this.fog);
        }

    }

    public Codec<? extends BiomeModifier> codec() {
        return null;
    }

    public HolderSet<Biome> biomes() {
        return this.biomes;
    }

    public int water() {
        return this.water;
    }

    public int fog() {
        return this.fog;
    }
}