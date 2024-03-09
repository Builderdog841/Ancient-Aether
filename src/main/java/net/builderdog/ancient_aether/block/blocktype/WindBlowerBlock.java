package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.entity.projectile.ZephyrSnowball;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
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

@SuppressWarnings("deprecation")
public class WindBlowerBlock extends Block implements Equipable {
    public static final BooleanProperty CHARGED = AncientAetherBlockStateProperties.CHARGED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public WindBlowerBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(CHARGED, false).setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(CHARGED, context.getLevel().hasNeighborSignal(context.getClickedPos())).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos neighborPos, boolean bool) {
        boolean flag = state.getValue(CHARGED);
        if (!level.isClientSide) {
            if (flag != level.hasNeighborSignal(pos)) {
                if (flag) {
                    level.scheduleTick(pos, this, 4);
                } else level.setBlock(pos, state.cycle(CHARGED), 2);
            }
        }
        if (flag && level.hasNeighborSignal(pos)) {
            Direction direction = state.getValue(FACING);
            ZephyrSnowball blow = new ZephyrSnowball(AetherEntityTypes.ZEPHYR_SNOWBALL.get(), level);
            blow.setPos(
                    pos.getX() + 0.7D * (double) direction.getStepX(),
                    pos.getY() + 0.7D * (double) direction.getStepY(),
                    pos.getZ() + 0.7D * (double) direction.getStepZ());
            blow.shoot(direction.getStepX(), direction.getStepY(), direction.getStepZ(), 1.1F, 0.0F);
            level.addFreshEntity(blow);
        }
    }

    public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(CHARGED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(CHARGED), 2);
        }
    }

    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CHARGED);
    }
}