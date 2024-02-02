package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenPlacedFeatureBuilders;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherOreFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class AncientAetherOrePlacements {
    public static final ResourceKey<PlacedFeature> AEROGEL_BLOBS = AncientAetherPlacementUtils.createKey("aerogel_blobs");
    public static final ResourceKey<PlacedFeature> WYND_ICE_BLOBS = AncientAetherPlacementUtils.createKey("wynd_ice_blobs");
    public static final ResourceKey<PlacedFeature> AETHER_QUARTZ_ORE = AncientAetherPlacementUtils.createKey("aether_quartz_ore");
    public static final ResourceKey<PlacedFeature> VALKYRUM_ORE = AncientAetherPlacementUtils.createKey("valkyrum_ore");
    public static final ResourceKey<PlacedFeature> BONUS_AMBROSIUM_ORE = AncientAetherPlacementUtils.createKey("bonus_ambrosium_ore");
    public static final ResourceKey<PlacedFeature> BONUS_GRAVITITE_ORE = AncientAetherPlacementUtils.createKey("bonus_gravitite_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtils.register(context, AEROGEL_BLOBS, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AEROGEL_BLOBS),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        AncientAetherPlacementUtils.register(context, WYND_ICE_BLOBS, configuredFeatures.getOrThrow(AncientAetherOreFeatures.WYND_ICE_BLOBS),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(1,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(112))));
        AncientAetherPlacementUtils.register(context, AETHER_QUARTZ_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256))));
        AncientAetherPlacementUtils.register(context, VALKYRUM_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.VALKYRUM_ORE),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(15,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(64))));
        AncientAetherPlacementUtils.register(context, BONUS_AMBROSIUM_ORE, configuredFeatures.getOrThrow(AetherConfiguredFeatures.ORE_AMBROSIUM_CONFIGURATION),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(96))));
        AncientAetherPlacementUtils.register(context, BONUS_GRAVITITE_ORE, configuredFeatures.getOrThrow(AetherConfiguredFeatures.ORE_GRAVITITE_BURIED_CONFIGURATION),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(256))));
    }
}