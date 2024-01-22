package net.builderdog.ancient_aether.block.utility;

import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.blockentity.AncientAetherCampfireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class AmbrosiumCampfireBlock extends CampfireBlock {
    public AmbrosiumCampfireBlock(boolean pSpawnParticles, int pFireDamage, BlockBehaviour.Properties pProperties) {
        super(pSpawnParticles, pFireDamage, pProperties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new AncientAetherCampfireBlockEntity(blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::particleTick) : null;
        } else {
            return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cookTick) : createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cooldownTick);
        }
    }
}