package net.builderdog.ancient_aether.item.equipment.tools.divine;

import net.builderdog.ancient_aether.item.equipment.AncientItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.DivineTool;
import net.minecraft.world.item.HoeItem;

public class DivineHoeItem extends HoeItem implements DivineTool {
    public DivineHoeItem() {
        super(AncientItemTiers.DIVINE, -3, 0, new Properties());
    }
}