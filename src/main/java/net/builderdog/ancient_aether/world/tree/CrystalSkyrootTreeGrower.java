package net.builderdog.ancient_aether.world.tree;

import net.builderdog.ancient_aether.data.generators.AncientAetherConfiguredFeatureData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalSkyrootTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource random, boolean largeHive) {
        return AncientAetherConfiguredFeatureData.CRYSTAL_SKYROOT_TREE;
    }
}
