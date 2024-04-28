package net.builderdog.ancient_aether.world.feature;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherMiscFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DungeonEntranceFeature extends Feature<NoneFeatureConfiguration> {
    public DungeonEntranceFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        int x = context.origin().getX();
        int y = context.origin().getY();
        int z = context.origin().getZ();

        BlockPos pos = new BlockPos(x, y, z);
        BlockPos posOffset = new BlockPos(x - 5, y, z - 5);
        BlockPos posVoid = new BlockPos(x, y - 12, z);
        RandomSource random = context.random();

        if (level.isEmptyBlock(pos)) {
            if (!level.isEmptyBlock(posVoid) && !level.getBlockState(posVoid).is(AetherTags.Blocks.NON_BRONZE_DUNGEON_SPAWNABLE)) {
                StructureTemplate template = level.getLevel().getStructureManager().getOrCreate(new ResourceLocation("ancient_aether", "bronze_dungeon/entrance/entrance"));
                template.placeInWorld(level, posOffset, pos, getSettings(), random, 3);
            }
        } else {
            StructureTemplate template = level.getLevel().getStructureManager().getOrCreate(new ResourceLocation("ancient_aether", "bronze_dungeon/entrance/staircase"));
            ConfiguredFeature<?, ?> feature = Objects.requireNonNull(level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(AncientAetherMiscFeatures.BRONZE_DUNGEON_ENTRANCE).orElse(null)).value();
            ChunkGenerator chunk = level.getLevel().getChunkSource().getGenerator();
            template.placeInWorld(level, posOffset, pos, getSettings(), random, 3);
            feature.place(level, chunk, random, new BlockPos(x, y + 8, z));
        }
        return false;
    }

    protected StructurePlaceSettings getSettings() {
        StructurePlaceSettings placeSettings = new StructurePlaceSettings();
        placeSettings.setKnownShape(true);
        placeSettings.addProcessor(new RuleProcessor(ImmutableList.of(
                new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.CARVED_STONE.get(), 0.01F), AlwaysTrueTest.INSTANCE, AetherBlocks.SENTRY_STONE.get().defaultBlockState()))));
        return placeSettings;
    }
}