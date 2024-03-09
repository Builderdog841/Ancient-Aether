package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.data.providers.AetherBlockLootSubProvider;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.mixin.mixins.common.accessor.BlockLootAccessor;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AncientAetherBlockLoot extends AetherBlockLootSubProvider {
    public AncientAetherBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected void dropOtherTwice(Block block, ItemLike itemLike) {
        add(block, createSilkTouchDispatchTable(block, applyExplosionDecay(itemLike, LootItem.lootTableItem(itemLike).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))));
    }

    public LootTable.Builder droppingCrystalSkyrootLeaves(Block block, Block sapling, float... chances) {
        return droppingWithChancesAndSkyrootSticks(block, sapling, chances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(BlockLootAccessor.aether$hasShearsOrSilkTouch().invert())
                        .add(applyExplosionCondition(block,
                                LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.0055F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    @Override
    protected void generate() {
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WOOD.get());
        dropSelf(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
        dropSelf(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_BUTTON.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_PLANKS.get());
        dropSelf(AncientAetherBlocks.SAKURA_STAIRS.get());
        dropSelf(AncientAetherBlocks.SAKURA_FENCE.get());
        dropSelf(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        dropSelf(AncientAetherBlocks.SAKURA_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.SAKURA_BUTTON.get());
        dropSelf(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.SAKURA_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WALL_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get());
        dropSelf(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.SAKURA_SAPLING.get());
        dropSelf(AncientAetherBlocks.VALKYRUM_ORE.get());
        dropSelf(AncientAetherBlocks.VALKYRUM_BLOCK.get());
        dropSelf(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS_PANE.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.FLUFFALO_WOOL.get());
        dropSelf(AncientAetherBlocks.FLUFFALO_CARPET.get());
        dropSelf(AncientAetherBlocks.CARVED_TILES.get());
        dropSelf(AncientAetherBlocks.CARVED_TILE_STAIRS.get());
        dropSelf(AncientAetherBlocks.CARVED_TILE_SLAB.get());
        dropSelf(AncientAetherBlocks.CARVED_TILE_WALL.get());
        dropSelf(AncientAetherBlocks.WYND_SENTRY_STONE.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STAIRS.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_WALL.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.CORRUPTED_AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.GALE_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.ANCIENT_OBELISK.get());
        dropSelf(AncientAetherBlocks.AMBROSIUM_LANTERN.get());
        dropSelf(AncientAetherBlocks.WYND_LANTERN.get());
        dropSelf(AncientAetherBlocks.SUN_LANTERN.get());
        dropSelf(AncientAetherBlocks.WIND_BLOWER.get());
        dropSelf(AncientAetherBlocks.SLIDER_PROTOTYPE.get());
        dropSelf(AncientAetherBlocks.SKY_BLUES.get());
        dropSelf(AncientAetherBlocks.WYND_THISTLE.get());
        dropSelf(AncientAetherBlocks.HIGHLAND_VIOLA.get());
        dropSelf(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        dropSelf(AncientAetherBlocks.HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.SENTRY_VASE.get());
        dropSelf(AncientAetherBlocks.ANGELIC_VASE.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_VASE.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_VASE.get());
        dropSelf(AncientAetherBlocks.GALE_VASE.get());
        dropSelf(AncientAetherBlocks.ATMOSINE_CRYSTAL.get());

        dropSelfDouble(AncientAetherBlocks.HIGHSPROOT_LOG.get());
        dropSelfDouble(AncientAetherBlocks.SAKURA_LOG.get());
        dropSelfDouble(AncientAetherBlocks.GRAVITY_GRAVEL.get());
        dropSelfDouble(AncientAetherBlocks.VIOLET_AERCLOUD.get());

        dropOther(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        dropOtherTwice(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get(), AetherItems.AMBROSIUM_SHARD.get());

        dropDoubleWithFortune(AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ);
        dropWhenSilkTouch(AncientAetherBlocks.WYND_ICE.get());
        dropWhenSilkTouch(AncientAetherBlocks.SKY_GRASS.get());

        dropPottedContents(AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SKY_BLUES.get());
        dropPottedContents(AncientAetherBlocks.POTTED_WYND_THISTLE.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHLAND_VIOLA.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING.get());

        add(AncientAetherBlocks.HIGHSPROOT_SLAB.get(), this::createSlabItemTable);
        add(AncientAetherBlocks.SAKURA_SLAB.get(), this::createSlabItemTable);
        add(AncientAetherBlocks.AEROGETIC_SLAB.get(), this::createSlabItemTable);
        add(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), createDoorTable(AncientAetherBlocks.HIGHSPROOT_DOOR.get()));
        add(AncientAetherBlocks.SAKURA_DOOR.get(), createDoorTable(AncientAetherBlocks.SAKURA_DOOR.get()));
        add(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), createDoorTable(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()));

        add(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get(),
                (leaves) -> droppingCrystalSkyrootLeaves(leaves, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.SAKURA_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.SAKURA_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));

        add(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(),
                (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
        add(AncientAetherBlocks.SAKURA_BOOKSHELF.get(),
                (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return AncientAetherBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}