package net.builderdog.ancient_aether.entity;

import com.aetherteam.aether.data.resources.AetherMobCategory;
import com.aetherteam.aether.entity.monster.Swet;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherChestBoatEntity;
import net.builderdog.ancient_aether.entity.monster.AeronauticLeaper;
import net.builderdog.ancient_aether.entity.monster.Slammroot;
import net.builderdog.ancient_aether.entity.monster.boss.MutatedAechorPlant;
import net.builderdog.ancient_aether.entity.passive.Fluffalo;
import net.builderdog.ancient_aether.entity.passive.WyndcapsAnimal;
import net.builderdog.ancient_aether.entity.projectile.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AncientAether.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<Fluffalo>> FLUFFALO = ENTITY_TYPES.register("fluffalo", () -> EntityType.Builder.of(Fluffalo::new, MobCategory.CREATURE).sized(1.5F, 1.75F).clientTrackingRange(10).build("fluffalo"));

    public static final DeferredHolder<EntityType<?>, EntityType<Swet>> FESTIVE_SWET = ENTITY_TYPES.register("festive_swet", () -> EntityType.Builder.of(Swet::new, AetherMobCategory.AETHER_SURFACE_MONSTER).sized(0.9F, 0.95F).clientTrackingRange(10).build("festive_swet"));
    public static final DeferredHolder<EntityType<?>, EntityType<Slammroot>> SLAMMROOT = ENTITY_TYPES.register("slammroot", () -> EntityType.Builder.of(Slammroot::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(16).build("slammroot"));
    public static final DeferredHolder<EntityType<?>, EntityType<AeronauticLeaper>> AERONAUTIC_LEAPER = ENTITY_TYPES.register("aeronautic_leaper", () -> EntityType.Builder.of(AeronauticLeaper::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(16).build("aeronautic_leaper"));

    public static final DeferredHolder<EntityType<?>, EntityType<MutatedAechorPlant>> MUTATED_AECHOR_PLANT = ENTITY_TYPES.register("mutated_aechor_plant", () -> EntityType.Builder.of(MutatedAechorPlant::new, MobCategory.MONSTER).sized(3.0F, 2.0F).clientTrackingRange(64).build("mutated_aechor_plant"));

    public static final DeferredHolder<EntityType<?>, EntityType<WindBlow>> WIND_BLOW = ENTITY_TYPES.register("wind_blow", () -> EntityType.Builder.of(WindBlow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("wind_blow"));
    public static final DeferredHolder<EntityType<?>, EntityType<AeronauticDart>> AERONAUTIC_DART = ENTITY_TYPES.register("aeronautic_dart", () -> EntityType.Builder.<AeronauticDart>of(AeronauticDart::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("aeronautic_dart"));
    public static final DeferredHolder<EntityType<?>, EntityType<MutatedAechorNeedle>> MUTATED_AECHOR_NEEDLE = ENTITY_TYPES.register("mutated_aechor_needle", () -> EntityType.Builder.<MutatedAechorNeedle>of(MutatedAechorNeedle::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("mutated_aechor_needle"));
    public static final DeferredHolder<EntityType<?>, EntityType<SporeBomb>> SPORE_BOMB = ENTITY_TYPES.register("spore_bomb", () -> EntityType.Builder.<SporeBomb>of(SporeBomb::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("spore_bomb"));
    public static final DeferredHolder<EntityType<?>, EntityType<RemedyCrystal>> REMEDY_CRYSTAL = ENTITY_TYPES.register("remedy_crystal", () -> EntityType.Builder.<RemedyCrystal>of(RemedyCrystal::new, MobCategory.MISC).sized(1.2F, 1.2F).clientTrackingRange(4).updateInterval(10).build("remedy_crystal"));

    public static final DeferredHolder<EntityType<?>, EntityType<AncientAetherBoatEntity>> BOAT = ENTITY_TYPES.register("boat", () -> EntityType.Builder.<AncientAetherBoatEntity>of(AncientAetherBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<AncientAetherChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<AncientAetherChestBoatEntity>of(AncientAetherChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("chest_boat"));

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntityTypes.FLUFFALO.get(), Fluffalo.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.FESTIVE_SWET.get(), Swet.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.SLAMMROOT.get(), Slammroot.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.AERONAUTIC_LEAPER.get(), AeronauticLeaper.createMobAttributes().build());
        event.put(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get(), MutatedAechorPlant.createMobAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(AncientAetherEntityTypes.FLUFFALO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WyndcapsAnimal::checkWyndcapsAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AncientAetherEntityTypes.FESTIVE_SWET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swet::checkSwetSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AncientAetherEntityTypes.SLAMMROOT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Slammroot::checkSlammrootSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}