package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.miscellaneous.FloatingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class AtmosineCrystalBlock extends FloatingBlock {
    public static final BooleanProperty DOUBLE_DROPS = AetherBlockStateProperties.DOUBLE_DROPS;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 6.0D, 4.0D, 16.0D, 11.0D, 12.0D);
    public AtmosineCrystalBlock(boolean powered, Properties properties) {
        super(powered, properties);
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(DOUBLE_DROPS);
    }
}