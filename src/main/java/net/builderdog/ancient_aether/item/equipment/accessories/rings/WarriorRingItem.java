package net.builderdog.ancient_aether.item.equipment.accessories.rings;

import com.aetherteam.aether.item.accessories.ring.RingItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class WarriorRingItem extends RingItem {

    public WarriorRingItem(Properties properties) {
        super(AncientSoundEvents.ITEM_ACCESSORY_EQUIP_WARRIOR_RING, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Warrior Ring Ability", 1.0, AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}