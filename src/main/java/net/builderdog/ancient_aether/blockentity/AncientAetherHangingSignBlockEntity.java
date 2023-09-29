package net.builderdog.ancient_aether.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AncientAetherHangingSignBlockEntity extends HangingSignBlockEntity {
    public AncientAetherHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public @NotNull BlockEntityType<AncientAetherHangingSignBlockEntity> getType() {
        return AncientAetherBlockEntityTypes.HANGING_SIGN.get();
    }
}