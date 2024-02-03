package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.aether.world.placementmodifier.ConfigFilter;
import com.aetherteam.aether.world.placementmodifier.ImprovedLayerPlacementModifier;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherVegetationFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class AncientAetherVegetationPlacements {
    public static final ResourceKey<PlacedFeature> AETHER_GRASS_BONEMEAL = AncientAetherPlacementUtils.createKey("aether_grass_bonemeal");
    public static final ResourceKey<PlacedFeature> AETHER_GRASS_PATCH = AncientAetherPlacementUtils.createKey("aether_grass_patch");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_GRASS_PATCH = AncientAetherPlacementUtils.createKey("wyndcaps_grass_patch");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_GRASS_PATCH = AncientAetherPlacementUtils.createKey("sakura_jungle_grass_patch");
    public static final ResourceKey<PlacedFeature> ELEVATED_ISLANDS_GRASS_PATCH = AncientAetherPlacementUtils.createKey("elevated_islands_grass_patch");
    public static final ResourceKey<PlacedFeature> BONUS_BERRY_BUSH_PATCH = AncientAetherPlacementUtils.createKey("bonus_berry_bush_patch");
    public static final ResourceKey<PlacedFeature> CRYSTAL_SKYROOT_GROVE_TREES = AncientAetherPlacementUtils.createKey("crystal_skyroot_grove_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_MEADOW_FLOWERS = AncientAetherPlacementUtils.createKey("skyroot_meadow_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_GROVE_FLOWERS = AncientAetherPlacementUtils.createKey("skyroot_grove_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_FOREST_FLOWERS = AncientAetherPlacementUtils.createKey("skyroot_forest_flowers");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_FLOWERS = AncientAetherPlacementUtils.createKey("wyndcaps_flowers");
    public static final ResourceKey<PlacedFeature> WYNDCAP_HIGHLAND_FLOWERS = AncientAetherPlacementUtils.createKey("wyndcap_highland_flowers");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_FLOWERS = AncientAetherPlacementUtils.createKey("sakura_jungle_flowers");
    public static final ResourceKey<PlacedFeature> CRYSTAL_SKYROOT_FOREST_TREES = AncientAetherPlacementUtils.createKey("crystal_skyroot_forest_trees");
    public static final ResourceKey<PlacedFeature> GOLDEN_SKYROOT_GROVE_TREES = AncientAetherPlacementUtils.createKey("golden_skyroot_grove_trees");
    public static final ResourceKey<PlacedFeature> GOLDEN_SKYROOT_FOREST_TREES = AncientAetherPlacementUtils.createKey("golden_skyroot_forest_trees");
    public static final ResourceKey<PlacedFeature> GOLDEN_THICKET_TREES = AncientAetherPlacementUtils.createKey("golden_thicket_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_TAIGA_TREES = AncientAetherPlacementUtils.createKey("wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> FESTIVE_WYNDCAP_TAIGA_TREES = AncientAetherPlacementUtils.createKey("festive_wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_HIGHLAND_TREES = AncientAetherPlacementUtils.createKey("wyndcap_highland_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_JUNGLE_TREES = AncientAetherPlacementUtils.createKey("skyroot_jungle_trees");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_TREES = AncientAetherPlacementUtils.createKey("sakura_jungle_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_CLEARING_TREES = AncientAetherPlacementUtils.createKey("elevated_clearing_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_FOREST_TREES = AncientAetherPlacementUtils.createKey("elevated_forest_trees");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtils.register(context, AETHER_GRASS_BONEMEAL, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SINGLE_PIECE_OF_SKY_GRASS), PlacementUtils.isEmpty());

        AncientAetherPlacementUtils.register(context, AETHER_GRASS_PATCH, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientAetherPlacementUtils.register(context, WYNDCAPS_GRASS_PATCH, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.FROZEN_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientAetherPlacementUtils.register(context, SAKURA_JUNGLE_GRASS_PATCH, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.JUNGLE_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 15, 25),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientAetherPlacementUtils.register(context, ELEVATED_ISLANDS_GRASS_PATCH, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.PALE_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );

        AncientAetherPlacementUtils.register(context, SKYROOT_MEADOW_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SKYROOT_MEADOW_FLOWER_PATCH),
                PlacementUtils.countExtra(14, 0.1F, 1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, SKYROOT_GROVE_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH),
                RarityFilter.onAverageOnceEvery(1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, SKYROOT_FOREST_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_FLOWER_PATCH),
                RarityFilter.onAverageOnceEvery(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, WYNDCAPS_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.WYNDCAPS_FLOWER_PATCH),
                RarityFilter.onAverageOnceEvery(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, WYNDCAP_HIGHLAND_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.WYNDCAPS_FLOWER_PATCH),
                RarityFilter.onAverageOnceEvery(1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, SAKURA_JUNGLE_FLOWERS, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SAKURA_JUNGLE_FLOWER_PATCH),
                RarityFilter.onAverageOnceEvery(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );

        AncientAetherPlacementUtils.register(context, BONUS_BERRY_BUSH_PATCH, configuredFeatures.getOrThrow(AetherConfiguredFeatures.BERRY_BUSH_PATCH_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(6),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome());

        AncientAetherPlacementUtils.register(context, CRYSTAL_SKYROOT_GROVE_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_CRYSTAL_SKYROOT),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, CRYSTAL_SKYROOT_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_CRYSTAL_SKYROOT),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, GOLDEN_SKYROOT_GROVE_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_GOLDEN_SKYROOT),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, GOLDEN_SKYROOT_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_GOLDEN_SKYROOT),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, GOLDEN_THICKET_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_GOLDEN_THICKET),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, FESTIVE_WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_FESTIVE_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, WYNDCAP_HIGHLAND_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(RarityFilter.onAverageOnceEvery(3))
        );
        AncientAetherPlacementUtils.register(context, SKYROOT_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_SKYROOT_JUNGLE),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, SAKURA_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_SAKURA),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1))
        );
        AncientAetherPlacementUtils.register(context, ELEVATED_CLEARING_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_ELEVATED_ISLANDS),
                AetherPlacedFeatureBuilders.treePlacement(RarityFilter.onAverageOnceEvery(3))
        );
        AncientAetherPlacementUtils.register(context, ELEVATED_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.TREES_ELEVATED_ISLANDS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(12, 0.1F, 1))
        );
    }
}