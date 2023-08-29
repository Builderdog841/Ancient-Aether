package net.builderdog.ancient_aether.block.functional;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.RotatedPillarBlock.AXIS;

public class BrokenObeliskBlock extends Block {
    public BrokenObeliskBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        super.use(blockstate, world, pos, entity, hand, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        double hitX = hit.getLocation().x;
        double hitY = hit.getLocation().y;
        double hitZ = hit.getLocation().z;
        Level level = world;
        Player player = entity;

        if (player instanceof ServerPlayer _plr0 && _plr0.level instanceof ServerLevel
                && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("aether:silver_dungeon"))).isDone()) {
            if ((player instanceof ServerPlayer _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AncientAetherItems.ANCIENT_RUNE.get()) {
                ItemStack stack = player.getMainHandItem();
                if (!(entity instanceof ServerPlayer _livEnt ? _livEnt.getAbilities().instabuild : false)) {
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    stack.shrink(1);
                }
                for (int x1 = Mth.floor(x - 55); x1 <= Mth.ceil(x + 55); x1++) {
                    for (int y1 = Mth.floor(y - 48); y1 <= Mth.ceil(y + 20); y1++) {
                        for (int z1 = Mth.floor(z - 55); z1 <= Mth.ceil(z + 55); z1++) {
                            BlockPos checkedPos = new BlockPos(x1, y1, z1);
                            BlockState checkedState = level.getBlockState(checkedPos);

                            if (checkedState.getBlock() == AetherBlocks.LOCKED_CARVED_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, AetherBlocks.CARVED_STONE.get().defaultBlockState());
                            }
                            if (checkedState.getBlock() == AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get()) {
                                level.setBlockAndUpdate(checkedPos, AncientAetherBlocks.CARVED_STONE_MOSAIC.get().defaultBlockState().setValue(AXIS, checkedState.getValue(AXIS)));
                            }
                            if (checkedState.getBlock() == AncientAetherBlocks.LOCKED_ANCIENT_SENTRY_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, AncientAetherBlocks.ANCIENT_SENTRY_STONE.get().defaultBlockState());
                            }
                            if (checkedState.getBlock() == AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                            if (checkedState.getBlock() == AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()) {
                                level.setBlockAndUpdate(checkedPos, AncientAetherBlocks.SENTRY_OBELISK.get().defaultBlockState());
                            }
                        }
                    }
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("ancient_aether:aether/unlock_ancient_valkyrian_vaults"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        } else {
            if (player != null && !level.isClientSide) {
                player.displayClientMessage(Component.translatable("gui.ancient_aether.obelisk_valkyrie_queen").withStyle(ChatFormatting.RED), true);
            } else {
                level.playSound(player, pos, AncientAetherSoundEvents.OBELISK_ACTIVATION.get(), SoundSource.BLOCKS, 0.8f,
                        0.5f + (((float) (Math.pow(level.random.nextDouble(), 2.5))) * 0.5f));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.SUCCESS;
    }
}

