package net.builderdog.ancient_aether.client;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AncientAether.MOD_ID);

    public static final RegistryObject<SoundEvent> BLOCK_ROOTHYRN_TRAP_TRIGGER = register("block.roothyrn_trap.trigger");
    public static final RegistryObject<SoundEvent> BLOCK_OBELISK_ACTIVATION = register("block.obelisk.activation");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_RING = register("item.accessory.equip_ancient_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_PENDANT = register("item.accessory.equip_ancient_pendant");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HEALTH_RING = register("item.accessory.equip_health_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HEALTH_PENDANT = register("item.accessory.equip_health_pendant");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HERMES_RING = register("item.accessory.equip_hermes_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HERMES_PENDANT = register("item.accessory.equip_hermes_pendant");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ARKENIUM_RING = register("item.accessory.equip_arkenium_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ARKENIUM_PENDANT = register("item.accessory.equip_arkenium_pendant");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_VALKYRUM_RING = register("item.accessory.equip_valkyrum_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_VALKYRUM_PENDANT = register("item.accessory.equip_valkyrum_pendant");
    public static final RegistryObject<SoundEvent> ENTITY_FLUFFALO_AMBIENT = register("entity.fluffalo.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_FLUFFALO_HURT = register("entity.fluffalo.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_FLUFFALO_DEATH = register("entity.fluffalo.death");
    public static final RegistryObject<SoundEvent> ENTITY_FLUFFALO_MILK = register("entity.fluffalo.milk");
    public static final RegistryObject<SoundEvent> ENTITY_ROOTHYRN_HURT = register("entity.roothyrn.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_ROOTHYRN_DEATH = register("entity.roothyrn.death");
    public static final RegistryObject<SoundEvent> ENTITY_AERONAUTIC_LEAPER_DEATH = register("entity.aeronautic_leaper.death");
    public static final RegistryObject<SoundEvent> ENTITY_AERONAUTIC_LEAPER_HURT = register("entity.aeronautic_leaper.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_AERONAUTIC_LEAPER_JUMP = register("entity.aeronautic_leaper.jump");


    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AncientAether.MOD_ID, name)));
    }
}