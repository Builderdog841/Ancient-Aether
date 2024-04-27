package net.builderdog.ancient_aether.data.resources.registries.placement;

import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.aether.world.placementmodifier.DungeonBlacklistFilter;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherMiscFeatures;
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

public class AncientAetherMiscPlacements {
    public static final ResourceKey<PlacedFeature> QUICKSOIL_COAST = AncientAetherPlacementUtils.createKey("quicksoil_coast");
    public static final ResourceKey<PlacedFeature> GRAVITY_GRAVEL_COAST = AncientAetherPlacementUtils.createKey("gravity_gravel_coast");
    public static final ResourceKey<PlacedFeature> WYND_ICE_COAST = AncientAetherPlacementUtils.createKey("wynd_ice_coast");
    public static final ResourceKey<PlacedFeature> SKYROOT_LEAF_VINES = AncientAetherPlacementUtils.createKey("skyroot_leaf_vines");
    public static final ResourceKey<PlacedFeature> SHORT_SKYROOT_LEAF_VINES = AncientAetherPlacementUtils.createKey("short_skyroot_leaf_vines");
    public static final ResourceKey<PlacedFeature> VIOLET_AERCLOUD = AncientAetherPlacementUtils.createKey("violet_aercloud");
    public static final ResourceKey<PlacedFeature> CLOUDBED = AncientAetherPlacementUtils.createKey("cloudbed");
    public static final ResourceKey<PlacedFeature> WATER_LAKE_UNDERGROUND = AncientAetherPlacementUtils.createKey("water_lake_underground");
    public static final ResourceKey<PlacedFeature> CRYSTAL_ISLAND = AncientAetherPlacementUtils.createKey("crystal_island");
    public static final ResourceKey<PlacedFeature> WYNDCAPS_CRYSTAL_ISLAND = AncientAetherPlacementUtils.createKey("wyndcaps_crystal_island");
    public static final ResourceKey<PlacedFeature> ELEVATED_CRYSTAL_ISLAND = AncientAetherPlacementUtils.createKey("elevated_crystal_island");
    public static final ResourceKey<PlacedFeature> BRONZE_DUNGEON_ENTRANCE = AncientAetherPlacementUtils.createKey("bronze_dungeon_entrance");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtils.register(context, QUICKSOIL_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_QUICKSOIL),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(96), VerticalAnchor.absolute(128)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, GRAVITY_GRAVEL_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_GRAVITY_GRAVEL),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(112), VerticalAnchor.absolute(144)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, WYND_ICE_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_WYND_ICE),
                CountPlacement.of(127),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(112), VerticalAnchor.absolute(144)),
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 16),
                BiomeFilter.biome()
        );

        AncientAetherPlacementUtils.register(context, SKYROOT_LEAF_VINES, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.SKYROOT_LEAF_VINE),
                CountPlacement.of(255),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesTag(AncientAetherTags.Blocks.LEAF_VINE_CAN_SPAWN_ON)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, SHORT_SKYROOT_LEAF_VINES, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.SHORT_SKYROOT_LEAF_VINE),
                CountPlacement.of(255),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesTag(AncientAetherTags.Blocks.LEAF_VINE_CAN_SPAWN_ON)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()
        );

        AncientAetherPlacementUtils.register(context, VIOLET_AERCLOUD, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.VIOLET_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(32, 224, 24));
        AncientAetherPlacementUtils.register(context, CLOUDBED, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.CLOUDBED), List.of());

        AncientAetherPlacementUtils.register(context, WATER_LAKE_UNDERGROUND, configuredFeatures.getOrThrow(AetherConfiguredFeatures.WATER_LAKE_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(15),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 16),
                SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -5),
                InSquarePlacement.spread(),
                BiomeFilter.biome());

        AncientAetherPlacementUtils.register(context, CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AetherConfiguredFeatures.CRYSTAL_ISLAND_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, WYNDCAPS_CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.CRYSTAL_ISLAND_FROZEN),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );
        AncientAetherPlacementUtils.register(context, ELEVATED_CRYSTAL_ISLAND, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.CRYSTAL_ISLAND_PALE),
                RarityFilter.onAverageOnceEvery(127),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(128)),
                InSquarePlacement.spread(),
                new DungeonBlacklistFilter(),
                BiomeFilter.biome()
        );

        AncientAetherPlacementUtils.register(context, BRONZE_DUNGEON_ENTRANCE, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.BRONZE_DUNGEON_ENTRANCE), BiomeFilter.biome());
    }
}