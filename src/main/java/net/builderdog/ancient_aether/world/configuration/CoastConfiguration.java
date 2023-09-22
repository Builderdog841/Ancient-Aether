package net.builderdog.ancient_aether.world.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CoastConfiguration(BlockStateProvider block, FloatProvider radius, UniformInt yRange, HolderSet<Block> validBlocks) implements FeatureConfiguration {
    public static final Codec<CoastConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockStateProvider.CODEC.fieldOf("block").forGetter(CoastConfiguration::block), FloatProvider.CODEC.fieldOf("radius").forGetter(CoastConfiguration::radius), UniformInt.CODEC.fieldOf("y_range").forGetter(CoastConfiguration::yRange), RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("valid_blocks").forGetter(CoastConfiguration::validBlocks)).apply(instance, CoastConfiguration::new);
    });

    public CoastConfiguration(BlockStateProvider block, FloatProvider radius, UniformInt yRange, HolderSet<Block> validBlocks) {
        this.block = block;
        this.radius = radius;
        this.yRange = yRange;
        this.validBlocks = validBlocks;
    }

    public BlockStateProvider block() {
        return this.block;
    }

    public FloatProvider radius() {
        return this.radius;
    }

    public UniformInt yRange() {
        return this.yRange;
    }

    public HolderSet<Block> validBlocks() {
        return this.validBlocks;
    }
}
