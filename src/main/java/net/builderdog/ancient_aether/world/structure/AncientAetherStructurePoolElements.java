package net.builderdog.ancient_aether.world.structure;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structure.poolelement.UndergroundDungeonRoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherStructurePoolElements {
    public static final DeferredRegister<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = DeferredRegister.create(Registries.STRUCTURE_POOL_ELEMENT, AncientAether.MODID);
    public static final RegistryObject<StructurePoolElementType<UndergroundDungeonRoom>> UNDERGROUND_DUNGEON_ROOM = STRUCTURE_POOL_ELEMENT.register("underground_dungeon_room", () -> () -> UndergroundDungeonRoom.CODEC);
}