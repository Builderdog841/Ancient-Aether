package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.providers.AncientAetherBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AncientAetherBlockStateData extends AncientAetherBlockStateProvider {
    public AncientAetherBlockStateData(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_PLANKS);
        blockWithItem(AncientAetherBlocks.SAKURA_PLANKS);
        blockWithItem(AncientAetherBlocks.SKYROOT_PINE_LEAVES);
        blockWithItem(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.SAKURA_LEAVES);
        blockWithItem(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.VALKYRUM_BLOCK);
        blockWithItem(AncientAetherBlocks.VALKYRUM_ORE);
        blockWithItem(AncientAetherBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(AncientAetherBlocks.GRAVITY_GRAVEL);
        blockWithItem(AncientAetherBlocks.WYND_ICE);
        blockWithItem(AncientAetherBlocks.FLUFFALO_WOOL);
        blockWithItem(AncientAetherBlocks.CARVED_TILES);
        blockWithItem(AncientAetherBlocks.WYND_SENTRY_STONE);
        blockWithItem(AncientAetherBlocks.AEROGETIC_STONE);
        blockWithItem(AncientAetherBlocks.LIGHT_AEROGETIC_STONE);
        blockWithItem(AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE);

        logBlock(((RotatedPillarBlock) AncientAetherBlocks.HIGHSPROOT_LOG.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.SAKURA_LOG.get()));
        logBlock((AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get()));
        logBlock((AncientAetherBlocks.CARVED_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.GALE_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get()));

        axisBlock((RotatedPillarBlock) AncientAetherBlocks.HIGHSPROOT_WOOD.get(), blockTexture(AncientAetherBlocks.HIGHSPROOT_LOG.get()), blockTexture(AncientAetherBlocks.HIGHSPROOT_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(),new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(),new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_highsproot_log"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.SAKURA_WOOD.get(), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MODID,"block/stripped_sakura_log"));

        simpleBlockItem(AncientAetherBlocks.HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:highsproot_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:stripped_highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:stripped_highsproot_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.SAKURA_LOG.get(), models().withExistingParent("ancient_aether:sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), models().withExistingParent("ancient_aether:stripped_sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:stripped_sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), models().withExistingParent("ancient_aether:holystone_brick_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:carved_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:angelic_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:hellfire_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.GALE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:gale_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:aerogetic_stone_mosaic","minecraft:block/cube_column"));

        translucentBlock(AncientAetherBlocks.VIOLET_AERCLOUD.get(),"");
        translucentBlock(AncientAetherBlocks.AEROGEL_GLASS.get(), "");

        pane(AncientAetherBlocks.AEROGEL_GLASS_PANE.get(), AncientAetherBlocks.AEROGEL_GLASS.get(), "");

        crossBlock(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING);
        crossBlock(AncientAetherBlocks.SKYROOT_PINE_SAPLING);
        crossBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING);
        crossBlock(AncientAetherBlocks.HIGHSPROOT_SAPLING);
        crossBlock(AncientAetherBlocks.SAKURA_SAPLING);
        crossBlock(AncientAetherBlocks.WYND_THISTLE);
        crossBlock(AncientAetherBlocks.SKY_BLUES);
        crossBlock(AncientAetherBlocks.SAKURA_BLOSSOMS);
        crossBlock(AncientAetherBlocks.HIGHLAND_VIOLA);
        crossBlock(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS);

        stairs((StairBlock) AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        stairs((StairBlock) AncientAetherBlocks.SAKURA_STAIRS.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        stairs((StairBlock) AncientAetherBlocks.CARVED_TILE_STAIRS.get(), AncientAetherBlocks.CARVED_TILES.get(), "");
        stairs((StairBlock) AncientAetherBlocks.AEROGETIC_STAIRS.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");

        slab((SlabBlock) AncientAetherBlocks.HIGHSPROOT_SLAB.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.SAKURA_SLAB.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.CARVED_TILE_SLAB.get(), AncientAetherBlocks.CARVED_TILES.get(), "");
        slab((SlabBlock) AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");

        fence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");

        fenceGateBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");

        wallBlock((WallBlock) AncientAetherBlocks.CARVED_TILE_WALL.get(), AncientAetherBlocks.CARVED_TILES.get(), "");
        wallBlock((WallBlock) AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");

        doorBlock(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_top"));
        doorBlock(AncientAetherBlocks.SAKURA_DOOR.get(), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_top"));
        translucentDoorBlock(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), texture(name(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), "", "_top"));

        trapdoorBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()), ""), false);
        trapdoorBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), texture(name(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), ""), false);
        translucentTrapdoorBlock(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get(), texture(name(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get()), ""), false);

        buttonBlock(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        buttonBlock(AncientAetherBlocks.SAKURA_BUTTON.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));

        pressurePlateBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));

        signBlock((StandingSignBlock) AncientAetherBlocks.HIGHSPROOT_SIGN.get(), (WallSignBlock) AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        signBlock((StandingSignBlock) AncientAetherBlocks.SAKURA_SIGN.get(), (WallSignBlock) AncientAetherBlocks.SAKURA_WALL_SIGN.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));

        hangingSignBlock(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), texture(name(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()), ""));
        hangingSignBlock(AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get(), texture(name(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()), ""));

        AABookshelf(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
        AABookshelf(AncientAetherBlocks.SAKURA_BOOKSHELF.get(), AncientAetherBlocks.SAKURA_PLANKS.get());

        lantern(AncientAetherBlocks.AMBROSIUM_LANTERN.get());
        lantern(AncientAetherBlocks.WYND_LANTERN.get());
        lantern(AncientAetherBlocks.SUN_LANTERN.get());

        vase(AncientAetherBlocks.HOLYSTONE_VASE.get());
        vase(AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        vase(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        vase(AncientAetherBlocks.SENTRY_VASE.get());
        vase(AncientAetherBlocks.ANGELIC_VASE.get());
        vase(AncientAetherBlocks.HELLFIRE_VASE.get());
        vase(AncientAetherBlocks.AEROGETIC_VASE.get());
        vase(AncientAetherBlocks.GALE_VASE.get());

        ancientVase(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), AncientAetherBlocks.HOLYSTONE_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), AncientAetherBlocks.MOSSY_HOLYSTONE_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(), AncientAetherBlocks.SENTRY_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_ANGELIC_VASE.get(), AncientAetherBlocks.ANGELIC_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_HELLFIRE_VASE.get(), AncientAetherBlocks.HELLFIRE_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_AEROGETIC_VASE.get(), AncientAetherBlocks.AEROGETIC_VASE.get());
        ancientVase(AncientAetherBlocks.ANCIENT_GALE_VASE.get(), AncientAetherBlocks.GALE_VASE.get());

        sliderPrototype(AncientAetherBlocks.SLIDER_PROTOTYPE.get());

        obelisk(AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get());
        obelisk(AncientAetherBlocks.ANCIENT_OBELISK.get());

        carpet(AncientAetherBlocks.FLUFFALO_CARPET.get(), AncientAetherBlocks.FLUFFALO_WOOL.get());

        AADungeonBlock(AncientAetherBlocks.LOCKED_CARVED_TILES.get(), AncientAetherBlocks.CARVED_TILES.get());
        AADungeonBlock(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AADungeonBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.LOCKED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.LOCKED_CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TRAPPED_CARVED_TILES.get(), AncientAetherBlocks.CARVED_TILES.get());
        AADungeonBlock(AncientAetherBlocks.TRAPPED_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TRAPPED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TRAPPED_CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        AADungeonBlock(AncientAetherBlocks.TREASURE_DOORWAY_CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());

        dungeonAxisBlock(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get(), AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
        dungeonAxisBlock(AncientAetherBlocks.LOCKED_ANGELIC_STONE_MOSAIC.get(), AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
        dungeonAxisBlock(AncientAetherBlocks.LOCKED_HELLFIRE_STONE_MOSAIC.get(), AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
        dungeonAxisBlock(AncientAetherBlocks.LOCKED_AEROGETIC_STONE_MOSAIC.get(), AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get());
        dungeonAxisBlock(AncientAetherBlocks.LOCKED_GALE_STONE_MOSAIC.get(), AncientAetherBlocks.GALE_STONE_MOSAIC.get());

        AAInvisibleBlock(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get(), AncientAetherBlocks.WYND_SENTRY_STONE.get());
        AAInvisibleBlock(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get(), AncientAetherBlocks.AEROGETIC_STONE.get());
        AAInvisibleBlock(AncientAetherBlocks.BOSS_DOORWAY_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get());
        AAInvisibleBlock(AncientAetherBlocks.BOSS_DOORWAY_CORRUPTED_LIGHT_AEROGETIC_STONE.get(), AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get());

        pottedPlant(AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING.get(), AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get(), AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get(), AncientAetherBlocks.SAKURA_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get(), AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_WYND_THISTLE.get(), AncientAetherBlocks.WYND_THISTLE.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHLAND_VIOLA.get(), AncientAetherBlocks.HIGHLAND_VIOLA.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SKY_BLUES.get(), AncientAetherBlocks.SKY_BLUES.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING.get(), AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), "");

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

        logWallBlock(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);

        logWallBlock(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MODID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MODID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }
}