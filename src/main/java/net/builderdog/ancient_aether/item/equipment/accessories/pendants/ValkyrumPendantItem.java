package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ValkyrumPendantItem extends PendantItem {

    public ValkyrumPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "valkyrum_pendant"), AncientSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(NeoForgeMod.BLOCK_REACH.value(), new AttributeModifier(uuid, "Valkyrum Pendant Ability", 1.0, AttributeModifier.Operation.ADDITION));
        attributes.put(NeoForgeMod.ENTITY_REACH.value(), new AttributeModifier(uuid, "Valkyrum Pendant Ability", 1.0, AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}