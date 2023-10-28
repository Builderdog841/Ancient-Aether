package net.builderdog.ancient_aether.block.building;

import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class DriftWeedBlock extends BushBlock {
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public DriftWeedBlock(Properties p_51021_) {
        super(p_51021_);
    }

    protected boolean mayPlaceOn(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return blockState.is(AncientAetherTags.Blocks.DRIFTWEED_PLACEABLE_ON);
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState p_57336_, @NotNull BlockGetter p_57337_, @NotNull BlockPos p_57338_, CollisionContext p_57339_) {
        return SHAPE;
    }
}
