package net.builderdog.ancient_aether.datagen.providers;

import com.aetherteam.aether.data.providers.AetherBlockStateProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.*;

import java.util.Map;

public abstract class AncientAetherBlockStateProvider extends AetherBlockStateProvider {
    public AncientAetherBlockStateProvider(PackOutput output, String id, ExistingFileHelper helper) {
        super(output, id, helper);
    }

    protected BlockModelBuilder makeWallPostModel(int width, int height, String name) {
        return models().withExistingParent(name, mcLoc("block/block"))
                .element().from(8 - width, 0.0F, 8 - width).to(8 + width, height, 8 + width)
                .face(Direction.DOWN).texture("#top").cullface(Direction.DOWN).end()
                .face(Direction.UP).texture("#top").cullface(Direction.UP).end()
                .face(Direction.NORTH).texture("#side").end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.EAST).texture("#side").end().end();
    }

    protected BlockModelBuilder makeWallSideModel(int length, int height, String name, ModelBuilder.FaceRotation faceRotation, int u1, int u2) {
        return models().withExistingParent(name, mcLoc("block/block"))
                .element().from(5.0F, 0.0F, 0.0F).to(11.0F, height, length)
                .face(Direction.DOWN).texture("#top").rotation(faceRotation).uvs(u1, 5, u2, 11).cullface(Direction.DOWN).end()
                .face(Direction.UP).texture("#top").rotation(faceRotation).uvs(u1, 5, u2, 11).end()
                .face(Direction.NORTH).texture("#side").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH).texture("#side").end()
                .face(Direction.WEST).texture("#side").end()
                .face(Direction.EAST).texture("#side").end().end();
    }

    public void aabookshelf(Block block, Block endBlock) {
        ModelFile bookshelf = models().cubeColumn(name(block), this.texture(name(block)), texture(name(endBlock)));
        this.getVariantBuilder(block).partialState().addModels(new ConfiguredModel(bookshelf));
    }

    public void logWallBlock(WallBlock block, Block baseBlock, String location, String modid, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        logWallBlockInternal(block, name(block), new ResourceLocation(modid, "block/" + location + name(baseBlock)), postUsesTop, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }

    private void logWallBlockInternal(WallBlock block, String baseName, ResourceLocation texture, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        logWallBlock(
                getMultipartBuilder(block),
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
                    logWallSidePart(builder, side, sideAlt, e, WallSide.LOW, true);
                    logWallSidePart(builder, sideTall, sideTallAlt, e, WallSide.TALL, true);
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