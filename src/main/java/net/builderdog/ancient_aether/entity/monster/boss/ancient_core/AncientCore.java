package net.builderdog.ancient_aether.entity.monster.boss.ancient_core;

import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.entity.AetherBossMob;
import com.aetherteam.aether.entity.ai.AetherBlockPathTypes;
import com.aetherteam.nitrogen.entity.BossRoomTracker;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.datagen.registries.AncientAetherStructureRegistry;
import net.builderdog.ancient_aether.entity.monster.boss.AncientAetherBossNameGenerator;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EnumSet;


public class AncientCore extends PathfinderMob implements AetherBossMob<AncientCore>, Enemy, IEntityAdditionalSpawnData {
    public static final EntityDataAccessor<Boolean> DATA_AWAKE_ID = SynchedEntityData.defineId(AncientCore.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Component> DATA_BOSS_NAME_ID = SynchedEntityData.defineId(AncientCore.class, EntityDataSerializers.COMPONENT);

    private BossRoomTracker<AncientCore> dungeon;
    private final ServerBossEvent bossFight;

    private int chatCooldown;
    @Nullable
    private AABB dungeonBounds;


    public AncientCore(EntityType<? extends AncientCore> entityType, Level level) {
        super(entityType, level);
        this.bossFight = new ServerBossEvent(this.getBossName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        this.bossFight.setVisible(false);
        this.xpReward = 100;
        this.setPathfindingMalus(AetherBlockPathTypes.BOSS_DOORWAY, -1.0F);
        this.setPersistenceRequired();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new DoNothingGoal(this));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 3.0F, 1.25F, 2.0F));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, AncientCore.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, livingEntity -> this.isBossFight()));
    }

    public AncientCore self(){
        return this;
    }


    //Attributes
    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FOLLOW_RANGE, 64.0);
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return target.canBeSeenAsEnemy();
    }

    @Override
    public float getYRot() {
        return !isAwake() ? 0 : super.getYRot();
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
    @Override
    public void tick() {
        super.tick();
        if (!this.isAwake() || (this.getTarget() instanceof Player player && (player.isCreative() || player.isSpectator()))) {
            this.setTarget(null);
        }
        if (this.getChatCooldown() > 0) {
            this.chatCooldown--;
        }
    }

    public boolean hurt(@NotNull DamageSource source, float damage) {
        if (!this.isBossFight()) {
            this.setAwake(true);
            this.setBossFight(true);
        }
        return super.hurt(source, damage);
    }

    @Nullable
    @Override
    public ResourceLocation getBossBarTexture() {
        return null;
    }

    public static class DoNothingGoal extends Goal {
        private final AncientCore ancientCore;
        public DoNothingGoal(AncientCore ancientCore) {
            this.ancientCore = ancientCore;
            this.ancientCore.setRot(0, 0);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            return !this.ancientCore.isBossFight();
        }

        @Override
        public void start() {
            this.ancientCore.setDeltaMovement(Vec3.ZERO);
            this.ancientCore.setPos(this.ancientCore.position().x,
                    this.ancientCore.position().y,
                    this.ancientCore.position().z);
        }
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

    @Override
    public boolean isBossFight() {
        return this.bossFight.isVisible();
    }

    @Override
    public void setBossFight(boolean isFighting) {
        this.bossFight.setVisible(isFighting);
    }

    //On Death
    @Override
    public void die(@NotNull DamageSource source) {
        if (!this.level().isClientSide) {
            this.bossFight.setProgress(this.getHealth() / this.getMaxHealth()); // Forces an update to the boss health meter.
            if (this.getDungeon() != null) {
                this.getDungeon().grantAdvancements(source);
                this.tearDownRoom();
            }
        }
        super.die(source);
    }

    private void stop() {
        this.setDeltaMovement(Vec3.ZERO);
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

    @Override
    public void checkDespawn() {}


    //Dungeon
    public void setDungeonBounds(@Nullable AABB dungeonBounds) {
        this.dungeonBounds = dungeonBounds;
    }
    @Override
    @SuppressWarnings("deprecation")
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
        this.setBossName(AncientAetherBossNameGenerator.generateAncientCore(this.getRandom()));
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
        if (state.is(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get())) {
            return AncientAetherBlocks.AEROGETIC_STONE.get().defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.LOCKED_CORRUPTED_LIGHT_AEROGETIC_STONE.get())) {
            return AncientAetherBlocks.CORRUPTED_LIGHT_AEROGETIC_STONE.get().defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.BOSS_DOORWAY_AEROGETIC_STONE.get())) {
            return Blocks.AIR.defaultBlockState();
        }
        if (state.is(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get())) {
            return Blocks.AIR.defaultBlockState();
        }
        return null;
    }

    @Override
    public void setDungeon(@Nullable BossRoomTracker<AncientCore> dungeon) {
        this.dungeon = dungeon;
        if (this.dungeonBounds == null) {
            assert dungeon != null;
            this.dungeonBounds = dungeon.roomBounds();
        }
    }


    @Override
    public BossRoomTracker<AncientCore> getDungeon() {
        return this.dungeon;
    }


    //Boss Bar and Data
    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossFight.setProgress(this.getHealth() / this.getMaxHealth());
        this.trackDungeon();
    }

    @Override
    public void setBossName(Component component) {
        this.entityData.set(DATA_BOSS_NAME_ID, component);
        this.bossFight.setName(component);
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_AWAKE_ID, false);
        this.entityData.define(DATA_BOSS_NAME_ID, Component.literal("Ancient Core"));
    }

    public boolean isAwake() {
        return this.entityData.get(DATA_AWAKE_ID);
    }

    public void setAwake(boolean ready) {
        this.entityData.set(DATA_AWAKE_ID, ready);
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.setBossName(name);
    }


    @Override
    public void addAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addBossSaveData(tag);
        tag.putBoolean("Awake", this.isAwake());
    }

    @Override
    public void readAdditionalSaveData(@Nonnull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readBossSaveData(tag);
        if (tag.contains("Awake")) {
            this.setAwake(tag.getBoolean("Awake"));
        }
    }

    @Override
    public Component getBossName() {
        return this.entityData.get(DATA_BOSS_NAME_ID);
    }

    @Override
    public int getDeathScore() {
        return this.deathScore;
    }

    public int getChatCooldown() {
        return this.chatCooldown;
    }


    //Sounds
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return AetherSoundEvents.ENTITY_SLIDER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AetherSoundEvents.ENTITY_SLIDER_DEATH.get();
    }

    @Nonnull
    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }
}