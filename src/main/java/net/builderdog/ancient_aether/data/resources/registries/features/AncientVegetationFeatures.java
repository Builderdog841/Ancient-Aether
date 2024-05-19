package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.resources.AncientFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class AncientVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SKY_GRASS = AncientFeatureUtils.registerKey("single_piece_of_sky_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_GRASS_PATCH = AncientFeatureUtils.registerKey("aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_AETHER_GRASS_PATCH = AncientFeatureUtils.registerKey("frozen_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_AETHER_GRASS_PATCH = AncientFeatureUtils.registerKey("jungle_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_AETHER_GRASS_PATCH = AncientFeatureUtils.registerKey("pale_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUNSET_ROSE_PATCH = AncientFeatureUtils.registerKey("sunset_rose_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = AncientFeatureUtils.registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = AncientFeatureUtils.registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SLAMMROOT_PATCH = AncientFeatureUtils.registerKey("slammroot_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_FLOWER_PATCH = AncientFeatureUtils.registerKey("aether_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_FOREST_FLOWER_PATCH = AncientFeatureUtils.registerKey("skyroot_forest_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_FLOWER_PATCH = AncientFeatureUtils.registerKey("wyndcaps_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_FLOWER_PATCH = AncientFeatureUtils.registerKey("skyroot_jungle_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_JUNGLE_FLOWER_PATCH = AncientFeatureUtils.registerKey("sakura_jungle_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEVATED_ISLANDS_FLOWER_PATCH = AncientFeatureUtils.registerKey("elevated_islands_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_LAKE_FLOWER_PATCH = AncientFeatureUtils.registerKey("sky_lake_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_TREE_VARIANTS = AncientFeatureUtils.registerKey("skyroot_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE_VARIANTS = AncientFeatureUtils.registerKey("skyroot_pine_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE_VARIANTS = AncientFeatureUtils.registerKey("fancy_skyroot_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE_VARIANTS = AncientFeatureUtils.registerKey("skyroot_jungle_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_MEADOW = AncientFeatureUtils.registerKey("trees_skyroot_meadow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_GROVE = AncientFeatureUtils.registerKey("trees_skyroot_grove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_FOREST = AncientFeatureUtils.registerKey("trees_skyroot_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_WOODLAND = AncientFeatureUtils.registerKey("trees_skyroot_woodland");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SUN_FOREST = AncientFeatureUtils.registerKey("trees_sun_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WYNDCAPS = AncientFeatureUtils.registerKey("trees_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FESTIVE_WYNDCAPS = AncientFeatureUtils.registerKey("trees_festive_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_JUNGLE = AncientFeatureUtils.registerKey("trees_skyroot_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SAKURA = AncientFeatureUtils.registerKey("trees_sakura");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ELEVATED_ISLANDS = AncientFeatureUtils.registerKey("trees_elevated_islands");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientFeatureUtils.register(context, SINGLE_PIECE_OF_SKY_GRASS, AncientFeatures.SKY_GRASS.get(), new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(AncientFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                .add(AncientFeatureStates.SKY_GRASS_SHORT, 2)
                .add(AncientFeatureStates.SKY_GRASS_MEDIUM, 3))));

        AncientFeatureUtils.register(context, AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                                .add(AncientFeatureStates.SKY_GRASS_SHORT, 2)
                                .add(AncientFeatureStates.SKY_GRASS_MEDIUM, 3)),
                        64));
        AncientFeatureUtils.register(context, FROZEN_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientFeatureStates.SKY_GRASS_VERY_SHORT_FROZEN, 1)
                                .add(AncientFeatureStates.SKY_GRASS_SHORT_FROZEN, 2)
                                .add(AncientFeatureStates.SKY_GRASS_MEDIUM_FROZEN, 2)),
                        64));
        AncientFeatureUtils.register(context, JUNGLE_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientFeatureStates.SKY_GRASS_MEDIUM, 1)
                                .add(AncientFeatureStates.SKY_GRASS_TALL, 2)
                                .add(AncientFeatureStates.SKY_GRASS_VERY_TALL, 3)),
                        64));
        AncientFeatureUtils.register(context, PALE_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientFeatureStates.SKY_GRASS_VERY_SHORT_PALE, 2)
                                .add(AncientFeatureStates.SKY_GRASS_SHORT_PALE, 1)),
                        64));

        AncientFeatureUtils.register(context, SUNSET_ROSE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientBlocks.SUNSET_ROSE.get().defaultBlockState(), 3)),
                        64));
        AncientFeatureUtils.register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientBlocks.SKY_BLUES.get().defaultBlockState(), 3)),
                        64));
        AncientFeatureUtils.register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientBlocks.WYND_THISTLE.get().defaultBlockState(), 3)),
                        64));
        AncientFeatureUtils.register(context, SLAMMROOT_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientBlocks.SLAMMROOT_PLANT.get().defaultBlockState(), 3)),
                        32));

        AncientFeatureUtils.register(context, AETHER_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.PURPLE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty()), 0.5F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.WHITE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty())));

        AncientFeatureUtils.register(context, SKYROOT_FOREST_FLOWER_PATCH, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L,
                                new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F,
                                AetherBlocks.WHITE_FLOWER.get().defaultBlockState(),
                                List.of(AncientBlocks.SKY_BLUES.get().defaultBlockState()),
                                List.of(AetherBlocks.PURPLE_FLOWER.get().defaultBlockState(),
                                        AncientBlocks.SUNSET_ROSE.get().defaultBlockState()
                                ))))));

        AncientFeatureUtils.register(context, WYNDCAPS_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty()), 0.375F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKY_BLUES_PATCH), PlacementUtils.isEmpty()), 0.125F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.WYND_THISTLE_PATCH), PlacementUtils.isEmpty())));

        AncientFeatureUtils.register(context, SKYROOT_JUNGLE_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SUNSET_ROSE_PATCH), PlacementUtils.isEmpty()), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty())));

        AncientFeatureUtils.register(context, SAKURA_JUNGLE_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SUNSET_ROSE_PATCH), PlacementUtils.isEmpty()), 0.25F),
        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SLAMMROOT_PATCH), PlacementUtils.isEmpty()), 0.25F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty())));

        AncientFeatureUtils.register(context, ELEVATED_ISLANDS_FLOWER_PATCH, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L,
                                new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F,
                                AetherBlocks.WHITE_FLOWER.get().defaultBlockState(),
                                List.of(AncientFeatureStates.SKY_GRASS_SHORT_PALE),
                                List.of(AetherBlocks.PURPLE_FLOWER.get().defaultBlockState(),
                                        AncientBlocks.ELEVETIA.get().defaultBlockState()
                                ))))));

        AncientFeatureUtils.register(context, SKY_LAKE_FLOWER_PATCH, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L,
                                new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F,
                                AetherBlocks.WHITE_FLOWER.get().defaultBlockState(),
                                List.of(AncientBlocks.SUNSET_ROSE.get().defaultBlockState()),
                                List.of(AetherBlocks.PURPLE_FLOWER.get().defaultBlockState(),
                                        AncientBlocks.SKY_BLUES.get().defaultBlockState()
                                ))))));

        AncientFeatureUtils.register(context, SKYROOT_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, SKYROOT_PINE_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_PINE_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientFeatureUtils.register(context,FANCY_SKYROOT_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.FANCY_SKYROOT_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context,SKYROOT_JUNGLE_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_JUNGLE_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SKYROOT_MEADOW, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_PINE_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SKYROOT_GROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.2F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SKYROOT_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.2F),
        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.025F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SKYROOT_WOODLAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SUN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.15F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.TALL_HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.HIGHSPROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_FESTIVE_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.WYNDCAPS_HOLIDAY_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_WYNDCAPS), PlacementUtils.filteredByBlockSurvival(AncientBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SKYROOT_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_PINE_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SKYROOT_PINE_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.02F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_SAKURA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.TALL_SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SAKURA_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_JUNGLE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.SAKURA_SAPLING.get()))));

        AncientFeatureUtils.register(context, TREES_ELEVATED_ISLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.FANCY_ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientTreeFeatures.ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get()))));


    }
}