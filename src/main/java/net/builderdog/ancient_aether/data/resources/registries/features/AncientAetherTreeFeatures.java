package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.HolidayFoliagePlacer;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.builders.AncientAetherFeatureBuilders;
import net.builderdog.ancient_aether.world.treedecorator.GrapeVineDecorator;
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

public class AncientAetherTreeFeatures extends AncientAetherFeatureBuilders {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_TREE_VINED = AncientAetherFeatureUtils.registerKey("skyroot_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = AncientAetherFeatureUtils.registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE_VINED = AncientAetherFeatureUtils.registerKey("skyroot_pine_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_TREE = AncientAetherFeatureUtils.registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_HIGHSPROOT_TREE = AncientAetherFeatureUtils.registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = AncientAetherFeatureUtils.registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = AncientAetherFeatureUtils.registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = AncientAetherFeatureUtils.registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE_VINED = AncientAetherFeatureUtils.registerKey("skyroot_jungle_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE_VINED = AncientAetherFeatureUtils.registerKey("fancy_skyroot_tree_vined");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ENCHANTED_SKYROOT_TREE = AncientAetherFeatureUtils.registerKey("fancy_enchanted_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYNDCAPS_HOLIDAY_TREE = AncientAetherFeatureUtils.registerKey("wyndcaps_holiday_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientAetherFeatureUtils.register(context, SKYROOT_TREE_VINED, Feature.TREE, createStraightSkyrootBlobTree(AetherFeatureStates.SKYROOT_LEAVES).decorators(ImmutableList.of(new GrapeVineDecorator(AncientAetherFeatureStates.GRAPE_VINE))).build());
        AncientAetherFeatureUtils.register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, ENCHANTED_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, SKYROOT_PINE_TREE, Feature.TREE, createSkyrootPineTree().build());
        AncientAetherFeatureUtils.register(context, SKYROOT_PINE_TREE_VINED, Feature.TREE, createSkyrootPineTree().decorators(ImmutableList.of(new GrapeVineDecorator(AncientAetherFeatureStates.GRAPE_VINE))).build());
        AncientAetherFeatureUtils.register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, FANCY_SKYROOT_TREE_VINED, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).decorators(ImmutableList.of(new GrapeVineDecorator(AncientAetherFeatureStates.GRAPE_VINE))).build());
        AncientAetherFeatureUtils.register(context, FANCY_ENCHANTED_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.ENCHANTED_SKYROOT_LEAVES).build());
        AncientAetherFeatureUtils.register(context, HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(15, 0, 4).build());
        AncientAetherFeatureUtils.register(context, TALL_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(18, 0, 5).build());
        AncientAetherFeatureUtils.register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        AncientAetherFeatureUtils.register(context, SKYROOT_JUNGLE_TREE_VINED, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).decorators(ImmutableList.of(new GrapeVineDecorator(AncientAetherFeatureStates.GRAPE_VINE))).build());
        AncientAetherFeatureUtils.register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 7, 7).build());
        AncientAetherFeatureUtils.register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 12, 10).build());

        AncientAetherFeatureUtils.register(context, WYNDCAPS_HOLIDAY_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(9, 0, 0),
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AetherFeatureStates.HOLIDAY_LEAVES, 4).add(AetherFeatureStates.DECORATED_HOLIDAY_LEAVES, 1).build()),
                        new HolidayFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(8)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines().build());
    }
}