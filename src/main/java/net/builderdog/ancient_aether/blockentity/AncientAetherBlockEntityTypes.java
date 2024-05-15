package net.builderdog.ancient_aether.blockentity;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherBlockEntityTypes extends BlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AncientAether.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientAetherSignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () ->
            BlockEntityType.Builder.of(AncientAetherSignBlockEntity::new,
                    AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get(),
                    AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientAetherHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITY_TYPES.register("hanging_sign", () ->
            BlockEntityType.Builder.of(AncientAetherHangingSignBlockEntity::new,
                    AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(),
                    AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientAetherCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITY_TYPES.register("campfire", () ->
            BlockEntityType.Builder.of(AncientAetherCampfireBlockEntity::new, AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()
    ).build(null));


    public AncientAetherBlockEntityTypes(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
        super(blockEntity, pos, state);
    }
}