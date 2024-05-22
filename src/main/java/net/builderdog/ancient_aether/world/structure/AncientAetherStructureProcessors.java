package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structure.processor.RemoveWaterloggingProcessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherStructureProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES = DeferredRegister.create(BuiltInRegistries.STRUCTURE_PROCESSOR, AncientAether.MODID);

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<RemoveWaterloggingProcessor>> REMOVE_WATERLOGGING = STRUCTURE_PROCESSOR_TYPES.register("remove_waterlogging", () -> () -> RemoveWaterloggingProcessor.CODEC);
}