package net.builderdog.ancient_aether.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import net.zepalesque.redux.util.math.MathUtil;
import net.zepalesque.redux.world.feature.config.CloudLayerConfig;

import java.util.List;

/**
 * Directly based on the Aether: Redux's CloudLayerFeature, with a few small tweaks to it
 */
public class CloudbedFeature extends Feature<CloudbedFeature.Config> {

    // Noise used to calculate the shape of the clouds
    public static final PerlinSimplexNoise base_noise = new PerlinSimplexNoise(new XoroshiroRandomSource(42), List.of(0, 1, 2, 3, 4));
    // Noise used to calculate a subtle rolling effect for the clouds
    public static final PerlinSimplexNoise y_offset = new PerlinSimplexNoise(new XoroshiroRandomSource(95), List.of(0, 1));

    public CloudbedFeature(Codec<Config> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Config> context) {
        int chunkX = context.origin().getX() - (context.origin().getX() % 16);
        int chunkZ = context.origin().getZ() - (context.origin().getZ() % 16);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                double scale = context.config().scaleXZ() * 0.00375;
                int xCoord = chunkX + x;
                int zCoord = chunkZ + z;
                double main = base_noise.getValue(xCoord * scale, zCoord * scale, false);
                double yOffset = y_offset.getValue(xCoord * scale * 0.75D, zCoord * scale * 0.75D, false);
                float offs = (float) Mth.lerp(Mth.inverseLerp(yOffset, -0.5, 0.5), 0D, 10D);
                if (main >= 0) {
                    double d1 = Mth.clamp(main, 0, 0.5) * 2;
                    float delta = costrp((float) d1, 0, 1);
                    float blocksUp = Mth.lerp(delta, 0F, 5F) + offs;
                    float blocksDown = Mth.lerp(delta, 0F, 4F) - offs;

                    for (int i = Mth.floor(-blocksDown); i <= Mth.floor(blocksUp); i++) {
                        int y = Mth.clamp(context.config().baseHeight() + i, context.level().getMinBuildHeight(), context.level().getMaxBuildHeight());
                        BlockPos pos = new BlockPos(xCoord, y, zCoord);
                        if (context.level().isStateAtPosition(pos, BlockBehaviour.BlockStateBase::isAir)) {
                            this.setBlock(context.level(), pos, context.config().block().getState(context.random(), pos));
                        }
                    }
                }
            }
        }
        return false;
    }

    /** Cosine interpolation from the Aether: Redux's MathUtil class, used to interpolate the cloud for a more rolling surface, like waves in the ocean */
    public static float costrp(float progress, float start, float end) {
        return (((-Mth.cos((float) (Math.PI * progress)) + 1F) * 0.5F) * (end - start)) + start;
    }

    public record Config(BlockStateProvider block, int baseHeight, double scaleXZ) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(
                (builder) -> builder.group(
                        BlockStateProvider.CODEC.fieldOf("block").forGetter(Config::block),
                        Codec.INT.fieldOf("base_height").forGetter(Config::baseHeight),
                        Codec.DOUBLE.fieldOf("xz_scale").forGetter(Config::scaleXZ)
                ).apply(builder, Config::new));

    }

}
