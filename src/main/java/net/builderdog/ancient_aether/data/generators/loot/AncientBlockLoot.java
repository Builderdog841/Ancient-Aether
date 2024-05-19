package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.mixin.mixins.common.accessor.BlockLootAccessor;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.providers.AncientBlockLootSubProvider;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AncientBlockLoot extends AncientBlockLootSubProvider {
    public AncientBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(AncientBlocks.VALKYRUM_ORE.get());
        dropSelf(AncientBlocks.ATMOSINE_CRYSTAL.get());
        dropSelf(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get());
        dropSelf(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get());
        dropSelf(AncientBlocks.SKYROOT_PINE_SAPLING.get());
        dropSelf(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.get());
        dropSelf(AncientBlocks.HIGHSPROOT_SAPLING.get());
        dropSelf(AncientBlocks.SAKURA_SAPLING.get());
        dropSelf(AncientBlocks.SUNSET_ROSE.get());
        dropSelf(AncientBlocks.SKY_BLUES.get());
        dropSelf(AncientBlocks.WYND_THISTLE.get());
        dropSelf(AncientBlocks.ELEVETIA.get());
        dropSelf(AncientBlocks.HIGHSPROOT_WOOD.get());
        dropSelf(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        dropSelf(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get());
        dropSelf(AncientBlocks.SAKURA_WOOD.get());
        dropSelf(AncientBlocks.STRIPPED_SAKURA_LOG.get());
        dropSelf(AncientBlocks.STRIPPED_SAKURA_WOOD.get());
        dropSelf(AncientBlocks.HIGHSPROOT_LOG_WALL.get());
        dropSelf(AncientBlocks.HIGHSPROOT_WOOD_WALL.get());
        dropSelf(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get());
        dropSelf(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get());
        dropSelf(AncientBlocks.SAKURA_LOG_WALL.get());
        dropSelf(AncientBlocks.SAKURA_WOOD_WALL.get());
        dropSelf(AncientBlocks.STRIPPED_SAKURA_LOG_WALL.get());
        dropSelf(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
        dropSelf(AncientBlocks.HIGHSPROOT_PLANKS.get());
        dropSelf(AncientBlocks.HIGHSPROOT_SAPLING.get());
        dropSelf(AncientBlocks.HIGHSPROOT_STAIRS.get());
        dropSelf(AncientBlocks.HIGHSPROOT_FENCE.get());
        dropSelf(AncientBlocks.HIGHSPROOT_FENCE_GATE.get());
        dropSelf(AncientBlocks.HIGHSPROOT_TRAPDOOR.get());
        dropSelf(AncientBlocks.HIGHSPROOT_BUTTON.get());
        dropSelf(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        dropSelf(AncientBlocks.HIGHSPROOT_SIGN.get());
        dropSelf(AncientBlocks.HIGHSPROOT_WALL_SIGN.get());
        dropSelf(AncientBlocks.HIGHSPROOT_HANGING_SIGN.get());
        dropSelf(AncientBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get());
        dropSelf(AncientBlocks.SAKURA_PLANKS.get());
        dropSelf(AncientBlocks.SAKURA_STAIRS.get());
        dropSelf(AncientBlocks.SAKURA_FENCE.get());
        dropSelf(AncientBlocks.SAKURA_FENCE_GATE.get());
        dropSelf(AncientBlocks.SAKURA_TRAPDOOR.get());
        dropSelf(AncientBlocks.SAKURA_BUTTON.get());
        dropSelf(AncientBlocks.SAKURA_PRESSURE_PLATE.get());
        dropSelf(AncientBlocks.SAKURA_SIGN.get());
        dropSelf(AncientBlocks.SAKURA_WALL_SIGN.get());
        dropSelf(AncientBlocks.SAKURA_HANGING_SIGN.get());
        dropSelf(AncientBlocks.SAKURA_WALL_HANGING_SIGN.get());
        dropSelf(AncientBlocks.VALKYRUM_BLOCK.get());
        dropSelf(AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get());
        dropSelf(AncientBlocks.AEROGEL_GLASS.get());
        dropSelf(AncientBlocks.AEROGEL_GLASS_PANE.get());
        dropSelf(AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get());
        dropSelf(AncientBlocks.FLUFFALO_WOOL.get());
        dropSelf(AncientBlocks.FLUFFALO_CARPET.get());
        dropSelf(AncientBlocks.CARVED_TILES.get());
        dropSelf(AncientBlocks.WYND_SENTRY_STONE.get());
        dropSelf(AncientBlocks.CARVED_TILE_STAIRS.get());
        dropSelf(AncientBlocks.CARVED_TILE_SLAB.get());
        dropSelf(AncientBlocks.CARVED_TILE_WALL.get());
        dropSelf(AncientBlocks.ANGELIC_CORNER_BRICK.get());
        dropSelf(AncientBlocks.VALKYRIE_BRICKS.get());
        dropSelf(AncientBlocks.VALKYRIE_BRICK_STAIRS.get());
        dropSelf(AncientBlocks.VALKYRIE_BRICK_SLAB.get());
        dropSelf(AncientBlocks.VALKYRIE_BRICK_WALL.get());
        dropSelf(AncientBlocks.VALKYRIE_TILES.get());
        dropSelf(AncientBlocks.VALKYRIE_TILE_STAIRS.get());
        dropSelf(AncientBlocks.VALKYRIE_TILE_SLAB.get());
        dropSelf(AncientBlocks.VALKYRIE_TILE_WALL.get());
        dropSelf(AncientBlocks.AEROGETIC_STONE.get());
        dropSelf(AncientBlocks.AEROGETIC_STAIRS.get());
        dropSelf(AncientBlocks.AEROGETIC_WALL.get());
        dropSelf(AncientBlocks.AEROGETIC_STONE_MOSAIC.get());
        dropSelf(AncientBlocks.AERONAUTIC_STONE.get());
        dropSelf(AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        dropSelf(AncientBlocks.CARVED_STONE_MOSAIC.get());
        dropSelf(AncientBlocks.ANGELIC_STONE_MOSAIC.get());
        dropSelf(AncientBlocks.HELLFIRE_STONE_MOSAIC.get());
        dropSelf(AncientBlocks.GALE_STONE_MOSAIC.get());
        dropSelf(AncientBlocks.POWERED_OBELISK.get());
        dropSelf(AncientBlocks.AMBROSIUM_LANTERN.get());
        dropSelf(AncientBlocks.WYND_LANTERN.get());
        dropSelf(AncientBlocks.SUN_LANTERN.get());
        dropSelf(AncientBlocks.WIND_BLOWER.get());
        dropSelf(AncientBlocks.SLIDER_PROTOTYPE.get());
        dropSelf(AncientBlocks.HOLYSTONE_VASE.get());
        dropSelf(AncientBlocks.MOSSY_HOLYSTONE_VASE.get());
        dropSelf(AncientBlocks.FROZEN_HOLYSTONE_VASE.get());
        dropSelf(AncientBlocks.SENTRY_VASE.get());
        dropSelf(AncientBlocks.ANGELIC_VASE.get());
        dropSelf(AncientBlocks.HELLFIRE_VASE.get());
        dropSelf(AncientBlocks.AEROGETIC_VASE.get());
        dropSelf(AncientBlocks.GALE_VASE.get());

        dropSelfDouble(AncientBlocks.GRAVITY_GRAVEL.get());
        dropSelfDouble(AncientBlocks.HIGHSPROOT_LOG.get());
        dropSelfDouble(AncientBlocks.SAKURA_LOG.get());
        dropSelfDouble(AncientBlocks.VIOLET_AERCLOUD.get());

        dropDoubleWithFortune(AncientBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ);
        dropWhenSilkTouch(AncientBlocks.WYND_ICE.get());
        dropWhenSilkTouch(AncientBlocks.SKY_GRASS.get());

        dropClay(AncientBlocks.VALKYRIE_CLAY.get(), AncientItems.VALKYRIE_CLAY_BALL.get());
        dropCampfire(AncientBlocks.AMBROSIUM_CAMPFIRE.get(), AetherItems.AMBROSIUM_SHARD.get());

        dropPottedContents(AncientBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_SKYROOT_PINE_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_SAKURA_SAPLING.get());
        dropPottedContents(AncientBlocks.POTTED_SKY_BLUES.get());
        dropPottedContents(AncientBlocks.POTTED_WYND_THISTLE.get());
        dropPottedContents(AncientBlocks.POTTED_SUNSET_ROSE.get());
        dropPottedContents(AncientBlocks.POTTED_ELEVETIA.get());

        add(AncientBlocks.HIGHSPROOT_SLAB.get(), this::createSlabItemTable);
        add(AncientBlocks.SAKURA_SLAB.get(), this::createSlabItemTable);
        add(AncientBlocks.AEROGETIC_SLAB.get(), this::createSlabItemTable);
        add(AncientBlocks.HIGHSPROOT_DOOR.get(), createDoorTable(AncientBlocks.HIGHSPROOT_DOOR.get()));
        add(AncientBlocks.SAKURA_DOOR.get(), createDoorTable(AncientBlocks.SAKURA_DOOR.get()));
        add(AncientBlocks.AEROGEL_GLASS_DOOR.get(), createDoorTable(AncientBlocks.AEROGEL_GLASS_DOOR.get()));

        add(AncientBlocks.CRYSTAL_SKYROOT_LEAVES.get(), (leaves) -> droppingCrystalSkyrootLeaves(leaves, AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientBlocks.ENCHANTED_SKYROOT_LEAVES.get(), (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientBlocks.SKYROOT_PINE_LEAVES.get(), (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientBlocks.SKYROOT_PINE_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientBlocks.BLUE_SKYROOT_PINE_LEAVES.get(), (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientBlocks.HIGHSPROOT_LEAVES.get(), (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientBlocks.HIGHSPROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientBlocks.SAKURA_LEAVES.get(), (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientBlocks.SAKURA_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));

        add(AncientBlocks.HIGHSPROOT_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
        add(AncientBlocks.SAKURA_BOOKSHELF.get(), (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return AncientBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }
}