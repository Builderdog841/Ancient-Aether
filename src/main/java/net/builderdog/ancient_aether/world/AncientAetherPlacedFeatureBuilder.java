package net.builderdog.ancient_aether.world;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AncientAetherPlacedFeatureBuilder {
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351);
    }

    private static List<PlacementModifier> VegetationPlacement(PlacementModifier count, PlacementModifier heightRange) {
        return List.of(count, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
}
