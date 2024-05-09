package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.Floatable;
import com.aetherteam.aether.entity.block.FloatingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class AtmosineCrystalBlock extends Block implements Floatable {
    public static final BooleanProperty DOUBLE_DROPS = AetherBlockStateProperties.DOUBLE_DROPS;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 6.0D, 4.0D, 16.0D, 11.0D, 12.0D);
    public AtmosineCrystalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        level.scheduleTick(pos, this, getDelayAfterPlace());
    }

    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState facingState, LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
        level.scheduleTick(pos, this, getDelayAfterPlace());
        return super.updateShape(state, direction, facingState, level, pos, facingPos);
    }

    @Override
    public void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        super.tick(state, level, pos, random);
        if (((pos.getY() <= level.getMaxBuildHeight())) && isFree(level.getBlockState(pos.above()))) {
            FloatingBlockEntity floatingBlockEntity = new FloatingBlockEntity(level, (double) pos.getX() + 0.5, pos.getY(), (double) pos.getZ() + 0.5, level.getBlockState(pos));
            level.addFreshEntity(floatingBlockEntity);
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            floating();
            floatingBlockEntity.setNatural(false);
        }
        else level.scheduleTick(pos, this, getDelayAfterPlace());
    }

    protected void floating() {
    }

    public static boolean isFree(BlockState state) {
        return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(DOUBLE_DROPS);
    }
}