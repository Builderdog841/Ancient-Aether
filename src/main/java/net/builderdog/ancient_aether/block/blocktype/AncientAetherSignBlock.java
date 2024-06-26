package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.blockentity.AncientAetherSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class AncientAetherSignBlock extends StandingSignBlock {
    public AncientAetherSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new AncientAetherSignBlockEntity(pos, state);
    }
}