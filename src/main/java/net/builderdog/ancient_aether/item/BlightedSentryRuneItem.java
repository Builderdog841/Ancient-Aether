package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlightedSentryRuneItem extends Item {

    public BlightedSentryRuneItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack item = context.getItemInHand();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();

        if (state.getBlock() == AncientAetherBlocks.BROKEN_BLIGHTED_OBELISK.get()) {
            if (player != null && !level.isClientSide) {
                level.setBlockAndUpdate(pos, AncientAetherBlocks.BLIGHTED_OBELISK.get().defaultBlockState());
                player.awardStat(Stats.ITEM_USED.get(item.getItem()));
                item.shrink(1);
            }
            level.playSound(player, pos, AncientAetherSoundEvents.OBELISK_ACTIVATION.get(), SoundSource.BLOCKS, 0.8f,
                    0.5f + (((float)(Math.pow(level.random.nextDouble(), 2.5))) * 0.5f));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else {
            return InteractionResult.PASS;
        }
    }
}