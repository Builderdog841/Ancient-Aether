package net.builderdog.ancient_aether.entity;

import com.aetherteam.aether.data.resources.AetherMobCategory;
import com.aetherteam.aether.entity.monster.Swet;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.misc.AeronauticDart;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.misc.AncientAetherChestBoatEntity;
import net.builderdog.ancient_aether.entity.misc.MutatedAechorNeedle;
import net.builderdog.ancient_aether.entity.monster.AeronauticLeaper;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.builderdog.ancient_aether.entity.monster.boss.MutatedAechorPlant;
import net.builderdog.ancient_aether.entity.passive.Fluffalo;
import net.builderdog.ancient_aether.entity.passive.WyndcapsAnimal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AncientAether.MODID);

    public static final RegistryObject<EntityType<Fluffalo>> FLUFFALO = ENTITY_TYPES.register("fluffalo",
            () -> EntityType.Builder.of(Fluffalo::new, MobCategory.CREATURE).sized(1.5F, 1.75F).clientTrackingRange(10).build(new ResourceLocation(AncientAether.MODID, "fluffalo").toString()));

    public static final RegistryObject<EntityType<Swet>> FESTIVE_SWET = ENTITY_TYPES.register("festive_swet",
            () -> EntityType.Builder.of(Swet::new, AetherMobCategory.AETHER_SURFACE_MONSTER).sized(0.9F, 0.95F).clientTrackingRange(10).build("festive_swet"));
    public static final RegistryObject<EntityType<Roothyrn>> ROOTHYRN = ENTITY_TYPES.register("roothyrn",
            () -> EntityType.Builder.of(Roothyrn::new, MobCategory.MONSTER).sized(0.7F, 0.7F).clientTrackingRange(16).build(new ResourceLocation(AncientAether.MODID, "roothyrn").toString()));
    public static final RegistryObject<EntityType<AeronauticLeaper>> AERONAUTIC_LEAPER = ENTITY_TYPES.register("aeronautic_leaper",
            () -> EntityType.Builder.of(AeronauticLeaper::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(10).build("aeronautic_leaper"));

    public static final RegistryObject<EntityType<MutatedAechorPlant>> MUTATED_AECHOR_PLANT = ENTITY_TYPES.register("mutated_aechor_plant",
            () -> EntityType.Builder.of(MutatedAechorPlant::new, MobCategory.MONSTER).sized(1.0F, 1.0F).clientTrackingRange(64).build("mutated_aechor_plant"));

    public static final RegistryObject<EntityType<AncientAetherBoatEntity>> BOAT = ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<AncientAetherBoatEntity>of(AncientAetherBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
    public static final RegistryObject<EntityType<AncientAetherChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", ()
            -> EntityType.Builder.<AncientAetherChestBoatEntity>of(AncientAetherChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("chest_boat"));
    public static final RegistryObject<EntityType<AeronauticDart>> AERONAUTIC_DART = ENTITY_TYPES.register("aeronautic_dart",
            () -> EntityType.Builder.<AeronauticDart>of(AeronauticDart::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("aeronautic_dart"));
    public static final RegistryObject<EntityType<MutatedAechorNeedle>> MUTATED_AECHOR_NEEDLE = ENTITY_TYPES.register("mutated_aechor_needle",
            () -> EntityType.Builder.<MutatedAechorNeedle>of(MutatedAechorNeedle::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("mutated_aechor_needle"));

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntityTypes.FLUFFALO.get(), Fluffalo.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.ROOTHYRN.get(), Roothyrn.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.AERONAUTIC_LEAPER.get(), AeronauticLeaper.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get(), MutatedAechorPlant.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.FESTIVE_SWET.get(), Swet.createMobAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(AncientAetherEntityTypes.FLUFFALO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WyndcapsAnimal::checkWyndcapsAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AncientAetherEntityTypes.FESTIVE_SWET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swet::checkSwetSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}