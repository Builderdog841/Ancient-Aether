package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import com.aetherteam.aether.world.feature.AetherFeatures;
import com.aetherteam.aether.world.foliageplacer.CrystalFoliagePlacer;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.feature.CloudbedFeature;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherPineFoliagePlacer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.OptionalInt;

public class AncientAetherConfiguredFeatureData {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE = registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VALKYRUM_ORE = registerKey("valkyrum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AEROGEL_BLOBS = registerKey("aerogel_blobs");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVITY_GRAVEL_ORE = registerKey("gravity_gravel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_PINE_TREE = registerKey("skyroot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SKYROOT_TREE = registerKey("crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHSPROOT_PINE_TREE = registerKey("highsproot_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTED_HIGHSPROOT_TREE = registerKey("frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_FROSTED_HIGHSPROOT_TREE = registerKey("tall_frosted_highsproot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SAKURA_TREE = registerKey("tall_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_JUNGLE_TREE = registerKey("skyroot_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_SKYROOT_TREE = registerKey("divine_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_SKYROOT_TREE = registerKey("fancy_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CRYSTAL_SKYROOT_TREE = registerKey("fancy_crystal_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_DIVINE_SKYROOT_TREE = registerKey("fancy_divine_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_AERCLOUD = registerKey("crystal_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = registerKey("cloudbed");

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
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Ore Features
        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> aerogelOre = List.of(OreConfiguration.target(holystone, AetherBlocks.AEROGEL.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> gravityGravelOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.GRAVITY_GRAVEL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> valkyrumOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.VALKYRUM_ORE.get().defaultBlockState()));

        register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 6, 0f));
        register(context, GRAVITY_GRAVEL_ORE, Feature.ORE, new OreConfiguration(gravityGravelOre, 64, 0f));
        register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelOre, 32, 0f));
        register(context, VALKYRUM_ORE, Feature.ORE, new OreConfiguration(valkyrumOre, 6, 0.5f));

        //Tree Features
        register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        register(context, DIVINE_SKYROOT_TREE, Feature.TREE, createStraightSkyrootBlobTree(AncientAetherFeatureStates.DIVINE_SKYROOT_LEAVES).build());
        register(context, SKYROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 5).build());
        register(context, HIGHSPROOT_PINE_TREE, Feature.TREE, createAetherPineTree(AncientAetherFeatureStates.HIGHSPROOT_LOG, AncientAetherFeatureStates.HIGHSPROOT_LEAVES, 2).build());
        register(context, SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 7, 7).build());
        register(context, TALL_SAKURA_TREE, Feature.TREE, createSakuraJungleTree(AncientAetherFeatureStates.SAKURA_LOG, AncientAetherFeatureStates.SAKURA_LEAVES, 12, 10).build());
        register(context, SKYROOT_JUNGLE_TREE, Feature.TREE, createSakuraJungleTree(AetherFeatureStates.SKYROOT_LOG, AetherFeatureStates.SKYROOT_LEAVES, 7, 7).build());
        register(context, FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(6, 2, 8).build());
        register(context, TALL_FROSTED_HIGHSPROOT_TREE, Feature.TREE, createWyndcapsPineTree(8, 4, 16).build());
        register(context, FANCY_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AetherFeatureStates.SKYROOT_LEAVES).build());
        register(context, FANCY_CRYSTAL_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).build());
        register(context, FANCY_DIVINE_SKYROOT_TREE, Feature.TREE, createFancySkyrootTree(AncientAetherFeatureStates.DIVINE_SKYROOT_LEAVES).build());

        //Patch Features
        register(context, WYND_THISTLE_PATCH, Feature.FLOWER,
                NitrogenConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(AncientAetherBlocks.WYND_THISTLE.get().defaultBlockState(), 3)), 64));
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

        //Misc Features
        register(context, VIOLET_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.VIOLET_AERCLOUD));
        register(context, CRYSTAL_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.CRYSTAL_AERCLOUD));

        register(context, CLOUDBED, AncientAetherFeatures.CLOUDBED.get(),
                new CloudbedFeature.Config(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1D));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}