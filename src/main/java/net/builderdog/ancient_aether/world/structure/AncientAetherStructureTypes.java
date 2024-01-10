package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, AncientAether.MOD_ID);
    public static final RegistryObject<StructureType<AdvancedJigsawStructure>> ADVANCED_JIGSAW_STRUCTURE = STRUCTURE_TYPES.register("advanced_jigsaw_structure", () -> () -> AdvancedJigsawStructure.CODEC);
}