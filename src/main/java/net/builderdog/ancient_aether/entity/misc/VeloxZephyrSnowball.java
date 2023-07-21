package net.builderdog.ancient_aether.entity.misc;

import com.aetherteam.aether.client.particle.AetherParticleTypes;
import com.aetherteam.aether.entity.AetherEntityTypes;

import com.aetherteam.aether.entity.monster.PassiveWhirlwind;
import com.aetherteam.aether.mixin.mixins.common.accessor.PlayerAccessor;
import com.aetherteam.aether.network.AetherPacketHandler;
import com.aetherteam.aether.network.packet.client.ZephyrSnowballHitPacket;
import com.aetherteam.aether.util.EquipmentUtil;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class VeloxZephyrSnowball extends Fireball implements ItemSupplier {
    private int ticksInAir;

    public VeloxZephyrSnowball(EntityType<? extends VeloxZephyrSnowball> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
    }

    public VeloxZephyrSnowball(Level level, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(AncientAetherEntities.VELOX_ZEPHYR_SNOWBALL.get(), shooter, accelX, accelY, accelZ, level);
        this.setNoGravity(true);
    }

    /**
     * Warning for "deprecation" is suppressed because vanilla calls {@link Level#hasChunkAt(BlockPos)} just fine.
     */
    @SuppressWarnings("deprecation")
    @Override
    public void tick() {
        if (!this.onGround) {
            ++this.ticksInAir;
        }
        if (this.ticksInAir > 400) {
            this.discard();
        }
        if (this.level.isClientSide || (this.getOwner() == null || this.getOwner().isAlive()) && this.level.hasChunkAt(this.blockPosition())) {
            HitResult hitResult = ProjectileUtil.getHitResult(this, this::canHitEntity);
            if (hitResult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitResult)) {
                this.onHit(hitResult);
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f = this.getInertia();
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.level.addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25, d1 - vec3.y * 0.25, d2 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }
                f = 0.8F;
            }

            this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale(f));
            this.level.addParticle(this.getTrailParticle(), d0, d1 + 0.5, d2, 0.0, 0.0, 0.0);
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        LevelAccessor world = this.level;
        double x = blockHitResult.getBlockPos().getX();
        double y = blockHitResult.getBlockPos().getY();
        double z = blockHitResult.getBlockPos().getZ();
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = new PassiveWhirlwind(AetherEntityTypes.WHIRLWIND.get(), _level);
                entityToSpawn.moveTo(x, y + 1, z, 0, 0);
                entityToSpawn.setYBodyRot(0);
                entityToSpawn.setYHeadRot(0);
                entityToSpawn.setDeltaMovement(0, 0, 0);
                if (entityToSpawn instanceof Mob _mobToSpawn)
                    _mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                _level.addFreshEntity(entityToSpawn);
            }
        }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Nonnull
    @Override
    protected ParticleOptions getTrailParticle() {
        return AetherParticleTypes.ZEPHYR_SNOWFLAKE.get();
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.SNOWBALL);
    }

    @Nonnull
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}