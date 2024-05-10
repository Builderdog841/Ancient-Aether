package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.providers.AncientAetherItemModelProvider;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AncientAetherItemModelData extends AncientAetherItemModelProvider {
    public AncientAetherItemModelData(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientAether.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AncientAetherItems.VALKYRUM);
        simpleItem(AncientAetherItems.VALKYRIE_CLAY_BALL);
        simpleItem(AncientAetherItems.VALKYRIE_BRICK);
        simpleItem(AncientAetherItems.GRAPES);
        simpleItem(AncientAetherItems.SLAMMBERRY);
        simpleItem(AncientAetherItems.FESTIVE_GUMMY_SWET);
        simpleItem(AncientAetherItems.HIGHSPROOT_BOAT);
        simpleItem(AncientAetherItems.HIGHSPROOT_CHEST_BOAT);
        simpleItem(AncientAetherItems.SAKURA_BOAT);
        simpleItem(AncientAetherItems.SAKURA_CHEST_BOAT);
        simpleItem(AncientAetherItems.VALKYRUM_RING);
        simpleItem(AncientAetherItems.VALKYRUM_PENDANT);
        simpleItem(AncientAetherItems.HERMES_RING);
        simpleItem(AncientAetherItems.HERMES_PENDANT);
        simpleItem(AncientAetherItems.WARRIOR_RING);
        simpleItem(AncientAetherItems.WARRIOR_PENDANT);
        simpleItem(AncientAetherItems.GROWTH_RING);
        simpleItem(AncientAetherItems.GROWTH_PENDANT);
        simpleItem(AncientAetherItems.ANCIENT_RING);
        simpleItem(AncientAetherItems.ANCIENT_PENDANT);
        simpleItem(AncientAetherItems.STRENGTH_STONE);
        simpleItem(AncientAetherItems.PINK_CAPE);
        simpleItem(AncientAetherItems.SHIELD_OF_INEBRIATION);
        simpleItem(AncientAetherItems.SHIELD_OF_REMEDIATION);
        simpleItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER);
        simpleItem(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE);

        handheldItem(AncientAetherItems.VALKYRUM_SWORD.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_SHOVEL.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_PICKAXE.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_AXE.get(), "");
        handheldItem(AncientAetherItems.VALKYRUM_HOE.get(), "");
        handheldItem(AncientAetherItems.DIVINE_SHOVEL.get(), "");
        handheldItem(AncientAetherItems.DIVINE_PICKAXE.get(), "");
        handheldItem(AncientAetherItems.DIVINE_AXE.get(), "");
        handheldItem(AncientAetherItems.DIVINE_HOE.get(), "");
        handheldItem(AncientAetherItems.ANCIENT_SWORD.get(), "");

        item(AncientAetherBlocks.HIGHSPROOT_DOOR.get().asItem(), "");
        item(AncientAetherBlocks.SAKURA_DOOR.get().asItem(), "");
        item(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get().asItem(), "");
        item(AncientAetherBlocks.HIGHSPROOT_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.SAKURA_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.SAKURA_HANGING_SIGN.get().asItem(), "");
        item(AncientAetherBlocks.AMBROSIUM_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.WYND_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.SUN_LANTERN.get().asItem(), "");
        item(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get().asItem(), "");
        item(AncientAetherBlocks.ATMOSINE_CRYSTAL.get().asItem(), "");

        eggItem(AncientAetherItems.FLUFFALO_SPAWN_EGG.get());
        eggItem(AncientAetherItems.FESTIVE_SWET_SPAWN_EGG.get());
        eggItem(AncientAetherItems.SLAMMROOT_SPAWN_EGG.get());
        eggItem(AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG.get());
        eggItem(AncientAetherItems.MUTATED_AECHOR_PLANT_SPAWN_EGG.get());

        untintedMoaEggItem(AncientAetherItems.TURQUOISE_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.TEAL_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.SKY_BLUE_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.LAVENDER_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.SAKURA_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.VIOLET_MOA_EGG.get());
        untintedMoaEggItem(AncientAetherItems.BURGUNDY_MOA_EGG.get());

        helmetItem(AncientAetherItems.VALKYRUM_HELMET.get(), "");
        chestplateItem(AncientAetherItems.VALKYRUM_CHESTPLATE.get(), "");
        leggingsItem(AncientAetherItems.VALKYRUM_LEGGINGS.get(), "");
        bootsItem(AncientAetherItems.VALKYRUM_BOOTS.get(), "");
        AAGlovesItem(AncientAetherItems.VALKYRUM_GLOVES.get(), "");

        lanceItem(AncientAetherItems.VALKYRUM_LANCE.get(), "");

        rotatedItem(AncientAetherItems.LABORATORY_DUNGEON_KEY.get(), "");
        rotatedItem(AncientAetherItems.ANCIENT_DUNGEON_KEY.get(), "");

        ancientRuneItem(AncientAetherItems.ANCIENT_RUNE.get());

        itemBlock(AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
        itemBlock(AncientAetherBlocks.SAKURA_STAIRS.get());
        itemBlock(AncientAetherBlocks.CARVED_TILE_STAIRS.get());
        itemBlock(AncientAetherBlocks.AEROGETIC_STAIRS.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_SLAB.get());
        itemBlock(AncientAetherBlocks.SAKURA_SLAB.get());
        itemBlock(AncientAetherBlocks.CARVED_TILE_SLAB.get());
        itemBlock(AncientAetherBlocks.AEROGETIC_SLAB.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        itemBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get(), "_bottom");
        itemBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        itemBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
        itemBlock(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get());
        itemBlock(AncientAetherBlocks.SAKURA_BOOKSHELF.get());
        itemBlock(AncientAetherBlocks.VIOLET_AERCLOUD.get());
        itemBlock(AncientAetherBlocks.AEROGEL_GLASS.get());
        itemBlock(AncientAetherBlocks.FLUFFALO_CARPET.get());
        itemBlock(AncientAetherBlocks.WIND_BLOWER.get());
        itemBlock(AncientAetherBlocks.SLIDER_PROTOTYPE.get());
        itemBlock(AncientAetherBlocks.HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        itemBlock(AncientAetherBlocks.SENTRY_VASE.get());
        itemBlock(AncientAetherBlocks.ANGELIC_VASE.get());
        itemBlock(AncientAetherBlocks.HELLFIRE_VASE.get());
        itemBlock(AncientAetherBlocks.AEROGETIC_VASE.get());
        itemBlock(AncientAetherBlocks.GALE_VASE.get());
        itemBlock(AncientAetherBlocks.ANCIENT_OBELISK.get());
        itemBlock(AncientAetherBlocks.POWERED_OBELISK.get());

        itemBlockCopy(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), AncientAetherBlocks.HOLYSTONE_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(), AncientAetherBlocks.SENTRY_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get(), AncientAetherBlocks.ANGELIC_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get(), AncientAetherBlocks.HELLFIRE_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get(), AncientAetherBlocks.AEROGETIC_VASE.get());
        itemBlockCopy(AncientAetherBlocks.ANCIENT_GALE_VASE.get(), AncientAetherBlocks.GALE_VASE.get());

        itemBlockFlat(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SAKURA_SAPLING.get(), "");
        itemBlockFlat(AncientAetherBlocks.SUNSET_ROSE.get(), "");
        itemBlockFlat(AncientAetherBlocks.SKY_BLUES.get(), "");
        itemBlockFlat(AncientAetherBlocks.WYND_THISTLE.get(), "");
        itemBlockFlat(AncientAetherBlocks.ELEVETIA.get(), "");

        itemFence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemFence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");

        itemWallBlock(AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get(), "");
        itemWallBlock(AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");

        itemLogWallBlock(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemLogWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");

        itemWoodWallBlock(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", "ancient_aether");
        itemWoodWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", "ancient_aether");

        itemButton(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        itemButton(AncientAetherBlocks.SAKURA_BUTTON.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");

        pane(AncientAetherBlocks.AEROGEL_GLASS_PANE.get(), AncientAetherBlocks.AEROGEL_GLASS.get(), "");

        skyGrassItem(AncientAetherBlocks.SKY_GRASS.get());

        AAItemLockedDungeonBlock(AncientAetherBlocks.LOCKED_CARVED_TILES.get(), AncientAetherBlocks.CARVED_TILES.get());
        AAItemLockedDungeonBlock(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AAItemLockedDungeonBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AAItemLockedDungeonBlock(AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        AAItemLockedDungeonBlock(AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        itemLockedMosaicBlock(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get(), AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get());
        itemLockedMosaicBlock(AncientAetherBlocks.LOCKED_GALE_STONE_MOSAIC.get(), AncientAetherBlocks.GALE_STONE_MOSAIC.get());

        AAItemTrappedDungeonBlock(AncientAetherBlocks.TRAPPED_CARVED_TILES.get(), AncientAetherBlocks.CARVED_TILES.get());
        AAItemTrappedDungeonBlock(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AAItemTrappedDungeonBlock(AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        AAItemTrappedDungeonBlock(AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        itemBossDoorwayDungeonBlock(AncientAetherBlocks.BOSS_DOORWAY_CARVED_STONE.get(), AetherBlocks.CARVED_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        AAItemBossDoorwayDungeonBlock(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        AAItemTreasureDoorwayDungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get(), AncientAetherBlocks.AERONAUTIC_STONE.get());
        AAItemTreasureDoorwayDungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get());
    }
}