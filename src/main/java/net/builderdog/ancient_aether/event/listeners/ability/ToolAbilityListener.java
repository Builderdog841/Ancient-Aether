package net.builderdog.ancient_aether.event.listeners.ability;

import net.builderdog.ancient_aether.event.hooks.AbilityHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class ToolAbilityListener {

    public static void listen(IEventBus bus) {
        bus.addListener(ToolAbilityListener::setupToolModifications);
        bus.addListener(ToolAbilityListener::doDivineToolAbility);
        bus.addListener(ToolAbilityListener::modifyBreakSpeed);
    }

    public static void setupToolModifications(BlockEvent.BlockToolModificationEvent event) {
        BlockState oldState = event.getState();
        ToolAction toolAction = event.getToolAction();
        BlockState newState = AbilityHooks.ToolHooks.setupToolActions(oldState, toolAction);
        if (newState != oldState && !event.isSimulated() && !event.isCanceled()) {
            event.setFinalState(newState);
        }
    }

    public static void doDivineToolAbility(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = player.level();
        BlockPos blockPos = event.getPos();
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState = event.getState();
        if (!event.isCanceled()) {
            AbilityHooks.ToolHooks.handleDivineToolAbility(player, level, blockPos, itemStack, blockState);
        }
    }

    public static void modifyBreakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState blockState = event.getState();
        Player player = event.getEntity();
        ItemStack itemStack = player.getMainHandItem();
        if (!event.isCanceled()) {
            event.setNewSpeed(AbilityHooks.ToolHooks.reduceToolEffectiveness(player, blockState, itemStack, event.getNewSpeed()));
        }
    }
}