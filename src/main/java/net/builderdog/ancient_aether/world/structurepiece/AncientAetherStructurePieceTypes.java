package net.builderdog.ancient_aether.world.structurepiece;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.structurepiece.qd_golddungeon.QDGoldIsland;
import net.builderdog.ancient_aether.world.structurepiece.qd_golddungeon.QDGoldStub;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class AncientAetherStructurePieceTypes {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = DeferredRegister.create(Registries.STRUCTURE_PIECE, AncientAether.MOD_ID);

    public static final RegistryObject<StructurePieceType> QD_GOLD_ISLAND = register("QDGIsland", QDGoldIsland::new);
    public static final RegistryObject<StructurePieceType> QD_GOLD_STUB = register("QDGStub", QDGoldStub::new);

    private static RegistryObject<StructurePieceType> register(String name, StructurePieceType structurePieceType) {
        return STRUCTURE_PIECE_TYPES.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
}