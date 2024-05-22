package net.builderdog.ancient_aether.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AncientAetherSignBlockEntity extends SignBlockEntity {
    public AncientAetherSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public @NotNull BlockEntityType<AncientAetherSignBlockEntity> getType() {
        return AncientAetherBlockEntityTypes.SIGN.get();
    }
}