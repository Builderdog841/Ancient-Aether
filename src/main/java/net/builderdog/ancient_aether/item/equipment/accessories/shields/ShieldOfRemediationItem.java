package net.builderdog.ancient_aether.item.equipment.accessories.shields;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class ShieldOfRemediationItem extends AccessoryItem {
    private static final ResourceLocation SHIELD_OF_REMEDIATION = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_remediation_accessory.png");
    private static final ResourceLocation SHIELD_OF_REMEDIATION_SLIM = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_remediation_slim_accessory.png");

    public ShieldOfRemediationItem(Properties properties) {
        super(properties);
    }

    public ResourceLocation getShieldOfRemediationTexture() {
        return SHIELD_OF_REMEDIATION;
    }

    public ResourceLocation getShieldOfRemediationSlimTexture() {
        return SHIELD_OF_REMEDIATION_SLIM;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (livingEntity.hasEffect(AetherEffects.INEBRIATION.get())) {
            livingEntity.removeEffect(AetherEffects.INEBRIATION.get());
        }
    }
}