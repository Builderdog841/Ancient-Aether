package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.providers.AncientItemModelProvider;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AncientItemModelData extends AncientItemModelProvider {
    public AncientItemModelData(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AncientItems.VALKYRUM);
        simpleItem(AncientItems.VALKYRIE_CLAY_BALL);
        simpleItem(AncientItems.VALKYRIE_BRICK);
        simpleItem(AncientItems.GRAPES);
        simpleItem(AncientItems.SLAMMBERRY);
        simpleItem(AncientItems.FESTIVE_GUMMY_SWET);
        simpleItem(AncientItems.HIGHSPROOT_BOAT);
        simpleItem(AncientItems.HIGHSPROOT_CHEST_BOAT);
        simpleItem(AncientItems.SAKURA_BOAT);
        simpleItem(AncientItems.SAKURA_CHEST_BOAT);
        simpleItem(AncientItems.VALKYRUM_RING);
        simpleItem(AncientItems.VALKYRUM_PENDANT);
        simpleItem(AncientItems.HERMES_RING);
        simpleItem(AncientItems.HERMES_PENDANT);
        simpleItem(AncientItems.WARRIOR_RING);
        simpleItem(AncientItems.WARRIOR_PENDANT);
        simpleItem(AncientItems.GROWTH_RING);
        simpleItem(AncientItems.GROWTH_PENDANT);
        simpleItem(AncientItems.ANCIENT_RING);
        simpleItem(AncientItems.ANCIENT_PENDANT);
        simpleItem(AncientItems.STRENGTH_STONE);
        simpleItem(AncientItems.PINK_CAPE);
        simpleItem(AncientItems.SHIELD_OF_INEBRIATION);
        simpleItem(AncientItems.SHIELD_OF_REMEDIATION);
        simpleItem(AncientItems.AERONAUTIC_DART_SHOOTER);
        simpleItem(AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE);

        handheldItem(AncientItems.VALKYRUM_SWORD.get(), "");
        handheldItem(AncientItems.VALKYRUM_SHOVEL.get(), "");
        handheldItem(AncientItems.VALKYRUM_PICKAXE.get(), "");
        handheldItem(AncientItems.VALKYRUM_AXE.get(), "");
        handheldItem(AncientItems.VALKYRUM_HOE.get(), "");
        handheldItem(AncientItems.DIVINE_SHOVEL.get(), "");
        handheldItem(AncientItems.DIVINE_PICKAXE.get(), "");
        handheldItem(AncientItems.DIVINE_AXE.get(), "");
        handheldItem(AncientItems.DIVINE_HOE.get(), "");
        handheldItem(AncientItems.ANCIENT_SWORD.get(), "");

        item(AncientBlocks.HIGHSPROOT_DOOR.get().asItem(), "");
        item(AncientBlocks.SAKURA_DOOR.get().asItem(), "");
        item(AncientBlocks.AEROGEL_GLASS_DOOR.get().asItem(), "");
        item(AncientBlocks.HIGHSPROOT_SIGN.get().asItem(), "");
        item(AncientBlocks.SAKURA_SIGN.get().asItem(), "");
        item(AncientBlocks.HIGHSPROOT_HANGING_SIGN.get().asItem(), "");
        item(AncientBlocks.SAKURA_HANGING_SIGN.get().asItem(), "");
        item(AncientBlocks.AMBROSIUM_LANTERN.get().asItem(), "");
        item(AncientBlocks.WYND_LANTERN.get().asItem(), "");
        item(AncientBlocks.SUN_LANTERN.get().asItem(), "");
        item(AncientBlocks.AMBROSIUM_CAMPFIRE.get().asItem(), "");
        item(AncientBlocks.ATMOSINE_CRYSTAL.get().asItem(), "");

        eggItem(AncientItems.FLUFFALO_SPAWN_EGG.get());
        eggItem(AncientItems.FESTIVE_SWET_SPAWN_EGG.get());
        eggItem(AncientItems.SLAMMROOT_SPAWN_EGG.get());
        eggItem(AncientItems.AERONAUTIC_LEAPER_SPAWN_EGG.get());
        eggItem(AncientItems.MUTATED_AECHOR_PLANT_SPAWN_EGG.get());

        untintedMoaEggItem(AncientItems.TURQUOISE_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.TEAL_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.SKY_BLUE_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.LAVENDER_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.SAKURA_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.VIOLET_MOA_EGG.get());
        untintedMoaEggItem(AncientItems.BURGUNDY_MOA_EGG.get());

        helmetItem(AncientItems.VALKYRUM_HELMET.get(), "");
        chestplateItem(AncientItems.VALKYRUM_CHESTPLATE.get(), "");
        leggingsItem(AncientItems.VALKYRUM_LEGGINGS.get(), "");
        bootsItem(AncientItems.VALKYRUM_BOOTS.get(), "");
        AAGlovesItem(AncientItems.VALKYRUM_GLOVES.get(), "");

        lanceItem(AncientItems.VALKYRUM_LANCE.get(), "");

        rotatedItem(AncientItems.LABORATORY_DUNGEON_KEY.get(), "");
        rotatedItem(AncientItems.ANCIENT_DUNGEON_KEY.get(), "");

        ancientRuneItem(AncientItems.ANCIENT_RUNE.get());

        itemBlock(AncientBlocks.HIGHSPROOT_STAIRS.get());
        itemBlock(AncientBlocks.SAKURA_STAIRS.get());
        itemBlock(AncientBlocks.CARVED_TILE_STAIRS.get());
        itemBlock(AncientBlocks.VALKYRIE_BRICK_STAIRS.get());
        itemBlock(AncientBlocks.VALKYRIE_TILE_STAIRS.get());
        itemBlock(AncientBlocks.AEROGETIC_STAIRS.get());
        itemBlock(AncientBlocks.HIGHSPROOT_SLAB.get());
        itemBlock(AncientBlocks.SAKURA_SLAB.get());
        itemBlock(AncientBlocks.CARVED_TILE_SLAB.get());
        itemBlock(AncientBlocks.VALKYRIE_BRICK_SLAB.get());
        itemBlock(AncientBlocks.VALKYRIE_TILE_SLAB.get());
        itemBlock(AncientBlocks.AEROGETIC_SLAB.get());
        itemBlock(AncientBlocks.HIGHSPROOT_FENCE_GATE.get());
        itemBlock(AncientBlocks.SAKURA_FENCE_GATE.get());
        itemBlock(AncientBlocks.HIGHSPROOT_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientBlocks.SAKURA_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        itemBlock(AncientBlocks.SAKURA_PRESSURE_PLATE.get());
        itemBlock(AncientBlocks.HIGHSPROOT_BOOKSHELF.get());
        itemBlock(AncientBlocks.SAKURA_BOOKSHELF.get());
        itemBlock(AncientBlocks.VIOLET_AERCLOUD.get());
        itemBlock(AncientBlocks.AEROGEL_GLASS.get());
        itemBlock(AncientBlocks.FLUFFALO_CARPET.get());
        itemBlock(AncientBlocks.ANGELIC_CORNER_BRICK.get());
        itemBlock(AncientBlocks.WIND_BLOWER.get());
        itemBlock(AncientBlocks.SLIDER_PROTOTYPE.get());
        itemBlock(AncientBlocks.HOLYSTONE_VASE.get());
        itemBlock(AncientBlocks.MOSSY_HOLYSTONE_VASE.get());
        itemBlock(AncientBlocks.FROZEN_HOLYSTONE_VASE.get());
        itemBlock(AncientBlocks.SENTRY_VASE.get());
        itemBlock(AncientBlocks.ANGELIC_VASE.get());
        itemBlock(AncientBlocks.HELLFIRE_VASE.get());
        itemBlock(AncientBlocks.AEROGETIC_VASE.get());
        itemBlock(AncientBlocks.GALE_VASE.get());
        itemBlock(AncientBlocks.ANCIENT_OBELISK.get());
        itemBlock(AncientBlocks.POWERED_OBELISK.get());

        itemBlockCopy(AncientBlocks.ANCIENT_HOLYSTONE_VASE.get(), AncientBlocks.HOLYSTONE_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), AncientBlocks.MOSSY_HOLYSTONE_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), AncientBlocks.FROZEN_HOLYSTONE_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_SENTRY_VASE.get(), AncientBlocks.SENTRY_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_ANGELIC_VASE.get(), AncientBlocks.ANGELIC_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_HELLFIRE_VASE.get(), AncientBlocks.HELLFIRE_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_AEROGETIC_VASE.get(), AncientBlocks.AEROGETIC_VASE.get());
        itemBlockCopy(AncientBlocks.ANCIENT_GALE_VASE.get(), AncientBlocks.GALE_VASE.get());

        itemBlockFlat(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.SKYROOT_PINE_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.HIGHSPROOT_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.SAKURA_SAPLING.get(), "");
        itemBlockFlat(AncientBlocks.SUNSET_ROSE.get(), "");
        itemBlockFlat(AncientBlocks.SKY_BLUES.get(), "");
        itemBlockFlat(AncientBlocks.WYND_THISTLE.get(), "");
        itemBlockFlat(AncientBlocks.ELEVETIA.get(), "");

        itemFence(AncientBlocks.HIGHSPROOT_FENCE.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemFence(AncientBlocks.SAKURA_FENCE.get(), AncientBlocks.SAKURA_PLANKS.get(), "");

        itemWallBlock(AncientBlocks.CARVED_TILE_WALL.get(), AncientBlocks.CARVED_TILES.get(), "");
        itemWallBlock(AncientBlocks.VALKYRIE_BRICK_WALL.get(), AncientBlocks.VALKYRIE_BRICKS.get(), "");
        itemWallBlock(AncientBlocks.VALKYRIE_TILE_WALL.get(), AncientBlocks.VALKYRIE_TILES.get(), "");
        itemWallBlock(AncientBlocks.AEROGETIC_WALL.get(), AncientBlocks.AEROGETIC_STONE.get(), "");

        itemLogWallBlock(AncientBlocks.HIGHSPROOT_LOG_WALL.get(), AncientBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientBlocks.SAKURA_LOG_WALL.get(), AncientBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");

        itemWoodWallBlock(AncientBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientBlocks.SAKURA_WOOD_WALL.get(), AncientBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");

        itemButton(AncientBlocks.HIGHSPROOT_BUTTON.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemButton(AncientBlocks.SAKURA_BUTTON.get(), AncientBlocks.SAKURA_PLANKS.get(), "");

        pane(AncientBlocks.AEROGEL_GLASS_PANE.get(), AncientBlocks.AEROGEL_GLASS.get(), "");

        skyGrassItem(AncientBlocks.SKY_GRASS.get());

        AAItemLockedDungeonBlock(AncientBlocks.LOCKED_CARVED_TILES.get(), AncientBlocks.CARVED_TILES.get());
        AAItemLockedDungeonBlock(AncientBlocks.LOCKED_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AAItemLockedDungeonBlock(AncientBlocks.LOCKED_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AAItemLockedDungeonBlock(AncientBlocks.LOCKED_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AAItemLockedDungeonBlock(AncientBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        itemLockedMosaicBlock(AncientBlocks.LOCKED_CARVED_STONE_MOSAIC.get(), AncientBlocks.CARVED_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get(), AncientBlocks.ANGELIC_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get(), AncientBlocks.HELLFIRE_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get(), AncientBlocks.AEROGETIC_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientBlocks.LOCKED_GALE_STONE_MOSAIC.get(), AncientBlocks.GALE_STONE_MOSAIC.get());

        AAItemTrappedDungeonBlock(AncientBlocks.TRAPPED_CARVED_TILES.get(), AncientBlocks.CARVED_TILES.get());
        AAItemTrappedDungeonBlock(AncientBlocks.TRAPPED_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AAItemTrappedDungeonBlock(AncientBlocks.TRAPPED_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AAItemTrappedDungeonBlock(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        itemBossDoorwayDungeonBlock(AncientBlocks.BOSS_DOORWAY_CARVED_STONE.get(), AetherBlocks.CARVED_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        AAItemTreasureDoorwayDungeonBlock(AncientBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
    }
}