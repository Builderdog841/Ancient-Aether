package net.builderdog.ancient_aether.entity.passive;

import com.aetherteam.aether.entity.ai.goal.EatAetherGrassGoal;
import com.aetherteam.aether.entity.ai.goal.FallingRandomStrollGoal;
import com.aetherteam.aether.entity.passive.AetherAnimal;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

@SuppressWarnings("deprecation")
public class Fluffalo extends WyndcapsAnimal implements Shearable, IForgeShearable {
    private static final EntityDataAccessor<Boolean> SHEARED = SynchedEntityData.defineId(Fluffalo.class, EntityDataSerializers.BOOLEAN);
    private int eatAnimationTick;
    private EatAetherGrassGoal eatBlockGoal;

    public Fluffalo(EntityType<? extends AetherAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(AncientAetherTags.Items.FLUFFALO_TEMPTATION_ITEMS);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(@NotNull LivingEntity entity) {
                return mob.getBbWidth() * mob.getBbWidth() + entity.getBbWidth();
            }
        });
        eatBlockGoal = new EatAetherGrassGoal(this);
        goalSelector.addGoal(0, new FloatGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        goalSelector.addGoal(3, new TemptGoal(this, 1.25, Ingredient.of(AncientAetherTags.Items.FLUFFALO_TEMPTATION_ITEMS), false));
        goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        goalSelector.addGoal(5, eatBlockGoal);
        goalSelector.addGoal(6, new FallingRandomStrollGoal(this, 1.0));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Nonnull
    public static AttributeSupplier.Builder createMobAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ATTACK_DAMAGE, 4.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.ATTACK_KNOCKBACK, 2f);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(SHEARED, false);
    }

    public @NotNull InteractionResult mobInteract(Player playerEntity, @Nonnull InteractionHand hand) {
        ItemStack itemStack = playerEntity.getItemInHand(hand);
        if (itemStack.is(Items.BUCKET) && !isBaby()) {
            playerEntity.playSound(AncientAetherSoundEvents.ENTITY_FLUFFALO_MILK.get(), 1.0F, 1.0F);
            ItemStack itemStack1 = ItemUtils.createFilledResult(itemStack, playerEntity, Items.MILK_BUCKET.getDefaultInstance());
            playerEntity.setItemInHand(hand, itemStack1);
            return InteractionResult.sidedSuccess(level().isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public @NotNull ResourceLocation getDefaultLootTable() {
        if (isSheared()) {
            return AncientAetherLoot.ENTITIES_FLUFFALO_SHEARED;
        } else {
            return getType().getDefaultLootTable();
        }
    }

    protected void customServerAiStep() {
        eatAnimationTick = eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (level().isClientSide) {
            eatAnimationTick = Math.max(0, eatAnimationTick - 1);
        }
        super.aiStep();
    }

    public void ate() {
        setSheared(false);
        if (isBaby()) {
            ageUp(60);
        }
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pose, EntityDimensions size) {
        return 0.95F * size.height;
    }

    public float getHeadEatPositionScale(float pos) {
        if (eatAnimationTick <= 0) {
            return -4.0F;
        } else if (eatAnimationTick >= 4 && eatAnimationTick <= 36) {
            return -2.0F;
        } else {
            return eatAnimationTick < 4 ? (eatAnimationTick - pos) / 4.0F : -(eatAnimationTick - 40 - pos) / 4.0F;
        }
    }

    public float getHeadEatAngleScale(float angle) {
        if (eatAnimationTick > 4 && eatAnimationTick <= 36) {
            float f = ((float) (eatAnimationTick - 4) - angle) / 32.0F;
            return (Mth.PI / 5.0F) + 0.21991149F * Mth.sin(f * 28.7F);
        } else {
            return eatAnimationTick > 0 ? (Mth.PI / 5.0F) : getXRot() * Mth.DEG_TO_RAD;
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

    public boolean isSheared() {
        return entityData.get(SHEARED);
    }

    public void setSheared(boolean setSheared) {
        entityData.set(SHEARED, setSheared);
    }

    public boolean readyForShearing() {
        return isAlive() && !isSheared() && !isBaby();
    }

    @Override
    public boolean isShearable(@Nonnull ItemStack item, Level world, BlockPos pos) {
        return readyForShearing();
    }

    @Override
    public void shear(@NotNull SoundSource sound) {
        level().playSound(null, this, SoundEvents.SHEEP_SHEAR, sound, 1.0F, 1.0F);
        setSheared(true);
        int i = 1 + random.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity itementity = spawnAtLocation(AncientAetherBlocks.FLUFFALO_WOOL.get(), 1);
            if (itementity != null) {
                itementity.setDeltaMovement(itementity.getDeltaMovement().add(((random.nextFloat() - random.nextFloat()) * 0.1F), (random.nextFloat() * 0.05F), ((random.nextFloat() - random.nextFloat()) * 0.1F)));
            }
        }

    }

    @Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@Nullable Player player, @Nonnull ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide) {
            setSheared(true);
            int i = 1 + random.nextInt(3);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            for (int j = 0; j < i; ++j) {
                items.add(new ItemStack(AncientAetherBlocks.FLUFFALO_WOOL.get()));
            }
            return items;
        }
        return java.util.Collections.emptyList();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return AncientAetherEntityTypes.FLUFFALO.get().create(level);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Sheared", isSheared());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setSheared(tag.getBoolean("Sheared"));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AncientAetherSoundEvents.ENTITY_FLUFFALO_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damage) {
        return AncientAetherSoundEvents.ENTITY_FLUFFALO_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AncientAetherSoundEvents.ENTITY_FLUFFALO_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }
}