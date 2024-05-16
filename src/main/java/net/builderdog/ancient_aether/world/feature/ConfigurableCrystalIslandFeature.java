package net.builderdog.ancient_aether.world.feature;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.world.feature.configuration.CrystalIslandConfiguration;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Arrays;

public class ConfigurableCrystalIslandFeature extends Feature<CrystalIslandConfiguration> {
    public ConfigurableCrystalIslandFeature(Codec<CrystalIslandConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrystalIslandConfiguration> context) {
        CrystalIslandConfiguration config = context.config();

        PlacedFeature feature = PlacementUtils.inlinePlaced(context.level().registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolderOrThrow(ResourceKey.create(Registries.CONFIGURED_FEATURE, config.feature()))).value();
        if (feature.place(context.level(), context.chunkGenerator(), context.random(), context.origin().above())) {
            for (int i = 0; i < 3; i++) {
                BlockState state;
                if (i == 0) {
                    state = config.topBlock();
                } else {
                    state = config.islandBlock();
                }
                int offset = i;
                setBlock(context.level(), context.origin().below(offset), state);
                Arrays.stream(Direction.values()).toList().subList(2, 6).forEach(direction -> {
                    setBlock(context.level(), context.origin().relative(direction).below(offset), state);
                    if (offset != 2) {
                        setBlock(context.level(), context.origin().relative(direction, 2).below(offset), state);
                        setBlock(context.level(), context.origin().relative(direction).relative(direction.getClockWise()).below(offset), state);
                    }
                });
            }
            return true;
        } else {
            return false;
        }
    }
}