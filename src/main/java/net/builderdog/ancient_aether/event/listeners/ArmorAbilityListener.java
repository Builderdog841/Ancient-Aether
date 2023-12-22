package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.item.equipment.armor.ValkyrumArmor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID)
public class ArmorAbilityListener {

    @SubscribeEvent
    public static void onEntityUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!event.isCanceled()) {
            ValkyrumArmor.handleFlight(livingEntity);
        }
    }
}