package net.builderdog.ancient_aether.event;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            Sheets.addWoodType(AncientAetherWoodTypes.HIGHLANDS_PINE);
            Sheets.addWoodType(AncientAetherWoodTypes.SAKURA);
        });
    }
}
