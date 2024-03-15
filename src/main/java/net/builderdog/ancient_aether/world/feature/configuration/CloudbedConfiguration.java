package net.builderdog.ancient_aether.world.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CloudbedConfiguration(BlockStateProvider block, int baseHeight, double scaleXZ, long noiseXZ, long noiseY, float thicknessUp, float thicknessDown) implements FeatureConfiguration {
    public static final Codec<CloudbedConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block").forGetter(CloudbedConfiguration::block),
            Codec.INT.fieldOf("base_height").forGetter(CloudbedConfiguration::baseHeight),
            Codec.DOUBLE.fieldOf("scale_xz").forGetter(CloudbedConfiguration::scaleXZ),
            Codec.LONG.fieldOf("noise_xz").forGetter(CloudbedConfiguration::noiseXZ),
            Codec.LONG.fieldOf("noise_y").forGetter(CloudbedConfiguration::noiseY),
            Codec.FLOAT.fieldOf("thickness_up").forGetter(CloudbedConfiguration::thicknessUp),
            Codec.FLOAT.fieldOf("thickness_down").forGetter(CloudbedConfiguration::thicknessDown)
    ).apply(instance, CloudbedConfiguration::new));
}