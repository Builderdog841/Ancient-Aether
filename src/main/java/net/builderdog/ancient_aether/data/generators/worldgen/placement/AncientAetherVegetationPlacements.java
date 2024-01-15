package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.world.placementmodifier.DungeonBlacklistFilter;
import com.aetherteam.aether.world.placementmodifier.ImprovedLayerPlacementModifier;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherOreFeatures;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherTreeFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherVegetationPlacements {
    public static final ResourceKey<PlacedFeature> GOLDEN_SKYROOT_GROVE_TREES = AncientAetherPlacementUtil.createKey("golden_skyroot_grove_trees");
    public static final ResourceKey<PlacedFeature> CRYSTAL_SKYROOT_GROVE_TREES = AncientAetherPlacementUtil.createKey("crystal_skyroot_grove_trees");
    public static final ResourceKey<PlacedFeature> GOLDEN_SKYROOT_FOREST_TREES = AncientAetherPlacementUtil.createKey("golden_skyroot_forest_trees");
    public static final ResourceKey<PlacedFeature> CRYSTAL_SKYROOT_FOREST_TREES = AncientAetherPlacementUtil.createKey("crystal_skyroot_forest_trees");
    public static final ResourceKey<PlacedFeature> GOLDEN_THICKET_TREES = AncientAetherPlacementUtil.createKey("golden_thicket_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_TAIGA_TREES = AncientAetherPlacementUtil.createKey("wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> FESTIVE_WYNDCAP_TAIGA_TREES = AncientAetherPlacementUtil.createKey("festive_wyndcap_taiga_trees");
    public static final ResourceKey<PlacedFeature> WYNDCAP_HIGHLAND_TREES = AncientAetherPlacementUtil.createKey("wyndcap_highland_trees");
    public static final ResourceKey<PlacedFeature> SKYROOT_JUNGLE_TREES = AncientAetherPlacementUtil.createKey("skyroot_jungle_trees");
    public static final ResourceKey<PlacedFeature> SAKURA_JUNGLE_TREES = AncientAetherPlacementUtil.createKey("sakura_jungle_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_FOREST_TREES = AncientAetherPlacementUtil.createKey("elevated_forest_trees");
    public static final ResourceKey<PlacedFeature> ELEVATED_CLEARING_TREES = AncientAetherPlacementUtil.createKey("elevated_clearing_trees");

    private static List<PlacementModifier> treePlacement(PlacementModifier count) {
        return treePlacementBase(count).build();
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier count) {
        return ImmutableList.<PlacementModifier>builder()
                .add(count)
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(ImprovedLayerPlacementModifier.of(Heightmap.Types.OCEAN_FLOOR, UniformInt.of(0, 1), 4))
                .add(BiomeFilter.biome())
                .add(new DungeonBlacklistFilter());
    }
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtil.register(context, GOLDEN_SKYROOT_GROVE_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(3, 0.1F, 2)));
        AncientAetherPlacementUtil.register(context, CRYSTAL_SKYROOT_GROVE_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(3, 0.1F, 2)));
        AncientAetherPlacementUtil.register(context, GOLDEN_SKYROOT_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(8, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, CRYSTAL_SKYROOT_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(8, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, GOLDEN_THICKET_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(9, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, FESTIVE_WYNDCAP_TAIGA_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(9, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, WYNDCAP_HIGHLAND_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(RarityFilter.onAverageOnceEvery(3)));
        AncientAetherPlacementUtil.register(context, SKYROOT_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(12, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, SAKURA_JUNGLE_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(12, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, ELEVATED_FOREST_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
        AncientAetherPlacementUtil.register(context, ELEVATED_CLEARING_TREES, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                treePlacement(RarityFilter.onAverageOnceEvery(3)));
    }
}
