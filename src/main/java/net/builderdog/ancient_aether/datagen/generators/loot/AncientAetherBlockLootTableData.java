package net.builderdog.ancient_aether.datagen.generators.loot;

import com.aetherteam.aether.data.providers.AetherBlockLootSubProvider;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.mixin.mixins.common.accessor.BlockLootAccessor;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AncientAetherBlockLootTableData extends AetherBlockLootSubProvider {
    public AncientAetherBlockLootTableData() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //Highsproot
        dropSelfDouble(AncientAetherBlocks.HIGHSPROOT_LOG.get());
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
        add(AncientAetherBlocks.HIGHSPROOT_SLAB.get(), this::createSlabItemTable);
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        add(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), createDoorTable(AncientAetherBlocks.HIGHSPROOT_DOOR.get()));
        dropSelf(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_BUTTON.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get());
        add(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(),
                (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));

        //Sakura
        dropSelfDouble(AncientAetherBlocks.SAKURA_LOG.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_PLANKS.get());
        dropSelf(AncientAetherBlocks.SAKURA_STAIRS.get());
        add(AncientAetherBlocks.SAKURA_SLAB.get(), this::createSlabItemTable);
        dropSelf(AncientAetherBlocks.SAKURA_FENCE.get());
        dropSelf(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        add(AncientAetherBlocks.SAKURA_DOOR.get(), createDoorTable(AncientAetherBlocks.SAKURA_DOOR.get()));
        dropSelf(AncientAetherBlocks.SAKURA_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.SAKURA_BUTTON.get());
        dropSelf(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.SAKURA_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WALL_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_HANGING_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get());
        add(AncientAetherBlocks.SAKURA_BOOKSHELF.get(),
                (bookshelf) -> createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));

        //Leaves
        add(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get(),
                (leaves) -> droppingCrystalSkyrootLeaves(leaves, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.DIVINE_SKYROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.SAKURA_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.SAKURA_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));

        //Saplings
        dropSelf(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get());
        dropSelf(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get());
        dropSelf(AncientAetherBlocks.SAKURA_SAPLING.get());

        //Ores
        dropSelf(AncientAetherBlocks.VALKYRUM_ORE.get());
        dropSelf(AncientAetherBlocks.VALKYRUM_BLOCK.get());
        dropDoubleWithFortune(AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ);

        //Natural
        dropSelfDouble(AncientAetherBlocks.GRAVITY_GRAVEL.get());
        dropWhenSilkTouch(AncientAetherBlocks.WYNDCAPS_ICE.get());

        //Aerclouds
        dropSelfDouble(AncientAetherBlocks.VIOLET_AERCLOUD.get());
        dropSelfDouble(AncientAetherBlocks.CRYSTAL_AERCLOUD.get());

        //Construction
        dropSelf(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS_PANE.get());
        dropSelf(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get());
        add(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), createDoorTable(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()));
        dropSelf(AncientAetherBlocks.BUFFALO_WOOL.get());
        dropSelf(AncientAetherBlocks.BUFFALO_CARPET.get());

        //Dungeon Blocks
        dropSelf(AncientAetherBlocks.CARVED_TILES.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STAIRS.get());
        add(AncientAetherBlocks.AEROGETIC_SLAB.get(), this::createSlabItemTable);
        dropSelf(AncientAetherBlocks.AEROGETIC_WALL.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());
        dropSelf(AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.GALE_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.ANCIENT_OBELISK.get());

        //Lanterns and Campfires
        dropSelf(AncientAetherBlocks.HOLYSTONE_LANTERN.get());
        dropSelf(AncientAetherBlocks.SENTRY_LANTERN.get());
        dropSelf(AncientAetherBlocks.ANGELIC_LANTERN.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_LANTERN.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_LANTERN.get());
        dropSelf(AncientAetherBlocks.GALE_LANTERN.get());
        dropOther(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get(), AetherItems.AMBROSIUM_SHARD.get());

        //Redstone Blocks
        dropSelf(AncientAetherBlocks.CRACKED_SLIDER.get());
        dropSelf(AncientAetherBlocks.WIND_BLOWER.get());

        //Plants
        dropSelf(AncientAetherBlocks.SKY_BLUES.get());
        dropSelf(AncientAetherBlocks.WYND_THISTLE.get());
        dropSelf(AncientAetherBlocks.HIGHLAND_VIOLA.get());
        dropSelf(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        dropOther(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get());

        //Potted Plants
        dropPottedContents(AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SKY_BLUES.get());
        dropPottedContents(AncientAetherBlocks.POTTED_WYND_THISTLE.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHLAND_VIOLA.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get());
        dropPottedContents(AncientAetherBlocks.POTTED_FROSTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_DIVINE_SKYROOT_SAPLING.get());

        //Vases
        dropSelf(AncientAetherBlocks.HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.FROSTED_HOLYSTONE_VASE.get());
        dropSelf(AncientAetherBlocks.SENTRY_VASE.get());
        dropSelf(AncientAetherBlocks.ANGELIC_VASE.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_VASE.get());
        dropSelf(AncientAetherBlocks.AEROGETIC_VASE.get());
    }

    public LootTable.Builder droppingCrystalSkyrootLeaves(Block block, Block sapling, float... chances) {
        return this.droppingWithChancesAndSkyrootSticks(block, sapling, chances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(BlockLootAccessor.aether$hasShearsOrSilkTouch().invert())
                        .add(this.applyExplosionCondition(block,
                                        LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.0055F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return AncientAetherBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}