package net.builderdog.ancient_aether.world.structurepiece.qd_golddungeon;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.world.structurepiece.AetherTemplateStructurePiece;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.function.Function;

/**
 * Superclass for all gold dungeon structure pieces. This exists to simplify the code.
 */
public abstract class QDGoldDungeonPiece extends AetherTemplateStructurePiece {
    public static final RuleProcessor LOCKED_HELLFIRE_STONE = new RuleProcessor(ImmutableList.of(
            new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.LOCKED_HELLFIRE_STONE.get(), 0.1F), AlwaysTrueTest.INSTANCE, AetherBlocks.LOCKED_LIGHT_HELLFIRE_STONE.get().defaultBlockState())
    ));
    public static final RuleProcessor MOSSY_HOLYSTONE = new RuleProcessor(ImmutableList.of(
            new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherBlocks.MOSSY_HOLYSTONE.get().defaultBlockState())
    ));

    public QDGoldDungeonPiece(StructurePieceType type, StructureTemplateManager manager, String name, StructurePlaceSettings settings, BlockPos pos) {
        super(type, manager, makeLocation(name), settings, pos);
    }

    public QDGoldDungeonPiece(StructurePieceType type, CompoundTag tag, StructureTemplateManager manager, Function<ResourceLocation, StructurePlaceSettings> settingsFactory) {
        super(type, tag, manager, settingsFactory);
    }

    protected static ResourceLocation makeLocation(String name) {
        return new ResourceLocation(AncientAether.MOD_ID, "quicksoil_desert_gold_dungeon/" + name);
    }
}