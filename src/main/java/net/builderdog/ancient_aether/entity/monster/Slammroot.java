package net.builderdog.ancient_aether.entity.monster;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class Slammroot extends Slime {
    public Slammroot(EntityType<? extends Slammroot> entity, Level level) {
        super(entity, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        goalSelector.addGoal(1, new SlimeFloatGoal(this));
        goalSelector.addGoal(2, new SlimeAttackGoal(this));
        goalSelector.addGoal(3, new SlimeRandomDirectionGoal(this));
        goalSelector.addGoal(5, new SlimeKeepOnJumpingGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) -> Math.abs(entity.getY() - this.getY()) <= 4.0));
    }

    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.3F);
    }

    @Override
    public void setSize(int size, boolean resetHealth) {}

    @Override
    public void remove(@Nonnull Entity.RemovalReason reason) {
        setRemoved(reason);
        if (reason == Entity.RemovalReason.KILLED) {
            gameEvent(GameEvent.ENTITY_DIE);
        }
        invalidateCaps();
    }

    protected boolean isDealsDamage() {
        return isEffectiveAi();
    }

    @Override
    public @Nullable
    SpawnGroupData finalizeSpawn(@Nonnull ServerLevelAccessor level, @Nonnull DifficultyInstance difficulty, @Nonnull MobSpawnType reason, @javax.annotation.Nullable SpawnGroupData spawnData, @javax.annotation.Nullable CompoundTag tag) {
        setSize(1, true);
        setLeftHanded(false);
        return spawnData;
    }

    protected void jumpFromGround() {
        Vec3 vec3 = getDeltaMovement();
        setDeltaMovement(vec3.x, 0.75F, vec3.z);
        hasImpulse = true;
        ForgeHooks.onLivingJump(this);
    }

    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensiontype = level.dimensionType();
            int i = dimensiontype.monsterSpawnBlockLightLimit();
            if (i < 15 && level.getBrightness(LightLayer.BLOCK, pos) > i) {
                return false;
            } else {
                int j = level.getLevel().isThundering() ? level.getMaxLocalRawBrightness(pos, 10) : level.getMaxLocalRawBrightness(pos);
                return j <= dimensiontype.monsterSpawnLightTest().sample(random);
            }
        }
    }

    public void playerTouch(@NotNull Player entity) {
        if (isDealsDamage()) {
            dealDamage(entity);
        }
    }

    @Override
    protected void dealDamage(@NotNull LivingEntity entity) {
        if (isAlive()) {
            int i = getSize();
            if (distanceToSqr(entity) < 1.2D * (double)i * 1.2D * (double)i && hasLineOfSight(entity) && entity.hurt(damageSources().mobAttack(this), getAttackDamage())) {
                doEnchantDamageEffects(this, entity);
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        if (!level().isClientSide) {
            if (!ForgeEventFactory.getMobGriefingEvent(level(), this)) {
                return;
            }

            for(int i = 0; i < 4; ++i) {
                int j = Mth.floor(getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                int k = Mth.floor(getY());
                int l = Mth.floor(getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos pos = new BlockPos(j, k, l);
                BlockPos posBelow = new BlockPos(j, k - 1, l);
                Block block = level().getBlockState(posBelow).getBlock();

                if (block instanceof BonemealableBlock) {
                    if (level().isEmptyBlock(pos)) {
                        if (level() instanceof ServerLevel serverLevel) {
                            ((BonemealableBlock) block).performBonemeal(serverLevel, level().getRandom(), posBelow, level().getBlockState(posBelow));
                        }
                    }
                }
            }
        }
    }

    public static boolean checkSlammrootSpawnRules(EntityType<? extends Slammroot> slammroot, ServerLevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return Mob.checkMobSpawnRules(slammroot, level, reason, pos, random)
                && isDarkEnoughToSpawn(level, pos, random)
                && !level.getBlockState(pos.below()).is(AncientAetherTags.Blocks.SLAMMROOT_SPAWNABLE_BLACKLIST)
                && level.getDifficulty() != Difficulty.PEACEFUL
                && (reason != MobSpawnType.NATURAL || random.nextInt(3) == 0);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return AncientAetherSoundEvents.ENTITY_SLAMMROOT_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AncientAetherSoundEvents.ENTITY_SLAMMROOT_DEATH.get();
    }

    @Override
    protected @NotNull SoundEvent getSquishSound() {
        return AncientAetherSoundEvents.ENTITY_SLAMMROOT_HURT.get();
    }

    @Override
    protected @NotNull SoundEvent getJumpSound() {
        return AncientAetherSoundEvents.ENTITY_SLAMMROOT_HURT.get();
    }

    @Nonnull
    @Override
    public EntityDimensions getDimensions(@NotNull Pose pose) {
        return super.getDimensions(pose).scale(2 * 0.879F);
    }

    @Override
    protected @NotNull ParticleOptions getParticleType() {
        return new BlockParticleOption(ParticleTypes.BLOCK, AetherBlocks.AETHER_DIRT.get().defaultBlockState());
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    @Override
    public EntityType<? extends AeronauticLeaper> getType() {
        return (EntityType<? extends AeronauticLeaper>) super.getType();
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    @Nonnull
    @Override
    protected ResourceLocation getDefaultLootTable() {
        return getType().getDefaultLootTable();
    }
}