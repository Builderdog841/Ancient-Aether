package net.builderdog.aether_crystallium.world;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.world.configurations.LargeCactusConfiguration;
import net.builderdog.aether_crystallium.world.features.ModFeatures;
import net.builderdog.aether_crystallium.world.foliageplacer.CrystalliumHookedFoliagePlacer;
import net.builderdog.aether_crystallium.world.foliageplacer.CrystalliumPineFoliagePlacer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLANDS_PINE_KEY = registerKey("highlands_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_KEY = registerKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOONLIT_TULIP_PATCH_KEY = registerKey("moonlit_tulip_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EDELWEISS_PATCH_KEY = registerKey("edelweiss_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_AETHER_CACTUS_PATCH_KEY = registerKey("small_aether_cactus_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE_KEY = registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUICKSTONE_ORE_KEY = registerKey("quickstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_CACTUS_KEY = registerKey("large_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_CACTUS_KEY = registerKey("giant_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_CACTUS_PLACEMENT = registerKey("aether_cactus_placement");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest aetherIslandBlocks = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(aetherIslandBlocks,
                ModBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> quickstoneOre = List.of(OreConfiguration.target(aetherIslandBlocks,
                ModBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState()));

        register(context, HIGHLANDS_PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LOG.get()),
                        new StraightTrunkPlacer(5, 7, 3),
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LEAVES.get()),
                        new CrystalliumPineFoliagePlacer(ConstantInt.of(1), ConstantInt.ZERO, ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SAKURA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SAKURA_LOG.get()),
                new StraightTrunkPlacer(5, 7, 3),
                BlockStateProvider.simple(ModBlocks.SAKURA_LEAVES.get()),
                new CrystalliumHookedFoliagePlacer(ConstantInt.of(1), ConstantInt.ZERO, ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, AETHER_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(aetherQuartzOre, 12, 0f));

        register(context, QUICKSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(quickstoneOre, 32, 0f));

        register(context, MOONLIT_TULIP_PATCH_KEY, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MOONLIT_TULIP.get().defaultBlockState(), 3)), 64));

        register(context, EDELWEISS_PATCH_KEY, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.EDELWEISS.get().defaultBlockState(), 3)), 64));

        register(context, SMALL_AETHER_CACTUS_PATCH_KEY, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.SMALL_AETHER_CACTUS.get().defaultBlockState(), 3)), 64));

        register(context, LARGE_CACTUS_KEY, ModFeatures.LARGE_CACTUS.get(),
                new LargeCactusConfiguration(
                        SimpleStateProvider.simple(ModBlocks.AETHER_CACTUS.get())));

        register(context, GIANT_CACTUS_KEY, ModFeatures.GIANT_CACTUS.get(),
                new LargeCactusConfiguration(
                        SimpleStateProvider.simple(ModBlocks.AETHER_CACTUS.get())));

        register(context, AETHER_CACTUS_PLACEMENT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(LARGE_CACTUS_KEY), PlacementUtils.filteredByBlockSurvival(ModBlocks.SMALL_AETHER_CACTUS.get())), 0.50F)),
                PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(GIANT_CACTUS_KEY), PlacementUtils.filteredByBlockSurvival(ModBlocks.SMALL_AETHER_CACTUS.get()))));

    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AetherCrystallium.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}

