package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.List;

public class AncientAetherVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = AncientAetherFeatureUtil.registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = AncientAetherFeatureUtil.registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = AncientAetherFeatureUtil.registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = AncientAetherFeatureUtil.registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("frozen_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("jungle_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("pale_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT = AncientAetherFeatureUtil.registerKey("trees_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ENCHANTED_SKYROOT = AncientAetherFeatureUtil.registerKey("trees_enchanted_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CRYSTAL_SKYROOT = AncientAetherFeatureUtil.registerKey("trees_crystal_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_GOLDEN_SKYROOT = AncientAetherFeatureUtil.registerKey("trees_golden_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_WOODLAND = AncientAetherFeatureUtil.registerKey("trees_skyroot_woodland");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_GOLDEN_THICKET = AncientAetherFeatureUtil.registerKey("trees_golden_thicket");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WYNDCAPS = AncientAetherFeatureUtil.registerKey("trees_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FESTIVE_WYNDCAPS = AncientAetherFeatureUtil.registerKey("trees_festive_wyndcaps");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SKYROOT_JUNGLE = AncientAetherFeatureUtil.registerKey("trees_skyroot_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SAKURA = AncientAetherFeatureUtil.registerKey("trees_sakura");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ELEVATED_ISLANDS = AncientAetherFeatureUtil.registerKey("trees_elevated");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        AncientAetherFeatureUtil.register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.WYND_THISTLE.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, HIGHLAND_VIOLA_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.HIGHLAND_VIOLA.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SKY_BLUES.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, SAKURA_BLOSSOMS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SAKURA_BLOSSOMS.get().defaultBlockState(), 12)
                        .add(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get().defaultBlockState(), 3)),
                        64));

        AncientAetherFeatureUtil.register(context, AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 3)),
                        64));
        AncientAetherFeatureUtil.register(context, FROZEN_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_FROZEN, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_FROZEN, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM_FROZEN, 2)),
                        64));
        AncientAetherFeatureUtil.register(context, JUNGLE_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_TALL, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_TALL, 3)),
                        64));
        AncientAetherFeatureUtil.register(context, PALE_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_PALE, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_PALE, 1)),
                        64));

        AncientAetherFeatureUtil.register(context, TREES_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.25F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.025F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.01F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_ENCHANTED_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_CRYSTAL_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_GOLDEN_SKYROOT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.01F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.25F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_SKYROOT_WOODLAND, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.25F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.01F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_GOLDEN_THICKET, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SUPER_GOLDEN_OAK_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.HIGHSPROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.HIGHSPROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_FROSTED_HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get())), 0.05F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FROSTED_HIGHSPROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_FESTIVE_WYNDCAPS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.WYNDCAPS_HOLIDAY_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_WYNDCAPS), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_SKYROOT_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_PINE_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get())), 0.2F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.05F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.02F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SKYROOT_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_SAKURA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.TALL_SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get())), 0.3F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_SKYROOT_JUNGLE), PlacementUtils.filteredByBlockSurvival(AetherBlocks.SKYROOT_SAPLING.get())), 0.3F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.SAKURA_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.SAKURA_SAPLING.get()))));

        AncientAetherFeatureUtil.register(context, TREES_ELEVATED_ISLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get())), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.FANCY_ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get())), 0.1F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AetherConfiguredFeatures.GOLDEN_OAK_TREE_CONFIGURATION), PlacementUtils.filteredByBlockSurvival(AetherBlocks.GOLDEN_OAK_SAPLING.get())), 0.1F)
        ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(AncientAetherTreeFeatures.ENCHANTED_SKYROOT_TREE), PlacementUtils.filteredByBlockSurvival(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get()))));
    }
}