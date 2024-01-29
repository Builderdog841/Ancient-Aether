package net.builderdog.ancient_aether.block.dungeon;

import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SentryLauncherBlock extends Block {
    public static final BooleanProperty TRIGGERED = AncientAetherBlockStateProperties.TRIGGERED;

    public SentryLauncherBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(TRIGGERED, Boolean.FALSE));
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return defaultBlockState().setValue(TRIGGERED, false);
    }

    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 1.5, entity.getDeltaMovement().z());
            defaultBlockState().setValue(TRIGGERED, true);
    }

    public void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(TRIGGERED)) {
            level.setBlock(pos, state.cycle(TRIGGERED), 4);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
    }
}