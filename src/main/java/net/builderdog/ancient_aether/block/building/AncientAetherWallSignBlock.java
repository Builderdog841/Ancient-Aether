package net.builderdog.ancient_aether.block.building;

import net.builderdog.ancient_aether.blockentity.AncientAetherSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherWallSignBlock extends WallSignBlock {
    public AncientAetherWallSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAetherSignBlockEntity(pos, state);
    }
}