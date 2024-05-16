package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.attachment.AetherDataAttachments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AttachmentHooks {

    public static void update(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.getData(AetherDataAttachments.AETHER_PLAYER).onUpdate(player);
        }
    }
}