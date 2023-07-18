package net.builderdog.ancient_aether.entity;

import com.aetherteam.aether.data.resources.AetherMobCategory;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.animals.HighlandsBuffalo;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.misc.AncientAetherChestBoatEntity;
import net.builderdog.ancient_aether.entity.misc.VeloxZephyrSnowball;
import net.builderdog.ancient_aether.entity.mobs.Rootling;
import net.builderdog.ancient_aether.entity.mobs.VeloxZephyr;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<EntityType<HighlandsBuffalo>> HIGHLANDS_BUFFALO =
            ENTITY_TYPES.register("highlands_buffalo",
                    () -> EntityType.Builder.of(HighlandsBuffalo::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f).clientTrackingRange(10)
                            .build(new ResourceLocation(AncientAether.MOD_ID, "highlands_buffalo").toString()));
    public static final RegistryObject<EntityType<Rootling>> ROOTLING =
            ENTITY_TYPES.register("rootling",
                    () -> EntityType.Builder.of(Rootling::new, MobCategory.MONSTER)
                            .sized(0.7f, 0.7f).clientTrackingRange(16)
                            .build(new ResourceLocation(AncientAether.MOD_ID, "rootling").toString()));
    public static final RegistryObject<EntityType<VeloxZephyr>> VELOX_ZEPHYR =
            ENTITY_TYPES.register("velox_zephyr",
                    () -> EntityType.Builder.of(VeloxZephyr::new, AetherMobCategory.AETHER_SKY_MONSTER)
                            .sized(4.5F, 3.5F).clientTrackingRange(10)
                            .build(new ResourceLocation(AncientAether.MOD_ID, "velox_zephyr").toString()));
    public static final RegistryObject<EntityType<AncientAetherBoatEntity>> BOAT =
            ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<AncientAetherBoatEntity>of(AncientAetherBoatEntity::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10)
                    .build("boat"));
    public static final RegistryObject<EntityType<AncientAetherChestBoatEntity>> CHEST_BOAT =
            ENTITY_TYPES.register("chest_boat",
            () -> EntityType.Builder.<AncientAetherChestBoatEntity>of(AncientAetherChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10)
                    .build("chest_boat"));
    public static final RegistryObject<EntityType<VeloxZephyrSnowball>> VELOX_ZEPHYR_SNOWBALL =
            ENTITY_TYPES.register("velox_zephyr_snowball",
            () -> EntityType.Builder.<VeloxZephyrSnowball>of(VeloxZephyrSnowball::new, MobCategory.MISC)
                    .sized(1.0F, 1.0F).clientTrackingRange(4).updateInterval(10)
                    .build("velox_zephyr_snowball"));


    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AncientAetherEntities.VELOX_ZEPHYR.get(), VeloxZephyr.createMobAttributes().build());
    }
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
