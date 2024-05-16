package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.ItemHooks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

public class ItemListener {

    public static void listen(IEventBus bus) {
        bus.addListener(EventPriority.LOW, ItemListener::onTooltipAdd);
    }

    public static void onTooltipAdd(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        List<Component> itemTooltips = event.getToolTip();
        ItemHooks.addTooltips(itemTooltips, itemStack);
    }
}