package net.builderdog.aether_crystallium.worldgen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.worldgen.configurations.LargeCactusConfiguration;
import net.builderdog.aether_crystallium.worldgen.features.ModFeatures;
import net.builderdog.aether_crystallium.worldgen.foliageplacer.HighlandsPineFoliagePlacer;
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
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLANDS_PINE_KEY = registerKey("highlands_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUNROOT_KEY = registerKey("sunroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOONLIT_TULIP_PATCH_KEY = registerKey("moonlit_tulip_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_AETHER_CACTUS_PATCH_KEY = registerKey("small_aether_cactus_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE_KEY = registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUICKSTONE_ORE_KEY = registerKey("quickstone_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest aetherIslandBlocks = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(aetherIslandBlocks,
                ModBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> quickstoneOre = List.of(OreConfiguration.target(aetherIslandBlocks,
                ModBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState()));

        register(context, HIGHLANDS_PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LOG.get()),
                        new StraightTrunkPlacer(5, 7, 3),
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LEAVES.get()),
                        new HighlandsPineFoliagePlacer(ConstantInt.of(1), ConstantInt.ZERO, ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SUNROOT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherBlocks.SKYROOT_LOG.get()),
                new StraightTrunkPlacer(5, 7, 3),
                BlockStateProvider.simple(ModBlocks.SUNROOT_LEAVES.get()),
                new HighlandsPineFoliagePlacer(ConstantInt.of(1), ConstantInt.ZERO, ConstantInt.of(1)),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, AETHER_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(aetherQuartzOre, 12, 0f));

        register(context, QUICKSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(quickstoneOre, 32, 0f));

        register(context, MOONLIT_TULIP_PATCH_KEY, Feature.FLOWER,
                AetherConfiguredFeatureBuilders.grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MOONLIT_TULIP.get().defaultBlockState(), 3)), 64));

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

