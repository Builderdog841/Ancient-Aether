package net.builderdog.ancient_aether.event.listeners;

import com.aetherteam.cumulus.client.CumulusClient;
import net.builderdog.ancient_aether.event.hooks.MenuHooks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
        modid = "aether",
        value = {Dist.CLIENT}
)
public class MenuListener {
    public MenuListener() {
    }

    @SubscribeEvent(
            priority = EventPriority.HIGHEST
    )
    public static void onGuiOpenHighest(ScreenEvent.Opening event) {
        MenuHooks.prepareCustomMenus(CumulusClient.MENU_HELPER);
    }
}
