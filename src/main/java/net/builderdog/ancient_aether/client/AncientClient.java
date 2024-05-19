package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.AncientConfig;
import net.builderdog.ancient_aether.block.AncientBlockSets;
import net.builderdog.ancient_aether.client.event.listeners.HandRenderListener;
import net.builderdog.ancient_aether.client.gui.AncientMenus;
import net.builderdog.ancient_aether.client.particle.AncientParticleTypes;
import net.builderdog.ancient_aether.client.renderer.AncientRenderers;
import net.minecraft.client.renderer.Sheets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import teamrazor.aeroblender.AeroBlenderConfig;

public class AncientClient {

    public static void clientInit(IEventBus bus) {
        bus.addListener(AncientClient::clientSetup);

        AncientMenus.MENUS.register(bus);
        AncientClient.eventSetup(bus);
    }

    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            AncientRenderers.registerCuriosRenderers();
            Sheets.addWoodType(AncientBlockSets.HIGHSPROOT);
            Sheets.addWoodType(AncientBlockSets.SAKURA);

            if (AncientConfig.CLIENT.config_overrides.get()) {
                AetherConfig.CLIENT.enable_aether_menu_button.set(false);
                AetherConfig.CLIENT.enable_aether_menu_button.save();
                CumulusConfig.CLIENT.enable_menu_list_button.set(true);
                CumulusConfig.CLIENT.enable_menu_list_button.save();
                AetherConfig.COMMON.add_ruined_portal_automatically.set(true);
                AetherConfig.COMMON.add_ruined_portal_automatically.save();
                AetherConfig.COMMON.add_temporary_freezing_automatically.set(true);
                AetherConfig.COMMON.add_temporary_freezing_automatically.save();
                AeroBlenderConfig.COMMON.vanillaAetherRegionWeight.set(0);
                AeroBlenderConfig.COMMON.vanillaAetherRegionWeight.save();

                if (AncientConfig.CLIENT.title_screen_override.get()) {
                    CumulusConfig.CLIENT.active_menu.set("ancient_aether:ancient_aether");
                    CumulusConfig.CLIENT.active_menu.save();
                }
            }
        });
    }

    public static void eventSetup(IEventBus neoBus) {
        IEventBus bus = NeoForge.EVENT_BUS;

        HandRenderListener.listen(bus);

        neoBus.addListener(AncientParticleTypes::registerParticleFactories);
        neoBus.addListener(AncientRenderers::registerEntityRenderers);
        neoBus.addListener(AncientRenderers::registerLayerDefinitions);
        neoBus.addListener(AncientRenderers::addEntityLayers);
    }
}