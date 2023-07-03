package net.builderdog.ancient_aether.blockentity;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<BlockEntityType<net.builderdog.ancient_aether.blockentity.AncientAetherSignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () -> BlockEntityType.Builder.of(AncientAetherSignBlockEntity::new,
            AncientAetherBlocks.HIGHLANDS_PINE_SIGN.get(), AncientAetherBlocks.HIGHLANDS_PINE_WALL_SIGN.get(),
            AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()
            ).build(null));

}