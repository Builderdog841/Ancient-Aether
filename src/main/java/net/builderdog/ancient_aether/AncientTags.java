package net.builderdog.ancient_aether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class AncientTags {

    public static class Blocks {
        public static final TagKey<Block> HIGHSPROOT_LOGS = tag("highsproot_logs");
        public static final TagKey<Block> SAKURA_LOGS = tag("sakura_logs");
        public static final TagKey<Block> VALKYRIE_BLOCKS = tag("valkyrie_blocks");
        public static final TagKey<Block> MOSAIC_BLOCKS = tag("mosaic_blocks");
        public static final TagKey<Block> AEROGETIC_BLOCKS = tag("aerogetic_blocks");
        public static final TagKey<Block> VASES = tag("vases");
        public static final TagKey<Block> WYNDCAPS_ANIMAL_SPAWNABLE_ON = tag("wyndcaps_animals_spawnable_on");
        public static final TagKey<Block> SLAMMROOT_SPAWNABLE_BLACKLIST = tag("slammroot_spawnable_blacklist");
        public static final TagKey<Block> LEAF_VINE_CAN_SPAWN_ON = tag("leaf_vine_can_spawn_on");
        public static final TagKey<Block> AETHER_CARVER_REPLACEABLES = tag("aether_carver_replaceables");
        public static final TagKey<Block> REPLACEABLE_DUNGEON_BLOCKS = tag("replaceable_dungeon_blocks");
        public static final TagKey<Block> REPLACEABLE_BOSS_ROOM_BLOCKS = tag("replaceable_boss_room_blocks");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AncientAether.MODID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> HIGHSPROOT_LOGS = tag("highsproot_logs");
        public static final TagKey<Item> SAKURA_LOGS = tag("sakura_logs");
        public static final TagKey<Item> VALKYRIE_BLOCKS = tag("valkyrie_blocks");
        public static final TagKey<Item> MOSAIC_BLOCKS = tag("mosaic_blocks");
        public static final TagKey<Item> AEROGETIC_BLOCKS = tag("aerogetic_blocks");
        public static final TagKey<Item> VASES = tag("vases");
        public static final TagKey<Item> WINDBLOWER_INGREDIENTS = tag("windblower_ingredients");
        public static final TagKey<Item> VALKYRUM_REPAIRING = tag("valkyrum_repairing");
        public static final TagKey<Item> DIVINE_REPAIRING = tag("divine_repairing");
        public static final TagKey<Item> ANCIENT_REPAIRING = tag("ancient_repairing");
        public static final TagKey<Item> FLUFFALO_TEMPTATION_ITEMS = tag("fluffalo_temptation_items");
        public static final TagKey<Item> COMMON_LOOT = tag("common_loot");
        public static final TagKey<Item> RARE_LOOT = tag("rare_loot");
        public static final TagKey<Item> EPIC_LOOT = tag("epic_loot");
        public static final TagKey<Item> MYTHIC_LOOT = tag("mythic_loot");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(AncientAether.MODID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> ACTIVATES_WIND_BLOWER = tag();

        private static TagKey<EntityType<?>> tag() {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AncientAether.MODID, "activates_wind_blower"));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_SKYROOT_PLAINS = tag("is_skyroot_plains");
        public static final TagKey<Biome> IS_SKYROOT_FOREST = tag("is_skyroot_forest");
        public static final TagKey<Biome> IS_SKYROOT = tag("is_skyroot");
        public static final TagKey<Biome> IS_WYNDCAPS = tag("is_wyndcaps");
        public static final TagKey<Biome> IS_SAKURA = tag("is_sakura");
        public static final TagKey<Biome> IS_ELEVATED = tag("is_elevated");
        public static final TagKey<Biome> IS_AETHER_CAVE = tag("is_aether_cave");
        public static final TagKey<Biome> IS_ANCIENT_AETHER_BIOME = tag("is_ancient_aether_biome");
        public static final TagKey<Biome> HAS_QUICKSOIL_COASTS = tag("has_quicksoil_coasts");
        public static final TagKey<Biome> HAS_GRAVITY_GRAVEL_COASTS = tag("has_gravity_gravel_coasts");
        public static final TagKey<Biome> HAS_WYND_ICE_COASTS = tag("has_wynd_ice_coasts");
        public static final TagKey<Biome> HAS_CLOUDBED = tag("has_cloudbed");
        public static final TagKey<Biome> HAS_AETHER_QUARTZ_ORE = tag("has_aether_quartz_ore");
        public static final TagKey<Biome> HAS_VALKYRUM_ORE = tag("has_valkyrum_ore");
        public static final TagKey<Biome> HAS_AEROGEL_BLOBS = tag("has_aerogel_blobs");
        public static final TagKey<Biome> HAS_WATER_LAKE_UNDERGROUND = tag("has_water_lake_underground");
        public static final TagKey<Biome> HAS_SKYROOT_MEADOW_TREES = tag("has_skyroot_meadow_trees");
        public static final TagKey<Biome> HAS_SKYROOT_GROVE_TREES = tag("has_skyroot_grove_trees");
        public static final TagKey<Biome> HAS_SKYROOT_FOREST_TREES = tag("has_skyroot_forest_trees");
        public static final TagKey<Biome> HAS_SKYROOT_WOODLAND_TREES = tag("has_skyroot_woodland_trees");
        public static final TagKey<Biome> HAS_AETHER_GRASS_PATCHES = tag("has_aether_grass_patches");
        public static final TagKey<Biome> HAS_SKYROOT_MEADOW_VEGETATION = tag("has_skyroot_meadow_vegetation");
        public static final TagKey<Biome> HAS_SKYROOT_GROVE_VEGETATION = tag("has_skyroot_grove_vegetation");
        public static final TagKey<Biome> HAS_SKYROOT_FOREST_VEGETATION = tag("has_skyroot_forest_vegetation");
        public static final TagKey<Biome> HAS_SKYROOT_WOODLAND_VEGETATION = tag("has_skyroot_woodland_vegetation");
        public static final TagKey<Biome> HAS_VIOLET_AERCLOUDS = tag("has_violet_aerclouds");
        public static final TagKey<Biome> HAS_CRYSTAL_ISLANDS = tag("has_crystal_islands");
        public static final TagKey<Biome> HAS_WYNDCAPS_CRYSTAL_ISLANDS = tag("has_wyndcaps_crystal_islands");
        public static final TagKey<Biome> HAS_ELEVATED_CRYSTAL_ISLANDS = tag("has_elevated_crystal_islands");
        public static final TagKey<Biome> HAS_AETHER_CAVES = tag("has_aether_caves");
        public static final TagKey<Biome> HAS_FROZEN_AETHER_GRASS = tag("has_frozen_aether_grass");
        public static final TagKey<Biome> HAS_PALE_AETHER_GRASS = tag("has_pale_aether_grass");
        public static final TagKey<Biome> HAS_ENCHANTED_AETHER_GRASS = tag("has_enchanted_aether_grass");
        public static final TagKey<Biome> HAS_STRUCTURE_HOLYSTONE_RUIN = tag("has_structure/holystone_ruin");
        public static final TagKey<Biome> HAS_STRUCTURE_MYSTERIOUS_HENGE = tag("has_structure/mysterious_henge");
        public static final TagKey<Biome> HAS_STRUCTURE_SUN_WELL = tag("has_structure/sun_well");
        public static final TagKey<Biome> HAS_STRUCTURE_VALKYRIE_CAMP_SKYROOT = tag("has_structure/valkyrie_camp_skyroot");
        public static final TagKey<Biome> HAS_STRUCTURE_VALKYRIE_CAMP_WYNDCAPS = tag("has_structure/valkyrie_camp_wyndcaps");
        public static final TagKey<Biome> HAS_STRUCTURE_VALKYRIE_SETTLEMENT_SKYROOT = tag("has_structure/valkyrie_settlement_skyroot");
        public static final TagKey<Biome> HAS_STRUCTURE_SENTRY_LABORATORY = tag("has_structure/sentry_laboratory");
        public static final TagKey<Biome> HAS_STRUCTURE_ANCIENT_DUNGEON = tag("has_structure/ancient_dungeon");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MODID, name));
        }
    }

    public static class Structures {
        public static final TagKey<Structure> ANCIENT_RUINS = tag("ancient_ruins");
        public static final TagKey<Structure> BRONZE_DUNGEONS_AVOID = tag("bronze_dungeons_avoid");
        public static final TagKey<Structure> VALKYRIE_SETTLEMENTS = tag("valkyrie_settlements");

        private static TagKey<Structure> tag(String name) {
            return TagKey.create(Registries.STRUCTURE, new ResourceLocation(AncientAether.MODID, name));
        }
    }
}