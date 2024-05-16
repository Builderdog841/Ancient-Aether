package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structure.jigsaw.BuriedJigsawStructure;
import net.builderdog.ancient_aether.world.structure.jigsaw.SkylandsJigsawStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(BuiltInRegistries.STRUCTURE_TYPE, AncientAether.MODID);
    public static final DeferredHolder<StructureType<?>, StructureType<SkylandsJigsawStructure>> SKYLANDS_JIGSAW = STRUCTURE_TYPES.register("jigsaw_skylands", () -> () -> SkylandsJigsawStructure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<BuriedJigsawStructure>> BURIED_JIGSAW = STRUCTURE_TYPES.register("jigsaw_buried", () -> () -> BuriedJigsawStructure.CODEC);
}