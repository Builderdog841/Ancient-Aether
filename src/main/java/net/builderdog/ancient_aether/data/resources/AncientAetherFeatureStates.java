package net.builderdog.ancient_aether.data.resources;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AncientAetherFeatureStates {
    public static final BooleanProperty DOUBLE_DROPS = AetherBlockStateProperties.DOUBLE_DROPS;
    public static final IntegerProperty LENGTH = AncientAetherBlockStateProperties.LENGTH;
    public static final EnumProperty<AetherGrassType> TYPE = AncientAetherBlockStateProperties.TYPE;

    public static final BlockState SKYROOT_PINE_LEAVES = AncientAetherBlocks.SKYROOT_PINE_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState CRYSTAL_SKYROOT_LEAVES = AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState ENCHANTED_SKYROOT_LEAVES = AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState HIGHSPROOT_LEAVES = AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SAKURA_LEAVES = AncientAetherBlocks.SAKURA_LEAVES.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState HIGHSPROOT_LOG = AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SAKURA_LOG = AncientAetherBlocks.SAKURA_LOG.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState VIOLET_AERCLOUD = AncientAetherBlocks.VIOLET_AERCLOUD.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState SKY_GRASS_VERY_SHORT = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1);
    public static final BlockState SKY_GRASS_SHORT = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2);
    public static final BlockState SKY_GRASS_MEDIUM = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 3);
    public static final BlockState SKY_GRASS_TALL = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 4);
    public static final BlockState SKY_GRASS_VERY_TALL = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 5);
    public static final BlockState SKY_GRASS_VERY_SHORT_FROZEN = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_SHORT_FROZEN = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_MEDIUM_FROZEN = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 3).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState SKY_GRASS_VERY_SHORT_PALE = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 1).setValue(TYPE, AetherGrassType.PALE);
    public static final BlockState SKY_GRASS_SHORT_PALE = AncientAetherBlocks.SKY_GRASS.get().defaultBlockState().setValue(LENGTH, 2).setValue(TYPE, AetherGrassType.PALE);
    public static final BlockState GRAVITY_GRAVEL = AncientAetherBlocks.GRAVITY_GRAVEL.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState WYND_ICE = AncientAetherBlocks.WYND_ICE.get().defaultBlockState();
    public static final BlockState AEROGEL = AetherBlocks.AEROGEL.get().defaultBlockState();
    public static final BlockState MOSSY_HOLYSTONE = AetherBlocks.MOSSY_HOLYSTONE.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState AETHER_QUARTZ_ORE = AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(DOUBLE_DROPS, true);
    public static final BlockState VALKYRUM_ORE = AncientAetherBlocks.VALKYRUM_ORE.get().defaultBlockState();
    public static final BlockState HIGHLAND_CYCLAMEN = AncientAetherBlocks.HIGHLAND_CYCLAMEN.get().defaultBlockState();
    public static final BlockState SKY_BLUES = AncientAetherBlocks.SKY_BLUES.get().defaultBlockState();
    public static final BlockState WYND_THISTLE = AncientAetherBlocks.WYND_THISTLE.get().defaultBlockState();
    public static final BlockState FROZEN_AETHER_GRASS_BLOCK = AetherBlocks.AETHER_GRASS_BLOCK.get().defaultBlockState().setValue(DOUBLE_DROPS, true).setValue(TYPE, AetherGrassType.FROZEN);
    public static final BlockState PALE_AETHER_GRASS_BLOCK = AetherBlocks.AETHER_GRASS_BLOCK.get().defaultBlockState().setValue(DOUBLE_DROPS, true).setValue(TYPE, AetherGrassType.PALE);
    public static final BlockState GRAPE_VINE = AncientAetherBlocks.GRAPE_VINE.get().defaultBlockState();
}