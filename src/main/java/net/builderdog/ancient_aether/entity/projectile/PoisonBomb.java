package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.mixin.mixins.common.accessor.PlayerAccessor;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class PoisonBomb extends Fireball {

    public PoisonBomb(EntityType<? extends PoisonBomb> type, Level level) {
        super(type, level);
        setNoGravity(false);
    }

    public PoisonBomb(Level level, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(AncientAetherEntityTypes.POISON_BOMB.get(), shooter, accelX, accelY, accelZ, level);
        setNoGravity(false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick() {
        if (level().isClientSide() || (getOwner() == null || getOwner().isAlive()) && level().hasChunkAt(blockPosition())) {
            HitResult hitResult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitResult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitResult)) {
                onHit(hitResult);
            }

            checkInsideBlocks();
            Vec3 vec3 = getDeltaMovement();
            double d0 = getX() + vec3.x();
            double d1 = getY() + vec3.y();
            double d2 = getZ() + vec3.z();
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f = getInertia();
            if (isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    level().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x() * 0.25, d1 - vec3.y() * 0.25, d2 - vec3.z() * 0.25, vec3.x(), vec3.y(), vec3.z());
                }
                f = 0.8F;
            }
            setDeltaMovement(vec3.add(xPower, yPower, zPower).scale(f));
            setPos(d0, d1, d2);
        }
        else discard();
    }

    @Override
    protected void onHit(@NotNull HitResult hitResult) {
        super.onHit(hitResult);
        if (!level().isClientSide()) {
            AreaEffectCloud areaEffectCloud = EntityType.AREA_EFFECT_CLOUD.create(level());
            if (areaEffectCloud != null) {
                areaEffectCloud.setPos(getX(), getY(), getZ());
                areaEffectCloud.setRadius(2.0F);
                areaEffectCloud.setDuration(300);
                areaEffectCloud.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 60, 1));
                level().addFreshEntity(areaEffectCloud);
            }
            discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        Entity entity = hitResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof Player player && player.isBlocking()) {
                PlayerAccessor playerAccessor = (PlayerAccessor) player;
                playerAccessor.callHurtCurrentlyUsedShield(3.0F);
            }
        }
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}