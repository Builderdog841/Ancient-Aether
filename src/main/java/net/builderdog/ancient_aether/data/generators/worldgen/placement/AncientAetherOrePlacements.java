package net.builderdog.ancient_aether.data.generators.worldgen.placement;

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
    public static final ResourceKey<PlacedFeature> AETHER_QUARTZ_ORE = AncientAetherPlacementUtils.createKey("aether_quartz_ore");
    public static final ResourceKey<PlacedFeature> VALKYRUM_ORE = AncientAetherPlacementUtils.createKey("valkyrum_ore");
    public static final ResourceKey<PlacedFeature> AEROGEL_ORE = AncientAetherPlacementUtils.createKey("aerogel_blobs");
    public static final ResourceKey<PlacedFeature> GRAVITY_GRAVEL_ORE = AncientAetherPlacementUtils.createKey("gravity_gravel_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtils.register(context, AETHER_QUARTZ_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AETHER_QUARTZ_ORE),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256))));
        AncientAetherPlacementUtils.register(context, VALKYRUM_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.VALKYRUM_ORE),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(15,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(64))));
        AncientAetherPlacementUtils.register(context, AEROGEL_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.AEROGEL_BLOBS),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        AncientAetherPlacementUtils.register(context, GRAVITY_GRAVEL_ORE, configuredFeatures.getOrThrow(AncientAetherOreFeatures.GRAVITY_GRAVEL_ORE),
                NitrogenPlacedFeatureBuilders.commonOrePlacement(1,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.absolute(80))));
    }
}
