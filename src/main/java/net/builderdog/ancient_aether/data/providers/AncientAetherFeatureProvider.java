package net.builderdog.ancient_aether.data.providers;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.foliageplacer.CrystalFoliagePlacer;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.world.configuration.CoastConfiguration;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

@SuppressWarnings("deprecation")
public class AncientAetherFeatureProvider {

    public static TreeConfiguration.TreeConfigurationBuilder createStraightSkyrootBlobTree(BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createFancySkyrootTree(BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createWyndcapsPineTree(int baseHeight, int heightRandA, int trunkHeight) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AncientAetherFeatureStates.HIGHSPROOT_LOG),
                new StraightTrunkPlacer(baseHeight, heightRandA, 1),
                BlockStateProvider.simple(AncientAetherFeatureStates.HIGHSPROOT_LEAVES),
                new CrystalFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), ConstantInt.of(trunkHeight)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createSakuraJungleTree(BlockState log, BlockState leaves, int baseHeight, int heightRandA) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new CherryTrunkPlacer(baseHeight, heightRandA, 0,
                        new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 3), UniformInt.of(-6, -4), UniformInt.of(-1, 0)),
                BlockStateProvider.simple(leaves),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.25F, 0.25F, 0.16666667F, 0.66666667F),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines();
    }

    public static BlockColumnConfiguration createSkyrootLeafVine(int length) {
        return new BlockColumnConfiguration(List.of(
                BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                        .add(UniformInt.of(1, length), 2)
                        .add(UniformInt.of(1, 2), 3)
                        .add(UniformInt.of(1, 6), 10)
                        .build()), BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES.setValue(BlockStateProperties.PERSISTENT, true)))),
                Direction.DOWN,
                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                true);
    }

    public static CoastConfiguration createCoast(BlockState coastState, int minHeight, int maxHeight) {
        return new CoastConfiguration(
                BlockStateProvider.simple(coastState),
                ConstantFloat.of(6.6282032F),
                ConstantFloat.of(4.4641016F),
                UniformInt.of(minHeight, maxHeight),
                HolderSet.direct(Block::builtInRegistryHolder, AetherBlocks.AETHER_GRASS_BLOCK.get())
        );
    }
}