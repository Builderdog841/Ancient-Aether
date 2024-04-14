package net.builderdog.ancient_aether.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ToxicSporeParticle extends TextureSheetParticle {

    protected ToxicSporeParticle(ClientLevel clientLevel, double v, double v1, double v2, double v3, double v4, double v5) {
        super(clientLevel, v, v1, v2);
        gravity = -0.1F;
        friction = 0.85F;
        setSize(0.02F, 0.02F);
        quadSize *= random.nextFloat() * 0.6F + 0.2F;
        xd = v3 * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
        yd = v4 * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
        zd = v5 * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
        lifetime = (int)(10.0D / (Math.random() * 0.8D + 0.2D));
    }

    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public record Factory(SpriteSet spriteSet) implements ParticleProvider<SimpleParticleType> {
        @Override
        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ToxicSporeParticle particle = new ToxicSporeParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(spriteSet());
            return particle;
        }
    }
}