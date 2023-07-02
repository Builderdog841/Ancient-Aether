package net.builderdog.aether_crystallium.world.trunkplacer;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.builderdog.aether_crystallium.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class CrystalliumSkinnyHookedTrunkPlacer extends BaseCrystalliumHookedTrunkPlacer {
    public static final Codec<CrystalliumSkinnyHookedTrunkPlacer> CODEC = RecordCodecBuilder.create((codec) -> trunkPlacerParts(codec)
            .and(BlockStateProvider.CODEC.fieldOf("skinnyTrunkProvider").forGetter((placer) -> placer.skinnyTrunkProvider))
            .apply(codec, CrystalliumSkinnyHookedTrunkPlacer::new));
    private final BlockStateProvider skinnyTrunkProvider;

    public CrystalliumSkinnyHookedTrunkPlacer(int height, int heightRandA, int heightRandB, BlockStateProvider skinnyTrunkProvider) {
        super(height, heightRandA, heightRandB);
        this.skinnyTrunkProvider = skinnyTrunkProvider;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.CRYSTALLIUM_SKINNY_HOOKED_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int height, BlockPos pos, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();

        list.addAll(this.placeVerticalTrunk(level, blockSetter, random, height, pos, this.skinnyTrunkProvider));
        list.addAll(this.placeBranches(level, blockSetter, random, height, pos, config));

        return list;
    }

    @Override
    public boolean isTrunk(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, (state) -> state.is(BlockTags.LOGS) || state.is(ModTags.Blocks.CRYSTALLIUM_LOG_WALLS));
    }
}