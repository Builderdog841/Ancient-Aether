package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.feature.CloudbedFeature;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.List;

public class AncientAetherMiscFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_QUICKSOIL = AncientAetherFeatureUtils.registerKey("coast_quicksoil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_GRAVITY_GRAVEL = AncientAetherFeatureUtils.registerKey("coast_gravity_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_WYND_ICE = AncientAetherFeatureUtils.registerKey("coast_wynd_ice");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_LEAF_VINE = AncientAetherFeatureUtils.registerKey("skyroot_leaf_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_SKYROOT_LEAF_VINE = AncientAetherFeatureUtils.registerKey("short_skyroot_leaf_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = AncientAetherFeatureUtils.registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = AncientAetherFeatureUtils.registerKey("cloudbed");

    private static BlockColumnConfiguration createSkyrootLeafVine(int length) {
        return new BlockColumnConfiguration(List.of(
                BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                        .add(UniformInt.of(1, length), 2)
                        .add(UniformInt.of(1, 2), 3)
                        .add(UniformInt.of(1, 6), 10)
                        .build()), BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES.setValue(BlockStateProperties.PERSISTENT, true)))),
                Direction.DOWN,
                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                true);
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //AncientAetherFeatureUtils.register(context, COAST_QUICKSOIL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AetherFeatureStates.QUICKSOIL), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
        AncientAetherFeatureUtils.register(context, COAST_GRAVITY_GRAVEL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AncientAetherFeatureStates.GRAVITY_GRAVEL), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
        AncientAetherFeatureUtils.register(context, COAST_WYND_ICE, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(AncientAetherTags.Blocks.COAST_REPLACEABLE, BlockStateProvider.simple(AncientAetherFeatureStates.WYND_ICE), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AncientAetherVegetationFeatures.AETHER_GRASS_PATCH)), CaveSurface.FLOOR, ConstantInt.of(2), 0.0F, 1, 0.0F, UniformInt.of(16, 16), 0.0F));
        AncientAetherFeatureUtils.register(context, SKYROOT_LEAF_VINE, Feature.BLOCK_COLUMN, createSkyrootLeafVine(12));
        AncientAetherFeatureUtils.register(context, SHORT_SKYROOT_LEAF_VINE, Feature.BLOCK_COLUMN, createSkyrootLeafVine(4));
        AncientAetherFeatureUtils.register(context, VIOLET_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(16, AncientAetherFeatureStates.VIOLET_AERCLOUD));
        AncientAetherFeatureUtils.register(context, CLOUDBED, AncientAetherFeatures.CLOUDBED.get(), new CloudbedFeature.Config(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1D));
    }
}