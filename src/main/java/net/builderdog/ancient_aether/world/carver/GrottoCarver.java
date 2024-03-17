package net.builderdog.ancient_aether.world.carver;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.world.carver.configuration.GrottoCarverConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Function;

@SuppressWarnings("deprecation")
public class GrottoCarver extends WorldCarver<GrottoCarverConfiguration> {

    public GrottoCarver(Codec<GrottoCarverConfiguration> codec) {
        super(codec);
    }

    public boolean isStartChunk(GrottoCarverConfiguration p_224894_, RandomSource p_224895_) {
        return p_224895_.nextFloat() <= p_224894_.probability;
    }

    public boolean carve(@NotNull CarvingContext context, @NotNull GrottoCarverConfiguration config, @NotNull ChunkAccess chunk, @NotNull Function<BlockPos, Holder<Biome>> biome, @NotNull RandomSource random, Aquifer aquifer, ChunkPos chunkPos, CarvingMask mask) {
        int i = SectionPos.sectionToBlockCoord(getRange() * 2 - 1);
        int j = random.nextInt(random.nextInt(random.nextInt(getCaveBound()) + 1) + 1);

        for(int k = 0; k < j; ++k) {
            double d0 = chunkPos.getBlockX(random.nextInt(16));
            double d1 = config.y.sample(random, context);
            double d2 = chunkPos.getBlockZ(random.nextInt(16));
            double d3 = config.horizontalRadiusMultiplier.sample(random);
            double d4 = config.verticalRadiusMultiplier.sample(random);
            double d5 = config.floorLevel.sample(random);
            CarveSkipChecker worldcarver$carveskipchecker = (p_159202_, p_159203_, p_159204_, p_159205_, p_159206_) -> shouldSkip(p_159203_, p_159204_, p_159205_, d5);
            int l = 1;
            if (random.nextInt(4) == 0) {
                double d6 = config.yScale.sample(random);
                float f1 = 1.0F + random.nextFloat() * 6.0F;
                createRoom(context, config, chunk, biome, aquifer, d0, d1, d2, f1, d6, mask, worldcarver$carveskipchecker);
                l += random.nextInt(4);
            }

            for(int k1 = 0; k1 < l; ++k1) {
                float f = random.nextFloat() * ((float)Math.PI * 2F);
                float f3 = (random.nextFloat() - 0.5F) / 4.0F;
                float f2 = getThickness(random);
                int i1 = i - random.nextInt(i / 4);
                int j1 = 0;
                createTunnel(context, config, chunk, biome, random.nextLong(), aquifer, d0, d1, d2, d3, d4, f2, f, f3, 0, i1, getYScale(), mask, worldcarver$carveskipchecker);
            }
        }
        return true;
    }

    protected int getCaveBound() {
        return 15;
    }

    protected float getThickness(RandomSource p_224871_) {
        float f = p_224871_.nextFloat() * 2.0F + p_224871_.nextFloat();
        if (p_224871_.nextInt(10) == 0) {
            f *= p_224871_.nextFloat() * p_224871_.nextFloat() * 3.0F + 1.0F;
        }
        return f;
    }

    protected double getYScale() {
        return 1.0D;
    }

    protected void createRoom(CarvingContext context, GrottoCarverConfiguration config, ChunkAccess p_190693_, Function<BlockPos, Holder<Biome>> p_190694_, Aquifer p_190695_, double p_190696_, double p_190697_, double p_190698_, float p_190699_, double p_190700_, CarvingMask p_190701_, WorldCarver.CarveSkipChecker p_190702_) {
        double d0 = 1.5D + (double)(Mth.sin(((float)Math.PI / 2F)) * p_190699_);
        double d1 = d0 * p_190700_;
        carveEllipsoid(context, config, p_190693_, p_190694_, p_190695_, p_190696_ + 1.0D, p_190697_, p_190698_, d0, d1, p_190701_, p_190702_);
    }

