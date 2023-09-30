package net.builderdog.ancient_aether.entity.monster;

import com.aetherteam.aether.client.AetherSoundEvents;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class AeronauticLeaper extends Slime {
	public static final EntityDataAccessor<Boolean> DATA_AWAKE_ID = SynchedEntityData.defineId(AeronauticLeaper.class, EntityDataSerializers.BOOLEAN);

	public float timeSpotted = 0.0F;

	public AeronauticLeaper(EntityType<? extends AeronauticLeaper> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		goalSelector.addGoal(1, new LeapingSentryFloatGoal(this));
		goalSelector.addGoal(3, new LeapingSentryAttackGoal(this));
		goalSelector.addGoal(4, new LeapingSentryRandomDirectionGoal(this));
		goalSelector.addGoal(5, new LeapingSentryKeepOnJumpingGoal(this));

		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_289461_) -> Math.abs(p_289461_.getY() - this.getY()) <= 4.0D));
	}

	@Nonnull
	public static AttributeSupplier.Builder createMobAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 10D)
				.add(Attributes.MOVEMENT_SPEED, 1f)
				.add(ForgeMod.ENTITY_GRAVITY.get(), 0.025)
				.add(Attributes.ATTACK_DAMAGE, 4f)
		        .add(Attributes.ATTACK_SPEED, 1.2f);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(DATA_AWAKE_ID, false);
	}

	@Override
	public void tick() {
		if (this.level().getNearestPlayer(this.getX(), this.getY(), this.getZ(), 8.0, EntitySelector.NO_SPECTATORS) != null) {
			if (!this.isAwake()) {
				if (this.timeSpotted >= 24) {
					this.setAwake(true);
				}
				this.timeSpotted++;
			}
		} else {
			this.setAwake(false);
		}
		super.tick();
	}

	@Override
	protected void jumpFromGround() {
		if (this.isAwake()) {
			super.jumpFromGround();
		}
	}

	@Override
	public void remove(@NotNull RemovalReason pReason) {
		this.setRemoved(pReason);
		this.invalidateCaps();
	}

	public boolean isAwake() {
		return this.getEntityData().get(DATA_AWAKE_ID);
	}

	public void setAwake(boolean awake) {
		this.getEntityData().set(DATA_AWAKE_ID, awake);
	}

	@Override
	public void setSize(int size, boolean resetHealth) { }

	@Override
	protected @NotNull ParticleOptions getParticleType() {
		return new BlockParticleOption(ParticleTypes.BLOCK, AncientAetherBlocks.LIGHT_AEROTIC_STONE.get().defaultBlockState());
	}

	@Override
	protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
		return AetherSoundEvents.ENTITY_SENTRY_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AetherSoundEvents.ENTITY_SENTRY_DEATH.get();
	}

	@Override
	protected @NotNull SoundEvent getSquishSound() {
		return AetherSoundEvents.ENTITY_SENTRY_JUMP.get();
	}

	@Override
	protected @NotNull SoundEvent getJumpSound() {
		return AetherSoundEvents.ENTITY_SENTRY_JUMP.get();
	}

	@Override
	public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
		return super.getDimensions(pose).scale(1.76F);
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 70) {
			for (int i = 0; i < 40; i++) {
				double x = this.getX() + (this.getRandom().nextFloat() * 0.25);
				double y = this.getY() + 0.5;
				double z = this.getZ() + (this.getRandom().nextFloat() * 0.25);
				float f1 = this.getRandom().nextFloat() * 360.0F;
				this.level().addParticle(ParticleTypes.POOF, x, y, z, -Math.sin(Mth.DEG_TO_RAD * f1) * 0.75, 0.125, Math.cos(Mth.DEG_TO_RAD * f1) * 0.75);
			}
		} else {
			super.handleEntityEvent(id);
		}
	}

	static class LeapingSentryAttackGoal extends SlimeAttackGoal {
		private final AeronauticLeaper aeronauticLeaper;

		public LeapingSentryAttackGoal(AeronauticLeaper aeronauticLeaper) {
			super(aeronauticLeaper);
			this.aeronauticLeaper = aeronauticLeaper;
		}

		@Override
		public boolean canUse() {
			return aeronauticLeaper.isAwake() && super.canUse();
		}

		@Override
		public boolean canContinueToUse() {
			return aeronauticLeaper.isAwake() && super.canContinueToUse();
		}
	}

	static class LeapingSentryFloatGoal extends SlimeFloatGoal {
		private final AeronauticLeaper aeronauticLeaper;

		public LeapingSentryFloatGoal(AeronauticLeaper aeronauticLeaper) {
			super(aeronauticLeaper);
			this.aeronauticLeaper = aeronauticLeaper;
		}

		@Override
		public boolean canUse() {
			return aeronauticLeaper.isAwake() && super.canUse();
		}

		@Override
		public boolean canContinueToUse() {
			return aeronauticLeaper.isAwake() && super.canContinueToUse();
		}
	}

	static class LeapingSentryKeepOnJumpingGoal extends SlimeKeepOnJumpingGoal {
		private final AeronauticLeaper aeronauticLeaper;

		public LeapingSentryKeepOnJumpingGoal(AeronauticLeaper aeronauticLeaper) {
			super(aeronauticLeaper);
			this.aeronauticLeaper = aeronauticLeaper;
		}

		@Override
		public boolean canUse() {
			return aeronauticLeaper.isAwake() && super.canUse();
		}

		@Override
		public boolean canContinueToUse() {
			return aeronauticLeaper.isAwake() && super.canContinueToUse();
		}
	}

	static class LeapingSentryRandomDirectionGoal extends SlimeRandomDirectionGoal {
		private final AeronauticLeaper aeronauticLeaper;

		public LeapingSentryRandomDirectionGoal(AeronauticLeaper aeronauticLeaper) {
			super(aeronauticLeaper);
			this.aeronauticLeaper = aeronauticLeaper;
		}

		@Override
		public boolean canUse() {
			return aeronauticLeaper.isAwake() && super.canUse();
		}

		@Override
		public boolean canContinueToUse() {
			return aeronauticLeaper.isAwake() && super.canContinueToUse();
		}
	}
}