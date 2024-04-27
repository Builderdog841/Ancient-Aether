package net.builderdog.ancient_aether.world.processor;

import com.aetherteam.aether.block.AetherBlocks;
import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherMiscFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class DungeonEntranceProcessor extends StructureProcessor {
    public static final DungeonEntranceProcessor INSTANCE = new DungeonEntranceProcessor();
    public static final Codec<DungeonEntranceProcessor> CODEC = Codec.unit(DungeonEntranceProcessor.INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader level, @NotNull BlockPos origin, @NotNull BlockPos centerBottom, StructureTemplate.@NotNull StructureBlockInfo originalBlockInfo, StructureTemplate.@NotNull StructureBlockInfo modifiedBlockInfo, @NotNull StructurePlaceSettings settings, @Nullable StructureTemplate template) {
        BlockPos pos = modifiedBlockInfo.pos();
        if (level instanceof ServerLevel serverLevel) {
            if (modifiedBlockInfo.state().is(Blocks.STRUCTURE_BLOCK)) {
                placeEntrance(serverLevel, pos);
                //return new StructureTemplate.StructureBlockInfo(pos, AetherBlocks.CARVED_STONE.get().defaultBlockState(), modifiedBlockInfo.nbt());
            }
        }
        return modifiedBlockInfo;
    }

    public void placeEntrance(ServerLevel serverLevel, BlockPos pos) {
        ConfiguredFeature<?, ?> feature = Objects.requireNonNull(serverLevel.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(AncientAetherMiscFeatures.BRONZE_DUNGEON_ENTRANCE).orElse(null)).value();
        ChunkGenerator chunk = serverLevel.getChunkSource().getGenerator();
        RandomSource random = serverLevel.getRandom();
        feature.place(serverLevel, chunk, random, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return AncientAetherStructureProcessors.DUNGEON_ENTRANCE.get();
    }
}