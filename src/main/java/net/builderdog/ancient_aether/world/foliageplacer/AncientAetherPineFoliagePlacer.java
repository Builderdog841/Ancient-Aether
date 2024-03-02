package net.builderdog.ancient_aether.world.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class AncientAetherPineFoliagePlacer extends FoliagePlacer {

    public static final Codec<AncientAetherPineFoliagePlacer> CODEC = RecordCodecBuilder.create((codec) -> foliagePlacerParts(codec)
            .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter((placer) -> placer.trunkHeight))
            .apply(codec, AncientAetherPineFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public AncientAetherPineFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        trunkHeight = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return AncientAetherFoliagePlacers.ANCIENT_AETHER_PINE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter setter, @NotNull RandomSource random, @NotNull TreeConfiguration configuration, int maxTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockpos = attachment.pos();
        int i = 0;
        int j = 2;
        int k = 1;

        if (foliageHeight % 2 != 0) {
            j -= 1;
        }

        for (int l = offset; l >= -foliageHeight; --l) {
            this.placeLeavesRow(level, setter, random, configuration, blockpos, i, l, attachment.doubleTrunk());
            if (i >= j) {
                i = k;
                j = Math.min(j + 1, foliageRadius + attachment.radiusOffset());
            } else {
                ++i;
            }
        }
    }

    @Override
    public int foliageHeight(@NotNull RandomSource random, int height, @NotNull TreeConfiguration configuration) {
        int value = height - this.trunkHeight.sample(random);
        return Math.max(3, value);
    }

    @Override
    protected boolean shouldSkipLocation(@NotNull RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localX + localX + localZ + localZ > range + 2;
    }
}