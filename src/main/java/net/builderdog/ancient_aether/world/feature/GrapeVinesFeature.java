package net.builderdog.ancient_aether.world.feature;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GrapeVinesFeature extends Feature<NoneFeatureConfiguration> {
    public GrapeVinesFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> config) {
        WorldGenLevel level = config.level();
        BlockPos pos = config.origin();
        BlockPos z = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);

        config.config();
        if (level.isEmptyBlock(pos)) {
            for (Direction direction : Direction.values()) {
                BlockState state = config.level().getBlockState(z.relative(direction));

                if (direction != Direction.DOWN && VineBlock.isAcceptableNeighbour(level, pos.relative(direction), direction) && state.is(AncientAetherTags.Blocks.GRAPE_VINE_CAN_SPAWN_ON)) {
                    level.setBlock(pos, AncientAetherBlocks.GRAPE_VINE.get().defaultBlockState().setValue(VineBlock.getPropertyForFace(direction), Boolean.TRUE), 2);
                    return true;
                }
            }
        }
        return false;
    }
}