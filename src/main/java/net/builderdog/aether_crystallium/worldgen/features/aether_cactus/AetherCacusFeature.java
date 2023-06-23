package net.builderdog.aether_crystallium.worldgen.features.aether_cactus;

import com.mojang.serialization.Codec;
import net.builderdog.aether_crystallium.worldgen.configurations.LargeCactusConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;

public abstract class AetherCacusFeature extends Feature<LargeCactusConfiguration> {


    public AetherCacusFeature(Codec<LargeCactusConfiguration> p_65786_) {
        super(p_65786_);
    }

    protected void placeSquare(WorldGenLevel level, int size, BlockPos pos, BlockState state) {

        //Centers the Square
        int offset = (int) ((size/2)+0.5);

        for(int i = 0; i < size; i++) {
            for (int y = 0; y < size; y++) {
                this.setBlock(level, pos.relative(Direction.Axis.X,  i-offset).relative(Direction.Axis.Z, y-offset), state);
                    
            }
        }
    }

    //Places A Small 3x3 Circle
    protected void placeSmallCircle(WorldGenLevel level, BlockPos pos, BlockState state) {
        this.setBlock(level, pos, state);
        this.setBlock(level, pos.north(), state);
        this.setBlock(level, pos.west(), state);
        this.setBlock(level, pos.east(), state); 
        this.setBlock(level, pos.south(), state);
    }


    //protected boolean setBlock(WorldGenLevel level, BlockPos pos, BlockState state) {
    //    if(level.isEmptyBlock(pos)) {
    //        this.setBlock(level, pos, state);
    //        return true;
    //    }
    //    else return false;
    //}
}