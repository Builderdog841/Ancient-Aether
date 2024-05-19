package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.blockentity.AncientHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class AncientWallHangingSignBlock extends WallHangingSignBlock {
    public AncientWallHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new AncientHangingSignBlockEntity(pos, state);
    }
}