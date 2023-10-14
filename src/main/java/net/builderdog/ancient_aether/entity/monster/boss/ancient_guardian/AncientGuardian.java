package net.builderdog.ancient_aether.entity.monster.boss.ancient_guardian;

import com.aetherteam.aether.entity.AetherBossMob;
import com.aetherteam.aether.entity.ai.AetherBlockPathTypes;
import com.aetherteam.aether.network.packet.serverbound.BossInfoPacket;
import com.aetherteam.nitrogen.entity.BossRoomTracker;
import com.aetherteam.nitrogen.network.PacketRelay;
import com.aetherteam.aether.entity.ai.goal.ContinuousMeleeAttackGoal;
import com.aetherteam.aether.network.AetherPacketHandler;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.datagen.resources.AncientAetherStructureRegistry;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.monster.boss.AncientAetherBossNameGenerator;
import net.builderdog.ancient_aether.entity.monster.boss.ancient_core.AncientCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public class AncientGuardian extends PathfinderMob implements AetherBossMob<AncientGuardian>, Enemy, IEntityAdditionalSpawnData {
    public static final EntityDataAccessor<Boolean> DATA_AWAKE_ID = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Component> DATA_BOSS_NAME_ID = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.COMPONENT);
    public int chatTime;
    private int attackTime = 0;
    private final ServerBossEvent bossFight;
    private BossRoomTracker<AncientGuardian> dungeon;
    @Nullable
    private AABB dungeonBounds;

    public AncientGuardian(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.bossFight = new ServerBossEvent(this.getBossName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        this.bossFight.setVisible(false);
        this.xpReward = 0;
        this.setPathfindingMalus(AetherBlockPathTypes.BOSS_DOORWAY, -1.0F);
        this.setPersistenceRequired();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AncientGuardian.DoNothingGoal(this));
        this.targetSelector.addGoal(2, new ContinuousMeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, AncientGuardian.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (livingEntity) -> this.isBossFight()));
    }

    //Attributes
    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FOLLOW_RANGE, 64.0);
    }

    @Override
    protected boolean canRide(@Nonnull Entity vehicle) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isAwake();
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isNoGravity() {
        return !isAwake();
    }

    @Override
    public boolean shouldDiscardFriction() {
        return !isAwake();
    }

    protected float getJumpPower() {
        return 0.0F;
    }

    //On Spawn
    protected void alignSpawnPos() {
        this.moveTo(Mth.floor(this.getX()), this.getY(), Mth.floor(this.getZ()));
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        CompoundTag tag = new CompoundTag();
        this.addBossSaveData(tag);
        buffer.writeNbt(tag);
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        CompoundTag tag = additionalData.readNbt();
        if (tag != null) {
            this.readBossSaveData(tag);
        }
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //During Fight
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

        if (this.chatTime > 0) {
            --this.chatTime;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        }
            if (source.getDirectEntity() instanceof LivingEntity attacker && this.level().getDifficulty() != Difficulty.PEACEFUL) {
                if (this.getDungeon() == null || this.getDungeon().isPlayerWithinRoomInterior(attacker)) {
                    if (super.hurt(source, amount) && this.getHealth() > 0) {
                        if (!this.level().isClientSide() && !this.isBossFight()) {
                            this.setBossFight(true);
                            if (this.getDungeon() != null) {
                                this.closeRoom();
                            }
                        }
                        return true;
                    }
                } else {
                    if (!this.level().isClientSide() && attacker instanceof Player player) {
                        this.displayTooFarMessage(player);
                        return false;
                    }
                }
            }
        return false;
    }


    public static class DoNothingGoal extends Goal {
        private final AncientGuardian ancientGuardian;

        public DoNothingGoal(AncientGuardian ancientGuardian) {
            this.ancientGuardian = ancientGuardian;
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
    public void checkDespawn() {
    }

    @Override
    public void startSeenByPlayer(@Nonnull ServerPlayer player) {
        super.startSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Display(this.bossFight.getId()), player);
        if (this.getDungeon() == null || this.getDungeon().isPlayerTracked(player)) {
            this.bossFight.addPlayer(player);
        }
    }

    @Override
    public void stopSeenByPlayer(@Nonnull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        PacketRelay.sendToPlayer(AetherPacketHandler.INSTANCE, new BossInfoPacket.Remove(this.bossFight.getId()), player);
        this.bossFight.removePlayer(player);
    }

    @Override
    public void onDungeonPlayerAdded(@Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            this.bossFight.addPlayer(serverPlayer);
        }
    }

    @Override
    public void onDungeonPlayerRemoved(@Nullable Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            this.bossFight.removePlayer(serverPlayer);
        }
    }

    //On Death
    public void die(@NotNull DamageSource source) {
        if (!this.level().isClientSide) {
            this.bossFight.setProgress(this.getHealth() / this.getMaxHealth());
            if (this.getDungeon() != null) {
                this.getDungeon().grantAdvancements(source);
                this.tearDownRoom();
            }
        }
        super.die(source);
        level().explode(this, this.position().x, this.position().y, this.position().z, 0.3F, false, Level.ExplosionInteraction.TNT);
        super.die(source);
        LevelAccessor world = level();
        if (world instanceof ServerLevel _level) {
            Mob entityToSpawn = new AncientCore(AncientAetherEntities.ANCIENT_CORE.get(), _level);
            entityToSpawn.moveTo(this.position().x, this.position().y, this.position().z, 0, 0);
            entityToSpawn.setYBodyRot(0);
            entityToSpawn.setYHeadRot(0);
            entityToSpawn.setDeltaMovement(0, 0, 0);
            entityToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            _level.addFreshEntity(entityToSpawn);
        }
    }

    public void reset() {
        this.stop();
        this.setAwake(false);
        this.setBossFight(false);
        this.setTarget(null);
        this.setHealth(this.getMaxHealth());
        if (this.getDungeon() != null) {
            this.setPos(this.getDungeon().originCoordinates());
            this.openRoom();
        }
    }

    //Dungeon
    public void setDungeonBounds(@Nullable AABB dungeonBounds) {
        this.dungeonBounds = dungeonBounds;
    }
    @Override
    @SuppressWarnings("deprecation")
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @javax.annotation.Nullable SpawnGroupData spawnData, @javax.annotation.Nullable CompoundTag tag) {
        this.setBossName(AncientAetherBossNameGenerator.generateAncientGuardian(this.getRandom()));
        if (tag != null && tag.contains("Dungeon")) {
            StructureManager manager = level.getLevel().structureManager();
            manager.registryAccess().registry(Registries.STRUCTURE).ifPresent(registry -> {
                        Structure structure = registry.get(AncientAetherStructureRegistry.ANCIENT_DUNGEON);
                        if (structure != null) {
                            StructureStart start = manager.getStructureAt(this.blockPosition(), structure);
                            if (start != StructureStart.INVALID_START) {
                                BoundingBox box = start.getBoundingBox();
                                AABB dungeonBounds = new AABB(box.minX(), box.minY(), box.minZ(), box.maxX() + 1, box.maxY() + 1, box.maxZ() + 1);
                                this.setDungeonBounds(dungeonBounds);
                            }
                        }
                    }
            );
        }
        return spawnData;
    }

    @Override
    public void tearDownRoom() {
        assert this.dungeonBounds != null;
        for (BlockPos pos : BlockPos.betweenClosed((int) this.dungeonBounds.minX, (int) this.dungeonBounds.minY, (int) this.dungeonBounds.minZ, (int) this.dungeonBounds.maxX, (int) this.dungeonBounds.maxY, (int) this.dungeonBounds.maxZ)) {
            BlockState state = this.level().getBlockState(pos);
            BlockState newState = this.convertBlock(state);
            if (newState != null) {
                this.level().setBlock(pos, newState, 1 | 2);
            }
        }
    }

    @Nullable
    @Override
    public BlockState convertBlock(BlockState state) {
        if (state.is(AncientAetherBlocks.LOCKED_LIGHT_AEROTIC_STONE.get())) {
            return AncientAetherBlocks.LOCKED_CORRUPTED_LIGHT_AEROTIC_STONE.get().defaultBlockState();
        }
        return null;
    }

    //Boss Bar and Data
    @Override
    public void setBossName(Component component) {
        this.entityData.set(DATA_BOSS_NAME_ID, component);
        this.bossFight.setName(component);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        setBossName(name);
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_AWAKE_ID, false);
        this.entityData.define(DATA_BOSS_NAME_ID, Component.literal("Ancient Guardian"));
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossFight.setProgress(this.getHealth() / this.getMaxHealth());
        this.trackDungeon();
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addBossSaveData(tag);
        tag.putBoolean("Awake", this.isAwake());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readBossSaveData(tag);
        if (tag.contains("Awake")) {
            this.setAwake(tag.getBoolean("Awake"));
        }
    }

    //Sounds
    //

    @Override
    public int getDeathScore() {
        return this.deathScore;
    }

    @Override
    public boolean isBossFight() {
        return this.bossFight.isVisible();
    }

    @Override
    public void setBossFight(boolean isFighting) {
        this.bossFight.setVisible(isFighting);
    }

    public boolean isAwake() {
        return this.entityData.get(DATA_AWAKE_ID);
    }

    public void setAwake(boolean ready) {
        this.entityData.set(DATA_AWAKE_ID, ready);
    }

    @Override
    public Component getBossName() {
        return this.entityData.get(DATA_BOSS_NAME_ID);
    }


    public AncientGuardian self() {
        return this;
    }

    public BossRoomTracker<AncientGuardian> getDungeon() {
        return this.dungeon;
    }

    public void setDungeon(BossRoomTracker<AncientGuardian> bossRoomTracker) {
        this.dungeon = bossRoomTracker;
    }

    private void stop() {
        this.setDeltaMovement(Vec3.ZERO);
    }
}