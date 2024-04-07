package net.builderdog.ancient_aether.effect;

import com.aetherteam.aether.effect.AetherEffects;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, AncientAether.MODID);

    public static final RegistryObject<Potion> POISON_BOMB_INEBRIATION = POTIONS.register("poison_bomb_inebriation", () -> new Potion(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 100, 0)));
}