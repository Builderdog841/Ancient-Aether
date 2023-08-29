package net.builderdog.ancient_aether.item.loot;

import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.combat.AetherItemTiers;
import com.aetherteam.aether.item.combat.AetherSwordItem;
import net.minecraft.world.item.Item;

public class AncientSwordItem extends AetherSwordItem {
    public AncientSwordItem() {
        super(AetherItemTiers.VAMPIRE, 3, -2F, new Item.Properties().rarity(AetherItems.AETHER_LOOT));
    }
}