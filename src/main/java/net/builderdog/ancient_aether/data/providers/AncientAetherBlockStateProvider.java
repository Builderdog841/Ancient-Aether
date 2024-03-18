package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.block.dungeon.DoorwayBlock;
import com.aetherteam.aether.data.providers.AetherBlockStateProvider;
import net.builderdog.ancient_aether.block.blocktype.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Objects;

public abstract class AncientAetherBlockStateProvider extends AetherBlockStateProvider {
    public AncientAetherBlockStateProvider(PackOutput output, String id, ExistingFileHelper helper) {
        super(output, id, helper);
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void crossBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void translucentDoorBlock(DoorBlock block, ResourceLocation bottom, ResourceLocation top) {
        doorBlockWithRenderType(block, bottom, top, "translucent");
    }

    public void translucentTrapdoorBlock(TrapDoorBlock block, ResourceLocation texture, boolean orientable) {
        trapdoorBlockWithRenderType(block, texture, orientable, "translucent");
    }

    public void AABookshelf(Block block, Block endBlock) {
        ModelFile bookshelf = models().cubeColumn(name(block), texture(name(block)), texture(name(endBlock)));
        getVariantBuilder(block).partialState().addModels(new ConfiguredModel(bookshelf));
    }

    public void lantern(Block block) {
        BlockModelBuilder lantern = models().withExistingParent(name(block), mcLoc("template_lantern")).texture("lantern", texture(name(block))).renderType("cutout");
        BlockModelBuilder hangingLantern = models().withExistingParent("hanging_" + name(block), mcLoc("template_hanging_lantern")).texture("lantern", texture(name(block))).renderType("cutout");
        getVariantBuilder(block).forAllStates((state -> ConfiguredModel.builder().modelFile(state.getValue(LanternBlock.HANGING) ? hangingLantern : lantern).build()));
    }

    public void carpet(Block block, Block baseBlock) {
        simpleBlock(block, models().singleTexture(name(block), mcLoc("block/carpet"), "wool", texture(name(baseBlock))));
    }

    public void vase(Block block) {
        ModelFile vase = models().withExistingParent(name(block), modLoc("block/template_vase"))
                .texture("vase", texture(name(block))).renderType("cutout");

        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction direction = state.getValue(VaseBlock.FACING);
            switch (direction) {
                case NORTH -> {
                    return ConfiguredModel.builder().modelFile(vase).build();
                }
                case EAST -> {
                    return ConfiguredModel.builder().modelFile(vase).rotationY(90).build();
                }
                case SOUTH -> {
                    return ConfiguredModel.builder().modelFile(vase).rotationY(180).build();
                }
                case WEST -> {
                    return ConfiguredModel.builder().modelFile(vase).rotationY(270).build();
                }
            }
            return ConfiguredModel.builder().build();
        });
    }

    public void ancientVase(Block block, Block blockCopy) {
        ModelFile ancientVase = models().withExistingParent(name(block), modLoc("block/template_vase")).texture("vase", texture(name(blockCopy))).renderType("cutout");

        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction direction = state.getValue(AncientVaseBlock.FACING);
            switch (direction) {
                case NORTH -> {
                    return ConfiguredModel.builder().modelFile(ancientVase).build();
                }
                case EAST -> {
                    return ConfiguredModel.builder().modelFile(ancientVase).rotationY(90).build();
                }
                case SOUTH -> {
                    return ConfiguredModel.builder().modelFile(ancientVase).rotationY(180).build();
                }
                case WEST -> {
                    return ConfiguredModel.builder().modelFile(ancientVase).rotationY(270).build();
                }
            }
            return ConfiguredModel.builder().build();
        });
    }

    public BlockModelBuilder cubePuffed(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west) {
        return models().withExistingParent(name, modLoc("cube_puffed"))
                .texture("down", down)
                .texture("up", up)
                .texture("north", north)
                .texture("south", south)
                .texture("east", east)
                .texture("west", west);
    }

    public void windBlower(Block block) {
        String blockName = name(block);
        ResourceLocation down =  extend(texture(name(block)), "_bottom");
        ResourceLocation up =  extend(texture(name(block)), "_top");
        ResourceLocation north =  extend(texture(name(block)), "_front");
        ResourceLocation south =  extend(texture(name(block)), "_back");
        ResourceLocation east =  extend(texture(name(block)), "_side_left");
        ResourceLocation west =  extend(texture(name(block)), "_side_right");
        ResourceLocation down_puffed =  extend(texture(name(block)), "_bottom_puffed");
        ResourceLocation up_puffed =  extend(texture(name(block)), "_top_puffed");
        ResourceLocation north_puffed =  extend(texture(name(block)), "_front_puffed");
        ResourceLocation south_puffed =  extend(texture(name(block)), "_back_puffed");
        ResourceLocation east_puffed =  extend(texture(name(block)), "_side_left_puffed");
        ResourceLocation west_puffed =  extend(texture(name(block)), "_side_right_puffed");

        ModelFile normal = models().cube(blockName, down, up, north, south, east, west).renderType("translucent").texture("particle", down);
        ModelFile charged = cubePuffed(blockName + "_puffed", down_puffed, up_puffed, north_puffed, south_puffed, east_puffed, west_puffed).renderType("translucent").texture("particle", down_puffed);
        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction direction = state.getValue(WindBlowerBlock.FACING);
            if (state.getValue(WindBlowerBlock.PUFFED))
                switch (direction) {
                    case NORTH -> {
                        return ConfiguredModel.builder().modelFile(charged).build();
                    }
                    case SOUTH -> {
                        return ConfiguredModel.builder().modelFile(charged).rotationY(180).build();
                    }
                    case WEST -> {
                        return ConfiguredModel.builder().modelFile(charged).rotationY(270).build();
                    }
                    case EAST -> {
                        return ConfiguredModel.builder().modelFile(charged).rotationY(90).build();
                    }
                }
            else
                switch (direction) {
                    case NORTH -> {
                        return ConfiguredModel.builder().modelFile(normal).build();
                    }
                    case SOUTH -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(180).build();
                    }
                    case WEST -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(270).build();
                    }
                    case EAST -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(90).build();
                    }
                }
            return ConfiguredModel.builder().build();
        });
    }


    public void sliderPrototype(Block block) {
        ResourceLocation template = modLoc("block/template_slider_prototype");
        ModelFile normal = models().withExistingParent(name(block), template).texture("slider", texture(name(block)));
        ModelFile critical = models().withExistingParent(name(block) + "_critical", template).texture("slider", texture(name(block) + "_critical"));

        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction direction = state.getValue(SliderPrototypeBlock.FACING);
            if (state.getValue(SliderPrototypeBlock.CRITICAL))
                switch (direction) {
                    case NORTH -> {
                        return ConfiguredModel.builder().modelFile(critical).build();
                    }
                    case EAST -> {
                        return ConfiguredModel.builder().modelFile(critical).rotationY(90).build();
                    }
                    case SOUTH -> {
                        return ConfiguredModel.builder().modelFile(critical).rotationY(180).build();
                    }
                    case WEST -> {
                        return ConfiguredModel.builder().modelFile(critical).rotationY(270).build();
                    }
                }
            else
                switch (direction) {
                    case NORTH -> {
                        return ConfiguredModel.builder().modelFile(normal).build();
                    }
                    case EAST -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(90).build();
                    }
                    case SOUTH -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(180).build();
                    }
                    case WEST -> {
                        return ConfiguredModel.builder().modelFile(normal).rotationY(270).build();
                    }
                }
            return ConfiguredModel.builder().build();
        });
    }

    public void grapeVine(Block block) {
        getVariantBuilder(block).forAllStatesExcept((state) -> {
            int age = state.getValue(GrapeVineBlock.AGE);
            ModelFile vine = models().withExistingParent(name(block) + "_stage" + age, modLoc("block/template_grape_vine"))
                    .texture("vine", texture(name(block) + "_stage" + age)).renderType("cutout_mipped");

            Direction direction = state.getValue(GrapeVineBlock.FACING);
            return ConfiguredModel.builder().modelFile(vine).rotationY((int) (direction.toYRot() + 180) % 360).build();
        });
    }

    public void obelisk(Block block) {
        ModelFile obelisk = models().withExistingParent(name(block), modLoc("block/template_obelisk"))
                .texture("obelisk", texture(name(block))).renderType("translucent");

        getVariantBuilder(block).partialState().addModels(new ConfiguredModel(obelisk));
    }

    public void AADungeonBlock(Block block, Block baseBlock) {
        ConfiguredModel dungeonBlock = new ConfiguredModel(models().cubeAll(name(baseBlock), texture(name(baseBlock))));
        getVariantBuilder(block).partialState().setModels(dungeonBlock);
    }

    public void lockedMosaicBlock(RotatedPillarBlock block, RotatedPillarBlock baseBlock) {
        ModelFile mosaicBlock = models().getExistingFile(modLoc("block/" + name(baseBlock)));
        ModelFile mosaicBlockHorizontal = models().getExistingFile(modLoc("block/" + name(baseBlock) + "_horizontal"));

        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction.Axis axis = state.getValue(RotatedPillarBlock.AXIS);
            switch (axis) {
                case X -> {
                    return ConfiguredModel.builder().modelFile(mosaicBlockHorizontal).rotationX(90).rotationY(90).build();
                }
                case Y -> {
                    return ConfiguredModel.builder().modelFile(mosaicBlock).build();
                }
                case Z -> {
                    return ConfiguredModel.builder().modelFile(mosaicBlockHorizontal).rotationX(90).build();
                }
            }
            return ConfiguredModel.builder().build();
        });
    }

    public void AAInvisibleBlock(Block block, Block baseBlock) {
        ModelFile visible = models().cubeAll(name(baseBlock), texture(name(baseBlock)));
        ModelFile invisible = models().getBuilder(name(block));
        getVariantBuilder(block).forAllStatesExcept((state) -> !(Boolean)state.getValue(DoorwayBlock.INVISIBLE) ? ConfiguredModel.builder().modelFile(visible).build() : ConfiguredModel.builder().modelFile(invisible).build());
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

    public void logWallBlock(WallBlock block, Block baseBlock, String location, String modid, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        logWallBlockInternal(block, name(block), new ResourceLocation(modid, "block/" + location + name(baseBlock)), postUsesTop, postBig, postShort, postTall, side, sideAlt, sideTall, sideTallAlt, sideShort, sideAltShort, sideTallShort, sideTallAltShort);
    }

    private void logWallBlockInternal(WallBlock block, String baseName, ResourceLocation texture, boolean postUsesTop, ModelFile postBig, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt, ModelFile sideShort, ModelFile sideAltShort, ModelFile sideTallShort, ModelFile sideTallAltShort) {
        logWallBlock(getMultipartBuilder(block),
                models().getBuilder(baseName + "_post_short").parent(postShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_post_tall").parent(postTall).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side").parent(side).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_alt").parent(sideAlt).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall").parent(sideTall).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_alt").parent(sideTallAlt).texture("particle", texture).texture("top", texture).texture("side", texture)
        );
        logWallBlockWithPost(getMultipartBuilder(block),
                models().getBuilder(baseName + "_post").parent(postBig).texture("particle", texture).texture("top", postUsesTop ? (texture + "_top") : texture.toString()).texture("side", texture),
                models().getBuilder(baseName + "_side_short").parent(sideShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_alt_short").parent(sideAltShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_short").parent(sideTallShort).texture("particle", texture).texture("top", texture).texture("side", texture),
                models().getBuilder(baseName + "_side_tall_alt_short").parent(sideTallAltShort).texture("particle", texture).texture("top", texture).texture("side", texture)
        );
    }

    public void logWallBlock(MultiPartBlockStateBuilder builder, ModelFile postShort, ModelFile postTall, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt) {
        builder.part().modelFile(postShort).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.LOW).condition(WallBlock.WEST_WALL, WallSide.LOW).end().end()
                .part().modelFile(postTall).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.TALL).condition(WallBlock.WEST_WALL, WallSide.TALL).end().end()
                .part().modelFile(postShort).rotationY(90).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.NONE).condition(WallBlock.NORTH_WALL, WallSide.LOW).condition(WallBlock.WEST_WALL, WallSide.NONE).condition(WallBlock.SOUTH_WALL, WallSide.LOW).end().end()
                .part().modelFile(postTall).rotationY(90).addModel()
                .nestedGroup().condition(WallBlock.UP, false).condition(WallBlock.EAST_WALL, WallSide.NONE).condition(WallBlock.NORTH_WALL, WallSide.TALL).condition(WallBlock.WEST_WALL, WallSide.NONE).condition(WallBlock.SOUTH_WALL, WallSide.TALL).end().end();
        WALL_PROPS.entrySet().stream()
                .filter(e -> e.getKey().getAxis().isHorizontal())
                .forEach(e -> {
                    logWallSidePart(builder, side, sideAlt, e, WallSide.LOW, false);
                    logWallSidePart(builder, sideTall, sideTallAlt, e, WallSide.TALL, false);
                });
    }

    public void logWallBlockWithPost(MultiPartBlockStateBuilder builder, ModelFile postBig, ModelFile side, ModelFile sideAlt, ModelFile sideTall, ModelFile sideTallAlt) {
        builder.part().modelFile(postBig).addModel()
                .condition(WallBlock.UP, true).end();WALL_PROPS.entrySet().stream()
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