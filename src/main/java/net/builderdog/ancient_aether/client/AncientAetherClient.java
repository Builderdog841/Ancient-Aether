package net.builderdog.ancient_aether.client;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherWoodTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import static net.minecraft.client.renderer.BiomeColors.getAverageGrassColor;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherClient {
    private static boolean refreshPacks = true;

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(AncientAetherWoodTypes.HIGHSPROOT);
            Sheets.addWoodType(AncientAetherWoodTypes.SAKURA);
            autoApplyPacks();
        });
    }

    public static void autoApplyPacks() {
        Minecraft.getInstance().getResourcePackRepository().addPack("builtin/ancient_aether_tweaks");
    }

    @SubscribeEvent
    public void loadComplete(FMLLoadCompleteEvent event) {
        if (refreshPacks) {
            Minecraft.getInstance().reloadResourcePacks();
            refreshPacks = true;
        }
    }

    @SubscribeEvent
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            event.getBlockColors().register((bs, world, pos, index) -> world != null && pos != null ? getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D),
                    AetherBlocks.AETHER_GRASS_BLOCK.get());
    }
}
