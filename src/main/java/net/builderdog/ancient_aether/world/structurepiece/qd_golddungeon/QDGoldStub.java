package net.builderdog.ancient_aether.world.structurepiece.qd_golddungeon;


import com.aetherteam.aether.world.processor.DoubleDropsProcessor;
import com.aetherteam.aether.world.processor.VerticalGradientProcessor;
import net.builderdog.ancient_aether.world.structurepiece.AncientAetherStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class QDGoldStub extends QDGoldDungeonPiece {

    public QDGoldStub(StructureTemplateManager manager, String name, BlockPos pos) {
        super(AncientAetherStructurePieceTypes.QD_GOLD_STUB.get(), manager, name, makeSettings(), pos);
    }

    public QDGoldStub(StructurePieceSerializationContext context, CompoundTag tag) {
        super(AncientAetherStructurePieceTypes.QD_GOLD_STUB.get(), tag, context.structureTemplateManager(), resourceLocation -> makeSettings());
    }

    private static StructurePlaceSettings makeSettings() {
        return new StructurePlaceSettings().addProcessor(VerticalGradientProcessor.INSTANCE).addProcessor(DoubleDropsProcessor.INSTANCE);
    }
}