package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.AetherConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import static com.aetherteam.aether.item.EquipmentUtil.findFirstCurio;

public final class AncientEquipmentUtil {

    private static boolean hasArmorSet(LivingEntity entity, Item helmet, Item chestplate, Item leggings, Item boots, Item gloves) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(helmet)
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(chestplate)
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(leggings)
                && entity.getItemBySlot(EquipmentSlot.FEET).is(boots)
                && (!AetherConfig.SERVER.require_gloves.get() || findFirstCurio(entity, gloves).isPresent());
    }

    public static boolean hasFullValkyrumSet(LivingEntity entity) {
        return hasArmorSet(entity, AncientItems.VALKYRUM_HELMET.get(), AncientItems.VALKYRUM_CHESTPLATE.get(), AncientItems.VALKYRUM_LEGGINGS.get(), AncientItems.VALKYRUM_BOOTS.get(), AncientItems.VALKYRUM_GLOVES.get());
    }

    public static boolean hasCurio(LivingEntity entity, Item item) {
        return findFirstCurio(entity, item).isPresent();
    }

    public static boolean hasShieldOfInebriation(LivingEntity entity) {
        return hasCurio(entity, AncientItems.SHIELD_OF_INEBRIATION.get());
    }
}