package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MutatedAechorNeedle extends AbstractDart {
    public MutatedAechorNeedle(EntityType<? extends MutatedAechorNeedle> type, Level level) {
        super(type, level, null);
        setBaseDamage(0.5);
    }

    public MutatedAechorNeedle(Level level, LivingEntity shooter) {
        super(AncientAetherEntityTypes.MUTATED_AECHOR_NEEDLE.get(), level, shooter, null);
        setBaseDamage(0.5);
    }

    protected void doPostHurtEffects(@NotNull LivingEntity living) {
        super.doPostHurtEffects(living);
        living.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 250, 0, false, false, true));
    }
}