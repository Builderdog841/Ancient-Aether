package net.builderdog.ancient_aether.block;

import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SkyrootThornBushBlock extends DeadBushBlock {
        public SkyrootThornBushBlock(BlockBehaviour.Properties properties) {
            super(properties);
        }
    public void entityInside(BlockState p_51148_, Level p_51149_, BlockPos p_51150_, Entity p_51151_) {
        p_51151_.hurt(p_51149_.damageSources().cactus(), 1.0F);
    }

    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.is(AncientAetherTags.Blocks.QUICKSOIL_DESERT_SURFACE_BLOCKS);
    }
}
