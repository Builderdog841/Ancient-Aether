package net.builderdog.ancient_aether.item.equipment.tools.abilities;

import net.builderdog.ancient_aether.effect.AncientEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public interface DivineTool {

    default void grantDivineProtectionBuff(Player player, Level level, BlockPos pos, ItemStack stack, BlockState state) {
        if (!level.isClientSide() && state.getDestroySpeed(level, pos) > 0 && stack.isCorrectToolForDrops(state)) {
            if (player.hasEffect(AncientEffects.DIVINE_PROTECTION.get())) {
                if (Objects.requireNonNull(player.getEffect(AncientEffects.DIVINE_PROTECTION.get())).getDuration() < 18000) {
                    player.addEffect(new MobEffectInstance(AncientEffects.DIVINE_PROTECTION.get(), duration(player), 0, false, true, true));
                }
            }
            else player.addEffect(new MobEffectInstance(AncientEffects.DIVINE_PROTECTION.get(), 100, 0, false, true, true));
        }
    }

    default int duration(Player player) {
        return Objects.requireNonNull(player.getEffect(AncientEffects.DIVINE_PROTECTION.get())).getDuration() + 100;
    }
}