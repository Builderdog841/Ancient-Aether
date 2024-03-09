package net.builderdog.ancient_aether.block.blocktype;

import com.aetherteam.aether.event.AetherEventDispatch;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@Deprecated
public class TrappedFlowerBlock extends BushBlock {
    private final Supplier<EntityType<?>> spawnableEntityTypeSupplier;
    private final Supplier<? extends BlockState> defaultStateSupplier;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public TrappedFlowerBlock(Supplier<EntityType<?>> spawnableEntityTypeSupplier, Supplier<? extends BlockState> defaultStateSupplier, Properties properties) {
        super(properties);
        this.spawnableEntityTypeSupplier = spawnableEntityTypeSupplier;
        this.defaultStateSupplier = defaultStateSupplier;
    }

    @Override
    public void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Entity entity) {
        if (entity instanceof Player player && AetherEventDispatch.onTriggerTrap(player, level, blockPos, blockState)) {
            level.setBlockAndUpdate(blockPos, defaultStateSupplier.get());
            if (level instanceof ServerLevel serverLevel) {
                float yRot = player.getYRot() * Mth.DEG_TO_RAD;
                Vec3 targetVec = new Vec3(blockPos.getX() + 0.5 - Mth.sin(yRot) * 3, blockPos.getY() + 1, blockPos.getZ() + 0.5 + Mth.cos(yRot) * 3);
                ClipContext context = new ClipContext(player.position(), targetVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player);
                BlockHitResult hitResult = serverLevel.clip(context);
                BlockPos spawnPos = hitResult.getBlockPos();
                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    spawnPos = spawnPos.relative(hitResult.getDirection());
                }
                spawnableEntityTypeSupplier.get().spawn(serverLevel, spawnPos, MobSpawnType.TRIGGERED);
            }
        }
    }

    public @NotNull VoxelShape getShape(BlockState p_53517_, @NotNull BlockGetter p_53518_, @NotNull BlockPos p_53519_, @NotNull CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}