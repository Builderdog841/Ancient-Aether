package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class HermesPendantItem extends PendantItem {
    private static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("AB22E1C-E2D6-4A0B-9562-55C75FE53A1E");

    public HermesPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MODID, "hermes_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_HERMES_PENDANT, properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance speed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            if (!speed.hasModifier(getMovementSpeedModifier(slotContext))) {
                speed.addTransientModifier(getMovementSpeedModifier(slotContext));
            }
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance speed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            if (speed.hasModifier(getMovementSpeedModifier(slotContext))) {
                speed.removeModifier(getMovementSpeedModifier(slotContext));
            }
        }
    }

    public AttributeModifier getMovementSpeedModifier(SlotContext slotContext) {
        if (slotContext.entity() instanceof Player player) {
            float foodLevel = player.getFoodData().getFoodLevel();
            return new AttributeModifier(MOVEMENT_SPEED_UUID, "Movement Speed increase", foodLevel * 0.002, AttributeModifier.Operation.ADDITION);
        }
        return null;
    }
}