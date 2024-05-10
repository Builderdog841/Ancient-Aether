package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.providers.AncientAetherLanguageProvider;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherStructures;
import net.builderdog.ancient_aether.effect.AncientAetherEffects;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.PackOutput;

public class AncientAetherLanguageData extends AncientAetherLanguageProvider {
    public AncientAetherLanguageData(PackOutput output) {
        super(output, AncientAether.MODID);
    }

    @Override
    protected void addTranslations() {
        String mark = " \n§6- Ancient Aether -";
        String markModified = " \n§6- Modified by Ancient Aether -";

        addBlock(AncientAetherBlocks.GRAVITY_GRAVEL, "Gravity Gravel");
        addBlock(AncientAetherBlocks.WYND_ICE, "Wynd Ice");
        addBlock(AncientAetherBlocks.VALKYRIE_CLAY, "Valkyrie Clay");

        addBlock(AncientAetherBlocks.AETHER_QUARTZ_ORE, "Aether Quartz Ore");
        addBlock(AncientAetherBlocks.VALKYRUM_ORE, "Valkyrum Ore");
        addBlock(AncientAetherBlocks.ATMOSINE_CRYSTAL, "Atmosine Crystal");

        addBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES, "Crystal Skyroot Leaves");
        addBlock(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES, "Enchanted Skyroot Leaves");
        addBlock(AncientAetherBlocks.SKYROOT_PINE_LEAVES, "Skyroot Pine Leaves");
        addBlock(AncientAetherBlocks.BLUE_SKYROOT_PINE_LEAVES, "Blue Skyroot Pine Leaves");
        addBlock(AncientAetherBlocks.HIGHSPROOT_LEAVES, "Highsproot Leaves");
        addBlock(AncientAetherBlocks.SAKURA_LEAVES, "Sakura Leaves");

        addBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING, "Crystal Skyroot Sapling");
        addBlock(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING, "Enchanted Skyroot Sapling");
        addBlock(AncientAetherBlocks.SKYROOT_PINE_SAPLING, "Skyroot Pine Sapling");
        addBlock(AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING, "Blue Skyroot Pine Sapling");
        addBlock(AncientAetherBlocks.HIGHSPROOT_SAPLING, "Highsproot Sapling");
        addBlock(AncientAetherBlocks.SAKURA_SAPLING, "Sakura Sapling");

        addBlock(AncientAetherBlocks.SKY_GRASS, "Sky Grass");
        addBlock(AncientAetherBlocks.SUNSET_ROSE, "Sunset Rose");
        addBlock(AncientAetherBlocks.SKY_BLUES, "Sky Blues");
        addBlock(AncientAetherBlocks.WYND_THISTLE, "Wynd Thistle");
        addBlock(AncientAetherBlocks.ELEVETIA, "Elevetia");
        addBlock(AncientAetherBlocks.GRAPE_VINE, "Grape Vine");
        addBlock(AncientAetherBlocks.SLAMMROOT_PLANT, "Slammroot Plant");

        addBlock(AncientAetherBlocks.HIGHSPROOT_LOG, "Highsproot Log");
        addBlock(AncientAetherBlocks.HIGHSPROOT_WOOD, "Highsproot Wood");
        addBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG, "Stripped Highsproot Log");
        addBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD, "Stripped Highsproot Log");
        addBlock(AncientAetherBlocks.SAKURA_LOG, "Sakura Log");
        addBlock(AncientAetherBlocks.SAKURA_WOOD, "Sakura Wood");
        addBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG, "Stripped Sakura Log");
        addBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD, "Stripped Sakura Log");

        addBlock(AncientAetherBlocks.HIGHSPROOT_LOG_WALL, "Highsproot Log Wall");
        addBlock(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL, "Highsproot Wood Wall");
        addBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL, "Stripped Highsproot Log Wall");
        addBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL, "Stripped Highsproot Log Wall");
        addBlock(AncientAetherBlocks.SAKURA_LOG_WALL, "Sakura Log Wall");
        addBlock(AncientAetherBlocks.SAKURA_WOOD_WALL, "Sakura Wood Wall");
        addBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL, "Stripped Sakura Log Wall");
        addBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL, "Stripped Sakura Log Wall");

        addBlock(AncientAetherBlocks.HIGHSPROOT_PLANKS, "Highsproot Planks");
        addBlock(AncientAetherBlocks.HIGHSPROOT_STAIRS, "Highsproot Stairs");
        addBlock(AncientAetherBlocks.HIGHSPROOT_SLAB, "Highsproot Slab");
        addBlock(AncientAetherBlocks.HIGHSPROOT_FENCE, "Highsproot Fence");
        addBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE, "Highsproot Fence Gate");
        addBlock(AncientAetherBlocks.HIGHSPROOT_DOOR, "Highsproot Door");
        addBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR, "Highsproot Trapdoor");
        addBlock(AncientAetherBlocks.HIGHSPROOT_BUTTON, "Highsproot Button");
        addBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE, "Highsproot Pressure Plate");
        addBlock(AncientAetherBlocks.HIGHSPROOT_SIGN, "Highsproot Sign");
        addBlock(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN, "Highsproot Hanging Sign");
        addBlock(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF, "Highsproot Bookshelf");

        addBlock(AncientAetherBlocks.SAKURA_PLANKS, "Sakura Planks");
        addBlock(AncientAetherBlocks.SAKURA_STAIRS, "Sakura Stairs");
        addBlock(AncientAetherBlocks.SAKURA_SLAB, "Sakura Slab");
        addBlock(AncientAetherBlocks.SAKURA_FENCE, "Sakura Fence");
        addBlock(AncientAetherBlocks.SAKURA_FENCE_GATE, "Sakura Fence Gate");
        addBlock(AncientAetherBlocks.SAKURA_DOOR, "Sakura Door");
        addBlock(AncientAetherBlocks.SAKURA_TRAPDOOR, "Sakura Trapdoor");
        addBlock(AncientAetherBlocks.SAKURA_BUTTON, "Sakura Button");
        addBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE, "Sakura Pressure Plate");
        addBlock(AncientAetherBlocks.SAKURA_SIGN, "Sakura Sign");
        addBlock(AncientAetherBlocks.SAKURA_HANGING_SIGN, "Sakura Hanging Sign");
        addBlock(AncientAetherBlocks.SAKURA_BOOKSHELF, "Sakura Bookshelf");

        addBlock(AncientAetherBlocks.VALKYRUM_BLOCK, "Block of Valkyrum");
        addBlock(AncientAetherBlocks.AEROGEL_GLASS, "Aerogel Glass");
        addBlock(AncientAetherBlocks.AEROGEL_GLASS_PANE, "Aerogel Glass Pane");
        addBlock(AncientAetherBlocks.AEROGEL_GLASS_DOOR, "Aerogel Glass Door");
        addBlock(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR, "Aerogel Glass Trapdoor");
        addBlock(AncientAetherBlocks.FLUFFALO_WOOL, "Fluffalo Wool");
        addBlock(AncientAetherBlocks.FLUFFALO_CARPET, "Fluffalo Carpet");

        addBlock(AncientAetherBlocks.CARVED_TILES, "Carved Tiles");
        addBlock(AncientAetherBlocks.WYND_SENTRY_STONE, "Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.CARVED_TILE_STAIRS, "Carved Tile Stairs");
        addBlock(AncientAetherBlocks.CARVED_TILE_SLAB, "Carved Tile Slab");
        addBlock(AncientAetherBlocks.CARVED_TILE_WALL, "Carved Tile Wall");

        addBlock(AncientAetherBlocks.AEROGETIC_STONE, "Aerogetic Stone");
        addBlock(AncientAetherBlocks.AERONAUTIC_STONE, "Aeronautic Stone");
        addBlock(AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE, "Corrupted Aeronautic Stone");
        addBlock(AncientAetherBlocks.AEROGETIC_STAIRS, "Aerogetic Stairs");
        addBlock(AncientAetherBlocks.AEROGETIC_SLAB, "Aerogetic Slab");
        addBlock(AncientAetherBlocks.AEROGETIC_WALL, "Aerogetic Wall");

        addBlock(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC, "Holystone Brick Mosaic");
        addBlock(AncientAetherBlocks.CARVED_STONE_MOSAIC, "Carved Stone Mosaic");
        addBlock(AncientAetherBlocks.ANGELIC_STONE_MOSAIC, "Angelic Stone Mosaic");
        addBlock(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC, "Hellfire Stone Mosaic");
        addBlock(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC, "Aerogetic Stone Mosaic");
        addBlock(AncientAetherBlocks.GALE_STONE_MOSAIC, "Gale Stone Mosaic");

        addBlock(AncientAetherBlocks.LOCKED_CARVED_TILES, "Locked Carved Tiles");
        addBlock(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE, "Locked Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE, "Locked Aerogetic Stone");
        addBlock(AncientAetherBlocks.LOCKED_AERONAUTIC_STONE, "Locked Aeronautic Stone");
        addBlock(AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE, "Locked Corrupted Aeronautic Stone");

        addBlock(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC, "Locked Carved Stone Mosaic");
        addBlock(AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC, "Locked Angelic Stone Mosaic");
        addBlock(AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC, "Locked Hellfire Stone Mosaic");
        addBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC, "Locked Aerogetic Stone Mosaic");
        addBlock(AncientAetherBlocks.LOCKED_GALE_STONE_MOSAIC, "Locked Gale Stone Mosaic");

        addBlock(AncientAetherBlocks.TRAPPED_CARVED_TILES, "Trapped Carved Tiles");
        addBlock(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE, "Trapped Aerogetic Stone");
        addBlock(AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE, "Trapped Aeronautic Stone");
        addBlock(AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE, "Trapped Corrupted Aeronautic Stone");

        addBlock(AncientAetherBlocks.BOSS_DOORWAY_CARVED_STONE, "Boss Doorway Carved Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE, "Boss Doorway Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE, "Boss Doorway Aerogetic Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE, "Boss Doorway Aeronautic Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE, "Boss Doorway Corrupted Aeronautic Stone");

        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE, "Treasure Doorway Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE, "Treasure Doorway Aerogetic Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE, "Treasure Doorway Aeronautic Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE, "Treasure Doorway Corrupted Aeronautic Stone");

        addBlock(AncientAetherBlocks.AMBROSIUM_LANTERN, "Ambrosium Lantern");
        addBlock(AncientAetherBlocks.WYND_LANTERN, "Wynd Lantern");
        addBlock(AncientAetherBlocks.SUN_LANTERN, "Sun Lantern");
        addBlock(AncientAetherBlocks.AMBROSIUM_CAMPFIRE, "Ambrosium Campfire");

        addBlock(AncientAetherBlocks.VIOLET_AERCLOUD, "Violet Aercloud");
        addBlock(AncientAetherBlocks.WIND_BLOWER, "Wind Blower");
        addBlock(AncientAetherBlocks.SLIDER_PROTOTYPE, "Slider Prototype");
        addBlock(AncientAetherBlocks.ANCIENT_OBELISK, "Ancient Obelisk");
        addBlock(AncientAetherBlocks.POWERED_OBELISK, "Powered Obelisk");

        addBlock(AncientAetherBlocks.HOLYSTONE_VASE, "Holystone Vase");
        addBlock(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE, "Mossy Holystone Vase");
        addBlock(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE, "Frozen Holystone Vase");
        addBlock(AncientAetherBlocks.SENTRY_VASE, "Sentry Vase");
        addBlock(AncientAetherBlocks.ANGELIC_VASE, "Angelic Vase");
        addBlock(AncientAetherBlocks.HELLFIRE_VASE, "Hellfire Vase");
        addBlock(AncientAetherBlocks.AEROGETIC_VASE, "Aerogetic Vase");
        addBlock(AncientAetherBlocks.GALE_VASE, "Gale Vase");

        addBlock(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE, "Ancient Holystone Vase");
        addBlock(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE, "Ancient Mossy Holystone Vase");
        addBlock(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE, "Ancient Frozen Holystone Vase");
        addBlock(AncientAetherBlocks.ANCIENT_SENTRY_VASE, "Ancient Sentry Vase");
        addBlock(AncientAetherBlocks.ANCIENT_ANGELIC_VASE, "Ancient Angelic Vase");
        addBlock(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE, "Ancient Hellfire Vase");
        addBlock(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE, "Ancient Aerogetic Vase");
        addBlock(AncientAetherBlocks.ANCIENT_GALE_VASE, "Ancient Gale Vase");

        addBlock(AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING, "Potted Crystal Skyroot Sapling");
        addBlock(AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING, "Potted Enchanted Skyroot Sapling");
        addBlock(AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING, "Potted Skyroot Pine Sapling");
        addBlock(AncientAetherBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING, "Potted Blue Skyroot Pine Sapling");
        addBlock(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING, "Potted Highsproot Sapling");
        addBlock(AncientAetherBlocks.POTTED_SAKURA_SAPLING, "Potted Sakura Sapling");
        addBlock(AncientAetherBlocks.POTTED_SUNSET_ROSE, "Potted Sunset Rose");
        addBlock(AncientAetherBlocks.POTTED_SKY_BLUES, "Potted Sky Blues");
        addBlock(AncientAetherBlocks.POTTED_WYND_THISTLE, "Potted Wynd Thistle");
        addBlock(AncientAetherBlocks.POTTED_ELEVETIA, "Potted Elevatia");

        addItem(AncientAetherItems.VALKYRUM, "Valkyrum");
        addItem(AncientAetherItems.VALKYRIE_CLAY_BALL, "Valkyrie Clay Ball");
        addItem(AncientAetherItems.VALKYRIE_BRICK, "Valkyrie Brick");

        addItem(AncientAetherItems.GRAPES, "Grapes");
        addItem(AncientAetherItems.SLAMMBERRY, "Slammberry");
        addItem(AncientAetherItems.FESTIVE_GUMMY_SWET, "Festive Gummy Swet");

        addItem(AncientAetherItems.VALKYRUM_SWORD, "Valkyrum Sword");
        addItem(AncientAetherItems.VALKYRUM_LANCE, "Valkyrum Lance");
        addItem(AncientAetherItems.VALKYRUM_SHOVEL, "Valkyrum Shovel");
        addItem(AncientAetherItems.VALKYRUM_PICKAXE, "Valkyrum Pickaxe");
        addItem(AncientAetherItems.VALKYRUM_AXE, "Valkyrum Axe");
        addItem(AncientAetherItems.VALKYRUM_HOE, "Valkyrum Hoe");

        addItem(AncientAetherItems.DIVINE_SHOVEL, "Divine Shovel");
        addItem(AncientAetherItems.DIVINE_PICKAXE, "Divine Pickaxe");
        addItem(AncientAetherItems.DIVINE_AXE, "Divine Axe");
        addItem(AncientAetherItems.DIVINE_HOE, "Divine Hoe");

        addItem(AncientAetherItems.VALKYRUM_HELMET, "Valkyrum Helmet");
        addItem(AncientAetherItems.VALKYRUM_CHESTPLATE, "Valkyrum Chestplate");
        addItem(AncientAetherItems.VALKYRUM_LEGGINGS, "Valkyrum Leggings");
        addItem(AncientAetherItems.VALKYRUM_BOOTS, "Valkyrum Boots");
        addItem(AncientAetherItems.VALKYRUM_GLOVES, "Valkyrum Gloves");

        addItem(AncientAetherItems.ANCIENT_SWORD, "Ancient Sword");
        addItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER, "Aeronautic Dart Shooter");

        addItem(AncientAetherItems.VALKYRUM_RING, "Valkyrum Ring");
        addItem(AncientAetherItems.HERMES_RING, "Hermes Ring");
        addItem(AncientAetherItems.WARRIOR_RING, "Warrior Ring");
        addItem(AncientAetherItems.GROWTH_RING, "Ring of Growth");
        addItem(AncientAetherItems.ANCIENT_RING, "Ancient Ring");

        addItem(AncientAetherItems.VALKYRUM_PENDANT, "Valkyrum Pendant");
        addItem(AncientAetherItems.HERMES_PENDANT, "Hermes Pendant");
        addItem(AncientAetherItems.WARRIOR_PENDANT, "Warrior Pendant");
        addItem(AncientAetherItems.GROWTH_PENDANT, "Pendant of Growth");
        addItem(AncientAetherItems.ANCIENT_PENDANT, "Ancient Pendant");

        addItem(AncientAetherItems.PINK_CAPE, "Pink Cape");
        addItem(AncientAetherItems.SHIELD_OF_INEBRIATION, "Shield of Inebriation");
        addItem(AncientAetherItems.SHIELD_OF_REMEDIATION, "Shield of Remediation");
        addItem(AncientAetherItems.STRENGTH_STONE, "Strength Stone");

        addItem(AncientAetherItems.ANCIENT_RUNE, "Ancient Rune");
        addItem(AncientAetherItems.LABORATORY_DUNGEON_KEY, "Laboratory Key");
        addItem(AncientAetherItems.ANCIENT_DUNGEON_KEY, "Ancient Key");

        addItem(AncientAetherItems.HIGHSPROOT_BOAT, "Highsproot Boat");
        addItem(AncientAetherItems.HIGHSPROOT_CHEST_BOAT, "Highsproot Chest Boat");
        addItem(AncientAetherItems.SAKURA_BOAT, "Sakura Boat");
        addItem(AncientAetherItems.SAKURA_CHEST_BOAT, "Sakura Chest Boat");

        addItem(AncientAetherItems.TURQUOISE_MOA_EGG, "Turquoise Moa Egg");
        addItem(AncientAetherItems.TEAL_MOA_EGG, "Teal Moa Egg");
        addItem(AncientAetherItems.SKY_BLUE_MOA_EGG, "Sky Blue Moa Egg");
        addItem(AncientAetherItems.LAVENDER_MOA_EGG, "Lavender Moa Egg");
        addItem(AncientAetherItems.SAKURA_MOA_EGG, "Sakura Moa Egg");
        addItem(AncientAetherItems.VIOLET_MOA_EGG, "Violet Moa Egg");
        addItem(AncientAetherItems.BURGUNDY_MOA_EGG, "Burgundy Moa Egg");

        addItem(AncientAetherItems.FLUFFALO_SPAWN_EGG, "Fluffalo Spawn Egg");
        addItem(AncientAetherItems.FESTIVE_SWET_SPAWN_EGG, "Festive Swet Spawn Egg");
        addItem(AncientAetherItems.SLAMMROOT_SPAWN_EGG, "Slammroot Spawn Egg");
        addItem(AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG, "Aeronautic Leaper Spawn Egg");
        addItem(AncientAetherItems.MUTATED_AECHOR_PLANT_SPAWN_EGG, "Mutated Aechor Plant Spawn Egg");

        addEntityType(AncientAetherEntityTypes.FLUFFALO, "Fluffalo");
        addEntityType(AncientAetherEntityTypes.FESTIVE_SWET, "Festive Swet");
        addEntityType(AncientAetherEntityTypes.SLAMMROOT, "Slammroot");
        addEntityType(AncientAetherEntityTypes.AERONAUTIC_LEAPER, "Aeronautic Leaper");
        addEntityType(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT, "Mutated Aechor Plant");

        addEntityType(AncientAetherEntityTypes.BOAT, "Boat");
        addEntityType(AncientAetherEntityTypes.CHEST_BOAT, "Chest Boat");
        addEntityType(AncientAetherEntityTypes.WIND_BLOW, "Wind Blow");
        addEntityType(AncientAetherEntityTypes.AERONAUTIC_DART, "Aeronautic Dart");
        addEntityType(AncientAetherEntityTypes.MUTATED_AECHOR_NEEDLE, "Mutated Aechor Needle");
        addEntityType(AncientAetherEntityTypes.SPORE_BOMB, "Spore Bomb");
        addEntityType(AncientAetherEntityTypes.REMEDY_CRYSTAL, "Remedy Crystal");

        addBiome(AncientAetherBiomes.SUN_FOREST, "Sun Forest");
        addBiome(AncientAetherBiomes.WYNDCAP_TAIGA, "Wyndcaps Taiga");
        addBiome(AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA, "Festive Wyndcaps Taiga");
        addBiome(AncientAetherBiomes.WYNDCAP_HIGHLAND, "Wyndcaps Highland");
        addBiome(AncientAetherBiomes.WYNDCAP_PEAKS, "Wyndcaps Peaks");
        addBiome(AncientAetherBiomes.SKYROOT_JUNGLE, "Skyroot Jungle");
        addBiome(AncientAetherBiomes.SAKURA_JUNGLE, "Sakura Jungle");
        addBiome(AncientAetherBiomes.ELEVATED_CLEARING, "Elevated Clearing");
        addBiome(AncientAetherBiomes.ELEVATED_FOREST, "Elevated Forest");
        addBiome(AncientAetherBiomes.SKY_LAKE, "Sky Lake");
        addBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS, "Holystone Caverns");
        addBiome(AncientAetherBiomes.FROZEN_CAVERNS, "Frozen Caverns");
        addBiome(AncientAetherBiomes.ELEVATED_CAVERNS, "Elevated Caverns");

        addStructure(AncientAetherStructures.HOLYSTONE_RUIN, "Holystone Ruin");
        addStructure(AncientAetherStructures.MYSTERIOUS_HENGE, "Mysterious Henge");
        addStructure(AncientAetherStructures.VALKYRIE_CAMP_SKYROOT, "Valkyrie Camp Skyroot");
        addStructure(AncientAetherStructures.VALKYRIE_CAMP_WYNDCAPS, "Valkyrie Camp Wyndcaps");
        addStructure(AncientAetherStructures.VALKYRIE_SETTLEMENT_SKYROOT, "Valkyrie Settlement Skyroot");
        addStructure(AncientAetherStructures.SENTRY_LABORATORY, "Sentry Laboratory");
        addStructure(AncientAetherStructures.ANCIENT_DUNGEON, "Ancient Dungeon");

        addEffect(AncientAetherEffects.DIVINE_PROTECTION, "Divine Protection");
        addEffect(AncientAetherEffects.NATURES_BOOST, "Nature's Boost");

        addEffectDesc(AncientAetherEffects.DIVINE_PROTECTION, "A protection buff granted by using Divine Tools");
        addEffectDesc(AncientAetherEffects.NATURES_BOOST, "Makes the player jump high into the air and fertilizes the ground once they land");

        addAdvancement("aether_biomes", "Aerospace Traveller");
        addAdvancement("moa_eggs", "Rainbow Omelette");
        addAdvancement("divine_pickaxe_loot", "The Pickaxe of Gods");
        addAdvancement("valkyrum", "What Clouds are made of");
        addAdvancement("valkyrum_lance", "Lancin' and Dancin'");
        addAdvancement("vampire_blade_loot", "Bloodlust");
        addAdvancement("find_sentry_laboratory", "A White Apple a day, keeps the Cockatrice away");
        addAdvancement("slider_prototype", "Out of Order");
        addAdvancement("laboratory_dungeon", "Peace, Love and Houseplants");
        addAdvancement("shield_accessory_loot", "In perfect Balance");
        addAdvancement("obelisk", "Ancient Forces");
        addAdvancement("ancient_dungeon", "Shut-Down");

        addAdvancementDesc("aether_biomes", "Find all Aether biomes" + mark);
        addAdvancementDesc("moa_eggs", "Collect all the different Moa Eggs" + mark);
        addAdvancementDesc("divine_pickaxe_loot", "Obtain the Divine Pickaxe from defeating the Valkyrie Queen. It can be used to mine Valkyrum Ore" + mark);
        addAdvancementDesc("valkyrum", "Enchant some Valkyrum Ore in an Altar" + mark);
        addAdvancementDesc("valkyrum_lance", "Craft yourself a Valkyrum Lance" + mark);
        addAdvancementDesc("vampire_blade_loot", "Obtain the Vampire Blade from defeating the Sun Spirit" + mark);
        addAdvancementDesc("find_sentry_laboratory", "Find the Sentry Laboratory located in the Wyndcaps" + mark);
        addAdvancementDesc("slider_prototype", "Mine a Slider Prototype with a Gravitite Pickaxe" + mark);
        addAdvancementDesc("laboratory_dungeon", "Defeat the Mutated Aechor Plant" + mark);
        addAdvancementDesc("shield_accessory_loot", "Obtain the Shields of Inebriation and Remediation" + mark);
        addAdvancementDesc("obelisk", "Enter the Ancient Dungeon by activating its Obelisk using an Ancient Rune" + mark);
        addAdvancementDesc("ancient_dungeon", "Defeat the Ancient Guardian" + mark);

        addAdvancementDesc("sakura_moa", "Ride a Sakura Moa" + markModified);
        addAdvancementDesc("divine_hoe", "I defeated the Silver Dungeon and all I got was this stupid Hoe" + markModified);
        addAdvancementDesc("valkyrum_armor", "Obtain a piece of Valkyrum Armor" + markModified);

        addTrim("atmosine", "Atmosine");
        addTrim("valkyrum", "Valkyrum");

        addTrimPattern("wynd", "Wynd");
        addTrimPattern("whale", "Whale");
        addTrimPattern("ascended", "Ascended");
        addTrimPattern("mysterious", "Mysterious");
        addTrimPattern("mechanical", "Mechanical");
        addTrimPattern("mosaic", "Mosaic");
        addTrimPattern("royal", "Royal");
        addTrimPattern("solar", "Solar");
        addTrimPattern("ancient", "Ancient");

        addTooltip("common", "Common");
        addTooltip("rare", "Rare");
        addTooltip("epic", "Epic");
        addTooltip("mythic", "Mythic");

        addSubtitle("block", "grape_vine.pick_grapes", "Grapes pop");
        addSubtitle("block", "obelisk.activation", "Obelisk activated");

        addAccessorySubtitle("valkyrum_ring", "Valkyrum Ring");
        addAccessorySubtitle("hermes_ring", "Hermes Ring");
        addAccessorySubtitle("warrior_ring", "Warrior Ring");
        addAccessorySubtitle("growth_ring", "Ring of Growth");
        addAccessorySubtitle("ancient_ring", "Ancient Ring");
        addAccessorySubtitle("valkyrum_pendant", "Valkyrum Pendant");
        addAccessorySubtitle("hermes_pendant", "Hermes Pendant");
        addAccessorySubtitle("warrior_pendant", "Warrior Pendant");
        addAccessorySubtitle("growth_pendant", "Pendant of Growth");
        addAccessorySubtitle("ancient_pendant", "Ancient Pendant");

        addSubtitle("entity", "fluffalo.ambient", "Fluffalo moos");
        addSubtitle("entity", "fluffalo.milk", "Fluffalo gets milked");
        addSubtitle("entity", "fluffalo.hurt", "Fluffalo hurts");
        addSubtitle("entity", "fluffalo.death", "Fluffalo dies");
        addSubtitle("entity", "slammroot.jump", "Slammroot bounces");
        addSubtitle("entity", "slammroot.hurt", "Slammroot hurts");
        addSubtitle("entity", "slammroot.death", "Slammroot dies");
        addSubtitle("entity", "aeronautic_leaper.jump", "Aeronautic Leaper leaps");
        addSubtitle("entity", "aeronautic_leaper.hurt", "Aeronautic Leaper hurts");
        addSubtitle("entity", "aeronautic_leaper.death", "Aeronautic Leaper dies");
        addSubtitle("entity", "mutated_aechor_plant.shoot.needle", "Mutated Aechor Plant shoots Needle");
        addSubtitle("entity", "mutated_aechor_plant.shoot.spore_bomb", "Mutated Aechor Plant shoots Spore Bomb");
        addSubtitle("entity", "mutated_aechor_plant.hurt", "Mutated Aechor Plant hurts");
        addSubtitle("entity", "mutated_aechor_plant.death", "Mutated Aechor Plant dies");
        addSubtitle("entity", "remedy_crystal.explode", "Remedy Crystal explodes");

        addMenu("laboratory_treasure_chest", "Laboratory Treasure Chest");
        addMenu("ancient_treasure_chest", "Ancient Treasure Chest");

        addGuiText("obelisk.requirement", "You have not defeated the Sun Spirit yet");
        addGuiText("mutated_aechor_plant.title", "the Mutated Aechor Plant");

        addGeneric("laboratory_treasure_chest_locked", "This Treasure Chest must be unlocked with a Laboratory Key");
        addGeneric("ancient_treasure_chest_locked", "This Treasure Chest must be unlocked with an Ancient Key");

        addPackTitle("texture_tweaks", "Ancient Aether Texture Tweaks");
        addPackTitle("programmer_art", "Ancient Aether Programmer Art");
        addPackTitle("worldgen_overrides", "Ancient Aether Worldgen Overrides");

        addCompatPackTitle("aether_genesis", "Aether Genesis");
        addCompatPackTitle("aether_emissivity", "Aether Emissivity");
        addCompatPackTitle("lost_content", "Lost Content");
        addCompatPackTitle("aether_redux", "Aether Redux");
        addCompatPackTitle("deep_aether", "Deep Aether");
        addCompatPackTitle("deep_aether_asset", "Deep Aether Asset");

        addMenuTitle("ancient_aether", "Ancient Aether");

        addServerConfig("modpack", "server_config_overrides", "Allows Ancient Aether to override Server Config default values, should not be disabled normally");

        addCommonConfig("gameplay", "wind_blow_duration", "The duration of how long Wind Blows fired by Wind Blowers last in ticks");
        addCommonConfig("worldgen", "ancient_aether_region_weight", "The weighting of Ancient Aether Regions in the Aether");
        addCommonConfig("experimental", "experimental_features", "Enables features of the mod that are work in progress");

        addClientConfig("tooltips", "rarity_system", "Gives Aether Dungeon Loot a certain rarity in form of a tooltip");
        addClientConfig("tooltips", "moa_egg_tooltips", "Displays the Moas Mid-Air Jumps and Speed as a tooltip on the egg");
        addClientConfig("tooltips", "dungeon_block_tooltips", "Displays what mob is summoned by Trapped Dungeon Blocks as well as what boss is required to unlock Boss Doorway Blocks on the item");
        addClientConfig("gui", "custom_boss_bars", "Gives Ancient Aether Bosses custom boss bar designs");
        addClientConfig("gui", "title_screen_override", "Changes the Title Screen to the Ancient Aether Theme on start-up");
        addClientConfig("gui", "the_aether_title", "Changes the title in the Ancient Aether Title Screen to: The Aether");
        addClientConfig("modpack", "config_overrides", "Allows Ancient Aether to override Config default values, should not be disabled normally");

        add("item.minecraft.quartz", "Quartz");

        addLore(AncientAetherBlocks.GRAVITY_GRAVEL, "Stepping on this block increases your jump height. It spawns on the coasts of Elevated Islands and doesn't fall unlike its Overworld counterpart.");
        addLore(AncientAetherBlocks.WYND_ICE, "A block that behaves similar to Packed Ice that generates on the Coasts of Wyndcap Islands.");
        addLore(AncientAetherBlocks.AETHER_QUARTZ_ORE, "A source of Quartz in the Aether.");
        addLore(AncientAetherBlocks.VALKYRUM_ORE, "A very rare ore that can only be mined with a Pickaxe of Arkzenus or higher. It can be enchanted into Valkyrum using an Altar.");
        addLore(AncientAetherBlocks.ATMOSINE_CRYSTAL, "A shiny Crystal found in the Atmosine Grotto. It floats upwards similarly to Gravitite and has various different crafting uses. It is also a good fuel source for the Altar.");
        addLore(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES, "These leaves generate with Crystal Skyroot Trees. They can drop Crystal Skyroot Saplings as well as White Apples when decaying.");
        addLore(AncientAetherBlocks.SKY_GRASS, "The main grass type of the Aether. It can come in different lengths and colors depending on its surroundings.");
        addLore(AncientAetherBlocks.VALKYRUM_BLOCK, "A block compacted from Valkyrum. They can power beacons and have a noble look to them.");
        addLore(AncientAetherBlocks.AEROGEL_GLASS, "A clearer version of Aerogel crafted from 8 pieces of Aerogel and one planks in the middle. It can be crafted into all kinds of variants. Unlike regular glass, it doesn't break when mined. Mining it also doesn't require a pickaxe.");
        addLore(AncientAetherBlocks.AEROGEL_GLASS_PANE, "A decoration block crafted from Aerogel Glass. Unlike regular glass panes, it doesn't break when mined. Mining it also doesn't require a pickaxe.");
        addLore(AncientAetherBlocks.FLUFFALO_WOOL, "A very thick piece of wool obtained from Fluffalos. Its density causes it to not be flammable making it an ideal block for roofs.");
        addLore(AncientAetherBlocks.FLUFFALO_CARPET, "A cozy decoration block crafted from Fluffalo Wool.");
        addLore(AncientAetherBlocks.CARVED_TILES, "A variant of Carved Stone that can be used as a decoration block. It also generates in Bronze Dungeons, primarily as an accent block to regular Carved Stone.");
        addLore(AncientAetherBlocks.WYND_SENTRY_STONE, "A rare Sentry Stone variant exclusive to the Sentry Laboratory. It emits a dimmer light than regular Sentry Stone and can also be made in the Freezer.");
        addLore(AncientAetherBlocks.AEROGETIC_STONE, "The stone found in Ancient Dungeons. This stone has a dark metal color to it and can be mined as a decorative block.");
        addLore(AncientAetherBlocks.AERONAUTIC_STONE, "The light version of Aerogetic Stone. It is less common than Aerogetic Stone, but it looks really nice as a decorative block.");
        addLore(AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE, "A spooky variant of Aeronautic Stone.");
        addLore(AncientAetherBlocks.AMBROSIUM_LANTERN, "A decoration block that is crafted from Holystone, Skyroot Sticks and an Ambrosium Torch. This Lantern works in the Aether unlike its Overworld counterpart.");
        addLore(AncientAetherBlocks.WYND_LANTERN, "A rather dim lantern found in Sentry Laboratories. It can also be crafted using an Ambrosium Lantern and a piece of Wynd Sentry Stone.");
        addLore(AncientAetherBlocks.SUN_LANTERN, "A fancy lantern found in Gold Dungeons. It can also be crafted using an Ambrosium Lantern and a piece of Light Hellfire Stone.");
        addLore(AncientAetherBlocks.AMBROSIUM_CAMPFIRE, "A campfire that works in the Aether. It's a good Furnace alternative if you don't have a lot of Ambrosium.");
        addLore(AncientAetherBlocks.VIOLET_AERCLOUD, "A violet cloud found close to the ground. This Aercloud acts as an opposite to the Blue Aercloud since it pushes players and other entities downwards.");
        addLore(AncientAetherBlocks.WIND_BLOWER, "A way of transmitting Redstone Signals in the Aether. Activating one makes it release a Wind Blow that would activate another one if it gets hit, which causes a chain reaction. If a Windblower is active, it will emit a Redstone Signal. It can also be worn on your head if you want to look extra fancy.");
        addLore(AncientAetherBlocks.SLIDER_PROTOTYPE, "A failed experiment of the Ancient Valkyries that can only be mined with a Gravitite Pickaxes or higher. Activating it with Redstone might have spooky consequences.");
        addLore(AncientAetherBlocks.ANCIENT_OBELISK, "Found at the entrances of Ancient Dungeons and can be unlocked with Ancient Runes.");
        addLore(AncientAetherBlocks.POWERED_OBELISK, "A futuristic decoration block that can only be mined with a Gravitite Pickaxe or higher.");
        addLore(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE, "A piece of pottery crafted by freezing regular Holystone Vases.");
        addLore(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE, "An overgrown relic found in Mysterious Henges. Breaking it can yield you some shiny treasures.");
        addLore(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE, "A frosted relic found in Sentry Laboratories. Breaking it can yield you some shiny treasures.");

        addLore(AncientAetherItems.VALKYRUM, "A shiny metal that is used to forge the finest pieces of weaponry. It can also be used a noble trimming material.");
        addLore(AncientAetherItems.GRAPES, "Often found growing on the logs of Skyroot Trees in Skyroot Forests. This delicious fruit serves a great early-game food source.");
        addLore(AncientAetherItems.SLAMMBERRY, "This berry, obtained from defeating the mischievous Slammroots, launches you high up in the air and then proceeds to spread vegetation once you land again.");
        addLore(AncientAetherItems.FESTIVE_GUMMY_SWET, "A sweet-smelling gummy, it can be found in random chests in Sentry Laboratories. It fully restores the player's hunger when eaten. Very useful for boss fights.");
        addLore(AncientAetherItems.ANCIENT_SWORD, "This Sword is a reward for defeating the Ancient Dungeon Boss. It's very powerful due to its high Attack Speed.");
        addLore(AncientAetherItems.PINK_CAPE, "An extravagant Cape, crafted from Pink Wool.");
        addLore(AncientAetherItems.ANCIENT_RUNE, "Obtained from Vases or Chests in Dungeons, this Rune is the key to the Ancient Dungeon. You can duplicate it using 7 Enchanted Gravitite and one piece of Aerogel.");
        addLore(AncientAetherItems.LABORATORY_DUNGEON_KEY, "Obtained from the Mutated Aechor Plant, the final boss of the Sentry Laboratory, this frozen key can be used to unlock the treasure this lab beholds.");
        addLore(AncientAetherItems.ANCIENT_DUNGEON_KEY, "A key shimmering in an ancient blue. It is dropped by the Ancient Dungeon's Final Boss and is used to unlock the Ancient Treasure Chest!");

        addLeavesLore(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES, "Enchanted Skyroot");
        addLeavesLore(AncientAetherBlocks.SKYROOT_PINE_LEAVES, "Skyroot Pine");
        addLeavesLore(AncientAetherBlocks.HIGHSPROOT_LEAVES, "Highsproot");
        addLeavesLore(AncientAetherBlocks.SAKURA_LEAVES, "Sakura");

        addSaplingLore(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING, "Crystal Skyroot", "blue");
        addSaplingLore(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING, "Enchanted Skyroot", "indigo");
        addSaplingLore(AncientAetherBlocks.SKYROOT_PINE_SAPLING, "Skyroot Pine", "green");
        addSaplingLore(AncientAetherBlocks.HIGHSPROOT_SAPLING, "Highsproot", "blue");
        addSaplingLore(AncientAetherBlocks.SAKURA_SAPLING, "Sakura", "pink");

        addFlowerLore(AncientAetherBlocks.SUNSET_ROSE, "Red", "small", "all around the Aether");
        addFlowerLore(AncientAetherBlocks.SKY_BLUES, "Cyan", "small", "all around the Aether");
        addFlowerLore(AncientAetherBlocks.WYND_THISTLE, "Light Blue", "spiky", "near Sky Lakes as well as in the Wyndcaps");
        addFlowerLore(AncientAetherBlocks.ELEVETIA, "Purple", "mysterious", "in Elevated Islands");

        addWoodBlockLore(AncientAetherBlocks.HIGHSPROOT_LOG, "Highsproot", "The log of a tree found in the Wyndcaps Region");
        addWoodBlockLore(AncientAetherBlocks.HIGHSPROOT_WOOD, "Highsproot", "Highsproot Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG, "Highsproot", "A Highsproot Log that has had its bark stripped away with an Axe");
        addWoodBlockLore(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD, "Highsproot", "Stripped Highsproot Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientAetherBlocks.SAKURA_LOG, "Sakura", "The log of a tree found in the Sakura Jungle Region");
        addWoodBlockLore(AncientAetherBlocks.SAKURA_WOOD, "Sakura", "Sakura Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientAetherBlocks.STRIPPED_SAKURA_LOG, "Sakura", "A Sakura Log that has had its bark stripped away with an Axe");
        addWoodBlockLore(AncientAetherBlocks.STRIPPED_SAKURA_WOOD, "Sakura", "Stripped Sakura Logs crafted to be smooth on all sides");

        addPlanksLore(AncientAetherBlocks.HIGHSPROOT_PLANKS, "Highsproot");
        addPlanksLore(AncientAetherBlocks.SAKURA_PLANKS, "Sakura");

        addStairsLore(AncientAetherBlocks.HIGHSPROOT_STAIRS, "Highsproot Planks");
        addStairsLore(AncientAetherBlocks.SAKURA_STAIRS, "Sakura Planks");
        addStairsLore(AncientAetherBlocks.CARVED_TILE_STAIRS, "Carved Tiles");
        addStairsLore(AncientAetherBlocks.AEROGETIC_STAIRS, "Aerogetic Stone");

        addSlabLore(AncientAetherBlocks.HIGHSPROOT_SLAB, "Highsproot Planks");
        addSlabLore(AncientAetherBlocks.SAKURA_SLAB, "Sakura Planks");
        addSlabLore(AncientAetherBlocks.CARVED_TILE_SLAB, "Carved Tiles");
        addSlabLore(AncientAetherBlocks.AEROGETIC_SLAB, "Aerogetic Stone");

        addWallLore(AncientAetherBlocks.HIGHSPROOT_LOG_WALL, "Highsproot Logs");
        addWallLore(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL, "Highsproot Wood");
        addWallLore(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL, "Stripped Highsproot Logs");
        addWallLore(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL, "Stripped Highsproot Wood");
        addWallLore(AncientAetherBlocks.SAKURA_LOG_WALL, "Sakura Logs");
        addWallLore(AncientAetherBlocks.SAKURA_WOOD_WALL, "Sakura Wood");
        addWallLore(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL, "Stripped Sakura Logs");
        addWallLore(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL, "Stripped Sakura Wood");
        addWallLore(AncientAetherBlocks.CARVED_TILE_WALL, "Carved Tiles");
        addWallLore(AncientAetherBlocks.AEROGETIC_WALL, "Aerogetic Stone");

        addFenceLore(AncientAetherBlocks.HIGHSPROOT_FENCE, "Highsproot");
        addFenceLore(AncientAetherBlocks.SAKURA_FENCE, "Sakura");

        addFenceGateLore(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE, "Highsproot");
        addFenceGateLore(AncientAetherBlocks.SAKURA_FENCE_GATE, "Sakura");

        addDoorLore(AncientAetherBlocks.HIGHSPROOT_DOOR, "Highsproot Planks");
        addDoorLore(AncientAetherBlocks.SAKURA_DOOR, "Sakura Planks");
        addDoorLore(AncientAetherBlocks.AEROGEL_GLASS_DOOR, "Aerogel Glass");

        addTrapdoorLore(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR, "Highsproot Planks");
        addTrapdoorLore(AncientAetherBlocks.SAKURA_TRAPDOOR, "Sakura Planks");
        addTrapdoorLore(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR, "Aerogel Glass");

        addButtonLore(AncientAetherBlocks.HIGHSPROOT_BUTTON, "Highsproot");
        addButtonLore(AncientAetherBlocks.SAKURA_BUTTON, "Sakura");

        addPressurePlateLore(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE, "Highsproot");
        addPressurePlateLore(AncientAetherBlocks.SAKURA_PRESSURE_PLATE, "Sakura");

        addSignLore(AncientAetherBlocks.HIGHSPROOT_SIGN, "Highsproot");
        addSignLore(AncientAetherBlocks.SAKURA_SIGN, "Sakura");

        addHangingSignLore(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN, "Highsproot");
        addHangingSignLore(AncientAetherBlocks.SAKURA_HANGING_SIGN, "Sakura");

        addBookshelfLore(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF, "Highsproot");
        addBookshelfLore(AncientAetherBlocks.SAKURA_BOOKSHELF, "Sakura");

        addMosaicLore(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC, "Holystone Brick");
        addMosaicLore(AncientAetherBlocks.CARVED_STONE_MOSAIC, "Carved Stone");
        addMosaicLore(AncientAetherBlocks.ANGELIC_STONE_MOSAIC, "Angelic Stone");
        addMosaicLore(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC, "Hellfire Stone");
        addMosaicLore(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC, "Aerogetic Stone");
        addMosaicLore(AncientAetherBlocks.GALE_STONE_MOSAIC, "Gale Stone");

        addVaseLore(AncientAetherBlocks.HOLYSTONE_VASE, "Holystone Bricks");
        addVaseLore(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE, "Mossy Holystone");
        addVaseLore(AncientAetherBlocks.SENTRY_VASE, "Carved Stone");
        addVaseLore(AncientAetherBlocks.ANGELIC_VASE, "Angelic Stone");
        addVaseLore(AncientAetherBlocks.HELLFIRE_VASE, "Hellfire Stone");
        addVaseLore(AncientAetherBlocks.AEROGETIC_VASE, "Aerogetic Stone");
        addVaseLore(AncientAetherBlocks.GALE_VASE, "Gale Stone");

        addAncientVaseLore(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE, "Holystone Ruins");
        addAncientVaseLore(AncientAetherBlocks.ANCIENT_SENTRY_VASE, "Bronze Dungeons");
        addAncientVaseLore(AncientAetherBlocks.ANCIENT_ANGELIC_VASE, "Silver Dungeons");
        addAncientVaseLore(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE, "Gold Dungeons");
        addAncientVaseLore(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE, "Ancient Dungeons");
        addAncientVaseLore(AncientAetherBlocks.ANCIENT_GALE_VASE, "Platinum Dungeons");

        addValkyrumItemLore(AncientAetherItems.VALKYRUM_SWORD, "weapon", "It doesn't have as much reach as the other Valkyrum Equipment but it's better Attack Damage and Attack Speed make it a valid alternative to the Valkyrum Lance.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_LANCE, "weapon", "A noble weapon forged from Valkyrum. This long-range weapon is very good for defeating Zephyrs and Valkyrie Queens.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_SHOVEL, "tool", "This Shovel can help you reach Quicksoil from a safer distance; quite useful wouldn't you say?");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_PICKAXE, "tool", "This Pickaxe is very useful when it comes to mining blocks from under islands, as it has a very far reach, almost double the normal reach! It is also quite useful for fighting the Slider.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_AXE, "tool", "This Axe has a very far reach and very high attack power. You can use this to your advantage, but be warned, the attack cooldown is very high");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_HOE, "tool", "This Hoe has an incredibly far reach, allowing you to pointlessly till dirt from a safe distance.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_HELMET, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_CHESTPLATE, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_LEGGINGS, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_BOOTS, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_GLOVES, "piece of arm wear", "The Gloves are needed to complete the armor set, which grants temporary flight.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_RING, "accessory", "A noble accessory forged from Valkyrum. This ring grants you +0.5 Blocks of Reach.");
        addValkyrumItemLore(AncientAetherItems.VALKYRUM_PENDANT, "accessory", "A noble accessory forged from Valkyrum. This pendant grants you +1 Blocks of Reach.");

        addRewardLore(AncientAetherItems.DIVINE_SHOVEL, "the Valkyrie Queen", "shovel grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientAetherItems.DIVINE_PICKAXE, "the Valkyrie Queen", "pickaxe is strong enough to mine Valkyrum Ore and grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientAetherItems.DIVINE_AXE, "the Valkyrie Queen", "axe grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientAetherItems.DIVINE_HOE, "the Valkyrie Queen", "hoe grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientAetherItems.AERONAUTIC_DART_SHOOTER, "the Ancient Dungeon Boss", "dart shooter launches mobs high up in the air similar to Gravitite Equipment. You can use any type of dart as ammunition");
        addRewardLore(AncientAetherItems.HERMES_RING, "Dungeons", "ring increases your total Movement Speed by +3%");
        addRewardLore(AncientAetherItems.HERMES_PENDANT, "Dungeons", "pendant increases your total Movement Speed by +5%");
        addRewardLore(AncientAetherItems.WARRIOR_RING, "Dungeons", "ring grants you +1 Armor Toughness");
        addRewardLore(AncientAetherItems.WARRIOR_PENDANT, "Dungeons", "pendant grants you +2 Armor Toughness");
        addRewardLore(AncientAetherItems.GROWTH_RING, "the Valkyrie Queen", "ring grants you +1 Max Health");
        addRewardLore(AncientAetherItems.GROWTH_PENDANT, "the Valkyrie Queen", "pendant grants you +2 Max Health");
        addRewardLore(AncientAetherItems.ANCIENT_RING, "the Ancient Dungeon Boss", "ring grants you +0.1 Attack Speed");
        addRewardLore(AncientAetherItems.ANCIENT_PENDANT, "the Ancient Dungeon Boss", "pendant grants you +0.2 Attack Speed");
        addRewardLore(AncientAetherItems.STRENGTH_STONE, "the Valkyrie Queen", "accessory increases your total Attack Damage by +15%");
        addRewardLore(AncientAetherItems.SHIELD_OF_INEBRIATION, "the Mutated Aechor Plant", "shield has a 50% change to give attackers Inebriation");
        addRewardLore(AncientAetherItems.SHIELD_OF_REMEDIATION, "the Mutated Aechor Plant", "shield makes you immune to Inebriation");

        addTemplateLore("wynd", "vases and dungeon chests");
        addTemplateLore("whale", "vases and dungeon chests");
        addTemplateLore("ascended", "vases and dungeon chests");
        addTemplateLore("mysterious", "Mysterious Henges");

        addBossTemplateLore("mosaic", "Slider");
        addBossTemplateLore("royal", "Valkyrie Queen");
        addBossTemplateLore("solar", "Sun Spirit");
        addBossTemplateLore("mechanical", "Mutated Aechor Plant");
        addBossTemplateLore("ancient", "Ancient Dungeon Boss");

        addBoatLore(AncientAetherItems.HIGHSPROOT_BOAT);
        addBoatLore(AncientAetherItems.SAKURA_BOAT);

        addChestBoatLore(AncientAetherItems.HIGHSPROOT_CHEST_BOAT, "Highsproot");
        addChestBoatLore(AncientAetherItems.SAKURA_CHEST_BOAT, "Sakura");

        addMoaEggLore(AncientAetherItems.TURQUOISE_MOA_EGG, "Turquoise", "7", ".");
        addMoaEggLore(AncientAetherItems.TEAL_MOA_EGG, "Teal", "6", " and a faster flying speed.");
        addMoaEggLore(AncientAetherItems.SKY_BLUE_MOA_EGG, "Sky Blue", "5", " and a faster flying speed.");
        addMoaEggLore(AncientAetherItems.LAVENDER_MOA_EGG, "Lavender", "3", ". These moas have been given a very fast a flying speed as a compensation.");
        addMoaEggLore(AncientAetherItems.SAKURA_MOA_EGG, "Sakura", "12", ". While they have an insane amount of mid-air jumps, their flying speed isn't the best.");
        addMoaEggLore(AncientAetherItems.VIOLET_MOA_EGG, "Violet", "4", ". These moas have been given a very fast a flying speed as a compensation.");
        addMoaEggLore(AncientAetherItems.BURGUNDY_MOA_EGG, "Burgundy", "10", ".");
    }
}