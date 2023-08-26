package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherCreativeTabs;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherCreativeModeTabs {
    public static CreativeModeTab ANCIENT_AETHER_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ANCIENT_AETHER_TAB = event.registerCreativeModeTab(new ResourceLocation(AncientAether.MOD_ID, "aether_crystallium_tab"),
                builder -> builder.icon(() -> new ItemStack(AncientAetherBlocks.CRACKED_SLIDER.get()))
                        .title(Component.translatable("creativemodetab.ancient_aether_tab"))
                        .displayItems((features, output) -> {
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get());
                            }
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get());
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get());
                            }
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.SAKURA_LOG_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.SAKURA_WOOD.get());
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.SAKURA_WOOD_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
                            if (ModList.get().isLoaded("aether_genesis")) {
                                output.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
                            }
                            output.accept(AncientAetherBlocks.EDELWEISS.get());
                            output.accept(AncientAetherBlocks.HIGHLAND_TULIP.get());
                            output.accept(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
                            output.accept(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get());
                            output.accept(AncientAetherBlocks.MOONLIT_WATERLILY.get());
                            if (ModList.get().isLoaded("lost_aether_content")) {
                                output.accept(AncientAetherBlocks.LOCKED_GALE_STONE_MOSAIC.get());
                            }
                            output.accept(AncientAetherItems.ANCIENT_SENTRY_RUNE.get());
                            output.accept(AncientAetherItems.HIGHLAND_BUFFALO_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.LEAPING_SENTRY_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.ROOTHYRN_SPAWN_EGG.get());
                        }));
    }

    @SubscribeEvent
    public static void buildCreativeModeTabs(CreativeModeTabEvent.BuildContents event) {
        CreativeModeTab tab = event.getTab();
        if (tab == AetherCreativeTabs.AETHER_BUILDING_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_WOOD.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_WOOD.get()), new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_STAIRS.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_SLAB.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_FENCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_FENCE.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_BUTTON.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_BUTTON.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_WOOD.get()), new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()), new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get()), new ItemStack(AncientAetherBlocks.SAKURA_PLANKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_PLANKS.get()), new ItemStack(AncientAetherBlocks.SAKURA_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_STAIRS.get()), new ItemStack(AncientAetherBlocks.SAKURA_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_SLAB.get()), new ItemStack(AncientAetherBlocks.SAKURA_FENCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_FENCE.get()), new ItemStack(AncientAetherBlocks.SAKURA_FENCE_GATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_FENCE_GATE.get()), new ItemStack(AncientAetherBlocks.SAKURA_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_DOOR.get()), new ItemStack(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), new ItemStack(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get()), new ItemStack(AncientAetherBlocks.SAKURA_BUTTON.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.HOLYSTONE_BRICKS.get()), new ItemStack(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AEROGEL_WALL.get()), new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICKS.get()), new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get()), new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get()), new ItemStack(AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_NATURAL_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_ORE.get()), new ItemStack(AncientAetherBlocks.AETHER_QUARTZ_ORE.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LEAVES.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()), new ItemStack(AncientAetherBlocks.SAKURA_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_SAPLING.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()), new ItemStack(AncientAetherBlocks.SAKURA_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.WHITE_FLOWER.get()), new ItemStack(AncientAetherBlocks.EDELWEISS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.EDELWEISS.get()), new ItemStack(AncientAetherBlocks.HIGHLAND_TULIP.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHLAND_TULIP.get()), new ItemStack(AncientAetherBlocks.SAKURA_BLOSSOMS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_BLOSSOMS.get()), new ItemStack(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get()), new ItemStack(AncientAetherBlocks.MOONLIT_WATERLILY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_EQUIPMENT_AND_UTILITIES) {
            event.getEntries().putAfter(new ItemStack(AetherItems.FLAMING_SWORD.get()), new ItemStack(AncientAetherItems.ANCIENT_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.BLACK_MOA_EGG.get()), new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.SKYROOT_CHEST_BOAT.get()), new ItemStack(AncientAetherItems.HIGHSPROOT_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HIGHSPROOT_BOAT.get()), new ItemStack(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get()), new ItemStack(AncientAetherItems.SAKURA_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SAKURA_BOAT.get()), new ItemStack(AncientAetherItems.SAKURA_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLD_DUNGEON_KEY.get()), new ItemStack(AncientAetherItems.ANCIENT_DUNGEON_KEY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.MUSIC_DISC_ASCENDING_DAWN.get()), new ItemStack(AncientAetherItems.MUSIC_DISC_LABYRINTHS_VENGEANCE_BUILDERDOG_REMIX.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_FOOD_AND_DRINKS) {
            event.getEntries().putAfter(new ItemStack(AetherItems.ENCHANTED_BERRY.get()), new ItemStack(AncientAetherItems.GRAPES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.WHITE_APPLE.get()), new ItemStack(AncientAetherItems.RAW_BUFFALO_RIBS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.RAW_BUFFALO_RIBS.get()), new ItemStack(AncientAetherItems.COOKED_BUFFALO_RIBS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.COOKED_BUFFALO_RIBS.get()), new ItemStack(AncientAetherItems.BUFFALO_RIB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_SPAWN_EGGS) {
            event.getEntries().putAfter(new ItemStack(AetherItems.BLACK_MOA_EGG.get()), new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_FUNCTIONAL_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_TORCH.get()), new ItemStack(AncientAetherBlocks.HOLYSTONE_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HOLYSTONE_LANTERN.get()), new ItemStack(AncientAetherBlocks.SENTRY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SENTRY_LANTERN.get()), new ItemStack(AncientAetherBlocks.ANGELIC_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANGELIC_LANTERN.get()), new ItemStack(AncientAetherBlocks.HELLFIRE_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (ModList.get().isLoaded("lost_aether_content")) {
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HELLFIRE_LANTERN.get()), new ItemStack(AncientAetherBlocks.GALE_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.GALE_LANTERN.get()), new ItemStack(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_SIGN.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_SIGN.get()), new ItemStack(AncientAetherBlocks.SAKURA_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()), new ItemStack(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()), new ItemStack(AncientAetherBlocks.SENTRY_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_REDSTONE_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CRACKED_SLIDER.get()), new ItemStack(AncientAetherBlocks.CRACKED_SLIDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (tab == AetherCreativeTabs.AETHER_DUNGEON_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.CARVED_WALL.get()), new ItemStack(AncientAetherBlocks.CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.LOCKED_ANCIENT_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ANGELIC_WALL.get()), new ItemStack(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.HELLFIRE_WALL.get()), new ItemStack(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
