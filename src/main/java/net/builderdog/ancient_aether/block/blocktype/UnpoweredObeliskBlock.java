package net.builderdog.ancient_aether.block.blocktype;

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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class UnpoweredObeliskBlock extends Block {
    public UnpoweredObeliskBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        super.use(state, level, pos, player, hand, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (player instanceof ServerPlayer serverPlayer && serverPlayer.level() instanceof ServerLevel
                && serverPlayer.getAdvancements().getOrStartProgress(Objects.requireNonNull(serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("aether:gold_dungeon")))).isDone()) {
            if (serverPlayer.getMainHandItem().getItem() == AncientAetherItems.ANCIENT_RUNE.get()) {
                ItemStack stack = player.getMainHandItem();
                ServerPlayer livingEntity = (ServerPlayer) player;
                if (!livingEntity.getAbilities().instabuild) {
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    stack.shrink(1);
                }
                for (int x1 = Mth.floor(x -8); x1 <= Mth.ceil(x + 8); x1++) {
                    for (int y1 = Mth.floor(y - 10); y1 <= Mth.ceil(y + 18); y1++) {
                        for (int z1 = Mth.floor(z - 8); z1 <= Mth.ceil(z + 8); z1++) {
                            BlockPos checkedPos = new BlockPos(x1, y1, z1);
                            BlockState checkedState = level.getBlockState(checkedPos);

                            if (checkedState.getBlock() == AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                            if (checkedState.getBlock() == AncientAetherBlocks.TREASURE_DOORWAY_LIGHT_AEROGETIC_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                        }
                    }
                }
                if (state.getBlock() == AncientAetherBlocks.UNPOWERED_ANCIENT_OBELISK.get()) {
                    level.setBlockAndUpdate(pos, AncientAetherBlocks.ANCIENT_OBELISK.get().defaultBlockState());
                }
                ServerPlayer _player = (ServerPlayer) player;
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("ancient_aether:unlock_ancient_dungeon"));
                assert _adv != null;
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria())
                        _player.getAdvancements().award(_adv, criteria);
                }
            }
        } else {
            if (!level.isClientSide) {
                player.displayClientMessage(Component.translatable("gui.ancient_aether.obelisk_sun_spirit").withStyle(ChatFormatting.RED), true);
            } else {
                level.playSound(player, pos, AncientAetherSoundEvents.BLOCK_OBELISK_ACTIVATION.get(), SoundSource.BLOCKS, 0.8f,
                        0.5f + (((float) (Math.pow(level.random.nextDouble(), 2.5))) * 0.5f));
                return InteractionResult.sidedSuccess(true);
            }
        }
        return InteractionResult.SUCCESS;
    }
}