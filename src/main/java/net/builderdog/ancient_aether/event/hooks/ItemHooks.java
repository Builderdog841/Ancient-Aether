package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientConfig;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.item.AncientItems;
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

        if (AncientConfig.CLIENT.rarity_system.get()) {
            if (stack.is(AncientTags.Items.COMMON_LOOT)) {
                components.add(position, AncientItems.COMMON);
            }
            if (stack.is(AncientTags.Items.RARE_LOOT)) {
                components.add(position, AncientItems.RARE);
            }
            if (stack.is(AncientTags.Items.EPIC_LOOT)) {
                components.add(position, AncientItems.EPIC);
            }
            if (stack.is(AncientTags.Items.MYTHIC_LOOT)) {
                components.add(position, AncientItems.MYTHIC);
            }
        }

        if (AncientConfig.CLIENT.moa_egg_tooltips.get()) {
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
            if (stack.is(AncientItems.SAKURA_MOA_EGG.get())) {
                components.add(position, Component.literal("12 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Slow " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.TURQUOISE_MOA_EGG.get())) {
                components.add(position, Component.literal("7 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.SKY_BLUE_MOA_EGG.get())) {
                components.add(position, Component.literal("5 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.TEAL_MOA_EGG.get())) {
                components.add(position, Component.literal("6 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.BURGUNDY_MOA_EGG.get())) {
                components.add(position, Component.literal("10 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Normal " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.LAVENDER_MOA_EGG.get())) {
                components.add(position, Component.literal("3 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Very Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientItems.VIOLET_MOA_EGG.get())) {
                components.add(position, Component.literal("4 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                components.add(position + 1, Component.literal("Very Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
        }

        if (AncientConfig.CLIENT.dungeon_block_tooltips.get()) {
            if (stack.is(AetherBlocks.TRAPPED_CARVED_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_SENTRY_STONE.get().asItem()) || stack.is(AncientBlocks.TRAPPED_CARVED_TILES.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.sentry").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AetherBlocks.TRAPPED_ANGELIC_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_LIGHT_ANGELIC_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.valkyrie").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AetherBlocks.TRAPPED_HELLFIRE_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_LIGHT_HELLFIRE_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.fire_minion").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientBlocks.TRAPPED_AEROGETIC_STONE.get().asItem()) || stack.is(AncientBlocks.TRAPPED_AERONAUTIC_STONE.get().asItem()) || stack.is(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.ancient_aether.aeronautic_leaper").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }

            if (stack.is(AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get().asItem()) || stack.is(AetherBlocks.BOSS_DOORWAY_SENTRY_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.slider").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AetherBlocks.BOSS_DOORWAY_ANGELIC_STONE.get().asItem()) || stack.is(AetherBlocks.BOSS_DOORWAY_LIGHT_ANGELIC_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.valkyrie_queen").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AetherBlocks.BOSS_DOORWAY_HELLFIRE_STONE.get().asItem()) || stack.is(AetherBlocks.BOSS_DOORWAY_LIGHT_HELLFIRE_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.aether.sun_spirit").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientBlocks.BOSS_DOORWAY_CARVED_STONE.get().asItem()) || stack.is(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get().asItem())) {
                components.add(position, Component.translatable("entity.ancient_aether.mutated_aechor_plant").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get().asItem()) || stack.is(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get().asItem()) || stack.is(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get().asItem())) {
                components.add(position, Component.literal("").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
        }
    }
}