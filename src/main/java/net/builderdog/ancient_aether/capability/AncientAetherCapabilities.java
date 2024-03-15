package net.builderdog.ancient_aether.capability;

import net.builderdog.ancient_aether.capability.player.AncientAetherPlayer;
import net.builderdog.ancient_aether.capability.player.AncientAetherPlayerCapability;
import net.builderdog.ancient_aether.capability.player.AncientAetherPlayerProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "aether", bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherCapabilities {
    public static final Capability<AncientAetherPlayer> ANCIENT_AETHER_PLAYER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });
    public AncientAetherCapabilities() {
    }

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(AncientAetherPlayer.class);
    }

    @Mod.EventBusSubscriber(modid = "ancient_aether")
    public static class Registration {
        public Registration() {
        }

        @SubscribeEvent
        public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
            Object var2 = event.getObject();
            if (var2 instanceof Player player) {
                event.addCapability(new ResourceLocation("ancient_aether", "ancient_aether_player"), new AncientAetherPlayerProvider(new AncientAetherPlayerCapability(player)));
            }
        }
    }
}