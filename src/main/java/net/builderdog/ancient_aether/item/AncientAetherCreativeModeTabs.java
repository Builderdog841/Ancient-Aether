package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherCreativeTabs;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import static com.aetherteam.aether.item.AetherCreativeTabs.AETHER_BUILDING_BLOCKS;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherCreativeModeTabs {

    @SubscribeEvent
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab tab = event.getTab();

        if (tab == AETHER_BUILDING_BLOCKS.get()) {
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
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.FLUFFALO_WOOL.get()), new ItemStack(AncientAetherBlocks.FLUFFALO_WOOL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.FLUFFALO_WOOL.get()), new ItemStack(AncientAetherBlocks.FLUFFALO_CARPET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AEROGEL_WALL.get()), new ItemStack(AncientAetherBlocks.AEROGEL_GLASS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGEL_GLASS.get()), new ItemStack(AncientAetherBlocks.AEROGEL_GLASS_PANE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGEL_GLASS_PANE.get()), new ItemStack(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), new ItemStack(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ENCHANTED_GRAVITITE.get()), new ItemStack(AncientAetherBlocks.VALKYRUM_BLOCK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (ModList.get().isLoaded("aether_genesis")) {
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_WOOD.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get()), new ItemStack(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_WOOD.get()), new ItemStack(AncientAetherBlocks.SAKURA_WOOD_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()), new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get()), new ItemStack(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_DUNGEON_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.CARVED_WALL.get()), new ItemStack(AncientAetherBlocks.CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_TILES.get()), new ItemStack(AncientAetherBlocks.LOCKED_CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_CARVED_TILES.get()), new ItemStack(AncientAetherBlocks.TRAPPED_CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TRAPPED_CARVED_TILES.get()), new ItemStack(AncientAetherBlocks.CARVED_TILE_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_TILE_STAIRS.get()), new ItemStack(AncientAetherBlocks.CARVED_TILE_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_TILE_SLAB.get()), new ItemStack(AncientAetherBlocks.CARVED_TILE_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_TILE_WALL.get()), new ItemStack(AncientAetherBlocks.CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CARVED_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()), new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.WYND_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get()), new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ANGELIC_WALL.get()), new ItemStack(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.HELLFIRE_WALL.get()), new ItemStack(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_LIGHT_HELLFIRE_STONE.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_STONE.get()), new ItemStack(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get()), new ItemStack(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get()), new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get()), new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_STAIRS.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_SLAB.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_WALL.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.CHEST_MIMIC.get()), new ItemStack(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (ModList.get().isLoaded("lost_aether_content")) {
                event.getEntries().putBefore(new ItemStack(AetherBlocks.TREASURE_CHEST.get()), new ItemStack(AncientAetherBlocks.GALE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.GALE_STONE_MOSAIC.get()), new ItemStack(AncientAetherBlocks.LOCKED_GALE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get()), new ItemStack(AncientAetherBlocks.ANCIENT_GALE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_NATURAL_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.QUICKSOIL.get()), new ItemStack(AncientAetherBlocks.GRAVITY_GRAVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_ORE.get()), new ItemStack(AncientAetherBlocks.AETHER_QUARTZ_ORE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LEAVES.get()), new ItemStack(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_LEAVES.get()), new ItemStack(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get()), new ItemStack(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_SAPLING.get()), new ItemStack(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get()), new ItemStack(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()), new ItemStack(AncientAetherBlocks.SAKURA_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_SAPLING.get()), new ItemStack(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()), new ItemStack(AncientAetherBlocks.SAKURA_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.WHITE_FLOWER.get()), new ItemStack(AncientAetherBlocks.HIGHLAND_CYCLAMEN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHLAND_CYCLAMEN.get()), new ItemStack(AncientAetherBlocks.SKY_BLUES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SKY_BLUES.get()), new ItemStack(AncientAetherBlocks.WYND_THISTLE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GRAVITITE_ORE.get()), new ItemStack(AetherBlocks.AEROGEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AEROGEL.get()), new ItemStack(AncientAetherBlocks.WYND_ICE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GRAVITITE_ORE.get()), new ItemStack(AncientAetherBlocks.VALKYRUM_ORE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.VALKYRUM_ORE.get()), new ItemStack(AncientAetherBlocks.ATMOSINE_CRYSTAL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.BERRY_BUSH_STEM.get()), new ItemStack(AncientAetherBlocks.SKY_GRASS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (!ModList.get().isLoaded("aether_genesis")) {
                event.getEntries().putAfter(new ItemStack(AetherBlocks.BLUE_AERCLOUD.get()), new ItemStack(AncientAetherBlocks.VIOLET_AERCLOUD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else {
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG_WALL.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get()), new ItemStack(AncientAetherBlocks.BLUE_SKYROOT_PINE_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get()), new ItemStack(AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_FUNCTIONAL_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_TORCH.get()), new ItemStack(AncientAetherBlocks.AMBROSIUM_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AMBROSIUM_LANTERN.get()), new ItemStack(AncientAetherBlocks.WYND_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.WYND_LANTERN.get()), new ItemStack(AncientAetherBlocks.SUN_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SUN_LANTERN.get()), new ItemStack(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_BOOKSHELF.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get()), new ItemStack(AncientAetherBlocks.SAKURA_BOOKSHELF.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_HANGING_SIGN.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_SIGN.get()), new ItemStack(AncientAetherItems.HIGHSPROOT_HANGING_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HIGHSPROOT_HANGING_SIGN.get()), new ItemStack(AncientAetherBlocks.SAKURA_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SAKURA_SIGN.get()), new ItemStack(AncientAetherItems.SAKURA_HANGING_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.TREASURE_CHEST.get()), new ItemStack(AncientAetherBlocks.HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get()), new ItemStack(AncientAetherBlocks.SENTRY_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SENTRY_VASE.get()), new ItemStack(AncientAetherBlocks.ANGELIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANGELIC_VASE.get()), new ItemStack(AncientAetherBlocks.HELLFIRE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HELLFIRE_VASE.get()), new ItemStack(AncientAetherBlocks.AEROGETIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()), new ItemStack(AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get()), new ItemStack(AncientAetherBlocks.ANCIENT_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.ANCIENT_OBELISK.get()), new ItemStack(AncientAetherBlocks.SLIDER_PROTOTYPE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (ModList.get().isLoaded("lost_aether_content")) {
                event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.AEROGETIC_VASE.get()), new ItemStack(AncientAetherBlocks.GALE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_REDSTONE_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.INCUBATOR.get()), new ItemStack(AncientAetherBlocks.WIND_BLOWER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.ALTAR.get()), new ItemStack(AncientAetherBlocks.FLUFFALO_WOOL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SLIDER_PROTOTYPE.get()), new ItemStack(AncientAetherBlocks.SLIDER_PROTOTYPE.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        }

        if (tab == AetherCreativeTabs.AETHER_EQUIPMENT_AND_UTILITIES.get()) {
            event.getEntries().remove(new ItemStack(AetherItems.FLAMING_SWORD.get()));
            event.getEntries().remove(new ItemStack(AetherItems.CANDY_CANE_SWORD.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VAMPIRE_BLADE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.HOLY_SWORD.get()));
            event.getEntries().remove(new ItemStack(AetherItems.LIGHTNING_SWORD.get()));
            event.getEntries().putAfter(new ItemStack(AetherItems.VALKYRIE_HOE.get()), new ItemStack(AetherItems.FLAMING_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.FLAMING_SWORD.get()), new ItemStack(AetherItems.LIGHTNING_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.LIGHTNING_SWORD.get()), new ItemStack(AetherItems.HOLY_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.HOLY_SWORD.get()), new ItemStack(AetherItems.VAMPIRE_BLADE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.VAMPIRE_BLADE.get()), new ItemStack(AncientAetherItems.ANCIENT_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ANCIENT_SWORD.get()), new ItemStack(AetherItems.CANDY_CANE_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_DART_SHOOTER.get()), new ItemStack(AetherItems.POISON_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.POISON_DART_SHOOTER.get()), new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientAetherItems.TURQUOISE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.TURQUOISE_MOA_EGG.get()), new ItemStack(AncientAetherItems.TEAL_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.TEAL_MOA_EGG.get()), new ItemStack(AncientAetherItems.SKY_BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SKY_BLUE_MOA_EGG.get()), new ItemStack(AetherItems.BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.BLUE_MOA_EGG.get()), new ItemStack(AncientAetherItems.LAVENDER_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.LAVENDER_MOA_EGG.get()), new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), new ItemStack(AncientAetherItems.VIOLET_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VIOLET_MOA_EGG.get()), new ItemStack(AncientAetherItems.BURGUNDY_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientAetherItems.ANCIENT_RUNE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.SKYROOT_CHEST_BOAT.get()), new ItemStack(AncientAetherItems.HIGHSPROOT_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HIGHSPROOT_BOAT.get()), new ItemStack(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get()), new ItemStack(AncientAetherItems.SAKURA_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SAKURA_BOAT.get()), new ItemStack(AncientAetherItems.SAKURA_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLD_DUNGEON_KEY.get()), new ItemStack(AncientAetherItems.ANCIENT_DUNGEON_KEY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ANCIENT_DUNGEON_KEY.get()), new ItemStack(AncientAetherItems.LABORATORY_DUNGEON_KEY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()), new ItemStack(AncientAetherItems.AERONAUTIC_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GRAVITITE_HOE.get()), new ItemStack(AncientAetherItems.VALKYRUM_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_SWORD.get()), new ItemStack(AncientAetherItems.VALKYRUM_LANCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_LANCE.get()), new ItemStack(AncientAetherItems.VALKYRUM_SHOVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_SHOVEL.get()), new ItemStack(AncientAetherItems.VALKYRUM_PICKAXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_PICKAXE.get()), new ItemStack(AncientAetherItems.VALKYRUM_AXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_AXE.get()), new ItemStack(AncientAetherItems.VALKYRUM_HOE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_HOE.get()), new ItemStack(AncientAetherItems.ARKENZUS_PICKAXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_LANCE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_PICKAXE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_AXE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_SHOVEL.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_HOE.get()));
        }

        if (tab == AetherCreativeTabs.AETHER_ARMOR_AND_ACCESSORIES.get()) {
            event.getEntries().putAfter(new ItemStack(AetherItems.IRON_RING.get()), new ItemStack(AetherItems.GOLDEN_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_RING.get()), new ItemStack(AetherItems.ZANITE_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ZANITE_RING.get()), new ItemStack(AetherItems.ICE_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ICE_RING.get()), new ItemStack(AncientAetherItems.VALKYRUM_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_RING.get()), new ItemStack(AncientAetherItems.HERMES_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HERMES_RING.get()), new ItemStack(AncientAetherItems.ARKENIUM_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ARKENIUM_RING.get()), new ItemStack(AncientAetherItems.HEALTH_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HEALTH_RING.get()), new ItemStack(AncientAetherItems.ANCIENT_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ICE_PENDANT.get()), new ItemStack(AncientAetherItems.VALKYRUM_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_PENDANT.get()), new ItemStack(AncientAetherItems.HERMES_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HERMES_PENDANT.get()), new ItemStack(AncientAetherItems.ARKENIUM_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ARKENIUM_PENDANT.get()), new ItemStack(AncientAetherItems.HEALTH_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.HEALTH_PENDANT.get()), new ItemStack(AncientAetherItems.ANCIENT_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.IRON_BUBBLE.get()), new ItemStack(AetherItems.REGENERATION_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.REGENERATION_STONE.get()), new ItemStack(AncientAetherItems.STRENGTH_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GRAVITITE_GLOVES.get()), new ItemStack(AncientAetherItems.VALKYRUM_HELMET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_HELMET.get()), new ItemStack(AncientAetherItems.VALKYRUM_CHESTPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_CHESTPLATE.get()), new ItemStack(AncientAetherItems.VALKYRUM_LEGGINGS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_LEGGINGS.get()), new ItemStack(AncientAetherItems.VALKYRUM_BOOTS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VALKYRUM_BOOTS.get()), new ItemStack(AncientAetherItems.VALKYRUM_GLOVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.VALKYRIE_CAPE.get()), new ItemStack(AetherItems.INVISIBILITY_CLOAK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.SHIELD_OF_REPULSION.get()), new ItemStack(AncientAetherItems.SHIELD_OF_INEBRIATION.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SHIELD_OF_INEBRIATION.get()), new ItemStack(AncientAetherItems.SHIELD_OF_REMEDIATION.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_HELMET.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_CHESTPLATE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_LEGGINGS.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_BOOTS.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_GLOVES.get()));
            if (!ModList.get().isLoaded("aether_genesis")) {
                event.getEntries().putAfter(new ItemStack(AetherItems.RED_CAPE.get()), new ItemStack(AncientAetherItems.PINK_CAPE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_FOOD_AND_DRINKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherItems.ENCHANTED_BERRY.get()), new ItemStack(AncientAetherItems.GRAPES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_GUMMY_SWET.get()), new ItemStack(AncientAetherItems.FESTIVE_GUMMY_SWET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_INGREDIENTS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ENCHANTED_GRAVITITE.get()), new ItemStack(AncientAetherItems.VALKYRUM.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_SPAWN_EGGS.get()) {
            event.getEntries().putFirst(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientAetherItems.TURQUOISE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.TURQUOISE_MOA_EGG.get()), new ItemStack(AncientAetherItems.TEAL_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.TEAL_MOA_EGG.get()), new ItemStack(AncientAetherItems.SKY_BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.BLUE_MOA_EGG.get()), new ItemStack(AncientAetherItems.LAVENDER_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.LAVENDER_MOA_EGG.get()), new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.SAKURA_MOA_EGG.get()), new ItemStack(AncientAetherItems.VIOLET_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientAetherItems.VIOLET_MOA_EGG.get()), new ItemStack(AncientAetherItems.BURGUNDY_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_SWET_SPAWN_EGG.get()), new ItemStack(AncientAetherItems.FLUFFALO_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.AERBUNNY_SPAWN_EGG.get()), new ItemStack(AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.SENTRY_SPAWN_EGG.get()), new ItemStack(AncientAetherItems.ROOTHYRN_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.FIRE_MINION_SPAWN_EGG.get()), new ItemStack(AncientAetherItems.FESTIVE_SWET_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}