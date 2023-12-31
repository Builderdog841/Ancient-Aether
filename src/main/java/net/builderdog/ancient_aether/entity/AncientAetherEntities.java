package net.builderdog.ancient_aether.entity;

import com.aetherteam.aether.data.resources.AetherMobCategory;
import com.aetherteam.aether.entity.monster.Swet;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.builderdog.ancient_aether.entity.misc.AeronauticDart;
import net.builderdog.ancient_aether.entity.monster.dungeon.AncientGuardian;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.misc.AncientAetherChestBoatEntity;
import net.builderdog.ancient_aether.entity.monster.dungeon.AeronauticLeaper;
import net.builderdog.ancient_aether.entity.monster.Roothyrn;
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
    public static final RegistryObject<EntityType<Swet>> FESTIVE_SWET = ENTITY_TYPES.register("festive_swet",
            () -> EntityType.Builder.of(Swet::new, AetherMobCategory.AETHER_SURFACE_MONSTER).sized(0.9F, 0.95F).clientTrackingRange(10).build("festive_swet"));
    public static final RegistryObject<EntityType<Roothyrn>> ROOTHYRN = ENTITY_TYPES.register("roothyrn",
            () -> EntityType.Builder.of(Roothyrn::new, MobCategory.MONSTER).sized(0.7f, 0.7f).clientTrackingRange(16).build(new ResourceLocation(AncientAether.MOD_ID, "roothyrn").toString()));
    public static final RegistryObject<EntityType<AeronauticLeaper>> AERONAUTIC_LEAPER = ENTITY_TYPES.register("aeronautic_leaper",
            () -> EntityType.Builder.of(AeronauticLeaper::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(10).build("aeronautic_leaper"));

    // Boss
    public static final RegistryObject<EntityType<AncientGuardian>> ANCIENT_GUARDIAN = ENTITY_TYPES.register("ancient_guardian", ()
            -> EntityType.Builder.of(AncientGuardian::new, MobCategory.MONSTER).sized(2f, 4f).clientTrackingRange(64).build(new ResourceLocation(AncientAether.MOD_ID, "ancient_guardian").toString()));

    // Misc
    public static final RegistryObject<EntityType<AncientAetherBoatEntity>> BOAT = ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<AncientAetherBoatEntity>of(AncientAetherBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
    public static final RegistryObject<EntityType<AncientAetherChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", ()
            -> EntityType.Builder.<AncientAetherChestBoatEntity>of(AncientAetherChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("chest_boat"));
    public static final RegistryObject<EntityType<AeronauticDart>> AERONAUTIC_DART = ENTITY_TYPES.register("aeronautic_dart",
            () -> EntityType.Builder.<AeronauticDart>of(AeronauticDart::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("aeronautic_dart"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
