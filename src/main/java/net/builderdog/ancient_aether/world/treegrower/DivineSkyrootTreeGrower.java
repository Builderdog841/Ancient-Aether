package net.builderdog.ancient_aether.world.treegrower;

import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class DivineSkyrootTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
        return random.nextInt(10) == 0 ? AncientAetherTreeFeatures.FANCY_DIVINE_SKYROOT_TREE : AncientAetherTreeFeatures.DIVINE_SKYROOT_TREE;
    }
}