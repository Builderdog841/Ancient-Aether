package net.builderdog.ancient_aether.block.functional;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrystalSaplingBlock extends SaplingBlock {
    public CrystalSaplingBlock(AbstractTreeGrower abstractTreeGrower, Properties properties) {
        super(abstractTreeGrower, properties);
    }

    protected boolean mayPlaceOn(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return blockState.is(AncientAetherBlocks.DIVINE_GRAVEL.get());
    }
}
