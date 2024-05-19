package net.builderdog.ancient_aether.world.tree.decorator;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.block.blocktype.GrapeVineBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class GrapeVineDecorator extends TreeDecorator {
    public static final Codec<GrapeVineDecorator> CODEC =
            BlockState.CODEC.fieldOf("block").xmap(GrapeVineDecorator::new, (instance) -> instance.state).codec();

    private final BlockState state;

    public GrapeVineDecorator(BlockState state) {
        this.state = state;
    }

    public void placeGrapeVine(Context context, BlockPos pos, BlockState state) {
        RandomSource random = context.random();
        int age = random.nextIntBetweenInclusive(0, 2);
        context.setBlock(pos, state.setValue(GrapeVineBlock.AGE, age));
    }

    public void place(Context context) {
        RandomSource random = context.random();
        context.logs().forEach((pos) -> {
            if (random.nextInt(3) > 0) {
                BlockPos pos1 = pos.north();
                if (context.isAir(pos1)) {
                    placeGrapeVine(context, pos1, state.setValue(GrapeVineBlock.FACING, Direction.NORTH));
                }
            }
            if (random.nextInt(3) > 0) {
                BlockPos pos2 = pos.east();
                if (context.isAir(pos2)) {
                    placeGrapeVine(context, pos2, state.setValue(GrapeVineBlock.FACING, Direction.EAST));
                }
            }
            if (random.nextInt(3) > 0) {
                BlockPos pos3 = pos.south();
                if (context.isAir(pos3)) {
                    placeGrapeVine(context, pos3, state.setValue(GrapeVineBlock.FACING, Direction.SOUTH));
                }
            }
            if (random.nextInt(3) > 0) {
                BlockPos pos4 = pos.west();
                if (context.isAir(pos4)) {
                    placeGrapeVine(context, pos4, state.setValue(GrapeVineBlock.FACING, Direction.WEST));
                }
            }
        });
    }

    protected @NotNull TreeDecoratorType<?> type() {
        return AncientTreeDecorators.GRAPE_VINE_DECORATOR.get();
    }
}