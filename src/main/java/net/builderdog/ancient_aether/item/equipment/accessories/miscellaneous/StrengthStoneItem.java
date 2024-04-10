package net.builderdog.ancient_aether.item.equipment.accessories.miscellaneous;

import com.aetherteam.aether.item.accessories.AccessoryItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class StrengthStoneItem extends AccessoryItem {

    public StrengthStoneItem(Properties properties) {
        super(properties);
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "Strength Stone Ability", 0.12, AttributeModifier.Operation.MULTIPLY_TOTAL));
        return attributes;
    }
}