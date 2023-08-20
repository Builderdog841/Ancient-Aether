package net.builderdog.ancient_aether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AncientAetherTags {

    public static class Items {
        public static final TagKey<Item> CRAFTS_HIGHSPROOT_PLANKS = tag("crafts_highsproot_planks");
        public static final TagKey<Item> CRAFTS_SAKURA_PLANKS = tag("crafts_sakura_planks");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }
}