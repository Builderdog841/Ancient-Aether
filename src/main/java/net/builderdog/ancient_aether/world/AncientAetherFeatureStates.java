package net.builderdog.ancient_aether.world;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.level.block.state.BlockState;

public class AncientAetherFeatureStates {
    public static final BlockState SKYROOT_PINE_LEAVES = AncientAetherBlocks.SKYROOT_PINE_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
    public static final BlockState CRYSTAL_SKYROOT_LEAVES = AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
    public static final BlockState HIGHSPROOT_LEAVES = AncientAetherBlocks.HIGHSPROOT_LEAVES.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
    public static final BlockState HIGHSPROOT_LOG = AncientAetherBlocks.HIGHSPROOT_LOG.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
    public static final BlockState VIOLET_AERCLOUD = AncientAetherBlocks.VIOLET_AERCLOUD.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
    public static final BlockState CRYSTAL_AERCLOUD = AncientAetherBlocks.CRYSTAL_AERCLOUD.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true);
}