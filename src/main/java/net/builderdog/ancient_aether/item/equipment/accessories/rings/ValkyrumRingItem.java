package net.builderdog.ancient_aether.item.equipment.accessories.rings;

import com.aetherteam.aether.item.accessories.ring.RingItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ValkyrumRingItem extends RingItem {

    public ValkyrumRingItem(Properties properties) {
        super(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_RING, properties);
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(uuid, "Valkyrie Ring Block Reach Boost", 0.5, AttributeModifier.Operation.ADDITION));
        attributes.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(uuid, "Valkyrie Ring Entity Reach Boost", 0.5, AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}