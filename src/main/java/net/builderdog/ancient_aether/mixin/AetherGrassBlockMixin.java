package net.builderdog.ancient_aether.mixin;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.block.natural.AetherGrassBlock;
import com.aetherteam.aether.mixin.mixins.common.accessor.SpreadingSnowyDirtBlockAccessor;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AetherGrassBlock.class)
public abstract class AetherGrassBlockMixin extends SnowyDirtMixin {

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    public void aa$constructor(BlockBehaviour.Properties properties, CallbackInfo ci) {
        registerDefaultState(defaultBlockState().setValue(AncientBlockStateProperties.TYPE, AetherGrassType.NORMAL));
    }

    @Inject(method = "createBlockStateDefinition", at = @At(value = "TAIL"))
    protected void aa$defineState(StateDefinition.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(AncientBlockStateProperties.TYPE);
    }

    @Inject(method = "randomTick", at = @At(value = "HEAD"), cancellable = true)
    public void aa$tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (!SpreadingSnowyDirtBlockAccessor.callCanBeGrass(state, level, pos)) {
            if (!level.isAreaLoaded(pos, 3)) {
                ci.cancel();
                return;
            }
            level.setBlockAndUpdate(pos, AetherBlocks.AETHER_DIRT.get().defaultBlockState());
        }
        else {
            if (!level.isAreaLoaded(pos, 3)) ci.cancel();
            if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState blockstate = defaultBlockState().setValue(AncientBlockStateProperties.TYPE, state.getValue(AncientBlockStateProperties.TYPE));
                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (level.getBlockState(blockpos).is(AetherBlocks.AETHER_DIRT.get()) && SpreadingSnowyDirtBlockAccessor.callCanPropagate(blockstate, level, blockpos)) {
                        level.setBlockAndUpdate(blockpos, blockstate.setValue(AetherGrassBlock.SNOWY, level.getBlockState(blockpos.above()).is(Blocks.SNOW)));
                    }
                }
            }
        }
        ci.cancel();
    }

    @Override
    protected void aa$getPlacedState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        Holder<Biome> biome = context.getLevel().getBiome(context.getClickedPos());
        if (biome.is(AncientTags.Biomes.HAS_FROZEN_AETHER_GRASS)) {
            cir.setReturnValue(defaultBlockState().setValue(AncientBlockStateProperties.TYPE, AetherGrassType.FROZEN));
        }
        else if (biome.is(AncientTags.Biomes.HAS_PALE_AETHER_GRASS)) {
            cir.setReturnValue(defaultBlockState().setValue(AncientBlockStateProperties.TYPE, AetherGrassType.PALE));
        }
        else if (biome.is(AncientTags.Biomes.HAS_ENCHANTED_AETHER_GRASS)) {
            cir.setReturnValue(defaultBlockState().setValue(AncientBlockStateProperties.TYPE, AetherGrassType.ENCHANTED));
        }
        else cir.setReturnValue(defaultBlockState().setValue(AncientBlockStateProperties.TYPE, AetherGrassType.NORMAL));
    }
}