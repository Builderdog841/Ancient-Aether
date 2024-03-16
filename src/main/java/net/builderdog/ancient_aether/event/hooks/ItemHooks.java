package net.builderdog.ancient_aether.event.hooks;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.legacy.lost_aether.registry.LCBlocks;
import com.legacy.lost_aether.registry.LCItems;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

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

        if (AncientAetherConfig.CLIENT.rarity_system.get()) {
            if (stack.is(AncientAetherTags.Items.COMMON_LOOT)) {
                components.add(position, AncientAetherItems.COMMON);
            }
            if (stack.is(AncientAetherTags.Items.RARE_LOOT)) {
                components.add(position, AncientAetherItems.RARE);
            }
            if (stack.is(AncientAetherTags.Items.EPIC_LOOT)) {
                components.add(position, AncientAetherItems.EPIC);
            }
            if (stack.is(AncientAetherTags.Items.MYTHIC_LOOT)) {
                components.add(position, AncientAetherItems.MYTHIC);
            }
        }

        if (AncientAetherConfig.CLIENT.moa_egg_tooltips.get()) {
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

            if (ModList.get().isLoaded("lost_aether_content")) {
                if (stack.is(LCItems.orange_moa_egg)) {
                    components.add(position, Component.literal("2 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                    components.add(position + 1, Component.literal("Hyper Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                }
                if (stack.is(LCItems.brown_moa_egg)) {
                    components.add(position, Component.literal("3 " + "Mid-Air Jumps").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                    components.add(position + 1, Component.literal("Very Fast " + "Speed").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                }
            }
        }

        if (stack.is(AetherBlocks.TRAPPED_CARVED_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_SENTRY_STONE.get().asItem()) || stack.is(AncientAetherBlocks.TRAPPED_CARVED_TILES.get().asItem())) {
            components.add(position, Component.translatable("entity.aether.sentry").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AetherBlocks.TRAPPED_ANGELIC_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_LIGHT_ANGELIC_STONE.get().asItem())) {
            components.add(position, Component.translatable("entity.aether.valkyrie").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AetherBlocks.TRAPPED_HELLFIRE_STONE.get().asItem()) || stack.is(AetherBlocks.TRAPPED_LIGHT_HELLFIRE_STONE.get().asItem())) {
            components.add(position, Component.translatable("entity.aether.fire_minion").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get().asItem()) || stack.is(AncientAetherBlocks.TRAPPED_LIGHT_AEROGETIC_STONE.get().asItem()) || stack.is(AncientAetherBlocks.TRAPPED_CORRUPTED_AEROGETIC_STONE.get().asItem())) {
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
        if (stack.is(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get().asItem())) {
            components.add(position, Component.translatable("entity.ancient_aether.mutated_aechor_plant").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }
        if (stack.is(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get().asItem()) || stack.is(AncientAetherBlocks.BOSS_DOORWAY_LIGHT_AEROGETIC_STONE.get().asItem()) || stack.is(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AEROGETIC_STONE.get().asItem())) {
            components.add(position, Component.literal("").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        }

        if (ModList.get().isLoaded("lost_aether_content")) {
            if (stack.is(LCBlocks.trapped_gale_stone.asItem()) || stack.is(LCBlocks.trapped_light_gale_stone.asItem())) {
                components.add(position, Component.translatable("entity.aether.whirlwind").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
            if (stack.is(LCBlocks.boss_doorway_gale_stone.asItem()) || stack.is(LCBlocks.boss_doorway_light_gale_stone.asItem())) {
                components.add(position, Component.translatable("entity.lost_aether_content.aerwhale_king").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
        }
    }
}