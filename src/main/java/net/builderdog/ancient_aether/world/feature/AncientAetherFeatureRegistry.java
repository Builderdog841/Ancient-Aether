package net.builderdog.ancient_aether.world.feature;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AncientAether.MOD_ID);

    public static RegistryObject<Feature<CloudbedFeature.Config>> CLOUDBED = FEATURES.register("cloudbed", () -> new CloudbedFeature(CloudbedFeature.Config.CODEC));
}
