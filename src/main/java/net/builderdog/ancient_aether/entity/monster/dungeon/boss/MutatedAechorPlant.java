package net.builderdog.ancient_aether.entity.monster.dungeon.boss;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.PoisonNeedle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class MutatedAechorPlant extends PathfinderMob implements RangedAttackMob {
    private static final EntityDataAccessor<Integer> DATA_SIZE_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_POISON_REMAINING_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_TARGETING_ENTITY_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.BOOLEAN);

    private float sinage;
    private float sinageAdd;

    public MutatedAechorPlant(EntityType<? extends MutatedAechorPlant> type, Level level) {
        super(type, level);
        xpReward = 5;
        setPoisonRemaining(2);
        if (level.isClientSide()) {
            sinage = getRandom().nextFloat() * 6.0F;
        }
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0,  new RangedAttackGoal(this, 1.0, 60, 10.0F));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(DATA_SIZE_ID, 5);
        getEntityData().define(DATA_POISON_REMAINING_ID, 0);
        getEntityData().define(DATA_TARGETING_ENTITY_ID, false);
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> dataAccessor) {
        if (DATA_SIZE_ID.equals(dataAccessor)) {
            refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
        setSize(getRandom().nextInt(4) + 1);
        setPos(Vec3.atBottomCenterOf(blockPosition()));
        return spawnData;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().getBlockState(blockPosition().below()).is(AetherTags.Blocks.AECHOR_PLANT_SPAWNABLE_ON) && !this.isPassenger()) {
            kill();
        }
        if (!level().isClientSide()) {
            if (getTarget() != null) {
                setTargetingEntity(true);
            } else if (getTarget() == null && getTargetingEntity()) {
                setTargetingEntity(false);
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide()) {
            sinage += sinageAdd;
            if (hurtTime > 0) {
                sinageAdd = 0.45F;
            } else if (getTargetingEntity()) {
                sinageAdd = 0.3F;
            } else {
                sinageAdd = 0.15F;
            }
            if (sinage >= Mth.TWO_PI) {
                sinage -= Mth.TWO_PI;
            }
        }
    }

    @Override
    public void push(double x, double y, double z) { }

    @Override
    protected void jumpFromGround() { }

    @Override
    public boolean canBeLeashed(@NotNull Player player) {
        return false;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (hurtTime == 0) {
            for (int i = 0; i < 8; ++i) {
                double d1 = getX() + (getRandom().nextFloat() - getRandom().nextFloat()) * 0.5;
                double d2 = getY() + 0.25 + (getRandom().nextFloat() - getRandom().nextFloat()) * 0.5;
                double d3 = getZ() + (getRandom().nextFloat() - getRandom().nextFloat()) * 0.5;
                double d4 = (getRandom().nextFloat() - getRandom().nextFloat()) * 0.5;
                double d5 = (getRandom().nextFloat() - getRandom().nextFloat()) * 0.5;
                level().addParticle(ParticleTypes.PORTAL, d1, d2, d3, d4, 0.25, d5);
            }
        }
        return super.hurt(source, amount);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        PoisonNeedle needle = new PoisonNeedle(level(), this);
        double x = target.getX() - getX();
        double z = target.getZ() - getZ();
        double sqrt = Math.sqrt(x * x + z * z + 0.1);
        double y = 0.1 + sqrt * 0.5 + (getY() - target.getY()) * 0.25;
        double distance = 1.5 / sqrt;
        x *= distance;
        z *= distance;
        needle.shoot(x, y + 0.5F, z, 0.285F + (float) y * 0.08F, 1.0F);
        playSound(AetherSoundEvents.ENTITY_AECHOR_PLANT_SHOOT.get(), 2.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        level().addFreshEntity(needle);
    }

    public int getSize() {
        return getEntityData().get(DATA_SIZE_ID);
    }

    public void setSize(int size) {
        getEntityData().set(DATA_SIZE_ID, size);
    }

    public int getPoisonRemaining() {
        return getEntityData().get(DATA_POISON_REMAINING_ID);
    }

    public void setPoisonRemaining(int poisonRemaining) {
        getEntityData().set(DATA_POISON_REMAINING_ID, poisonRemaining);
    }

    public boolean getTargetingEntity() {
        return getEntityData().get(DATA_TARGETING_ENTITY_ID);
    }

    public void setTargetingEntity(boolean targetingEntity) {
        getEntityData().set(DATA_TARGETING_ENTITY_ID, targetingEntity);
    }

    public float getSinage() {
        return sinage;
    }

    public float getSinageAdd() {
        return sinageAdd;
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AetherSoundEvents.ENTITY_AECHOR_PLANT_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AetherSoundEvents.ENTITY_AECHOR_PLANT_DEATH.get();
    }

    @Override
    public boolean hasLineOfSight(@NotNull Entity entity) {
        return this.distanceTo(entity) <= 8.0 && super.hasLineOfSight(entity);
    }

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
        float width = 0.75F + getSize() * 0.125F;
        float height = 0.5F + getSize() * 0.075F;
        return EntityDimensions.fixed(width, height);
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pose, EntityDimensions size) {
        return size.height / 1.15F;
    }

    @Override
    public double getMyRidingOffset() {
        return getVehicle() != null && getVehicle().isCrouching() ? 0.1 : 0.275;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        return effect.getEffect() != AetherEffects.INEBRIATION.get() && super.canBeAffected(effect);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Size", getSize());
        tag.putInt("Poison Remaining", getPoisonRemaining());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Size")) {
            setSize(tag.getInt("Size"));
        }
        if (tag.contains("Poison Remaining")) {
            setPoisonRemaining(tag.getInt("Poison Remaining"));
        }
    }
}