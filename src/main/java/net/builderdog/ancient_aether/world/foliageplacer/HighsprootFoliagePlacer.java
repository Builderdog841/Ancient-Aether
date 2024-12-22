package net.builderdog.ancient_aether.world.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class HighsprootFoliagePlacer extends FoliagePlacer {

    public static final Codec<HighsprootFoliagePlacer> CODEC = RecordCodecBuilder.create((codec) -> foliagePlacerParts(codec)
            .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter((placer) -> placer.trunkHeight))
            .apply(codec, HighsprootFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public HighsprootFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        trunkHeight = height;
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter foliageSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos pos = attachment.pos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        boolean doubleTrunk = attachment.doubleTrunk();

        for (int i = offset; i >= offset - foliageHeight; --i) {
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 12, z), 14, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 10, z), 2, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 9, z), 12, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 7, z), 2, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 6, z), 9, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 4, z), 1, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 3, z), 6, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y - 1, z), 4, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, pos, 2, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y + 1, z), 1, i, doubleTrunk);
            placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x, y + 2, z), 0, i, doubleTrunk);

            if (random.nextBoolean()) {
                placeLeavesRow(level, foliageSetter, random, config, new BlockPos(x + random.nextIntBetweenInclusive(-1, 1), y - random.nextIntBetweenInclusive(13, 14), z + random.nextIntBetweenInclusive(-1, 1)), 3, i, doubleTrunk);
            }
        }
    }

    @Override
    public int foliageHeight(@NotNull RandomSource random, int height, @NotNull TreeConfiguration config) {
        return 1;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return Mth.square(localX) + Mth.square(localY + 2) + Mth.square(localZ) > range + random.nextInt(3);
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return AncientAetherFoliagePlacers.HIGHSPROOT_FOLIAGE_PLACER.get();
    }
}