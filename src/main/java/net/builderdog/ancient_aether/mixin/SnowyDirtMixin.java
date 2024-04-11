package net.builderdog.ancient_aether.mixin;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SnowyDirtBlock.class)
public abstract class SnowyDirtMixin extends BlockMixin {
    @Inject(method = "getStateForPlacement", at = @At(value = "HEAD"), cancellable = true)
    protected void aa$getPlacedState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
    }
}
