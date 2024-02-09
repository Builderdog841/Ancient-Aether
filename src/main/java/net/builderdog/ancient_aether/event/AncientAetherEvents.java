package net.builderdog.ancient_aether.event;

import com.aetherteam.aether.entity.monster.Swet;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.builderdog.ancient_aether.entity.monster.dungeon.AeronauticLeaper;
import net.builderdog.ancient_aether.entity.monster.dungeon.boss.AncientGuardian;
import net.builderdog.ancient_aether.entity.passive.Fluffalo;
import net.builderdog.ancient_aether.entity.passive.WyndcapsAnimal;
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
        event.put(AncientAetherEntityTypes.FLUFFALO.get(), Fluffalo.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.ROOTHYRN.get(), Roothyrn.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.AERONAUTIC_LEAPER.get(), AeronauticLeaper.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.ANCIENT_GUARDIAN.get(), AncientGuardian.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.FESTIVE_SWET.get(), Swet.createMobAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(AncientAetherEntityTypes.FLUFFALO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WyndcapsAnimal::checkWyndcapsAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AncientAetherEntityTypes.FESTIVE_SWET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swet::checkSwetSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}