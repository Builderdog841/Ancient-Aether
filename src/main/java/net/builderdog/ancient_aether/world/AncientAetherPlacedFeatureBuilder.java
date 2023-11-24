package net.builderdog.ancient_aether.world;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherPlacedFeatureBuilder {
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier placementModifier) {
        return List.of(p_195347_, InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(p_195344_), placementModifier);
    }
}
