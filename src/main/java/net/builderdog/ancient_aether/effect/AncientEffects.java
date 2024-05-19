package net.builderdog.ancient_aether.effect;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, AncientAether.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> DIVINE_PROTECTION = EFFECTS.register("divine_protection", () -> new DivineProtectionEffect().addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "CB33E1C-E2D6-4A0B-9562-55C25FE53A1E", 3, AttributeModifier.Operation.ADDITION));
    public static final DeferredHolder<MobEffect, MobEffect> NATURES_BOOST = EFFECTS.register("natures_boost", NaturesBoostEffect::new);
}