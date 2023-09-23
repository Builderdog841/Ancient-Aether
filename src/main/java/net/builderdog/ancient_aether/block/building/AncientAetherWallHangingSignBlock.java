package net.builderdog.ancient_aether.block.building;

import net.builderdog.ancient_aether.blockentity.AncientAetherHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherWallHangingSignBlock extends WallHangingSignBlock {
    public AncientAetherWallHangingSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAetherHangingSignBlockEntity(pos, state);
    }
}