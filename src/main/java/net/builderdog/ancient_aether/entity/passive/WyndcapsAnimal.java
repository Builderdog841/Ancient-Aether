package net.builderdog.ancient_aether.entity.passive;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.entity.passive.AetherAnimal;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;

public abstract class WyndcapsAnimal extends AetherAnimal {
    protected WyndcapsAnimal(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    public static boolean checkWyndcapsAnimalSpawnRules(EntityType<? extends WyndcapsAnimal> animal, LevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).is(AncientAetherTags.Blocks.WYNDCAPS_ANIMAL_SPAWNABLE_ON) && level.getRawBrightness(pos, 0) > 8;
    }

    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return level.getBlockState(pos.below()).is(AetherBlocks.AETHER_GRASS_BLOCK.get()) ? 10.0F : (float)level.getMaxLocalRawBrightness(pos) - 0.5F;
    }
}
