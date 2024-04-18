package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structure.poolelement.DungeonEntrance;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherStructurePoolElements {
    public static final DeferredRegister<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = DeferredRegister.create(Registries.STRUCTURE_POOL_ELEMENT, AncientAether.MODID);
    public static final RegistryObject<StructurePoolElementType<DungeonEntrance>> DUNGEON_ENTRANCE = STRUCTURE_POOL_ELEMENT.register("dungeon_entrance", () -> () -> DungeonEntrance.CODEC);
}