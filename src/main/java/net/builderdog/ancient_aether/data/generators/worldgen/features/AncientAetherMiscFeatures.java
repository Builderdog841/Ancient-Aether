package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.feature.CloudbedFeature;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class AncientAetherMiscFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = AncientAetherFeatureUtil.registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_AERCLOUD = AncientAetherFeatureUtil.registerKey("crystal_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = AncientAetherFeatureUtil.registerKey("cloudbed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICESTONE_FOREST_ROCK = AncientAetherFeatureUtil.registerKey("icestone_forest_rock");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientAetherFeatureUtil.register(context, VIOLET_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.VIOLET_AERCLOUD));
        AncientAetherFeatureUtil.register(context, CRYSTAL_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.CRYSTAL_AERCLOUD));
        AncientAetherFeatureUtil.register(context, CLOUDBED, AncientAetherFeatures.CLOUDBED.get(), new CloudbedFeature.Config(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1D));
        AncientAetherFeatureUtil.register(context, ICESTONE_FOREST_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(AetherFeatureStates.ICESTONE));
    }
}