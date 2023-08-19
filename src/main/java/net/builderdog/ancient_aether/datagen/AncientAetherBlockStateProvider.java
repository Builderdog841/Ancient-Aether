package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherBlockStateProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class AncientAetherBlockStateProvider extends AetherBlockStateProvider {
    public AncientAetherBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AncientAetherBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(AncientAetherBlocks.ANCIENT_SENTRY_STONE);
        blockWithItem(AncientAetherBlocks.QUICKSOIL_BRICKS);
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_PLANKS);
        blockWithItem(AncientAetherBlocks.SAKURA_PLANKS);
        blockWithItem(AncientAetherBlocks.HIGHSPROOT_LEAVES);
        blockWithItem(AncientAetherBlocks.SAKURA_LEAVES);

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

        logBlock(((RotatedPillarBlock) AncientAetherBlocks.SAKURA_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.SAKURA_WOOD.get(), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()), blockTexture(AncientAetherBlocks.SAKURA_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_sakura_log"));

        simpleBlockItem(AncientAetherBlocks.SAKURA_LOG.get(), models().withExistingParent("ancient_aether:sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:sakura_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), models().withExistingParent("ancient_aether:stripped_sakura_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), models().withExistingParent("ancient_aether:stripped_sakura_wood","minecraft:block/cube_column"));

        logBlock(((RotatedPillarBlock) AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CARVED_STONE_MOSAIC.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.GALE_STONE_MOSAIC.get()));

        simpleBlockItem(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get(), models().withExistingParent("ancient_aether:holystone_brick_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CARVED_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:carved_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:angelic_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:hellfire_stone_mosaic","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.GALE_STONE_MOSAIC.get(), models().withExistingParent("ancient_aether:gale_stone_mosaic","minecraft:block/cube_column"));

        stairs((StairBlock) AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), (Block)AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.HIGHSPROOT_SLAB.get(), (Block)AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fence(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.HIGHSPROOT_DOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.HIGHSPROOT_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.HIGHSPROOT_BUTTON.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()), ""));

        stairs((StairBlock) AncientAetherBlocks.SAKURA_STAIRS.get(), (Block)AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.SAKURA_SLAB.get(), (Block)AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        fence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.SAKURA_DOOR.get(), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), texture(name(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.SAKURA_BUTTON.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));

        stairs((StairBlock) AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get(), (Block)AncientAetherBlocks.QUICKSOIL_BRICKS.get(), "");
        slab((SlabBlock) AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get(), (Block)AncientAetherBlocks.QUICKSOIL_BRICKS.get(), "");
        wallBlock(AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get(), AncientAetherBlocks.QUICKSOIL_BRICKS.get(), "");

        crossBlock(AncientAetherBlocks.HIGHSPROOT_SAPLING);
        crossBlock(AncientAetherBlocks.SAKURA_SAPLING);
        crossBlock(AncientAetherBlocks.HIGHLAND_TULIP);
        crossBlock(AncientAetherBlocks.EDELWEISS);
        crossBlock(AncientAetherBlocks.SAKURA_BLOSSOMS);
        crossBlock(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS);

        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_SAPLING.get(), AncientAetherBlocks.SAKURA_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get(), AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_EDELWEISS.get(), AncientAetherBlocks.EDELWEISS.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS.get(), AncientAetherBlocks.SAKURA_BLOSSOMS.get(), "");
        pottedPlant(AncientAetherBlocks.POTTED_HIGHLAND_TULIP.get(), AncientAetherBlocks.HIGHLAND_TULIP.get(), "");
    }
    private void makeLogWalls() {
        ModelFile postBig = this.makeWallPostModel(4, 16, "wooden_post_big");
        ModelFile postShort = this.makeWallPostModel(3, 14, "wooden_post_short");
        ModelFile postTall = this.makeWallPostModel(3, 16, "wooden_post_tall");

        ModelFile side = this.makeWallSideModel(5, 14, "wooden_side", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 5);
        ModelFile sideAlt = this.makeWallSideModel(5, 14, "wooden_side_alt", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 11, 16);
        ModelFile sideTall = this.makeWallSideModel(5, 16, "wooden_side_tall", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 5);
        ModelFile sideTallAlt = this.makeWallSideModel(5, 16, "wooden_side_tall_alt", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 11, 16);

        ModelFile sideShort = this.makeWallSideModel(4, 14, "wooden_side_short", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 4);
        ModelFile sideAltShort = this.makeWallSideModel(4, 14, "wooden_side_alt_short", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 12, 16);
        ModelFile sideTallShort = this.makeWallSideModel(4, 16, "wooden_side_tall_short", ModelBuilder.FaceRotation.CLOCKWISE_90, 0, 4);
        ModelFile sideTallAltShort = this.makeWallSideModel(4, 16, "wooden_side_tall_alt_short", ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90, 12, 16);

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
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    protected BlockModelBuilder makeWallPostModel(int width, int height, String name) {
        return models().withExistingParent(name, this.mcLoc("block/block"))
                .element().from(8 - width, 0.0F, 8 - width).to(8 + width, height, 8 + width)
                .face(Direction.DOWN).texture("#top").cullface(Direction.DOWN).end()
                .face(Direction.UP).texture("#top").cullface(Direction.UP).end()
                .face(Direction.NORTH).texture("#side").end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.EAST).texture("#side").end().end();
    }

    protected BlockModelBuilder makeWallSideModel(int length, int height, String name, ModelBuilder.FaceRotation faceRotation, int u1, int u2) {
        return models().withExistingParent(name, this.mcLoc("block/block"))
                .element().from(5.0F, 0.0F, 0.0F).to(11.0F, height, length)
                .face(Direction.DOWN).texture("#top").rotation(faceRotation).uvs(u1, 5, u2, 11).cullface(Direction.DOWN).end()
                .face(Direction.UP).texture("#top").rotation(faceRotation).uvs(u1, 5, u2, 11).end()
                .face(Direction.NORTH).texture("#side").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.EAST).texture("#side").end().end();
    }

    public void logWallBlock(WallBlock block, Block baseBlock, String location, String modid, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        this.logWallBlockInternal(block, this.name(block), new ResourceLocation(modid, "block/" + location + this.name(baseBlock)), postUsesTop, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }

    private void logWallBlockInternal(WallBlock block, String baseName, ResourceLocation texture, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        this.logWallBlock(
                this.getMultipartBuilder(block),
                models().getBuilder(baseName + "_post_short").parent(postShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_post_tall").parent(postTall).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side").parent(side).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_alt").parent(sideAlt).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall").parent(sideTall).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_alt").parent(sideTallAlt).texture("particle", texture).texture("top", texture).texture("side", texture)
        );

        this.logWallBlockWithPost(
                this.getMultipartBuilder(block),
                models().getBuilder(baseName + "_post").parent(postBig).texture("particle", texture).texture("top", postUsesTop ? (texture + "_top") : texture.toString()).texture("side", texture),
                models().getBuilder(baseName + "_side_short").parent(sideShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_alt_short").parent(sideAltShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_short").parent(sideTallShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_alt_short").parent(sideTallAltShort).texture("particle", texture).texture("top", texture).texture("side", texture)
        );
    }

    public void logWallBlock(MultiPartBlockStateBuilder builder, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt) {
        builder
                // Smaller post when West & East are both short while North & South being none
                .part().modelFile(postShort).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.LOW).condition(WallBlock.WEST_WALL, WallSide.LOW).end().end()
                // Taller thinner post when West & East are both tall while North & South being none
                .part().modelFile(postTall).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.TALL).condition(WallBlock.WEST_WALL, WallSide.TALL).end().end()
                // Rotated small post when West & East are both none while North & South are short
                .part().modelFile(postShort).rotationY(90).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.NONE).condition(WallBlock.NORTH_WALL, WallSide.LOW).condition(WallBlock.WEST_WALL, WallSide.NONE).condition(WallBlock.SOUTH_WALL, WallSide.LOW).end().end()
                // Rotated small post when West & East are both none while North & South are tall
                .part().modelFile(postTall).rotationY(90).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.NONE).condition(WallBlock.NORTH_WALL, WallSide.TALL).condition(WallBlock.WEST_WALL, WallSide.NONE).condition(WallBlock.SOUTH_WALL, WallSide.TALL).end().end();
        WALL_PROPS.entrySet().stream()
                .filter(e -> e.getKey().getAxis().isHorizontal())
                .forEach(e -> {
                    this.logWallSidePart(builder, side, sideAlt, e, WallSide.LOW, false);
                    this.logWallSidePart(builder, sideTall, sideTallAlt, e, WallSide.TALL, false);
                });
    }

    public void logWallBlockWithPost(MultiPartBlockStateBuilder builder, ModelFile postBig, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt) {
        builder
                // Big post for connections, typically including angled
                .part().modelFile(postBig).addModel()
                .condition(WallBlock.UP, true).end();
        WALL_PROPS.entrySet().stream()
                .filter(e -> e.getKey().getAxis().isHorizontal())
                .forEach(e -> {
                    this.logWallSidePart(builder, side, sideAlt, e, WallSide.LOW, true);
                    this.logWallSidePart(builder, sideTall, sideTallAlt, e, WallSide.TALL, true);
                });
    }

    private void logWallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, ModelFile modelAlt, Map.Entry<Direction, Property<WallSide>> entry, WallSide height, boolean hasPost) {
        int rotation = (((int) entry.getKey().toYRot()) + 180) % 360;
        builder.part()
                .modelFile(rotation < 180 ? model : modelAlt)
                .rotationY(rotation)
                .addModel()
                .condition(entry.getValue(), height).condition(WallBlock.UP, hasPost);
    }
}
