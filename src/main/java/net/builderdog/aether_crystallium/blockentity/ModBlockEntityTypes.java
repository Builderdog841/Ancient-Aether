package net.builderdog.aether_crystallium.blockentity;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<BlockEntityType<HighlandsPineSignBlockEntity>> HIGHLANDS_PINE_SIGN = BLOCK_ENTITY_TYPES.register("skyroot_sign", () ->
            BlockEntityType.Builder.of(HighlandsPineSignBlockEntity::new, ModBlocks.HIGHLANDS_PINE_WALL_SIGN.get(), ModBlocks.HIGHLANDS_PINE_SIGN.get()).build(null));

}