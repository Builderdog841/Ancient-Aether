package net.builderdog.ancient_aether.mixin.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public abstract class BlockMixin {

    @Shadow public abstract BlockState defaultBlockState();

    @Shadow
    protected abstract void registerDefaultState(BlockState state);
}