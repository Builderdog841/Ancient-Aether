package net.builderdog.ancient_aether.block.blocktype;

import com.mojang.serialization.MapCodec;
import net.builderdog.ancient_aether.block.blockstate.AncientBlockStateProperties;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class GrapeVineBlock extends Block implements BonemealableBlock {
    public static final MapCodec<GrapeVineBlock> CODEC = simpleCodec(GrapeVineBlock::new);
    public static final BooleanProperty CROPPED = AncientBlockStateProperties.CROPPED;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final DirectionProperty FACING = LadderBlock.FACING;
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    public GrapeVineBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(CROPPED, false).setValue(AGE, 0));
    }

    @Override
    protected @NotNull MapCodec<? extends GrapeVineBlock> codec() {
        return CODEC;
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            default -> EAST_AABB;
        };
    }

    private boolean canAttachTo(BlockGetter getter, BlockPos pos, Direction direction) {
        BlockState blockstate = getter.getBlockState(pos);
        return blockstate.isFaceSturdy(getter, pos, direction);
    }

    public boolean canSurvive(BlockState state, @NotNull LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        return canAttachTo(level, pos.relative(direction.getOpposite()), direction);
    }

    public @NotNull BlockState updateShape(BlockState thisState, Direction direction, @NotNull BlockState state, @NotNull LevelAccessor accessor, @NotNull BlockPos thisPos, @NotNull BlockPos pos) {
        if (direction.getOpposite() == thisState.getValue(FACING) && !thisState.canSurvive(accessor, thisPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(thisState, direction, state, accessor, thisPos, pos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (!context.replacingClickedOnBlock()) {
            BlockState state = context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace().getOpposite()));
            if (state.is(this) && state.getValue(FACING) == context.getClickedFace()) {
                return null;
            }
        }

        BlockState state = defaultBlockState();
        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        for(Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                state = state.setValue(FACING, direction.getOpposite());
                if (state.canSurvive(level, pos)) {
                    return state;
                }
            }
        }
        return null;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 2 && !state.getValue(CROPPED);
    }

    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack(AncientItems.GRAPES.get());
    }

    public void randomTick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        int i = state.getValue(AGE);
        if (i < 2 && level.getRawBrightness(pos.above(), 0) >= 9 && CommonHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
            BlockState blockstate = state.setValue(AGE, i + 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            CommonHooks.onCropsGrowPost(level, pos, state);
        }
    }

    public @NotNull InteractionResult use(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 2;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL) && player.getItemInHand(hand).canPerformAction(ToolActions.SHEARS_CARVE)) {
            return InteractionResult.PASS;
        }
        if (i > 1) {
            int j = 1 + level.random.nextInt(1);
            popResource(level, pos, new ItemStack(AncientItems.GRAPES.get(), j + (flag ? 1 : 0)));
            BlockState age = state.setValue(AGE, 1);
            level.setBlock(pos, age, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, age));
            level.playSound(null, pos, AncientSoundEvents.BLOCK_GRAPE_VINE_PICK_GRAPES.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        if (player.getItemInHand(hand).canPerformAction(ToolActions.SHEARS_CARVE)) {
            if (!state.getValue(CROPPED)) {
                level.gameEvent(player, GameEvent.SHEAR, pos);
                player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
                BlockState cut = state.setValue(CROPPED, true);
                level.setBlock(pos, cut, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, cut));
                level.playSound(null, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state) {
        return state.getValue(AGE) < 2;
    }

    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, BlockState state) {
        int i = Math.min(2, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, i), 2);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CROPPED).add(AGE).add(FACING);
    }
}