package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SkyGrassBlock extends TallGrassBlock {
    public static final IntegerProperty LENGTH = AncientAetherBlockStateProperties.LENGTH;
    public static final EnumProperty<AetherGrassType> TYPE = AncientAetherBlockStateProperties.TYPE;

    public static final List<VoxelShape> SHAPES = List.of(
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D)
    );

    @Override
    @NotNull
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // If this has out of bounds errors try removing the '- 1'
        return SHAPES.get(state.getValue(AncientAetherBlockStateProperties.LENGTH) - 1);
    }

    public SkyGrassBlock(Properties properties) {
        super(properties);
    }

    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, BlockState state) {
        int i = Math.min(5, state.getValue(LENGTH) + Mth.nextInt(level.random, 1, 3));
        BlockState blockstate = state.setValue(LENGTH, i);
        level.setBlock(pos, blockstate, 2);
        if (i == 5) {
            blockstate.randomTick(level, pos, level.random);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().below());
        if (blockstate.getBlock() == AetherBlocks.AETHER_GRASS_BLOCK.get()) {
            return defaultBlockState().setValue(TYPE, blockstate.getValue(TYPE));
        } else if (blockstate.getBlock() == AetherBlocks.ENCHANTED_AETHER_GRASS_BLOCK.get()) {
            return defaultBlockState().setValue(TYPE, AetherGrassType.ENCHANTED);
        } else
        return defaultBlockState();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(LENGTH);
        blockBlockStateBuilder.add(TYPE);
    }
}