package net.builderdog.aether_crystallium.datagen;

import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf((ModBlocks.ENCHANTED_SENTRY_STONE.get()));
        dropSelf((ModBlocks.BLIGHTED_SENTRY_STONE.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICKS.get()));
        dropSelf((ModBlocks.QUICKSTONE.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_LOG.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_WOOD.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_LOG_WALL.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_WOOD_WALL.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG_WALL.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD_WALL.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_PLANKS.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_SAPLING.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_STAIRS.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_SLAB.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_FENCE.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_FENCE_GATE.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_DOOR.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_TRAPDOOR.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_BUTTON.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_PRESSURE_PLATE.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_SIGN.get()));
        dropSelf((ModBlocks.SAKURA_LOG.get()));
        dropSelf((ModBlocks.SAKURA_WOOD.get()));
        dropSelf((ModBlocks.STRIPPED_SAKURA_LOG.get()));
        dropSelf((ModBlocks.STRIPPED_SAKURA_WOOD.get()));
        dropSelf((ModBlocks.SAKURA_LOG_WALL.get()));
        dropSelf((ModBlocks.SAKURA_WOOD_WALL.get()));
        dropSelf((ModBlocks.STRIPPED_SAKURA_LOG_WALL.get()));
        dropSelf((ModBlocks.STRIPPED_SAKURA_WOOD_WALL.get()));
        dropSelf((ModBlocks.SAKURA_PLANKS.get()));
        dropSelf((ModBlocks.SAKURA_SAPLING.get()));
        dropSelf((ModBlocks.SAKURA_STAIRS.get()));
        dropSelf((ModBlocks.SAKURA_SLAB.get()));
        dropSelf((ModBlocks.SAKURA_FENCE.get()));
        dropSelf((ModBlocks.SAKURA_FENCE_GATE.get()));
        dropSelf((ModBlocks.SAKURA_DOOR.get()));
        dropSelf((ModBlocks.SAKURA_TRAPDOOR.get()));
        dropSelf((ModBlocks.SAKURA_BUTTON.get()));
        dropSelf((ModBlocks.SAKURA_PRESSURE_PLATE.get()));
        dropSelf((ModBlocks.SAKURA_SIGN.get()));
        dropSelf((ModBlocks.AETHER_CACTUS.get()));
        dropSelf((ModBlocks.STRIPPED_AETHER_CACTUS.get()));
        dropSelf((ModBlocks.CACTUS_FLOWER.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_STAIRS.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_SLAB.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_WALL.get()));
        dropSelf((ModBlocks.MOONLIT_TULIP.get()));
        dropSelf((ModBlocks.EDELWEISS.get()));
        dropSelf((ModBlocks.SMALL_AETHER_CACTUS.get()));
        dropSelf((ModBlocks.CRACKED_SLIDER.get()));
        dropSelf((ModBlocks.POTTED_MOONLIT_TULIP.get()));
        dropSelf((ModBlocks.POTTED_EDELWEISS.get()));
        dropSelf((ModBlocks.POTTED_HIGHLANDS_PINE_SAPLING.get()));
        dropSelf((ModBlocks.POTTED_SMALL_AETHER_CACTUS.get()));
        dropSelf((ModBlocks.POTTED_SAKURA_SAPLING.get()));
        dropSelf((ModBlocks.HOLYSTONE_LANTERN.get()));
        dropSelf((ModBlocks.SENTRY_LANTERN.get()));
        dropSelf((ModBlocks.ANGELIC_LANTERN.get()));
        dropSelf((ModBlocks.HELLFIRE_LANTERN.get()));

        add(ModBlocks.AETHER_QUARTZ_ORE.get(),
                (block) -> createOreDrop(ModBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ));

        add(ModBlocks.HIGHLANDS_PINE_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.HIGHLANDS_PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.SAKURA_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.SAKURA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}