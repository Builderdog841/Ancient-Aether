package net.builderdog.ancient_aether.event.listeners;

import com.aetherteam.aether.AetherConfig;
import net.builderdog.ancient_aether.AncientConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

public class ServerListener {

    public static void listen(IEventBus bus) {
        bus.addListener(ServerListener::serverSetup);
    }

    public static void serverSetup(ServerAboutToStartEvent event) {
        if (AncientConfig.SERVER.server_config_overrides.get()) {
            AetherConfig.SERVER.disable_eternal_day.set(true);
        }
    }
}