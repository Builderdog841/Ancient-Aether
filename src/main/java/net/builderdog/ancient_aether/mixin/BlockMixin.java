package net.builderdog.ancient_aether.mixin;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {

    @Shadow public abstract BlockState defaultBlockState();

    @Shadow
    protected abstract void registerDefaultState(BlockState state);

    @Inject(method = "getStateForPlacement", at = @At(value = "HEAD"), cancellable = true)
    protected void aa$getPlacedState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {}

}
