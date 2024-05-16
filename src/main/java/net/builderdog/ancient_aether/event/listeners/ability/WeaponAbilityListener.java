package net.builderdog.ancient_aether.event.listeners.ability;

import net.builderdog.ancient_aether.event.hooks.AbilityHooks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class WeaponAbilityListener {

    public static void listen(IEventBus bus) {
        bus.addListener(WeaponAbilityListener::onEntityDamage);
    }

    public static void onEntityDamage(LivingDamageEvent event) {
        LivingEntity targetEntity = event.getEntity();
        DamageSource damageSource = event.getSource();
        Entity sourceEntity = damageSource.getDirectEntity();
        event.setAmount(AbilityHooks.WeaponHooks.reduceWeaponEffectiveness(targetEntity, sourceEntity, event.getAmount()));
        event.setAmount(AbilityHooks.WeaponHooks.reduceArmorEffectiveness(targetEntity, sourceEntity, event.getAmount()));
    }
}