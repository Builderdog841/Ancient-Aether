package net.builderdog.ancient_aether.world.feature;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.block.blocktype.SkyGrassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class SkyGrassFeature extends Feature<SimpleBlockConfiguration> {
    public SkyGrassFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
        SimpleBlockConfiguration simpleblockconfiguration = context.config();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        BlockState state = simpleblockconfiguration.toPlace().getState(context.random(), origin);
        if (state.hasProperty(SkyGrassBlock.TYPE) && state.getBlock() instanceof SkyGrassBlock) {
            state = SkyGrassBlock.state(level, origin, state);
        }
        if (state.canSurvive(level, origin)) {
            if (state.getBlock() instanceof DoublePlantBlock) {
                if (!level.isEmptyBlock(origin.above())) {
                    return false;
                }
                DoublePlantBlock.placeAt(level, state, origin, 2);
            } else {
                level.setBlock(origin, state, 2);
            }
            return true;
        } else {
            return false;
        }
    }
}
