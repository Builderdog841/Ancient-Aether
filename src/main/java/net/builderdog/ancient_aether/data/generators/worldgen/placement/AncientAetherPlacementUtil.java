package net.builderdog.ancient_aether.data.generators.worldgen.placement;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherPlacementUtil {

    public static void bootstrap(BootstapContext<PlacedFeature> placedFeature) {
        AncientAetherOrePlacements.bootstrap(placedFeature);
        AncientAetherMiscPlacements.bootstrap(placedFeature);
    }

    static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    public static void register(BootstapContext<PlacedFeature> p_255872_, ResourceKey<PlacedFeature> p_255820_, Holder<ConfiguredFeature<?, ?>> p_255813_, List<PlacementModifier> p_256042_) {
        p_255872_.register(p_255820_, new PlacedFeature(p_255813_, List.copyOf(p_256042_)));
    }

    public static void register(BootstapContext<PlacedFeature> p_256241_, ResourceKey<PlacedFeature> p_256614_, Holder<ConfiguredFeature<?, ?>> p_255855_, PlacementModifier... p_256413_) {
        register(p_256241_, p_256614_, p_255855_, List.of(p_256413_));
    }
}