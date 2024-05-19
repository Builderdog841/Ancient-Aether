package net.builderdog.ancient_aether.event.hooks;

import net.builderdog.ancient_aether.attachments.AncientDataAttachments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AttachmentHooks {

    public static void update(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.getData(AncientDataAttachments.ANCIENT_PLAYER).onUpdate(player);
        }
    }
}