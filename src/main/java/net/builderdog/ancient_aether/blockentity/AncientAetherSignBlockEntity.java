package net.builderdog.ancient_aether.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AncientAetherSignBlockEntity extends SignBlockEntity {
    public AncientAetherSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<AncientAetherSignBlockEntity> getType() {
        return AncientAetherBlockEntityTypes.SIGN.get();
    }
}