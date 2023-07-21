package net.builderdog.ancient_aether.event;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.animals.HighlandsBuffalo;
import net.builderdog.ancient_aether.entity.mobs.Rootling;
import net.builderdog.ancient_aether.entity.mobs.VeloxZephyr;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherEvents {

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(AncientAetherEntities.VELOX_ZEPHYR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VeloxZephyr::checkVeloxZephyrSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntities.VELOX_ZEPHYR.get(), VeloxZephyr.createMobAttributes().build());
        event.put(AncientAetherEntities.VELOX_WHIRLWIND.get(), VeloxZephyr.createMobAttributes().build());
        event.put(AncientAetherEntities.HIGHLANDS_BUFFALO.get(), HighlandsBuffalo.createMobAttributes().build());
        event.put(AncientAetherEntities.ROOTLING.get(), Rootling.createMobAttributes().build());
    }
}