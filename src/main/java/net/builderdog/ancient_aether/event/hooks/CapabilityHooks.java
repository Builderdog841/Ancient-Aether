package net.builderdog.ancient_aether.event.hooks;

import net.builderdog.ancient_aether.capability.player.AncientAetherPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CapabilityHooks {

    public static class AncientAetherPlayerHooks {
        public static void update(LivingEntity entity) {
            if (entity instanceof Player player) {
                AncientAetherPlayer.get(player).ifPresent(AncientAetherPlayer::onUpdate);
            }
        }
    }
}