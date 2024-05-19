package net.builderdog.ancient_aether.item.equipment.tools.divine;

import net.builderdog.ancient_aether.item.equipment.AncientItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.DivineTool;
import net.minecraft.world.item.AxeItem;

public class DivineAxeItem extends AxeItem implements DivineTool {
    public DivineAxeItem() {
        super(AncientItemTiers.DIVINE, 5.0F, -3.0F, new Properties());
    }
}