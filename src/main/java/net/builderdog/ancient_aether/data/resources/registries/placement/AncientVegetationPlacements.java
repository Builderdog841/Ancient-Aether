package net.builderdog.ancient_aether.data.resources.registries.placement;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.aether.world.placementmodifier.ConfigFilter;
import com.aetherteam.aether.world.placementmodifier.ImprovedLayerPlacementModifier;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientVegetationFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.placement.*;

public class AncientVegetationPlacements extends TrunkVineDecorator {
    public static final ResourceKey<PlacedFeature> AETHER_GRASS_PATCH = AncientPlacementUtils.createKey("aether_grass_patch");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_GRASS_PATCH = AncientPlacementUtils.createKey("wyndcaps_grass_patch");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_GRASS_PATCH = AncientPlacementUtils.createKey("sakura_jungle_grass_patch");
    public static final ResourceKey<PlacedFeature> ELEVATED_ISLANDS_GRASS_PATCH = AncientPlacementUtils.createKey("elevated_islands_grass_patch");
    public static final ResourceKey<PlacedFeature> BONUS_BERRY_BUSH_PATCH = AncientPlacementUtils.createKey("bonus_berry_bush_patch");
    public static final ResourceKey<PlacedFeature> SKYROOT_MEADOW_FLOWERS = AncientPlacementUtils.createKey("skyroot_meadow_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_GROVE_FLOWERS = AncientPlacementUtils.createKey("skyroot_grove_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_FOREST_FLOWERS = AncientPlacementUtils.createKey("skyroot_forest_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_WOODLAND_FLOWERS = AncientPlacementUtils.createKey("skyroot_woodland_flowers");
    public static final ResourceKey<PlacedFeature> SUN_FOREST_FLOWERS = AncientPlacementUtils.createKey("sun_forest_flowers");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_FLOWERS = AncientPlacementUtils.createKey("wyndcaps_flowers");
    public static final ResourceKey<PlacedFeature> WYNDCAP_HIGHLAND_FLOWERS = AncientPlacementUtils.createKey("wyndcap_highland_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_JUNGLE_FLOWERS = AncientPlacementUtils.createKey("skyroot_jungle_flowers");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_FLOWERS = AncientPlacementUtils.createKey("sakura_jungle_flowers");
    public static final ResourceKey<PlacedFeature> ELEVATED_ISLANDS_FLOWERS = AncientPlacementUtils.createKey("elevated_islands_flowers");
    public static final ResourceKey<PlacedFeature> SKY_LAKE_FLOWERS = AncientPlacementUtils.createKey("sky_lake_flowers");
    public static final ResourceKey<PlacedFeature> SKYROOT_MEADOW_TREES = AncientPlacementUtils.createKey("skyroot_meadow_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_GROVE_TREES = AncientPlacementUtils.createKey("skyroot_grove_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_FOREST_TREES = AncientPlacementUtils.createKey("skyroot_forest_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_WOODLAND_TREES = AncientPlacementUtils.createKey("skyroot_woodland_trees");
    public static final ResourceKey<PlacedFeature> SUN_FOREST_TREES = AncientPlacementUtils.createKey("sun_forest_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_TAIGA_TREES = AncientPlacementUtils.createKey("wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> FESTIVE_WYNDCAP_TAIGA_TREES = AncientPlacementUtils.createKey("festive_wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_HIGHLAND_TREES = AncientPlacementUtils.createKey("wyndcap_highland_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_JUNGLE_TREES = AncientPlacementUtils.createKey("skyroot_jungle_trees");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_TREES = AncientPlacementUtils.createKey("sakura_jungle_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_CLEARING_TREES = AncientPlacementUtils.createKey("elevated_clearing_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_FOREST_TREES = AncientPlacementUtils.createKey("elevated_forest_trees");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientPlacementUtils.register(context, AETHER_GRASS_PATCH, configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientPlacementUtils.register(context, WYNDCAPS_GRASS_PATCH, configuredFeatures.getOrThrow(AncientVegetationFeatures.FROZEN_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientPlacementUtils.register(context, SAKURA_JUNGLE_GRASS_PATCH, configuredFeatures.getOrThrow(AncientVegetationFeatures.JUNGLE_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 15, 25),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );
        AncientPlacementUtils.register(context, ELEVATED_ISLANDS_GRASS_PATCH, configuredFeatures.getOrThrow(AncientVegetationFeatures.PALE_AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass)
        );

        AncientPlacementUtils.register(context, SKYROOT_MEADOW_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH),
                CountPlacement.of(6),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SKYROOT_GROVE_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH),
                CountPlacement.of(5),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SKYROOT_FOREST_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_FOREST_FLOWER_PATCH),
                CountPlacement.of(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SKYROOT_WOODLAND_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_FOREST_FLOWER_PATCH),
                CountPlacement.of(1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SUN_FOREST_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.AETHER_FLOWER_PATCH),
                CountPlacement.of(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, WYNDCAPS_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.WYNDCAPS_FLOWER_PATCH),
                CountPlacement.of(1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, WYNDCAP_HIGHLAND_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.WYNDCAPS_FLOWER_PATCH),
                CountPlacement.of(3),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SKYROOT_JUNGLE_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.SKYROOT_JUNGLE_FLOWER_PATCH),
                CountPlacement.of(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SAKURA_JUNGLE_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.SAKURA_JUNGLE_FLOWER_PATCH),
                CountPlacement.of(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, ELEVATED_ISLANDS_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.ELEVATED_ISLANDS_FLOWER_PATCH),
                CountPlacement.of(1),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SKY_LAKE_FLOWERS, configuredFeatures.getOrThrow(AncientVegetationFeatures.SKY_LAKE_FLOWER_PATCH),
                CountPlacement.of(2),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome()
        );

        AncientPlacementUtils.register(context, BONUS_BERRY_BUSH_PATCH, configuredFeatures.getOrThrow(AetherConfiguredFeatures.BERRY_BUSH_PATCH_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(3),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome());

        AncientPlacementUtils.register(context, SKYROOT_MEADOW_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_MEADOW),
                AetherPlacedFeatureBuilders.treePlacement(RarityFilter.onAverageOnceEvery(3))
        );
        AncientPlacementUtils.register(context, SKYROOT_GROVE_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_GROVE),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(5, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, SKYROOT_FOREST_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_FOREST),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, SKYROOT_WOODLAND_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_WOODLAND),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(24, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, SUN_FOREST_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SUN_FOREST),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, FESTIVE_WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_FESTIVE_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, WYNDCAP_HIGHLAND_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_WYNDCAPS),
                AetherPlacedFeatureBuilders.treePlacement(RarityFilter.onAverageOnceEvery(3))
        );
        AncientPlacementUtils.register(context, SKYROOT_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SKYROOT_JUNGLE),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(28, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, SAKURA_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_SAKURA),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(28, 0.1F, 1))
        );
        AncientPlacementUtils.register(context, ELEVATED_CLEARING_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_ELEVATED_ISLANDS),
                AetherPlacedFeatureBuilders.treePlacement(RarityFilter.onAverageOnceEvery(3))
        );
        AncientPlacementUtils.register(context, ELEVATED_FOREST_TREES, configuredFeatures.getOrThrow(AncientVegetationFeatures.TREES_ELEVATED_ISLANDS),
                AetherPlacedFeatureBuilders.treePlacement(PlacementUtils.countExtra(12, 0.1F, 1))
        );
    }
}