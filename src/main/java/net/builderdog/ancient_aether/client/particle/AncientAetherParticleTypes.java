package net.builderdog.ancient_aether.client.particle;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.client.particle.SnowflakeParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<SimpleParticleType> VELOX_WHIRLWIND = PARTICLES.register("velox_whirlwind", () -> new SimpleParticleType(false));

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {

        event.registerSpriteSet(VELOX_WHIRLWIND.get(), VeloxWhirlyParticle.Factory::new);
    }
}