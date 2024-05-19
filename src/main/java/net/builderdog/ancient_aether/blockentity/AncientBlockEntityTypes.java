package net.builderdog.ancient_aether.blockentity;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientBlockEntityTypes extends BlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AncientAether.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientSignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () ->
            BlockEntityType.Builder.of(AncientSignBlockEntity::new,
                    AncientBlocks.HIGHSPROOT_SIGN.get(), AncientBlocks.HIGHSPROOT_WALL_SIGN.get(),
                    AncientBlocks.SAKURA_SIGN.get(), AncientBlocks.SAKURA_WALL_SIGN.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITY_TYPES.register("hanging_sign", () ->
            BlockEntityType.Builder.of(AncientHangingSignBlockEntity::new,
                    AncientBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(),
                    AncientBlocks.SAKURA_HANGING_SIGN.get(), AncientBlocks.SAKURA_WALL_HANGING_SIGN.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITY_TYPES.register("campfire", () ->
            BlockEntityType.Builder.of(AncientCampfireBlockEntity::new, AncientBlocks.AMBROSIUM_CAMPFIRE.get()
    ).build(null));


    public AncientBlockEntityTypes(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
        super(blockEntity, pos, state);
    }
}