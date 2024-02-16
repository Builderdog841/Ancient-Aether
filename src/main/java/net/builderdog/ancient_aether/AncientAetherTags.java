package net.builderdog.ancient_aether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class AncientAetherTags {

    public static class Blocks {
        public static final TagKey<Block> WYNDCAPS_ANIMAL_SPAWNABLE_ON = tag("wyndcaps_animals_spawnable_on");
        public static final TagKey<Block> AETHER_CARVER_REPLACEABLES = tag("aether_carver_replaceables");
        public static final TagKey<Block> COAST_REPLACEABLE = tag("coast_replaceable");
        public static final TagKey<Block> LEAF_VINE_CAN_SPAWN_ON = tag("leaf_vine_can_spawn_on");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> WINDBLOWER_INGREDIENT = tag("windblower_ingredient");
        public static final TagKey<Item> CRAFTS_HIGHSPROOT_PLANKS = tag("crafts_highsproot_planks");
        public static final TagKey<Item> CRAFTS_SAKURA_PLANKS = tag("crafts_sakura_planks");
        public static final TagKey<Item> FLUFFALO_TEMPTATION_ITEMS = tag("fluffalo_temptation_items");
        public static final TagKey<Item> COMMON_LOOT = tag("common_loot");
        public static final TagKey<Item> RARE_LOOT = tag("rare_loot");
        public static final TagKey<Item> EPIC_LOOT = tag("epic_loot");
        public static final TagKey<Item> LEGENDARY_LOOT = tag("legendary_loot");
        public static final TagKey<Item> VALKYRUM_REPAIRING = tag("valkyrum_repairing");
        public static final TagKey<Item> ANCIENT_REPAIRING = tag("ancient_repairing");
        public static final TagKey<Item> ARKZENUS_REPAIRING = tag("arkzenus_repairing");
        public static final TagKey<Item> COMPAT_ORANGE_MOA_EGG = tag("compat/orange_moa_egg");
        public static final TagKey<Item> COMPAT_BROWN_MOA_EGG = tag("compat/brown_moa_egg");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_AEROGEL_BLOBS = tag("has_aerogel_blobs");
        public static final TagKey<Biome> HAS_AETHER_QUARTZ_ORE = tag("has_aether_quartz_ore");
        public static final TagKey<Biome> HAS_VALKYRUM_ORE = tag("has_valkyrum_ore");
        public static final TagKey<Biome> HAS_QUICKSOIL_COASTS = tag("has_quicksoil_coasts");
        public static final TagKey<Biome> HAS_GRAVITY_GRAVEL_COASTS = tag("has_gravity_gravel_coasts");
        public static final TagKey<Biome> HAS_WYND_ICE_COASTS = tag("has_wynd_ice_coasts");
        public static final TagKey<Biome> HAS_AETHER_GRASS_PATCHES = tag("has_aether_grass_patches");
        public static final TagKey<Biome> HAS_VIOLET_AERCLOUD = tag("has_violet_aercloud");
        public static final TagKey<Biome> HAS_CLOUDBED = tag("has_cloudbed");
        public static final TagKey<Biome> HAS_WATER_LAKE_UNDERGROUND = tag("has_water_lake_underground");
        public static final TagKey<Biome> HAS_FROZEN_AETHER_GRASS = tag("has_frozen_aether_grass");
        public static final TagKey<Biome> HAS_PALE_AETHER_GRASS = tag("has_pale_aether_grass");
        public static final TagKey<Biome> HAS_ENCHANTED_AETHER_GRASS = tag("has_enchanted_aether_grass");
        public static final TagKey<Biome> HAS_AETHER_CAVES = tag("has_aether_caves");
        public static final TagKey<Biome> IS_SKYROOT_FOREST = tag("is_skyroot_forest");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }
}