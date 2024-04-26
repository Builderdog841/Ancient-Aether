package net.builderdog.ancient_aether.world.feature;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherMiscFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DungeonEntranceFeature extends Feature<NoneFeatureConfiguration> {
    public DungeonEntranceFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        int x = context.origin().getX() - 6;
        int y = context.origin().getY();
        int z = context.origin().getZ() - 6;

        BlockPos pos = new BlockPos(x, y, z);
        BlockPos posAbove = new BlockPos(x, y + 8, z);
        BlockPos posBelow = new BlockPos(x, y - 12, z);
        RandomSource random = context.random();
        ChunkGenerator chunk = context.chunkGenerator();

        if (level instanceof ServerLevel serverLevel) {
            if (level.isEmptyBlock(pos)) {
                if (!level.isEmptyBlock(posBelow)) {
                    StructureTemplate template = serverLevel.getStructureManager().getOrCreate(new ResourceLocation("ancient_aether", "bronze_dungeon/entrance/entrance"));
                    template.placeInWorld(serverLevel, pos, pos, new StructurePlaceSettings(), random, 3);
                    return false;
                }
            } else {
                StructureTemplate template = serverLevel.getStructureManager().getOrCreate(new ResourceLocation("ancient_aether", "bronze_dungeon/entrance/staircase"));
                ConfiguredFeature<?, ?> configuredfeature = Objects.requireNonNull(level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(AncientAetherMiscFeatures.BRONZE_DUNGEON_ENTRANCE).orElse(null)).value();
                template.placeInWorld(serverLevel, pos, pos, new StructurePlaceSettings(), random, 3);
                configuredfeature.place(level, chunk, random, posAbove);
            }
        }
        return false;
    }
}