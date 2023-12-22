package net.builderdog.ancient_aether.item.equipment.armor;

import com.aetherteam.aether.AetherConfig;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import static com.aetherteam.aether.item.EquipmentUtil.findFirstCurio;

public final class EquipmentUtil {

    private static boolean hasArmorSet(LivingEntity entity, Item helmet, Item chestplate, Item leggings, Item boots, Item gloves) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(helmet)
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(chestplate)
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(leggings)
                && entity.getItemBySlot(EquipmentSlot.FEET).is(boots)
                && (!AetherConfig.SERVER.require_gloves.get() || findFirstCurio(entity, gloves).isPresent());
    }

    public static boolean hasFullValkyrumSet(LivingEntity entity) {
        return hasArmorSet(entity, AncientAetherItems.VALKYRUM_HELMET.get(), AncientAetherItems.VALKYRUM_CHESTPLATE.get(), AncientAetherItems.VALKYRUM_LEGGINGS.get(), AncientAetherItems.VALKYRUM_BOOTS.get(), AetherItems.VALKYRIE_GLOVES.get());
    }
}
