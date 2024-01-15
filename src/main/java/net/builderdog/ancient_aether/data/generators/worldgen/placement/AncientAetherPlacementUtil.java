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

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}