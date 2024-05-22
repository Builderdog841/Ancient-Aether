package net.builderdog.ancient_aether.item.equipment.weapons;

import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.minecraft.world.item.SwordItem;

public class AncientSwordItem extends SwordItem {
    public AncientSwordItem() {
        super(AncientAetherItemTiers.ANCIENT, 3, -2F, new Properties());
    }
}