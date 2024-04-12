package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.network.AetherPacketHandler;
import com.aetherteam.aether.network.packet.clientbound.ToolDebuffPacket;
import com.aetherteam.nitrogen.network.PacketRelay;
import com.google.common.collect.ImmutableMap;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.equipment.armor.EquipmentUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

        public static boolean debuffTools;

        public static float reduceToolEffectiveness(Player player, BlockState state, ItemStack stack, float speed) {
            if (AetherConfig.SERVER.tools_debuff.get()) {
                if (!player.level().isClientSide()) {
                    debuffTools = true;
                    PacketRelay.sendToNear(AetherPacketHandler.INSTANCE, new ToolDebuffPacket(true), player.getX(), player.getY(), player.getZ(), 10, player.level().dimension());
                }
            }
            if (debuffTools) {
                if ((state.getBlock().getDescriptionId().startsWith("block.ancient_aether.") && !state.is(AetherTags.Blocks.TREATED_AS_VANILLA_BLOCK))) {
                    if (!stack.isEmpty() && stack.isCorrectToolForDrops(state) && !stack.getItem().getDescriptionId().startsWith("item.aether.") && !stack.is(AetherTags.Items.TREATED_AS_AETHER_ITEM)) {
                        speed = 1.0F;
                    }
                }
            }
            return speed;
        }
    }
}