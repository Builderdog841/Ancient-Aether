package net.builderdog.ancient_aether.item.equipment.tools.valkyrum;

import com.aetherteam.aether.item.tools.abilities.ValkyrieTool;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ValkyrumAxeItem extends AxeItem implements ValkyrieTool {
    public ValkyrumAxeItem() {
        super(AncientAetherItemTiers.VALKYRUM, 5.0F, -3.3F, new Properties());
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(@NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
        return extendReachModifier(super.getAttributeModifiers(slot, stack), slot);
    }
}