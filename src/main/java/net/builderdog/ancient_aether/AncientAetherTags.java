package net.builderdog.ancient_aether;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class AncientAetherTags {
    public static class Blocks {
        public static final TagKey<Block> ANCIENT_AETHER_LOG_WALLS = tag("ancient_aether_log_walls");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AncientAether.MOD_ID, name));
        }
    }
}