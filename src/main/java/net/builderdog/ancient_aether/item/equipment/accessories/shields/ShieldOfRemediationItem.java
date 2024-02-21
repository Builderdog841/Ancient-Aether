package net.builderdog.ancient_aether.item.equipment.accessories.shields;

import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.resources.ResourceLocation;

public class ShieldOfRemediationItem extends AccessoryItem {
    private static final ResourceLocation SHIELD_OF_REMEDIATION = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_remediation/shield_of_remediation_accessory.png");
    private static final ResourceLocation SHIELD_OF_REMEDIATION_INACTIVE = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_remediation/shield_of_remediation_inactive_accessory.png");
    private static final ResourceLocation SHIELD_OF_REMEDIATION_SLIM = new ResourceLocation("ancient_aether", "textures/models/accessory/shield_of_remediation/shields/shield_of_remediation_slim_accessory.png");
    private static final ResourceLocation SHIELD_OF_REMEDIATION_SLIM_INACTIVE = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_remediation/shield_of_remediation_slim_inactive_accessory.png");

    public ShieldOfRemediationItem(Properties properties) {
        super(properties);
    }

    public ResourceLocation getShieldOfRemediationTexture() {
        return SHIELD_OF_REMEDIATION;
    }

    public ResourceLocation getShieldOfRemediationInactiveTexture() {
        return SHIELD_OF_REMEDIATION_INACTIVE;
    }

    public ResourceLocation getShieldOfRemediationSlimTexture() {
        return SHIELD_OF_REMEDIATION_SLIM;
    }

    public ResourceLocation getShieldOfRemediationSlimInactiveTexture() {
        return SHIELD_OF_REMEDIATION_SLIM_INACTIVE;
    }
}