package net.builderdog.ancient_aether.event;

import com.aetherteam.aether.entity.passive.AetherAnimal;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.builderdog.ancient_aether.entity.monster.LeapingSentry;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherEvents {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntities.HIGHLAND_BUFFALO.get(), HighlandBuffalo.createMobAttributes().build());
        event.put(AncientAetherEntities.ROOTHYRN.get(), Roothyrn.createMobAttributes().build());
        event.put(AncientAetherEntities.LEAPING_SENTRY.get(), LeapingSentry.createMobAttributes().build());
        event.put(AncientAetherEntities.ANCIENT_GUARDIAN.get(), AncientGuardian.createMobAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(AncientAetherEntities.HIGHLAND_BUFFALO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}