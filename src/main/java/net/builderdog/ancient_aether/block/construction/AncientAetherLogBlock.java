package net.builderdog.ancient_aether.block.construction;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.natural.AetherLogBlock;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class AncientAetherLogBlock extends AetherLogBlock {
    public AncientAetherLogBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, false));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(AncientAetherBlocks.HIGHSPROOT_LOG.get())) {
                return  AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(AncientAetherBlocks.HIGHSPROOT_WOOD.get())) {
                return  AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(AncientAetherBlocks.SAKURA_LOG.get())) {
                return  AncientAetherBlocks.STRIPPED_SAKURA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(AncientAetherBlocks.SAKURA_WOOD.get())) {
                return  AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
