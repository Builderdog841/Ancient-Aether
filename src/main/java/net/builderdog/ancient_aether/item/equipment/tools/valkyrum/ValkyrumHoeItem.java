package net.builderdog.ancient_aether.item.equipment.tools.valkyrum;

import com.aetherteam.aether.item.tools.abilities.ValkyrieTool;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.item.equipment.AncientItemTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ValkyrumHoeItem extends HoeItem implements ValkyrieTool {
    public ValkyrumHoeItem() {
        super(AncientItemTiers.VALKYRUM, -3, -0.3F, new Properties());
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(@NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
        return extendReachModifier(super.getAttributeModifiers(slot, stack), slot);
    }
}