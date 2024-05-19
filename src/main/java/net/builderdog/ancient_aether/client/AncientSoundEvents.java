package net.builderdog.ancient_aether.client;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AncientAether.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_GRAPE_VINE_PICK_GRAPES = register("block.grape_vine.pick_grapes");
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_OBELISK_ACTIVATION = register("block.obelisk.activation");

    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_VALKYRUM_RING = register("item.accessory.equip_valkyrum_ring");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_HERMES_RING = register("item.accessory.equip_hermes_ring");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_GROWTH_RING = register("item.accessory.equip_growth_ring");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_WARRIOR_RING = register("item.accessory.equip_warrior_ring");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_RING = register("item.accessory.equip_ancient_ring");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT = register("item.accessory.equip_valkyrum_pendant");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_HERMES_PENDANT = register("item.accessory.equip_hermes_pendant");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_WARRIOR_PENDANT = register("item.accessory.equip_warrior_pendant");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_GROWTH_PENDANT = register("item.accessory.equip_growth_pendant");
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_PENDANT = register("item.accessory.equip_ancient_pendant");

    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLUFFALO_AMBIENT = register("entity.fluffalo.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLUFFALO_MILK = register("entity.fluffalo.milk");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLUFFALO_HURT = register("entity.fluffalo.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLUFFALO_DEATH = register("entity.fluffalo.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SLAMMROOT_JUMP = register("entity.slammroot.jump");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SLAMMROOT_HURT = register("entity.slammroot.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SLAMMROOT_DEATH = register("entity.slammroot.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AERONAUTIC_LEAPER_JUMP = register("entity.aeronautic_leaper.jump");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AERONAUTIC_LEAPER_HURT = register("entity.aeronautic_leaper.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AERONAUTIC_LEAPER_DEATH = register("entity.aeronautic_leaper.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MUTATED_AECHOR_PLANT_SHOOT_NEEDLE = register("entity.mutated_aechor_plant.shoot.needle");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MUTATED_AECHOR_PLANT_SHOOT_SPORE_BOMB = register("entity.mutated_aechor_plant.shoot.spore_bomb");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MUTATED_AECHOR_PLANT_HURT = register("entity.mutated_aechor_plant.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MUTATED_AECHOR_PLANT_DEATH = register("entity.mutated_aechor_plant.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_REMEDY_CRYSTAL_EXPLODE = register("entity.remedy_crystal.explode");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String location) {
        return SOUNDS.register(location, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AncientAether.MODID, location)));
    }
}