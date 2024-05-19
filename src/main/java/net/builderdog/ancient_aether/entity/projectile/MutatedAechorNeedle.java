package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MutatedAechorNeedle extends AbstractDart {
    public MutatedAechorNeedle(EntityType<? extends MutatedAechorNeedle> type, Level level) {
        super(type, level, ItemStack.EMPTY);
        setBaseDamage(6);
    }

    public MutatedAechorNeedle(Level level, LivingEntity shooter) {
        super(AncientEntityTypes.MUTATED_AECHOR_NEEDLE.get(), level, shooter, ItemStack.EMPTY);
        setBaseDamage(6);
    }

    protected void doPostHurtEffects(@NotNull LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 250, 0, false, false, true));
        if (entity.hasEffect(AetherEffects.REMEDY.get())) {
            entity.removeEffect(AetherEffects.REMEDY.get());
        }
    }
}