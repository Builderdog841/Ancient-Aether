package net.builderdog.aether_crystallium.worldgen.features;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.worldgen.configurations.LargeCactusConfiguration;
import net.builderdog.aether_crystallium.worldgen.features.aether_cactus.GiantCatusFeature;
import net.builderdog.aether_crystallium.worldgen.features.aether_cactus.LargeCatusFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AetherCrystallium.MOD_ID);

    public static RegistryObject<Feature<LargeCactusConfiguration>> LARGE_CACTUS = FEATURES.register("large_cactus", () -> new LargeCatusFeature(LargeCactusConfiguration.CODEC));

    public static RegistryObject<Feature<LargeCactusConfiguration>> GIANT_CACTUS = FEATURES.register("giant_cactus", () -> new GiantCatusFeature(LargeCactusConfiguration.CODEC));


}