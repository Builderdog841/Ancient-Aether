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

public class HookedCrystalFoliagePlacer extends FoliagePlacer {
    public static final Codec<HookedCrystalFoliagePlacer> CODEC = RecordCodecBuilder.create((codec) -> foliagePlacerParts(codec)
            .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter((placer) -> placer.trunkHeight))
            .apply(codec, HookedCrystalFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public HookedCrystalFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.trunkHeight = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return AncientAetherFoliagePlacerTypes.HOOKED_CRYSTAL_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, FoliagePlacer.@NotNull FoliageSetter setter, @NotNull RandomSource random, @NotNull TreeConfiguration configuration, int maxTreeHeight, FoliagePlacer.FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockpos = attachment.pos();
        this.placeLeavesRow(level, setter, random, configuration, blockpos, attachment.radiusOffset(), 0, attachment.doubleTrunk());
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