package net.builderdog.aether_crystallium.world.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;


public record LargeCactusConfiguration(BlockStateProvider blockstate) implements FeatureConfiguration {
    public static final Codec<LargeCactusConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("blockstate").forGetter(LargeCactusConfiguration::blockstate))
            .apply(instance, LargeCactusConfiguration::new));
}