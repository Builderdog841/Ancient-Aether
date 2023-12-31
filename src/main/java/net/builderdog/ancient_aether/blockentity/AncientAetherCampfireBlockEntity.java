package net.builderdog.ancient_aether.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AncientAetherCampfireBlockEntity extends CampfireBlockEntity {
    public AncientAetherCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public @NotNull BlockEntityType<AncientAetherCampfireBlockEntity> getType() {
        return AncientAetherBlockEntityTypes.CAMPFIRE.get();
    }
}