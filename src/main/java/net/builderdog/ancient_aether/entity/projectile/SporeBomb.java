package net.builderdog.ancient_aether.entity.projectile;

import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import net.builderdog.ancient_aether.client.particle.AncientParticleTypes;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class SporeBomb extends AbstractDart {

    public SporeBomb(EntityType<? extends SporeBomb> type, Level level) {
        super(type, level, ItemStack.EMPTY);
        setNoGravity(false);
    }

    public SporeBomb(Level level, LivingEntity shooter) {
        super(AncientEntityTypes.SPORE_BOMB.get(), level, shooter, ItemStack.EMPTY);
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
                areaEffectCloud.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 60, 0));
                areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
                areaEffectCloud.setParticle(AncientParticleTypes.TOXIC_SPORES.get());
                level().addFreshEntity(areaEffectCloud);
            }
            discard();
        }
    }
}