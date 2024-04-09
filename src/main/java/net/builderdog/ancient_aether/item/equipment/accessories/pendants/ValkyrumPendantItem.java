package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ValkyrumPendantItem extends PendantItem {

    public ValkyrumPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "valkyrum_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(uuid, "Valkyrie Ring Block Reach Boost", 1.0, AttributeModifier.Operation.ADDITION));
        attributes.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(uuid, "Valkyrie Ring Entity Reach Boost", 1.0, AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}