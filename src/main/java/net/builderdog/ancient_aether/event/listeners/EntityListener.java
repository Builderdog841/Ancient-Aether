package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.event.hooks.EntityHooks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class EntityListener {

    public static void listen(IEventBus bus) {
        bus.addListener(EntityListener::onInteractWithEntity);
        bus.addListener(EntityListener::onEntityHurt);
    }

    public static void onInteractWithEntity(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity targetEntity = event.getTarget();
        Player player = event.getEntity();
        InteractionHand interactionHand = event.getHand();
        EntityHooks.skyrootBucketMilking(targetEntity, player, interactionHand);
    }

    public static void onEntityHurt(LivingHurtEvent event) {
        LivingEntity player = event.getEntity();
        Entity attackerEntity = event.getSource().getDirectEntity();
        if (player instanceof Player && attackerEntity instanceof LivingEntity attacker) {
            EntityHooks.shieldOfInebriationAbility(player, attacker);
        }
    }
}