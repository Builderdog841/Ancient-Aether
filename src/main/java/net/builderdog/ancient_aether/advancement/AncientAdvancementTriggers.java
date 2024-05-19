package net.builderdog.ancient_aether.advancement;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAdvancementTriggers {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, AncientAether.MODID);
    public static final DeferredHolder<CriterionTrigger<?>, ObeliskTrigger> OBELISK_ACTIVATION = TRIGGERS.register("obelisk_activation", ObeliskTrigger::new);
}