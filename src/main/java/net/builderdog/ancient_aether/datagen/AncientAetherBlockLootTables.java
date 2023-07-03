package net.builderdog.ancient_aether.datagen;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class AncientAetherBlockLootTables extends BlockLootSubProvider {
    public AncientAetherBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf((AncientAetherBlocks.ENCHANTED_SENTRY_STONE.get()));
        dropSelf((AncientAetherBlocks.BLIGHTED_SENTRY_STONE.get()));
        dropSelf((AncientAetherBlocks.QUICKSOIL_BRICKS.get()));
        dropSelf((AncientAetherBlocks.QUICKSTONE.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_LOG.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_WOOD.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_LOG_WALL.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_WOOD_WALL.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG_WALL.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD_WALL.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_SAPLING.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_STAIRS.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_SLAB.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_FENCE.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_FENCE_GATE.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_BUTTON.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_PRESSURE_PLATE.get()));
        dropSelf((AncientAetherBlocks.HIGHLANDS_PINE_SIGN.get()));
        dropSelf((AncientAetherBlocks.SAKURA_LOG.get()));
        dropSelf((AncientAetherBlocks.SAKURA_WOOD.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get()));
        dropSelf((AncientAetherBlocks.SAKURA_LOG_WALL.get()));
        dropSelf((AncientAetherBlocks.SAKURA_WOOD_WALL.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get()));
        dropSelf((AncientAetherBlocks.SAKURA_PLANKS.get()));
        dropSelf((AncientAetherBlocks.SAKURA_SAPLING.get()));
        dropSelf((AncientAetherBlocks.SAKURA_STAIRS.get()));
        dropSelf((AncientAetherBlocks.SAKURA_SLAB.get()));
        dropSelf((AncientAetherBlocks.SAKURA_FENCE.get()));
        dropSelf((AncientAetherBlocks.SAKURA_FENCE_GATE.get()));
        dropSelf((AncientAetherBlocks.SAKURA_DOOR.get()));
        dropSelf((AncientAetherBlocks.SAKURA_TRAPDOOR.get()));
        dropSelf((AncientAetherBlocks.SAKURA_BUTTON.get()));
        dropSelf((AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get()));
        dropSelf((AncientAetherBlocks.SAKURA_SIGN.get()));
        dropSelf((AncientAetherBlocks.AETHER_CACTUS.get()));
        dropSelf((AncientAetherBlocks.STRIPPED_AETHER_CACTUS.get()));
        dropSelf((AncientAetherBlocks.CACTUS_FLOWER.get()));
        dropSelf((AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get()));
        dropSelf((AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get()));
        dropSelf((AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get()));
        dropSelf((AncientAetherBlocks.MOONLIT_TULIP.get()));
        dropSelf((AncientAetherBlocks.EDELWEISS.get()));
        dropSelf((AncientAetherBlocks.SMALL_AETHER_CACTUS.get()));
        dropSelf((AncientAetherBlocks.CRACKED_SLIDER.get()));
        dropSelf((AncientAetherBlocks.POTTED_MOONLIT_TULIP.get()));
        dropSelf((AncientAetherBlocks.POTTED_EDELWEISS.get()));
        dropSelf((AncientAetherBlocks.POTTED_HIGHLANDS_PINE_SAPLING.get()));
        dropSelf((AncientAetherBlocks.POTTED_SMALL_AETHER_CACTUS.get()));
        dropSelf((AncientAetherBlocks.POTTED_SAKURA_SAPLING.get()));
        dropSelf((AncientAetherBlocks.HOLYSTONE_LANTERN.get()));
        dropSelf((AncientAetherBlocks.SENTRY_LANTERN.get()));
        dropSelf((AncientAetherBlocks.ANGELIC_LANTERN.get()));
        dropSelf((AncientAetherBlocks.HELLFIRE_LANTERN.get()));

        add(AncientAetherBlocks.AETHER_QUARTZ_ORE.get(),
                (block) -> createOreDrop(AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ));

        add(AncientAetherBlocks.HIGHLANDS_PINE_LEAVES.get(),
                (block) -> createLeavesDrops(block, AncientAetherBlocks.HIGHLANDS_PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(AncientAetherBlocks.SAKURA_LEAVES.get(),
                (block) -> createLeavesDrops(block, AncientAetherBlocks.SAKURA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AncientAetherBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}