package net.builderdog.ancient_aether.block.building;

import net.builderdog.ancient_aether.blockentity.AncientAetherHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public AncientAetherCeilingHangingSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAetherHangingSignBlockEntity(pos, state);
    }
}