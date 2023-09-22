package net.builderdog.ancient_aether.world.feature;

import com.aetherteam.aether.world.BlockPlacementUtil;
import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.world.configuration.CoastConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class CoastFeature extends Feature<CoastConfiguration> {
    public CoastFeature(Codec<CoastConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<CoastConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        CoastConfiguration config = context.config();

        for(int x = pos.getX(); x < pos.getX() + 8; ++x) {
            for(int z = pos.getZ(); z < pos.getZ() + 8; ++z) {
                for(int y = config.yRange().getMinValue(); y < config.yRange().getMaxValue(); ++y) {
                    BlockPos placementPos = new BlockPos(x, y, z);
                    if (level.getBlockState(placementPos).isAir() && level.getBlockState(placementPos.above()).is(config.validBlocks()) && level.getBlockState(placementPos.above(4)).isAir()) {
                        BlockPlacementUtil.placeDisk(level, config.block(), placementPos, config.radius().sample(random), random);
                        break;
                    }
                }
            }
        }

        return true;
    }
}