    protected void createTunnel(CarvingContext p_190671_, GrottoCarverConfiguration config, ChunkAccess p_190673_, Function<BlockPos, Holder<Biome>> p_190674_, long p_190675_, Aquifer p_190676_, double p_190677_, double p_190678_, double p_190679_, double p_190680_, double p_190681_, float p_190682_, float p_190683_, float p_190684_, int p_190685_, int p_190686_, double p_190687_, CarvingMask p_190688_, WorldCarver.CarveSkipChecker p_190689_) {
        RandomSource randomsource = RandomSource.create(p_190675_);
        int i = randomsource.nextInt(p_190686_ / 2) + p_190686_ / 4;
        boolean flag = randomsource.nextInt(6) == 0;
        float f = 0.0F;
        float f1 = 0.0F;

        for(int j = p_190685_; j < p_190686_; ++j) {
            double d0 = 1.5D + (double)(Mth.sin((float)Math.PI * (float)j / (float)p_190686_) * p_190682_);
            double d1 = d0 * p_190687_;
            float f2 = Mth.cos(p_190684_);
            p_190677_ += Mth.cos(p_190683_) * f2;
            p_190678_ += Mth.sin(p_190684_);
            p_190679_ += Mth.sin(p_190683_) * f2;
            p_190684_ *= flag ? 0.92F : 0.7F;
            p_190684_ += f1 * 0.1F;
            p_190683_ += f * 0.1F;
            f1 *= 0.9F;
            f *= 0.75F;
            f1 += (randomsource.nextFloat() - randomsource.nextFloat()) * randomsource.nextFloat() * 2.0F;
            f += (randomsource.nextFloat() - randomsource.nextFloat()) * randomsource.nextFloat() * 4.0F;
            if (j == i && p_190682_ > 1.0F) {
                createTunnel(p_190671_, config, p_190673_, p_190674_, randomsource.nextLong(), p_190676_, p_190677_, p_190678_, p_190679_, p_190680_, p_190681_, randomsource.nextFloat() * 0.5F + 0.5F, p_190683_ - ((float)Math.PI / 2F), p_190684_ / 3.0F, j, p_190686_, 1.0D, p_190688_, p_190689_);
                createTunnel(p_190671_, config, p_190673_, p_190674_, randomsource.nextLong(), p_190676_, p_190677_, p_190678_, p_190679_, p_190680_, p_190681_, randomsource.nextFloat() * 0.5F + 0.5F, p_190683_ + ((float)Math.PI / 2F), p_190684_ / 3.0F, j, p_190686_, 1.0D, p_190688_, p_190689_);
                return;
            }

            if (randomsource.nextInt(4) != 0) {
                if (!canReach(p_190673_.getPos(), p_190677_, p_190679_, j, p_190686_, p_190682_)) {
                    return;
                }
                carveEllipsoid(p_190671_, config, p_190673_, p_190674_, p_190676_, p_190677_, p_190678_, p_190679_, d0 * p_190680_, d1 * p_190681_, p_190688_, p_190689_);
            }
        }
    }

    private static boolean shouldSkip(double p_159196_, double p_159197_, double p_159198_, double p_159199_) {
        if (p_159197_ <= p_159199_) {
            return true;
        } else {
            return p_159196_ * p_159196_ + p_159197_ * p_159197_ + p_159198_ * p_159198_ >= 1.0D;
        }
    }

    protected boolean carveBlock(@NotNull CarvingContext context, @NotNull GrottoCarverConfiguration config, ChunkAccess chunk, @NotNull Function<BlockPos, Holder<Biome>> biome, @NotNull CarvingMask mask, BlockPos.@NotNull MutableBlockPos pos, BlockPos.@NotNull MutableBlockPos checkedPos, @NotNull Aquifer aquifer, @NotNull MutableBoolean reachedSurface) {
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

    protected static boolean isDebugEnabled(GrottoCarverConfiguration config) {
        return config.debugSettings.isDebugMode();
    }

    protected static BlockState getDebugState(GrottoCarverConfiguration config, BlockState state) {
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
        else return WATER.createLegacyBlock();
    }

    @Nullable
    private BlockState getCarveState(CarvingContext context, GrottoCarverConfiguration config, BlockPos pos, ChunkAccess chunk) {
        if (pos.getY() <= config.lavaLevel.resolveY(context)) {
            return getFluidState(pos, chunk);
        } else {
            BlockState air = Blocks.CAVE_AIR.defaultBlockState();
            return isDebugEnabled(config) ? getDebugState(config, air) : air;
        }
    }
}