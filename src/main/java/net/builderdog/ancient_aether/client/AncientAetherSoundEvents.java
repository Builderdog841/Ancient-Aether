package net.builderdog.ancient_aether.client;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AncientAether.MOD_ID);

    public static final RegistryObject<SoundEvent> OBELISK_ACTIVATION = register("block.obelisk.obelisk_activation");
    public static final RegistryObject<SoundEvent> HIGHLAND_BUFFALO_AMBIENT = register("entity.highland_buffalo.ambient");
    public static final RegistryObject<SoundEvent> HIGHLAND_BUFFALO_HURT = register("entity.highland_buffalo.hurt");
    public static final RegistryObject<SoundEvent> HIGHLAND_BUFFALO_DEATH = register("entity.highland_buffalo.death");
    public static final RegistryObject<SoundEvent> ROOTHYRN_HURT = register("entity.roothyrn.hurt");
    public static final RegistryObject<SoundEvent> ROOTHYRN_DEATH = register("entity.roothyrn.death");
    public static final RegistryObject<SoundEvent> ROOTHYRN_EMERGES = register("block.roothyrn_trap.trigger");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_RING = register("item.accessory.equip_ancient_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_ANCIENT_PENDANT = register("item.accessory.equip_ancient_pendant");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HEALTH_RING = register("item.accessory.equip_health_ring");
    public static final RegistryObject<SoundEvent> ITEM_ACCESSORY_EQUIP_HEALTH_PENDANT = register("item.accessory.equip_health_pendant");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AncientAether.MOD_ID, name)));
    }
}