package net.builderdog.ancient_aether.world.feature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zepalesque.redux.Redux;
import net.zepalesque.redux.world.feature.config.*;

public class AncientAetherFeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Redux.MODID);

    public static RegistryObject<Feature<CloudLayerConfig>> CLOUDBED = FEATURES.register("cloud_layer", () -> new CloudbedFeature(CloudLayerConfig.CODEC));
}
