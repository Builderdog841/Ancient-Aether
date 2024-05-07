package net.builderdog.ancient_aether.world.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record CrystalIslandConfiguration(ResourceLocation feature, BlockState topBlock, BlockState islandBlock) implements FeatureConfiguration {
    public static final Codec<CrystalIslandConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            ResourceLocation.CODEC.fieldOf("feature").forGetter(CrystalIslandConfiguration::feature),
            BlockState.CODEC.fieldOf("top_block").forGetter(CrystalIslandConfiguration::topBlock),
            BlockState.CODEC.fieldOf("island_block").forGetter(CrystalIslandConfiguration::islandBlock)
    ).apply(instance, CrystalIslandConfiguration::new));
}