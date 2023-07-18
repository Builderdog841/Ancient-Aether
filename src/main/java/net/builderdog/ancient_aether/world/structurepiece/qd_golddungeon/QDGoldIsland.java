package net.builderdog.ancient_aether.world.structurepiece.qd_golddungeon;

import com.aetherteam.aether.world.processor.DoubleDropsProcessor;
import com.aetherteam.aether.world.processor.VerticalGradientProcessor;
import com.aetherteam.aether.world.structurepiece.AetherStructurePieceTypes;
import net.builderdog.ancient_aether.world.structurepiece.AncientAetherStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class QDGoldIsland extends QDGoldDungeonPiece {

    public QDGoldIsland(StructureTemplateManager manager, String name, BlockPos pos) {
        super(AncientAetherStructurePieceTypes.QD_GOLD_ISLAND.get(), manager, name, makeSettings(), pos);
    }

    public QDGoldIsland(StructurePieceSerializationContext context, CompoundTag tag) {
        super(AncientAetherStructurePieceTypes.QD_GOLD_ISLAND.get(), tag, context.structureTemplateManager(), resourceLocation -> makeSettings());
    }

    private static StructurePlaceSettings makeSettings() {
        return new StructurePlaceSettings().addProcessor(VerticalGradientProcessor.INSTANCE).addProcessor(DoubleDropsProcessor.INSTANCE);
    }
}