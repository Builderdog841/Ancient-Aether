package net.builderdog.ancient_aether.effects.gravity;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ReversedGravityEffect extends MobEffect {
    private int effectDuration;

    public ReversedGravityEffect() {
        super(MobEffectCategory.HARMFUL, 5031241);
    }
}