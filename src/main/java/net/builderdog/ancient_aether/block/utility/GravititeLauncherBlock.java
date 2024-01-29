package net.builderdog.ancient_aether.block.utility;

import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GravititeLauncherBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty TRIGGERED = AncientAetherBlockStateProperties.TRIGGERED;

    public GravititeLauncherBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(TRIGGERED, Boolean.FALSE));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(TRIGGERED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, BlockState state, @NotNull Entity entity) {
        if (state.getValue(TRIGGERED)) {
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 1.5, entity.getDeltaMovement().z());
        }
    }

    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos thisPos, @NotNull Block block, @NotNull BlockPos neighbourPos, boolean p_55671_) {
        if (!level.isClientSide) {
            boolean flag = state.getValue(TRIGGERED);
            if (flag != level.hasNeighborSignal(thisPos)) {
                if (flag) {
                    level.scheduleTick(thisPos, this, 4);
                } else {
                    level.setBlock(thisPos, state.cycle(TRIGGERED), 2);
                }
            }
        }
    }

    public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(TRIGGERED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(TRIGGERED), 2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(TRIGGERED);
    }

    public @NotNull BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }
    public @NotNull BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }
}