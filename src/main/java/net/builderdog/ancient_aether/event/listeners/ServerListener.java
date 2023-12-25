package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.event.hooks.ServerHooks;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID)
public class ServerListener {
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        ServerHooks.cacheDatapacks(event.getServer());
    }
    @SubscribeEvent
    public static void onServerClosing(ServerStoppedEvent event) {
        ServerHooks.clearDatapacks();
    }
}
