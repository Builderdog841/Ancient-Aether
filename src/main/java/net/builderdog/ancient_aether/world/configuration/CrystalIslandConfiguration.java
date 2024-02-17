package net.builderdog.ancient_aether.world.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record CrystalIslandConfiguration(BlockState surfaceBlock, BlockState islandBlock) implements FeatureConfiguration {
    public static final Codec<CrystalIslandConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockState.CODEC.fieldOf("surface_block").forGetter(CrystalIslandConfiguration::surfaceBlock),
            BlockState.CODEC.fieldOf("island_block").forGetter(CrystalIslandConfiguration::islandBlock)
    ).apply(instance, CrystalIslandConfiguration::new));
}