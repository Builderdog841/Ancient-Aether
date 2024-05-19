package net.builderdog.ancient_aether.item.equipment.tools.divine;

import net.builderdog.ancient_aether.item.equipment.AncientItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.DivineTool;
import net.minecraft.world.item.ShovelItem;

public class DivineShovelItem extends ShovelItem implements DivineTool {
    public DivineShovelItem() {
        super(AncientItemTiers.DIVINE, 1.5F, -3.0F, new Properties());
    }
}