package net.builderdog.ancient_aether.event.hooks;

import net.builderdog.ancient_aether.item.equipment.armor.EquipmentUtil;
import net.minecraft.world.entity.LivingEntity;

public class AbilityHooks {
    public static class ArmorHooks {

        public static boolean fallCancellation(LivingEntity entity) {
            return EquipmentUtil.hasFullValkyrumSet(entity);
        }
    }
}
