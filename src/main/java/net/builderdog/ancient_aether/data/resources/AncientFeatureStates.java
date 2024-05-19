package net.builderdog.ancient_aether.data.resources;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientBlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AncientFeatureStates {
    public static final BooleanProperty DOUBLE_DROPS = AetherBlockStateProperties.DOUBLE_DROPS;
    public static final IntegerProperty LENGTH = AncientBlockStateProperties.LENGTH;
    public static final EnumProperty<AetherGrassType> TYPE = AncientBlockStateProperties.TYPE;

    public static final BlockState FROZEN_AETHER_GRASS_BLOCK = AetherBlocks.AETHER_GRASS_BLOCK.get().defaultBlockState().setValue(DOUBLE_DROPS, true).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState PALE_AETHER_GRASS_BLOCK = AetherBlocks.AETHER_GRASS_BLOCK.get().defaultBlockState().setValue(DOUBLE_DROPS, true).setValue(TYPE, AetherGrassType.PALE);

    public static final BlockState GRAVITY_GRAVEL = AncientBlocks.GRAVITY_GRAVEL.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState VALKYRIE_CLAY = AncientBlocks.VALKYRIE_CLAY.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState MOSSY_HOLYSTONE = AetherBlocks.MOSSY_HOLYSTONE.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState AETHER_QUARTZ_ORE = AncientBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState VALKYRUM_ORE = AncientBlocks.VALKYRUM_ORE.get().defaultBlockState();
    public static final BlockState AEROGEL = AetherBlocks.AEROGEL.get().defaultBlockState();

    public static final BlockState CRYSTAL_SKYROOT_LEAVES = AncientBlocks.CRYSTAL_SKYROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState ENCHANTED_SKYROOT_LEAVES = AncientBlocks.ENCHANTED_SKYROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SKYROOT_PINE_LEAVES = AncientBlocks.SKYROOT_PINE_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState HIGHSPROOT_LEAVES = AncientBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SAKURA_LEAVES = AncientBlocks.SAKURA_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);

    public static final BlockState SKY_GRASS_VERY_SHORT = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1);
    public static final BlockState SKY_GRASS_SHORT = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2);
    public static final BlockState SKY_GRASS_MEDIUM = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 3);
    public static final BlockState SKY_GRASS_TALL = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 4);
    public static final BlockState SKY_GRASS_VERY_TALL = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 5);
    public static final BlockState SKY_GRASS_VERY_SHORT_FROZEN = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_SHORT_FROZEN = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_MEDIUM_FROZEN = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 3).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_VERY_SHORT_PALE = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1).setValue(TYPE, AetherGrassType.PALE);
    public static final BlockState SKY_GRASS_SHORT_PALE = AncientBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2).setValue(TYPE, AetherGrassType.PALE);

    public static final BlockState GRAPE_VINE = AncientBlocks.GRAPE_VINE.get().defaultBlockState();

    public static final BlockState HIGHSPROOT_LOG = AncientBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SAKURA_LOG = AncientBlocks.SAKURA_LOG.get().defaultBlockState().setValue(DOUBLE_DROPS, true);

    public static final BlockState VIOLET_AERCLOUD = AncientBlocks.VIOLET_AERCLOUD.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
}