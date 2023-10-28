package net.builderdog.ancient_aether.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

public class WindBlowerBlock extends RedstoneLampBlock implements Equipable {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public WindBlowerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(LIT, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos()));
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    public void neighborChanged(@NotNull BlockState blockState, Level p_55667_, @NotNull BlockPos p_55668_, @NotNull Block p_55669_, @NotNull BlockPos p_55670_, boolean p_55671_) {
        if (!p_55667_.isClientSide) {
            boolean flag = blockState.getValue(LIT);
            if (flag != p_55667_.hasNeighborSignal(p_55668_)) {
                if (flag) {
                    p_55667_.scheduleTick(p_55668_, this, 4);
                } else {
                    p_55667_.setBlock(p_55668_, blockState.cycle(LIT), 2);
                }
            }
        }
    }

    public void tick(BlockState p_221937_, @NotNull ServerLevel p_221938_, @NotNull BlockPos p_221939_, RandomSource p_221940_) {
        if (p_221937_.getValue(LIT) && !p_221938_.hasNeighborSignal(p_221939_)) {
            p_221938_.setBlock(p_221939_, p_221937_.cycle(LIT), 2);
        }
    }

    public @NotNull BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(FACING).add(LIT);
    }

    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
