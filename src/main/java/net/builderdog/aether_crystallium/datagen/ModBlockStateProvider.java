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
        blockWithItem(ModBlocks.CRYSTAL_GOLD_BLOCK);
        blockWithItem(ModBlocks.RAW_CRYSTAL_GOLD_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_GOLD_ORE);
        blockWithItem(ModBlocks.ENCHANTED_SENTRY_STONE);
        blockWithItem(ModBlocks.BLIGHTED_SENTRY_STONE);
        blockWithItem(ModBlocks.QUICKSOIL_BRICKS);
        blockWithItem(ModBlocks.FROSTPINE_PLANKS);
        blockWithItem(ModBlocks.FROSTPINE_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.FROSTPINE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.FROSTPINE_WOOD.get(), blockTexture(ModBlocks.FROSTPINE_LOG.get()), blockTexture(ModBlocks.FROSTPINE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_FROSTPINE_LOG.get(),new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_frostpine_log"),
                new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_frostpine_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_FROSTPINE_WOOD.get(),new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_frostpine_log"),
                new ResourceLocation(AetherCrystallium.MOD_ID,"block/stripped_frostpine_log"));

        simpleBlockItem(ModBlocks.FROSTPINE_LOG.get(), models().withExistingParent("aether_crystallium:frostpine_log","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.FROSTPINE_WOOD.get(), models().withExistingParent("aether_crystallium:frostpine_wood","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_FROSTPINE_LOG.get(), models().withExistingParent("aether_crystallium:stripped_frostpine_log","minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_FROSTPINE_WOOD.get(), models().withExistingParent("aether_crystallium:stripped_frostpine_wood","minecraft:block/cube_column"));

        saplingBlock(ModBlocks.FROSTPINE_SAPLING);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
        models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
