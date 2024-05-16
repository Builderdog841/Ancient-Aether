package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.AttachmentHooks;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class AttachmentListener {

    public static void listen(IEventBus bus) {
        bus.addListener(AttachmentListener::onPlayerUpdate);
    }

    public static void onPlayerUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        AttachmentHooks.update(livingEntity);
    }
}