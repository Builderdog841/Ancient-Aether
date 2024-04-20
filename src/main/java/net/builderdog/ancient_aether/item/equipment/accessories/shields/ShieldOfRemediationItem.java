package net.builderdog.ancient_aether.item.equipment.accessories.shields;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class ShieldOfRemediationItem extends ShieldAccessoryItem {

    public ShieldOfRemediationItem(Properties properties, ResourceLocation shieldName) {
        super(properties, shieldName);
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (livingEntity.hasEffect(AetherEffects.INEBRIATION.get())) {
            livingEntity.removeEffect(AetherEffects.INEBRIATION.get());
        }
    }
}