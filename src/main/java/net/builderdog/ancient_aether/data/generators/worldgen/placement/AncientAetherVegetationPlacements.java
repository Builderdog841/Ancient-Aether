package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.AetherConfig;
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

public class AncientAetherVegetationPlacements {
    public static final ResourceKey<PlacedFeature> AETHER_GRASS_BONEMEAL = AncientAetherPlacementUtils.createKey("aether_grass_bonemeal");
    public static final ResourceKey<PlacedFeature> AETHER_GRASS_PATCH = AncientAetherPlacementUtils.createKey("aether_grass_patch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtils.register(context, AETHER_GRASS_BONEMEAL, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.SINGLE_PIECE_OF_SKY_GRASS), PlacementUtils.isEmpty());

        AncientAetherPlacementUtils.register(context, AETHER_GRASS_PATCH, configuredFeatures.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH),
                NoiseThresholdCountPlacement.of(-0.8, 10, 20),
                ImprovedLayerPlacementModifier.of(Heightmap.Types.MOTION_BLOCKING, UniformInt.of(0, 1), 4),
                BiomeFilter.biome(),
                new ConfigFilter(AetherConfig.SERVER.generate_tall_grass));
    }
}