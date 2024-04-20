package net.builderdog.ancient_aether.world.structure.poolelement;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructurePoolElements;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DungeonEntrance extends StructurePoolElement {
    private static final Codec<Either<ResourceLocation, StructureTemplate>> TEMPLATE_CODEC = Codec.of(DungeonEntrance::encodeTemplate, ResourceLocation.CODEC.map(Either::left));
    public static final Codec<DungeonEntrance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(templateCodec(), processorsCodec(), projectionCodec()).apply(instance, DungeonEntrance::new));
    protected final Either<ResourceLocation, StructureTemplate> template;
    protected final Holder<StructureProcessorList> processors;

    private static <T> DataResult<T> encodeTemplate(Either<ResourceLocation, StructureTemplate> template, DynamicOps<T> ops, T values) {
        Optional<ResourceLocation> optional = template.left();
        return optional.isEmpty() ? DataResult.error(() -> "Can not serialize a runtime pool element") : ResourceLocation.CODEC.encode(optional.get(), ops, values);
    }

    protected static <E extends DungeonEntrance> RecordCodecBuilder<E, Holder<StructureProcessorList>> processorsCodec() {
        return StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter((processors) -> processors.processors);
    }

    protected static <E extends DungeonEntrance> RecordCodecBuilder<E, Either<ResourceLocation, StructureTemplate>> templateCodec() {
        return TEMPLATE_CODEC.fieldOf("location").forGetter((location) -> location.template);
    }

    protected DungeonEntrance(Either<ResourceLocation, StructureTemplate> template, Holder<StructureProcessorList> processors, StructureTemplatePool.Projection projection) {
        super(projection);
        this.template = template;
        this.processors = processors;
    }

    public @NotNull Vec3i getSize(@NotNull StructureTemplateManager structureTemplateManager, @NotNull Rotation rotation) {
        StructureTemplate structuretemplate = getTemplate(structureTemplateManager);
        return structuretemplate.getSize(rotation);
    }

    private StructureTemplate getTemplate(StructureTemplateManager structureTemplateManager) {
        return template.map(structureTemplateManager::getOrCreate, Function.identity());
    }

    public List<StructureTemplate.StructureBlockInfo> getDataMarkers(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, boolean bool) {
        StructureTemplate structuretemplate = getTemplate(templateManager);
        List<StructureTemplate.StructureBlockInfo> list1 = structuretemplate.filterBlocks(pos, (new StructurePlaceSettings()).setRotation(rotation), Blocks.STRUCTURE_BLOCK, bool);
        List<StructureTemplate.StructureBlockInfo> list2 = Lists.newArrayList();

        for(StructureTemplate.StructureBlockInfo structureblockinfo : list1) {
            CompoundTag compoundtag = structureblockinfo.nbt();
            if (compoundtag != null) {
                StructureMode structuremode = StructureMode.valueOf(compoundtag.getString("mode"));
                if (structuremode == StructureMode.DATA) {
                    list2.add(structureblockinfo);
                }
            }
        }
        return list2;
    }

    public @NotNull List<StructureTemplate.StructureBlockInfo> getShuffledJigsawBlocks(@NotNull StructureTemplateManager templateManager, @NotNull BlockPos pos, @NotNull Rotation rotation, @NotNull RandomSource random) {
        StructureTemplate structuretemplate = getTemplate(templateManager);
        ObjectArrayList<StructureTemplate.StructureBlockInfo> objectarraylist = structuretemplate.filterBlocks(pos, (new StructurePlaceSettings()).setRotation(rotation), Blocks.JIGSAW, true);
        Util.shuffle(objectarraylist, random);
        return objectarraylist;
    }

    public @NotNull BoundingBox getBoundingBox(@NotNull StructureTemplateManager structureTemplateManager, @NotNull BlockPos pos, @NotNull Rotation rotation) {
        StructureTemplate structuretemplate = getTemplate(structureTemplateManager);
        return structuretemplate.getBoundingBox((new StructurePlaceSettings()).setRotation(rotation), pos);
    }

    @SuppressWarnings("deprecation")
    public boolean place(@NotNull StructureTemplateManager structureTemplateManager, @NotNull WorldGenLevel level, @NotNull StructureManager structureManager, @NotNull ChunkGenerator chunk, @NotNull BlockPos offset, @NotNull BlockPos pos, @NotNull Rotation rotation, @NotNull BoundingBox box, @NotNull RandomSource random, boolean keepJigsaws) {
        StructureTemplate template = getTemplate(structureTemplateManager);
        StructurePlaceSettings settings = getSettings(rotation, box, keepJigsaws);
        if (!template.placeInWorld(level, offset, pos, settings, random, 18)) {
            return false;
        } else {
            for (StructureTemplate.StructureBlockInfo structureblockinfo : StructureTemplate.processBlockInfos(level, offset, pos, settings, getDataMarkers(structureTemplateManager, offset, rotation, false))) {
                handleDataMarker(level, structureblockinfo, offset, rotation, random, box);
            }
            return true;
        }
    }

    protected StructurePlaceSettings getSettings(Rotation rotation, BoundingBox boundingBox, boolean offset) {
        StructurePlaceSettings structure = new StructurePlaceSettings();
        structure.setBoundingBox(boundingBox);
        structure.setRotation(rotation);
        structure.setKnownShape(true);
        structure.setIgnoreEntities(false);
        structure.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        structure.setFinalizeEntities(true);
        if (!offset) {
            structure.addProcessor(JigsawReplacementProcessor.INSTANCE);
        }

        processors.value().list().forEach(structure::addProcessor);
        getProjection().getProcessors().forEach(structure::addProcessor);
        return structure;
    }

    public @NotNull StructurePoolElementType<?> getType() {
        return AncientAetherStructurePoolElements.DUNGEON_ENTRANCE.get();
    }

    public String toString() {
        return "Single[" + template + "]";
    }
}