package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlockSets;
import net.builderdog.ancient_aether.client.renderer.AncientAetherRenderers;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import teamrazor.aeroblender.AeroBlenderConfig;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            AncientAetherRenderers.registerCuriosRenderers();
            Sheets.addWoodType(AncientAetherBlockSets.HIGHSPROOT);
            Sheets.addWoodType(AncientAetherBlockSets.SAKURA);
            AetherConfig.CLIENT.enable_aether_menu_button.set(false);
            CumulusConfig.CLIENT.enable_menu_list_button.set(true);
            AetherConfig.COMMON.add_ruined_portal_automatically.set(true);
            AetherConfig.COMMON.add_temporary_freezing_automatically.set(true);
            AeroBlenderConfig.COMMON.vanillaAetherRegionWeight.set(0);
        });
    }
}