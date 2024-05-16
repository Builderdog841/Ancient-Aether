package net.builderdog.ancient_aether.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import org.jetbrains.annotations.NotNull;

public class NaturesBoostEffect extends MobEffect {
    public NaturesBoostEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x8FA8A3);
    }

    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        Level level = entity.level();
        if (!level.isClientSide) {
            for (int i = 0; i < 4; ++i) {
                int j = Mth.floor(entity.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                int k = Mth.floor(entity.getY());
                int l = Mth.floor(entity.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos pos = new BlockPos(j, k, l);
                BlockPos posBelow = new BlockPos(j, k - 1, l);
                Block block = level.getBlockState(posBelow).getBlock();

                if (block instanceof BonemealableBlock) {
                    if (level.isEmptyBlock(pos)) {
                        if (level instanceof ServerLevel serverLevel) {
                            ((BonemealableBlock) block).performBonemeal(serverLevel, level.getRandom(), posBelow, level.getBlockState(posBelow));
                        }
                    }
                }
            }
        }
    }
}