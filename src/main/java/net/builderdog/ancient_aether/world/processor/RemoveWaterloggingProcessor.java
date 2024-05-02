package net.builderdog.ancient_aether.world.processor;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class RemoveWaterloggingProcessor extends StructureProcessor {
    public static final RemoveWaterloggingProcessor INSTANCE = new RemoveWaterloggingProcessor();

    public static final Codec<RemoveWaterloggingProcessor> CODEC = Codec.unit(RemoveWaterloggingProcessor.INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader level, @NotNull BlockPos origin, @NotNull BlockPos centerBottom, StructureTemplate.@NotNull StructureBlockInfo originalBlockInfo, StructureTemplate.StructureBlockInfo modifiedBlockInfo, @NotNull StructurePlaceSettings settings, @Nullable StructureTemplate template) {
        if (modifiedBlockInfo.state().hasProperty(BlockStateProperties.WATERLOGGED)) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.pos(), modifiedBlockInfo.state().setValue(BlockStateProperties.WATERLOGGED, false), modifiedBlockInfo.nbt());
        }
        return super.process(level, origin, centerBottom, originalBlockInfo, modifiedBlockInfo, settings, template);
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return AncientAetherStructureProcessors.REMOVE_WATERLOGGING.get();
    }
}