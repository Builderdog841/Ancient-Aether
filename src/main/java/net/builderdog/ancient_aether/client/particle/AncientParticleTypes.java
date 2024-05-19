package net.builderdog.ancient_aether.client.particle;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, AncientAether.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TOXIC_SPORES = PARTICLES.register("toxic_spores", () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(TOXIC_SPORES.get(), ToxicSporeParticle.Factory::new);
    }
}