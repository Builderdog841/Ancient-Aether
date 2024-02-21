package net.builderdog.ancient_aether.item.equipment.accessories.shields;

import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ShieldOfInebriationItem extends AccessoryItem {
    private static final ResourceLocation SHIELD_OF_INEBRIATION = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_inebriation/shield_of_inebriation_accessory.png");
    private static final ResourceLocation SHIELD_OF_INEBRIATION_INACTIVE = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_inebriation/shield_of_inebriation_inactive_accessory.png");
    private static final ResourceLocation SHIELD_OF_INEBRIATION_SLIM = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_inebriation/shield_of_inebriation_slim_accessory.png");
    private static final ResourceLocation SHIELD_OF_INEBRIATION_SLIM_INACTIVE = new ResourceLocation("ancient_aether", "textures/models/accessory/shields/shield_of_inebriation/shield_of_inebriation_slim_inactive_accessory.png");

    public ShieldOfInebriationItem(Item.Properties properties) {
        super(properties);
    }

    public ResourceLocation getShieldOfInebriationTexture() {
        return SHIELD_OF_INEBRIATION;
    }

    public ResourceLocation getShieldOfInebriationInactiveTexture() {
        return SHIELD_OF_INEBRIATION_INACTIVE;
    }

    public ResourceLocation getShieldOfInebriationSlimTexture() {
        return SHIELD_OF_INEBRIATION_SLIM;
    }

    public ResourceLocation getShieldOfInebriationSlimInactiveTexture() {
        return SHIELD_OF_INEBRIATION_SLIM_INACTIVE;
    }
}