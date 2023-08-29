package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.UUID;

public class StrengthStoneItem extends AccessoryItem {
    private static final UUID DAMAGE_UUID = UUID.fromString("AC022E1C-E2D5-4A0B-9562-55C75FE53A1E");

    public StrengthStoneItem(Properties properties) {
        super(properties);
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance damage = livingEntity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (damage != null) {
            if (!damage.hasModifier(getdamageModifier())) {
                damage.addTransientModifier(getdamageModifier());
            }
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance stepHeight = livingEntity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (stepHeight != null) {
            if (stepHeight.hasModifier(getdamageModifier())) {
                stepHeight.removeModifier(getdamageModifier());
            }
        }
    }
    public AttributeModifier getdamageModifier() {
        return new AttributeModifier(DAMAGE_UUID, "Attack Damage increase", 1.25, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
