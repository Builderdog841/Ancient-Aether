package net.builderdog.ancient_aether.world.feature;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.feature.configuration.CloudbedConfiguration;
import net.builderdog.ancient_aether.world.feature.configuration.CoastConfiguration;
import net.builderdog.ancient_aether.world.feature.configuration.CrystalIslandConfiguration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, AncientAether.MODID);

    public static DeferredHolder<Feature<?>, Feature<SimpleBlockConfiguration>> SKY_GRASS = FEATURES.register("sky_grass", () -> new SkyGrassFeature(SimpleBlockConfiguration.CODEC));
    public static DeferredHolder<Feature<?>, Feature<CoastConfiguration>> COAST = FEATURES.register("coast", () -> new CoastFeature(CoastConfiguration.CODEC));
    public static DeferredHolder<Feature<?>, Feature<CrystalIslandConfiguration>> CONFIGURABLE_CRYSTAL_ISLAND = FEATURES.register("configurable_crystal_island", () -> new ConfigurableCrystalIslandFeature(CrystalIslandConfiguration.CODEC));
    public static DeferredHolder<Feature<?>, Feature<CloudbedConfiguration>> CLOUDBED = FEATURES.register("cloudbed", () -> new CloudbedFeature(CloudbedConfiguration.CODEC));
    public static DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DUNGEON_ENTRANCE = FEATURES.register("dungeon_entrance", () -> new DungeonEntranceFeature(NoneFeatureConfiguration.CODEC));
}