package net.builderdog.ancient_aether.world.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class CrystalFoliagePlacer extends FoliagePlacer {
    public static final Codec<CrystalFoliagePlacer> CODEC = RecordCodecBuilder.create((codec) -> foliagePlacerParts(codec)
            .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter((placer) -> placer.trunkHeight))
            .apply(codec, CrystalFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public CrystalFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.trunkHeight = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return AncientAetherFoliagePlacerTypes.CRYSTAL_FOLIAGE_PLACER.get();
    }


    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter foliageSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, int maxFreeTreeHeight, @NotNull FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        for (int i = offset; i >= offset - foliageHeight; --i) {
            this.placeLeavesRow(level, foliageSetter, random, config, attachment.pos(), 3, i, attachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(@NotNull RandomSource random, int height, @NotNull TreeConfiguration config) {
        return 3;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return Mth.square(localX) + Mth.square(localY + 2) + Mth.square(localZ) > 12 + random.nextInt(5);
    }
}