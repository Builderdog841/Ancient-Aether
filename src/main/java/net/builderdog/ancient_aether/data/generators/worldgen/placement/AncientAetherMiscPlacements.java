package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherMiscFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
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
    public static final ResourceKey<PlacedFeature> VIOLET_AERCLOUD = AncientAetherPlacementUtils.createKey("violet_aercloud");
    public static final ResourceKey<PlacedFeature> CLOUDBED = AncientAetherPlacementUtils.createKey("cloudbed");
    public static final ResourceKey<PlacedFeature> WATER_LAKE_UNDERGROUND = AncientAetherPlacementUtils.createKey("water_lake_underground");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        AncientAetherPlacementUtils.register(context, VIOLET_AERCLOUD, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.VIOLET_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(32, 224, 24));
        AncientAetherPlacementUtils.register(context, CLOUDBED, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.CLOUDBED), List.of());

        AncientAetherPlacementUtils.register(context, WATER_LAKE_UNDERGROUND, configuredFeatures.getOrThrow(AetherConfiguredFeatures.WATER_LAKE_CONFIGURATION),
                RarityFilter.onAverageOnceEvery(15),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 16),
                SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -5),
                BiomeFilter.biome());

        AncientAetherPlacementUtils.register(context, QUICKSOIL_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_QUICKSOIL),
                PlacementUtils.countExtra(20, 0.1F, 1),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(110), VerticalAnchor.absolute(115)),
                InSquarePlacement.spread(),
                BiomeFilter.biome());
        AncientAetherPlacementUtils.register(context, GRAVITY_GRAVEL_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_GRAVITY_GRAVEL),
                PlacementUtils.countExtra(20, 0.1F, 1),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(120), VerticalAnchor.absolute(125)),
                InSquarePlacement.spread(),
                BiomeFilter.biome());
        AncientAetherPlacementUtils.register(context, WYND_ICE_COAST, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.COAST_WYND_ICE),
                PlacementUtils.countExtra(20, 0.1F, 1),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(110), VerticalAnchor.absolute(115)),
                InSquarePlacement.spread(),
                BiomeFilter.biome());
    }
}