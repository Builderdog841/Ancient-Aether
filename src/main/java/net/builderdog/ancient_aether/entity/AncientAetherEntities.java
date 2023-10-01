package net.builderdog.ancient_aether.entity;

import com.aetherteam.aether.data.resources.AetherMobCategory;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.builderdog.ancient_aether.entity.monster.boss.ancient_core.AncientCore;
import net.builderdog.ancient_aether.entity.monster.boss.ancient_guardian.AncientGuardian;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.misc.AncientAetherChestBoatEntity;
import net.builderdog.ancient_aether.entity.misc.GravititeDart;
import net.builderdog.ancient_aether.entity.misc.WyndZephyrSnowball;
import net.builderdog.ancient_aether.entity.monster.AeronauticLeaper;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
import net.builderdog.ancient_aether.entity.monster.WyndZephyr;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AncientAether.MOD_ID);


    // Animals
    public static final RegistryObject<EntityType<HighlandBuffalo>> HIGHLAND_BUFFALO = ENTITY_TYPES.register("highland_buffalo",
            () -> EntityType.Builder.of(HighlandBuffalo::new, MobCategory.CREATURE).sized(1.5f, 1.75f).clientTrackingRange(10).build(new ResourceLocation(AncientAether.MOD_ID, "highland_buffalo").toString()));

    // Monster
    public static final RegistryObject<EntityType<Roothyrn>> ROOTHYRN = ENTITY_TYPES.register("roothyrn",
            () -> EntityType.Builder.of(Roothyrn::new, MobCategory.MONSTER).sized(0.7f, 0.7f).clientTrackingRange(16).build(new ResourceLocation(AncientAether.MOD_ID, "roothyrn").toString()));
    public static final RegistryObject<EntityType<AeronauticLeaper>> AERONAUTIC_LEAPER = ENTITY_TYPES.register("aeronautic_leaper",
            () -> EntityType.Builder.of(AeronauticLeaper::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(10).build("aeronautic_leaper"));
    public static final RegistryObject<EntityType<WyndZephyr>> WYND_ZEPHYR =
            ENTITY_TYPES.register("wynd_zephyr",
                    () -> EntityType.Builder.of(WyndZephyr::new, AetherMobCategory.AETHER_SKY_MONSTER)
                            .sized(4.5F, 3.5F).clientTrackingRange(10)
                            .build(new ResourceLocation(AncientAether.MOD_ID, "wynd_zephyr").toString()));

    // Boss
    public static final RegistryObject<EntityType<AncientGuardian>> ANCIENT_GUARDIAN = ENTITY_TYPES.register("ancient_guardian", ()
            -> EntityType.Builder.of(AncientGuardian::new, MobCategory.MONSTER).sized(2f, 4f).clientTrackingRange(64).build(new ResourceLocation(AncientAether.MOD_ID, "ancient_guardian").toString()));
    public static final RegistryObject<EntityType<AncientCore>> ANCIENT_CORE = ENTITY_TYPES.register("ancient_core", ()
            -> EntityType.Builder.of(AncientCore::new, MobCategory.MONSTER).sized(2f, 4f).clientTrackingRange(64).build(new ResourceLocation(AncientAether.MOD_ID, "ancient_core").toString()));

    // Misc
    public static final RegistryObject<EntityType<AncientAetherBoatEntity>> BOAT = ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<AncientAetherBoatEntity>of(AncientAetherBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
    public static final RegistryObject<EntityType<AncientAetherChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", ()
            -> EntityType.Builder.<AncientAetherChestBoatEntity>of(AncientAetherChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("chest_boat"));
    public static final RegistryObject<EntityType<GravititeDart>> GRAVITITE_DART = ENTITY_TYPES.register("gravitite_dart",
            () -> EntityType.Builder.<GravititeDart>of(GravititeDart::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("gravitite_dart"));
    public static final RegistryObject<EntityType<WyndZephyrSnowball>> WYND_ZEPHYR_SNOWBALL =
            ENTITY_TYPES.register("wynd_zephyr_snowball",
                    () -> EntityType.Builder.<WyndZephyrSnowball>of(WyndZephyrSnowball::new, MobCategory.MISC)
                            .sized(1.0F, 1.0F).clientTrackingRange(4).updateInterval(10)
                            .build("wynd_zephyr_snowball"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
