package net.builderdog.ancient_aether.entity.monster;

import com.aetherteam.aether.entity.ai.goal.FallingRandomStrollGoal;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class Slammroot extends Monster {
    public Slammroot(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2F, false) {
            @Override
            protected double getAttackReachSqr(@NotNull LivingEntity entity) {
                return mob.getBbWidth() * mob.getBbWidth() + entity.getBbWidth();
            }
        });
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        goalSelector.addGoal(2, new FloatGoal(this));
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        goalSelector.addGoal(4, new FallingRandomStrollGoal(this, 1.0));
        goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12D)
                .add(Attributes.ATTACK_DAMAGE, 2.0F)
                .add(Attributes.ATTACK_SPEED, 1.2F)
                .add(Attributes.MOVEMENT_SPEED, 0.3F);
    }

    protected void jumpFromGround() {
        Vec3 vec3 = getDeltaMovement();
        setDeltaMovement(vec3.x, 0.5F, vec3.z);
        hasImpulse = true;
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        return false;
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
}