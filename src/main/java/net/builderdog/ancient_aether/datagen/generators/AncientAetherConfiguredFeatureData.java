package net.builderdog.ancient_aether.datagen.generators;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import com.aetherteam.nitrogen.data.resources.builders.NitrogenConfiguredFeatureBuilders;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.feature.CloudbedFeature;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherPineFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

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
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_SKYROOT_TREE = registerKey("divine_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_DIVINE_SKYROOT = registerKey("fancy_divine_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_THISTLE_PATCH = registerKey("wynd_thistle_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLAND_VIOLA_PATCH = registerKey("highland_viola_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_BLOSSOMS_PATCH = registerKey("sakura_blossoms_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_BLUES_PATCH = registerKey("sky_blues_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_AERCLOUD = registerKey("crystal_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = registerKey("cloudbed");

    private static TreeConfiguration.TreeConfigurationBuilder createStraightSkyrootBlobTree(BlockState p_195148_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createCrystalSkyroot() {
        return createStraightSkyrootBlobTree(AncientAetherFeatureStates.CRYSTAL_SKYROOT_LEAVES).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createDivineSkyroot() {
        return createStraightSkyrootBlobTree(AncientAetherFeatureStates.DIVINE_SKYROOT_LEAVES).ignoreVines();
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);

        //Ore Features
        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> aerogelOre = List.of(OreConfiguration.target(holystone, AetherBlocks.AEROGEL.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> gravityGravelOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.GRAVITY_GRAVEL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> valkyrumOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.VALKYRUM_ORE.get().defaultBlockState()));

        register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 6, 0f));
        register(context, GRAVITY_GRAVEL_ORE, Feature.ORE, new OreConfiguration(gravityGravelOre, 64, 0f));
        register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelOre, 32, 0f));
        register(context, VALKYRUM_ORE, Feature.ORE, new OreConfiguration(valkyrumOre, 6, 0.5f));

        register(context, CLOUDBED, AncientAetherFeatures.CLOUDBED.get(),
                new CloudbedFeature.Config(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1D));

        //Tree Features
        register(context, SKYROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(5, 5, 0),
                        BlockStateProvider.simple(AncientAetherFeatureStates.SKYROOT_PINE_LEAVES),
                        new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());
        register(context, CRYSTAL_SKYROOT_TREE, Feature.TREE, createCrystalSkyroot().build());
        register(context, DIVINE_SKYROOT_TREE, Feature.TREE, createDivineSkyroot().build());
        register(context, HIGHSPROOT_PINE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherFeatureStates.HIGHSPROOT_LOG),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.simple(AncientAetherFeatureStates.HIGHSPROOT_LEAVES),
                        new AncientAetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());
        register(context, SAKURA_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AncientAetherFeatureStates.SAKURA_LOG),
                        new CherryTrunkPlacer(7, 7, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 3), UniformInt.of(-6, -4), UniformInt.of(-1, 0)),
                        BlockStateProvider.simple(AncientAetherFeatureStates.SAKURA_LEAVES),
                        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.25F, 0.16666667F, 0.66666667F),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).ignoreVines().build());

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
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}