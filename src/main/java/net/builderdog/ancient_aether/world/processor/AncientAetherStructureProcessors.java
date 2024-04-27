package net.builderdog.ancient_aether.world.processor;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherStructureProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, AncientAether.MODID);

    public static final RegistryObject<StructureProcessorType<DungeonEntranceProcessor>> DUNGEON_ENTRANCE = STRUCTURE_PROCESSOR_TYPES.register("dungeon_entrance", () -> () -> DungeonEntranceProcessor.CODEC);
}