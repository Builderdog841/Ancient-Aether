package net.builderdog.ancient_aether.world.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CloudbedConfiguration(BlockStateProvider block, int baseHeight, double scaleXZ, float thresholdUp, float thresholdDown) implements FeatureConfiguration {
    public static final Codec<CloudbedConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block").forGetter(CloudbedConfiguration::block),
            Codec.INT.fieldOf("base_height").forGetter(CloudbedConfiguration::baseHeight),
            Codec.DOUBLE.fieldOf("xz_scale").forGetter(CloudbedConfiguration::scaleXZ),
            Codec.FLOAT.fieldOf("threshold_up").forGetter(CloudbedConfiguration::thresholdUp),
            Codec.FLOAT.fieldOf("threshold_down").forGetter(CloudbedConfiguration::thresholdDown)
    ).apply(instance, CloudbedConfiguration::new));
}