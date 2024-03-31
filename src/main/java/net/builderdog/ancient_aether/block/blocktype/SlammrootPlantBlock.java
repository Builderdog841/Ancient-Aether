package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.monster.Slammroot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class SlammrootPlantBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);

    public SlammrootPlantBlock(Properties properties) {
        super(properties);
    }

    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        spawnSlammroot(level, pos);
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        if(entity instanceof Player) {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            spawnSlammroot(level, pos);
        }
    }

    public void spawnSlammroot(@NotNull Level level, @NotNull BlockPos pos) {
        Slammroot slammroot = new Slammroot(AncientAetherEntityTypes.SLAMMROOT.get(), level);
        slammroot.setPos(pos.getX() + 0.5, pos.getY() + 0.25, pos.getZ() + 0.5);
        level.addFreshEntity(slammroot);
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}