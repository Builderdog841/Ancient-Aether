package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherMiscFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class AncientAetherMiscPlacements {
    public static final ResourceKey<PlacedFeature> VIOLET_AERCLOUD = AncientAetherPlacementUtil.createKey("violet_aercloud");
    public static final ResourceKey<PlacedFeature> CLOUDBED = AncientAetherPlacementUtil.createKey("cloudbed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        AncientAetherPlacementUtil.register(context, VIOLET_AERCLOUD, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.VIOLET_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(32, 224, 24));
        AncientAetherPlacementUtil.register(context, CLOUDBED, configuredFeatures.getOrThrow(AncientAetherMiscFeatures.CLOUDBED), List.of());
    }
}
