package net.builderdog.ancient_aether.world.feature;

import net.builderdog.ancient_aether.world.configuration.CoastConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES;
    public static RegistryObject<Feature<CoastConfiguration>> COAST;

    public AncientAetherFeatures() {
    }

    static {
        FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, "ancient_aether");
        COAST = FEATURES.register("coast", () -> {
            return new CoastFeature(CoastConfiguration.CODEC);
        });
    }
}
