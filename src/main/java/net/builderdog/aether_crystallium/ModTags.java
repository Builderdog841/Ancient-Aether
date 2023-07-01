package net.builderdog.aether_crystallium;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CRYSTALLIUM_LOG_WALLS = tag("crystallium_log_walls");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AetherCrystallium.MOD_ID, name));
        }
    }
}