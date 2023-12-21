package net.builderdog.ancient_aether.block.natural;

import com.aetherteam.aether.block.natural.AercloudBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VioletAercloudBlock extends AercloudBlock {
    protected static final VoxelShape COLLISION_SHAPE = Shapes.empty();

    public VioletAercloudBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isShiftKeyDown() && (!entity.isVehicle() || !(entity.getControllingPassenger() instanceof Player))) {
            entity.resetFallDistance();
            entity.setDeltaMovement(entity.getDeltaMovement().x(), -2.0, entity.getDeltaMovement().z());
            if (entity instanceof LivingEntity livingEntity && (!livingEntity.isFallFlying() && (!(entity instanceof Player player) || !player.getAbilities().flying))) {
                entity.setOnGround(true);
            } else if (!(entity instanceof Projectile)) {
                entity.setOnGround(false);
            }
        } else {
            super.entityInside(state, level, pos, entity);
        }
    }

    @Override
    public VoxelShape getDefaultCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }
}