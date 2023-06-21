package net.builderdog.aether_crystallium.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class HighlandsPineSignBlockEntity extends SignBlockEntity {
    public HighlandsPineSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<HighlandsPineSignBlockEntity> getType()
    {
        return ModBlockEntityTypes.HIGHLANDS_PINE_SIGN.get();
    }
}