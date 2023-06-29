package net.builderdog.aether_crystallium.blockentity;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.block.ModSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
            ModBlocks.HIGHLANDS_PINE_SIGN.get(), ModBlocks.HIGHLANDS_PINE_WALL_SIGN.get(),
            ModBlocks.SUNROOT_SIGN.get(), ModBlocks.SUNROOT_WALL_SIGN.get()
            ).build(null));

}