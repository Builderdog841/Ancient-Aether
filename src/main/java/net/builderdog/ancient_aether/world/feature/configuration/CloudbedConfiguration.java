package net.builderdog.ancient_aether.world.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CloudbedConfiguration(BlockStateProvider block, int baseHeight, double scaleXZ, long noiseFactor, long yOffsetFactor, float thresholdUp, float thresholdDown) implements FeatureConfiguration {
    public static final Codec<CloudbedConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block").forGetter(CloudbedConfiguration::block),
            Codec.INT.fieldOf("base_height").forGetter(CloudbedConfiguration::baseHeight),
            Codec.DOUBLE.fieldOf("xz_scale").forGetter(CloudbedConfiguration::scaleXZ),
            Codec.LONG.fieldOf("noise_factor").forGetter(CloudbedConfiguration::noiseFactor),
            Codec.LONG.fieldOf("y_offset_factor").forGetter(CloudbedConfiguration::yOffsetFactor),
            Codec.FLOAT.fieldOf("threshold_up").forGetter(CloudbedConfiguration::thresholdUp),
            Codec.FLOAT.fieldOf("threshold_down").forGetter(CloudbedConfiguration::thresholdDown)
    ).apply(instance, CloudbedConfiguration::new));
}