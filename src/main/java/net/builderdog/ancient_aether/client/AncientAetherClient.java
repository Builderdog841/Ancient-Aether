package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.AncientAetherBlockSets;
import net.builderdog.ancient_aether.client.renderer.AncientAetherRenderers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.network.chat.Style;
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
            AetherItems.AETHER_LOOT.getStyleModifier().apply(Style.EMPTY.withColor(ChatFormatting.WHITE));

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
}