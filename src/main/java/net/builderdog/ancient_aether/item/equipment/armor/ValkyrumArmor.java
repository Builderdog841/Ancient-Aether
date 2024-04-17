package net.builderdog.ancient_aether.item.equipment.armor;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.mixin.mixins.common.accessor.ServerGamePacketListenerImplAccessor;
import net.builderdog.ancient_aether.item.EquipmentUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public interface ValkyrumArmor {

    static void handleFlight(LivingEntity entity) {
        if (EquipmentUtil.hasFullValkyrumSet(entity)) {
            if (entity instanceof Player player && !player.getAbilities().flying) {
                AetherPlayer.get(player).ifPresent(aetherPlayer -> {
                    Vec3 deltaMovement = player.getDeltaMovement();
                    if (aetherPlayer.isJumping() && !onGround(player)) {
                        if (aetherPlayer.getFlightModifier() >= aetherPlayer.getFlightModifierMax()) {
                            aetherPlayer.setFlightModifier(aetherPlayer.getFlightModifierMax());
                        }
                        if (aetherPlayer.getFlightTimer() > 2) {
                            if (aetherPlayer.getFlightTimer() < aetherPlayer.getFlightTimerMax()) {
                                aetherPlayer.setFlightModifier(aetherPlayer.getFlightModifier() + 0.25F);
                                aetherPlayer.setFlightTimer(aetherPlayer.getFlightTimer() + 1);
                            }
                        } else {
                            aetherPlayer.setFlightTimer(aetherPlayer.getFlightTimer() + 1);
                        }
                    } else if (!aetherPlayer.isJumping()) {
                        aetherPlayer.setFlightModifier(1.0F);
                    }
                    if (onGround(player)) {
                        aetherPlayer.setFlightTimer(0);
                        aetherPlayer.setFlightModifier(1.0F);
                    }
                    if (aetherPlayer.isJumping() && !onGround(player) && aetherPlayer.getFlightTimer() > 2 && aetherPlayer.getFlightTimer() < aetherPlayer.getFlightTimerMax() && aetherPlayer.getFlightModifier() > 1.0F) {
                        player.setDeltaMovement(deltaMovement.x(), 0.025F * aetherPlayer.getFlightModifier(), deltaMovement.z());
                    }
                    if (player instanceof ServerPlayer serverPlayer) {
                        ServerGamePacketListenerImplAccessor serverGamePacketListenerImplAccessor = (ServerGamePacketListenerImplAccessor) serverPlayer.connection;
                        serverGamePacketListenerImplAccessor.aether$setAboveGroundTickCount(0);
                    }
                });
            }
        }
    }

    private static boolean onGround(Player player) {
        return player.onGround() || player.isInFluidType();
    }
}