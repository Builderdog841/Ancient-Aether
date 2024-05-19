package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.providers.AncientLanguageProvider;
import net.builderdog.ancient_aether.data.resources.registries.AncientBiomes;
import net.builderdog.ancient_aether.data.resources.registries.AncientStructures;
import net.builderdog.ancient_aether.effect.AncientEffects;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.data.PackOutput;

public class AncientLanguageData extends AncientLanguageProvider {
    public AncientLanguageData(PackOutput output) {
        super(output, AncientAether.MODID);
    }

    @Override
    protected void addTranslations() {
        String mark = " \n§6- Ancient Aether -";
        String markModified = " \n§6- Modified by Ancient Aether -";

        addBlock(AncientBlocks.GRAVITY_GRAVEL, "Gravity Gravel");
        addBlock(AncientBlocks.WYND_ICE, "Wynd Ice");
        addBlock(AncientBlocks.VALKYRIE_CLAY, "Valkyrie Clay");

        addBlock(AncientBlocks.AETHER_QUARTZ_ORE, "Aether Quartz Ore");
        addBlock(AncientBlocks.VALKYRUM_ORE, "Valkyrum Ore");
        addBlock(AncientBlocks.ATMOSINE_CRYSTAL, "Atmosine Crystal");

        addBlock(AncientBlocks.CRYSTAL_SKYROOT_LEAVES, "Crystal Skyroot Leaves");
        addBlock(AncientBlocks.ENCHANTED_SKYROOT_LEAVES, "Enchanted Skyroot Leaves");
        addBlock(AncientBlocks.SKYROOT_PINE_LEAVES, "Skyroot Pine Leaves");
        addBlock(AncientBlocks.BLUE_SKYROOT_PINE_LEAVES, "Blue Skyroot Pine Leaves");
        addBlock(AncientBlocks.HIGHSPROOT_LEAVES, "Highsproot Leaves");
        addBlock(AncientBlocks.SAKURA_LEAVES, "Sakura Leaves");

        addBlock(AncientBlocks.CRYSTAL_SKYROOT_SAPLING, "Crystal Skyroot Sapling");
        addBlock(AncientBlocks.ENCHANTED_SKYROOT_SAPLING, "Enchanted Skyroot Sapling");
        addBlock(AncientBlocks.SKYROOT_PINE_SAPLING, "Skyroot Pine Sapling");
        addBlock(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING, "Blue Skyroot Pine Sapling");
        addBlock(AncientBlocks.HIGHSPROOT_SAPLING, "Highsproot Sapling");
        addBlock(AncientBlocks.SAKURA_SAPLING, "Sakura Sapling");

        addBlock(AncientBlocks.SKY_GRASS, "Sky Grass");
        addBlock(AncientBlocks.SUNSET_ROSE, "Sunset Rose");
        addBlock(AncientBlocks.SKY_BLUES, "Sky Blues");
        addBlock(AncientBlocks.WYND_THISTLE, "Wynd Thistle");
        addBlock(AncientBlocks.ELEVETIA, "Elevetia");
        addBlock(AncientBlocks.GRAPE_VINE, "Grape Vine");
        addBlock(AncientBlocks.SLAMMROOT_PLANT, "Slammroot Plant");

        addBlock(AncientBlocks.HIGHSPROOT_LOG, "Highsproot Log");
        addBlock(AncientBlocks.HIGHSPROOT_WOOD, "Highsproot Wood");
        addBlock(AncientBlocks.STRIPPED_HIGHSPROOT_LOG, "Stripped Highsproot Log");
        addBlock(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD, "Stripped Highsproot Log");
        addBlock(AncientBlocks.SAKURA_LOG, "Sakura Log");
        addBlock(AncientBlocks.SAKURA_WOOD, "Sakura Wood");
        addBlock(AncientBlocks.STRIPPED_SAKURA_LOG, "Stripped Sakura Log");
        addBlock(AncientBlocks.STRIPPED_SAKURA_WOOD, "Stripped Sakura Log");

        addBlock(AncientBlocks.HIGHSPROOT_LOG_WALL, "Highsproot Log Wall");
        addBlock(AncientBlocks.HIGHSPROOT_WOOD_WALL, "Highsproot Wood Wall");
        addBlock(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL, "Stripped Highsproot Log Wall");
        addBlock(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL, "Stripped Highsproot Log Wall");
        addBlock(AncientBlocks.SAKURA_LOG_WALL, "Sakura Log Wall");
        addBlock(AncientBlocks.SAKURA_WOOD_WALL, "Sakura Wood Wall");
        addBlock(AncientBlocks.STRIPPED_SAKURA_LOG_WALL, "Stripped Sakura Log Wall");
        addBlock(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL, "Stripped Sakura Log Wall");

        addBlock(AncientBlocks.HIGHSPROOT_PLANKS, "Highsproot Planks");
        addBlock(AncientBlocks.HIGHSPROOT_STAIRS, "Highsproot Stairs");
        addBlock(AncientBlocks.HIGHSPROOT_SLAB, "Highsproot Slab");
        addBlock(AncientBlocks.HIGHSPROOT_FENCE, "Highsproot Fence");
        addBlock(AncientBlocks.HIGHSPROOT_FENCE_GATE, "Highsproot Fence Gate");
        addBlock(AncientBlocks.HIGHSPROOT_DOOR, "Highsproot Door");
        addBlock(AncientBlocks.HIGHSPROOT_TRAPDOOR, "Highsproot Trapdoor");
        addBlock(AncientBlocks.HIGHSPROOT_BUTTON, "Highsproot Button");
        addBlock(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE, "Highsproot Pressure Plate");
        addBlock(AncientBlocks.HIGHSPROOT_SIGN, "Highsproot Sign");
        addBlock(AncientBlocks.HIGHSPROOT_HANGING_SIGN, "Highsproot Hanging Sign");
        addBlock(AncientBlocks.HIGHSPROOT_BOOKSHELF, "Highsproot Bookshelf");

        addBlock(AncientBlocks.SAKURA_PLANKS, "Sakura Planks");
        addBlock(AncientBlocks.SAKURA_STAIRS, "Sakura Stairs");
        addBlock(AncientBlocks.SAKURA_SLAB, "Sakura Slab");
        addBlock(AncientBlocks.SAKURA_FENCE, "Sakura Fence");
        addBlock(AncientBlocks.SAKURA_FENCE_GATE, "Sakura Fence Gate");
        addBlock(AncientBlocks.SAKURA_DOOR, "Sakura Door");
        addBlock(AncientBlocks.SAKURA_TRAPDOOR, "Sakura Trapdoor");
        addBlock(AncientBlocks.SAKURA_BUTTON, "Sakura Button");
        addBlock(AncientBlocks.SAKURA_PRESSURE_PLATE, "Sakura Pressure Plate");
        addBlock(AncientBlocks.SAKURA_SIGN, "Sakura Sign");
        addBlock(AncientBlocks.SAKURA_HANGING_SIGN, "Sakura Hanging Sign");
        addBlock(AncientBlocks.SAKURA_BOOKSHELF, "Sakura Bookshelf");

        addBlock(AncientBlocks.VALKYRUM_BLOCK, "Block of Valkyrum");
        addBlock(AncientBlocks.AEROGEL_GLASS, "Aerogel Glass");
        addBlock(AncientBlocks.AEROGEL_GLASS_PANE, "Aerogel Glass Pane");
        addBlock(AncientBlocks.AEROGEL_GLASS_DOOR, "Aerogel Glass Door");
        addBlock(AncientBlocks.AEROGEL_GLASS_TRAPDOOR, "Aerogel Glass Trapdoor");
        addBlock(AncientBlocks.FLUFFALO_WOOL, "Fluffalo Wool");
        addBlock(AncientBlocks.FLUFFALO_CARPET, "Fluffalo Carpet");

        addBlock(AncientBlocks.CARVED_TILES, "Carved Tiles");
        addBlock(AncientBlocks.WYND_SENTRY_STONE, "Wynd Sentry Stone");
        addBlock(AncientBlocks.CARVED_TILE_STAIRS, "Carved Tile Stairs");
        addBlock(AncientBlocks.CARVED_TILE_SLAB, "Carved Tile Slab");
        addBlock(AncientBlocks.CARVED_TILE_WALL, "Carved Tile Wall");

        addBlock(AncientBlocks.ANGELIC_CORNER_BRICK, "Angelic Corner Brick");
        addBlock(AncientBlocks.VALKYRIE_BRICKS, "Valkyrie Bricks");
        addBlock(AncientBlocks.VALKYRIE_BRICK_STAIRS, "Valkyrie Brick Stairs");
        addBlock(AncientBlocks.VALKYRIE_BRICK_SLAB, "Valkyrie Brick Slab");
        addBlock(AncientBlocks.VALKYRIE_BRICK_WALL, "Valkyrie Brick Wall");
        addBlock(AncientBlocks.VALKYRIE_TILES, "Valkyrie Tiles");
        addBlock(AncientBlocks.VALKYRIE_TILE_STAIRS, "Valkyrie Tile Stairs");
        addBlock(AncientBlocks.VALKYRIE_TILE_SLAB, "Valkyrie Tile Slab");
        addBlock(AncientBlocks.VALKYRIE_TILE_WALL, "Valkyrie Tile Wall");

        addBlock(AncientBlocks.AEROGETIC_STONE, "Aerogetic Stone");
        addBlock(AncientBlocks.AERONAUTIC_STONE, "Aeronautic Stone");
        addBlock(AncientBlocks.CORRUPTED_AERONAUTIC_STONE, "Corrupted Aeronautic Stone");
        addBlock(AncientBlocks.AEROGETIC_STAIRS, "Aerogetic Stairs");
        addBlock(AncientBlocks.AEROGETIC_SLAB, "Aerogetic Slab");
        addBlock(AncientBlocks.AEROGETIC_WALL, "Aerogetic Wall");

        addBlock(AncientBlocks.HOLYSTONE_BRICK_MOSAIC, "Holystone Brick Mosaic");
        addBlock(AncientBlocks.CARVED_STONE_MOSAIC, "Carved Stone Mosaic");
        addBlock(AncientBlocks.ANGELIC_STONE_MOSAIC, "Angelic Stone Mosaic");
        addBlock(AncientBlocks.HELLFIRE_STONE_MOSAIC, "Hellfire Stone Mosaic");
        addBlock(AncientBlocks.AEROGETIC_STONE_MOSAIC, "Aerogetic Stone Mosaic");
        addBlock(AncientBlocks.GALE_STONE_MOSAIC, "Gale Stone Mosaic");

        addBlock(AncientBlocks.LOCKED_CARVED_TILES, "Locked Carved Tiles");
        addBlock(AncientBlocks.LOCKED_WYND_SENTRY_STONE, "Locked Wynd Sentry Stone");
        addBlock(AncientBlocks.LOCKED_AEROGETIC_STONE, "Locked Aerogetic Stone");
        addBlock(AncientBlocks.LOCKED_AERONAUTIC_STONE, "Locked Aeronautic Stone");
        addBlock(AncientBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE, "Locked Corrupted Aeronautic Stone");

        addBlock(AncientBlocks.LOCKED_CARVED_STONE_MOSAIC, "Locked Carved Stone Mosaic");
        addBlock(AncientBlocks.LOCKED_ANGELIC_STONE_MOSAIC, "Locked Angelic Stone Mosaic");
        addBlock(AncientBlocks.LOCKED_HELLFIRE_STONE_MOSAIC, "Locked Hellfire Stone Mosaic");
        addBlock(AncientBlocks.LOCKED_AEROGETIC_STONE_MOSAIC, "Locked Aerogetic Stone Mosaic");
        addBlock(AncientBlocks.LOCKED_GALE_STONE_MOSAIC, "Locked Gale Stone Mosaic");

        addBlock(AncientBlocks.TRAPPED_CARVED_TILES, "Trapped Carved Tiles");
        addBlock(AncientBlocks.TRAPPED_AEROGETIC_STONE, "Trapped Aerogetic Stone");
        addBlock(AncientBlocks.TRAPPED_AERONAUTIC_STONE, "Trapped Aeronautic Stone");
        addBlock(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE, "Trapped Corrupted Aeronautic Stone");

        addBlock(AncientBlocks.BOSS_DOORWAY_CARVED_STONE, "Boss Doorway Carved Stone");
        addBlock(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE, "Boss Doorway Wynd Sentry Stone");
        addBlock(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE, "Boss Doorway Aerogetic Stone");
        addBlock(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE, "Boss Doorway Aeronautic Stone");
        addBlock(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE, "Boss Doorway Corrupted Aeronautic Stone");

        addBlock(AncientBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE, "Treasure Doorway Wynd Sentry Stone");
        addBlock(AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE, "Treasure Doorway Aerogetic Stone");
        addBlock(AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE, "Treasure Doorway Aeronautic Stone");
        addBlock(AncientBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE, "Treasure Doorway Corrupted Aeronautic Stone");

        addBlock(AncientBlocks.AMBROSIUM_LANTERN, "Ambrosium Lantern");
        addBlock(AncientBlocks.WYND_LANTERN, "Wynd Lantern");
        addBlock(AncientBlocks.SUN_LANTERN, "Sun Lantern");
        addBlock(AncientBlocks.AMBROSIUM_CAMPFIRE, "Ambrosium Campfire");

        addBlock(AncientBlocks.VIOLET_AERCLOUD, "Violet Aercloud");
        addBlock(AncientBlocks.WIND_BLOWER, "Wind Blower");
        addBlock(AncientBlocks.SLIDER_PROTOTYPE, "Slider Prototype");
        addBlock(AncientBlocks.ANCIENT_OBELISK, "Ancient Obelisk");
        addBlock(AncientBlocks.POWERED_OBELISK, "Powered Obelisk");

        addBlock(AncientBlocks.HOLYSTONE_VASE, "Holystone Vase");
        addBlock(AncientBlocks.MOSSY_HOLYSTONE_VASE, "Mossy Holystone Vase");
        addBlock(AncientBlocks.FROZEN_HOLYSTONE_VASE, "Frozen Holystone Vase");
        addBlock(AncientBlocks.SENTRY_VASE, "Sentry Vase");
        addBlock(AncientBlocks.ANGELIC_VASE, "Angelic Vase");
        addBlock(AncientBlocks.HELLFIRE_VASE, "Hellfire Vase");
        addBlock(AncientBlocks.AEROGETIC_VASE, "Aerogetic Vase");
        addBlock(AncientBlocks.GALE_VASE, "Gale Vase");

        addBlock(AncientBlocks.ANCIENT_HOLYSTONE_VASE, "Ancient Holystone Vase");
        addBlock(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE, "Ancient Mossy Holystone Vase");
        addBlock(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE, "Ancient Frozen Holystone Vase");
        addBlock(AncientBlocks.ANCIENT_SENTRY_VASE, "Ancient Sentry Vase");
        addBlock(AncientBlocks.ANCIENT_ANGELIC_VASE, "Ancient Angelic Vase");
        addBlock(AncientBlocks.ANCIENT_HELLFIRE_VASE, "Ancient Hellfire Vase");
        addBlock(AncientBlocks.ANCIENT_AEROGETIC_VASE, "Ancient Aerogetic Vase");
        addBlock(AncientBlocks.ANCIENT_GALE_VASE, "Ancient Gale Vase");

        addBlock(AncientBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING, "Potted Crystal Skyroot Sapling");
        addBlock(AncientBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING, "Potted Enchanted Skyroot Sapling");
        addBlock(AncientBlocks.POTTED_SKYROOT_PINE_SAPLING, "Potted Skyroot Pine Sapling");
        addBlock(AncientBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING, "Potted Blue Skyroot Pine Sapling");
        addBlock(AncientBlocks.POTTED_HIGHSPROOT_SAPLING, "Potted Highsproot Sapling");
        addBlock(AncientBlocks.POTTED_SAKURA_SAPLING, "Potted Sakura Sapling");
        addBlock(AncientBlocks.POTTED_SUNSET_ROSE, "Potted Sunset Rose");
        addBlock(AncientBlocks.POTTED_SKY_BLUES, "Potted Sky Blues");
        addBlock(AncientBlocks.POTTED_WYND_THISTLE, "Potted Wynd Thistle");
        addBlock(AncientBlocks.POTTED_ELEVETIA, "Potted Elevatia");

        addItem(AncientItems.VALKYRUM, "Valkyrum");
        addItem(AncientItems.VALKYRIE_CLAY_BALL, "Valkyrie Clay Ball");
        addItem(AncientItems.VALKYRIE_BRICK, "Valkyrie Brick");

        addItem(AncientItems.GRAPES, "Grapes");
        addItem(AncientItems.SLAMMBERRY, "Slammberry");
        addItem(AncientItems.FESTIVE_GUMMY_SWET, "Festive Gummy Swet");

        addItem(AncientItems.VALKYRUM_SWORD, "Valkyrum Sword");
        addItem(AncientItems.VALKYRUM_LANCE, "Valkyrum Lance");
        addItem(AncientItems.VALKYRUM_SHOVEL, "Valkyrum Shovel");
        addItem(AncientItems.VALKYRUM_PICKAXE, "Valkyrum Pickaxe");
        addItem(AncientItems.VALKYRUM_AXE, "Valkyrum Axe");
        addItem(AncientItems.VALKYRUM_HOE, "Valkyrum Hoe");

        addItem(AncientItems.DIVINE_SHOVEL, "Divine Shovel");
        addItem(AncientItems.DIVINE_PICKAXE, "Divine Pickaxe");
        addItem(AncientItems.DIVINE_AXE, "Divine Axe");
        addItem(AncientItems.DIVINE_HOE, "Divine Hoe");

        addItem(AncientItems.VALKYRUM_HELMET, "Valkyrum Helmet");
        addItem(AncientItems.VALKYRUM_CHESTPLATE, "Valkyrum Chestplate");
        addItem(AncientItems.VALKYRUM_LEGGINGS, "Valkyrum Leggings");
        addItem(AncientItems.VALKYRUM_BOOTS, "Valkyrum Boots");
        addItem(AncientItems.VALKYRUM_GLOVES, "Valkyrum Gloves");

        addItem(AncientItems.ANCIENT_SWORD, "Ancient Sword");
        addItem(AncientItems.AERONAUTIC_DART_SHOOTER, "Aeronautic Dart Shooter");

        addItem(AncientItems.VALKYRUM_RING, "Valkyrum Ring");
        addItem(AncientItems.HERMES_RING, "Hermes Ring");
        addItem(AncientItems.WARRIOR_RING, "Warrior Ring");
        addItem(AncientItems.GROWTH_RING, "Ring of Growth");
        addItem(AncientItems.ANCIENT_RING, "Ancient Ring");

        addItem(AncientItems.VALKYRUM_PENDANT, "Valkyrum Pendant");
        addItem(AncientItems.HERMES_PENDANT, "Hermes Pendant");
        addItem(AncientItems.WARRIOR_PENDANT, "Warrior Pendant");
        addItem(AncientItems.GROWTH_PENDANT, "Pendant of Growth");
        addItem(AncientItems.ANCIENT_PENDANT, "Ancient Pendant");

        addItem(AncientItems.PINK_CAPE, "Pink Cape");
        addItem(AncientItems.SHIELD_OF_INEBRIATION, "Shield of Inebriation");
        addItem(AncientItems.SHIELD_OF_REMEDIATION, "Shield of Remediation");
        addItem(AncientItems.STRENGTH_STONE, "Strength Stone");

        addItem(AncientItems.ANCIENT_RUNE, "Ancient Rune");
        addItem(AncientItems.LABORATORY_DUNGEON_KEY, "Laboratory Key");
        addItem(AncientItems.ANCIENT_DUNGEON_KEY, "Ancient Key");

        addItem(AncientItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");
        addItem(AncientItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE, "Smithing Template");

        addItem(AncientItems.HIGHSPROOT_BOAT, "Highsproot Boat");
        addItem(AncientItems.HIGHSPROOT_CHEST_BOAT, "Highsproot Chest Boat");
        addItem(AncientItems.SAKURA_BOAT, "Sakura Boat");
        addItem(AncientItems.SAKURA_CHEST_BOAT, "Sakura Chest Boat");

        addItem(AncientItems.TURQUOISE_MOA_EGG, "Turquoise Moa Egg");
        addItem(AncientItems.TEAL_MOA_EGG, "Teal Moa Egg");
        addItem(AncientItems.SKY_BLUE_MOA_EGG, "Sky Blue Moa Egg");
        addItem(AncientItems.LAVENDER_MOA_EGG, "Lavender Moa Egg");
        addItem(AncientItems.SAKURA_MOA_EGG, "Sakura Moa Egg");
        addItem(AncientItems.VIOLET_MOA_EGG, "Violet Moa Egg");
        addItem(AncientItems.BURGUNDY_MOA_EGG, "Burgundy Moa Egg");

        addItem(AncientItems.FLUFFALO_SPAWN_EGG, "Fluffalo Spawn Egg");
        addItem(AncientItems.FESTIVE_SWET_SPAWN_EGG, "Festive Swet Spawn Egg");
        addItem(AncientItems.SLAMMROOT_SPAWN_EGG, "Slammroot Spawn Egg");
        addItem(AncientItems.AERONAUTIC_LEAPER_SPAWN_EGG, "Aeronautic Leaper Spawn Egg");
        addItem(AncientItems.MUTATED_AECHOR_PLANT_SPAWN_EGG, "Mutated Aechor Plant Spawn Egg");

        addEntityType(AncientEntityTypes.FLUFFALO, "Fluffalo");
        addEntityType(AncientEntityTypes.FESTIVE_SWET, "Festive Swet");
        addEntityType(AncientEntityTypes.SLAMMROOT, "Slammroot");
        addEntityType(AncientEntityTypes.AERONAUTIC_LEAPER, "Aeronautic Leaper");
        addEntityType(AncientEntityTypes.MUTATED_AECHOR_PLANT, "Mutated Aechor Plant");

        addEntityType(AncientEntityTypes.BOAT, "Boat");
        addEntityType(AncientEntityTypes.CHEST_BOAT, "Chest Boat");
        addEntityType(AncientEntityTypes.WIND_BLOW, "Wind Blow");
        addEntityType(AncientEntityTypes.AERONAUTIC_DART, "Aeronautic Dart");
        addEntityType(AncientEntityTypes.MUTATED_AECHOR_NEEDLE, "Mutated Aechor Needle");
        addEntityType(AncientEntityTypes.SPORE_BOMB, "Spore Bomb");
        addEntityType(AncientEntityTypes.REMEDY_CRYSTAL, "Remedy Crystal");

        addBiome(AncientBiomes.SUN_FOREST, "Sun Forest");
        addBiome(AncientBiomes.WYNDCAP_TAIGA, "Wyndcaps Taiga");
        addBiome(AncientBiomes.FESTIVE_WYNDCAP_TAIGA, "Festive Wyndcaps Taiga");
        addBiome(AncientBiomes.WYNDCAP_HIGHLAND, "Wyndcaps Highland");
        addBiome(AncientBiomes.WYNDCAP_PEAKS, "Wyndcaps Peaks");
        addBiome(AncientBiomes.SKYROOT_JUNGLE, "Skyroot Jungle");
        addBiome(AncientBiomes.SAKURA_JUNGLE, "Sakura Jungle");
        addBiome(AncientBiomes.ELEVATED_CLEARING, "Elevated Clearing");
        addBiome(AncientBiomes.ELEVATED_FOREST, "Elevated Forest");
        addBiome(AncientBiomes.SKY_LAKE, "Sky Lake");
        addBiome(AncientBiomes.HOLYSTONE_CAVERNS, "Holystone Caverns");
        addBiome(AncientBiomes.FROZEN_CAVERNS, "Frozen Caverns");
        addBiome(AncientBiomes.ELEVATED_CAVERNS, "Elevated Caverns");

        addStructure(AncientStructures.HOLYSTONE_RUIN, "Holystone Ruin");
        addStructure(AncientStructures.MYSTERIOUS_HENGE, "Mysterious Henge");
        addStructure(AncientStructures.VALKYRIE_CAMP_SKYROOT, "Valkyrie Camp Skyroot");
        addStructure(AncientStructures.VALKYRIE_CAMP_WYNDCAPS, "Valkyrie Camp Wyndcaps");
        addStructure(AncientStructures.VALKYRIE_SETTLEMENT_SKYROOT, "Valkyrie Settlement Skyroot");
        addStructure(AncientStructures.SENTRY_LABORATORY, "Sentry Laboratory");
        addStructure(AncientStructures.ANCIENT_DUNGEON, "Ancient Dungeon");

        addEffect(AncientEffects.DIVINE_PROTECTION, "Divine Protection");
        addEffect(AncientEffects.NATURES_BOOST, "Nature's Boost");

        addEffectDesc(AncientEffects.DIVINE_PROTECTION, "A protection buff granted by using Divine Tools");
        addEffectDesc(AncientEffects.NATURES_BOOST, "Makes the player jump high into the air and fertilizes the ground once they land");

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

        addCompatibilityPackTitle("aether_genesis", "Aether Genesis");
        addCompatibilityPackTitle("aether_emissivity", "Aether Emissivity");
        addCompatibilityPackTitle("lost_aether_content", "Lost Content");
        addCompatibilityPackTitle("aether_redux", "Aether Redux");
        addCompatibilityPackTitle("deep_aether", "Deep Aether");
        addCompatibilityPackTitle("deep_aether_assets", "Deep Aether Assets");

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

        addLore(AncientBlocks.GRAVITY_GRAVEL, "Stepping on this block increases your jump height. It generates on the coasts of Elevated Islands and doesn't fall unlike its Overworld counterpart.");
        addLore(AncientBlocks.WYND_ICE, "A block that behaves similar to Packed Ice and can be found on the coasts of Wyndcap Islands.");
        addLore(AncientBlocks.VALKYRIE_CLAY, "The Aether's equivalent of clay. It can be found in shallow areas of Sky Lakes");
        addLore(AncientBlocks.AETHER_QUARTZ_ORE, "A source of Quartz in the Aether.");
        addLore(AncientBlocks.VALKYRUM_ORE, "A very rare ore that can only be mined with a Pickaxe of Arkzenus or higher. It can be enchanted into Valkyrum using an Altar.");
        addLore(AncientBlocks.ATMOSINE_CRYSTAL, "A shiny crystal that floats upwards similarly to Gravitite and is good fuel supplier for the Altar.");
        addLore(AncientBlocks.CRYSTAL_SKYROOT_LEAVES, "These leaves generate with Crystal Skyroot Trees. They can drop Crystal Skyroot Saplings as well as White Apples when decaying.");
        addLore(AncientBlocks.SKY_GRASS, "The main grass type of the Aether. It can come in different lengths and colors depending on its surroundings.");
        addLore(AncientBlocks.VALKYRUM_BLOCK, "A block compacted from Valkyrum. They can power beacons and have a noble look to them.");
        addLore(AncientBlocks.AEROGEL_GLASS, "A clearer version of Aerogel crafted from 8 pieces of Aerogel and one planks in the middle. It can be crafted into all kinds of variants. Unlike regular glass, it doesn't break when mined. Mining it also doesn't require a pickaxe.");
        addLore(AncientBlocks.AEROGEL_GLASS_PANE, "A decoration block crafted from Aerogel Glass. Unlike regular glass panes, it doesn't break when mined. Mining it also doesn't require a pickaxe.");
        addLore(AncientBlocks.FLUFFALO_WOOL, "A very thick piece of wool obtained from Fluffalos. Its density causes it to not be flammable making it an ideal block for roofs.");
        addLore(AncientBlocks.FLUFFALO_CARPET, "A cozy decoration block crafted from Fluffalo Wool.");
        addLore(AncientBlocks.CARVED_TILES, "A variant of Carved Stone that can be used as a decoration block. It also generates in Bronze Dungeons, primarily as an accent block to regular Carved Stone.");
        addLore(AncientBlocks.WYND_SENTRY_STONE, "A rare Sentry Stone variant exclusive to the Sentry Laboratory. It emits a dimmer light than regular Sentry Stone and can also be made in the Freezer.");
        addLore(AncientBlocks.ANGELIC_CORNER_BRICK, "A variant of Angelic Stone. Due to its unique texture you can rotate it to create a quite interesting wall patterns for your builds.");
        addLore(AncientBlocks.VALKYRIE_BRICKS, "The result from smelting Valkyrie Clay after crafting it together. These pristine bricks make for a nice building material that can crafted into several variants.");
        addLore(AncientBlocks.VALKYRIE_TILES, "A variant of Valkyrie Bricks that works nicely as a shiny floor block.");
        addLore(AncientBlocks.AEROGETIC_STONE, "A stone found in Ancient Dungeons. This stone has a dark metal color to it and can be mined as a decorative block.");
        addLore(AncientBlocks.AERONAUTIC_STONE, "The light version of Aerogetic Stone. It is less common than Aerogetic Stone, but it looks really nice as a decorative block.");
        addLore(AncientBlocks.CORRUPTED_AERONAUTIC_STONE, "A spooky variant of Aeronautic Stone.");
        addLore(AncientBlocks.AMBROSIUM_LANTERN, "A decoration block that is crafted from Holystone, Skyroot Sticks and an Ambrosium Torch. This Lantern works in the Aether unlike its Overworld counterpart.");
        addLore(AncientBlocks.WYND_LANTERN, "A dim lantern found in Sentry Laboratories. It can also be crafted using an Ambrosium Lantern and a piece of Wynd Sentry Stone.");
        addLore(AncientBlocks.SUN_LANTERN, "A fancy lantern found in Gold Dungeons. It can also be crafted using an Ambrosium Lantern and a piece of Light Hellfire Stone.");
        addLore(AncientBlocks.AMBROSIUM_CAMPFIRE, "A campfire that works in the Aether. It's a good Furnace alternative if you don't have a lot of Ambrosium.");
        addLore(AncientBlocks.VIOLET_AERCLOUD, "A violet cloud found close to the ground. This Aercloud acts as an opposite to the Blue Aercloud since it pushes players and other entities downwards.");
        addLore(AncientBlocks.WIND_BLOWER, "A way of transmitting Redstone Signals in the Aether. Activating one makes it release a Wind Blow that would activate another one if it gets hit, which causes a chain reaction. If a Windblower is active, it will emit a Redstone Signal. It can also be worn on your head if you want to look extra fancy.");
        addLore(AncientBlocks.SLIDER_PROTOTYPE, "A failed experiment of the Ancient Valkyries that can only be mined with a Gravitite Pickaxes or higher. Activating it with Redstone might have spooky consequences.");
        addLore(AncientBlocks.ANCIENT_OBELISK, "Found at the entrances of Ancient Dungeons and can be unlocked with Ancient Runes.");
        addLore(AncientBlocks.POWERED_OBELISK, "A futuristic decoration block that can only be mined with a Gravitite Pickaxe or higher.");
        addLore(AncientBlocks.FROZEN_HOLYSTONE_VASE, "A piece of pottery crafted by freezing regular Holystone Vases.");
        addLore(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE, "An overgrown relic found in Mysterious Henges. Breaking it can yield you some shiny treasures.");
        addLore(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE, "A frosted relic found in Sentry Laboratories. Breaking it can yield you some shiny treasures.");

        addLore(AncientItems.VALKYRUM, "A shiny metal that is used to forge the finest pieces of weaponry. It can also be used a noble trimming material.");
        addLore(AncientItems.VALKYRIE_CLAY_BALL, "Obtained from mining Valkyrie Clay, this item can either be smelted into a Valkyrie Brick or crafted back into a block.");
        addLore(AncientItems.VALKYRIE_BRICK, "A shiny white brick that can be crafted into various different decoration blocks like Valkyrie Bricks or Vases.");
        addLore(AncientItems.GRAPES, "Often found growing on the logs of Skyroot Trees in Skyroot Forests. This delicious fruit serves as a great early-game food source.");
        addLore(AncientItems.SLAMMBERRY, "This berry, obtained from defeating the mischievous Slammroots, launches you high up in the air and then proceeds to spread vegetation once you land again.");
        addLore(AncientItems.FESTIVE_GUMMY_SWET, "A sweet-smelling gummy, it can be found in random chests in Sentry Laboratories. It fully restores the player's hunger when eaten. Very useful for boss fights.");
        addLore(AncientItems.ANCIENT_SWORD, "This Sword is a reward for defeating the Ancient Dungeon Boss. It's very powerful due to its high Attack Speed.");
        addLore(AncientItems.PINK_CAPE, "An extravagant Cape, crafted from Pink Wool.");
        addLore(AncientItems.ANCIENT_RUNE, "Obtained from Vases or Chests in Dungeons, this Rune is the key to the Ancient Dungeon. You can duplicate it using 7 Enchanted Gravitite and one piece of Aerogel.");
        addLore(AncientItems.LABORATORY_DUNGEON_KEY, "Obtained from the Mutated Aechor Plant, the final boss of the Sentry Laboratory, this frozen key can be used to unlock the treasure this lab beholds.");
        addLore(AncientItems.ANCIENT_DUNGEON_KEY, "A key shimmering in an ancient blue. It is dropped by the Ancient Dungeon's Final Boss and is used to unlock the Ancient Treasure Chest!");

        addLeavesLore(AncientBlocks.ENCHANTED_SKYROOT_LEAVES, "Enchanted Skyroot");
        addLeavesLore(AncientBlocks.SKYROOT_PINE_LEAVES, "Skyroot Pine");
        addLeavesLore(AncientBlocks.HIGHSPROOT_LEAVES, "Highsproot");
        addLeavesLore(AncientBlocks.SAKURA_LEAVES, "Sakura");

        addSaplingLore(AncientBlocks.CRYSTAL_SKYROOT_SAPLING, "Crystal Skyroot", "blue");
        addSaplingLore(AncientBlocks.ENCHANTED_SKYROOT_SAPLING, "Enchanted Skyroot", "indigo");
        addSaplingLore(AncientBlocks.SKYROOT_PINE_SAPLING, "Skyroot Pine", "green");
        addSaplingLore(AncientBlocks.HIGHSPROOT_SAPLING, "Highsproot", "blue");
        addSaplingLore(AncientBlocks.SAKURA_SAPLING, "Sakura", "pink");

        addFlowerLore(AncientBlocks.SUNSET_ROSE, "Red", "small", "all around the Aether");
        addFlowerLore(AncientBlocks.SKY_BLUES, "Cyan", "small", "all around the Aether");
        addFlowerLore(AncientBlocks.WYND_THISTLE, "Light Blue", "spiky", "near Sky Lakes as well as in the Wyndcaps");
        addFlowerLore(AncientBlocks.ELEVETIA, "Purple", "mysterious", "in Elevated Islands");

        addWoodBlockLore(AncientBlocks.HIGHSPROOT_LOG, "Highsproot", "The log of a tree found in the Wyndcaps Region");
        addWoodBlockLore(AncientBlocks.HIGHSPROOT_WOOD, "Highsproot", "Highsproot Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientBlocks.STRIPPED_HIGHSPROOT_LOG, "Highsproot", "A Highsproot Log that has had its bark stripped away with an Axe");
        addWoodBlockLore(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD, "Highsproot", "Stripped Highsproot Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientBlocks.SAKURA_LOG, "Sakura", "The log of a tree found in the Sakura Jungle Region");
        addWoodBlockLore(AncientBlocks.SAKURA_WOOD, "Sakura", "Sakura Logs crafted to be smooth on all sides");
        addWoodBlockLore(AncientBlocks.STRIPPED_SAKURA_LOG, "Sakura", "A Sakura Log that has had its bark stripped away with an Axe");
        addWoodBlockLore(AncientBlocks.STRIPPED_SAKURA_WOOD, "Sakura", "Stripped Sakura Logs crafted to be smooth on all sides");

        addPlanksLore(AncientBlocks.HIGHSPROOT_PLANKS, "Highsproot");
        addPlanksLore(AncientBlocks.SAKURA_PLANKS, "Sakura");

        addStairsLore(AncientBlocks.HIGHSPROOT_STAIRS, "Highsproot Planks");
        addStairsLore(AncientBlocks.SAKURA_STAIRS, "Sakura Planks");
        addStairsLore(AncientBlocks.CARVED_TILE_STAIRS, "Carved Tiles");
        addStairsLore(AncientBlocks.VALKYRIE_BRICK_STAIRS, "Valkyrie Bricks");
        addStairsLore(AncientBlocks.VALKYRIE_TILE_STAIRS, "Valkyrie Tiles");
        addStairsLore(AncientBlocks.AEROGETIC_STAIRS, "Aerogetic Stone");

        addSlabLore(AncientBlocks.HIGHSPROOT_SLAB, "Highsproot Planks");
        addSlabLore(AncientBlocks.SAKURA_SLAB, "Sakura Planks");
        addSlabLore(AncientBlocks.CARVED_TILE_SLAB, "Carved Tiles");
        addSlabLore(AncientBlocks.VALKYRIE_BRICK_SLAB, "Valkyrie Bricks");
        addSlabLore(AncientBlocks.VALKYRIE_TILE_SLAB, "Valkyrie Tiles");
        addSlabLore(AncientBlocks.AEROGETIC_SLAB, "Aerogetic Stone");

        addWallLore(AncientBlocks.HIGHSPROOT_LOG_WALL, "Highsproot Logs");
        addWallLore(AncientBlocks.HIGHSPROOT_WOOD_WALL, "Highsproot Wood");
        addWallLore(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL, "Stripped Highsproot Logs");
        addWallLore(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL, "Stripped Highsproot Wood");
        addWallLore(AncientBlocks.SAKURA_LOG_WALL, "Sakura Logs");
        addWallLore(AncientBlocks.SAKURA_WOOD_WALL, "Sakura Wood");
        addWallLore(AncientBlocks.STRIPPED_SAKURA_LOG_WALL, "Stripped Sakura Logs");
        addWallLore(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL, "Stripped Sakura Wood");
        addWallLore(AncientBlocks.CARVED_TILE_WALL, "Carved Tiles");
        addWallLore(AncientBlocks.VALKYRIE_BRICK_WALL, "Valkyrie Bricks");
        addWallLore(AncientBlocks.VALKYRIE_TILE_WALL, "Valkyrie Tiles");
        addWallLore(AncientBlocks.AEROGETIC_WALL, "Aerogetic Stone");

        addFenceLore(AncientBlocks.HIGHSPROOT_FENCE, "Highsproot");
        addFenceLore(AncientBlocks.SAKURA_FENCE, "Sakura");

        addFenceGateLore(AncientBlocks.HIGHSPROOT_FENCE_GATE, "Highsproot");
        addFenceGateLore(AncientBlocks.SAKURA_FENCE_GATE, "Sakura");

        addDoorLore(AncientBlocks.HIGHSPROOT_DOOR, "Highsproot Planks");
        addDoorLore(AncientBlocks.SAKURA_DOOR, "Sakura Planks");
        addDoorLore(AncientBlocks.AEROGEL_GLASS_DOOR, "Aerogel Glass");

        addTrapdoorLore(AncientBlocks.HIGHSPROOT_TRAPDOOR, "Highsproot Planks");
        addTrapdoorLore(AncientBlocks.SAKURA_TRAPDOOR, "Sakura Planks");
        addTrapdoorLore(AncientBlocks.AEROGEL_GLASS_TRAPDOOR, "Aerogel Glass");

        addButtonLore(AncientBlocks.HIGHSPROOT_BUTTON, "Highsproot");
        addButtonLore(AncientBlocks.SAKURA_BUTTON, "Sakura");

        addPressurePlateLore(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE, "Highsproot");
        addPressurePlateLore(AncientBlocks.SAKURA_PRESSURE_PLATE, "Sakura");

        addSignLore(AncientBlocks.HIGHSPROOT_SIGN, "Highsproot");
        addSignLore(AncientBlocks.SAKURA_SIGN, "Sakura");

        addHangingSignLore(AncientBlocks.HIGHSPROOT_HANGING_SIGN, "Highsproot");
        addHangingSignLore(AncientBlocks.SAKURA_HANGING_SIGN, "Sakura");

        addBookshelfLore(AncientBlocks.HIGHSPROOT_BOOKSHELF, "Highsproot");
        addBookshelfLore(AncientBlocks.SAKURA_BOOKSHELF, "Sakura");

        addMosaicLore(AncientBlocks.HOLYSTONE_BRICK_MOSAIC, "Holystone Brick");
        addMosaicLore(AncientBlocks.CARVED_STONE_MOSAIC, "Carved Stone");
        addMosaicLore(AncientBlocks.ANGELIC_STONE_MOSAIC, "Angelic Stone");
        addMosaicLore(AncientBlocks.HELLFIRE_STONE_MOSAIC, "Hellfire Stone");
        addMosaicLore(AncientBlocks.AEROGETIC_STONE_MOSAIC, "Aerogetic Stone");
        addMosaicLore(AncientBlocks.GALE_STONE_MOSAIC, "Gale Stone");

        addVaseLore(AncientBlocks.HOLYSTONE_VASE, "Holystone Bricks");
        addVaseLore(AncientBlocks.MOSSY_HOLYSTONE_VASE, "Mossy Holystone");
        addVaseLore(AncientBlocks.SENTRY_VASE, "Carved Stone");
        addVaseLore(AncientBlocks.ANGELIC_VASE, "Angelic Stone");
        addVaseLore(AncientBlocks.HELLFIRE_VASE, "Hellfire Stone");
        addVaseLore(AncientBlocks.AEROGETIC_VASE, "Aerogetic Stone");
        addVaseLore(AncientBlocks.GALE_VASE, "Gale Stone");

        addAncientVaseLore(AncientBlocks.ANCIENT_HOLYSTONE_VASE, "Holystone Ruins");
        addAncientVaseLore(AncientBlocks.ANCIENT_SENTRY_VASE, "Bronze Dungeons");
        addAncientVaseLore(AncientBlocks.ANCIENT_ANGELIC_VASE, "Silver Dungeons");
        addAncientVaseLore(AncientBlocks.ANCIENT_HELLFIRE_VASE, "Gold Dungeons");
        addAncientVaseLore(AncientBlocks.ANCIENT_AEROGETIC_VASE, "Ancient Dungeons");
        addAncientVaseLore(AncientBlocks.ANCIENT_GALE_VASE, "Platinum Dungeons");

        addValkyrumItemLore(AncientItems.VALKYRUM_SWORD, "weapon", "It doesn't have as much reach as the other Valkyrum Equipment but it's better Attack Damage and Attack Speed make it a valid alternative to the Valkyrum Lance.");
        addValkyrumItemLore(AncientItems.VALKYRUM_LANCE, "weapon", "A noble weapon forged from Valkyrum. This long-range weapon is very good for defeating Zephyrs and Valkyrie Queens.");
        addValkyrumItemLore(AncientItems.VALKYRUM_SHOVEL, "tool", "This Shovel can help you reach Quicksoil from a safer distance; quite useful wouldn't you say?");
        addValkyrumItemLore(AncientItems.VALKYRUM_PICKAXE, "tool", "This Pickaxe is very useful when it comes to mining blocks from under islands, as it has a very far reach, almost double the normal reach! It is also quite useful for fighting the Slider.");
        addValkyrumItemLore(AncientItems.VALKYRUM_AXE, "tool", "This Axe has a very far reach and very high attack power. You can use this to your advantage, but be warned, the attack cooldown is very high");
        addValkyrumItemLore(AncientItems.VALKYRUM_HOE, "tool", "This Hoe has an incredibly far reach, allowing you to pointlessly till dirt from a safe distance.");
        addValkyrumItemLore(AncientItems.VALKYRUM_HELMET, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientItems.VALKYRUM_CHESTPLATE, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientItems.VALKYRUM_LEGGINGS, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientItems.VALKYRUM_BOOTS, "piece of armor", "When fully worn, you are granted temporary flight. Quite useful for getting to high places.");
        addValkyrumItemLore(AncientItems.VALKYRUM_GLOVES, "piece of arm wear", "The Gloves are needed to complete the armor set, which grants temporary flight.");
        addValkyrumItemLore(AncientItems.VALKYRUM_RING, "accessory", "A noble accessory forged from Valkyrum. This ring grants you +0.5 Blocks of Reach.");
        addValkyrumItemLore(AncientItems.VALKYRUM_PENDANT, "accessory", "A noble accessory forged from Valkyrum. This pendant grants you +1 Blocks of Reach.");

        addRewardLore(AncientItems.DIVINE_SHOVEL, "the Valkyrie Queen", "shovel grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientItems.DIVINE_PICKAXE, "the Valkyrie Queen", "pickaxe is strong enough to mine Valkyrum Ore and grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientItems.DIVINE_AXE, "the Valkyrie Queen", "axe grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientItems.DIVINE_HOE, "the Valkyrie Queen", "hoe grants you bonus protection when used. The duration of the buff increases the more blocks you mine.");
        addRewardLore(AncientItems.AERONAUTIC_DART_SHOOTER, "the Ancient Dungeon Boss", "dart shooter launches mobs high up in the air similar to Gravitite Equipment. You can use any type of dart as ammunition");
        addRewardLore(AncientItems.HERMES_RING, "Dungeons", "ring increases your total Movement Speed by +3%");
        addRewardLore(AncientItems.HERMES_PENDANT, "Dungeons", "pendant increases your total Movement Speed by +5%");
        addRewardLore(AncientItems.WARRIOR_RING, "Dungeons", "ring grants you +1 Armor Toughness");
        addRewardLore(AncientItems.WARRIOR_PENDANT, "Dungeons", "pendant grants you +2 Armor Toughness");
        addRewardLore(AncientItems.GROWTH_RING, "the Valkyrie Queen", "ring grants you +1 Max Health");
        addRewardLore(AncientItems.GROWTH_PENDANT, "the Valkyrie Queen", "pendant grants you +2 Max Health");
        addRewardLore(AncientItems.ANCIENT_RING, "the Ancient Dungeon Boss", "ring grants you +0.1 Attack Speed");
        addRewardLore(AncientItems.ANCIENT_PENDANT, "the Ancient Dungeon Boss", "pendant grants you +0.2 Attack Speed");
        addRewardLore(AncientItems.STRENGTH_STONE, "the Valkyrie Queen", "accessory increases your total Attack Damage by +15%");
        addRewardLore(AncientItems.SHIELD_OF_INEBRIATION, "the Mutated Aechor Plant", "shield has a 50% change to give attackers Inebriation");
        addRewardLore(AncientItems.SHIELD_OF_REMEDIATION, "the Mutated Aechor Plant", "shield makes you immune to Inebriation");

        addTemplateLore("wynd", "vases and dungeon chests");
        addTemplateLore("whale", "vases and dungeon chests");
        addTemplateLore("ascended", "vases and dungeon chests");
        addTemplateLore("mysterious", "Mysterious Henges");

        addBossTemplateLore("mosaic", "Slider");
        addBossTemplateLore("royal", "Valkyrie Queen");
        addBossTemplateLore("solar", "Sun Spirit");
        addBossTemplateLore("mechanical", "Mutated Aechor Plant");
        addBossTemplateLore("ancient", "Ancient Dungeon Boss");

        addBoatLore(AncientItems.HIGHSPROOT_BOAT);
        addBoatLore(AncientItems.SAKURA_BOAT);

        addChestBoatLore(AncientItems.HIGHSPROOT_CHEST_BOAT, "Highsproot");
        addChestBoatLore(AncientItems.SAKURA_CHEST_BOAT, "Sakura");

        addMoaEggLore(AncientItems.TURQUOISE_MOA_EGG, "Turquoise", "7", ".");
        addMoaEggLore(AncientItems.TEAL_MOA_EGG, "Teal", "6", " and a faster flying speed.");
        addMoaEggLore(AncientItems.SKY_BLUE_MOA_EGG, "Sky Blue", "5", " and a faster flying speed.");
        addMoaEggLore(AncientItems.LAVENDER_MOA_EGG, "Lavender", "3", ". These moas have been given a very fast a flying speed as a compensation.");
        addMoaEggLore(AncientItems.SAKURA_MOA_EGG, "Sakura", "12", ". While they have an insane amount of mid-air jumps, their flying speed isn't the best.");
        addMoaEggLore(AncientItems.VIOLET_MOA_EGG, "Violet", "4", ". These moas have been given a very fast a flying speed as a compensation.");
        addMoaEggLore(AncientItems.BURGUNDY_MOA_EGG, "Burgundy", "10", ".");
    }
}