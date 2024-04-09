package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.projectile.WindBlow;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class WindBlowerBlock extends Block implements Equipable {
    public static final BooleanProperty PUFFED = AncientAetherBlockStateProperties.PUFFED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public WindBlowerBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(PUFFED, false).setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(PUFFED, context.getLevel().hasNeighborSignal(context.getClickedPos())).setValue(FACING, context.getHorizontalDirection().getOpposite());
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

    public void neighborChanged(BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos neighborPos, boolean bool) {
        boolean flag = state.getValue(PUFFED);
        if (!level.isClientSide) {
            if (flag != level.hasNeighborSignal(pos)) {
                if (flag) {
                    level.scheduleTick(pos, this, 4);
                } else level.setBlock(pos, state.cycle(PUFFED), 2);
            }
            if (!flag && level.hasNeighborSignal(pos)) {
                shoot(state, level, pos);
            }
        }
    }

    @Override
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState state, BlockHitResult hitResult, Projectile projectile) {
        BlockPos pos = hitResult.getBlockPos();
        if (projectile.getType().is(AncientAetherTags.Entities.ACTIVATES_WIND_BLOWER) && !state.getValue(PUFFED)) {
            shoot(state, level, pos);
        }
    }

    public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(PUFFED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(PUFFED), 2);
        }
    }

    public void shoot(BlockState state, Level level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        WindBlow wind = new WindBlow(AncientAetherEntityTypes.WIND_BLOW.get(), level);
        wind.setPos(pos.getX() + 0.5, pos.getY() + 0.25, pos.getZ() + 0.5);
        wind.shoot(direction.getStepX(), direction.getStepY(), direction.getStepZ(), 1.0F, 0.0F);
        level.addFreshEntity(wind);
        level.setBlock(pos, state.cycle(PUFFED), 2);
        level.scheduleTick(pos, this, 4);
    }

    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PUFFED);
    }
}