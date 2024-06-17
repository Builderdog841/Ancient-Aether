package net.builderdog.ancient_aether.block;

import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class AncientAetherBlockBuilders {

    public static Block leaves(MapColor mapColor, SoundType sound) {
        return new AetherDoubleDropsLeaves(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(sound)
                        .noOcclusion()
                        .isValidSpawn(AncientAetherBlocks::ocelotOrParrot)
                        .isSuffocating(AncientAetherBlocks::never)
                        .isViewBlocking(AncientAetherBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(AncientAetherBlocks::never)
        );
    }

    public static WallBlock logWall() {
        return new WallBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WOOD)
                        .instrument(NoteBlockInstrument.BASS)
                        .ignitedByLava().strength(2.0F)
                        .sound(SoundType.WOOD)
        );
    }

    public static Block dungeonBlock(MapColor mapColor) {
        return new Block(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(0.5F, 6.0F)
                        .requiresCorrectToolForDrops()
        );
    }

    public static RotatedPillarBlock dungeonMosaic(MapColor mapColor) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(0.5F, 6.0F)
                        .requiresCorrectToolForDrops()
        );
    }

    public static boolean never(BlockState test1, BlockGetter test2, BlockPos test3) {
        return false;
    }
    public static boolean always(BlockState test1, BlockGetter test2, BlockPos test3) {
        return true;
    }

    public static boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
}