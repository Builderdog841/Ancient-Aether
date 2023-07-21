package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantedSentryRuneItem extends Item {
    public EnchantedSentryRuneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack item = context.getItemInHand();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        LevelAccessor world = context.getLevel();
        double x = context.getClickedPos().getX();
        double y = context.getClickedPos().getY();
        double z = context.getClickedPos().getZ();

        if (state.getBlock() == AncientAetherBlocks.BROKEN_ENCHANTED_OBELISK.get()) {
            if (player instanceof ServerPlayer _plr0 && _plr0.level instanceof ServerLevel
                    && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("aether:silver_dungeon"))).isDone()) {
                if (player != null && !level.isClientSide) {
                    level.setBlockAndUpdate(pos, AncientAetherBlocks.ENCHANTED_OBELISK.get().defaultBlockState());
                    player.awardStat(Stats.ITEM_USED.get(item.getItem()));
                    item.shrink(1);
                    for (int x1 = Mth.floor(x - 30); x1 <= Mth.ceil(x + 30); x1++) {
                        for (int y1 = Mth.floor(y - 15); y1 <= Mth.ceil(y + 20); y1++) {
                            for (int z1 = Mth.floor(z - 30); z1 <= Mth.ceil(z + 30); z1++) {
                                BlockPos checkedPos = new BlockPos(x1, y1, z1);
                                BlockState checkedState = level.getBlockState(checkedPos);

                                if (checkedState.getBlock() == AetherBlocks.LOCKED_CARVED_STONE.get()) {
                                    level.setBlockAndUpdate(checkedPos, AetherBlocks.CARVED_STONE.get().defaultBlockState());
                                }
                                if (checkedState.getBlock() == AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get()) {
                                    level.setBlockAndUpdate(checkedPos, AncientAetherBlocks.CARVED_STONE_MOSAIC.get().defaultBlockState());
                                }
                                if (checkedState.getBlock() == AncientAetherBlocks.LOCKED_ENCHANTED_SENTRY_STONE.get()) {
                                    level.setBlockAndUpdate(checkedPos, AncientAetherBlocks.ENCHANTED_SENTRY_STONE.get().defaultBlockState());
                                }
                                if (checkedState.getBlock() == AetherBlocks.BOSS_DOORWAY_CARVED_STONE.get()) {
                                    level.setBlockAndUpdate(checkedPos, Blocks.AIR.defaultBlockState());
                                }
                            }
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
                    } else {
                    }
        return InteractionResult.PASS;
    }
}
