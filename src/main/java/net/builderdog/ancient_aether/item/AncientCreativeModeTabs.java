package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherCreativeTabs;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientConfig;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import static com.aetherteam.aether.item.AetherCreativeTabs.AETHER_BUILDING_BLOCKS;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientCreativeModeTabs {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab tab = event.getTab();

        if (tab == AETHER_BUILDING_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_WOOD.get()), new ItemStack(AncientBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientBlocks.HIGHSPROOT_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_WOOD.get()), new ItemStack(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get()), new ItemStack(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get()), new ItemStack(AncientBlocks.HIGHSPROOT_PLANKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_PLANKS.get()), new ItemStack(AncientBlocks.HIGHSPROOT_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_STAIRS.get()), new ItemStack(AncientBlocks.HIGHSPROOT_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_SLAB.get()), new ItemStack(AncientBlocks.HIGHSPROOT_FENCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_FENCE.get()), new ItemStack(AncientBlocks.HIGHSPROOT_FENCE_GATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_FENCE_GATE.get()), new ItemStack(AncientBlocks.HIGHSPROOT_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_DOOR.get()), new ItemStack(AncientBlocks.HIGHSPROOT_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_TRAPDOOR.get()), new ItemStack(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get()), new ItemStack(AncientBlocks.HIGHSPROOT_BUTTON.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_BUTTON.get()), new ItemStack(AncientBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_LOG.get()), new ItemStack(AncientBlocks.SAKURA_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_WOOD.get()), new ItemStack(AncientBlocks.STRIPPED_SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.STRIPPED_SAKURA_LOG.get()), new ItemStack(AncientBlocks.STRIPPED_SAKURA_WOOD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.STRIPPED_SAKURA_WOOD.get()), new ItemStack(AncientBlocks.SAKURA_PLANKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_PLANKS.get()), new ItemStack(AncientBlocks.SAKURA_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_STAIRS.get()), new ItemStack(AncientBlocks.SAKURA_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_SLAB.get()), new ItemStack(AncientBlocks.SAKURA_FENCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_FENCE.get()), new ItemStack(AncientBlocks.SAKURA_FENCE_GATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_FENCE_GATE.get()), new ItemStack(AncientBlocks.SAKURA_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_DOOR.get()), new ItemStack(AncientBlocks.SAKURA_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_TRAPDOOR.get()), new ItemStack(AncientBlocks.SAKURA_PRESSURE_PLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_PRESSURE_PLATE.get()), new ItemStack(AncientBlocks.SAKURA_BUTTON.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.HOLYSTONE_BRICKS.get()), new ItemStack(AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ENCHANTED_GRAVITITE.get()), new ItemStack(AncientBlocks.VALKYRUM_BLOCK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AEROGEL_WALL.get()), new ItemStack(AncientBlocks.AEROGEL_GLASS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGEL_GLASS.get()), new ItemStack(AncientBlocks.AEROGEL_GLASS_PANE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGEL_GLASS_PANE.get()), new ItemStack(AncientBlocks.AEROGEL_GLASS_DOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGEL_GLASS_DOOR.get()), new ItemStack(AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.FLUFFALO_WOOL.get()), new ItemStack(AncientBlocks.FLUFFALO_WOOL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.FLUFFALO_WOOL.get()), new ItemStack(AncientBlocks.FLUFFALO_CARPET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_DUNGEON_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.CARVED_WALL.get()), new ItemStack(AncientBlocks.CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CARVED_TILES.get()), new ItemStack(AncientBlocks.LOCKED_CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_CARVED_TILES.get()), new ItemStack(AncientBlocks.TRAPPED_CARVED_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TRAPPED_CARVED_TILES.get()), new ItemStack(AncientBlocks.CARVED_TILE_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CARVED_TILE_STAIRS.get()), new ItemStack(AncientBlocks.CARVED_TILE_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CARVED_TILE_SLAB.get()), new ItemStack(AncientBlocks.CARVED_TILE_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CARVED_TILE_WALL.get()), new ItemStack(AncientBlocks.CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CARVED_STONE_MOSAIC.get()), new ItemStack(AncientBlocks.LOCKED_CARVED_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()), new ItemStack(AncientBlocks.BOSS_DOORWAY_CARVED_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_SENTRY_STONE.get()), new ItemStack(AncientBlocks.WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.WYND_SENTRY_STONE.get()), new ItemStack(AncientBlocks.LOCKED_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_WYND_SENTRY_STONE.get()), new ItemStack(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get()), new ItemStack(AncientBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ANGELIC_WALL.get()), new ItemStack(AncientBlocks.ANGELIC_CORNER_BRICK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANGELIC_CORNER_BRICK.get()), new ItemStack(AncientBlocks.ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANGELIC_STONE_MOSAIC.get()), new ItemStack(AncientBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_LIGHT_ANGELIC_STONE.get()), new ItemStack(AncientBlocks.VALKYRIE_BRICKS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_BRICKS.get()), new ItemStack(AncientBlocks.VALKYRIE_BRICK_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_BRICK_STAIRS.get()), new ItemStack(AncientBlocks.VALKYRIE_BRICK_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_BRICK_SLAB.get()), new ItemStack(AncientBlocks.VALKYRIE_BRICK_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_BRICK_WALL.get()), new ItemStack(AncientBlocks.VALKYRIE_TILES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_TILES.get()), new ItemStack(AncientBlocks.VALKYRIE_TILE_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_TILE_STAIRS.get()), new ItemStack(AncientBlocks.VALKYRIE_TILE_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRIE_TILE_SLAB.get()), new ItemStack(AncientBlocks.VALKYRIE_TILE_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.HELLFIRE_WALL.get()), new ItemStack(AncientBlocks.HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HELLFIRE_STONE_MOSAIC.get()), new ItemStack(AncientBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.TREASURE_DOORWAY_LIGHT_HELLFIRE_STONE.get()), new ItemStack(AncientBlocks.AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGETIC_STONE.get()), new ItemStack(AncientBlocks.LOCKED_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_AEROGETIC_STONE.get()), new ItemStack(AncientBlocks.TRAPPED_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TRAPPED_AEROGETIC_STONE.get()), new ItemStack(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get()), new ItemStack(AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()), new ItemStack(AncientBlocks.AEROGETIC_STAIRS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGETIC_STAIRS.get()), new ItemStack(AncientBlocks.AEROGETIC_SLAB.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGETIC_SLAB.get()), new ItemStack(AncientBlocks.AEROGETIC_WALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGETIC_WALL.get()), new ItemStack(AncientBlocks.AEROGETIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AEROGETIC_STONE_MOSAIC.get()), new ItemStack(AncientBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get()), new ItemStack(AncientBlocks.AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.LOCKED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.TRAPPED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TRAPPED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), new ItemStack(AncientBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.CHEST_MIMIC.get()), new ItemStack(AncientBlocks.ANCIENT_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_SENTRY_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_SENTRY_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_ANGELIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_ANGELIC_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_HELLFIRE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_HELLFIRE_VASE.get()), new ItemStack(AncientBlocks.ANCIENT_AEROGETIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_NATURAL_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.QUICKSOIL.get()), new ItemStack(AncientBlocks.GRAVITY_GRAVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.GRAVITY_GRAVEL.get()), new ItemStack(AncientBlocks.WYND_ICE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.WYND_ICE.get()), new ItemStack(AncientBlocks.VALKYRIE_CLAY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_ORE.get()), new ItemStack(AncientBlocks.AETHER_QUARTZ_ORE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GRAVITITE_ORE.get()), new ItemStack(AncientBlocks.VALKYRUM_ORE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRUM_ORE.get()), new ItemStack(AetherBlocks.AEROGEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LOG.get()), new ItemStack(AncientBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LEAVES.get()), new ItemStack(AncientBlocks.SKYROOT_PINE_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_LEAVES.get()), new ItemStack(AncientBlocks.CRYSTAL_SKYROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CRYSTAL_SKYROOT_LEAVES.get()), new ItemStack(AncientBlocks.ENCHANTED_SKYROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_SAPLING.get()), new ItemStack(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get()), new ItemStack(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SKYROOT_PINE_LEAVES.get()), new ItemStack(AncientBlocks.HIGHSPROOT_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_LEAVES.get()), new ItemStack(AncientBlocks.SAKURA_LEAVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_SAPLING.get()), new ItemStack(AncientBlocks.SKYROOT_PINE_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SKYROOT_PINE_SAPLING.get()), new ItemStack(AncientBlocks.HIGHSPROOT_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_SAPLING.get()), new ItemStack(AncientBlocks.SAKURA_SAPLING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.WHITE_FLOWER.get()), new ItemStack(AncientBlocks.SUNSET_ROSE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SUNSET_ROSE.get()), new ItemStack(AncientBlocks.SKY_BLUES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SKY_BLUES.get()), new ItemStack(AncientBlocks.WYND_THISTLE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.WYND_THISTLE.get()), new ItemStack(AncientBlocks.ELEVETIA.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.BERRY_BUSH_STEM.get()), new ItemStack(AncientBlocks.SKY_GRASS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.BLUE_AERCLOUD.get()), new ItemStack(AncientBlocks.VIOLET_AERCLOUD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if (AncientConfig.COMMON.experimental_features.get()) {
                event.getEntries().putAfter(new ItemStack(AncientBlocks.VALKYRUM_ORE.get()), new ItemStack(AncientBlocks.ATMOSINE_CRYSTAL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (tab == AetherCreativeTabs.AETHER_FUNCTIONAL_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.AMBROSIUM_TORCH.get()), new ItemStack(AncientBlocks.AMBROSIUM_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AMBROSIUM_LANTERN.get()), new ItemStack(AncientBlocks.WYND_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.WYND_LANTERN.get()), new ItemStack(AncientBlocks.SUN_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SUN_LANTERN.get()), new ItemStack(AncientBlocks.AMBROSIUM_CAMPFIRE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_BOOKSHELF.get()), new ItemStack(AncientBlocks.HIGHSPROOT_BOOKSHELF.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_BOOKSHELF.get()), new ItemStack(AncientBlocks.SAKURA_BOOKSHELF.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherBlocks.SKYROOT_HANGING_SIGN.get()), new ItemStack(AncientBlocks.HIGHSPROOT_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_SIGN.get()), new ItemStack(AncientBlocks.HIGHSPROOT_HANGING_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HIGHSPROOT_HANGING_SIGN.get()), new ItemStack(AncientBlocks.SAKURA_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SAKURA_SIGN.get()), new ItemStack(AncientBlocks.SAKURA_HANGING_SIGN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.TREASURE_CHEST.get()), new ItemStack(AncientBlocks.HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.MOSSY_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.MOSSY_HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.FROZEN_HOLYSTONE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.FROZEN_HOLYSTONE_VASE.get()), new ItemStack(AncientBlocks.SENTRY_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SENTRY_VASE.get()), new ItemStack(AncientBlocks.ANGELIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANGELIC_VASE.get()), new ItemStack(AncientBlocks.HELLFIRE_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.HELLFIRE_VASE.get()), new ItemStack(AncientBlocks.AEROGETIC_VASE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.AMBROSIUM_CAMPFIRE.get()), new ItemStack(AncientBlocks.ANCIENT_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.ANCIENT_OBELISK.get()), new ItemStack(AncientBlocks.POWERED_OBELISK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.POWERED_OBELISK.get()), new ItemStack(AncientBlocks.SLIDER_PROTOTYPE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_REDSTONE_BLOCKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.INCUBATOR.get()), new ItemStack(AncientBlocks.WIND_BLOWER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherBlocks.ALTAR.get()), new ItemStack(AncientBlocks.FLUFFALO_WOOL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientBlocks.SLIDER_PROTOTYPE.get()), new ItemStack(AncientBlocks.SLIDER_PROTOTYPE.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
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
            event.getEntries().putAfter(new ItemStack(AetherItems.VAMPIRE_BLADE.get()), new ItemStack(AncientItems.ANCIENT_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.ANCIENT_SWORD.get()), new ItemStack(AetherItems.CANDY_CANE_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_DART_SHOOTER.get()), new ItemStack(AetherItems.POISON_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.POISON_DART_SHOOTER.get()), new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientItems.TURQUOISE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.TURQUOISE_MOA_EGG.get()), new ItemStack(AncientItems.TEAL_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.TEAL_MOA_EGG.get()), new ItemStack(AncientItems.SKY_BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SKY_BLUE_MOA_EGG.get()), new ItemStack(AetherItems.BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.BLUE_MOA_EGG.get()), new ItemStack(AncientItems.LAVENDER_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.LAVENDER_MOA_EGG.get()), new ItemStack(AncientItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SAKURA_MOA_EGG.get()), new ItemStack(AncientItems.VIOLET_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VIOLET_MOA_EGG.get()), new ItemStack(AncientItems.BURGUNDY_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientItems.ANCIENT_RUNE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.SKYROOT_CHEST_BOAT.get()), new ItemStack(AncientItems.HIGHSPROOT_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.HIGHSPROOT_BOAT.get()), new ItemStack(AncientItems.HIGHSPROOT_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.HIGHSPROOT_CHEST_BOAT.get()), new ItemStack(AncientItems.SAKURA_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SAKURA_BOAT.get()), new ItemStack(AncientItems.SAKURA_CHEST_BOAT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLD_DUNGEON_KEY.get()), new ItemStack(AncientItems.LABORATORY_DUNGEON_KEY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.LABORATORY_DUNGEON_KEY.get()), new ItemStack(AncientItems.ANCIENT_DUNGEON_KEY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()), new ItemStack(AncientItems.AERONAUTIC_DART_SHOOTER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GRAVITITE_HOE.get()), new ItemStack(AncientItems.DIVINE_SHOVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.DIVINE_SHOVEL.get()), new ItemStack(AncientItems.DIVINE_PICKAXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.DIVINE_PICKAXE.get()), new ItemStack(AncientItems.DIVINE_AXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.DIVINE_AXE.get()), new ItemStack(AncientItems.DIVINE_HOE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.DIVINE_HOE.get()), new ItemStack(AncientItems.VALKYRUM_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_SWORD.get()), new ItemStack(AncientItems.VALKYRUM_LANCE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_LANCE.get()), new ItemStack(AncientItems.VALKYRUM_SHOVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_SHOVEL.get()), new ItemStack(AncientItems.VALKYRUM_PICKAXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_PICKAXE.get()), new ItemStack(AncientItems.VALKYRUM_AXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_AXE.get()), new ItemStack(AncientItems.VALKYRUM_HOE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
            event.getEntries().putAfter(new ItemStack(AetherItems.ICE_RING.get()), new ItemStack(AncientItems.VALKYRUM_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_RING.get()), new ItemStack(AncientItems.HERMES_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.HERMES_RING.get()), new ItemStack(AncientItems.WARRIOR_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.WARRIOR_RING.get()), new ItemStack(AncientItems.GROWTH_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.GROWTH_RING.get()), new ItemStack(AncientItems.ANCIENT_RING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.ICE_PENDANT.get()), new ItemStack(AncientItems.VALKYRUM_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_PENDANT.get()), new ItemStack(AncientItems.HERMES_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.HERMES_PENDANT.get()), new ItemStack(AncientItems.WARRIOR_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.WARRIOR_PENDANT.get()), new ItemStack(AncientItems.GROWTH_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.GROWTH_PENDANT.get()), new ItemStack(AncientItems.ANCIENT_PENDANT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.IRON_BUBBLE.get()), new ItemStack(AetherItems.REGENERATION_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.REGENERATION_STONE.get()), new ItemStack(AncientItems.STRENGTH_STONE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GRAVITITE_GLOVES.get()), new ItemStack(AncientItems.VALKYRUM_HELMET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_HELMET.get()), new ItemStack(AncientItems.VALKYRUM_CHESTPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_CHESTPLATE.get()), new ItemStack(AncientItems.VALKYRUM_LEGGINGS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_LEGGINGS.get()), new ItemStack(AncientItems.VALKYRUM_BOOTS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRUM_BOOTS.get()), new ItemStack(AncientItems.VALKYRUM_GLOVES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.VALKYRIE_CAPE.get()), new ItemStack(AetherItems.INVISIBILITY_CLOAK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.SHIELD_OF_REPULSION.get()), new ItemStack(AncientItems.SHIELD_OF_INEBRIATION.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SHIELD_OF_INEBRIATION.get()), new ItemStack(AncientItems.SHIELD_OF_REMEDIATION.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_HELMET.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_CHESTPLATE.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_LEGGINGS.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_BOOTS.get()));
            event.getEntries().remove(new ItemStack(AetherItems.VALKYRIE_GLOVES.get()));
        }

        if (tab == AetherCreativeTabs.AETHER_FOOD_AND_DRINKS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherItems.ENCHANTED_BERRY.get()), new ItemStack(AncientItems.GRAPES.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.GRAPES.get()), new ItemStack(AncientItems.SLAMMBERRY.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_GUMMY_SWET.get()), new ItemStack(AncientItems.FESTIVE_GUMMY_SWET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_INGREDIENTS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherBlocks.ENCHANTED_GRAVITITE.get()), new ItemStack(AncientItems.VALKYRUM.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_AMBER.get()), new ItemStack(AncientItems.VALKYRIE_CLAY_BALL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VALKYRIE_CLAY_BALL.get()), new ItemStack(AncientItems.VALKYRIE_BRICK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(AncientItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (tab == AetherCreativeTabs.AETHER_SPAWN_EGGS.get()) {
            event.getEntries().putAfter(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), new ItemStack(AncientItems.TURQUOISE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.TURQUOISE_MOA_EGG.get()), new ItemStack(AncientItems.TEAL_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.TEAL_MOA_EGG.get()), new ItemStack(AncientItems.SKY_BLUE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.BLUE_MOA_EGG.get()), new ItemStack(AncientItems.LAVENDER_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.LAVENDER_MOA_EGG.get()), new ItemStack(AncientItems.SAKURA_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.SAKURA_MOA_EGG.get()), new ItemStack(AncientItems.VIOLET_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AncientItems.VIOLET_MOA_EGG.get()), new ItemStack(AncientItems.BURGUNDY_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.GOLDEN_SWET_SPAWN_EGG.get()), new ItemStack(AncientItems.FLUFFALO_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(AetherItems.AERBUNNY_SPAWN_EGG.get()), new ItemStack(AncientItems.AERONAUTIC_LEAPER_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.SHEEPUFF_SPAWN_EGG.get()), new ItemStack(AncientItems.SLAMMROOT_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(new ItemStack(AetherItems.FIRE_MINION_SPAWN_EGG.get()), new ItemStack(AncientItems.FESTIVE_SWET_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}