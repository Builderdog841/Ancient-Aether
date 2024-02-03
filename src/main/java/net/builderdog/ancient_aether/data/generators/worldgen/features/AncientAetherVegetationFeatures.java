package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.world.AncientAetherFeatureStates;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class AncientAetherVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = AncientAetherFeatureUtils.registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = AncientAetherFeatureUtils.registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = AncientAetherFeatureUtils.registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = AncientAetherFeatureUtils.registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SKY_GRASS = AncientAetherFeatureUtils.registerKey("single_piece_of_sky_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("frozen_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("jungle_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_AETHER_GRASS_PATCH = AncientAetherFeatureUtils.registerKey("pale_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("aether_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("wyndcaps_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_JUNGLE_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("sakura_jungle_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_MEADOW_FLOWER_PATCH = AncientAetherFeatureUtils.registerKey("skyroot_meadow_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT = AncientAetherFeatureUtils.registerKey("trees_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CRYSTAL_SKYROOT = AncientAetherFeatureUtils.registerKey("trees_crystal_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_GOLDEN_SKYROOT = AncientAetherFeatureUtils.registerKey("trees_golden_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_WOODLAND = AncientAetherFeatureUtils.registerKey("trees_skyroot_woodland");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_GOLDEN_THICKET = AncientAetherFeatureUtils.registerKey("trees_golden_thicket");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WYNDCAPS = AncientAetherFeatureUtils.registerKey("trees_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FESTIVE_WYNDCAPS = AncientAetherFeatureUtils.registerKey("trees_festive_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_JUNGLE = AncientAetherFeatureUtils.registerKey("trees_skyroot_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SAKURA = AncientAetherFeatureUtils.registerKey("trees_sakura");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ELEVATED_ISLANDS = AncientAetherFeatureUtils.registerKey("trees_elevated_islands");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        AncientAetherFeatureUtils.register(context, HIGHLAND_VIOLA_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.HIGHLAND_VIOLA, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_BLUES, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.WYND_THISTLE, 3)),
                        64));
        AncientAetherFeatureUtils.register(context, SAKURA_BLOSSOMS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SAKURA_BLOSSOMS, 12)
                                .add(AncientAetherFeatureStates.TRAPPED_SAKURA_BLOSSOMS, 3)),
                        64));

        AncientAetherFeatureUtils.register(context, SINGLE_PIECE_OF_SKY_GRASS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
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

        AncientAetherFeatureUtils.register(context, AETHER_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.PURPLE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty()), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.HIGHLAND_VIOLA_PATCH), PlacementUtils.isEmpty()), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKY_BLUES_PATCH), PlacementUtils.isEmpty()), 0.2F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.WHITE_FLOWER_PATCH_CONFIGURATION), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, WYNDCAPS_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty()), 0.5F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.WYND_THISTLE_PATCH), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, SAKURA_JUNGLE_FLOWER_PATCH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH), PlacementUtils.isEmpty()), 0.25F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SAKURA_BLOSSOMS_PATCH), PlacementUtils.isEmpty())));

        AncientAetherFeatureUtils.register(context, SKYROOT_MEADOW_FLOWER_PATCH, Feature.FLOWER,
                new RandomPatchConfiguration(56, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new DualNoiseProvider(
                                new InclusiveRange<>(1, 3),
                                new NormalNoise.NoiseParameters(-10, 1.0D), 1.0F, 2345L,
                                new NormalNoise.NoiseParameters(-3, 1.0D), 1.0F,
                                List.of(AetherFeatureStates.PURPLE_FLOWER,
                                        AetherFeatureStates.WHITE_FLOWER,
                                        AncientAetherFeatureStates.HIGHLAND_VIOLA,
                                        AetherFeatureStates.PURPLE_FLOWER,
                                        AncientAetherFeatureStates.SKY_GRASS_SHORT,
                                        AetherFeatureStates.WHITE_FLOWER,
                                        AncientAetherFeatureStates.SKY_BLUES,
                                        AncientAetherFeatureStates.HIGHLAND_VIOLA,
                                        AetherFeatureStates.PURPLE_FLOWER,
                                        AncientAetherFeatureStates.SKY_BLUES,
                                        AncientAetherFeatureStates.SKY_GRASS_MEDIUM))))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.25F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.025F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.01F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_CRYSTAL_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.25F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_GOLDEN_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.25F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_WOODLAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.25F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.001F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_GOLDEN_THICKET, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SUPER_GOLDEN_OAK_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_FESTIVE_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.WYNDCAPS_HOLIDAY_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_WYNDCAPS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SKYROOT_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.02F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_SAKURA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_SKYROOT_JUNGLE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get()))));

        AncientAetherFeatureUtils.register(context, TREES_ELEVATED_ISLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get()))));
    }
}