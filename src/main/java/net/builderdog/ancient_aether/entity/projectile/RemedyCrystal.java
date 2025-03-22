package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.client.particle.AetherParticleTypes;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.crystal.AbstractCrystal;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class RemedyCrystal extends AbstractCrystal {
    private double xPower;
    private double zPower;

    public RemedyCrystal(EntityType<? extends RemedyCrystal> entityType, Level level) {
        super(entityType, level);
    }

    public RemedyCrystal(Level level, Entity shooter) {
        this(AncientAetherEntityTypes.REMEDY_CRYSTAL.get(), level);
        setOwner(shooter);
        setPos(shooter.getX(), shooter.getY(), shooter.getZ());
        float rotation = random.nextFloat() * 360;
        xPower = Mth.sin(rotation) * 0.20;
        zPower = -Mth.cos(rotation) * 0.20;
        setDeltaMovement(xPower, 0, zPower);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        markHurt();
        switch (result.getDirection()) {
            case NORTH, SOUTH -> zPower = -zPower;
            case WEST, EAST -> xPower = -xPower;
        }
        setDeltaMovement(xPower, 0, zPower);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (isInvulnerableTo(source)) {
            return false;
        } else {
            Entity attackerEntity = source.getDirectEntity();
            if (attackerEntity instanceof LivingEntity attacker) {
                attacker.addEffect(new MobEffectInstance(AetherEffects.REMEDY.get(), 100, 0, false, false, true));
                kill();
            }
        }
        return false;
    }

    @Override
    protected ParticleOptions getExplosionParticle() {
        return AetherParticleTypes.FROZEN.get();
    }

    @Nullable
    @Override
    public SoundEvent getImpactExplosionSoundEvent() {
        return AncientAetherSoundEvents.ENTITY_REMEDY_CRYSTAL_EXPLODE.get();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putDouble("XSpeed", xPower);
        tag.putDouble("ZSpeed", zPower);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        xPower = tag.getDouble("XSpeed");
        zPower = tag.getDouble("ZSpeed");
    }
}