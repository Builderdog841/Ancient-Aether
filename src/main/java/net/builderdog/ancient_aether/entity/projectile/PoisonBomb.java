package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class PoisonBomb extends AbstractDart {

    public PoisonBomb(EntityType<? extends PoisonBomb> type, Level level) {
        super(type, level, null);
        setNoGravity(false);
    }

    public PoisonBomb(Level level, LivingEntity shooter) {
        super(AncientAetherEntityTypes.POISON_BOMB.get(), level, shooter, null);
        setNoGravity(false);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (!level().isClientSide()) {
            AreaEffectCloud areaEffectCloud = EntityType.AREA_EFFECT_CLOUD.create(level());
            if (areaEffectCloud != null) {
                areaEffectCloud.setPos(getX(), getY(), getZ());
                areaEffectCloud.setRadius(4.0F);
                areaEffectCloud.setDuration(300);
                areaEffectCloud.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 60, 1));
                level().addFreshEntity(areaEffectCloud);
            }
            discard();
        }
    }
}