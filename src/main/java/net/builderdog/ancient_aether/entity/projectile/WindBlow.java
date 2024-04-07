package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.client.particle.AetherParticleTypes;
import com.aetherteam.aether.item.EquipmentUtil;
import com.aetherteam.aether.mixin.mixins.common.accessor.PlayerAccessor;
import com.aetherteam.aether.network.AetherPacketHandler;
import com.aetherteam.aether.network.packet.clientbound.ZephyrSnowballHitPacket;
import com.aetherteam.nitrogen.network.PacketRelay;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class WindBlow extends Fireball implements ItemSupplier {
    private int ticksInAir;

    public WindBlow(EntityType<? extends WindBlow> type, Level level) {
        super(type, level);
        setNoGravity(true);
    }

    @Override
    public void tick() {
        if (!onGround()) {
            ++ticksInAir;
        }
        if (ticksInAir > AncientAetherConfig.COMMON.wind_blow_duration.get()) {
            if (!level().isClientSide()) {
                discard();
            }
        }
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
            level().addParticle(getTrailParticle(), d0, d1, d2, 0.0, 0.0, 0.0);
            setPos(d0, d1, d2);
        } else discard();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (ticksInAir > 1) {
            if (!level().isClientSide()) {
                discard();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        Entity entity = hitResult.getEntity();
        if (entity instanceof LivingEntity livingEntity && !EquipmentUtil.hasSentryBoots(livingEntity)) {
            if (livingEntity instanceof Player player && player.isBlocking()) {
                PlayerAccessor playerAccessor = (PlayerAccessor) player;
                playerAccessor.callHurtCurrentlyUsedShield(3.0F);
            } else {
                entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.5, entity.getDeltaMovement().z());
                entity.setDeltaMovement(entity.getDeltaMovement().x() + (getDeltaMovement().x() * 1.5), entity.getDeltaMovement().y(), entity.getDeltaMovement().z() + (getDeltaMovement().z() * 1.5));
                if (livingEntity instanceof ServerPlayer player) {
                    if (!level().isClientSide()) {
                        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new ZephyrSnowballHitPacket(livingEntity.getId(), getDeltaMovement().x(), getDeltaMovement().z()), player);
                    }
                }
            }
        }
        if (!level().isClientSide()) {
            discard();
        }
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected @NotNull ParticleOptions getTrailParticle() {
        return AetherParticleTypes.PASSIVE_WHIRLWIND.get();
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("TicksInAir", ticksInAir);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("TicksInAir")) {
            ticksInAir = tag.getInt("TicksInAir");
        }
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}