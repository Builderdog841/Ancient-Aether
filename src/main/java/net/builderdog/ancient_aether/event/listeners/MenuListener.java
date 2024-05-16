package net.builderdog.ancient_aether.event.listeners;

import com.aetherteam.cumulus.client.CumulusClient;
import net.builderdog.ancient_aether.event.hooks.MenuHooks;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ScreenEvent;

public class MenuListener {

    public static void listen(IEventBus bus) {
        bus.addListener(EventPriority.HIGHEST, MenuListener::onGuiOpenHighest);
    }

    public static void onGuiOpenHighest(ScreenEvent.Opening event) {
        MenuHooks.prepareCustomMenus(CumulusClient.MENU_HELPER);
    }
}