package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.HolidayFoliagePlacer;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.data.resources.AncientFeatureStates;
import net.builderdog.ancient_aether.data.resources.builders.AncientFeatureBuilders;
import net.builderdog.ancient_aether.world.tree.decorator.GrapeVineDecorator;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class AncientTreeFeatures extends AncientFeatureBuilders {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_TREE_VINED = AncientFeatureUtils.registerKey("skyroot_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = AncientFeatureUtils.registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE_VINED = AncientFeatureUtils.registerKey("skyroot_pine_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = AncientFeatureUtils.registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_TREE = AncientFeatureUtils.registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_HIGHSPROOT_TREE = AncientFeatureUtils.registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = AncientFeatureUtils.registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = AncientFeatureUtils.registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = AncientFeatureUtils.registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE_VINED = AncientFeatureUtils.registerKey("skyroot_jungle_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_SKYROOT_TREE = AncientFeatureUtils.registerKey("enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = AncientFeatureUtils.registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE_VINED = AncientFeatureUtils.registerKey("fancy_skyroot_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ENCHANTED_SKYROOT_TREE = AncientFeatureUtils.registerKey("fancy_enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_HOLIDAY_TREE = AncientFeatureUtils.registerKey("wyndcaps_holiday_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientFeatureUtils.register(context, SKYROOT_TREE_VINED, Feature.TREE, createStraightSkyrootBlobTree(AetherFeatureStates.SKYROOT_LEAVES).decorators(ImmutableList.of(new GrapeVineDecorator(AncientFeatureStates.GRAPE_VINE))).build());
        AncientFeatureUtils.register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientFeatureUtils.register(context, ENCHANTED_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientFeatureUtils.register(context, SKYROOT_PINE_TREE, Feature.TREE, createSkyrootPineTree().build());
        AncientFeatureUtils.register(context, SKYROOT_PINE_TREE_VINED, Feature.TREE, createSkyrootPineTree().decorators(ImmutableList.of(new GrapeVineDecorator(AncientFeatureStates.GRAPE_VINE))).build());
        AncientFeatureUtils.register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        AncientFeatureUtils.register(context, FANCY_SKYROOT_TREE_VINED, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).decorators(ImmutableList.of(new GrapeVineDecorator(AncientFeatureStates.GRAPE_VINE))).build());
        AncientFeatureUtils.register(context, FANCY_ENCHANTED_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientFeatureUtils.register(context, HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(6, 2, 8).build());
        AncientFeatureUtils.register(context, TALL_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(8, 4, 16).build());
        AncientFeatureUtils.register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        AncientFeatureUtils.register(context, SKYROOT_JUNGLE_TREE_VINED, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).decorators(ImmutableList.of(new GrapeVineDecorator(AncientFeatureStates.GRAPE_VINE))).build());
        AncientFeatureUtils.register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientFeatureStates.SAKURA_LOG, AncientFeatureStates.SAKURA_LEAVES, 7, 7).build());
        AncientFeatureUtils.register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientFeatureStates.SAKURA_LOG, AncientFeatureStates.SAKURA_LEAVES, 12, 10).build());

        AncientFeatureUtils.register(context, WYNDCAPS_HOLIDAY_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(9, 0, 0),
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.HOLIDAY_LEAVES, 4).add(AetherFeatureStates.DECORATED_HOLIDAY_LEAVES, 1).build()),
                        new HolidayFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(8)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
    }
}