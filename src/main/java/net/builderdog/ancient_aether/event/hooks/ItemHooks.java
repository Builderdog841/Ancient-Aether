package net.builderdog.ancient_aether.event.hooks;

import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ItemHooks {

    public static void addDungeonTooltips(List<Component> components, ItemStack stack) {
        int position = components.size();
        Component itemName = stack.getItem().getName(stack);
        for (int i = 0; i < position; i++) {
            Component component = components.get(i);
            if (component.getString().equals(itemName.getString())) {
                position = i + 1;
                break;
            }
        }
        if (stack.is(AncientAetherTags.Items.COMMON_LOOT)) {
            components.add(position, AncientAetherItems.COMMON);
        }
        if (stack.is(AncientAetherTags.Items.RARE_LOOT)) {
            components.add(position, AncientAetherItems.RARE);
        }
        if (stack.is(AncientAetherTags.Items.EPIC_LOOT)) {
            components.add(position, AncientAetherItems.EPIC);
        }
        if (stack.is(AncientAetherTags.Items.LEGENDARY_LOOT)) {
            components.add(position, AncientAetherItems.LEGENDARY);
        }
        if (stack.is(AncientAetherTags.Items.SEASONAL_LOOT)) {
            components.add(position, AncientAetherItems.SEASONAL);
        }
        if (stack.is(AncientAetherTags.Items.WIP)) {
            components.add(position, AncientAetherItems.WIP);
        }
    }
}