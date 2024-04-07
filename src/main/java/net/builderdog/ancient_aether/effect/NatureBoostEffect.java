package net.builderdog.ancient_aether.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NatureBoostEffect extends MobEffect {
    private int effectDuration;
    public NatureBoostEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x8FA8A3);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        effectDuration = duration;
        return true;
    }
}