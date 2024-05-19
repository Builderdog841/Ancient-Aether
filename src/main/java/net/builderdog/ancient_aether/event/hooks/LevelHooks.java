package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.data.resources.registries.AetherConfiguredFeatures;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class LevelHooks {
    public static ResourceKey<ConfiguredFeature<?, ?>> modifyGrownSapling(RandomSource random, Holder<ConfiguredFeature<?, ?>> feature) {
        if (feature != null) {
            if (feature.is(AetherConfiguredFeatures.SKYROOT_TREE_CONFIGURATION)) {
                if (random.nextInt(10) == 0) {
                    return AncientTreeFeatures.FANCY_SKYROOT_TREE;
                }
            }
        }
        return null;
    }
}