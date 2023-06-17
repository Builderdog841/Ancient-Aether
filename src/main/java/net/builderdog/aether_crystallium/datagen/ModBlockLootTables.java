package net.builderdog.aether_crystallium.datagen;

import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf((ModBlocks.CRYSTAL_GOLD_BLOCK.get()));
        dropSelf((ModBlocks.RAW_CRYSTAL_GOLD_BLOCK.get()));
        dropSelf((ModBlocks.ENCHANTED_SENTRY_STONE.get()));
        dropSelf((ModBlocks.BLIGHTED_SENTRY_STONE.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICKS.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_LOG.get()));
        dropSelf((ModBlocks.HIGHLANDS_PINE_WOOD.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get()));
        dropSelf((ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get()));
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
        dropSelf((ModBlocks.AETHER_CACTUS.get()));
        dropSelf((ModBlocks.PURPLE_AETHER_CACTUS_FLOWER.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_STAIRS.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_SLAB.get()));
        dropSelf((ModBlocks.QUICKSOIL_BRICK_WALL.get()));
        dropSelf((ModBlocks.MOONLIT_TULIP.get()));
        dropSelf((ModBlocks.SMALL_AETHER_CACTUS.get()));

        add(ModBlocks.CRYSTAL_GOLD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.CRYSTAL_GOLD_ORE.get(), ModItems.RAW_CRYSTAL_GOLD.get()));

        add(ModBlocks.HIGHLANDS_PINE_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.HIGHLANDS_PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
