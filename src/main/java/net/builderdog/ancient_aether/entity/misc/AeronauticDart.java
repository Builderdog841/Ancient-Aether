package net.builderdog.ancient_aether.entity.misc;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.entity.projectile.dart.GoldenDart;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class AeronauticDart extends GoldenDart {
    public AeronauticDart(Level level) {
        super(AncientAetherEntityTypes.AERONAUTIC_DART.get(), level);
        this.setBaseDamage(4.0);
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!level().isClientSide) {
            Entity entity = entityHitResult.getEntity();
            if (!entity.getType().is(AetherTags.Entities.UNLAUNCHABLE) && (entity.onGround() || entity.isInFluidType())) {
                entity.push(0.0, 1.0, 0.0);
                if (entity instanceof ServerPlayer serverPlayer) {
                    serverPlayer.connection.send(new ClientboundSetEntityMotionPacket(serverPlayer));
                }
            }
        }
    }

    public AeronauticDart(EntityType<? extends GoldenDart> type, Level level) {
        super(type, level);
    }
}