package net.builderdog.ancient_aether.item.equipment.accessories.rings;

import com.aetherteam.aether.item.accessories.ring.RingItem;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ArkeniumRingItem extends RingItem {
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.fromString("CB33E1C-E2D6-4A0B-9562-55C25FE53A1E");

    public ArkeniumRingItem(Properties properties) {
        super(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ARKENIUM_RING, properties);
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance toughness = livingEntity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (toughness != null) {
            if (!toughness.hasModifier(getArmorToughnessModifier())) {
                toughness.addTransientModifier(getArmorToughnessModifier());
            }
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance toughness = livingEntity.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (toughness != null) {
            if (toughness.hasModifier(getArmorToughnessModifier())) {
                toughness.removeModifier(getArmorToughnessModifier());
            }
        }
    }
    public AttributeModifier getArmorToughnessModifier() {
        return new AttributeModifier(ARMOR_TOUGHNESS_UUID, "Armor Toughness increase", 1, AttributeModifier.Operation.ADDITION);
    }
}
