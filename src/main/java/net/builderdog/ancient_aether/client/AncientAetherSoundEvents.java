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
    public static final RegistryObject<SoundEvent> HIGHLANDS_BUFFALO_AMBIENT = register("entity.highlands_buffalo.ambient");
    public static final RegistryObject<SoundEvent> HIGHLANDS_BUFFALO_HURT = register("entity.highlands_buffalo.hurt");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AncientAether.MOD_ID, name)));
    }
}