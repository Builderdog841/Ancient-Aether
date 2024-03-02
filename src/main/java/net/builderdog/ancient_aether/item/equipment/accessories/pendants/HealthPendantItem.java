package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

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

public class HealthPendantItem extends PendantItem {
    private static final UUID HEALTH_UUID = UUID.fromString("A022E1C-E2D5-4A0B-9562-55C75FE53A1E");

    public HealthPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "health_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HEALTH_PENDANT, properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance health = livingEntity.getAttribute(Attributes.MAX_HEALTH);
        if (health != null) {
            if (!health.hasModifier(getHealthModifier())) {
                health.addTransientModifier(getHealthModifier());
            }
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance health = livingEntity.getAttribute(Attributes.MAX_HEALTH);
        if (health != null) {
            if (health.hasModifier(getHealthModifier())) {
                health.removeModifier(getHealthModifier());
            }
        }
    }

    public AttributeModifier getHealthModifier() {
        return new AttributeModifier(HEALTH_UUID, "Max Health increase", 2, AttributeModifier.Operation.ADDITION);
    }
}