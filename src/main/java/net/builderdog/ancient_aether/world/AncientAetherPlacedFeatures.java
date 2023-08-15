package net.builderdog.ancient_aether.world;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AETHER_QUARTZ_ORE_PLACED = createKey("aether_quartz_ore");
    public static final ResourceKey<PlacedFeature> AEROGEL_ORE_PLACED = createKey("aerogel_blobs");
    public static final ResourceKey<PlacedFeature> HIGHLAND_TULIP_PATCH = createKey("highland_tulip_patch");
    public static final ResourceKey<PlacedFeature> EDELWEISS_PATCH = createKey("edelweiss_patch");
    public static final ResourceKey<PlacedFeature> SAKURA_BLOSSOMS_PATCH = createKey("sakura_blossoms_patch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AETHER_QUARTZ_ORE_PLACED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AETHER_QUARTZ_ORE),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, AEROGEL_ORE_PLACED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AEROGEL_BLOBS),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, HIGHLAND_TULIP_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.HIGHLAND_TULIP_PATCH),
                RarityFilter.onAverageOnceEvery(8),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());

        register(context, SAKURA_BLOSSOMS_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.SAKURA_BLOSSOMS_PATCH),
                RarityFilter.onAverageOnceEvery(8),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());

        register(context, EDELWEISS_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.EDELWEISS_PATCH),
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
