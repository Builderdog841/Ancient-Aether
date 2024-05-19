package net.builderdog.ancient_aether.block.blocktype;

import net.builderdog.ancient_aether.advancement.AncientAdvancementTriggers;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.ChatFormatting;
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

public class ObeliskBlock extends Block {
    public ObeliskBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        super.use(state, level, pos, player, hand, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (player instanceof ServerPlayer serverPlayer && serverPlayer.level() instanceof ServerLevel
                && serverPlayer.getAdvancements().getOrStartProgress(Objects.requireNonNull(serverPlayer.server.getAdvancements().get(new ResourceLocation("aether:gold_dungeon")))).isDone()) {
            if (serverPlayer.getMainHandItem().getItem() == AncientItems.ANCIENT_RUNE.get()) {
                ItemStack stack = player.getMainHandItem();
                AncientAdvancementTriggers.OBELISK_ACTIVATION.get().trigger(serverPlayer, serverPlayer.getMainHandItem());
                if (!serverPlayer.getAbilities().instabuild) {
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    stack.shrink(1);
                }
                for (int x1 = Mth.floor(x -8); x1 <= Mth.ceil(x + 8); x1++) {
                    for (int y1 = Mth.floor(y - 10); y1 <= Mth.ceil(y + 18); y1++) {
                        for (int z1 = Mth.floor(z - 8); z1 <= Mth.ceil(z + 8); z1++) {
                            BlockPos checkedPos = new BlockPos(x1, y1, z1);
                            BlockState checkedState = level.getBlockState(checkedPos);

                            if (checkedState.getBlock() == AncientBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                            if (checkedState.getBlock() == AncientBlocks.TREASURE_DOORWAY_AERONAUTIC_STONE.get()) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                            if (checkedState.getBlock() == Blocks.VINE) {
                                level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                            }
                        }
                    }
                }
                if (state.getBlock() == AncientBlocks.ANCIENT_OBELISK.get()) {
                    level.setBlockAndUpdate(pos, AncientBlocks.POWERED_OBELISK.get().defaultBlockState());
                }
                level.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, AncientSoundEvents.BLOCK_OBELISK_ACTIVATION.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.sidedSuccess(true);
            }
        }
        else {
            if (!level.isClientSide) {
                player.displayClientMessage(Component.translatable("gui.ancient_aether.obelisk.requirement").withStyle(ChatFormatting.RED), true);
            }
        }
        return InteractionResult.SUCCESS;
    }
}