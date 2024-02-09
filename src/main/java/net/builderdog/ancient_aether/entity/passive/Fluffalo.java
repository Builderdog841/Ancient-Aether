package net.builderdog.ancient_aether.entity.passive;

import com.aetherteam.aether.entity.ai.goal.FallingRandomStrollGoal;
import com.aetherteam.aether.entity.passive.AetherAnimal;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class Fluffalo extends WyndcapsAnimal {

    public Fluffalo(EntityType<? extends AetherAnimal> entityType, Level level) {
        super(entityType, level);
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
        goalSelector.addGoal(0, new FloatGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        goalSelector.addGoal(3, new TemptGoal(this, 1.25, Ingredient.of(AncientAetherTags.Items.FLUFFALO_TEMPTATION_ITEMS), false));
        goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        goalSelector.addGoal(5, new FallingRandomStrollGoal(this, 1.0));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AncientAetherSoundEvents.FLUFFALO_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) { return AncientAetherSoundEvents.FLUFFALO_HURT.get();}

    @Nonnull
    public InteractionResult mobInteract(Player playerEntity, @Nonnull InteractionHand hand) {
        ItemStack itemStack = playerEntity.getItemInHand(hand);
        if (itemStack.is(Items.BUCKET) && !isBaby()) {
            playerEntity.playSound( AncientAetherSoundEvents.FLUFFALO_MILK.get(), 1.0F, 1.0F);
            ItemStack itemStack1 = ItemUtils.createFilledResult(itemStack, playerEntity, Items.MILK_BUCKET.getDefaultInstance());
            playerEntity.setItemInHand(hand, itemStack1);
            return InteractionResult.sidedSuccess(level().isClientSide);
        } else {
            return super.mobInteract(playerEntity, hand);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AncientAetherSoundEvents.FLUFFALO_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob ageableMob) {
        return AncientAetherEntityTypes.FLUFFALO.get().create(level);
    }
}