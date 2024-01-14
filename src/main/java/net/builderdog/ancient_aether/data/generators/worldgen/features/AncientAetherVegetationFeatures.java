package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class AncientAetherVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = AncientAetherFeatureUtil.registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = AncientAetherFeatureUtil.registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = AncientAetherFeatureUtil.registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = AncientAetherFeatureUtil.registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("frozen_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("jungle_aether_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_AETHER_GRASS_PATCH = AncientAetherFeatureUtil.registerKey("pale_aether_grass_patch");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientAetherFeatureUtil.register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.WYND_THISTLE.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, HIGHLAND_VIOLA_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.HIGHLAND_VIOLA.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SKY_BLUES.get().defaultBlockState(), 3)),
                        64));
        AncientAetherFeatureUtil.register(context, SAKURA_BLOSSOMS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SAKURA_BLOSSOMS.get().defaultBlockState(), 12)
                        .add(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get().defaultBlockState(), 3)),
                        64));

        AncientAetherFeatureUtil.register(context, AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT, 1)
                        .add(AncientAetherFeatureStates.SKY_GRASS_SHORT, 2)
                        .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 3)),
                        64));
        AncientAetherFeatureUtil.register(context, FROZEN_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_FROZEN, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_FROZEN, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM_FROZEN, 2)),
                        64));
        AncientAetherFeatureUtil.register(context, JUNGLE_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_MEDIUM, 1)
                                .add(AncientAetherFeatureStates.SKY_GRASS_TALL, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_TALL, 3)),
                        64));
        AncientAetherFeatureUtil.register(context, PALE_AETHER_GRASS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(AncientAetherFeatureStates.SKY_GRASS_VERY_SHORT_PALE, 2)
                                .add(AncientAetherFeatureStates.SKY_GRASS_SHORT_PALE, 1)),
                        64));
    }
}