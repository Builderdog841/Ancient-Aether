package net.builderdog.ancient_aether.event;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.AncientAetherWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static net.minecraft.client.renderer.BiomeColors.getAverageGrassColor;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(AncientAetherWoodTypes.HIGHSPROOT);
            Sheets.addWoodType(AncientAetherWoodTypes.SAKURA);
        });
    }

    @SubscribeEvent
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            event.getBlockColors().register((bs, world, pos, index) -> world != null && pos != null ? getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D),
                    AetherBlocks.AETHER_GRASS_BLOCK.get());
    }
}
