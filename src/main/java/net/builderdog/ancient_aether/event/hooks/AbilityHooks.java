package net.builderdog.ancient_aether.event.hooks;

import com.google.common.collect.ImmutableMap;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.equipment.armor.EquipmentUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Map;

public class AbilityHooks {
    public static class ArmorHooks {

        public static boolean fallCancellation(LivingEntity entity) {
            return EquipmentUtil.hasFullValkyrumSet(entity);
        }
    }

    public static class ToolHooks {
        public static final Map<Block, Block> STRIPPABLES = (new ImmutableMap.Builder<Block, Block>())
                .put(AncientAetherBlocks.HIGHSPROOT_LOG.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get())
                .put(AncientAetherBlocks.SAKURA_LOG.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get())
                .put(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get())
                .put(AncientAetherBlocks.SAKURA_WOOD.get(), AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get())
                .put(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get())
                .put(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get())
                .put(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get())
                .put(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get())
                .build();

        public static BlockState setupToolActions(BlockState old, ToolAction action) {
            Block oldBlock = old.getBlock();
            if (action == ToolActions.AXE_STRIP) {
                if (STRIPPABLES.containsKey(oldBlock)) {
                    return STRIPPABLES.get(oldBlock).withPropertiesOf(old);
                }
            }
            return old;
        }
    }
}