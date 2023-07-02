package net.builderdog.aether_crystallium.world.features;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.world.configurations.LargeCactusConfiguration;
import net.builderdog.aether_crystallium.world.features.aether_cactus.GiantCactusFeature;
import net.builderdog.aether_crystallium.world.features.aether_cactus.LargeCactusFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AetherCrystallium.MOD_ID);

    public static RegistryObject<Feature<LargeCactusConfiguration>> LARGE_CACTUS = FEATURES.register("large_cactus", () -> new LargeCactusFeature(LargeCactusConfiguration.CODEC));

    public static RegistryObject<Feature<LargeCactusConfiguration>> GIANT_CACTUS = FEATURES.register("giant_cactus", () -> new GiantCactusFeature(LargeCactusConfiguration.CODEC));
}