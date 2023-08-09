package net.builderdog.ancient_aether.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherBlockStateProvider;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherBlockStateProvider extends AetherBlockStateProvider {
    public AncientAetherBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AncientAetherBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(AncientAetherBlocks.ENCHANTED_SENTRY_STONE);
        blockWithItem(AncientAetherBlocks.BLIGHTED_SENTRY_STONE);
        blockWithItem(AncientAetherBlocks.QUICKSTONE);
        blockWithItem(AncientAetherBlocks.QUICKSOIL_BRICKS);
        blockWithItem(AncientAetherBlocks.HIGHLANDS_PINE_PLANKS);
        blockWithItem(AncientAetherBlocks.SAKURA_PLANKS);
        blockWithItem(AncientAetherBlocks.HIGHLANDS_PINE_LEAVES);
        blockWithItem(AncientAetherBlocks.SAKURA_LEAVES);

        logBlock(((RotatedPillarBlock) AncientAetherBlocks.HIGHLANDS_PINE_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.HIGHLANDS_PINE_WOOD.get(), blockTexture(AncientAetherBlocks.HIGHLANDS_PINE_LOG.get()), blockTexture(AncientAetherBlocks.HIGHLANDS_PINE_LOG.get()));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highlands_pine_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highlands_pine_log_top"));
        axisBlock((RotatedPillarBlock) AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get(),new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highlands_pine_log"),
                new ResourceLocation(AncientAether.MOD_ID,"block/stripped_highlands_pine_log"));

        simpleBlockItem(AncientAetherBlocks.HIGHLANDS_PINE_LOG.get(), models().withExistingParent("ancient_aether:highlands_pine_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.HIGHLANDS_PINE_WOOD.get(), models().withExistingParent("ancient_aether:highlands_pine_wood","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get(), models().withExistingParent("ancient_aether:stripped_highlands_pine_log","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get(), models().withExistingParent("ancient_aether:stripped_highlands_pine_wood","minecraft:block/cube_column"));

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

        fence(AncientAetherBlocks.HIGHLANDS_PINE_FENCE.get(), AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.HIGHLANDS_PINE_FENCE_GATE.get(), AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get(), texture(name(AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR.get(), texture(name(AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.HIGHLANDS_PINE_BUTTON.get(), texture(name(AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.HIGHLANDS_PINE_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get()), ""));

        fence(AncientAetherBlocks.SAKURA_FENCE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        fenceGateBlock(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), AncientAetherBlocks.SAKURA_PLANKS.get(), "");
        doorBlock(AncientAetherBlocks.SAKURA_DOOR.get(), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_bottom"), texture(name(AncientAetherBlocks.SAKURA_DOOR.get()), "", "_top"));
        trapdoorBlock(AncientAetherBlocks.SAKURA_TRAPDOOR.get(), texture(name(AncientAetherBlocks.SAKURA_TRAPDOOR.get()), ""), false);
        buttonBlock(AncientAetherBlocks.SAKURA_BUTTON.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));
        pressurePlateBlock(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get(), texture(name(AncientAetherBlocks.SAKURA_PLANKS.get()), ""));

        crossBlock(AncientAetherBlocks.HIGHLANDS_PINE_SAPLING);
        crossBlock(AncientAetherBlocks.SAKURA_SAPLING);
        crossBlock(AncientAetherBlocks.MOONLIT_TULIP);
        crossBlock(AncientAetherBlocks.EDELWEISS);
        crossBlock(AncientAetherBlocks.SKYROOT_THORN_BUSH);
        crossBlock(AncientAetherBlocks.SAKURA_BLOSSOMS);
        crossBlock(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS);
        crossBlock(AncientAetherBlocks.SMALL_AETHER_CACTUS);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void crossBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
