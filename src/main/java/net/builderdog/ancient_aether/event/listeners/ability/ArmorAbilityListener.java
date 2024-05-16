package net.builderdog.ancient_aether.event.listeners.ability;

import net.builderdog.ancient_aether.event.hooks.AbilityHooks;
import net.builderdog.ancient_aether.item.equipment.armor.ValkyrumArmor;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

public class ArmorAbilityListener {

    public static void listen(IEventBus bus) {
        bus.addListener(ArmorAbilityListener::onEntityUpdate);
        bus.addListener(ArmorAbilityListener::onEntityFall);
    }

    public static void onEntityUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!event.isCanceled()) {
            ValkyrumArmor.handleFlight(livingEntity);
        }
    }

    public static void onEntityFall(LivingFallEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!event.isCanceled()) {
            event.setCanceled(AbilityHooks.ArmorHooks.fallCancellation(livingEntity));
        }
    }
}