package net.builderdog.ancient_aether.item.equipment.accessories.pendants;

import com.aetherteam.aether.item.accessories.pendant.PendantItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ValkyrumPendantItem extends PendantItem {
    private static final UUID REACH_UUID = UUID.fromString("AB22E1C-E2D6-4A0B-9562-55C75FE53A1D");

    public ValkyrumPendantItem(Properties properties) {
        super(new ResourceLocation(AncientAether.MOD_ID, "valkyrum_pendant"), AncientAetherSoundEvents.ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT, properties);
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance entityReach = livingEntity.getAttribute(ForgeMod.ENTITY_REACH.get());
        AttributeInstance blockReach = livingEntity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (entityReach != null) {
            if (!entityReach.hasModifier(getReachModifier())) {
                entityReach.addTransientModifier(getReachModifier());
            }
        }
        if (blockReach != null) {
            if (!blockReach.hasModifier(getReachModifier())) {
                blockReach.addTransientModifier(getReachModifier());
            }
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AttributeInstance entityReach = livingEntity.getAttribute(ForgeMod.ENTITY_REACH.get());
        AttributeInstance blockReach = livingEntity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (entityReach != null) {
            if (entityReach.hasModifier(getReachModifier())) {
                entityReach.removeModifier(getReachModifier());
            }
        }
        if (blockReach != null) {
            if (blockReach.hasModifier(getReachModifier())) {
                blockReach.removeModifier(getReachModifier());
            }
        }
    }
    public AttributeModifier getReachModifier() {
        return new AttributeModifier(REACH_UUID, "Reach increase", 0.5, AttributeModifier.Operation.ADDITION);
    }
}
