package net.builderdog.ancient_aether.data.resources.registries.placement;

import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.aether.world.placementmodifier.DungeonBlacklistFilter;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientMiscFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientMiscPlacements {
    public static final ResourceKey<PlacedFeature> QUICKSOIL_COAST = AncientPlacementUtils.createKey("quicksoil_coast");
    public static final ResourceKey<PlacedFeature> GRAVITY_GRAVEL_COAST = AncientPlacementUtils.createKey("gravity_gravel_coast");
    public static final ResourceKey<PlacedFeature> WYND_ICE_COAST = AncientPlacementUtils.createKey("wynd_ice_coast");
    public static final ResourceKey<PlacedFeature> SKYROOT_LEAF_VINES = AncientPlacementUtils.createKey("skyroot_leaf_vines");
    public static final ResourceKey<PlacedFeature> SHORT_SKYROOT_LEAF_VINES = AncientPlacementUtils.createKey("short_skyroot_leaf_vines");
    public static final ResourceKey<PlacedFeature> VIOLET_AERCLOUD = AncientPlacementUtils.createKey("violet_aercloud");
    public static final ResourceKey<PlacedFeature> CLOUDBED = AncientPlacementUtils.createKey("cloudbed");
    public static final ResourceKey<PlacedFeature> WATER_LAKE_UNDERGROUND = AncientPlacementUtils.createKey("water_lake_underground");
    public static final ResourceKey<PlacedFeature> CRYSTAL_ISLAND = AncientPlacementUtils.createKey("crystal_island");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_CRYSTAL_ISLAND = AncientPlacementUtils.createKey("wyndcaps_crystal_island");
    public static final ResourceKey<PlacedFeature> ELEVATED_CRYSTAL_ISLAND = AncientPlacementUtils.createKey("elevated_crystal_island");
    public static final ResourceKey<PlacedFeature> BRONZE_DUNGEON_ENTRANCE = AncientPlacementUtils.createKey("bronze_dungeon_entrance");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientPlacementUtils.register(context, QUICKSOIL_COAST, configuredFeatures.getOrThrow(AncientMiscFeatures.COAST_QUICKSOIL),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(96), VerticalAnchor.absolute(128)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, GRAVITY_GRAVEL_COAST, configuredFeatures.getOrThrow(AncientMiscFeatures.COAST_GRAVITY_GRAVEL),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(112), VerticalAnchor.absolute(144)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, WYND_ICE_COAST, configuredFeatures.getOrThrow(AncientMiscFeatures.COAST_WYND_ICE),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(112), VerticalAnchor.absolute(144)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );

        AncientPlacementUtils.register(context, SKYROOT_LEAF_VINES, configuredFeatures.getOrThrow(AncientMiscFeatures.SKYROOT_LEAF_VINE),
                CountPlacement.of(255),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesTag(AncientTags.Blocks.LEAF_VINE_CAN_SPAWN_ON)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, SHORT_SKYROOT_LEAF_VINES, configuredFeatures.getOrThrow(AncientMiscFeatures.SHORT_SKYROOT_LEAF_VINE),
                CountPlacement.of(255),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesTag(AncientTags.Blocks.LEAF_VINE_CAN_SPAWN_ON)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()
        );

        AncientPlacementUtils.register(context, VIOLET_AERCLOUD, configuredFeatures.getOrThrow(AncientMiscFeatures.VIOLET_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(32, 224, 24));
        AncientPlacementUtils.register(context, CLOUDBED, configuredFeatures.getOrThrow(AncientMiscFeatures.CLOUDBED), List.of());

        AncientPlacementUtils.register(context, WATER_LAKE_UNDERGROUND, configuredFeatures.getOrThrow(AetherConfiguredFeatures.WATER_LAKE_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(15),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 16),
                SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -5),
                InSquarePlacement.spread(),
                BiomeFilter.biome());

        AncientPlacementUtils.register(context, CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AetherConfiguredFeatures.CRYSTAL_ISLAND_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, WYNDCAPS_CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AncientMiscFeatures.CRYSTAL_ISLAND_FROZEN),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );
        AncientPlacementUtils.register(context, ELEVATED_CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AncientMiscFeatures.CRYSTAL_ISLAND_PALE),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );

        AncientPlacementUtils.register(context, BRONZE_DUNGEON_ENTRANCE, configuredFeatures.getOrThrow(AncientMiscFeatures.BRONZE_DUNGEON_ENTRANCE));
    }
}