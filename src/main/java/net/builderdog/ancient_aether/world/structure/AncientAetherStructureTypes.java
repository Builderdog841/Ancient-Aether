package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structure.jigsaw.BuriedJigsawStructure;
import net.builderdog.ancient_aether.world.structure.jigsaw.SkylandsJigsawStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, AncientAether.MODID);
    public static final RegistryObject<StructureType<SkylandsJigsawStructure>> SKYLANDS_JIGSAW = STRUCTURE_TYPES.register("jigsaw_skylands", () -> () -> SkylandsJigsawStructure.CODEC);
    public static final RegistryObject<StructureType<BuriedJigsawStructure>> BURIED_JIGSAW = STRUCTURE_TYPES.register("jigsaw_buried", () -> () -> BuriedJigsawStructure.CODEC);
}