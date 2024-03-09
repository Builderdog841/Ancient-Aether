package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.providers.AncientAetherLanguageProvider;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
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

        addBlock(AncientAetherBlocks.AETHER_QUARTZ_ORE, "Aether Quartz Ore");
        addBlock(AncientAetherBlocks.VALKYRUM_ORE, "Valkyrum Ore");
        addBlock(AncientAetherBlocks.ATMOSINE_CRYSTAL, "Atmosine Crystal");

        addBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES, "Crystal Skyroot Leaves");
        addBlock(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES, "Enchanted Skyroot Leaves");
        addBlock(AncientAetherBlocks.SKYROOT_PINE_LEAVES, "Skyroot Pine Leaves");
        addBlock(AncientAetherBlocks.HIGHSPROOT_LEAVES, "Highsproot Leaves");
        addBlock(AncientAetherBlocks.SAKURA_LEAVES, "Sakura Leaves");

        addBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING, "Crystal Skyroot Sapling");
        addBlock(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING, "Enchanted Skyroot Sapling");
        addBlock(AncientAetherBlocks.SKYROOT_PINE_SAPLING, "Skyroot Pine Sapling");
        addBlock(AncientAetherBlocks.HIGHSPROOT_SAPLING, "Highsproot Sapling");
        addBlock(AncientAetherBlocks.SAKURA_SAPLING, "Sakura Sapling");

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

        addBlock(AncientAetherBlocks.SKY_GRASS, "Sky Grass");
        addBlock(AncientAetherBlocks.HIGHLAND_VIOLA, "Highland Viola");
        addBlock(AncientAetherBlocks.SKY_BLUES, "Sky Blues");
        addBlock(AncientAetherBlocks.WYND_THISTLE, "Wynd Thistle");
        addBlock(AncientAetherBlocks.SAKURA_BLOSSOMS, "Sakura Blossoms");
        addBlock(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS, "Trapped Sakura Blossoms");
        addBlock(AncientAetherBlocks.GRAPE_VINE, "Grape Vine");

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

        addBlock(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC, "Holystone Brick Mosaic");
        addBlock(AncientAetherBlocks.CARVED_STONE_MOSAIC, "Carved Stone Mosaic");
        addBlock(AncientAetherBlocks.ANGELIC_STONE_MOSAIC, "Angelic Stone Mosaic");
        addBlock(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC, "Hellfire Stone Mosaic");
        addBlock(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC, "Aerogetic Stone Mosaic");
        addBlock(AncientAetherBlocks.GALE_STONE_MOSAIC, "Gale Stone Mosaic");

        addBlock(AncientAetherBlocks.CARVED_TILES, "Carved Tiles");
        addBlock(AncientAetherBlocks.WYND_SENTRY_STONE, "Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.CARVED_TILE_STAIRS, "Carved Tile Stairs");
        addBlock(AncientAetherBlocks.CARVED_TILE_SLAB, "Carved Tile Slab");
        addBlock(AncientAetherBlocks.CARVED_TILE_WALL, "Carved Tile Wall");

        addBlock(AncientAetherBlocks.AEROGETIC_STONE, "Aerogetic Stone");
        addBlock(AncientAetherBlocks.LIGHT_AEROGETIC_STONE, "Light Aerogetic Stone");
        addBlock(AncientAetherBlocks.CORRUPTED_AEROGETIC_STONE, "Corrupted Aerogetic Stone");
        addBlock(AncientAetherBlocks.AEROGETIC_STAIRS, "Aerogetic Stairs");
        addBlock(AncientAetherBlocks.AEROGETIC_SLAB, "Aerogetic Slab");
        addBlock(AncientAetherBlocks.AEROGETIC_WALL, "Aerogetic Wall");

        addBlock(AncientAetherBlocks.LOCKED_CARVED_TILES, "Locked Carved Tiles");
        addBlock(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE, "Locked Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE, "Locked Aerogetic Stone");
        addBlock(AncientAetherBlocks.LOCKED_LIGHT_AEROGETIC_STONE, "Locked Light Aerogetic Stone");
        addBlock(AncientAetherBlocks.LOCKED_CORRUPTED_AEROGETIC_STONE, "Locked Corrupted Aerogetic Stone");

        addBlock(AncientAetherBlocks.TRAPPED_CARVED_TILES, "Trapped Carved Tiles");
        addBlock(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE, "Trapped Aerogetic Stone");
        addBlock(AncientAetherBlocks.TRAPPED_LIGHT_AEROGETIC_STONE, "Trapped Light Aerogetic Stone");
        addBlock(AncientAetherBlocks.TRAPPED_CORRUPTED_AEROGETIC_STONE, "Trapped Corrupted Aerogetic Stone");

        addBlock(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE, "Boss Doorway Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE, "Boss Doorway Aerogetic Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_LIGHT_AEROGETIC_STONE, "Boss Doorway Light Aerogetic Stone");
        addBlock(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AEROGETIC_STONE, "Boss Doorway Corrupted Aerogetic Stone");

        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE, "Treasure Doorway Wynd Sentry Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE, "Treasure Doorway Aerogetic Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_LIGHT_AEROGETIC_STONE, "Treasure Doorway Light Aerogetic Stone");
        addBlock(AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AEROGETIC_STONE, "Treasure Doorway Corrupted Aerogetic Stone");

        addBlock(AncientAetherBlocks.AMBROSIUM_LANTERN, "Ambrosium Lantern");
        addBlock(AncientAetherBlocks.WYND_LANTERN, "Wynd Lantern");
        addBlock(AncientAetherBlocks.SUN_LANTERN, "Sun Lantern");
        addBlock(AncientAetherBlocks.AMBROSIUM_CAMPFIRE, "Ambrosium Campfire");

        addBlock(AncientAetherBlocks.VIOLET_AERCLOUD, "Violet Aercloud");
        addBlock(AncientAetherBlocks.WIND_BLOWER, "Wind Blower");
        addBlock(AncientAetherBlocks.SLIDER_PROTOTYPE, "Slider Prototype");
        addBlock(AncientAetherBlocks.ANCIENT_OBELISK, "Ancient Obelisk");
        addBlock(AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK, "Unpowered Ancient Obelisk");

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
        addBlock(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING, "Potted Highsproot Sapling");
        addBlock(AncientAetherBlocks.POTTED_SAKURA_SAPLING, "Potted Sakura Sapling");
        addBlock(AncientAetherBlocks.POTTED_HIGHLAND_VIOLA, "Potted Highland Viola");
        addBlock(AncientAetherBlocks.POTTED_SKY_BLUES, "Potted Sky Blues");
        addBlock(AncientAetherBlocks.POTTED_WYND_THISTLE, "Potted Wynd Thistle");
        addBlock(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS, "Potted Sakura Blossoms");

        addItem(AncientAetherItems.VALKYRUM, "Valkyrum");
        addItem(AncientAetherItems.GRAPES, "Grapes");
        addItem(AncientAetherItems.FESTIVE_GUMMY_SWET, "Festive Gummy Swet");

        addItem(AncientAetherItems.VALKYRUM_SWORD, "Valkyrum Sword");
        addItem(AncientAetherItems.VALKYRUM_LANCE, "Valkyrum Lance");
        addItem(AncientAetherItems.VALKYRUM_SHOVEL, "Valkyrum Shovel");
        addItem(AncientAetherItems.VALKYRUM_PICKAXE, "Valkyrum Pickaxe");
        addItem(AncientAetherItems.VALKYRUM_AXE, "Valkyrum Axe");
        addItem(AncientAetherItems.VALKYRUM_HOE, "Valkyrum Hoe");

        addItem(AncientAetherItems.VALKYRUM_HELMET, "Valkyrum Hoe");
        addItem(AncientAetherItems.VALKYRUM_CHESTPLATE, "Valkyrum Chestplate");
        addItem(AncientAetherItems.VALKYRUM_LEGGINGS, "Valkyrum Leggings");
        addItem(AncientAetherItems.VALKYRUM_BOOTS, "Valkyrum Boots");
        addItem(AncientAetherItems.VALKYRUM_GLOVES, "Valkyrum Gloves");

        addItem(AncientAetherItems.ANCIENT_SWORD, "Ancient Sword");
        addItem(AncientAetherItems.ARKENZUS_PICKAXE, "Pickaxe of Arkenzus");
        addItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER, "Aeronautic Dart Shooter");

        addItem(AncientAetherItems.VALKYRUM_RING, "Valkyrum Ring");
        addItem(AncientAetherItems.HERMES_RING, "Hermes Ring");
        addItem(AncientAetherItems.ARKENIUM_RING, "Arkenium Ring");
        addItem(AncientAetherItems.HEALTH_RING, "Health Ring");
        addItem(AncientAetherItems.ANCIENT_RING, "Ancient Ring");

        addItem(AncientAetherItems.VALKYRUM_PENDANT, "Valkyrum Pendant");
        addItem(AncientAetherItems.HERMES_PENDANT, "Hermes Pendant");
        addItem(AncientAetherItems.ARKENIUM_PENDANT, "Arkenium Pendant");
        addItem(AncientAetherItems.HEALTH_PENDANT, "Health Pendant");
        addItem(AncientAetherItems.ANCIENT_PENDANT, "Ancient Pendant");

        addItem(AncientAetherItems.STRENGTH_STONE, "Strength Stone");
        addItem(AncientAetherItems.PINK_CAPE, "Pink Cape");
        addItem(AncientAetherItems.SHIELD_OF_INEBRIATION, "Shield of Inebriation");
        addItem(AncientAetherItems.SHIELD_OF_REMEDIATION, "Shield of Remediation");

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
        addItem(AncientAetherItems.ROOTHYRN_SPAWN_EGG, "Roothyrn Spawn Egg");
        addItem(AncientAetherItems.AERONAUTIC_LEAPER_SPAWN_EGG, "Aeronautic Leaper Spawn Egg");
        addItem(AncientAetherItems.MUTATED_AECHOR_PLANT_SPAWN_EGG, "Mutated Aechor Plant Spawn Egg");

        addEntityType(AncientAetherEntityTypes.FLUFFALO, "Fluffalo");
        addEntityType(AncientAetherEntityTypes.FESTIVE_SWET, "Festive Swet");
        addEntityType(AncientAetherEntityTypes.ROOTHYRN, "Roothyrn");
        addEntityType(AncientAetherEntityTypes.AERONAUTIC_LEAPER, "Aeronautic Leaper");
        addEntityType(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT, "Mutated Aechor Plant");

        addEntityType(AncientAetherEntityTypes.BOAT, "Boat");
        addEntityType(AncientAetherEntityTypes.CHEST_BOAT, "Chest Boat");
        addEntityType(AncientAetherEntityTypes.AERONAUTIC_DART, "Aeronautic Dart");
        addEntityType(AncientAetherEntityTypes.MUTATED_AECHOR_NEEDLE, "Mutated Aechor Needle");

        addBiome(AncientAetherBiomes.CRYSTAL_SKYROOT_GROVE, "Crystal Skyroot Grove");
        addBiome(AncientAetherBiomes.CRYSTAL_SKYROOT_FOREST, "Crystal Skyroot Forest");
        addBiome(AncientAetherBiomes.GOLDEN_SKYROOT_GROVE, "Golden Skyroot Grove");
        addBiome(AncientAetherBiomes.GOLDEN_SKYROOT_FOREST, "Golden Skyroot Forest");
        addBiome(AncientAetherBiomes.GOLDEN_THICKET, "Golden Thicket");
        addBiome(AncientAetherBiomes.WYNDCAP_TAIGA, "Wyndcaps Taiga");
        addBiome(AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA, "Festive Wyndcaps Taiga");
        addBiome(AncientAetherBiomes.WYNDCAP_HIGHLAND, "Wyndcaps Highland");
        addBiome(AncientAetherBiomes.WYNDCAP_PEAKS, "Wyndcaps Peaks");
        addBiome(AncientAetherBiomes.SKYROOT_JUNGLE, "Skyroot Jungle");
        addBiome(AncientAetherBiomes.SAKURA_JUNGLE, "Sakura Jungle");
        addBiome(AncientAetherBiomes.ELEVATED_CLEARING, "Elevated Clearing");
        addBiome(AncientAetherBiomes.ELEVATED_FOREST, "Elevated Forest");
        addBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS, "Holystone Caverns");
        addBiome(AncientAetherBiomes.FROZEN_CAVERNS, "Frozen Caverns");
        addBiome(AncientAetherBiomes.ELEVATED_CAVERNS, "Elevated Caverns");
        addBiome(AncientAetherBiomes.ATMOSINE_GROTTO, "Atmosine Grotto");

        addAdvancement("aether_biomes", "Aerospace Traveller");
        addAdvancement("moa_eggs", "Rainbow Omelette");
        addAdvancement("arkenzus_pickaxe", "The Pickaxe of Gods");
        addAdvancement("valkyrum", "What Clouds are made of");
        addAdvancement("valkyrum_lance", "Lancin' and Dancin'");
        addAdvancement("vampire_blade", "Bloodlust");
        addAdvancement("find_sentry_laboratory", "A White Apple a day, keeps the Cockatrice away");
        addAdvancement("slider_prototype", "Out of Order");
        addAdvancement("laboratory_dungeon", "Peace, Love and Houseplants");
        addAdvancement("shield_accessories", "Yin and Yang");
        addAdvancement("unlock_ancient_dungeon", "Ancient Forces");
        addAdvancement("ancient_dungeon", "Shut-Down");

        addAdvancementDesc("aether_biomes", "Find all Aether biomes" + mark);
        addAdvancementDesc("moa_eggs", "Collect all the different Moa Eggs" + mark);
        addAdvancementDesc("arkenzus_pickaxe", "Obtain the Pickaxe of Arkenzus from defeating the Valkyrie Queen. It can be used to mine Valkyrum Ore" + mark);
        addAdvancementDesc("valkyrum", "Enchant some Valkyrum Ore in an Altar" + mark);
        addAdvancementDesc("valkyrum_lance", "Craft yourself a Valkyrum Lance" + mark);
        addAdvancementDesc("vampire_blade", "Obtain the Vampire Blade from defeating the Sun Spirit" + mark);
        addAdvancementDesc("find_sentry_laboratory", "Find the Sentry Laboratory located in the Wyndcaps" + mark);
        addAdvancementDesc("slider_prototype", "Mine a Slider Prototype with a Gravitite Pickaxe" + mark);
        addAdvancementDesc("laboratory_dungeon", "Defeat the Mutated Aechor Plant" + mark);
        addAdvancementDesc("shield_accessories", "Obtain the Shields of Inebriation and Remediation" + mark);
        addAdvancementDesc("unlock_ancient_dungeon", "Enter the Ancient Dungeon by activating its Obelisk using an Ancient Rune" + mark);
        addAdvancementDesc("ancient_dungeon", "Defeat the Ancient Guardian" + mark);

        addAdvancementDesc("sakura_moa", "Find all Aether biomes" + markModified);
        addAdvancementDesc("valkyrum_armor", "Ride a Sakura Moa" + markModified);

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

        addMenuText("laboratory_treasure_chest", "Laboratory Treasure Chest");
        addMenuText("ancient_treasure_chest", "Ancient Treasure Chest");

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

        add("item.minecraft.quartz", "Quartz");
    }
}