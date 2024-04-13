package net.builderdog.ancient_aether.event.listeners.ability;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.event.hooks.AbilityHooks;
import net.builderdog.ancient_aether.item.equipment.armor.ValkyrumArmor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MODID)
public class ArmorAbilityListener {

    @SubscribeEvent
    public static void onEntityUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!event.isCanceled()) {
            ValkyrumArmor.handleFlight(livingEntity);
        }
    }

    @SubscribeEvent
    public static void onEntityFall(LivingFallEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!event.isCanceled()) {
            event.setCanceled(AbilityHooks.ArmorHooks.fallCancellation(livingEntity));
        }
    }
}