package net.builderdog.aether_crystallium.client.renderer;

import net.builderdog.aether_crystallium.blockentity.ModBlockEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.blockentity.SignRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.SIGN.get(), SignRenderer::new);
        //event.registerEntityRenderer(Mod.BOAT.get(), context -> new ModBoatRenderer<>(context, false));
    }
}