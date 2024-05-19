package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.data.providers.AncientBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AncientBlockStateData extends AncientBlockStateProvider {
    public AncientBlockStateData(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AncientBlocks.GRAVITY_GRAVEL);
        blockWithItem(AncientBlocks.WYND_ICE);
        blockWithItem(AncientBlocks.VALKYRIE_CLAY);
        blockWithItem(AncientBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(AncientBlocks.VALKYRUM_ORE);
        blockWithItem(AncientBlocks.CRYSTAL_SKYROOT_LEAVES);
        blockWithItem(AncientBlocks.ENCHANTED_SKYROOT_LEAVES);
        blockWithItem(AncientBlocks.SKYROOT_PINE_LEAVES);
        blockWithItem(AncientBlocks.BLUE_SKYROOT_PINE_LEAVES);
        blockWithItem(AncientBlocks.HIGHSPROOT_LEAVES);
        blockWithItem(AncientBlocks.SAKURA_LEAVES);
        blockWithItem(AncientBlocks.HIGHSPROOT_PLANKS);
        blockWithItem(AncientBlocks.SAKURA_PLANKS);
        blockWithItem(AncientBlocks.VALKYRUM_BLOCK);
        blockWithItem(AncientBlocks.FLUFFALO_WOOL);
        blockWithItem(AncientBlocks.CARVED_TILES);
        blockWithItem(AncientBlocks.WYND_SENTRY_STONE);
        blockWithItem(AncientBlocks.VALKYRIE_BRICKS);
        blockWithItem(AncientBlocks.VALKYRIE_TILES);
        blockWithItem(AncientBlocks.AEROGETIC_STONE);
        blockWithItem(AncientBlocks.AERONAUTIC_STONE);
        blockWithItem(AncientBlocks.CORRUPTED_AERONAUTIC_STONE);

        logBlock(AncientBlocks.HIGHSPROOT_LOG.get());
        logBlock(AncientBlocks.SAKURA_LOG.get());
        logBlock((AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get()));
        logBlock((AncientBlocks.CARVED_STONE_MOSAIC.get()));
        logBlock((AncientBlocks.ANGELIC_STONE_MOSAIC.get()));
        logBlock((AncientBlocks.HELLFIRE_STONE_MOSAIC.get()));
        logBlock((AncientBlocks.GALE_STONE_MOSAIC.get()));
        logBlock((AncientBlocks.AEROGETIC_STONE_MOSAIC.get()));

        axisBlock(AncientBlocks.HIGHSPROOT_WOOD.get(), blockTexture(AncientBlocks.HIGHSPROOT_LOG.get()), blockTexture(AncientBlocks.HIGHSPROOT_LOG.get()));
        axisBlock(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(),new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log_top"));
        axisBlock(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get(),new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"));
        axisBlock(AncientBlocks.SAKURA_WOOD.get(), blockTexture(AncientBlocks.SAKURA_LOG.get()), blockTexture(AncientBlocks.SAKURA_LOG.get()));
        axisBlock(AncientBlocks.STRIPPED_SAKURA_LOG.get(), new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log_top"));
        axisBlock(AncientBlocks.STRIPPED_SAKURA_WOOD.get(), new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"));

        simpleBlockItem(AncientBlocks.HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:highsproot_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:stripped_highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:stripped_highsproot_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.SAKURA_LOG.get(), models().withExistingParent("ancient_aether:sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.STRIPPED_SAKURA_LOG.get(), models().withExistingParent("ancient_aether:stripped_sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.STRIPPED_SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:stripped_sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.HOLYSTONE_BRICK_MOSAIC.get(), models().withExistingParent("ancient_aether:holystone_brick_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.CARVED_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:carved_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.ANGELIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:angelic_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.HELLFIRE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:hellfire_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.GALE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:gale_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientBlocks.AEROGETIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:aerogetic_stone_mosaic","minecraft:block/cube_column"));

        translucentBlock(AncientBlocks.VIOLET_AERCLOUD.get(),"");
        translucentBlock(AncientBlocks.AEROGEL_GLASS.get(), "");

        pane(AncientBlocks.AEROGEL_GLASS_PANE.get(), AncientBlocks.AEROGEL_GLASS.get(), "");

        crossBlock(AncientBlocks.ATMOSINE_CRYSTAL);
        crossBlock(AncientBlocks.CRYSTAL_SKYROOT_SAPLING);
        crossBlock(AncientBlocks.ENCHANTED_SKYROOT_SAPLING);
        crossBlock(AncientBlocks.SKYROOT_PINE_SAPLING);
        crossBlock(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING);
        crossBlock(AncientBlocks.HIGHSPROOT_SAPLING);
        crossBlock(AncientBlocks.SAKURA_SAPLING);
        crossBlock(AncientBlocks.SUNSET_ROSE);
        crossBlock(AncientBlocks.SKY_BLUES);
        crossBlock(AncientBlocks.WYND_THISTLE);
        crossBlock(AncientBlocks.ELEVETIA);

        stairs(AncientBlocks.HIGHSPROOT_STAIRS.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        stairs(AncientBlocks.SAKURA_STAIRS.get(), AncientBlocks.SAKURA_PLANKS.get(), "");
        stairs(AncientBlocks.CARVED_TILE_STAIRS.get(), AncientBlocks.CARVED_TILES.get(), "");
        stairs(AncientBlocks.VALKYRIE_BRICK_STAIRS.get(), AncientBlocks.VALKYRIE_BRICKS.get(), "");
        stairs(AncientBlocks.VALKYRIE_TILE_STAIRS.get(), AncientBlocks.VALKYRIE_TILES.get(), "");
        stairs(AncientBlocks.AEROGETIC_STAIRS.get(), AncientBlocks.AEROGETIC_STONE.get(), "");

        slab(AncientBlocks.HIGHSPROOT_SLAB.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        slab(AncientBlocks.SAKURA_SLAB.get(), AncientBlocks.SAKURA_PLANKS.get(), "");
        slab(AncientBlocks.CARVED_TILE_SLAB.get(), AncientBlocks.CARVED_TILES.get(), "");
        slab(AncientBlocks.VALKYRIE_BRICK_SLAB.get(), AncientBlocks.VALKYRIE_BRICKS.get(), "");
        slab(AncientBlocks.VALKYRIE_TILE_SLAB.get(), AncientBlocks.VALKYRIE_TILES.get(), "");
        slab(AncientBlocks.AEROGETIC_SLAB.get(), AncientBlocks.AEROGETIC_STONE.get(), "");

        fence(AncientBlocks.HIGHSPROOT_FENCE.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        fence(AncientBlocks.SAKURA_FENCE.get(), AncientBlocks.SAKURA_PLANKS.get(), "");

        fenceGateBlock(AncientBlocks.HIGHSPROOT_FENCE_GATE.get(), AncientBlocks.HIGHSPROOT_PLANKS.get(), "");
        fenceGateBlock(AncientBlocks.SAKURA_FENCE_GATE.get(), AncientBlocks.SAKURA_PLANKS.get(), "");

        wallBlock(AncientBlocks.CARVED_TILE_WALL.get(), AncientBlocks.CARVED_TILES.get(), "");
        wallBlock(AncientBlocks.VALKYRIE_BRICK_WALL.get(), AncientBlocks.VALKYRIE_BRICKS.get(), "");
        wallBlock(AncientBlocks.VALKYRIE_TILE_WALL.get(), AncientBlocks.VALKYRIE_TILES.get(), "");
        wallBlock(AncientBlocks.AEROGETIC_WALL.get(), AncientBlocks.AEROGETIC_STONE.get(), "");

        doorBlock(AncientBlocks.HIGHSPROOT_DOOR.get(), texture(name(AncientBlocks.HIGHSPROOT_DOOR.get()), "", "_bottom"), texture(name(AncientBlocks.HIGHSPROOT_DOOR.get()), "", "_top"));
        doorBlock(AncientBlocks.SAKURA_DOOR.get(), texture(name(AncientBlocks.SAKURA_DOOR.get()), "", "_bottom"), texture(name(AncientBlocks.SAKURA_DOOR.get()), "", "_top"));
        translucentDoorBlock(AncientBlocks.AEROGEL_GLASS_DOOR.get(), texture(name(AncientBlocks.AEROGEL_GLASS_DOOR.get()), "", "_bottom"), texture(name(AncientBlocks.AEROGEL_GLASS_DOOR.get()), "", "_top"));

        trapdoorBlock(AncientBlocks.HIGHSPROOT_TRAPDOOR.get(), texture(name(AncientBlocks.HIGHSPROOT_TRAPDOOR.get()), ""), false);
        trapdoorBlock(AncientBlocks.SAKURA_TRAPDOOR.get(), texture(name(AncientBlocks.SAKURA_TRAPDOOR.get()), ""), false);
        translucentTrapdoorBlock(AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get(), texture(name(AncientBlocks.AEROGEL_GLASS_TRAPDOOR.get()), ""), false);

        buttonBlock(AncientBlocks.HIGHSPROOT_BUTTON.get(), texture(name(AncientBlocks.HIGHSPROOT_PLANKS.get()), ""));
        buttonBlock(AncientBlocks.SAKURA_BUTTON.get(), texture(name(AncientBlocks.SAKURA_PLANKS.get()), ""));

        pressurePlateBlock(AncientBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), texture(name(AncientBlocks.HIGHSPROOT_PLANKS.get()), ""));
        pressurePlateBlock(AncientBlocks.SAKURA_PRESSURE_PLATE.get(), texture(name(AncientBlocks.SAKURA_PLANKS.get()), ""));

        signBlock(AncientBlocks.HIGHSPROOT_SIGN.get(), AncientBlocks.HIGHSPROOT_WALL_SIGN.get(), texture(name(AncientBlocks.HIGHSPROOT_PLANKS.get()), ""));
        signBlock(AncientBlocks.SAKURA_SIGN.get(), AncientBlocks.SAKURA_WALL_SIGN.get(), texture(name(AncientBlocks.SAKURA_PLANKS.get()), ""));

        hangingSignBlock(AncientBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), texture(name(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get()), ""));
        hangingSignBlock(AncientBlocks.SAKURA_HANGING_SIGN.get(), AncientBlocks.SAKURA_WALL_HANGING_SIGN.get(), texture(name(AncientBlocks.STRIPPED_SAKURA_LOG.get()), ""));

        AABookshelf(AncientBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientBlocks.HIGHSPROOT_PLANKS.get());
        AABookshelf(AncientBlocks.SAKURA_BOOKSHELF.get(), AncientBlocks.SAKURA_PLANKS.get());

        lantern(AncientBlocks.AMBROSIUM_LANTERN.get());
        lantern(AncientBlocks.WYND_LANTERN.get());
        lantern(AncientBlocks.SUN_LANTERN.get());

        vase(AncientBlocks.HOLYSTONE_VASE.get());
        vase(AncientBlocks.MOSSY_HOLYSTONE_VASE.get());
        vase(AncientBlocks.FROZEN_HOLYSTONE_VASE.get());
        vase(AncientBlocks.SENTRY_VASE.get());
        vase(AncientBlocks.ANGELIC_VASE.get());
        vase(AncientBlocks.HELLFIRE_VASE.get());
        vase(AncientBlocks.AEROGETIC_VASE.get());
        vase(AncientBlocks.GALE_VASE.get());

        ancientVase(AncientBlocks.ANCIENT_HOLYSTONE_VASE.get(), AncientBlocks.HOLYSTONE_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), AncientBlocks.MOSSY_HOLYSTONE_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), AncientBlocks.FROZEN_HOLYSTONE_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_SENTRY_VASE.get(), AncientBlocks.SENTRY_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_ANGELIC_VASE.get(), AncientBlocks.ANGELIC_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_HELLFIRE_VASE.get(), AncientBlocks.HELLFIRE_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_AEROGETIC_VASE.get(), AncientBlocks.AEROGETIC_VASE.get());
        ancientVase(AncientBlocks.ANCIENT_GALE_VASE.get(), AncientBlocks.GALE_VASE.get());

        carpet(AncientBlocks.FLUFFALO_CARPET.get(), AncientBlocks.FLUFFALO_WOOL.get());
        cornerBrick(AncientBlocks.ANGELIC_CORNER_BRICK.get());
        grapeVine(AncientBlocks.GRAPE_VINE.get());
        slammrootPlant(AncientBlocks.SLAMMROOT_PLANT.get());
        windBlower(AncientBlocks.WIND_BLOWER.get());
        sliderPrototype(AncientBlocks.SLIDER_PROTOTYPE.get());

        obelisk(AncientBlocks.ANCIENT_OBELISK.get());
        obelisk(AncientBlocks.POWERED_OBELISK.get());

        AADungeonBlock(AncientBlocks.LOCKED_CARVED_TILES.get(), AncientBlocks.CARVED_TILES.get());
        AADungeonBlock(AncientBlocks.LOCKED_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AADungeonBlock(AncientBlocks.LOCKED_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientBlocks.LOCKED_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AADungeonBlock(AncientBlocks.LOCKED_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        AADungeonBlock(AncientBlocks.TRAPPED_CARVED_TILES.get(), AncientBlocks.CARVED_TILES.get());
        AADungeonBlock(AncientBlocks.TRAPPED_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientBlocks.TRAPPED_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AADungeonBlock(AncientBlocks.TRAPPED_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());
        AADungeonBlock(AncientBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AADungeonBlock(AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AADungeonBlock(AncientBlocks.TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        lockedMosaicBlock(AncientBlocks.LOCKED_CARVED_STONE_MOSAIC.get(), AncientBlocks.CARVED_STONE_MOSAIC.get());
        lockedMosaicBlock(AncientBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get(), AncientBlocks.ANGELIC_STONE_MOSAIC.get());
        lockedMosaicBlock(AncientBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get(), AncientBlocks.HELLFIRE_STONE_MOSAIC.get());
        lockedMosaicBlock(AncientBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get(), AncientBlocks.AEROGETIC_STONE_MOSAIC.get());
        lockedMosaicBlock(AncientBlocks.LOCKED_GALE_STONE_MOSAIC.get(), AncientBlocks.GALE_STONE_MOSAIC.get());

        invisibleBlock(AncientBlocks.BOSS_DOORWAY_CARVED_STONE.get(), AetherBlocks.CARVED_STONE.get());
        AAInvisibleBlock(AncientBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get(), AncientBlocks.WYND_SENTRY_STONE.get());
        AAInvisibleBlock(AncientBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(), AncientBlocks.AEROGETIC_STONE.get());
        AAInvisibleBlock(AncientBlocks.BOSS_DOORWAY_AERONAUTIC_STONE.get(), AncientBlocks.AERONAUTIC_STONE.get());
        AAInvisibleBlock(AncientBlocks.BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE.get(), AncientBlocks.CORRUPTED_AERONAUTIC_STONE.get());

        pottedPlant(AncientBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get(), AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING.get(), AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_SKYROOT_PINE_SAPLING.get(), AncientBlocks.SKYROOT_PINE_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING.get(), AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_HIGHSPROOT_SAPLING.get(), AncientBlocks.HIGHSPROOT_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_SAKURA_SAPLING.get(), AncientBlocks.SAKURA_SAPLING.get(), "");
        pottedPlant(AncientBlocks.POTTED_SKY_BLUES.get(), AncientBlocks.SKY_BLUES.get(), "");
        pottedPlant(AncientBlocks.POTTED_SUNSET_ROSE.get(), AncientBlocks.SUNSET_ROSE.get(), "");
        pottedPlant(AncientBlocks.POTTED_WYND_THISTLE.get(), AncientBlocks.WYND_THISTLE.get(), "");
        pottedPlant(AncientBlocks.POTTED_ELEVETIA.get(), AncientBlocks.ELEVETIA.get(), "");

        makeLogWalls();
    }

    private void makeLogWalls() {
        ModelFile postBig = makeWallPostModel(4, 16, "wooden_post_big");
        ModelFile postShort = makeWallPostModel(3, 14, "wooden_post_short");
        ModelFile postTall = makeWallPostModel(3, 16, "wooden_post_tall");

        ModelFile side = makeWallSideModel(5, 14, "wooden_side", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 5);
        ModelFile sideAlt = makeWallSideModel(5, 14, "wooden_side_alt", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 11, 16);
        ModelFile sideTall = makeWallSideModel(5, 16, "wooden_side_tall", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 5);
        ModelFile sideTallAlt = makeWallSideModel(5, 16, "wooden_side_tall_alt", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 11, 16);

        ModelFile sideShort = makeWallSideModel(4, 14, "wooden_side_short", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 4);
        ModelFile sideAltShort = makeWallSideModel(4, 14, "wooden_side_alt_short", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 12, 16);
        ModelFile sideTallShort = makeWallSideModel(4, 16, "wooden_side_tall_short", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 4);
        ModelFile sideTallAltShort = makeWallSideModel(4, 16, "wooden_side_tall_alt_short", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 12, 16);

        logWallBlock(AncientBlocks.HIGHSPROOT_LOG_WALL.get(), AncientBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);

        logWallBlock(AncientBlocks.SAKURA_LOG_WALL.get(), AncientBlocks.SAKURA_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.SAKURA_WOOD_WALL.get(), AncientBlocks.SAKURA_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }
}