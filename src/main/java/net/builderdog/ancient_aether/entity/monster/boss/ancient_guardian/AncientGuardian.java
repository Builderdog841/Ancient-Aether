package net.builderdog.ancient_aether.entity.monster.boss.ancient_guardian;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.entity.AetherBossMob;
import com.aetherteam.aether.entity.ai.AetherBlockPathTypes;
import com.aetherteam.nitrogen.entity.BossRoomTracker;
import com.aetherteam.aether.entity.ai.goal.ContinuousMeleeAttackGoal;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.datagen.resources.AncientAetherStructureRegistry;
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
import net.minecraft.tags.DamageTypeTags;
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
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.EnumSet;
import java.util.function.Predicate;

public class AncientGuardian extends PathfinderMob implements AetherBossMob<AncientGuardian>, Enemy, IEntityAdditionalSpawnData {
    private static final EntityDataAccessor<Boolean> DATA_IS_READY = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Component> DATA_BOSS_NAME = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.COMPONENT);
    public static final EntityDataAccessor<Boolean> DATA_AWAKE_ID = SynchedEntityData.defineId(AncientGuardian.class, EntityDataSerializers.BOOLEAN);
    private final ServerBossEvent bossFight;

    @Nullable
    private AABB dungeonBounds;

    public AncientGuardian(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        bossFight = new ServerBossEvent(this.getBossName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
        bossFight.setVisible(false);
        xpReward = 0;
        setPathfindingMalus(AetherBlockPathTypes.BOSS_DOORWAY, -1.0F);
        setPersistenceRequired();
    }

    protected void registerGoals() {
        goalSelector.addGoal(0, new AncientGuardian.DoNothingGoal(this));
        targetSelector.addGoal(2, new ContinuousMeleeAttackGoal(this, 1.0, false));
        goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        targetSelector.addGoal(1, new HurtByTargetGoal(this, AncientGuardian.class));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (livingEntity) -> this.isBossFight()));
    }

    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FOLLOW_RANGE, 64.0);
    }

    @Override
    @SuppressWarnings("deprecation")
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
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
    public void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_IS_READY, false);
        this.getEntityData().define(DATA_AWAKE_ID, false);
        this.getEntityData().define(DATA_BOSS_NAME, Component.literal("Ancient Guardian"));
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

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        }
        if (this.isReady()) {
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
        }
        return false;
    }

    @Override
    public void closeRoom() {
        AetherBossMob.super.closeRoom();
    }

    @Override
    public void openRoom() {
        AetherBossMob.super.openRoom();
    }

    @Override
    public void evaporate(AncientGuardian entity, BlockPos min, BlockPos max, Predicate<BlockState> check) {
        AetherBossMob.super.evaporate(entity, min, max, check);
    }

    @Override
    public void evaporateEffects(AncientGuardian entity, BlockPos pos) {
        AetherBossMob.super.evaporateEffects(entity, pos);
    }

    @Override
    public Pair<BlockPos, BlockPos> getDefaultBounds(AncientGuardian entity) {
        return AetherBossMob.super.getDefaultBounds(entity);
    }

    @Nullable
    @Override
    public ResourceLocation getBossBarTexture() {
        return new ResourceLocation(Aether.MODID, "textures/gui/boss_bar_valkyrie_queen.png");
    }

    public void setDungeonBounds(@Nullable AABB dungeonBounds) {
        this.dungeonBounds = dungeonBounds;
    }

    @Override
    public Component getBossName() {
        return null;
    }

    @Override
    public void setBossName(Component component) {

    }

    @Override
    public boolean isBossFight() {
        return false;
    }

    @Override
    public void setBossFight(boolean b) {

    }

    @Nullable
    @Override
    public BossRoomTracker<AncientGuardian> getDungeon() {
        return null;
    }

    @Override
    public void setDungeon(@Nullable BossRoomTracker<AncientGuardian> bossRoomTracker) {

    }

    @Override
    public int getDeathScore() {
        return 0;
    }

    @Override
    public void trackDungeon() {
        AetherBossMob.super.trackDungeon();
    }

    @Override
    public void displayTooFarMessage(Player player) {
        AetherBossMob.super.displayTooFarMessage(player);
    }

    @Override
    public void onDungeonPlayerAdded(@Nullable Player player) {
        AetherBossMob.super.onDungeonPlayerAdded(player);
    }

    @Override
    public void onDungeonPlayerRemoved(@Nullable Player player) {
        AetherBossMob.super.onDungeonPlayerRemoved(player);
    }

    @Override
    public void reset() {

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
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addBossSaveData(tag);
        if (this.dungeonBounds != null) {
            tag.putDouble("DungeonBoundsMinX", this.dungeonBounds.minX);
            tag.putDouble("DungeonBoundsMinY", this.dungeonBounds.minY);
            tag.putDouble("DungeonBoundsMinZ", this.dungeonBounds.minZ);
            tag.putDouble("DungeonBoundsMaxX", this.dungeonBounds.maxX);
            tag.putDouble("DungeonBoundsMaxY", this.dungeonBounds.maxY);
            tag.putDouble("DungeonBoundsMaxZ", this.dungeonBounds.maxZ);
        }
        tag.putBoolean("Ready", this.isReady());
    }

    public boolean isReady() {
        return this.getEntityData().get(DATA_IS_READY);
    }

    public void setReady(boolean ready) {
        this.getEntityData().set(DATA_IS_READY, ready);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readBossSaveData(tag);
        if (tag.contains("DungeonBoundsMinX")) {
            double minX = tag.getDouble("DungeonBoundsMinX");
            double minY = tag.getDouble("DungeonBoundsMinY");
            double minZ = tag.getDouble("DungeonBoundsMinZ");
            double maxX = tag.getDouble("DungeonBoundsMaxX");
            double maxY = tag.getDouble("DungeonBoundsMaxY");
            double maxZ = tag.getDouble("DungeonBoundsMaxZ");
            this.dungeonBounds = new AABB(minX, minY, minZ, maxX, maxY, maxZ);
        }
        if (tag.contains("Ready")) {
            this.setReady(tag.getBoolean("Ready"));
        }
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

    public boolean isAwake() {
        return this.entityData.get(DATA_AWAKE_ID);
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
}