package net.builderdog.ancient_aether.world;

import com.aetherteam.aether.data.resources.builders.AetherPlacedFeatureBuilders;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AETHER_QUARTZ_ORE = createKey("aether_quartz_ore");
    public static final ResourceKey<PlacedFeature> VALKYRUM_ORE = createKey("valkyrum_ore");
    public static final ResourceKey<PlacedFeature> AEROGEL_ORE = createKey("aerogel_blobs");
    public static final ResourceKey<PlacedFeature> GRAVITY_GRAVEL_ORE = createKey("gravity_gravel_ore");
    public static final ResourceKey<PlacedFeature> VIOLET_AERCLOUD = createKey("violet_aercloud");
    public static final ResourceKey<PlacedFeature> CRYSTAL_AERCLOUD = createKey("crystal_aercloud");
    public static final ResourceKey<PlacedFeature> CLOUDBED = createKey("cloudbed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Ore Features
        register(context, AETHER_QUARTZ_ORE, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AETHER_QUARTZ_ORE),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256))));
        register(context, VALKYRUM_ORE, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.VALKYRUM_ORE),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(64))));
        register(context, AEROGEL_ORE, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AEROGEL_BLOBS),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        register(context, GRAVITY_GRAVEL_ORE, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.GRAVITY_GRAVEL_ORE),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(1,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.absolute(80))));

        //Misc Features
        register(context, VIOLET_AERCLOUD, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.VIOLET_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(32, 224, 24));
        register(context, CRYSTAL_AERCLOUD, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.CRYSTAL_AERCLOUD), AetherPlacedFeatureBuilders.aercloudPlacement(16, 72, 25));
        register(context, CLOUDBED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.CLOUDBED), List.of());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
