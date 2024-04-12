package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.zepalesque.redux.block.util.state.ReduxStates;
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
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(AncientAetherBlockStateProperties.LENGTH) - 1);
    }

    public SkyGrassBlock(Properties properties) {
        super(properties);
    }

    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, BlockState state) {
        int i = Math.min(5, state.getValue(LENGTH) + Mth.nextInt(level.random, 1, 3));
        BlockState blockstate = state.setValue(LENGTH, i);
        level.setBlock(pos, blockstate, 2);
        if (i == 5) {
            blockstate.randomTick(level, pos, level.random);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return state(level, currentPos, super.updateShape(state, facing, facingState, level, currentPos, facingPos));
    }

    public static BlockState state(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockState below = level.getBlockState(pos.below());
        if (state.hasProperty(TYPE)) {
            if (below.is(AetherBlocks.ENCHANTED_AETHER_GRASS_BLOCK.get())) {
                return state.setValue(ReduxStates.ENCHANTED, true);
            } else if (below.hasProperty(TYPE)) {
                return state.setValue(TYPE, below.getValue(TYPE));
            }
            else return stateBase(level, pos, state);
        }

        return state;
    }
    public static BlockState stateBase(LevelAccessor level, BlockPos pos, BlockState state) {
        Holder<Biome> biome = level.getBiome(pos);
            if (biome.is(AncientAetherTags.Biomes.HAS_FROZEN_AETHER_GRASS)) {
                return state.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.FROZEN);
            } else if (biome.is(AncientAetherTags.Biomes.HAS_PALE_AETHER_GRASS)) {
                return state.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.PALE);
            } else if (biome.is(AncientAetherTags.Biomes.HAS_ENCHANTED_AETHER_GRASS)) {
                return state.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.ENCHANTED);
            } else return state.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.NORMAL);
    }

    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
        return state.getValue(LENGTH) < 5;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return state(context.getLevel(), context.getClickedPos(), defaultBlockState());
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(LENGTH);
        blockBlockStateBuilder.add(TYPE);
    }
}