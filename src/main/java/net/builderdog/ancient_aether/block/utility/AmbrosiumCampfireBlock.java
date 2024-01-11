package net.builderdog.ancient_aether.block.utility;

import java.util.Optional;
import javax.annotation.Nullable;

import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.blockentity.AncientAetherCampfireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class AmbrosiumCampfireBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape VIRTUAL_FENCE_POST = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    private static final int SMOKE_DISTANCE = 5;
    private final boolean spawnParticles;
    private final int fireDamage;

    public AmbrosiumCampfireBlock(boolean p_51236_, int p_51237_, BlockBehaviour.Properties p_51238_) {
        super(p_51238_);
        spawnParticles = p_51236_;
        fireDamage = p_51237_;
        registerDefaultState(stateDefinition.any().setValue(LIT, Boolean.TRUE).setValue(SIGNAL_FIRE, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    public @NotNull InteractionResult use(@NotNull BlockState p_51274_, Level p_51275_, @NotNull BlockPos p_51276_, @NotNull Player p_51277_, @NotNull InteractionHand p_51278_, @NotNull BlockHitResult p_51279_) {
        BlockEntity blockentity = p_51275_.getBlockEntity(p_51276_);
        if (blockentity instanceof AncientAetherCampfireBlockEntity campfireBlockEntity) {
            ItemStack itemstack = p_51277_.getItemInHand(p_51278_);
            Optional<CampfireCookingRecipe> optional = campfireBlockEntity.getCookableRecipe(itemstack);
            if (optional.isPresent()) {
                if (!p_51275_.isClientSide && campfireBlockEntity.placeFood(p_51277_, p_51277_.getAbilities().instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
                    p_51277_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return InteractionResult.SUCCESS;
                }

                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }

    public void entityInside(BlockState p_51269_, @NotNull Level p_51270_, @NotNull BlockPos p_51271_, @NotNull Entity p_51272_) {
        if (p_51269_.getValue(LIT) && p_51272_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_51272_)) {
            p_51272_.hurt(p_51270_.damageSources().inFire(), fireDamage);
        }

        super.entityInside(p_51269_, p_51270_, p_51271_, p_51272_);
    }

    public void onRemove(BlockState p_51281_, @NotNull Level p_51282_, @NotNull BlockPos p_51283_, BlockState p_51284_, boolean p_51285_) {
        if (!p_51281_.is(p_51284_.getBlock())) {
            BlockEntity blockentity = p_51282_.getBlockEntity(p_51283_);
            if (blockentity instanceof AncientAetherCampfireBlockEntity) {
                Containers.dropContents(p_51282_, p_51283_, ((AncientAetherCampfireBlockEntity)blockentity).getItems());
            }

            super.onRemove(p_51281_, p_51282_, p_51283_, p_51284_, p_51285_);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_51240_) {
        LevelAccessor levelaccessor = p_51240_.getLevel();
        BlockPos blockpos = p_51240_.getClickedPos();
        boolean flag = levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(SIGNAL_FIRE, isSmokeSource(levelaccessor.getBlockState(blockpos.below()))).setValue(LIT, !flag).setValue(FACING, p_51240_.getHorizontalDirection());
    }

    public @NotNull BlockState updateShape(BlockState p_51298_, @NotNull Direction p_51299_, @NotNull BlockState p_51300_, @NotNull LevelAccessor p_51301_, @NotNull BlockPos p_51302_, @NotNull BlockPos p_51303_) {
        if (p_51298_.getValue(WATERLOGGED)) {
            p_51301_.scheduleTick(p_51302_, Fluids.WATER, Fluids.WATER.getTickDelay(p_51301_));
        }

        return p_51299_ == Direction.DOWN ? p_51298_.setValue(SIGNAL_FIRE, isSmokeSource(p_51300_)) : super.updateShape(p_51298_, p_51299_, p_51300_, p_51301_, p_51302_, p_51303_);
    }

    private boolean isSmokeSource(BlockState p_51324_) {
        return p_51324_.is(Blocks.HAY_BLOCK);
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState p_51309_, @NotNull BlockGetter p_51310_, @NotNull BlockPos p_51311_, @NotNull CollisionContext p_51312_) {
        return SHAPE;
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_51307_) {
        return RenderShape.MODEL;
    }

    public void animateTick(BlockState p_220918_, @NotNull Level p_220919_, @NotNull BlockPos p_220920_, @NotNull RandomSource p_220921_) {
        if (p_220918_.getValue(LIT)) {
            if (p_220921_.nextInt(10) == 0) {
                p_220919_.playLocalSound(p_220920_.getX() + 0.5D, p_220920_.getY() + 0.5D, p_220920_.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + p_220921_.nextFloat(), p_220921_.nextFloat() * 0.7F + 0.6F, false);
            }

            if (spawnParticles && p_220921_.nextInt(5) == 0) {
                for(int i = 0; i < p_220921_.nextInt(1) + 1; ++i) {
                    p_220919_.addParticle(ParticleTypes.LAVA, p_220920_.getX() + 0.5D, p_220920_.getY() + 0.5D, p_220920_.getZ() + 0.5D, p_220921_.nextFloat() / 2.0F, 5.0E-5D, p_220921_.nextFloat() / 2.0F);
                }
            }

        }
    }

    public static void dowse(@Nullable Entity p_152750_, LevelAccessor p_152751_, BlockPos p_152752_, BlockState p_152753_) {
        if (p_152751_.isClientSide()) {
            for(int i = 0; i < 20; ++i) {
                makeParticles((Level)p_152751_, p_152752_, p_152753_.getValue(SIGNAL_FIRE), true);
            }
        }

        BlockEntity blockentity = p_152751_.getBlockEntity(p_152752_);
        if (blockentity instanceof AncientAetherCampfireBlockEntity) {
            ((AncientAetherCampfireBlockEntity)blockentity).dowse();
        }

        p_152751_.gameEvent(p_152750_, GameEvent.BLOCK_CHANGE, p_152752_);
    }

    public boolean placeLiquid(@NotNull LevelAccessor p_51257_, @NotNull BlockPos p_51258_, BlockState p_51259_, @NotNull FluidState p_51260_) {
        if (!p_51259_.getValue(BlockStateProperties.WATERLOGGED) && p_51260_.getType() == Fluids.WATER) {
            boolean flag = p_51259_.getValue(LIT);
            if (flag) {
                if (!p_51257_.isClientSide()) {
                    p_51257_.playSound(null, p_51258_, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                dowse(null, p_51257_, p_51258_, p_51259_);
            }

            p_51257_.setBlock(p_51258_, p_51259_.setValue(WATERLOGGED, Boolean.TRUE).setValue(LIT, Boolean.FALSE), 3);
            p_51257_.scheduleTick(p_51258_, p_51260_.getType(), p_51260_.getType().getTickDelay(p_51257_));
            return true;
        } else {
            return false;
        }
    }

    public void onProjectileHit(Level p_51244_, @NotNull BlockState p_51245_, BlockHitResult p_51246_, @NotNull Projectile p_51247_) {
        BlockPos blockpos = p_51246_.getBlockPos();
        if (!p_51244_.isClientSide && p_51247_.isOnFire() && p_51247_.mayInteract(p_51244_, blockpos) && !p_51245_.getValue(LIT) && !p_51245_.getValue(WATERLOGGED)) {
            p_51244_.setBlock(blockpos, p_51245_.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
        }

    }

    public static void makeParticles(Level p_51252_, BlockPos p_51253_, boolean p_51254_, boolean p_51255_) {
        RandomSource randomsource = p_51252_.getRandom();
        SimpleParticleType simpleparticletype = p_51254_ ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
        p_51252_.addAlwaysVisibleParticle(simpleparticletype, true, p_51253_.getX() + 0.5D + randomsource.nextDouble() / 3.0D * (randomsource.nextBoolean() ? 1 : -1), p_51253_.getY() + randomsource.nextDouble() + randomsource.nextDouble(), p_51253_.getZ() + 0.5D + randomsource.nextDouble() / 3.0D * (randomsource.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        if (p_51255_) {
            p_51252_.addParticle(ParticleTypes.SMOKE, p_51253_.getX() + 0.5D + randomsource.nextDouble() / 4.0D * (randomsource.nextBoolean() ? 1 : -1), p_51253_.getY() + 0.4D, p_51253_.getZ() + 0.5D + randomsource.nextDouble() / 4.0D * (randomsource.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
        }

    }

    public static boolean isSmokeyPos(Level p_51249_, BlockPos p_51250_) {
        for(int i = 1; i <= 5; ++i) {
            BlockPos blockpos = p_51250_.below(i);
            BlockState blockstate = p_51249_.getBlockState(blockpos);
            if (isLitCampfire(blockstate)) {
                return true;
            }

            boolean flag = Shapes.joinIsNotEmpty(VIRTUAL_FENCE_POST, blockstate.getCollisionShape(p_51249_, blockpos, CollisionContext.empty()), BooleanOp.AND);
            if (flag) {
                BlockState blockstate1 = p_51249_.getBlockState(blockpos.below());
                return isLitCampfire(blockstate1);
            }
        }

        return false;
    }

    public static boolean isLitCampfire(BlockState p_51320_) {
        return p_51320_.hasProperty(LIT) && p_51320_.is(BlockTags.CAMPFIRES) && p_51320_.getValue(LIT);
    }

    public @NotNull FluidState getFluidState(BlockState p_51318_) {
        return p_51318_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51318_);
    }

    public @NotNull BlockState rotate(BlockState p_51295_, Rotation p_51296_) {
        return p_51295_.setValue(FACING, p_51296_.rotate(p_51295_.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState p_51292_, Mirror p_51293_) {
        return p_51292_.rotate(p_51293_.getRotation(p_51292_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51305_) {
        p_51305_.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos p_152759_, @NotNull BlockState p_152760_) {
        return new AncientAetherCampfireBlockEntity(p_152759_, p_152760_);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker getTicker(Level p_152755_, @NotNull BlockState p_152756_, @NotNull BlockEntityType<T> p_152757_) {
        if (p_152755_.isClientSide) {
            return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::particleTick) : null;
        } else {
            return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cookTick) : createTickerHelper(p_152757_, AncientAetherBlockEntityTypes.CAMPFIRE.get(), AncientAetherCampfireBlockEntity::cooldownTick);
        }
    }

    public boolean isPathfindable(@NotNull BlockState p_51264_, @NotNull BlockGetter p_51265_, @NotNull BlockPos p_51266_, @NotNull PathComputationType p_51267_) {
        return false;
    }

    public static boolean canLight(BlockState p_51322_) {
        return p_51322_.is(BlockTags.CAMPFIRES, (p_51262_) -> p_51262_.hasProperty(WATERLOGGED) && p_51262_.hasProperty(LIT)) && !p_51322_.getValue(WATERLOGGED) && !p_51322_.getValue(LIT);
    }
}