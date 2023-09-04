package net.builderdog.ancient_aether.datagen.generators;

import com.aetherteam.aether.data.providers.AetherBlockLootSubProvider;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.mixin.mixins.common.accessor.BlockLootAccessor;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class AncientAetherBlockLootTableData extends AetherBlockLootSubProvider {
    public AncientAetherBlockLootTableData() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(AncientAetherBlocks.AEROTIC_STONE.get());
        dropSelf(AncientAetherBlocks.LIGHT_AEROTIC_STONE.get());
        dropSelf(AncientAetherBlocks.QUICKSTONE.get());
        dropSelf(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
        dropSelf(AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        dropSelf(AncientAetherBlocks.GALE_STONE_MOSAIC.get());
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
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SLAB.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
        add(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), createDoorTable(AncientAetherBlocks.HIGHSPROOT_DOOR.get()));
        dropSelf(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_BUTTON.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_SIGN.get());
        dropSelf(AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get());
        dropSelfDouble(AncientAetherBlocks.SAKURA_LOG.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
        dropSelf(AncientAetherBlocks.SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get());
        dropSelf(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
        dropSelf(AncientAetherBlocks.SAKURA_PLANKS.get());
        dropSelf(AncientAetherBlocks.SAKURA_SAPLING.get());
        dropSelf(AncientAetherBlocks.SAKURA_STAIRS.get());
        dropSelf(AncientAetherBlocks.SAKURA_SLAB.get());
        dropSelf(AncientAetherBlocks.SAKURA_FENCE.get());
        dropSelf(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
        add(AncientAetherBlocks.SAKURA_DOOR.get(), createDoorTable(AncientAetherBlocks.SAKURA_DOOR.get()));
        dropSelf(AncientAetherBlocks.SAKURA_TRAPDOOR.get());
        dropSelf(AncientAetherBlocks.SAKURA_BUTTON.get());
        dropSelf(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
        dropSelf(AncientAetherBlocks.SAKURA_SIGN.get());
        dropSelf(AncientAetherBlocks.SAKURA_WALL_SIGN.get());
        dropSelf(AncientAetherBlocks.QUICKSTONE_STAIRS.get());
        dropSelf(AncientAetherBlocks.QUICKSTONE_SLAB.get());
        dropSelf(AncientAetherBlocks.HIGHLAND_TULIP.get());
        dropSelf(AncientAetherBlocks.EDELWEISS.get());
        dropSelf(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        dropSelf(AncientAetherBlocks.CRACKED_SLIDER.get());
        dropSelf(AncientAetherBlocks.HOLYSTONE_LANTERN.get());
        dropSelf(AncientAetherBlocks.SENTRY_LANTERN.get());
        dropSelf(AncientAetherBlocks.ANGELIC_LANTERN.get());
        dropSelf(AncientAetherBlocks.HELLFIRE_LANTERN.get());
        dropSelf(AncientAetherBlocks.GALE_LANTERN.get());
        dropSelf(AncientAetherBlocks.SENTRY_OBELISK.get());
        dropSelf(AncientAetherBlocks.MOONLIT_WATERLILY.get());

        dropOther(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get());

        dropOther(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get(), AetherItems.AMBROSIUM_SHARD.get());

        dropPottedContents(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get());
        dropPottedContents(AncientAetherBlocks.POTTED_HIGHLAND_TULIP.get());
        dropPottedContents(AncientAetherBlocks.POTTED_EDELWEISS.get());
        dropPottedContents(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get());

        dropDoubleWithFortune(AncientAetherBlocks.AETHER_QUARTZ_ORE.get(), Items.QUARTZ);

        add(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
        add(AncientAetherBlocks.SAKURA_LEAVES.get(),
                (leaves) -> droppingWithChancesAndSkyrootSticks(leaves, AncientAetherBlocks.SAKURA_SAPLING.get(), BlockLootAccessor.aether$getNormalLeavesSaplingChances()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AncientAetherBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}