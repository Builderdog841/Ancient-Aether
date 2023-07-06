package net.builderdog.ancient_aether.datagen;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherBlockStateProvider extends BlockStateProvider {
    public AncientAetherBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AncientAether.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AncientAetherBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(AncientAetherBlocks.ENCHANTED_SENTRY_STONE);
        blockWithItem(AncientAetherBlocks.QUICKSTONE);
        blockWithItem(AncientAetherBlocks.BLIGHTED_SENTRY_STONE);
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

        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CHISELED_HOLYSTONE_BRICKS.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CHISELED_CARVED_STONE.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CHISELED_ANGELIC_STONE.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CHISELED_HELLFIRE_STONE.get()));
        logBlock(((RotatedPillarBlock) AncientAetherBlocks.CHISELED_GALE_STONE.get()));

        simpleBlockItem(AncientAetherBlocks.CHISELED_HOLYSTONE_BRICKS.get(), models().withExistingParent("ancient_aether:chiseled_holystone_bricks","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CHISELED_CARVED_STONE.get(), models().withExistingParent("ancient_aether:chiseled_carved_stone","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CHISELED_ANGELIC_STONE.get(), models().withExistingParent("ancient_aether:chiseled_angelic_stone","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CHISELED_HELLFIRE_STONE.get(), models().withExistingParent("ancient_aether:chiseled_hellfire_stone","minecraft:block/cube_column"));
        simpleBlockItem(AncientAetherBlocks.CHISELED_GALE_STONE.get(), models().withExistingParent("ancient_aether:chiseled_gale_stone","minecraft:block/cube_column"));


        saplingBlock(AncientAetherBlocks.HIGHLANDS_PINE_SAPLING);
        saplingBlock(AncientAetherBlocks.SAKURA_SAPLING);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
        models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
