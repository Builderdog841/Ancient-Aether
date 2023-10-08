package net.builderdog.ancient_aether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AncientAetherTags {

    public static class Blocks {
        public static final TagKey<Block> WYNDCAPS_ANIMAL_SPAWNABLE_ON = tag();

        private static TagKey<Block> tag() {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AncientAether.MOD_ID, "wyndcaps_animals_spawnable_on"));
        }
    }
    public static class Items {
        public static final TagKey<Item> CRAFTS_HIGHSPROOT_PLANKS = tag("crafts_highsproot_planks");
        public static final TagKey<Item> CRAFTS_SAKURA_PLANKS = tag("crafts_sakura_planks");
        public static final TagKey<Item> HIGHLAND_BUFFALO_TEMPTATION_ITEMS = tag("highland_buffalo_temptation_items");
        public static final TagKey<Item> ANCIENT_DUNGEON_LOOT = tag("ancient_dungeon_loot");
        public static final TagKey<Item> DEPRECATED = tag("deprecated");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }
}