package net.builderdog.ancient_aether.datagen.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.datagen.providers.AncientAetherBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class AncientAetherBlockStateData extends AncientAetherBlockStateProvider {
    public AncientAetherBlockStateData(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {

        //Highsproot
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.HIGHSPROOT_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.HIGHSPROOT_WOOD.get(), blockTexture(AncientAetherBlocks.HIGHSPROOT_LOG.get()), blockTexture(AncientAetherBlocks.HIGHSPROOT_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highsproot_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highsproot_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highsproot_log"));
        simpleBlockItem(AncientAetherBlocks.HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:highsproot_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), models().withExistingParent("ancient_aether:stripped_highsproot_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), models().withExistingParent("ancient_aether:stripped_highsproot_wood","minecraft:block/cube_column"));
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_PLANKS);
        stairs((StairBlock) AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.HIGHSPROOT_SLAB.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        aabookshelf(AncientAetherBlocks.HIGHSPROOT_BOOKSHELF.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get());

        //Sakura
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.SAKURA_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.SAKURA_WOOD.get(), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"));
        simpleBlockItem(AncientAetherBlocks.SAKURA_LOG.get(), models().withExistingParent("ancient_aether:sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), models().withExistingParent("ancient_aether:stripped_sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:stripped_sakura_wood","minecraft:block/cube_column"));
        blockWithItem(AncientAetherBlocks.SAKURA_PLANKS);
        stairs((StairBlock) AncientAetherBlocks.SAKURA_STAIRS.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.SAKURA_SLAB.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        fence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.SAKURA_DOOR.get(), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), texture(name(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.SAKURA_BUTTON.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));
        aabookshelf(AncientAetherBlocks.SAKURA_BOOKSHELF.get(), AncientAetherBlocks.SAKURA_PLANKS.get());
        hangingSignBlock(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), texture(name(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()), ""));
        hangingSignBlock(AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get(), texture(name(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get()), ""));

        //Leaves
        blockWithItem(AncientAetherBlocks.SKYROOT_PINE_LEAVES);
        blockWithItem(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.SAKURA_LEAVES);
        blockWithItem(AncientAetherBlocks.DIVINE_SKYROOT_LEAVES);

        //Saplings
        crossBlock(AncientAetherBlocks.DIVINE_SKYROOT_SAPLING);
        crossBlock(AncientAetherBlocks.SKYROOT_PINE_SAPLING);
        crossBlock(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING);
        crossBlock(AncientAetherBlocks.HIGHSPROOT_SAPLING);
        crossBlock(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING);
        crossBlock(AncientAetherBlocks.SAKURA_SAPLING);

        //Ores
        blockWithItem(AncientAetherBlocks.VALKYRUM_BLOCK);
        blockWithItem(AncientAetherBlocks.VALKYRUM_ORE);
        blockWithItem(AncientAetherBlocks.AETHER_QUARTZ_ORE);

        //Natural Blocks
        blockWithItem(AncientAetherBlocks.GRAVITY_GRAVEL);
        blockWithItem(AncientAetherBlocks.WYNDCAPS_ICE);

        //Aerclouds
        translucentBlock(AncientAetherBlocks.VIOLET_AERCLOUD.get(),"");
        translucentBlock(AncientAetherBlocks.CRYSTAL_AERCLOUD.get(),"");

        //Construction
        logBlock((AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get()));
        translucentBlock(AncientAetherBlocks.AEROGEL_GLASS.get(), "");
        pane(AncientAetherBlocks.AEROGEL_GLASS_PANE.get(), AncientAetherBlocks.AEROGEL_GLASS.get(), "");
        translucentDoorBlock(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get(), texture(name(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.AEROGEL_GLASS_DOOR.get()), "", "_top"));
        translucentTrapdoorBlock(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get(), texture(name(AncientAetherBlocks.AEROGEL_GLASS_TRAPDOOR.get()), ""), false);
        blockWithItem(AncientAetherBlocks.BUFFALO_WOOL);

        //Dungeon Blocks
        blockWithItem(AncientAetherBlocks.AEROGETIC_STONE);
        blockWithItem(AncientAetherBlocks.LIGHT_AEROGETIC_STONE);
        blockWithItem(AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE);
        stairs((StairBlock) AncientAetherBlocks.AEROGETIC_STAIRS.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");
        slab((SlabBlock) AncientAetherBlocks.AEROGETIC_SLAB.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");
        wallBlock((WallBlock) AncientAetherBlocks.AEROGETIC_WALL.get(), AncientAetherBlocks.AEROGETIC_STONE.get(), "");
        logBlock((AncientAetherBlocks.CARVED_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.GALE_STONE_MOSAIC.get()));
        logBlock((AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get()));
        simpleBlockItem(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), models().withExistingParent("ancient_aether:holystone_brick_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:carved_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:angelic_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:hellfire_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.GALE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:gale_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.AEROGETIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:aerogetic_stone_mosaic","minecraft:block/cube_column"));

        //Plants
        crossBlock(AncientAetherBlocks.WYND_THISTLE);
        crossBlock(AncientAetherBlocks.SKY_BLUES);
        crossBlock(AncientAetherBlocks.SAKURA_BLOSSOMS);
        crossBlock(AncientAetherBlocks.HIGHLAND_VIOLA);
        crossBlock(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS);

        //Potted Plants
        pottedPlant(AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING.get(), AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING.get(), AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get(), AncientAetherBlocks.SAKURA_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get(), AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_WYND_THISTLE.get(), AncientAetherBlocks.WYND_THISTLE.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHLAND_VIOLA.get(), AncientAetherBlocks.HIGHLAND_VIOLA.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SKY_BLUES.get(), AncientAetherBlocks.SKY_BLUES.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_FROSTED_HIGHSPROOT_SAPLING.get(), AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_DIVINE_SKYROOT_SAPLING.get(), AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get(), "");

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

        logWallBlock(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MOD_ID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MOD_ID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.HIGHSPROOT_LOG.get(), "", AncientAether.MOD_ID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), "", AncientAether.MOD_ID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);

        logWallBlock(AncientAetherBlocks.SAKURA_LOG_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", AncientAether.MOD_ID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MOD_ID, true, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), AncientAetherBlocks.SAKURA_LOG.get(), "", AncientAether.MOD_ID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
        logWallBlock(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), "", AncientAether.MOD_ID, false, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void crossBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
