package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherCreativeTabs;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class AncientAetherCreativeModeTabs {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab tab = event.getTab();

        if (tab == AetherCreativeTabs.AETHER_BUILDING_BLOCKS.get()) {
            putAfter(event, AetherBlocks.GOLDEN_OAK_WOOD.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_LOG.get(), AncientAetherBlocks.HIGHSPROOT_WOOD.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_WOOD.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
            putAfter(event, AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get());
            putAfter(event, AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), AncientAetherBlocks.HIGHSPROOT_SLAB.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_SLAB.get(), AncientAetherBlocks.HIGHSPROOT_FENCE.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), AncientAetherBlocks.HIGHSPROOT_DOOR.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_DOOR.get(), AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), AncientAetherBlocks.HIGHSPROOT_BUTTON.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), AncientAetherBlocks.SAKURA_LOG.get());
            putAfter(event, AncientAetherBlocks.SAKURA_LOG.get(), AncientAetherBlocks.SAKURA_WOOD.get());
            putAfter(event, AncientAetherBlocks.SAKURA_WOOD.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
            putAfter(event, AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
            putAfter(event, AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), AncientAetherBlocks.SAKURA_PLANKS.get());
            putAfter(event, AncientAetherBlocks.SAKURA_PLANKS.get(), AncientAetherBlocks.SAKURA_STAIRS.get());
            putAfter(event, AncientAetherBlocks.SAKURA_STAIRS.get(), AncientAetherBlocks.SAKURA_SLAB.get());
            putAfter(event, AncientAetherBlocks.SAKURA_SLAB.get(), AncientAetherBlocks.SAKURA_FENCE.get());
            putAfter(event, AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_FENCE_GATE.get());
            putAfter(event, AncientAetherBlocks.SAKURA_FENCE_GATE.get(), AncientAetherBlocks.SAKURA_DOOR.get());
            putAfter(event, AncientAetherBlocks.SAKURA_DOOR.get(), AncientAetherBlocks.SAKURA_TRAPDOOR.get());
            putAfter(event, AncientAetherBlocks.SAKURA_TRAPDOOR.get(), AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
            putAfter(event, AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), AncientAetherBlocks.SAKURA_BUTTON.get());
            putAfter(event, AetherBlocks.HOLYSTONE_BRICKS.get(), AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
            putAfter(event, AetherBlocks.ENCHANTED_GRAVITITE.get(), AncientAetherBlocks.VALKYRUM_BLOCK.get());
            putAfter(event, AetherBlocks.AEROGEL_WALL.get(), AncientAetherBlocks.AEROGEL_GLASS.get());
            putAfter(event, AncientAetherBlocks.AEROGEL_GLASS.get(), AncientAetherBlocks.AEROGEL_GLASS_PANE.get());
            putAfter(event, AncientAetherBlocks.AEROGEL_GLASS_PANE.get(), AncientAetherBlocks.AEROGEL_GLASS_DOOR.get());
            putAfter(event, AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get());
            putAfter(event, AncientAetherBlocks.FLUFFALO_WOOL.get(), AncientAetherBlocks.FLUFFALO_WOOL.get());
            putAfter(event, AncientAetherBlocks.FLUFFALO_WOOL.get(), AncientAetherBlocks.FLUFFALO_CARPET.get());
        }

        if (tab == AetherCreativeTabs.AETHER_DUNGEON_BLOCKS.get()) {
            putAfter(event, AetherBlocks.CARVED_WALL.get(), AncientAetherBlocks.CARVED_TILES.get());
            putAfter(event, AncientAetherBlocks.CARVED_TILES.get(), AncientAetherBlocks.LOCKED_CARVED_TILES.get());
            putAfter(event, AncientAetherBlocks.LOCKED_CARVED_TILES.get(), AncientAetherBlocks.TRAPPED_CARVED_TILES.get());
            putAfter(event, AncientAetherBlocks.TRAPPED_CARVED_TILES.get(), AncientAetherBlocks.CARVED_TILE_STAIRS.get());
            putAfter(event, AncientAetherBlocks.CARVED_TILE_STAIRS.get(), AncientAetherBlocks.CARVED_TILE_SLAB.get());
            putAfter(event, AncientAetherBlocks.CARVED_TILE_SLAB.get(), AncientAetherBlocks.CARVED_TILE_WALL.get());
            putAfter(event, AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
            putAfter(event, AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get());
            putAfter(event, AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get(), AncientAetherBlocks.BOSS_DOORWAY_CARVED_STONE.get());
            putAfter(event, AetherBlocks.TREASURE_DOORWAY_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
            putAfter(event, AncientAetherBlocks.WYND_SENTRY_STONE.get(), AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get());
            putAfter(event, AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get(), AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get());
            putAfter(event, AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get(), AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get());
            putAfter(event, AetherBlocks.ANGELIC_WALL.get(), AncientAetherBlocks.ANGELIC_CORNER_BRICK.get());
            putAfter(event, AncientAetherBlocks.ANGELIC_CORNER_BRICK.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
            putAfter(event, AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get());
            putAfter(event, AetherBlocks.TREASURE_DOORWAY_LIGHT_ANGELIC_STONE.get(), AncientAetherBlocks.VALKYRIE_BRICKS.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_BRICKS.get(), AncientAetherBlocks.VALKYRIE_BRICK_STAIRS.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_BRICK_STAIRS.get(), AncientAetherBlocks.VALKYRIE_BRICK_SLAB.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_BRICK_SLAB.get(), AncientAetherBlocks.VALKYRIE_BRICK_WALL.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_BRICK_WALL.get(), AncientAetherBlocks.VALKYRIE_TILES.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_TILES.get(), AncientAetherBlocks.VALKYRIE_TILE_STAIRS.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_TILE_STAIRS.get(), AncientAetherBlocks.VALKYRIE_TILE_SLAB.get());
            putAfter(event, AncientAetherBlocks.VALKYRIE_TILE_SLAB.get(), AncientAetherBlocks.VALKYRIE_TILE_WALL.get());
            putAfter(event, AetherBlocks.HELLFIRE_WALL.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
            putAfter(event, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get());
            putAfter(event, AetherBlocks.TREASURE_DOORWAY_LIGHT_HELLFIRE_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
            putAfter(event, AncientAetherBlocks.AEROGETIC_STONE.get(), AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get());
            putAfter(event, AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(), AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get(), AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get());
            putAfter(event, AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STAIRS.get());
            putAfter(event, AncientAetherBlocks.AEROGETIC_STAIRS.get(), AncientAetherBlocks.AEROGETIC_SLAB.get());
            putAfter(event, AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_WALL.get());
            putAfter(event, AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get());
            putAfter(event, AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get(), AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get());
            putAfter(event, AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.AERONAUTIC_STONE.get(), AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get(), AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get(), AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get(), AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get());
            putAfter(event, AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.LOCKED_AEROGEL.get());
            putAfter(event, AetherBlocks.CHEST_MIMIC.get(), AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.ANCIENT_SENTRY_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(), AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get(), AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get(), AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get());
        }

        if (tab == AetherCreativeTabs.AETHER_NATURAL_BLOCKS.get()) {
            putAfter(event, AetherBlocks.QUICKSOIL.get(), AncientAetherBlocks.GRAVITY_GRAVEL.get());
            putAfter(event, AncientAetherBlocks.GRAVITY_GRAVEL.get(), AncientAetherBlocks.WYND_ICE.get());
            putAfter(event, AncientAetherBlocks.WYND_ICE.get(), AncientAetherBlocks.VALKYRIE_CLAY.get());
            putAfter(event, AetherBlocks.AMBROSIUM_ORE.get(), AncientAetherBlocks.AETHER_QUARTZ_ORE.get());
            putAfter(event, AetherBlocks.GRAVITITE_ORE.get(), AncientAetherBlocks.VALKYRUM_ORE.get());
            putAfter(event, AncientAetherBlocks.VALKYRUM_ORE.get(), AetherBlocks.AEROGEL.get());
            event.getEntries().putAfter(new ItemStack(AetherBlocks.GOLDEN_OAK_LOG.get()), new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.HIGHSPROOT_LOG.get()), new ItemStack(AncientAetherBlocks.SAKURA_LOG.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            putAfter(event, AetherBlocks.GOLDEN_OAK_LEAVES.get(), AncientAetherBlocks.SKYROOT_PINE_LEAVES.get());
            putAfter(event, AetherBlocks.SKYROOT_LEAVES.get(), AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get());
            putAfter(event, AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get(), AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get());
            putAfter(event, AetherBlocks.SKYROOT_SAPLING.get(), AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get());
            putAfter(event, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get());
            putAfter(event, AncientAetherBlocks.SKYROOT_PINE_LEAVES.get(), AncientAetherBlocks.HIGHSPROOT_LEAVES.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), AncientAetherBlocks.SAKURA_LEAVES.get());
            putAfter(event, AetherBlocks.GOLDEN_OAK_SAPLING.get(), AncientAetherBlocks.SKYROOT_PINE_SAPLING.get());
            putAfter(event, AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), AncientAetherBlocks.SAKURA_SAPLING.get());
            putAfter(event, AetherBlocks.WHITE_FLOWER.get(), AncientAetherBlocks.SUNSET_ROSE.get());
            putAfter(event, AncientAetherBlocks.SUNSET_ROSE.get(), AncientAetherBlocks.SKY_BLUES.get());
            putAfter(event, AncientAetherBlocks.SKY_BLUES.get(), AncientAetherBlocks.WYND_THISTLE.get());
            putAfter(event, AncientAetherBlocks.WYND_THISTLE.get(), AncientAetherBlocks.ELEVETIA.get());
            putBefore(event, AetherBlocks.BERRY_BUSH_STEM.get(), AncientAetherBlocks.SKY_GRASS.get());
            putAfter(event, AetherBlocks.BLUE_AERCLOUD.get(), AncientAetherBlocks.VIOLET_AERCLOUD.get());
            if (AncientAetherConfig.COMMON.experimental_features.get()) {
                putAfter(event, AncientAetherBlocks.VALKYRUM_ORE.get(), AncientAetherBlocks.ATMOSINE_CRYSTAL.get());
            }
        }

        if (tab == AetherCreativeTabs.AETHER_FUNCTIONAL_BLOCKS.get()) {
            putAfter(event, AetherBlocks.AMBROSIUM_TORCH.get(), AncientAetherBlocks.AMBROSIUM_LANTERN.get());
            putAfter(event, AncientAetherBlocks.AMBROSIUM_LANTERN.get(), AncientAetherBlocks.WYND_LANTERN.get());
            putAfter(event, AncientAetherBlocks.WYND_LANTERN.get(), AncientAetherBlocks.SUN_LANTERN.get());
            putAfter(event, AncientAetherBlocks.SUN_LANTERN.get(), AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get());
            putAfter(event, AetherBlocks.SKYROOT_BOOKSHELF.get(), AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientAetherBlocks.SAKURA_BOOKSHELF.get());
            putAfter(event, AetherBlocks.SKYROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_SIGN.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get());
            putAfter(event, AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_SIGN.get());
            putAfter(event, AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_HANGING_SIGN.get());
            putBefore(event, AetherBlocks.TREASURE_CHEST.get(), AncientAetherBlocks.HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.HOLYSTONE_VASE.get(), AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get(), AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
            putAfter(event, AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.SENTRY_VASE.get());
            putAfter(event, AncientAetherBlocks.SENTRY_VASE.get(), AncientAetherBlocks.ANGELIC_VASE.get());
            putAfter(event, AncientAetherBlocks.ANGELIC_VASE.get(), AncientAetherBlocks.HELLFIRE_VASE.get());
            putAfter(event, AncientAetherBlocks.HELLFIRE_VASE.get(), AncientAetherBlocks.AEROGETIC_VASE.get());
            putAfter(event, AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get(), AncientAetherBlocks.ANCIENT_OBELISK.get());
            putAfter(event, AncientAetherBlocks.ANCIENT_OBELISK.get(), AncientAetherBlocks.POWERED_OBELISK.get());
            putAfter(event, AncientAetherBlocks.POWERED_OBELISK.get(), AncientAetherBlocks.SLIDER_PROTOTYPE.get());
        }

        if (tab == AetherCreativeTabs.AETHER_REDSTONE_BLOCKS.get()) {
            putAfter(event, AetherBlocks.INCUBATOR.get(), AncientAetherBlocks.WIND_BLOWER.get());
            putBefore(event, AetherBlocks.ALTAR.get(), AncientAetherBlocks.FLUFFALO_WOOL.get());
            event.getEntries().putAfter(new ItemStack(AncientAetherBlocks.SLIDER_PROTOTYPE.get()), new ItemStack(AncientAetherBlocks.SLIDER_PROTOTYPE.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        }

        if (tab == AetherCreativeTabs.AETHER_EQUIPMENT_AND_UTILITIES.get()) {
            remove(event, AetherItems.FLAMING_SWORD.get());
            remove(event, AetherItems.CANDY_CANE_SWORD.get());
            remove(event, AetherItems.VAMPIRE_BLADE.get());
            remove(event, AetherItems.HOLY_SWORD.get());
            remove(event, AetherItems.LIGHTNING_SWORD.get());
            remove(event, AetherItems.VALKYRIE_LANCE.get());
            remove(event, AetherItems.VALKYRIE_PICKAXE.get());
            remove(event, AetherItems.VALKYRIE_AXE.get());
            remove(event, AetherItems.VALKYRIE_SHOVEL.get());
            remove(event, AetherItems.VALKYRIE_HOE.get());
            putAfter(event, AetherItems.GRAVITITE_HOE.get(), AncientAetherItems.DIVINE_SHOVEL.get());
            putAfter(event, AncientAetherItems.DIVINE_SHOVEL.get(), AncientAetherItems.DIVINE_PICKAXE.get());
            putAfter(event, AncientAetherItems.DIVINE_PICKAXE.get(), AncientAetherItems.DIVINE_AXE.get());
            putAfter(event, AncientAetherItems.DIVINE_AXE.get(), AncientAetherItems.DIVINE_HOE.get());
            putAfter(event, AncientAetherItems.DIVINE_HOE.get(), AncientAetherItems.VALKYRUM_SWORD.get());
            putAfter(event, AncientAetherItems.VALKYRUM_SWORD.get(), AncientAetherItems.VALKYRUM_LANCE.get());
            putAfter(event, AncientAetherItems.VALKYRUM_LANCE.get(), AncientAetherItems.VALKYRUM_SHOVEL.get());
            putAfter(event, AncientAetherItems.VALKYRUM_SHOVEL.get(), AncientAetherItems.VALKYRUM_PICKAXE.get());
            putAfter(event, AncientAetherItems.VALKYRUM_PICKAXE.get(), AncientAetherItems.VALKYRUM_AXE.get());
            putAfter(event, AncientAetherItems.VALKYRUM_AXE.get(), AncientAetherItems.VALKYRUM_HOE.get());
            putAfter(event, AncientAetherItems.VALKYRUM_HOE.get(), AetherItems.FLAMING_SWORD.get());
            putAfter(event, AetherItems.FLAMING_SWORD.get(), AetherItems.LIGHTNING_SWORD.get());
            putAfter(event, AetherItems.LIGHTNING_SWORD.get(), AetherItems.HOLY_SWORD.get());
            putAfter(event, AetherItems.HOLY_SWORD.get(), AetherItems.VAMPIRE_BLADE.get());
            putAfter(event, AetherItems.VAMPIRE_BLADE.get(), AncientAetherItems.ANCIENT_SWORD.get());
            putAfter(event, AncientAetherItems.ANCIENT_SWORD.get(), AetherItems.CANDY_CANE_SWORD.get());
            putAfter(event, AetherItems.GOLDEN_DART_SHOOTER.get(), AetherItems.POISON_DART_SHOOTER.get());
            putAfter(event, AetherItems.POISON_DART_SHOOTER.get(), AetherItems.ENCHANTED_DART_SHOOTER.get());
            putAfter(event, AetherItems.ENCHANTED_DART_SHOOTER.get(), AncientAetherItems.AERONAUTIC_DART_SHOOTER.get());
            putAfter(event, AetherItems.WHITE_MOA_EGG.get(), AncientAetherItems.TURQUOISE_MOA_EGG.get());
            putAfter(event, AncientAetherItems.TURQUOISE_MOA_EGG.get(), AncientAetherItems.TEAL_MOA_EGG.get());
            putAfter(event, AncientAetherItems.TEAL_MOA_EGG.get(), AncientAetherItems.SKY_BLUE_MOA_EGG.get());
            putAfter(event, AncientAetherItems.SKY_BLUE_MOA_EGG.get(), AetherItems.BLUE_MOA_EGG.get());
            putAfter(event, AetherItems.BLUE_MOA_EGG.get(), AncientAetherItems.LAVENDER_MOA_EGG.get());
            putAfter(event, AncientAetherItems.LAVENDER_MOA_EGG.get(), AncientAetherItems.SAKURA_MOA_EGG.get());
            putAfter(event, AncientAetherItems.SAKURA_MOA_EGG.get(), AncientAetherItems.VIOLET_MOA_EGG.get());
            putAfter(event, AncientAetherItems.VIOLET_MOA_EGG.get(), AncientAetherItems.BURGUNDY_MOA_EGG.get());
            putBefore(event, AetherItems.WHITE_MOA_EGG.get(), AncientAetherItems.ANCIENT_RUNE.get());
            putAfter(event, AetherItems.SKYROOT_CHEST_BOAT.get(), AncientAetherItems.HIGHSPROOT_BOAT.get());
            putAfter(event, AncientAetherItems.HIGHSPROOT_BOAT.get(), AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get());
            putAfter(event, AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), AncientAetherItems.SAKURA_BOAT.get());
            putAfter(event, AncientAetherItems.SAKURA_BOAT.get(), AncientAetherItems.SAKURA_CHEST_BOAT.get());
            putAfter(event, AetherItems.GOLD_DUNGEON_KEY.get(), AncientAetherItems.LABORATORY_DUNGEON_KEY.get());
            putAfter(event, AncientAetherItems.LABORATORY_DUNGEON_KEY.get(), AncientAetherItems.ANCIENT_DUNGEON_KEY.get());
        }

        if (tab == AetherCreativeTabs.AETHER_ARMOR_AND_ACCESSORIES.get()) {
            remove(event, AetherItems.VALKYRIE_HELMET.get());
            remove(event, AetherItems.VALKYRIE_CHESTPLATE.get());
            remove(event, AetherItems.VALKYRIE_LEGGINGS.get());
            remove(event, AetherItems.VALKYRIE_BOOTS.get());
            remove(event, AetherItems.VALKYRIE_GLOVES.get());
            putAfter(event, AetherItems.IRON_RING.get(), AetherItems.GOLDEN_RING.get());
            putAfter(event, AetherItems.GOLDEN_RING.get(), AetherItems.ZANITE_RING.get());
            putAfter(event, AetherItems.ZANITE_RING.get(), AetherItems.ICE_RING.get());
            putAfter(event, AetherItems.ICE_RING.get(), AncientAetherItems.VALKYRUM_RING.get());
            putAfter(event, AncientAetherItems.VALKYRUM_RING.get(), AncientAetherItems.HERMES_RING.get());
            putAfter(event, AncientAetherItems.HERMES_RING.get(), AncientAetherItems.WARRIOR_RING.get());
            putAfter(event, AncientAetherItems.WARRIOR_RING.get(), AncientAetherItems.GROWTH_RING.get());
            putAfter(event, AncientAetherItems.GROWTH_RING.get(), AncientAetherItems.ANCIENT_RING.get());
            putAfter(event, AetherItems.ICE_PENDANT.get(), AncientAetherItems.VALKYRUM_PENDANT.get());
            putAfter(event, AncientAetherItems.VALKYRUM_PENDANT.get(), AncientAetherItems.HERMES_PENDANT.get());
            putAfter(event, AncientAetherItems.HERMES_PENDANT.get(), AncientAetherItems.WARRIOR_PENDANT.get());
            putAfter(event, AncientAetherItems.WARRIOR_PENDANT.get(), AncientAetherItems.GROWTH_PENDANT.get());
            putAfter(event, AncientAetherItems.GROWTH_PENDANT.get(), AncientAetherItems.ANCIENT_PENDANT.get());
            putAfter(event, AetherItems.IRON_BUBBLE.get(), AetherItems.REGENERATION_STONE.get());
            putAfter(event, AetherItems.REGENERATION_STONE.get(), AncientAetherItems.STRENGTH_STONE.get());
            putAfter(event, AetherItems.GRAVITITE_GLOVES.get(), AncientAetherItems.VALKYRUM_HELMET.get());
            putAfter(event, AncientAetherItems.VALKYRUM_HELMET.get(), AncientAetherItems.VALKYRUM_CHESTPLATE.get());
            putAfter(event, AncientAetherItems.VALKYRUM_CHESTPLATE.get(), AncientAetherItems.VALKYRUM_LEGGINGS.get());
            putAfter(event, AncientAetherItems.VALKYRUM_LEGGINGS.get(), AncientAetherItems.VALKYRUM_BOOTS.get());
            putAfter(event, AncientAetherItems.VALKYRUM_BOOTS.get(), AncientAetherItems.VALKYRUM_GLOVES.get());
            putAfter(event, AetherItems.VALKYRIE_CAPE.get(), AetherItems.INVISIBILITY_CLOAK.get());
            putAfter(event, AetherItems.SHIELD_OF_REPULSION.get(), AncientAetherItems.SHIELD_OF_INEBRIATION.get());
            putAfter(event, AncientAetherItems.SHIELD_OF_INEBRIATION.get(), AncientAetherItems.SHIELD_OF_REMEDIATION.get());
        }

        if (tab == AetherCreativeTabs.AETHER_FOOD_AND_DRINKS.get()) {
            putAfter(event, AetherItems.ENCHANTED_BERRY.get(), AncientAetherItems.GRAPES.get());
            putAfter(event, AncientAetherItems.GRAPES.get(), AncientAetherItems.SLAMMBERRY.get());
            putAfter(event, AetherItems.GOLDEN_GUMMY_SWET.get(), AncientAetherItems.FESTIVE_GUMMY_SWET.get());
        }

        if (tab == AetherCreativeTabs.AETHER_INGREDIENTS.get()) {
            putAfter(event, AetherBlocks.ENCHANTED_GRAVITITE.get(), AncientAetherItems.VALKYRUM.get());
            putAfter(event, AetherItems.GOLDEN_AMBER.get(), AncientAetherItems.VALKYRIE_CLAY_BALL.get());
            putAfter(event, AncientAetherItems.VALKYRIE_CLAY_BALL.get(), AncientAetherItems.VALKYRIE_BRICK.get());
            putAfter(event, AetherItems.SWET_BALL.get(), AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get());
            putAfter(event, AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get(), AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        }

        if (tab == AetherCreativeTabs.AETHER_SPAWN_EGGS.get()) {
            remove(event, AetherItems.WHITE_MOA_EGG.get());
            event.getEntries().putFirst(new ItemStack(AetherItems.WHITE_MOA_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            putAfter(event, AetherItems.WHITE_MOA_EGG.get(), AncientAetherItems.TURQUOISE_MOA_EGG.get());
            putAfter(event, AncientAetherItems.TURQUOISE_MOA_EGG.get(), AncientAetherItems.TEAL_MOA_EGG.get());
            putAfter(event, AncientAetherItems.TEAL_MOA_EGG.get(), AncientAetherItems.SKY_BLUE_MOA_EGG.get());
            putAfter(event, AetherItems.BLUE_MOA_EGG.get(), AncientAetherItems.LAVENDER_MOA_EGG.get());
            putAfter(event, AncientAetherItems.LAVENDER_MOA_EGG.get(), AncientAetherItems.SAKURA_MOA_EGG.get());
            putAfter(event, AncientAetherItems.SAKURA_MOA_EGG.get(), AncientAetherItems.VIOLET_MOA_EGG.get());
            putAfter(event, AncientAetherItems.VIOLET_MOA_EGG.get(), AncientAetherItems.BURGUNDY_MOA_EGG.get());
            putAfter(event, AetherItems.GOLDEN_SWET_SPAWN_EGG.get(), AncientAetherItems.FLUFFALO_SPAWN_EGG.get());
            putAfter(event, AetherItems.AERBUNNY_SPAWN_EGG.get(), AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG.get());
            putBefore(event, AetherItems.SHEEPUFF_SPAWN_EGG.get(), AncientAetherItems.SLAMMROOT_SPAWN_EGG.get());
            putBefore(event, AetherItems.FIRE_MINION_SPAWN_EGG.get(), AncientAetherItems.FESTIVE_SWET_SPAWN_EGG.get());
        }
    }

    public static void remove(BuildCreativeModeTabContentsEvent event, ItemLike entry) {
        event.getEntries().remove(new ItemStack(entry));
    }

    public static void putBefore(BuildCreativeModeTabContentsEvent event, ItemLike beforeEntry, ItemLike entry) {
        event.getEntries().putBefore(new ItemStack(beforeEntry), new ItemStack(entry), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    public static void putAfter(BuildCreativeModeTabContentsEvent event, ItemLike afterEntry, ItemLike entry) {
        event.getEntries().putAfter(new ItemStack(afterEntry), new ItemStack(entry), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}