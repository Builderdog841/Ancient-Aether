package net.builderdog.ancient_aether.world;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherPineFoliagePlacer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class AncientAetherConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_TREE = registerKey("highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_PINE_TREE = registerKey("highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTED_HIGHSPROOT_TREE = registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_FROSTED_HIGHSPROOT_TREE = registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRIFT_WEED_PATCH = registerKey("drift_weed_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE = registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AEROGEL_BLOBS = registerKey("aerogel_blobs");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERAL_DIRT_ORE = registerKey("etheral_dirt_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone,
                AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));

        List<OreConfiguration.TargetBlockState> aerogelOre = List.of(OreConfiguration.target(holystone,
                AetherBlocks.AEROGEL.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> etheralDirtOre = List.of(OreConfiguration.target(holystone,
                AncientAetherBlocks.ETHERAL_DIRT.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));

        register(context, HIGHSPROOT_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());

        register(context, HIGHSPROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());

        register(context, SKYROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(5, 5, 0),
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES),
                        new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());

        register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 6, 0f));

        register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelOre, 32, 0f));

        register(context, ETHERAL_DIRT_ORE, Feature.ORE, new OreConfiguration(etheralDirtOre, 64, 0f));

        register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.WYND_THISTLE.get().defaultBlockState(), 3)), 64));

        register(context, DRIFT_WEED_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.DRIFT_WEED.get().defaultBlockState(), 3)), 32));

        register(context, HIGHLAND_VIOLA_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.HIGHLAND_VIOLA.get().defaultBlockState(), 3)), 64));

        register(context, SKY_BLUES_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SKY_BLUES.get().defaultBlockState(), 3)), 64));

        register(context, SAKURA_BLOSSOMS_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SAKURA_BLOSSOMS.get().defaultBlockState(), 12)
                        .add(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get().defaultBlockState(), 3)), 64));

    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

