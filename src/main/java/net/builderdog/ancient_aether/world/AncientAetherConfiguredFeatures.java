package net.builderdog.ancient_aether.world;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_HIGHSPROOT_PINE_TREE = registerKey("small_highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_PINE_TREE = registerKey("highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_TULIP_PATCH = registerKey("highland_tulip_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EDELWEISS_PATCH = registerKey("edelweiss_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE = registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AEROGEL_BLOBS = registerKey("aerogel_blobs");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone,
                AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));

        List<OreConfiguration.TargetBlockState> aerogelOre = List.of(OreConfiguration.target(holystone,
                AetherBlocks.AEROGEL.get().defaultBlockState()));

        register(context, HIGHSPROOT_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());

        register(context, SMALL_HIGHSPROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());

        register(context, HIGHSPROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)),
                        new StraightTrunkPlacer(5, 10, 0),
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

        register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 12, 0f));

        register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelOre, 64, 0f));

        register(context, HIGHLAND_TULIP_PATCH, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.HIGHLAND_TULIP.get().defaultBlockState(), 3)), 64));

        register(context, EDELWEISS_PATCH, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.EDELWEISS.get().defaultBlockState(), 3)), 64));

        register(context, SAKURA_BLOSSOMS_PATCH, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.SAKURA_BLOSSOMS.get().defaultBlockState(), 12)
                        .add(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get().defaultBlockState(), 3)), 64));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}

