package net.builderdog.ancient_aether.item.equipment.tools.divine;

import net.builderdog.ancient_aether.item.equipment.AncientAetherItemTiers;
import net.builderdog.ancient_aether.item.equipment.tools.abilities.DivineTool;
import net.minecraft.world.item.PickaxeItem;

public class DivinePickaxeItem extends PickaxeItem implements DivineTool {
    public DivinePickaxeItem() {
        super(AncientAetherItemTiers.DIVINE, 1, -2.8F, new Properties());
    }
}