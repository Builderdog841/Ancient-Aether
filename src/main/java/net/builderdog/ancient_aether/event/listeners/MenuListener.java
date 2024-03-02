package net.builderdog.ancient_aether.event.listeners;

import com.aetherteam.cumulus.client.CumulusClient;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.event.hooks.MenuHooks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, value = Dist.CLIENT)
public class MenuListener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onGuiOpenHighest(ScreenEvent.Opening event) {
        MenuHooks.prepareCustomMenus(CumulusClient.MENU_HELPER);
    }
}