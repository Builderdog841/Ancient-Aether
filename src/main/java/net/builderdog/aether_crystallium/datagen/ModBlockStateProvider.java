package net.builderdog.aether_crystallium.datagen;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AetherCrystallium.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AETHER_QUARTZ_ORE);
        blockWithItem(ModBlocks.ENCHANTED_SENTRY_STONE);
        blockWithItem(ModBlocks.QUICKSTONE);
        blockWithItem(ModBlocks.BLIGHTED_SENTRY_STONE);
        blockWithItem(ModBlocks.QUICKSOIL_BRICKS);
        blockWithItem(ModBlocks.HIGHLANDS_PINE_PLANKS);
        blockWithItem(ModBlocks.HIGHLANDS_PINE_LEAVES);
        blockWithItem(ModBlocks.SUNROOT_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.HIGHLANDS_PINE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.HIGHLANDS_PINE_WOOD.get(), blockTexture(ModBlocks.HIGHLANDS_PINE_LOG.get()), blockTexture(ModBlocks.HIGHLANDS_PINE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get(),new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_highlands_pine_log"),
                new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_highlands_pine_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get(),new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_highlands_pine_log"),
                new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_highlands_pine_log"));

        simpleBlockItem(ModBlocks.HIGHLANDS_PINE_LOG.get(), models().withExistingParent("aether_crystallium:highlands_pine_log","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.HIGHLANDS_PINE_WOOD.get(), models().withExistingParent("aether_crystallium:highlands_pine_wood","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get(), models().withExistingParent("aether_crystallium:stripped_highlands_pine_log","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get(), models().withExistingParent("aether_crystallium:stripped_highlands_pine_wood","minecraft:block/cube_column"));

        saplingBlock(ModBlocks.HIGHLANDS_PINE_SAPLING);
        saplingBlock(ModBlocks.SUNROOT_SAPLING);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
        models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
