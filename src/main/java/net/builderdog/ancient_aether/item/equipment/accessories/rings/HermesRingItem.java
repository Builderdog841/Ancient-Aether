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

public class HermesRingItem extends RingItem {
    private static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("AB22E1C-E2D6-4A0B-9562-55C75FE53A1E");

    public HermesRingItem(Properties properties) {
        super(AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_RING, properties);
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance speed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            if (!speed.hasModifier(getMovementSpeedModifier())) {
                speed.addTransientModifier(getMovementSpeedModifier());
            }
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance speed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            if (speed.hasModifier(getMovementSpeedModifier())) {
                speed.removeModifier(getMovementSpeedModifier());
            }
        }
    }
    public AttributeModifier getMovementSpeedModifier() {
        return new AttributeModifier(MOVEMENT_SPEED_UUID, "Movement Speed increase", 0.015, AttributeModifier.Operation.ADDITION);
    }
}
