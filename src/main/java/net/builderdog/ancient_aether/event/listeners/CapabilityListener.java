package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.CapabilityHooks;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class CapabilityListener {

    public static void listen(IEventBus bus) {
        bus.addListener(CapabilityListener::onPlayerUpdate);
    }

    public static void onPlayerUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        CapabilityHooks.AncientAetherPlayerHooks.update(livingEntity);
    }
}