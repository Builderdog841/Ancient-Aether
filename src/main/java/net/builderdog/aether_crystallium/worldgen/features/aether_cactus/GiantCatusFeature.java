package net.builderdog.aether_crystallium.worldgen.features.aether_cactus;

import com.mojang.serialization.Codec;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.worldgen.configurations.LargeCactusConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jetbrains.annotations.NotNull;

public class GiantCatusFeature extends AetherCacusFeature {
    public GiantCatusFeature(Codec<LargeCactusConfiguration> codec) {
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

        //Placement

        //Current Height During Placement
        int i ;



        //Places the base 7x7 base circle of the Cactus. Has a random height between 2 and 3.
        for(i = 0; i < random.nextInt(2,4); i++) {
            this.placeLargerCircle(level, pos.above(i), blockState);
        }

        //places 5x5 square
        this.placeSquare(level,5,pos.above(i), blockState);
        i++;

        this.placeLargeCircle(level, pos.above(i), blockState);
        i++;

        this.placeSquare(level,3, pos.above(i), blockState);

        //places top plant with a 50% chance
        if(random.nextBoolean()) {
            i++;
            this.setBlock(level, pos.above(i), ModBlocks.CACTUS_FLOWER.get().defaultBlockState());
        }

        //Success
        return true;
    }


    //Places a 5x5 circle
    public void placeLargeCircle(WorldGenLevel level, BlockPos pos, BlockState state) {
        this.placeSquare(level, 3, pos, state);

        this.setBlock(level, pos.north(2).east(), state);
        this.setBlock(level, pos.north(2), state);
        this.setBlock(level, pos.north(2).west(), state);

        this.setBlock(level, pos.south(2).east(), state);
        this.setBlock(level, pos.south(2), state);
        this.setBlock(level, pos.south(2).west(), state);

        this.setBlock(level, pos.east(2).south(), state);
        this.setBlock(level, pos.east(2), state);
        this.setBlock(level, pos.east(2).north(), state);

        this.setBlock(level, pos.west(2).south(), state);
        this.setBlock(level, pos.west(2), state);
        this.setBlock(level, pos.west(2).north(), state);
    }
    //Places a 7x7 circle
    public void placeLargerCircle(WorldGenLevel level, BlockPos pos, BlockState state) {
        this.placeSquare(level, 5, pos, state);

        this.setBlock(level, pos.north(3).east(), state);
        this.setBlock(level, pos.north(3), state);
        this.setBlock(level, pos.north(3).west(), state);

        this.setBlock(level, pos.south(3).east(), state);
        this.setBlock(level, pos.south(3), state);
        this.setBlock(level, pos.south(3).west(), state);

        this.setBlock(level, pos.east(3).south(), state);
        this.setBlock(level, pos.east(3), state);
        this.setBlock(level, pos.east(3).north(), state);

        this.setBlock(level, pos.west(3).south(), state);
        this.setBlock(level, pos.west(3), state);
        this.setBlock(level, pos.west(3).north(), state);
    }

}