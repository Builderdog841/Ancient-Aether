package net.builderdog.ancient_aether.item.equipment.tools.valkyrum;

import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public class ValkyrumSwordItem extends SwordItem implements ValkyrumSwordRange {
    public ValkyrumSwordItem() {
        super(AncientAetherItemTiers.VALKYRUM, 3, -2.4F, (new Properties()));
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return extendReachModifier(super.getAttributeModifiers(slot, stack), slot);
    }
}
