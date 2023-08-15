package net.builderdog.ancient_aether.event;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.builderdog.ancient_aether.entity.monster.LeapingSentry;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherEvents {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntities.HIGHLAND_BUFFALO.get(), HighlandBuffalo.createMobAttributes().build());
        event.put(AncientAetherEntities.ROOTHYRN.get(), Roothyrn.createMobAttributes().build());
        event.put(AncientAetherEntities.LEAPING_SENTRY.get(), LeapingSentry.createMobAttributes().build());
    }
}