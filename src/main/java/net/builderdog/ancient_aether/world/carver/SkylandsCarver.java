package net.builderdog.ancient_aether.world.carver;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Function;

@SuppressWarnings("deprecation")
public class SkylandsCarver extends CaveWorldCarver {

    public SkylandsCarver(Codec<CaveCarverConfiguration> codec) {
        super(codec);
    }

    protected boolean carveBlock(@NotNull CarvingContext pContext, @NotNull CaveCarverConfiguration config, ChunkAccess chunk, @NotNull Function<BlockPos, Holder<Biome>> biome, @NotNull CarvingMask mask, BlockPos.@NotNull MutableBlockPos pos, BlockPos.@NotNull MutableBlockPos checkedPos, @NotNull Aquifer aquifer, @NotNull MutableBoolean reachedSurface) {
        BlockState blockstate = chunk.getBlockState(pos);
        if (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.MYCELIUM)) {
            reachedSurface.setTrue();
        }

        if (!canReplaceBlock(config, blockstate) && !isDebugEnabled(config)) {
            return false;
        } else {
            BlockState blockstate1 = getCarveState(pContext, config, pos);
            if (blockstate1 == null) {
                return false;
            } else {
                chunk.setBlockState(pos, blockstate1, false);
                if (aquifer.shouldScheduleFluidUpdate() && !blockstate1.getFluidState().isEmpty()) {
                    chunk.markPosForPostprocessing(pos);
                }

                if (reachedSurface.isTrue()) {
                    checkedPos.setWithOffset(pos, Direction.DOWN);
                    if (chunk.getBlockState(checkedPos).is(Blocks.DIRT)) {
                        pContext.topMaterial(biome, chunk, checkedPos, !blockstate1.getFluidState().isEmpty()).ifPresent((p_272572_) -> {
                            chunk.setBlockState(checkedPos, p_272572_, false);
                            if (!p_272572_.getFluidState().isEmpty()) {
                                chunk.markPosForPostprocessing(checkedPos);
                            }

                        });
                    }
                }

                return true;
            }
        }
    }

    protected static boolean isDebugEnabled(CarverConfiguration pConfig) {
        return pConfig.debugSettings.isDebugMode();
    }

    protected static BlockState getDebugState(CarverConfiguration config, BlockState state) {
        if (state.is(Blocks.AIR)) {
            return config.debugSettings.getAirState();
        } else if (state.is(Blocks.WATER)) {
            BlockState waterState = config.debugSettings.getWaterState();
            return waterState.hasProperty(BlockStateProperties.WATERLOGGED) ? waterState.setValue(BlockStateProperties.WATERLOGGED, true) : waterState;
        } else {
            return state.is(Blocks.LAVA) ? config.debugSettings.getLavaState() : state;
        }
    }

    @Nullable
    private BlockState getCarveState(CarvingContext context, CarverConfiguration config, BlockPos pos) {
        if (pos.getY() <= config.lavaLevel.resolveY(context)) {
            return Blocks.WATER.defaultBlockState();
        } else {
            BlockState air = Blocks.CAVE_AIR.defaultBlockState();
            return isDebugEnabled(config) ? getDebugState(config, air) : air;
        }
    }
}