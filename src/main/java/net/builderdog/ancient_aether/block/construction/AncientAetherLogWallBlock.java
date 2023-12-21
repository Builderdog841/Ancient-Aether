package net.builderdog.ancient_aether.block.construction;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;


public class AncientAetherLogWallBlock extends WallBlock {
    public AncientAetherLogWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get())) {
                return  AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get().defaultBlockState()
                        .setValue(EAST_WALL, state.getValue(EAST_WALL)).setValue(WEST_WALL, state.getValue(WEST_WALL)).setValue(NORTH_WALL, state.getValue(NORTH_WALL)).setValue(SOUTH_WALL, state.getValue(SOUTH_WALL))
                        .setValue(UP, state.getValue(UP)).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
            if(state.is(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get())) {
                return  AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get().defaultBlockState()
                        .setValue(EAST_WALL, state.getValue(EAST_WALL)).setValue(WEST_WALL, state.getValue(WEST_WALL)).setValue(NORTH_WALL, state.getValue(NORTH_WALL)).setValue(SOUTH_WALL, state.getValue(SOUTH_WALL))
                        .setValue(UP, state.getValue(UP)).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
            if(state.is(AncientAetherBlocks.SAKURA_LOG_WALL.get())) {
                return  AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get().defaultBlockState()
                        .setValue(EAST_WALL, state.getValue(EAST_WALL)).setValue(WEST_WALL, state.getValue(WEST_WALL)).setValue(NORTH_WALL, state.getValue(NORTH_WALL)).setValue(SOUTH_WALL, state.getValue(SOUTH_WALL))
                        .setValue(UP, state.getValue(UP)).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
            if(state.is(AncientAetherBlocks.SAKURA_WOOD_WALL.get())) {
                return  AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get().defaultBlockState()
                        .setValue(EAST_WALL, state.getValue(EAST_WALL)).setValue(WEST_WALL, state.getValue(WEST_WALL)).setValue(NORTH_WALL, state.getValue(NORTH_WALL)).setValue(SOUTH_WALL, state.getValue(SOUTH_WALL))
                        .setValue(UP, state.getValue(UP)).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}