package net.builderdog.ancient_aether.item.loot;

import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.item.accessories.AccessoryItem;
import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class AncientPendantItem extends PendantItem {
    private static final UUID ATTACK_SPEED_UUID = UUID.fromString("B022E1C-E2D5-4A0B-9562-55C75FE53A1E");

    public AncientPendantItem(Properties properties) {
        super("ancient_pendant", AetherSoundEvents.ITEM_ACCESSORY_EQUIP_IRON_PENDANT, properties);
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance damage = livingEntity.getAttribute(Attributes.ATTACK_SPEED);
        if (damage != null) {
            if (!damage.hasModifier(getdamageModifier())) {
                damage.addTransientModifier(getdamageModifier());
            }
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance stepHeight = livingEntity.getAttribute(Attributes.ATTACK_SPEED);
        if (stepHeight != null) {
            if (stepHeight.hasModifier(getdamageModifier())) {
                stepHeight.removeModifier(getdamageModifier());
            }
        }
    }
    public AttributeModifier getdamageModifier() {
        return new AttributeModifier(ATTACK_SPEED_UUID, "Attack Speed increase", 0.2, AttributeModifier.Operation.ADDITION);
    }
}
