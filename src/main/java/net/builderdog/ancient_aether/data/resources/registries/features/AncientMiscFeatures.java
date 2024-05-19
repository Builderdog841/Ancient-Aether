package net.builderdog.ancient_aether.data.resources.registries.features;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.resources.AncientFeatureStates;
import net.builderdog.ancient_aether.data.resources.builders.AncientFeatureBuilders;
import net.builderdog.ancient_aether.world.feature.AncientFeatures;
import net.builderdog.ancient_aether.world.feature.configuration.CloudbedConfiguration;
import net.builderdog.ancient_aether.world.feature.configuration.CrystalIslandConfiguration;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class AncientMiscFeatures extends AncientFeatureBuilders {
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_QUICKSOIL = AncientFeatureUtils.registerKey("coast_quicksoil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_GRAVITY_GRAVEL = AncientFeatureUtils.registerKey("coast_gravity_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAST_WYND_ICE = AncientFeatureUtils.registerKey("coast_wynd_ice");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYROOT_LEAF_VINE = AncientFeatureUtils.registerKey("skyroot_leaf_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_SKYROOT_LEAF_VINE = AncientFeatureUtils.registerKey("short_skyroot_leaf_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLET_AERCLOUD = AncientFeatureUtils.registerKey("violet_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUDBED = AncientFeatureUtils.registerKey("cloudbed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_ISLAND_FROZEN = AncientFeatureUtils.registerKey("crystal_island_frozen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_ISLAND_PALE = AncientFeatureUtils.registerKey("crystal_island_pale");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRONZE_DUNGEON_ENTRANCE = AncientFeatureUtils.registerKey("bronze_dungeon_entrance");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        AncientFeatureUtils.register(context, COAST_QUICKSOIL, AncientFeatures.COAST.get(), createCoast(AetherFeatureStates.QUICKSOIL, 96, 128));
        AncientFeatureUtils.register(context, COAST_GRAVITY_GRAVEL, AncientFeatures.COAST.get(), createCoast(AncientFeatureStates.GRAVITY_GRAVEL, 112, 144));
        AncientFeatureUtils.register(context, COAST_WYND_ICE, AncientFeatures.COAST.get(), createCoast(AncientBlocks.WYND_ICE.get().defaultBlockState(), 96, 128));
        AncientFeatureUtils.register(context, SKYROOT_LEAF_VINE, Feature.BLOCK_COLUMN, createSkyrootLeafVine(12));
        AncientFeatureUtils.register(context, SHORT_SKYROOT_LEAF_VINE, Feature.BLOCK_COLUMN, createSkyrootLeafVine(4));
        AncientFeatureUtils.register(context, VIOLET_AERCLOUD, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(8, AncientFeatureStates.VIOLET_AERCLOUD));
        AncientFeatureUtils.register(context, CLOUDBED, AncientFeatures.CLOUDBED.get(), new CloudbedConfiguration(BlockStateProvider.simple(AetherFeatureStates.COLD_AERCLOUD), 80, 1.0D, 64L, 96L, 6.0F, 6.0F));
        AncientFeatureUtils.register(context, CRYSTAL_ISLAND_FROZEN, AncientFeatures.CONFIGURABLE_CRYSTAL_ISLAND.get(), new CrystalIslandConfiguration(new ResourceLocation(Aether.MODID, "crystal_tree"), AncientFeatureStates.FROZEN_AETHER_GRASS_BLOCK, AetherFeatureStates.HOLYSTONE));
        AncientFeatureUtils.register(context, CRYSTAL_ISLAND_PALE, AncientFeatures.CONFIGURABLE_CRYSTAL_ISLAND.get(), new CrystalIslandConfiguration(new ResourceLocation(Aether.MODID, "crystal_tree"), AncientFeatureStates.PALE_AETHER_GRASS_BLOCK, AetherFeatureStates.HOLYSTONE));
        AncientFeatureUtils.register(context, BRONZE_DUNGEON_ENTRANCE, AncientFeatures.DUNGEON_ENTRANCE.get());
    }
}