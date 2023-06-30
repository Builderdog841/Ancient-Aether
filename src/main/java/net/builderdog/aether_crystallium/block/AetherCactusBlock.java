package net.builderdog.aether_crystallium.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class AetherCactusBlock extends Block {

    public AetherCactusBlock(BlockBehaviour.Properties p_54800_) {
        super(p_54800_);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
        p_153780_.hurt(p_153777_.damageSources().cactus(), 1.0F);
        super.stepOn(p_153777_, p_153778_, p_153779_, p_153780_);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.AETHER_CACTUS.get())) {
                return ModBlocks.STRIPPED_AETHER_CACTUS.get().defaultBlockState();
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}

