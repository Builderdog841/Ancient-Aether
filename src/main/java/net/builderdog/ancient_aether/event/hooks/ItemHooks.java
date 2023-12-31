package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemHooks {

    public static void addTooltips(List<Component> components, ItemStack stack) {
        int position = components.size();
        Component itemName = stack.getItem().getName(stack);
        for (int i = 0; i < position; i++) {
            Component component = components.get(i);
            if (component.getString().equals(itemName.getString())) {
                position = i + 1;
                break;
            }
        }

        //Loot Tiers
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
        if (stack.is(AncientAetherTags.Items.WIP)) {
            components.add(position, AncientAetherItems.WIP);
        }

        //Moa Eggs
        if (stack.is(AetherItems.BLUE_MOA_EGG.get())) {
            components.add(position, Component.literal("3 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AetherItems.WHITE_MOA_EGG.get())) {
            components.add(position, Component.literal("4 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AetherItems.BLACK_MOA_EGG.get())) {
            components.add(position, Component.literal("8 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.SAKURA_MOA_EGG.get())) {
            components.add(position, Component.literal("12 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Slow " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.TURQUOISE_MOA_EGG.get())) {
            components.add(position, Component.literal("7 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.SKY_BLUE_MOA_EGG.get())) {
            components.add(position, Component.literal("5 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.TEAL_MOA_EGG.get())) {
            components.add(position, Component.literal("6 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.BURGUNDY_MOA_EGG.get())) {
            components.add(position, Component.literal("10 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.LAVENDER_MOA_EGG.get())) {
            components.add(position, Component.literal("3 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Very Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherItems.VIOLET_MOA_EGG.get())) {
            components.add(position, Component.literal("4 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            components.add(position + 1, Component.literal("Very Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
    }
}