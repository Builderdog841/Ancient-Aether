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
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
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

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;
    private final int minSpawnHeight;

    public static final Codec<BuriedJigsawStructure> CODEC = RecordCodecBuilder.<BuriedJigsawStructure>mapCodec(instance ->
            instance.group(BuriedJigsawStructure.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                    Codec.intRange(-4096, 4096).fieldOf("min_spawn_height").forGetter(structure -> structure.minSpawnHeight)
            ).apply(instance, BuriedJigsawStructure::new)).codec();

    public BuriedJigsawStructure(
            StructureSettings config,
            Holder<StructureTemplatePool> startPool,
            Optional<ResourceLocation> startJigsawName,
            int size,
            HeightProvider startHeight,
            Optional<Heightmap.Types> projectStartToHeightmap,
            int maxDistanceFromCenter,
            int minSpawnHeight) {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
        this.minSpawnHeight = minSpawnHeight;
    }

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        LevelHeightAccessor heightAccessor = context.heightAccessor();
        RandomState randomState = context.randomState();
        StructureTemplateManager templateManager = context.structureTemplateManager();

        if (!extraSpawningChecks(context)) {
            return Optional.empty();
        }
        int startY = startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));

        ChunkPos chunkPos = context.chunkPos();
        BlockPos blockPos = new BlockPos(chunkPos.getMiddleBlockX(), startY, chunkPos.getMiddleBlockZ());

        int height = findStartingHeight(chunkGenerator, heightAccessor, chunkPos, randomState, templateManager);
        if (height <= heightAccessor.getMinBuildHeight()) {
            MutableInt y = new MutableInt(height);
            searchNearbyChunks(chunkPos, y, chunkGenerator, heightAccessor, randomState, templateManager);
            height = y.getValue();
            if (height <= heightAccessor.getMinBuildHeight()) {
                return Optional.empty();
            }
        }

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

    private void searchNearbyChunks(ChunkPos chunkPos, MutableInt height, ChunkGenerator generator, LevelHeightAccessor heightAccessor, RandomState randomState, StructureTemplateManager templateManager) {
        int y;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (x != 0 || z != 0) {
                    ChunkPos offset = new ChunkPos(chunkPos.x + x, chunkPos.z + z);
                    y = findStartingHeight(generator, heightAccessor, offset, randomState, templateManager);
                    if (y > heightAccessor.getMinBuildHeight()) {
                        height.setValue(y);
                        return;
                    }
                }
            }
        }
    }

    private int findStartingHeight(ChunkGenerator generator, LevelHeightAccessor heightAccessor, ChunkPos chunkPos, RandomState random, StructureTemplateManager templateManager) {
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
        int maxHeight = heightAccessor.getMaxBuildHeight();
        int thickness = roomHeight + 2;
        int currentThickness = 0;
        for (int y = height; y <= maxHeight; y++) {
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

    private int checkRoomHeight(StructureTemplateManager manager, ResourceLocation roomName) {
        StructureTemplate template = manager.getOrCreate(roomName);
        return template.getSize().getY();
    }

    private boolean checkEachCornerAtY(NoiseColumn[] columns, int y) {
        for (NoiseColumn column : columns) {
            if (column.getBlock(y).isAir() || column.getBlock(y).is(AetherTags.Blocks.NON_BRONZE_DUNGEON_SPAWNABLE)) {
                return false;
            }
        }
        return true;
    }

    private boolean extraSpawningChecks(GenerationContext context) {
        ChunkPos chunkpos = context.chunkPos();
        return context.chunkGenerator().getFirstOccupiedHeight(
                chunkpos.getMiddleBlockX(),
                chunkpos.getMiddleBlockZ(),
                Heightmap.Types.WORLD_SURFACE_WG,
                context.heightAccessor(),
                context.randomState()) > minSpawnHeight;
    }

    @Override
    public @NotNull StructureType<?> type() {
        return AncientAetherStructureTypes.BURIED_JIGSAW_STRUCTURE.get();
    }
}