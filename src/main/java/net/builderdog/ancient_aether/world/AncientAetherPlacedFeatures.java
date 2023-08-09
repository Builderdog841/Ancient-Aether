package net.builderdog.ancient_aether.world;

import com.aetherteam.aether.world.placementmodifier.DungeonBlacklistFilter;
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
    public static final ResourceKey<PlacedFeature> QUICKSTONE_ORE_PLACED = createKey("quickstone_blobs");
    public static final ResourceKey<PlacedFeature> AEROGEL_ORE_PLACED = createKey("aerogel_blobs");
    public static final ResourceKey<PlacedFeature> MOONLIT_TULIP_PATCH = createKey("moonlit_tulip_patch");
    public static final ResourceKey<PlacedFeature> EDELWEISS_PATCH = createKey("edelweiss_patch");
    public static final ResourceKey<PlacedFeature> SAKURA_BLOSSOMS_PATCH = createKey("sakura_blossoms_patch");
    public static final ResourceKey<PlacedFeature> SMALL_AETHER_CACTUS_PATCH = createKey("small_aether_cactus_patch");
    public static final ResourceKey<PlacedFeature> SKYROOT_THORN_BUSH_PATCH = createKey("skyroot_thorn_bush_patch");
    public static final ResourceKey<PlacedFeature> AETHER_CACTUS_PATCH = createKey("aether_cactus_patch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AETHER_QUARTZ_ORE_PLACED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AETHER_QUARTZ_ORE),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, QUICKSTONE_ORE_PLACED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.QUICKSTONE_BLOBS),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, AEROGEL_ORE_PLACED, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AEROGEL_BLOBS),
                AncientAetherPlacedFeatureBuilder.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, MOONLIT_TULIP_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.MOONLIT_TULIP_PATCH),
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

        register(context, SMALL_AETHER_CACTUS_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.SMALL_AETHER_CACTUS_PATCH),
                RarityFilter.onAverageOnceEvery(2),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome());

        register(context, AETHER_CACTUS_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.AETHER_CACTUS_PLACEMENT),
                CountPlacement.of(2),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome(),
                new DungeonBlacklistFilter());

        register(context, SKYROOT_THORN_BUSH_PATCH, configuredFeatures.getOrThrow(AncientAetherConfiguredFeatures.SKYROOT_THORN_BUSH_PATCH),
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome(),
                new DungeonBlacklistFilter());
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
