package net.builderdog.ancient_aether.block.utility;

import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public class GravititeLauncherBlock extends Block {

    public static final BooleanProperty TRIGGERED = AncientAetherBlockStateProperties.TRIGGERED;

    public GravititeLauncherBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(TRIGGERED, Boolean.FALSE));
    }

    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        if (state.getValue(TRIGGERED)) {
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 1.5, entity.getDeltaMovement().z());
        }
    }
}