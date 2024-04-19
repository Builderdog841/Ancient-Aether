package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
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

public class AncientAetherVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SKY_GRASS = AncientAetherFeatureUtils.registerKey("single_piece_of_sky_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("frozen_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("jungle_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("pale_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUNSET_ROSE_PATCH = AncientAetherFeatureUtils.registerKey("sunset_rose_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = AncientAetherFeatureUtils.registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = AncientAetherFeatureUtils.registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SLAMMROOT_PATCH = AncientAetherFeatureUtils.registerKey("slammroot_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("aether_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_FLOWER_PATCH_MIXED = AncientAetherFeatureUtils.registerKey("aether_flower_patch_mixed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("wyndcaps_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("skyroot_jungle_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_JUNGLE_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("sakura_jungle_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEVATED_ISLANDS_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("elevated_islands_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_TREE_VARIANTS = AncientAetherFeatureUtils.registerKey("skyroot_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE_VARIANTS = AncientAetherFeatureUtils.registerKey("skyroot_pine_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE_VARIANTS = AncientAetherFeatureUtils.registerKey("fancy_skyroot_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE_VARIANTS = AncientAetherFeatureUtils.registerKey("skyroot_jungle_tree_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_MEADOW = AncientAetherFeatureUtils.registerKey("trees_skyroot_meadow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_GROVE = AncientAetherFeatureUtils.registerKey("trees_skyroot_grove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_FOREST = AncientAetherFeatureUtils.registerKey("trees_skyroot_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_WOODLAND = AncientAetherFeatureUtils.registerKey("trees_skyroot_woodland");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SUN_FOREST = AncientAetherFeatureUtils.registerKey("trees_sun_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WYNDCAPS = AncientAetherFeatureUtils.registerKey("trees_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FESTIVE_WYNDCAPS = AncientAetherFeatureUtils.registerKey("trees_festive_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_JUNGLE = AncientAetherFeatureUtils.registerKey("trees_skyroot_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SAKURA = AncientAetherFeatureUtils.registerKey("trees_sakura");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ELEVATED_ISLANDS = AncientAetherFeatureUtils.registerKey("trees_elevated_islands");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherFeatureUtils.register(context, SINGLE_PIECE_OF_SKY_GRASS, AncientAetherFeatures.SKY_GRASS.get(), new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT, 2)
                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 3))));

        AncientAetherFeatureUtils.register(context, AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, FROZEN_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_FROZEN, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_FROZEN, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM_FROZEN, 2)),
                        64));
        AncientAetherFeatureUtils.register(context, JUNGLE_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_TALL, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_TALL, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, PALE_AETHER_GRASS_PATCH, Feature.RANDOM_PATCH,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_PALE, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_PALE, 1)),
                        64));

        AncientAetherFeatureUtils.register(context, SUNSET_ROSE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SUNSET_ROSE, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_BLUES, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.WYND_THISTLE, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, SLAMMROOT_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherBlocks.SLAMMROOT_PLANT.get().defaultBlockState(), 3)),
                        32));

        AncientAetherFeatureUtils.register(context, AETHER_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.PURPLE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty()), 0.5F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.WHITE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, AETHER_FLOWER_PATCH_MIXED, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L,
                                new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F,
                                AetherBlocks.WHITE_FLOWER.get().defaultBlockState(),
                                List.of(AncientAetherFeatureStates.SKY_BLUES),
                                List.of(AetherBlocks.PURPLE_FLOWER.get().defaultBlockState(),
                                        AncientAetherFeatureStates.SUNSET_ROSE
                                ))))));

        AncientAetherFeatureUtils.register(context, WYNDCAPS_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty()), 0.375F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKY_BLUES_PATCH), PlacementUtils.isEmpty()), 0.125F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.WYND_THISTLE_PATCH), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, SKYROOT_JUNGLE_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SUNSET_ROSE_PATCH), PlacementUtils.isEmpty()), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, SAKURA_JUNGLE_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SUNSET_ROSE_PATCH), PlacementUtils.isEmpty()), 0.25F),
        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SLAMMROOT_PATCH), PlacementUtils.isEmpty()), 0.25F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, ELEVATED_ISLANDS_FLOWER_PATCH, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L,
                                new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F,
                                AetherBlocks.WHITE_FLOWER.get().defaultBlockState(),
                                List.of(AncientAetherFeatureStates.SKY_GRASS_SHORT_PALE),
                                List.of(AetherBlocks.PURPLE_FLOWER.get().defaultBlockState(),
                                        AncientAetherFeatureStates.ELEVATIA
                                ))))));

        AncientAetherFeatureUtils.register(context, SKYROOT_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, SKYROOT_PINE_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context,FANCY_SKYROOT_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context,SKYROOT_JUNGLE_TREE_VARIANTS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_JUNGLE_TREE_VINED), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_MEADOW, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_PINE_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_GROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.2F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.2F),
        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.025F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_WOODLAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SUN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.15F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.15F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_FESTIVE_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.WYNDCAPS_HOLIDAY_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_WYNDCAPS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_PINE_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FANCY_SKYROOT_TREE_VARIANTS), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.02F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SAKURA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_SKYROOT_JUNGLE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_ELEVATED_ISLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_DIVINE_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.DIVINE_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get()))));


    }
}