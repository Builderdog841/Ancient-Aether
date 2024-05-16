package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.AncientAetherBlockSets;
import net.builderdog.ancient_aether.client.event.listeners.HandRenderListener;
import net.builderdog.ancient_aether.client.gui.AncientAetherMenus;
import net.builderdog.ancient_aether.client.particle.AncientAetherParticleTypes;
import net.builderdog.ancient_aether.client.renderer.AncientAetherRenderers;
import net.minecraft.client.renderer.Sheets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import teamrazor.aeroblender.AeroBlenderConfig;

public class AncientAetherClient {

    public static void clientInit(IEventBus bus) {
        bus.addListener(AncientAetherClient::clientSetup);

        AncientAetherMenus.MENUS.register(bus);
        AncientAetherClient.eventSetup(bus);
    }

    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            AncientAetherRenderers.registerCuriosRenderers();
            Sheets.addWoodType(AncientAetherBlockSets.HIGHSPROOT);
            Sheets.addWoodType(AncientAetherBlockSets.SAKURA);

            if (AncientAetherConfig.CLIENT.config_overrides.get()) {
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

                if (AncientAetherConfig.CLIENT.title_screen_override.get()) {
                    CumulusConfig.CLIENT.active_menu.set("ancient_aether:ancient_aether");
                    CumulusConfig.CLIENT.active_menu.save();
                }
            }
        });
    }

    public static void eventSetup(IEventBus neoBus) {
        IEventBus bus = NeoForge.EVENT_BUS;

        HandRenderListener.listen(bus);

        neoBus.addListener(AncientAetherParticleTypes::registerParticleFactories);
        neoBus.addListener(AncientAetherRenderers::registerEntityRenderers);
        neoBus.addListener(AncientAetherRenderers::registerLayerDefinitions);
        neoBus.addListener(AncientAetherRenderers::addEntityLayers);
        neoBus.addListener(AncientAetherRenderers::bakeModels);
    }
}