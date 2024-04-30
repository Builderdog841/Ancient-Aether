package net.builderdog.ancient_aether.effect.mob;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NatureBoostEffect extends MobEffect {
    public NatureBoostEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x8FA8A3);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}