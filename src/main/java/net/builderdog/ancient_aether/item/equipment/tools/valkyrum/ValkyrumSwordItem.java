package net.builderdog.ancient_aether.item.equipment.tools.valkyrum;

import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.ValkyrumSwordRange;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import org.jetbrains.annotations.NotNull;

public class ValkyrumSwordItem extends SwordItem implements ValkyrumSwordRange {
    public ValkyrumSwordItem() {
        super(AncientAetherItemTiers.VALKYRUM, 3, -2.4F, (new Properties()));
    }

    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(@NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
        return extendReachModifier(super.getAttributeModifiers(slot, stack), slot);
    }
}
