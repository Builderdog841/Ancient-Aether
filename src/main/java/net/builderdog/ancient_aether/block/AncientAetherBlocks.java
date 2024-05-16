package net.builderdog.ancient_aether.block;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.block.construction.BookshelfBlock;
import com.aetherteam.aether.block.dungeon.DoorwayBlock;
import com.aetherteam.aether.block.dungeon.TrappedBlock;
import com.aetherteam.aether.block.dungeon.TreasureDoorwayBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import com.aetherteam.aether.block.natural.AetherDoubleDropsOreBlock;
import com.aetherteam.aether.block.natural.AetherLogBlock;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.blocktype.*;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.tree.AncientAetherTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.aetherteam.aether.block.AetherBlocks.*;
import static net.minecraft.world.level.block.Blocks.*;

@SuppressWarnings("deprecation")
public class AncientAetherBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AncientAether.MODID);

    public static final DeferredBlock<Block> GRAVITY_GRAVEL = register("gravity_gravel", () -> new AetherDoubleDropBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).jumpFactor(1.5F).strength(0.25F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> WYND_ICE = register("wynd_ice", () -> new Block(Block.Properties.ofFullCopy(PACKED_ICE)));
    public static final DeferredBlock<Block> VALKYRIE_CLAY = register("valkyrie_clay", () -> new AetherDoubleDropBlock(Block.Properties.ofFullCopy(CLAY).mapColor(MapColor.SNOW)));

    public static final DeferredBlock<Block> AETHER_QUARTZ_ORE = register("aether_quartz_ore", () -> new AetherDoubleDropsOreBlock(UniformInt.of(2, 5), Block.Properties.ofFullCopy(NETHER_QUARTZ_ORE)));
    public static final DeferredBlock<Block> VALKYRUM_ORE = register("valkyrum_ore", () -> new ValkyrumBlock(Block.Properties.of().strength(5.0F, 5.0F).requiresCorrectToolForDrops().mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> ATMOSINE_CRYSTAL = register("atmosine_crystal", () -> new AtmosineCrystalBlock(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 5)));

    public static final DeferredBlock<Block> CRYSTAL_SKYROOT_LEAVES = register("crystal_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(CRYSTAL_LEAVES.get())));
    public static final DeferredBlock<Block> ENCHANTED_SKYROOT_LEAVES = register("enchanted_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LEAVES.get()).mapColor(MapColor.LAPIS).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final DeferredBlock<Block> SKYROOT_PINE_LEAVES = register("skyroot_pine_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LEAVES.get())));
    public static final DeferredBlock<Block> BLUE_SKYROOT_PINE_LEAVES = register("blue_skyroot_pine_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(SKYROOT_PINE_LEAVES.get()).mapColor(MapColor.DIAMOND)));
    public static final DeferredBlock<Block> HIGHSPROOT_LEAVES = register("highsproot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LEAVES.get()).mapColor(MapColor.TERRACOTTA_BLUE).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final DeferredBlock<Block> SAKURA_LEAVES = register("sakura_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LEAVES.get()).sound(SoundType.CHERRY_LEAVES).mapColor(MapColor.COLOR_PINK).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));

    public static final DeferredBlock<Block> CRYSTAL_SKYROOT_SAPLING = register("crystal_skyroot_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.CRYSTAL_SKYROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SAPLING.get()).mapColor(MapColor.DIAMOND)));
    public static final DeferredBlock<Block> ENCHANTED_SKYROOT_SAPLING = register("enchanted_skyroot_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.ENCHANTED_SKYROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SAPLING.get()).mapColor(MapColor.LAPIS)));
    public static final DeferredBlock<Block> SKYROOT_PINE_SAPLING = register("skyroot_pine_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.SKYROOT_PINE_TREE, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SAPLING.get())));
    public static final DeferredBlock<Block> BLUE_SKYROOT_PINE_SAPLING = register("blue_skyroot_pine_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.BLUE_SKYROOT_PINE_TREE, BlockBehaviour.Properties.ofFullCopy(SKYROOT_PINE_SAPLING.get()).mapColor(MapColor.DIAMOND)));
    public static final DeferredBlock<Block> HIGHSPROOT_SAPLING = register("highsproot_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SAPLING.get()).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final DeferredBlock<Block> SAKURA_SAPLING = register("sakura_sapling", () -> new SaplingBlock(AncientAetherTreeGrowers.SAKURA, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SAPLING.get()).mapColor(MapColor.COLOR_PINK)));

    public static final DeferredBlock<Block> SKY_GRASS = register("sky_grass", () -> new SkyGrassBlock(Block.Properties.ofFullCopy(SHORT_GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(AncientAetherBlocks::always)));
    public static final DeferredBlock<Block> SUNSET_ROSE = register("sunset_rose", () -> new FlowerBlock(MobEffects.REGENERATION, 8, Block.Properties.ofFullCopy(WHITE_FLOWER.get())));
    public static final DeferredBlock<Block> SKY_BLUES = register("sky_blues", () -> new FlowerBlock(AetherEffects.REMEDY, 6, Block.Properties.ofFullCopy(WHITE_FLOWER.get())));
    public static final DeferredBlock<Block> WYND_THISTLE = register("wynd_thistle", () -> new FlowerBlock(MobEffects.SLOW_FALLING, 7, Block.Properties.ofFullCopy(WHITE_FLOWER.get())));
    public static final DeferredBlock<Block> ELEVETIA = register("elevetia", () -> new FlowerBlock(MobEffects.LEVITATION, 4, Block.Properties.ofFullCopy(WHITE_FLOWER.get())));
    public static final DeferredBlock<GrapeVineBlock> GRAPE_VINE = BLOCKS.register("grape_vine", () -> new GrapeVineBlock(Block.Properties.ofFullCopy(VINE).noLootTable()));
    public static final DeferredBlock<Block> SLAMMROOT_PLANT = BLOCKS.register("slammroot_plant", () -> new SlammrootPlantBlock(Block.Properties.of().offsetType(BlockBehaviour.OffsetType.XYZ).dynamicShape().noOcclusion().noCollission().mapColor(MapColor.PLANT).sound(SoundType.HANGING_ROOTS).instabreak().pushReaction(PushReaction.DESTROY).noTerrainParticles().noLootTable()));

    public static final DeferredBlock<RotatedPillarBlock> HIGHSPROOT_LOG = register("highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LOG.get())));
    public static final DeferredBlock<RotatedPillarBlock> HIGHSPROOT_WOOD = register("highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(SKYROOT_WOOD.get())));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_HIGHSPROOT_LOG = register("stripped_highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_SKYROOT_LOG.get())));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_HIGHSPROOT_WOOD = register("stripped_highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_SKYROOT_WOOD.get())));
    public static final DeferredBlock<RotatedPillarBlock> SAKURA_LOG = register("sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(SKYROOT_LOG.get())));
    public static final DeferredBlock<RotatedPillarBlock> SAKURA_WOOD = register("sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(SKYROOT_WOOD.get())));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SAKURA_LOG = register("stripped_sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_SKYROOT_LOG.get())));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = register("stripped_sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_SKYROOT_WOOD.get())));

    public static final DeferredBlock<WallBlock> HIGHSPROOT_LOG_WALL = register("highsproot_log_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> HIGHSPROOT_WOOD_WALL = register("highsproot_wood_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> STRIPPED_HIGHSPROOT_LOG_WALL = register("stripped_highsproot_log_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> STRIPPED_HIGHSPROOT_WOOD_WALL = register("stripped_highsproot_wood_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> SAKURA_LOG_WALL = register("sakura_log_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> SAKURA_WOOD_WALL = register("sakura_wood_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> STRIPPED_SAKURA_LOG_WALL = register("stripped_sakura_log_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<WallBlock> STRIPPED_SAKURA_WOOD_WALL = register("stripped_sakura_wood_wall", () -> new WallBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));

    public static final DeferredBlock<Block> HIGHSPROOT_PLANKS = register("highsproot_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SKYROOT_PLANKS.get())));
    public static final DeferredBlock<StairBlock> HIGHSPROOT_STAIRS = register("highsproot_stairs", () -> new StairBlock(() -> HIGHSPROOT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SKYROOT_STAIRS.get())));
    public static final DeferredBlock<SlabBlock> HIGHSPROOT_SLAB = register("highsproot_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(SKYROOT_SLAB.get())));
    public static final DeferredBlock<FenceBlock> HIGHSPROOT_FENCE = register("highsproot_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<FenceGateBlock> HIGHSPROOT_FENCE_GATE = register("highsproot_fence_gate", () -> new FenceGateBlock(AncientAetherBlockSets.HIGHSPROOT, Block.Properties.ofFullCopy(SKYROOT_FENCE_GATE.get())));
    public static final DeferredBlock<DoorBlock> HIGHSPROOT_DOOR = register("highsproot_door", () -> new DoorBlock(AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_DOOR.get())));
    public static final DeferredBlock<TrapDoorBlock> HIGHSPROOT_TRAPDOOR = register("highsproot_trapdoor", () -> new TrapDoorBlock(AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_TRAPDOOR.get())));
    public static final DeferredBlock<ButtonBlock> HIGHSPROOT_BUTTON = register("highsproot_button", () -> new ButtonBlock(AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, 30, Block.Properties.ofFullCopy(SKYROOT_BUTTON.get())));
    public static final DeferredBlock<PressurePlateBlock> HIGHSPROOT_PRESSURE_PLATE = register("highsproot_pressure_plate", () -> new PressurePlateBlock(AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_PRESSURE_PLATE.get())));
    public static final DeferredBlock<StandingSignBlock> HIGHSPROOT_SIGN = register("highsproot_sign", () -> new AncientAetherSignBlock(AncientAetherBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SIGN.get())));
    public static final DeferredBlock<WallSignBlock> HIGHSPROOT_WALL_SIGN = BLOCKS.register("highsproot_wall_sign", () -> new AncientAetherWallSignBlock(AncientAetherBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_WALL_SIGN.get())));
    public static final DeferredBlock<CeilingHangingSignBlock> HIGHSPROOT_HANGING_SIGN = register("highsproot_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(AncientAetherBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_HANGING_SIGN.get())));
    public static final DeferredBlock<WallHangingSignBlock> HIGHSPROOT_WALL_HANGING_SIGN = BLOCKS.register("highsproot_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(AncientAetherBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(SKYROOT_WALL_HANGING_SIGN.get())));
    public static final DeferredBlock<Block> HIGHSPROOT_BOOKSHELF = register("highsproot_bookshelf", () -> new BookshelfBlock(Block.Properties.ofFullCopy(SKYROOT_BOOKSHELF.get())));

    public static final DeferredBlock<Block> SAKURA_PLANKS = register("sakura_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SKYROOT_PLANKS.get())));
    public static final DeferredBlock<StairBlock> SAKURA_STAIRS = register("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SKYROOT_STAIRS.get())));
    public static final DeferredBlock<SlabBlock> SAKURA_SLAB = register("sakura_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(SKYROOT_SLAB.get())));
    public static final DeferredBlock<FenceBlock> SAKURA_FENCE = register("sakura_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(SKYROOT_FENCE.get())));
    public static final DeferredBlock<FenceGateBlock> SAKURA_FENCE_GATE = register("sakura_fence_gate", () -> new FenceGateBlock(AncientAetherBlockSets.SAKURA, Block.Properties.ofFullCopy(SKYROOT_FENCE_GATE.get())));
    public static final DeferredBlock<DoorBlock> SAKURA_DOOR = register("sakura_door", () -> new DoorBlock(AncientAetherBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_DOOR.get())));
    public static final DeferredBlock<TrapDoorBlock> SAKURA_TRAPDOOR = register("sakura_trapdoor", () -> new TrapDoorBlock(AncientAetherBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_TRAPDOOR.get())));
    public static final DeferredBlock<ButtonBlock> SAKURA_BUTTON = register("sakura_button", () -> new ButtonBlock(AncientAetherBlockSets.SAKURA_BLOCK_SET, 30, Block.Properties.ofFullCopy(SKYROOT_BUTTON.get())));
    public static final DeferredBlock<PressurePlateBlock> SAKURA_PRESSURE_PLATE = register("sakura_pressure_plate", () -> new PressurePlateBlock(AncientAetherBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(SKYROOT_PRESSURE_PLATE.get())));
    public static final DeferredBlock<StandingSignBlock> SAKURA_SIGN = register("sakura_sign", () -> new AncientAetherSignBlock(AncientAetherBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(SKYROOT_SIGN.get())));
    public static final DeferredBlock<WallSignBlock> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new AncientAetherWallSignBlock(AncientAetherBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(SKYROOT_WALL_SIGN.get())));
    public static final DeferredBlock<CeilingHangingSignBlock> SAKURA_HANGING_SIGN = register("sakura_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(AncientAetherBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(SKYROOT_HANGING_SIGN.get())));
    public static final DeferredBlock<WallHangingSignBlock> SAKURA_WALL_HANGING_SIGN = BLOCKS.register("sakura_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(AncientAetherBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(SKYROOT_WALL_HANGING_SIGN.get())));
    public static final DeferredBlock<Block> SAKURA_BOOKSHELF = register("sakura_bookshelf", () -> new BookshelfBlock(Block.Properties.ofFullCopy(SKYROOT_BOOKSHELF.get())));

    public static final DeferredBlock<Block> VALKYRUM_BLOCK = register("valkyrum_block", () -> new ValkyrumBlock(Block.Properties.ofFullCopy(ZANITE_BLOCK.get()).strength(6.0F, 8.0F).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<TransparentBlock> AEROGEL_GLASS = register("aerogel_glass", () -> new AerogelGlassBlock(Block.Properties.ofFullCopy(AEROGEL.get()).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final DeferredBlock<IronBarsBlock> AEROGEL_GLASS_PANE = register("aerogel_glass_pane", () -> new IronBarsBlock(Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<DoorBlock> AEROGEL_GLASS_DOOR = register("aerogel_glass_door", () -> new DoorBlock(AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET, Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<TrapDoorBlock> AEROGEL_GLASS_TRAPDOOR = register("aerogel_glass_trapdoor", () -> new TrapDoorBlock(AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET, Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<Block> FLUFFALO_WOOL = register("fluffalo_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(WHITE_WOOL).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final DeferredBlock<CarpetBlock> FLUFFALO_CARPET = register("fluffalo_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(FLUFFALO_WOOL.get())));

    public static final DeferredBlock<Block> CARVED_TILES = register("carved_tiles", () -> new Block(Block.Properties.ofFullCopy(CARVED_STONE.get())));
    public static final DeferredBlock<Block> WYND_SENTRY_STONE = register("wynd_sentry_stone", () -> new Block(Block.Properties.ofFullCopy(SENTRY_STONE.get()).lightLevel(s -> 7)));
    public static final DeferredBlock<StairBlock> CARVED_TILE_STAIRS = register("carved_tile_stairs", () -> new StairBlock(() -> CARVED_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(CARVED_TILES.get())));
    public static final DeferredBlock<SlabBlock> CARVED_TILE_SLAB = register("carved_tile_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(CARVED_TILES.get())));
    public static final DeferredBlock<WallBlock> CARVED_TILE_WALL = register("carved_tile_wall", () -> new WallBlock(Block.Properties.ofFullCopy(CARVED_TILES.get())));

    public static final DeferredBlock<HorizontalDirectionalBlock> ANGELIC_CORNER_BRICK = register("angelic_corner_brick", () -> new HorizontalFacingBlock(Block.Properties.ofFullCopy(ANGELIC_STONE.get())));
    public static final DeferredBlock<Block> VALKYRIE_BRICKS = register("valkyrie_bricks", () -> new Block(Block.Properties.ofFullCopy(PILLAR.get())));
    public static final DeferredBlock<StairBlock> VALKYRIE_BRICK_STAIRS = register("valkyrie_brick_stairs", () -> new StairBlock(() -> VALKYRIE_BRICKS.get().defaultBlockState(), Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> VALKYRIE_BRICK_SLAB = register("valkyrie_brick_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<WallBlock> VALKYRIE_BRICK_WALL = register("valkyrie_brick_wall", () -> new WallBlock(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<Block> VALKYRIE_TILES = register("valkyrie_tiles", () -> new Block(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<StairBlock> VALKYRIE_TILE_STAIRS = register("valkyrie_tile_stairs", () -> new StairBlock(() -> VALKYRIE_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> VALKYRIE_TILE_SLAB = register("valkyrie_tile_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(VALKYRIE_TILES.get())));
    public static final DeferredBlock<WallBlock> VALKYRIE_TILE_WALL = register("valkyrie_tile_wall", () -> new WallBlock(Block.Properties.ofFullCopy(VALKYRIE_TILES.get())));

    public static final DeferredBlock<Block> AEROGETIC_STONE = register("aerogetic_stone", () -> new Block(Block.Properties.ofFullCopy(CARVED_STONE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final DeferredBlock<Block> AERONAUTIC_STONE = register("aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).lightLevel(s -> 11)));
    public static final DeferredBlock<Block> CORRUPTED_AERONAUTIC_STONE = register("corrupted_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(AERONAUTIC_STONE.get())));
    public static final DeferredBlock<StairBlock> AEROGETIC_STAIRS = register("aerogetic_stairs", () -> new StairBlock(() -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<SlabBlock> AEROGETIC_SLAB = register("aerogetic_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<WallBlock> AEROGETIC_WALL = register("aerogetic_wall", () -> new WallBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));

    public static final DeferredBlock<RotatedPillarBlock> HOLYSTONE_BRICK_MOSAIC = register("holystone_brick_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AetherBlocks.HOLYSTONE_BRICKS.get())));
    public static final DeferredBlock<RotatedPillarBlock> CARVED_STONE_MOSAIC = register("carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AetherBlocks.CARVED_STONE.get())));
    public static final DeferredBlock<RotatedPillarBlock> ANGELIC_STONE_MOSAIC = register("angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AetherBlocks.ANGELIC_STONE.get())));
    public static final DeferredBlock<RotatedPillarBlock> HELLFIRE_STONE_MOSAIC = register("hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AetherBlocks.HELLFIRE_STONE.get())));
    public static final DeferredBlock<RotatedPillarBlock> AEROGETIC_STONE_MOSAIC = register("aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<RotatedPillarBlock> GALE_STONE_MOSAIC = register("gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AetherBlocks.CARVED_STONE.get())));

    public static final DeferredBlock<Block> LOCKED_CARVED_TILES = register("locked_carved_tiles", () -> new Block(Block.Properties.ofFullCopy(CARVED_TILES.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_WYND_SENTRY_STONE = register("locked_wynd_sentry_stone", () -> new Block(Block.Properties.ofFullCopy(WYND_SENTRY_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_AEROGETIC_STONE = register("locked_aerogetic_stone", () -> new Block(Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_AERONAUTIC_STONE = register("locked_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).lightLevel(s -> 11).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_CORRUPTED_AERONAUTIC_STONE = register("locked_corrupted_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<RotatedPillarBlock> LOCKED_CARVED_STONE_MOSAIC = register("locked_carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_ANGELIC_STONE_MOSAIC = register("locked_angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(LOCKED_ANGELIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_HELLFIRE_STONE_MOSAIC = register("locked_hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(LOCKED_HELLFIRE_STONE.get()).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_AEROGETIC_STONE_MOSAIC = register("locked_aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_GALE_STONE_MOSAIC = register("locked_gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(LOCKED_CARVED_STONE.get()).noLootTable()));

    public static final DeferredBlock<Block> TRAPPED_CARVED_TILES = register("trapped_carved_tiles", () -> new TrappedBlock(AetherEntityTypes.SENTRY::get, () -> CARVED_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(CARVED_TILES.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_AEROGETIC_STONE = register("trapped_aerogetic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_AERONAUTIC_STONE = register("trapped_aeronautic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_CORRUPTED_AERONAUTIC_STONE = register("trapped_corrupted_aeronautic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> CORRUPTED_AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<Block> BOSS_DOORWAY_CARVED_STONE = register("boss_doorway_carved_stone", () -> new DoorwayBlock(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.ofFullCopy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_WYND_SENTRY_STONE = register("boss_doorway_wynd_sentry_stone", () -> new DoorwayBlock(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.ofFullCopy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_AEROGETIC_STONE = register("boss_doorway_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_AERONAUTIC_STONE = register("boss_doorway_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("boss_doorway_corrupted_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<Block> TREASURE_DOORWAY_WYND_SENTRY_STONE = register("treasure_doorway_wynd_sentry_stone", () -> new TreasureDoorwayBlock(Block.Properties.ofFullCopy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_AEROGETIC_STONE = register("treasure_doorway_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_AERONAUTIC_STONE = register("treasure_doorway_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("treasure_doorway_corrupted_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<LanternBlock> AMBROSIUM_LANTERN = register("ambrosium_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 15)));
    public static final DeferredBlock<LanternBlock> WYND_LANTERN = register("wynd_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 7)));
    public static final DeferredBlock<LanternBlock> SUN_LANTERN = register("sun_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> AMBROSIUM_CAMPFIRE = register("ambrosium_campfire", () -> new AmbrosiumCampfireBlock(false, 1, Block.Properties.ofFullCopy(Blocks.CAMPFIRE)));

    public static final DeferredBlock<Block> VIOLET_AERCLOUD = register("violet_aercloud", () -> new VioletAercloudBlock(BlockBehaviour.Properties.ofFullCopy(COLD_AERCLOUD.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<Block> WIND_BLOWER = register("wind_blower", () -> new WindBlowerBlock(BlockBehaviour.Properties.ofFullCopy(COLD_AERCLOUD.get())));
    public static final DeferredBlock<Block> SLIDER_PROTOTYPE = register("slider_prototype", () -> new SliderPrototypeBlock(BlockBehaviour.Properties.ofFullCopy(CARVED_STONE.get()).strength(5f).noOcclusion()));
    public static final DeferredBlock<Block> ANCIENT_OBELISK = register("ancient_obelisk", () -> new ObeliskBlock(BlockBehaviour.Properties.ofFullCopy(STONE).sound(SoundType.STONE).lightLevel(s -> 3).noLootTable().strength(-1.0F, 3600000.0F).noOcclusion()));
    public static final DeferredBlock<Block> POWERED_OBELISK = register("powered_obelisk", () -> new Block(BlockBehaviour.Properties.ofFullCopy(AEROGETIC_STONE.get()).strength(5f).lightLevel(s -> 12).noOcclusion()));

    public static final DeferredBlock<VaseBlock> HOLYSTONE_VASE = register("holystone_vase", () -> new VaseBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().sound(SoundType.DECORATED_POT).noOcclusion().isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final DeferredBlock<VaseBlock> MOSSY_HOLYSTONE_VASE = register("mossy_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> FROZEN_HOLYSTONE_VASE = register("frozen_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> SENTRY_VASE = register("sentry_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> ANGELIC_VASE = register("angelic_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> HELLFIRE_VASE = register("hellfire_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> AEROGETIC_VASE = register("aerogetic_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> GALE_VASE = register("gale_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));

    public static final DeferredBlock<AncientVaseBlock> ANCIENT_HOLYSTONE_VASE = register("ancient_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get()).sound(SoundType.DECORATED_POT_CRACKED).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_MOSSY_HOLYSTONE_VASE = register("ancient_mossy_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_MOSSY_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_FROZEN_HOLYSTONE_VASE = register("ancient_frozen_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_FROZEN_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_SENTRY_VASE = register("ancient_sentry_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_SENTRY_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_ANGELIC_VASE = register("ancient_angelic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_ANGELIC_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_HELLFIRE_VASE = register("ancient_hellfire_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HELLFIRE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_AEROGETIC_VASE = register("ancient_aerogetic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_AEROGETIC_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_GALE_VASE = register("ancient_gale_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_GALE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));

    public static final DeferredBlock<FlowerPotBlock> POTTED_CRYSTAL_SKYROOT_SAPLING = BLOCKS.register("potted_crystal_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYSTAL_SKYROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ENCHANTED_SKYROOT_SAPLING = BLOCKS.register("potted_divine_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ENCHANTED_SKYROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKYROOT_PINE_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_BLUE_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_blue_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_SKYROOT_PINE_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_HIGHSPROOT_SAPLING = BLOCKS.register("potted_highsproot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHSPROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SUNSET_ROSE = BLOCKS.register("potted_highland_cyclamen", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNSET_ROSE, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SKY_BLUES = BLOCKS.register("potted_sky_blues", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKY_BLUES, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_WYND_THISTLE = BLOCKS.register("potted_wynd_thistle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WYND_THISTLE, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ELEVETIA = BLOCKS.register("potted_elevetia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ELEVETIA, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.SKYROOT_PINE_SAPLING.getId(), AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING);
        pot.addPlant(AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.getId(), AncientAetherBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING);
        pot.addPlant(AncientAetherBlocks.HIGHSPROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.SAKURA_SAPLING.getId(), AncientAetherBlocks.POTTED_SAKURA_SAPLING);
        pot.addPlant(AncientAetherBlocks.SUNSET_ROSE.getId(), AncientAetherBlocks.POTTED_SUNSET_ROSE);
        pot.addPlant(AncientAetherBlocks.SKY_BLUES.getId(), AncientAetherBlocks.POTTED_SKY_BLUES);
        pot.addPlant(AncientAetherBlocks.WYND_THISTLE.getId(), AncientAetherBlocks.POTTED_WYND_THISTLE);
        pot.addPlant(AncientAetherBlocks.ELEVETIA.getId(), AncientAetherBlocks.POTTED_ELEVETIA);
    }

    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.BLUE_SKYROOT_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKY_GRASS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SUNSET_ROSE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKY_BLUES.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.WYND_THISTLE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.ELEVETIA.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.GRAPE_VINE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE.get(), 5, 20);
    }

    public static void registerWoodTypes() {
        WoodType.register(AncientAetherBlockSets.HIGHSPROOT);
        WoodType.register(AncientAetherBlockSets.SAKURA);
    }

    private static boolean never(BlockState test1, BlockGetter test2, BlockPos test3) {
        return false;
    }
    private static boolean always(BlockState test1, BlockGetter test2, BlockPos test3) {
        return true;
    }

    private static boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AncientAetherItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}