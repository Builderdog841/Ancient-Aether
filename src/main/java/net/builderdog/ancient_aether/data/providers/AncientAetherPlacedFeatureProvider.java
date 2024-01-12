package net.builderdog.ancient_aether.data.providers;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class AncientAetherPlacedFeatureProvider {
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier placementModifier) {
        return List.of(p_195347_, InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(p_195344_), placementModifier);
    }
}
