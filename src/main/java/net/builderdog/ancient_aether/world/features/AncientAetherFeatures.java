package net.builderdog.ancient_aether.world.features;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.configurations.LargeCactusConfiguration;
import net.builderdog.ancient_aether.world.features.aether_cactus.GiantCactusFeature;
import net.builderdog.ancient_aether.world.features.aether_cactus.GoldenLargeCactusFeature;
import net.builderdog.ancient_aether.world.features.aether_cactus.LargeCactusFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AncientAether.MOD_ID);
    public static RegistryObject<Feature<LargeCactusConfiguration>> LARGE_CACTUS = FEATURES.register("large_cactus", () -> new LargeCactusFeature(LargeCactusConfiguration.CODEC));
    public static RegistryObject<Feature<LargeCactusConfiguration>> GOLDEN_LARGE_CACTUS = FEATURES.register("golden_large_cactus", () -> new GoldenLargeCactusFeature(LargeCactusConfiguration.CODEC));
    public static RegistryObject<Feature<LargeCactusConfiguration>> GIANT_CACTUS = FEATURES.register("giant_cactus", () -> new GiantCactusFeature(LargeCactusConfiguration.CODEC));

}

