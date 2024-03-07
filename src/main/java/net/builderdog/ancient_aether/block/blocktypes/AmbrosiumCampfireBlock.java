package net.builderdog.ancient_aether.block.blocktypes;

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
    public AmbrosiumCampfireBlock(boolean spawnParticles, int fireDamage, BlockBehaviour.Properties properties) {
        super(spawnParticles, fireDamage, properties);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new AncientAetherCampfireBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::particleTick) : null;
        } else {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cookTick) : createTickerHelper(blockEntityType, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cooldownTick);
        }
    }
}