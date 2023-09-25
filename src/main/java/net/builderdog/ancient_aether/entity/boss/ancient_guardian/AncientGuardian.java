package net.builderdog.ancient_aether.entity.boss.ancient_guardian;

import com.aetherteam.aether.entity.AetherBossMob;
import com.aetherteam.aether.entity.monster.dungeon.boss.BossNameGenerator;
import com.aetherteam.aether.network.packet.serverbound.BossInfoPacket;
import com.aetherteam.nitrogen.entity.BossRoomTracker;
import com.aetherteam.nitrogen.network.PacketRelay;
import com.aetherteam.aether.entity.ai.goal.ContinuousMeleeAttackGoal;
import com.aetherteam.aether.network.AetherPacketHandler;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public class AncientGuardian extends PathfinderMob implements AetherBossMob<AncientGuardian>, Enemy, IEntityAdditionalSpawnData {
    public static final EntityDataAccessor<Boolean> DATA_AWAKE_ID;
    public static final EntityDataAccessor<Component> DATA_BOSS_NAME_ID;
    public int chatTime;
    private int attackTime = 0;
    private final ServerBossEvent bossFight;
    private BossRoomTracker<AncientGuardian> bronzeDungeon;

    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Monster.createMobAttributes().add(Attributes.MAX_HEALTH, 500.0).add(Attributes.MOVEMENT_SPEED, 0.35).add(Attributes.FOLLOW_RANGE, 8.0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AncientGuardian.DoNothingGoal(this));
        this.targetSelector.addGoal(2, new ContinuousMeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, AncientGuardian.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (livingEntity) -> {
            return this.isBossFight();
        }));
    }

    public AncientGuardian(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.bossFight = new ServerBossEvent(this.getBossName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        this.bossFight.setVisible(false);
        this.xpReward = 50;
        this.setPersistenceRequired();
    }
    public void die(@NotNull DamageSource source) {
        level().explode(this, this.position().x, this.position().y, this.position().z, 0.3F, false, Level.ExplosionInteraction.TNT);
        super.die(source);
    }

    public void tick() {
        super.tick();
        if (this.attackTime > 0) {
            --this.attackTime;
        }

        label30:
        {
            if (this.isAwake()) {
                LivingEntity var2 = this.getTarget();
                if (!(var2 instanceof Player player)) {
                    break label30;
                }

                if (!player.isCreative() && !player.isSpectator()) {
                    break label30;
                }
            }

            this.setTarget( null);
        }

        this.extinguishFire();
        if (this.getHealth() > 0.0F) {
            double a = this.random.nextFloat() - 0.5F;
            double b = this.random.nextFloat();
            double c = this.random.nextFloat() - 0.5F;
            double d = this.position().x + a * b;
            double e = this.getBoundingBox().minY + b - 0.30000001192092896;
            double f = this.position().z + c * b;
            if (!this.isAwake()) {
                level().addParticle(new DustParticleOptions(Vec3.fromRGB24(10444703).toVector3f(), 1.0F), d, e, f, 0.28999999165534973, 0.2800000011920929, 0.47999998927116394);
            } else {
                level().addParticle(new DustParticleOptions(Vec3.fromRGB24(9315170).toVector3f(), 1.0F), d, e, f, 0.4300000071525574, 0.18000000715255737, 0.2800000011920929);
            }
        }

        if (this.chatTime > 0) {
            --this.chatTime;
        }

    }

    public void reset() {
        this.setAwake(false);
        this.setBossFight(false);
        this.setTarget( null);
        this.setHealth(this.getMaxHealth());
        if (this.getDungeon() != null) {
            this.setPos(this.getDungeon().originCoordinates());
            this.openRoom();
        }

    }

    public boolean doHurtTarget(Entity pEntity) {
        this.attackTime = 10;
        level().broadcastEntityEvent(this, (byte) 4);
        float f = (float) (7 + this.random.nextInt(15));
        float f1 = (int) f > 0 ? f / 2.0F + (float) this.random.nextInt((int) f) : f;
        boolean flag = pEntity.hurt(this.damageSources().mobAttack(this), f1);
        if (flag) {
            double d2;
            if (pEntity instanceof LivingEntity livingentity) {
                d2 = livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            } else {
                d2 = 0.0;
            }

            double d1 = Math.max(0.0, 1.0 - d2);
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(0.0, 0.4000000059604645 * d1, 0.0));
            this.doEnchantDamageEffects(this, pEntity);
        }

        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    public void checkDespawn() {
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_AWAKE_ID, false);
        this.entityData.define(DATA_BOSS_NAME_ID, Component.literal("Ancient Guardian"));
    }

    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void addAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addBossSaveData(tag);
        tag.putBoolean("Awake", this.isAwake());
    }

    public void readAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readBossSaveData(tag);
        if (tag.contains("Awake")) {
            this.setAwake(tag.getBoolean("Awake"));
        }

    }

    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        Entity attacker = source.getEntity();
        if (entity != null && source.is(DamageTypeTags.IS_PROJECTILE)) {
            if (!level().isClientSide && attacker instanceof Player && ((Player) attacker).getMainHandItem() != Items.AIR.getDefaultInstance()) {
                chatTime = 60;
                attacker.sendSystemMessage(Component.literal("gui.aether_genesis.boss.message.projectile"));
            }

            return false;
        } else {
            if (!isBossFight()) {
                setAwake(true);
                setBossFight(true);
            }

            return super.hurt(source, damage);
        }
    }

    protected float getJumpPower() {
        return 0.0F;
    }

    public AncientGuardian self() {
        return this;
    }

    public boolean isBossFight() {
        return this.bossFight.isVisible();
    }

    public void setBossFight(boolean isFighting) {
        this.bossFight.setVisible(isFighting);
    }

    public BossRoomTracker<AncientGuardian> getDungeon() {
        return this.bronzeDungeon;
    }

    public void setDungeon(BossRoomTracker<AncientGuardian> bossRoomTracker) {
        this.bronzeDungeon = bossRoomTracker;
    }

    public int getDeathScore() {
        return this.deathScore;
    }

    public @Nullable BlockState convertBlock(BlockState blockState) {
        return null;
    }

    public void writeSpawnData(FriendlyByteBuf buffer) {
        CompoundTag tag = new CompoundTag();
        addBossSaveData(tag);
        buffer.writeNbt(tag);
    }

    public void readSpawnData(FriendlyByteBuf additionalData) {
        CompoundTag tag = additionalData.readNbt();
        if (tag != null) {
            readBossSaveData(tag);
        }

    }

    @Override
    public void startSeenByPlayer(@Nonnull ServerPlayer player) {
        super.startSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Display(this.bossFight.getId()), player);
        if (this.getDungeon() == null || this.getDungeon().isPlayerTracked(player)) {
            this.bossFight.addPlayer(player);
        }
    }

    public void customServerAiStep() {
        super.customServerAiStep();
        bossFight.setProgress(getHealth() / getMaxHealth());
        trackDungeon();
    }

    @Override
    public void stopSeenByPlayer(@Nonnull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Remove(this.bossFight.getId()), player);
        this.bossFight.removePlayer(player);
    }

    public void onDungeonPlayerAdded(@javax.annotation.Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            bossFight.addPlayer(serverPlayer);
        }

    }

    public void onDungeonPlayerRemoved(@javax.annotation.Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            bossFight.removePlayer(serverPlayer);
        }

    }

    public boolean isAwake() {
        return this.entityData.get(DATA_AWAKE_ID);
    }

    public void setAwake(boolean ready) {
        this.entityData.set(DATA_AWAKE_ID, ready);
    }

    public Component getBossName() {
        return this.entityData.get(DATA_BOSS_NAME_ID);
    }

    public void setBossName(Component component) {
        this.entityData.set(DATA_BOSS_NAME_ID, component);
        this.bossFight.setName(component);
    }

    protected void alignSpawnPos() {
        this.moveTo(Mth.floor(this.getX()), this.getY(), Mth.floor(this.getZ()));
    }

    public MutableComponent generateGuardianName() {
        MutableComponent result = BossNameGenerator.generateBossName(this.getRandom());
        return result.append(Component.translatable("gui.ancient_aether.ancient_guardian.title"));
    }


    public SpawnGroupData finalizeSpawn(@Nonnull ServerLevelAccessor pLevel, @Nonnull DifficultyInstance pDifficulty, @Nonnull MobSpawnType pReason, @javax.annotation.Nullable SpawnGroupData pSpawnData, @javax.annotation.Nullable CompoundTag pDataTag) {
        this.alignSpawnPos();
        SpawnGroupData data = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        setBossName(generateGuardianName());
        return data;
    }

    public void setCustomName(@javax.annotation.Nullable Component name) {
        super.setCustomName(name);
        setBossName(name);
    }

    static {
        DATA_AWAKE_ID = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.BOOLEAN);
        DATA_BOSS_NAME_ID = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.COMPONENT);
    }

    public static class DoNothingGoal extends Goal {
        private final AncientGuardian ancientGuardian;

        public DoNothingGoal(AncientGuardian sentryGuardian) {
            this.ancientGuardian = sentryGuardian;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
        }

        public boolean canUse() {
            return !ancientGuardian.isBossFight();
        }

        public void start() {
            ancientGuardian.setDeltaMovement(Vec3.ZERO);
            ancientGuardian.setPos(ancientGuardian.position().x, ancientGuardian.position().y, ancientGuardian.position().z);
        }
    }
}