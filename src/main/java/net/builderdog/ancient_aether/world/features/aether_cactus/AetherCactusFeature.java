package net.builderdog.ancient_aether.world.features.aether_cactus;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.world.configurations.LargeCactusConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;

public abstract class AetherCactusFeature extends Feature<LargeCactusConfiguration> {


    public AetherCactusFeature(Codec<LargeCactusConfiguration> p_65786_) {
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
    protected boolean checkSquare(WorldGenLevel level, int size, BlockPos pos) {

        //Centers the Square
        int offset = (int) ((size/2)+0.5);

        for(int i = 0; i < size; i++) {
            for (int y = 0; y < size; y++) {
                if(!level.isEmptyBlock(pos.relative(Direction.Axis.X,  i-offset).relative(Direction.Axis.Z, y-offset))) return false;
            }
        }
        return true;
    }

    protected boolean checkSquareFilled(WorldGenLevel level, int size, BlockPos pos) {

        //Centers the Square
        int offset = (int) ((size/2)+0.5);

        for(int i = 0; i < size; i++) {
            for (int y = 0; y < size; y++) {
                if(level.isEmptyBlock(pos.relative(Direction.Axis.X,  i-offset).relative(Direction.Axis.Z, y-offset))) return false;
            }
        }
        return true;
    }

    //Places A Small 3x3 Circle
    protected void placeSmallCircle(WorldGenLevel level, BlockPos pos, BlockState state) {
        this.setBlock(level, pos, state);
        this.setBlock(level, pos.north(), state);
        this.setBlock(level, pos.west(), state);
        this.setBlock(level, pos.east(), state); 
        this.setBlock(level, pos.south(), state);
    }
}