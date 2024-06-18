package net.builderdog.ancient_aether.mixin.common;

import com.aetherteam.aether.entity.monster.dungeon.boss.Slider;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Slider.class)
public class SliderMixin {

    @Inject(at = @At(value = "HEAD"), method = "convertBlock", remap = false, cancellable = true)
    protected void onConvertBlock(BlockState state, CallbackInfoReturnable<BlockState> cir) {
        if (state.is(AncientAetherBlocks.LOCKED_CARVED_TILES.get())) {
            cir.setReturnValue(AncientAetherBlocks.CARVED_TILES.get().defaultBlockState());
        }
        if (state.is(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get())) {
            cir.setReturnValue(AncientAetherBlocks.CARVED_STONE_MOSAIC.get().defaultBlockState().setValue(BlockStateProperties.AXIS, state.getValue(BlockStateProperties.AXIS)));
        }
    }
}