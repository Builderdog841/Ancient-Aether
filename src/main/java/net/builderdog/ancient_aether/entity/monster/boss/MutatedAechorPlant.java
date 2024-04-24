package net.builderdog.ancient_aether.entity.monster.boss;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.AetherBossMob;
import com.aetherteam.aether.event.AetherEventDispatch;
import com.aetherteam.aether.network.AetherPacketHandler;
import com.aetherteam.aether.network.packet.serverbound.BossInfoPacket;
import com.aetherteam.nitrogen.entity.BossRoomTracker;
import com.aetherteam.nitrogen.network.PacketRelay;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.entity.projectile.MutatedAechorNeedle;
import net.builderdog.ancient_aether.entity.projectile.RemedyCrystal;
import net.builderdog.ancient_aether.entity.projectile.SporeBomb;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MutatedAechorPlant extends PathfinderMob implements AetherBossMob<MutatedAechorPlant>, Enemy, IEntityAdditionalSpawnData, RangedAttackMob {
    private static final EntityDataAccessor<Boolean> DATA_ACTIVE_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_SIZE_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Component> DATA_BOSS_NAME_ID = SynchedEntityData.defineId(MutatedAechorPlant.class, EntityDataSerializers.COMPONENT);
    private float sinage;
    private float sinageAdd;
    private final ServerBossEvent bossFight;
    @Nullable
    private BossRoomTracker<MutatedAechorPlant> laboratoryDungeon;

    public MutatedAechorPlant(EntityType<? extends MutatedAechorPlant> type, Level level) {
        super(type, level);
        xpReward = XP_REWARD_BOSS;
        bossFight = new ServerBossEvent(getBossName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        setBossFight(false);
        setPersistenceRequired();
        if (level.isClientSide()) {
            sinage = getRandom().nextFloat() * 6.0F;
        }
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0,  new RangedAttackGoal(this, 1.0, 30, 16.0F));
        goalSelector.addGoal(1,  new SpawnRemedyCrystalGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, livingEntity -> isBossFight()));
    }

    //---------------------[Attribute Methods]---------------------\\

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public void push(double x, double y, double z) {}

    @Override
    protected void jumpFromGround() {}

    @Override
    public boolean canBeLeashed(@NotNull Player player) {
        return false;
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return target.canBeSeenAsEnemy();
    }

    @Override
    protected boolean canRide(@NotNull Entity vehicle) {
        return false;
    }

    //---------------------[Parameter Methods]---------------------\\

    public int getSize() {
        return getEntityData().get(DATA_SIZE_ID);
    }

    public void setSize(int size) {
        getEntityData().set(DATA_SIZE_ID, size);
    }

    public float getSinage() {
        return sinage;
    }

    public float getSinageAdd() {
        return sinageAdd;
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
    public void checkDespawn() {}

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //---------------------[General Methods]---------------------\\

    @Override
    public void tick() {
        super.tick();
        if (!isActive() || (getTarget() instanceof Player player && (!player.isCreative() || !player.isSpectator()))) {
            setTarget(null);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide()) {
            sinage += sinageAdd;
            if (hurtTime > 0) {
                sinageAdd = 0.45F;
            } else if (isActive()) {
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
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            super.hurt(source, amount);
        } else if (source.getDirectEntity() instanceof LivingEntity attacker && level().getDifficulty() != Difficulty.PEACEFUL) {
            if (getDungeon() == null || getDungeon().isPlayerWithinRoomInterior(attacker)) {
                if (super.hurt(source, amount) && getHealth() > 0) {
                    if (!isBossFight()) {
                        start();
                    }
                    return true;
                }
            } else {
                if (!level().isClientSide() && attacker instanceof Player player) {
                    displayTooFarMessage(player);
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void die(@NotNull DamageSource source) {
        setDeltaMovement(Vec3.ZERO);
        if (level() instanceof ServerLevel) {
            bossFight.setProgress(getHealth() / getMaxHealth());
            if (getDungeon() != null) {
                getDungeon().grantAdvancements(source);
                tearDownRoom();
            }
        }
        super.die(source);
    }

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
        if (isActive()) {
            if (RandomSource.create().nextInt(2) == 0) {
                poisonBombRangedAttack(target);
            } else {
                needleRangedAttack(target);
            }
            playSound(AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_SHOOT.get(), 2.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        }
    }

    public void needleRangedAttack(@NotNull LivingEntity target) {
        MutatedAechorNeedle needle = new MutatedAechorNeedle(level(), this);
        double d0 = target.getX() - getX();
        double d1 = target.getY(0.75) - needle.getY();
        double d2 = target.getZ() - getZ();
        double d3 = Mth.sqrt((float) (Mth.square(d0) + Mth.square(d2)));
        needle.shoot(d0, d1 + d3 * 0.2, d2, 1.0F, (float) (14 - level().getDifficulty().getId() * 4));
        level().addFreshEntity(needle);
    }

    public void poisonBombRangedAttack(@NotNull LivingEntity target) {
        SporeBomb poisonBomb = new SporeBomb(level(), this);
        double d0 = target.getX() - getX();
        double d1 = target.getY(0.75) - poisonBomb.getY();
        double d2 = target.getZ() - getZ();
        double d3 = Mth.sqrt((float) (Mth.square(d0) + Mth.square(d2)));
        poisonBomb.shoot(d0, d1 + d3 * 0.2, d2, 1.0F, (float) (14 - level().getDifficulty().getId() * 4));
        level().addFreshEntity(poisonBomb);
    }

    @SuppressWarnings("deprecation")
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
        setBossName(AncientAetherBossNameGenerator.generateMutatedAechorName(getRandom()));
        setPos(Vec3.atBottomCenterOf(blockPosition()));
        return spawnData;
    }

   @Override
   public boolean hasLineOfSight(@NotNull Entity entity) {
        return distanceTo(entity) <= 8.0 && super.hasLineOfSight(entity);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        return effect.getEffect() != AetherEffects.INEBRIATION.get() && super.canBeAffected(effect);
    }

    @Override
    public void evaporateEffects(MutatedAechorPlant entity, BlockPos pos) {
        AetherBossMob.super.evaporateEffects(entity, pos);
    }

    //---------------------[Boss Methods]---------------------\\

    public boolean isActive() {
        return getEntityData().get(DATA_ACTIVE_ID);
    }

    public void setActive(boolean active) {
        getEntityData().set(DATA_ACTIVE_ID, active);
    }

    @Nullable
    @Override
    public ResourceLocation getBossBarTexture() {
        return AncientAetherConfig.CLIENT.custom_boss_bars.get() ? new ResourceLocation(AncientAether.MODID, "textures/gui/boss_bar_mutated_aechor_plant_custom.png") : new ResourceLocation(AncientAether.MODID, "textures/gui/boss_bar_mutated_aechor_plant.png");
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        bossFight.setProgress(getHealth() / getMaxHealth());
        trackDungeon();
    }

    @Override
    public Component getBossName() {
        return getEntityData().get(DATA_BOSS_NAME_ID);
    }

    @Override
    public void setBossName(Component component) {
        getEntityData().set(DATA_BOSS_NAME_ID, component);
        bossFight.setName(component);
    }

    @Override
    public boolean isBossFight() {
        return bossFight.isVisible();
    }

    @Override
    public void setBossFight(boolean isFighting) {
        bossFight.setVisible(isFighting);
    }

    @Nullable
    @Override
    public BossRoomTracker<MutatedAechorPlant> getDungeon() {
        return laboratoryDungeon;
    }

    @Override
    public void setDungeon(@Nullable BossRoomTracker<MutatedAechorPlant> dungeon) {
        laboratoryDungeon = dungeon;
    }

    @Override
    public int getDeathScore() {
        return deathScore;
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        setBossName(name);
    }

    private void start() {
        setActive(true);
        setBossFight(true);
        if (getDungeon() != null) {
            closeRoom();
        }
        AetherEventDispatch.onBossFightStart(this, getDungeon());
    }

    public void reset() {
        setActive(false);
        setBossFight(false);
        setTarget(null);
        setHealth(getMaxHealth());
        if (getDungeon() != null) {
            setPos(getDungeon().originCoordinates());
            openRoom();
        }
        AetherEventDispatch.onBossFightStop(this, getDungeon());
    }

    @Override
    public void startSeenByPlayer(@NotNull ServerPlayer player) {
        super.startSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Display(bossFight.getId(), getId()), player);
        if (getDungeon() == null || getDungeon().isPlayerTracked(player)) {
            bossFight.addPlayer(player);
            AetherEventDispatch.onBossFightPlayerAdd(this, getDungeon(), player);
        }
    }

    @Override
    public void stopSeenByPlayer(@NotNull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Remove(bossFight.getId(), getId()), player);
        bossFight.removePlayer(player);
        AetherEventDispatch.onBossFightPlayerRemove(this, getDungeon(), player);
    }

    @Override
    public void onDungeonPlayerAdded(@Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            bossFight.addPlayer(serverPlayer);
            AetherEventDispatch.onBossFightPlayerAdd(this, getDungeon(), serverPlayer);
        }
    }

    @Override
    public void onDungeonPlayerRemoved(@Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            bossFight.removePlayer(serverPlayer);
            AetherEventDispatch.onBossFightPlayerRemove(this, getDungeon(), serverPlayer);
        }
    }

    @Override
    public void tearDownRoom() {
        AetherBossMob.super.tearDownRoom();
    }

    @Nullable
    @Override
    public BlockState convertBlock(BlockState state) {
        if (state.is(AetherBlocks.LOCKED_CARVED_STONE.get())) {
            return AetherBlocks.CARVED_STONE.get().defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get())) {
            return AncientAetherBlocks.WYND_SENTRY_STONE.get().defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()) || state.is(AetherBlocks.TREASURE_DOORWAY_CARVED_STONE.get())) {
            return Blocks.AIR.defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.BOSS_DOORWAY_WYND_SENTRY_STONE.get()) || state.is(AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get())) {
            return Blocks.AIR.defaultBlockState();
        }
        return null;
    }

    //---------------------[Data Methods]---------------------\\

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Active", isActive());
        tag.putInt("Size", getSize());
        addBossSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Active")) {
            setActive(tag.getBoolean("Active"));
        }
        if (tag.contains("Size")) {
            setSize(tag.getInt("Size"));
        }
        readBossSaveData(tag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(DATA_ACTIVE_ID, false);
        getEntityData().define(DATA_BOSS_NAME_ID, Component.literal("Mutated Aechor Plant"));
        getEntityData().define(DATA_SIZE_ID, 0);
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> dataAccessor) {
        if (DATA_SIZE_ID.equals(dataAccessor)) {
            refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        CompoundTag tag = new CompoundTag();
        addBossSaveData(tag);
        buffer.writeNbt(tag);
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        CompoundTag tag = additionalData.readNbt();
        if (tag != null) {
            readBossSaveData(tag);
        }
    }

    //---------------------[Sound Methods]---------------------\\

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AncientAetherSoundEvents.ENTITY_MUTATED_AECHOR_PLANT_DEATH.get();
    }

    @Override
    public @NotNull SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    public static class SpawnRemedyCrystalGoal extends Goal {
        private final MutatedAechorPlant mutatedAechorPlant;
        private int shootInterval;

        public SpawnRemedyCrystalGoal(MutatedAechorPlant mutatedAechorPlant) {
            this.mutatedAechorPlant = mutatedAechorPlant;
            shootInterval = (int) (40 + mutatedAechorPlant.getHealth() / 2);
        }

        @Override
        public boolean canUse() {
            return mutatedAechorPlant.isBossFight() && --shootInterval <= 0;
        }

        @Override
        public void start() {
            RemedyCrystal crystal;
            crystal = new RemedyCrystal(mutatedAechorPlant.level(), mutatedAechorPlant);
            mutatedAechorPlant.level().addFreshEntity(crystal);
            shootInterval = (int) (15 + mutatedAechorPlant.getHealth() / 2);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}