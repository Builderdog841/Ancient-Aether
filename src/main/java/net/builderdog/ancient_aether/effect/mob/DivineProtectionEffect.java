package net.builderdog.ancient_aether.effect.mob;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DivineProtectionEffect extends MobEffect {

    public DivineProtectionEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x6A8282);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}