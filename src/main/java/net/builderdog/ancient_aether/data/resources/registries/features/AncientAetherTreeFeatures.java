package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.GoldenOakFoliagePlacer;
import com.aetherteam.aether.world.foliageplacer.HolidayFoliagePlacer;
import net.builderdog.ancient_aether.data.providers.AncientAetherFeatureProvider;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.foliageplacer.PineFoliagePlacer;
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

import java.util.OptionalInt;

public class AncientAetherTreeFeatures extends AncientAetherFeatureProvider {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = AncientAetherFeatureUtils.registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_TREE = AncientAetherFeatureUtils.registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_HIGHSPROOT_TREE = AncientAetherFeatureUtils.registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = AncientAetherFeatureUtils.registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = AncientAetherFeatureUtils.registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = AncientAetherFeatureUtils.registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CRYSTAL_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("fancy_crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("fancy_enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_HOLIDAY_TREE = AncientAetherFeatureUtils.registerKey("wyndcaps_holiday_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUPER_GOLDEN_OAK_TREE = AncientAetherFeatureUtils.registerKey("super_golden_oak_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientAetherFeatureUtils.register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, ENCHANTED_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, SKYROOT_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                new StraightTrunkPlacer(5, 5, 0), BlockStateProvider.simple(AncientAetherFeatureStates.SKYROOT_PINE_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines().build());
        AncientAetherFeatureUtils.register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 7, 7).build());
        AncientAetherFeatureUtils.register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 12, 10).build());
        AncientAetherFeatureUtils.register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        AncientAetherFeatureUtils.register(context, HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(6, 2, 8).build());
        AncientAetherFeatureUtils.register(context, TALL_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(8, 4, 16).build());
        AncientAetherFeatureUtils.register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, FANCY_CRYSTAL_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, FANCY_ENCHANTED_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, WYNDCAPS_HOLIDAY_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(9, 0, 0),
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.HOLIDAY_LEAVES, 4).add(AetherFeatureStates.DECORATED_HOLIDAY_LEAVES, 1).build()),
                        new HolidayFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(8)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
        AncientAetherFeatureUtils.register(context, SUPER_GOLDEN_OAK_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.GOLDEN_OAK_LOG, 3).add(AetherFeatureStates.SKYROOT_LOG, 2).build()),
                        new StraightTrunkPlacer(10, 6, 0),
                        BlockStateProvider.simple(AetherFeatureStates.GOLDEN_OAK_LEAVES),
                        new GoldenOakFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(7)),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(10))
                ).ignoreVines().build());
    }
}