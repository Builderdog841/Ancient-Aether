package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientAetherBlockTagData extends BlockTagsProvider {
    public AncientAetherBlockTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, AncientAether.MODID, helper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientAetherTags.Blocks.AEROGETIC_BLOCKS).add(
                AncientAetherBlocks.AEROGETIC_STONE.get(),
                AncientAetherBlocks.AEROGETIC_STAIRS.get(),
                AncientAetherBlocks.AEROGETIC_SLAB.get(),
                AncientAetherBlocks.AEROGETIC_WALL.get(),
                AncientAetherBlocks.AERONAUTIC_STONE.get(),
                AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(),
                AncientAetherBlocks.LOCKED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get(),
                AncientAetherBlocks.TRAPPED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(),
                AncientAetherBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(),
                AncientAetherBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(),
                AncientAetherBlocks.AEROGETIC_VASE.get(),
                AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get()
        );
        tag(AncientAetherTags.Blocks.VASES).add(
                AncientAetherBlocks.HOLYSTONE_VASE.get(),
                AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get(),
                AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get(),
                AncientAetherBlocks.SENTRY_VASE.get(),
                AncientAetherBlocks.ANGELIC_VASE.get(),
                AncientAetherBlocks.HELLFIRE_VASE.get(),
                AncientAetherBlocks.AEROGETIC_VASE.get(),
                AncientAetherBlocks.GALE_VASE.get(),
                AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(),
                AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(),
                AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(),
                AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(),
                AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get(),
                AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get(),
                AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get(),
                AncientAetherBlocks.ANCIENT_GALE_VASE.get()
        );
        tag(AncientAetherTags.Blocks.WYNDCAPS_ANIMAL_SPAWNABLE_ON).add(
                AetherBlocks.AETHER_GRASS_BLOCK.get(),
                Blocks.SNOW_BLOCK
        );
        tag(AncientAetherTags.Blocks.SLAMMROOT_SPAWNABLE_BLACKLIST).addTags(
                AncientAetherTags.Blocks.AEROGETIC_BLOCKS
        );
        tag(AncientAetherTags.Blocks.LEAF_VINE_CAN_SPAWN_ON).add(
                AetherBlocks.ICESTONE.get()
        ).addTags(
                AetherTags.Blocks.HOLYSTONE,
                AetherTags.Blocks.SENTRY_BLOCKS,
                Tags.Blocks.ORES
        );
        tag(AncientAetherTags.Blocks.AETHER_CARVER_REPLACEABLES).add(
                Blocks.SNOW_BLOCK,
                Blocks.POWDER_SNOW
        ).addTags(
                AetherTags.Blocks.AETHER_ISLAND_BLOCKS
        );
        tag(AncientAetherTags.Blocks.REPLACEABLE_DUNGEON_BLOCKS).add(
                Blocks.AIR,
                Blocks.WATER
        ).addTags(
                AncientAetherTags.Blocks.VASES,
                BlockTags.MINEABLE_WITH_SHOVEL,
                BlockTags.MINEABLE_WITH_PICKAXE,
                BlockTags.MINEABLE_WITH_AXE,
                BlockTags.MINEABLE_WITH_HOE
        );

        tag(AetherTags.Blocks.AETHER_PORTAL_BLACKLIST).add(
                AncientAetherBlocks.VIOLET_AERCLOUD.get(),
                AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get(),
                AetherBlocks.AETHER_DIRT.get(),
                AetherBlocks.ICESTONE.get(),
                AetherBlocks.AEROGEL.get(),
                AetherBlocks.SKYROOT_PLANKS.get(),
                AetherBlocks.SKYROOT_STAIRS.get(),
                AetherBlocks.SKYROOT_SLAB.get(),
                AetherBlocks.SKYROOT_FENCE.get(),
                AetherBlocks.SKYROOT_BOOKSHELF.get()
        ).addTags(
                AncientAetherTags.Blocks.AEROGETIC_BLOCKS,
                AetherTags.Blocks.HOLYSTONE,
                AetherTags.Blocks.SENTRY_BLOCKS,
                AetherTags.Blocks.ANGELIC_BLOCKS,
                AetherTags.Blocks.HELLFIRE_BLOCKS,
                Tags.Blocks.ORES
        );
        tag(AetherTags.Blocks.AETHER_ISLAND_BLOCKS).add(
                AncientAetherBlocks.GRAVITY_GRAVEL.get(),
                AncientAetherBlocks.WYND_ICE.get()
        );
        tag(AetherTags.Blocks.AERCLOUDS).add(
                AncientAetherBlocks.VIOLET_AERCLOUD.get()
        );
        tag(AetherTags.Blocks.DUNGEON_BLOCKS).add(
                AncientAetherBlocks.CARVED_TILES.get(),
                AncientAetherBlocks.WYND_SENTRY_STONE.get(),
                AncientAetherBlocks.AEROGETIC_STONE.get(),
                AncientAetherBlocks.AERONAUTIC_STONE.get(),
                AncientAetherBlocks.CORRUPTED_AERONAUTIC_STONE.get()
        );
    }
}