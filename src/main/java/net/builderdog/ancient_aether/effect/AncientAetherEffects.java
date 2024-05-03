package net.builderdog.ancient_aether.effect;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AncientAether.MODID);

    public static final RegistryObject<MobEffect> DIVINE_PROTECTION = EFFECTS.register("divine_protection", () -> new DivineProtectionEffect().addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "CB33E1C-E2D6-4A0B-9562-55C25FE53A1E", 3, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> NATURES_BOOST = EFFECTS.register("natures_boost", NaturesBoostEffect::new);
}