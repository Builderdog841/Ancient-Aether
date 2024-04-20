package net.builderdog.ancient_aether.item.equipment.accessories.shields;

import com.aetherteam.aether.item.accessories.AccessoryItem;
import net.minecraft.resources.ResourceLocation;

public class ShieldAccessoryItem extends AccessoryItem {
    protected ResourceLocation SHIELD_TEXTURE;
    protected ResourceLocation SHIELD_SLIM_TEXTURE;

    public ShieldAccessoryItem(Properties properties, ResourceLocation shieldName) {
        super(properties);
        setRenderTexture(shieldName.getNamespace(), shieldName.getPath());
    }

    public void setRenderTexture(String modId, String registryName) {
        SHIELD_TEXTURE = new ResourceLocation(modId, "textures/models/accessory/shields/" + registryName + "_accessory.png");
        SHIELD_SLIM_TEXTURE = new ResourceLocation(modId, "textures/models/accessory/shields/" + registryName + "_slim_accessory.png");
    }

    public ResourceLocation getShieldTexture() {
        return SHIELD_TEXTURE;
    }

    public ResourceLocation getShieldSlimTexture() {
        return SHIELD_SLIM_TEXTURE;
    }
}
