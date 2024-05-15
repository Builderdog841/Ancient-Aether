package net.builderdog.ancient_aether.client.particle;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import java.util.function.Supplier;

@Mod(modid = AncientAether.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AncientAether.MODID);

    public static final Supplier<SimpleParticleType> TOXIC_SPORES = PARTICLES.register("toxic_spores", () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(TOXIC_SPORES.get(), ToxicSporeParticle.Factory::new);
    }
}