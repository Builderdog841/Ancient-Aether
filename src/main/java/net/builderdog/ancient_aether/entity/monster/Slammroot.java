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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
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
import java.util.EnumSet;

public class Slammroot extends Monster {
    public Slammroot(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2F, false) {
            @Override
            protected double getAttackReachSqr(@NotNull LivingEntity entity) {
                return mob.getBbWidth() * mob.getBbWidth() + entity.getBbWidth();
            }
        });
        goalSelector.addGoal(2, new FloatGoal(this));
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2F, false));
        goalSelector.addGoal(3, new JumpGoal(this));
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
        setDeltaMovement(vec3.x, 0.75F, vec3.z);
        hasImpulse = true;
    }

    protected int getJumpDelay() {
        return random.nextInt(20) + 10;
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

    public static class JumpGoal extends Goal {
        private final Slammroot slammroot;

        public JumpGoal(Slammroot slammroot) {
            this.slammroot = slammroot;
            setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return !slammroot.isPassenger();
        }

        public void tick() {
            MoveControl movecontrol = slammroot.getMoveControl();
            if (movecontrol instanceof SlammrootMoveControl slammrootMoveControl) {
                slammrootMoveControl.setWantedMovement(1.0D);
            }
        }
    }

    static class SlammrootMoveControl extends MoveControl {
        private float yRot;
        private int jumpDelay;
        private final Slammroot slammroot;

        public SlammrootMoveControl(Slammroot slammroot) {
            super(slammroot);
            this.slammroot = slammroot;
            yRot = 180.0F * slammroot.getYRot() / (float)Math.PI;
        }

        public void setDirection(float yRot) {
            this.yRot = yRot;
        }

        public void setWantedMovement(double speed) {
            speedModifier = speed;
            operation = MoveControl.Operation.MOVE_TO;
        }

        public void tick() {
            mob.setYRot(rotlerp(mob.getYRot(), yRot, 90.0F));
            mob.yHeadRot = mob.getYRot();
            mob.yBodyRot = mob.getYRot();
            if (operation != MoveControl.Operation.MOVE_TO) {
                mob.setZza(0.0F);
            } else {
                operation = MoveControl.Operation.WAIT;
                if (mob.onGround()) {
                    mob.setSpeed((float)(speedModifier * mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (jumpDelay-- <= 0) {
                        jumpDelay = slammroot.getJumpDelay();
                        jumpDelay /= 3;
                    } else {
                        slammroot.xxa = 0.0F;
                        slammroot.zza = 0.0F;
                        mob.setSpeed(0.0F);
                    }
                } else {
                    mob.setSpeed((float)(speedModifier * mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }
            }
        }
    }
}