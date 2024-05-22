package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class HermesPendantItem extends PendantItem {

    public HermesPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "hermes_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_PENDANT, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Hermes Pendant Ability", 0.05, AttributeModifier.Operation.MULTIPLY_TOTAL));
        return attributes;
    }
}