package net.builderdog.ancient_aether.block.natural;

import com.aetherteam.aether.event.AetherEventDispatch;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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

public class TrappedFlowerBlock extends BushBlock {
    private final Supplier<EntityType<?>> spawnableEntityTypeSupplier;
    private final Supplier<? extends BlockState> defaultStateSupplier;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public TrappedFlowerBlock(Supplier<EntityType<?>> spawnableEntityTypeSupplier, Supplier<? extends BlockState> defaultStateSupplier, Properties properties) {
        super(properties);
        this.spawnableEntityTypeSupplier = spawnableEntityTypeSupplier;
        this.defaultStateSupplier = defaultStateSupplier;
    }

    public BlockState getFacadeBlock() {
        return this.defaultStateSupplier.get();
    }

    @Override
    public void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Entity entity) {
        if (entity instanceof Player player && AetherEventDispatch.onTriggerTrap(player, level, blockPos, blockState)) {
            level.setBlockAndUpdate(blockPos, this.defaultStateSupplier.get());
            if (level instanceof ServerLevel serverLevel) {
                float yRot = player.getYRot() * Mth.DEG_TO_RAD;
                Vec3 targetVec = new Vec3(blockPos.getX() + 0.5 - Mth.sin(yRot) * 3, blockPos.getY() + 1, blockPos.getZ() + 0.5 + Mth.cos(yRot) * 3);
                ClipContext context = new ClipContext(player.position(), targetVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player);
                BlockHitResult hitResult = serverLevel.clip(context);
                BlockPos spawnPos = hitResult.getBlockPos();
                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    spawnPos = spawnPos.relative(hitResult.getDirection());
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("ancient_aether:roothyrn_trap"));
                    assert _adv != null;
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                this.spawnableEntityTypeSupplier.get().spawn(serverLevel, spawnPos, MobSpawnType.TRIGGERED);
                serverLevel.playSound(null, blockPos, AncientAetherSoundEvents.ROOTHYRN_EMERGES.get(), SoundSource.BLOCKS, 0.5F, level.getRandom().nextFloat() * 0.1F + 0.9F);
            }
        }
    }
    public @NotNull VoxelShape getShape(BlockState p_53517_, @NotNull BlockGetter p_53518_, @NotNull BlockPos p_53519_, @NotNull CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}
