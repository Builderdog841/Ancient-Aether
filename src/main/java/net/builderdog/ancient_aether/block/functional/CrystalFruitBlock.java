package net.builderdog.ancient_aether.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrystalFruitBlock extends Block {
    public CrystalFruitBlock(Properties properties) {
        super(properties);
    }
    public boolean canSurvive(@NotNull BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return !levelReader.isEmptyBlock(blockPos.above());
    }
}
