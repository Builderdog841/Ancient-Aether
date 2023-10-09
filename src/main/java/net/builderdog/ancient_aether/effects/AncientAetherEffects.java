package net.builderdog.ancient_aether.effects;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AncientAether.MOD_ID);

   // public static final RegistryObject<MobEffect> LOW_GRAVITY = EFFECTS.register("low_gravity", InebriationEffect::new);
   // public static final RegistryObject<MobEffect> HIGH_GRAVITY = EFFECTS.register("high_gravity", RemedyEffect::new);
  //  public static final RegistryObject<MobEffect> REVERSED_GRAVITY = EFFECTS.register("reversed_gravity", RemedyEffect::new);
}