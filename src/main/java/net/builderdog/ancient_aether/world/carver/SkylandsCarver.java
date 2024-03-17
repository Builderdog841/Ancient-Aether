package net.builderdog.ancient_aether.world.carver;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
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

    protected boolean carveBlock(@NotNull CarvingContext context, @NotNull CaveCarverConfiguration config, ChunkAccess chunk, @NotNull Function<BlockPos, Holder<Biome>> biome, @NotNull CarvingMask mask, BlockPos.@NotNull MutableBlockPos pos, BlockPos.@NotNull MutableBlockPos checkedPos, @NotNull Aquifer aquifer, @NotNull MutableBoolean reachedSurface) {
        BlockState state = chunk.getBlockState(pos);
        if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MYCELIUM)) {
            reachedSurface.setTrue();
        }

        if (!canReplaceBlock(config, state) && !isDebugEnabled(config)) {
            return false;
        } else {
            BlockState carveState = getCarveState(context, config, pos, chunk);
            if (carveState == null) {
                return false;
            } else {
                chunk.setBlockState(pos, carveState, false);
                if (aquifer.shouldScheduleFluidUpdate() && !carveState.getFluidState().isEmpty()) {
                    chunk.markPosForPostprocessing(pos);
                }

                if (reachedSurface.isTrue()) {
                    checkedPos.setWithOffset(pos, Direction.DOWN);
                    if (chunk.getBlockState(checkedPos).is(Blocks.DIRT)) {
                        context.topMaterial(biome, chunk, checkedPos, !carveState.getFluidState().isEmpty()).ifPresent((bool) -> {
                            chunk.setBlockState(checkedPos, bool, false);
                            if (!bool.getFluidState().isEmpty()) {
                                chunk.markPosForPostprocessing(checkedPos);
                            }
                        });
                    }
                }
                return true;
            }
        }
    }

    protected static boolean isDebugEnabled(CarverConfiguration config) {
        return config.debugSettings.isDebugMode();
    }

    protected static BlockState getDebugState(CarverConfiguration config, BlockState state) {
        if (state.is(Blocks.AIR)) {
            return config.debugSettings.getAirState();
        }
        else if (state.is(Blocks.WATER)) {
            BlockState waterState = config.debugSettings.getWaterState();
            return waterState.hasProperty(BlockStateProperties.WATERLOGGED) ? waterState.setValue(BlockStateProperties.WATERLOGGED, true) : waterState;
        } else {
            return state.is(Blocks.LAVA) ? config.debugSettings.getLavaState() : state;
        }
    }

    private BlockState getFluidState(BlockPos pos, ChunkAccess chunk) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos pos1 = new BlockPos(x + 1, y, z);
        BlockPos pos2 = new BlockPos(x, y, z + 1);
        BlockPos pos3 = new BlockPos(x - 1, y, z);
        BlockPos pos4 = new BlockPos(x, y, z - 1);
        BlockPos pos5 = new BlockPos(x, y - 1, z);

        if (chunk.getBlockState(pos1) == Blocks.AIR.defaultBlockState()) {
            return AetherFeatureStates.HOLYSTONE;
        }
        if (chunk.getBlockState(pos2) == Blocks.AIR.defaultBlockState()) {
            return AetherFeatureStates.HOLYSTONE;
        }
        if (chunk.getBlockState(pos3) == Blocks.AIR.defaultBlockState()) {
            return AetherFeatureStates.HOLYSTONE;
        }
        if (chunk.getBlockState(pos4) == Blocks.AIR.defaultBlockState()) {
            return AetherFeatureStates.HOLYSTONE;
        }
        if (chunk.getBlockState(pos5) == Blocks.AIR.defaultBlockState()) {
            return AetherFeatureStates.HOLYSTONE;
        }
        else return WATER.createLegacyBlock();
    }

    @Nullable
    private BlockState getCarveState(CarvingContext context, CarverConfiguration config, BlockPos pos, ChunkAccess chunk) {
        if (pos.getY() <= config.lavaLevel.resolveY(context)) {
            return getFluidState(pos, chunk);
        } else {
            BlockState air = Blocks.CAVE_AIR.defaultBlockState();
            return isDebugEnabled(config) ? getDebugState(config, air) : air;
        }
    }
}