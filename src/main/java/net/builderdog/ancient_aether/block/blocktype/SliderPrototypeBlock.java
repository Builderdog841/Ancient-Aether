package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class SliderPrototypeBlock extends HorizontalFacingBlock {
    public static final BooleanProperty CRITICAL = AncientAetherBlockStateProperties.CRITICAL;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public SliderPrototypeBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(CRITICAL, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(CRITICAL, context.getLevel().hasNeighborSignal(context.getClickedPos())).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos neighborPos, boolean bool) {
        if (!level.isClientSide) {
            boolean flag = state.getValue(CRITICAL);
            if (flag != level.hasNeighborSignal(pos)) {
                if (flag) {
                    level.scheduleTick(pos, this, 4);
                } else {
                    level.setBlock(pos, state.cycle(CRITICAL), 2);
                }
            }
        }
    }

    public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(CRITICAL) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(CRITICAL), 2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CRITICAL, FACING);
    }
}