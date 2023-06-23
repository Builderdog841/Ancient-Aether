package net.builderdog.aether_crystallium.worldgen.features.aether_cactus;

import com.mojang.serialization.Codec;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.worldgen.configurations.LargeCactusConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jetbrains.annotations.NotNull;

public class LargeCatusFeature extends AetherCacusFeature {


    public LargeCatusFeature(Codec<LargeCactusConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<LargeCactusConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        LargeCactusConfiguration config = context.config();

        //Block from the configured feature
        BlockState blockState = config.blockstate().getState(random, pos);

        //Random Number Between 2 and 3 (not 2 and 4)
        int MaxHeight = random.nextInt(2, 4);

        //Placement


        //Checks if position is Empty and Filled one block below
        if(!checkSquare(level, 3, pos)) return false;
        if(!checkSquareFilled(level, 3,pos.below())) return false;

        //Current Height During Placement
        int i;
        //Places the base 3x3 cube of the Cactus.
        for (i = 0; i < MaxHeight; i++) {
            this.placeSquare(level, 3, pos.above(i), blockState);
        }

        //places top 3x3 circle
        this.placeSmallCircle(level, pos.above(i), blockState);

        //Places Cactus Flower At top
        i++;
        this.setBlock(level, pos.above(i), ModBlocks.CACTUS_FLOWER.get().defaultBlockState());

        //Success
        return true;
    }


}