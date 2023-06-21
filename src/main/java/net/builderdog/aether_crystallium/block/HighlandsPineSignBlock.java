package net.builderdog.aether_crystallium.block;

import net.builderdog.aether_crystallium.blockentity.HighlandsPineSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.entity.BlockEntity;

public class HighlandsPineSignBlock extends StandingSignBlock {
    public HighlandsPineSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HighlandsPineSignBlockEntity(pos, state);
    }
}