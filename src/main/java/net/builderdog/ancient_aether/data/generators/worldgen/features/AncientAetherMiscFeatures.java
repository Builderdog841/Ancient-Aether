package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.feature.CloudbedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AncientAetherMiscFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_QUICKSOIL = AncientAetherFeatureUtil.registerKey("coast_quicksoil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_GRAVITY_GRAVEL = AncientAetherFeatureUtil.registerKey("coast_gravity_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_WYND_ICE = AncientAetherFeatureUtil.registerKey("coast_wynd_ice");

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = AncientAetherFeatureUtil.registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = AncientAetherFeatureUtil.registerKey("cloudbed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICESTONE_FOREST_ROCK = AncientAetherFeatureUtil.registerKey("icestone_forest_rock");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        AncientAetherFeatureUtil.register(context, COAST_QUICKSOIL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AetherFeatureStates.QUICKSOIL), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
            AncientAetherFeatureUtil.register(context, COAST_GRAVITY_GRAVEL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AncientAetherFeatureStates.GRAVITY_GRAVEL), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
        AncientAetherFeatureUtil.register(context, COAST_WYND_ICE, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AncientAetherFeatureStates.WYND_ICE), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
        AncientAetherFeatureUtil.register(context, ICESTONE_FOREST_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(AetherFeatureStates.ICESTONE));
        AncientAetherFeatureUtil.register(context, VIOLET_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.VIOLET_AERCLOUD));
        AncientAetherFeatureUtil.register(context, CLOUDBED, AncientAetherFeatures.CLOUDBED.get(), new CloudbedFeature.Config(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1D));
    }
}