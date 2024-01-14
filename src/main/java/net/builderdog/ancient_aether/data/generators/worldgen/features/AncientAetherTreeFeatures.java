package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.CrystalFoliagePlacer;
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
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AncientAetherTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = AncientAetherConfiguredFeatureData.registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_PINE_TREE = AncientAetherConfiguredFeatureData.registerKey("highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTED_HIGHSPROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_FROSTED_HIGHSPROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = AncientAetherConfiguredFeatureData.registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = AncientAetherConfiguredFeatureData.registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = AncientAetherConfiguredFeatureData.registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_SKYROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("divine_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CRYSTAL_SKYROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("fancy_crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_DIVINE_SKYROOT_TREE = AncientAetherConfiguredFeatureData.registerKey("fancy_divine_skyroot_tree");

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
        AncientAetherConfiguredFeatureData.register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherConfiguredFeatureData.register(context, DIVINE_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.DIVINE_SKYROOT_LEAVES).build());
        AncientAetherConfiguredFeatureData.register(context, SKYROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 5).build());
        AncientAetherConfiguredFeatureData.register(context, HIGHSPROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AncientAetherFeatureStates.HIGHSPROOT_LOG, AncientAetherFeatureStates.HIGHSPROOT_LEAVES, 2).build());
        AncientAetherConfiguredFeatureData.register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 7, 7).build());
        AncientAetherConfiguredFeatureData.register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 12, 10).build());
        AncientAetherConfiguredFeatureData.register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        AncientAetherConfiguredFeatureData.register(context, FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(6, 2, 8).build());
        AncientAetherConfiguredFeatureData.register(context, TALL_FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(8, 4, 16).build());
        AncientAetherConfiguredFeatureData.register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        AncientAetherConfiguredFeatureData.register(context, FANCY_CRYSTAL_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherConfiguredFeatureData.register(context, FANCY_DIVINE_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.DIVINE_SKYROOT_LEAVES).build());
    }
}