package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.CrystalFoliagePlacer;
import com.aetherteam.aether.world.foliageplacer.GoldenOakFoliagePlacer;
import com.aetherteam.aether.world.foliageplacer.HolidayFoliagePlacer;
import com.aetherteam.aether.world.trunkplacer.GoldenOakTrunkPlacer;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherPineFoliagePlacer;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AncientAetherTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = AncientAetherFeatureUtil.registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = AncientAetherFeatureUtil.registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_PINE_TREE = AncientAetherFeatureUtil.registerKey("highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTED_HIGHSPROOT_TREE = AncientAetherFeatureUtil.registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_FROSTED_HIGHSPROOT_TREE = AncientAetherFeatureUtil.registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = AncientAetherFeatureUtil.registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = AncientAetherFeatureUtil.registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = AncientAetherFeatureUtil.registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtil.registerKey("enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = AncientAetherFeatureUtil.registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CRYSTAL_SKYROOT_TREE = AncientAetherFeatureUtil.registerKey("fancy_crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtil.registerKey("fancy_enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_HOLIDAY_TREE = AncientAetherFeatureUtil.registerKey("wyndcaps_holiday_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_JUNGLE_BUSH = AncientAetherFeatureUtil.registerKey("sakura_jungle_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUPER_GOLDEN_OAK_TREE = AncientAetherFeatureUtil.registerKey("super_golden_oak_tree");

    private static TreeConfiguration.TreeConfigurationBuilder createStraightSkyrootBlobTree(BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancySkyrootTree(BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAetherPineTree(BlockState log, BlockState leaves, int heightRandA) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new StraightTrunkPlacer(5, heightRandA, 0), BlockStateProvider.simple(leaves),
                new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createWyndcapsPineTree(int baseHeight, int heightRandA, int trunkHeight) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AncientAetherFeatureStates.HIGHSPROOT_LOG),
                new StraightTrunkPlacer(baseHeight, heightRandA, 1),
                BlockStateProvider.simple(AncientAetherFeatureStates.FROSTED_HIGHSPROOT_LEAVES),
                new CrystalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(trunkHeight)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSakuraJungleTree(BlockState log, BlockState leaves, int baseHeight, int heightRandA) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new CherryTrunkPlacer(baseHeight, heightRandA, 0,
                new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 3), UniformInt.of(-6, -4), UniformInt.of(-1, 0)),
                BlockStateProvider.simple(leaves),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.25F, 0.16666667F, 0.66666667F),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines();
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientAetherFeatureUtil.register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtil.register(context, ENCHANTED_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtil.register(context, SKYROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AetherFeatureStates.SKYROOT_LOG, AncientAetherFeatureStates.SKYROOT_PINE_LEAVES, 5).build());
        AncientAetherFeatureUtil.register(context, HIGHSPROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AncientAetherFeatureStates.HIGHSPROOT_LOG, AncientAetherFeatureStates.HIGHSPROOT_LEAVES, 2).build());
        AncientAetherFeatureUtil.register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 7, 7).build());
        AncientAetherFeatureUtil.register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 12, 10).build());
        AncientAetherFeatureUtil.register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        AncientAetherFeatureUtil.register(context, FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(6, 2, 8).build());
        AncientAetherFeatureUtil.register(context, TALL_FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(8, 4, 16).build());
        AncientAetherFeatureUtil.register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        AncientAetherFeatureUtil.register(context, FANCY_CRYSTAL_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtil.register(context, FANCY_ENCHANTED_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtil.register(context, WYNDCAPS_HOLIDAY_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(9, 0, 0),
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.HOLIDAY_LEAVES, 4).add(AetherFeatureStates.DECORATED_HOLIDAY_LEAVES, 1).build()),
                        new HolidayFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(8)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
        AncientAetherFeatureUtil.register(context, SAKURA_JUNGLE_BUSH, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0))
                        .ignoreVines().build());
        AncientAetherFeatureUtil.register(context, SUPER_GOLDEN_OAK_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.GOLDEN_OAK_LOG, 3).add(AetherFeatureStates.SKYROOT_LOG, 2).build()),
                        new StraightTrunkPlacer(12, 16, 0),
                        BlockStateProvider.simple(AetherFeatureStates.GOLDEN_OAK_LEAVES),
                        new GoldenOakFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(7)),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(10))
                ).ignoreVines().build());
    }
}