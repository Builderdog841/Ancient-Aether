package net.builderdog.ancient_aether.item.equipment.weapons;

import net.builderdog.ancient_aether.item.equipment.AncientItemTiers;
import net.minecraft.world.item.SwordItem;

public class AncientSwordItem extends SwordItem {
    public AncientSwordItem() {
        super(AncientItemTiers.ANCIENT, 3, -2F, new Properties());
    }
}