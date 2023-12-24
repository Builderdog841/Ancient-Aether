package net.builderdog.ancient_aether.item.equipment.accessories;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ArkeniumPendantItem extends PendantItem {
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.fromString("CB33E1C-E2D6-4A0B-9562-55C25FE53A1E");

    public ArkeniumPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MOD_ID, "arkenium_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_ARKENIUM_PENDANT, properties);
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
        return new AttributeModifier(ARMOR_TOUGHNESS_UUID, "Armor Toughness increase", 2, AttributeModifier.Operation.ADDITION);
    }
}
