package net.builderdog.ancient_aether.item.loot;

import com.aetherteam.aether.item.combat.AetherItemTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class AncientSwordItem extends SwordItem {
    public AncientSwordItem() {
        super(AetherItemTiers.VAMPIRE, 3, -2F, new Item.Properties());
    }
}