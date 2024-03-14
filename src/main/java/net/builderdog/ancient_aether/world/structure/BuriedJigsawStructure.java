package net.builderdog.ancient_aether.world.structure;

import com.aetherteam.aether.AetherTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

    public class BuriedJigsawStructure extends Structure {
        public static final Codec<BuriedJigsawStructure> CODEC = RecordCodecBuilder.<BuriedJigsawStructure>mapCodec(instance ->
                instance.group(BuriedJigsawStructure.settingsCodec(instance),
                        StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                        ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                        Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                        HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                        Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                Codec.INT.fieldOf("above_bottom").forGetter(structure -> structure.aboveBottom),
                Codec.INT.fieldOf("below_top").forGetter(structure -> structure.belowTop)
                ).apply(instance, BuriedJigsawStructure::new)).codec();

        private final Holder<StructureTemplatePool> startPool;
        private final Optional<ResourceLocation> startJigsawName;
        private final int size;
        private final HeightProvider startHeight;
        private final Optional<Heightmap.Types> projectStartToHeightmap;
        private final int maxDistanceFromCenter;
        private final int aboveBottom;
        private final int belowTop;

        public BuriedJigsawStructure(StructureSettings settings, int aboveBottom, int belowTop) {
            super(settings);
            this.startPool = startPool;
            this.startJigsawName = startJigsawName;
            this.size = size;
            this.startHeight = startHeight;
            this.projectStartToHeightmap = projectStartToHeightmap;
            this.maxDistanceFromCenter = maxDistanceFromCenter;
            this.aboveBottom = aboveBottom;
            this.belowTop = belowTop;
        }

        @Override
        public @NotNull Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
            ChunkPos chunkPos = context.chunkPos();
            ChunkGenerator chunkGenerator = context.chunkGenerator();
            LevelHeightAccessor heightAccessor = context.heightAccessor();
            RandomState randomState = context.randomState();
            StructureTemplateManager templateManager = context.structureTemplateManager();
            int height = findStartingHeight(chunkGenerator, heightAccessor, chunkPos, randomState, templateManager, aboveBottom, belowTop);
            if (height <= heightAccessor.getMinBuildHeight()) {
                MutableInt y = new MutableInt(height);
                chunkPos = searchNearbyChunks(chunkPos, y, chunkGenerator, heightAccessor, randomState, templateManager, aboveBottom, belowTop);
                height = y.getValue();
                if (height <= heightAccessor.getMinBuildHeight()) {
                    return Optional.empty();
                }
            }
            BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), height, chunkPos.getMinBlockZ());
            return JigsawPlacement.addPieces(
                    context,
                    startPool,
                    startJigsawName,
                    size,
                    blockPos,
                    false,
                    projectStartToHeightmap,
                    maxDistanceFromCenter);
        }

        private static ChunkPos searchNearbyChunks(ChunkPos chunkPos, MutableInt height, ChunkGenerator generator, LevelHeightAccessor heightAccessor, RandomState randomState, StructureTemplateManager templateManager, int aboveBottom, int belowTop) {
            int y;
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    if (x != 0 || z != 0) {
                        ChunkPos offset = new ChunkPos(chunkPos.x + x, chunkPos.z + z);
                        y = BuriedJigsawStructure.findStartingHeight(generator, heightAccessor, offset, randomState, templateManager, aboveBottom, belowTop);
                        if (y > heightAccessor.getMinBuildHeight()) {
                            height.setValue(y);
                            return offset;
                        }
                    }
                }
            }
            return chunkPos;
        }

        private static int findStartingHeight(ChunkGenerator generator, LevelHeightAccessor heightAccessor, ChunkPos chunkPos, RandomState random, StructureTemplateManager templateManager, int aboveBottom, int belowTop) {
            int minX = chunkPos.getMinBlockX() - 1;
            int minZ = chunkPos.getMinBlockZ() - 1;
            int maxX = chunkPos.getMaxBlockX() + 1;
            int maxZ = chunkPos.getMaxBlockZ() + 1;
            NoiseColumn[] columns = {
                    generator.getBaseColumn(minX, minZ, heightAccessor, random),
                    generator.getBaseColumn(minX, maxZ, heightAccessor, random),
                    generator.getBaseColumn(maxX, minZ, heightAccessor, random),
                    generator.getBaseColumn(maxX, maxZ, heightAccessor, random)
            };
            int roomHeight = checkRoomHeight(templateManager, new ResourceLocation(AncientAether.MODID, "sentry_laboratory/boss_room"));
            int height = heightAccessor.getMinBuildHeight();
            int maxHeight = heightAccessor.getMaxBuildHeight() - belowTop;
            int thickness = roomHeight + 2;
            int currentThickness = 0;
            for (int y = height + aboveBottom; y <= maxHeight; y++) {
                if (checkEachCornerAtY(columns, y)) {
                    ++currentThickness;
                } else {
                    if (currentThickness > thickness) {
                        thickness = currentThickness;
                        height = y;
                    }
                    currentThickness = 0;
                }
            }
            int offset = (thickness + roomHeight) / 2;
            height -= offset;
            return height;
        }

        private static int checkRoomHeight(StructureTemplateManager manager, ResourceLocation roomName) {
            StructureTemplate template = manager.getOrCreate(roomName);
            return template.getSize().getY();
        }

        private static boolean checkEachCornerAtY(NoiseColumn[] columns, int y) {
            for (NoiseColumn column : columns) {
                if (column.getBlock(y).isAir() || column.getBlock(y).is(AetherTags.Blocks.NON_BRONZE_DUNGEON_SPAWNABLE)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public @NotNull BoundingBox adjustBoundingBox(@NotNull BoundingBox box) {
            return box;
        }

        @Override
        public @NotNull StructureType<?> type() {
            return AncientAetherStructureTypes.BURIED_JIGSAW_STRUCTURE.get();
        }
    }