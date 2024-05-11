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
import com.aetherteam.aether.blockentity.AltarBlockEntity;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.block.BurnableBlockItem;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherConfig;
import net.builderdog.ancient_aether.block.blocktype.*;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.treegrower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.aetherteam.aether.block.AetherBlocks.*;
import static net.minecraft.world.level.block.Blocks.*;

@SuppressWarnings("deprecation")
public class AncientAetherBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AncientAether.MODID);

    public static final RegistryObject<Block> GRAVITY_GRAVEL = register("gravity_gravel", () -> new AetherDoubleDropBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).jumpFactor(1.5F).strength(0.25F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WYND_ICE = register("wynd_ice", () -> new Block(Block.Properties.copy(PACKED_ICE)));
    public static final RegistryObject<Block> VALKYRIE_CLAY = register("valkyrie_clay", () -> new AetherDoubleDropBlock(Block.Properties.copy(CLAY).mapColor(MapColor.SNOW)));

    public static final RegistryObject<Block> AETHER_QUARTZ_ORE = register("aether_quartz_ore", () -> new AetherDoubleDropsOreBlock(Block.Properties.copy(NETHER_QUARTZ_ORE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> VALKYRUM_ORE = register("valkyrum_ore", () -> new ValkyrumBlock(Block.Properties.of().strength(5.0F, 5.0F).requiresCorrectToolForDrops().mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<Block> ATMOSINE_CRYSTAL = register("atmosine_crystal", () -> new AtmosineCrystalBlock(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 5)));

    public static final RegistryObject<Block> CRYSTAL_SKYROOT_LEAVES = register("crystal_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(CRYSTAL_LEAVES.get())));
    public static final RegistryObject<Block> ENCHANTED_SKYROOT_LEAVES = register("enchanted_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).mapColor(MapColor.LAPIS).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> SKYROOT_PINE_LEAVES = register("skyroot_pine_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get())));
    public static final RegistryObject<Block> BLUE_SKYROOT_PINE_LEAVES = register("blue_skyroot_pine_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_PINE_LEAVES.get()).mapColor(MapColor.DIAMOND)));
    public static final RegistryObject<Block> HIGHSPROOT_LEAVES = register("highsproot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).mapColor(MapColor.TERRACOTTA_BLUE).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> SAKURA_LEAVES = register("sakura_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).sound(SoundType.CHERRY_LEAVES).mapColor(MapColor.COLOR_PINK).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));

    public static final RegistryObject<Block> CRYSTAL_SKYROOT_SAPLING = register("crystal_skyroot_sapling", () -> new SaplingBlock(new CrystalSkyrootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.DIAMOND)));
    public static final RegistryObject<Block> ENCHANTED_SKYROOT_SAPLING = register("enchanted_skyroot_sapling", () -> new SaplingBlock(new EnchantedSkyrootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.LAPIS)));
    public static final RegistryObject<Block> SKYROOT_PINE_SAPLING = register("skyroot_pine_sapling", () -> new SaplingBlock(new SkyrootPineTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get())));
    public static final RegistryObject<Block> BLUE_SKYROOT_PINE_SAPLING = register("blue_skyroot_pine_sapling", () -> new SaplingBlock(new BlueSkyrootPineTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_PINE_SAPLING.get()).mapColor(MapColor.DIAMOND)));
    public static final RegistryObject<Block> HIGHSPROOT_SAPLING = register("highsproot_sapling", () -> new SaplingBlock(new HighsprootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> SAKURA_SAPLING = register("sakura_sapling", () -> new SaplingBlock(new SakuraTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> SKY_GRASS = register("sky_grass", () -> new SkyGrassBlock(Block.Properties.copy(GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(AncientAetherBlocks::always)));
    public static final RegistryObject<Block> SUNSET_ROSE = register("sunset_rose", () -> new FlowerBlock(MobEffects.REGENERATION, 8, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> SKY_BLUES = register("sky_blues", () -> new FlowerBlock(AetherEffects.REMEDY, 6, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> WYND_THISTLE = register("wynd_thistle", () -> new FlowerBlock(MobEffects.SLOW_FALLING, 7, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> ELEVETIA = register("elevetia", () -> new FlowerBlock(MobEffects.LEVITATION, 4, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<GrapeVineBlock> GRAPE_VINE = BLOCKS.register("grape_vine", () -> new GrapeVineBlock(Block.Properties.copy(VINE).noLootTable()));
    public static final RegistryObject<Block> SLAMMROOT_PLANT = BLOCKS.register("slammroot_plant", () -> new SlammrootPlantBlock(Block.Properties.of().offsetType(BlockBehaviour.OffsetType.XYZ).dynamicShape().noOcclusion().noCollission().mapColor(MapColor.PLANT).sound(SoundType.HANGING_ROOTS).instabreak().pushReaction(PushReaction.DESTROY).noParticlesOnBreak().noLootTable()));

    public static final RegistryObject<RotatedPillarBlock> HIGHSPROOT_LOG = register("highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> HIGHSPROOT_WOOD = register("highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_WOOD.get())));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_HIGHSPROOT_LOG = register("stripped_highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_HIGHSPROOT_WOOD = register("stripped_highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_WOOD.get())));
    public static final RegistryObject<RotatedPillarBlock> SAKURA_LOG = register("sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> SAKURA_WOOD = register("sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_WOOD.get())));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_LOG = register("stripped_sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = register("stripped_sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_WOOD.get())));

    public static final RegistryObject<WallBlock> HIGHSPROOT_LOG_WALL = register("highsproot_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> HIGHSPROOT_WOOD_WALL = register("highsproot_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_LOG_WALL = register("stripped_highsproot_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_WOOD_WALL = register("stripped_highsproot_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> SAKURA_LOG_WALL = register("sakura_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> SAKURA_WOOD_WALL = register("sakura_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_LOG_WALL = register("stripped_sakura_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_WOOD_WALL = register("stripped_sakura_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));

    public static final RegistryObject<Block> HIGHSPROOT_PLANKS = register("highsproot_planks", () -> new Block(BlockBehaviour.Properties.copy(SKYROOT_PLANKS.get())));
    public static final RegistryObject<StairBlock> HIGHSPROOT_STAIRS = register("highsproot_stairs", () -> new StairBlock(() -> HIGHSPROOT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SKYROOT_STAIRS.get())));
    public static final RegistryObject<SlabBlock> HIGHSPROOT_SLAB = register("highsproot_slab", () -> new SlabBlock(Block.Properties.copy(SKYROOT_SLAB.get())));
    public static final RegistryObject<FenceBlock> HIGHSPROOT_FENCE = register("highsproot_fence", () -> new FenceBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<FenceGateBlock> HIGHSPROOT_FENCE_GATE = register("highsproot_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(SKYROOT_FENCE_GATE.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<DoorBlock> HIGHSPROOT_DOOR = register("highsproot_door", () -> new DoorBlock(Block.Properties.copy(SKYROOT_DOOR.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> HIGHSPROOT_TRAPDOOR = register("highsproot_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(SKYROOT_TRAPDOOR.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> HIGHSPROOT_BUTTON = register("highsproot_button", () -> new ButtonBlock(Block.Properties.copy(SKYROOT_BUTTON.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> HIGHSPROOT_PRESSURE_PLATE = register("highsproot_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(SKYROOT_PRESSURE_PLATE.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<StandingSignBlock> HIGHSPROOT_SIGN = register("highsproot_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(SKYROOT_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<WallSignBlock> HIGHSPROOT_WALL_SIGN = BLOCKS.register("highsproot_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<CeilingHangingSignBlock> HIGHSPROOT_HANGING_SIGN = register("highsproot_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_HANGING_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<WallHangingSignBlock> HIGHSPROOT_WALL_HANGING_SIGN = BLOCKS.register("highsproot_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_HANGING_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<Block> HIGHSPROOT_BOOKSHELF = register("highsproot_bookshelf", () -> new BookshelfBlock(Block.Properties.copy(SKYROOT_BOOKSHELF.get())));

    public static final RegistryObject<Block> SAKURA_PLANKS = register("sakura_planks", () -> new Block(BlockBehaviour.Properties.copy(SKYROOT_PLANKS.get())));
    public static final RegistryObject<StairBlock> SAKURA_STAIRS = register("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SKYROOT_STAIRS.get())));
    public static final RegistryObject<SlabBlock> SAKURA_SLAB = register("sakura_slab", () -> new SlabBlock(Block.Properties.copy(SKYROOT_SLAB.get())));
    public static final RegistryObject<FenceBlock> SAKURA_FENCE = register("sakura_fence", () -> new FenceBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<FenceGateBlock> SAKURA_FENCE_GATE = register("sakura_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(SKYROOT_FENCE_GATE.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<DoorBlock> SAKURA_DOOR = register("sakura_door", () -> new DoorBlock(Block.Properties.copy(SKYROOT_DOOR.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> SAKURA_TRAPDOOR = register("sakura_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(SKYROOT_TRAPDOOR.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> SAKURA_BUTTON = register("sakura_button", () -> new ButtonBlock(Block.Properties.copy(SKYROOT_BUTTON.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> SAKURA_PRESSURE_PLATE = register("sakura_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(SKYROOT_PRESSURE_PLATE.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<StandingSignBlock> SAKURA_SIGN = register("sakura_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(SKYROOT_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<WallSignBlock> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<CeilingHangingSignBlock> SAKURA_HANGING_SIGN = register("sakura_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_HANGING_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<WallHangingSignBlock> SAKURA_WALL_HANGING_SIGN = BLOCKS.register("sakura_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_HANGING_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<Block> SAKURA_BOOKSHELF = register("sakura_bookshelf", () -> new BookshelfBlock(Block.Properties.copy(SKYROOT_BOOKSHELF.get())));

    public static final RegistryObject<Block> VALKYRUM_BLOCK = register("valkyrum_block", () -> new ValkyrumBlock(Block.Properties.copy(ZANITE_BLOCK.get()).strength(6.0F, 8.0F).mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<GlassBlock> AEROGEL_GLASS = register("aerogel_glass", () -> new GlassBlock(Block.Properties.copy(AEROGEL.get()).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<IronBarsBlock> AEROGEL_GLASS_PANE = register("aerogel_glass_pane", () -> new IronBarsBlock(Block.Properties.copy(AEROGEL_GLASS.get())));
    public static final RegistryObject<DoorBlock> AEROGEL_GLASS_DOOR = register("aerogel_glass_door", () -> new DoorBlock(Block.Properties.copy(AEROGEL_GLASS.get()), AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> AEROGEL_GLASS_TRAPDOOR = register("aerogel_glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(AEROGEL_GLASS.get()), AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET));
    public static final RegistryObject<Block> FLUFFALO_WOOL = register("fluffalo_wool", () -> new Block(BlockBehaviour.Properties.copy(WHITE_WOOL).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<CarpetBlock> FLUFFALO_CARPET = register("fluffalo_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(FLUFFALO_WOOL.get())));

    public static final RegistryObject<Block> CARVED_TILES = register("carved_tiles", () -> new Block(Block.Properties.copy(CARVED_STONE.get())));
    public static final RegistryObject<Block> WYND_SENTRY_STONE = register("wynd_sentry_stone", () -> new Block(Block.Properties.copy(SENTRY_STONE.get()).lightLevel(s -> 7)));
    public static final RegistryObject<StairBlock> CARVED_TILE_STAIRS = register("carved_tile_stairs", () -> new StairBlock(() -> CARVED_TILES.get().defaultBlockState(), Block.Properties.copy(CARVED_TILES.get())));
    public static final RegistryObject<SlabBlock> CARVED_TILE_SLAB = register("carved_tile_slab", () -> new SlabBlock(Block.Properties.copy(CARVED_TILES.get())));
    public static final RegistryObject<WallBlock> CARVED_TILE_WALL = register("carved_tile_wall", () -> new WallBlock(Block.Properties.copy(CARVED_TILES.get())));

    public static final RegistryObject<HorizontalDirectionalBlock> ANGELIC_CORNER_BRICK = register("angelic_corner_brick", () -> new HorizontalFacingBlock(Block.Properties.copy(ANGELIC_STONE.get())));
    public static final RegistryObject<Block> VALKYRIE_BRICKS = register("valkyrie_bricks", () -> new Block(Block.Properties.copy(PILLAR.get())));
    public static final RegistryObject<StairBlock> VALKYRIE_BRICK_STAIRS = register("valkyrie_brick_stairs", () -> new StairBlock(() -> VALKYRIE_BRICKS.get().defaultBlockState(), Block.Properties.copy(VALKYRIE_BRICKS.get())));
    public static final RegistryObject<SlabBlock> VALKYRIE_BRICK_SLAB = register("valkyrie_brick_slab", () -> new SlabBlock(Block.Properties.copy(VALKYRIE_BRICKS.get())));
    public static final RegistryObject<WallBlock> VALKYRIE_BRICK_WALL = register("valkyrie_brick_wall", () -> new WallBlock(Block.Properties.copy(VALKYRIE_BRICKS.get())));

    public static final RegistryObject<Block> AEROGETIC_STONE = register("aerogetic_stone", () -> new Block(Block.Properties.copy(CARVED_STONE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> AERONAUTIC_STONE = register("aeronautic_stone", () -> new Block(Block.Properties.copy(AEROGETIC_STONE.get()).lightLevel(s -> 11)));
    public static final RegistryObject<Block> CORRUPTED_AERONAUTIC_STONE = register("corrupted_aeronautic_stone", () -> new Block(Block.Properties.copy(AERONAUTIC_STONE.get())));
    public static final RegistryObject<StairBlock> AEROGETIC_STAIRS = register("aerogetic_stairs", () -> new StairBlock(() -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.copy(AEROGETIC_STONE.get())));
    public static final RegistryObject<SlabBlock> AEROGETIC_SLAB = register("aerogetic_slab", () -> new SlabBlock(Block.Properties.copy(AEROGETIC_STONE.get())));
    public static final RegistryObject<WallBlock> AEROGETIC_WALL = register("aerogetic_wall", () -> new WallBlock(Block.Properties.copy(AEROGETIC_STONE.get())));

    public static final RegistryObject<RotatedPillarBlock> HOLYSTONE_BRICK_MOSAIC = register("holystone_brick_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HOLYSTONE_BRICKS.get())));
    public static final RegistryObject<RotatedPillarBlock> CARVED_STONE_MOSAIC = register("carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> ANGELIC_STONE_MOSAIC = register("angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.ANGELIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> HELLFIRE_STONE_MOSAIC = register("hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HELLFIRE_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> AEROGETIC_STONE_MOSAIC = register("aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AEROGETIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> GALE_STONE_MOSAIC = register("gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));

    public static final RegistryObject<Block> LOCKED_CARVED_TILES = register("locked_carved_tiles", () -> new Block(Block.Properties.copy(CARVED_TILES.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_WYND_SENTRY_STONE = register("locked_wynd_sentry_stone", () -> new Block(Block.Properties.copy(WYND_SENTRY_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_AEROGETIC_STONE = register("locked_aerogetic_stone", () -> new Block(Block.Properties.copy(AEROGETIC_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_AERONAUTIC_STONE = register("locked_aeronautic_stone", () -> new Block(Block.Properties.copy(LOCKED_AEROGETIC_STONE.get()).lightLevel(s -> 11).noLootTable()));
    public static final RegistryObject<Block> LOCKED_CORRUPTED_AERONAUTIC_STONE = register("locked_corrupted_aeronautic_stone", () -> new Block(Block.Properties.copy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final RegistryObject<RotatedPillarBlock> LOCKED_CARVED_STONE_MOSAIC = register("locked_carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_ANGELIC_STONE_MOSAIC = register("locked_angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_ANGELIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_HELLFIRE_STONE_MOSAIC = register("locked_hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_HELLFIRE_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_AEROGETIC_STONE_MOSAIC = register("locked_aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_GALE_STONE_MOSAIC = register("locked_gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> TRAPPED_CARVED_TILES = register("trapped_carved_tiles", () -> new TrappedBlock(AetherEntityTypes.SENTRY::get, () -> CARVED_TILES.get().defaultBlockState(), Block.Properties.copy(CARVED_TILES.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_AEROGETIC_STONE = register("trapped_aerogetic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.copy(AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_AERONAUTIC_STONE = register("trapped_aeronautic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.copy(AERONAUTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_CORRUPTED_AERONAUTIC_STONE = register("trapped_corrupted_aeronautic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> CORRUPTED_AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.copy(CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> BOSS_DOORWAY_CARVED_STONE = register("boss_doorway_carved_stone", () -> new DoorwayBlock(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_WYND_SENTRY_STONE = register("boss_doorway_wynd_sentry_stone", () -> new DoorwayBlock(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.copy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_AEROGETIC_STONE = register("boss_doorway_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_AERONAUTIC_STONE = register("boss_doorway_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("boss_doorway_corrupted_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> TREASURE_DOORWAY_WYND_SENTRY_STONE = register("treasure_doorway_wynd_sentry_stone", () -> new TreasureDoorwayBlock(Block.Properties.copy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_AEROGETIC_STONE = register("treasure_doorway_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_AERONAUTIC_STONE = register("treasure_doorway_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("treasure_doorway_corrupted_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final RegistryObject<LanternBlock> AMBROSIUM_LANTERN = register("ambrosium_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 15)));
    public static final RegistryObject<LanternBlock> WYND_LANTERN = register("wynd_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 7)));
    public static final RegistryObject<LanternBlock> SUN_LANTERN = register("sun_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 12)));
    public static final RegistryObject<Block> AMBROSIUM_CAMPFIRE = register("ambrosium_campfire", () -> new AmbrosiumCampfireBlock(false, 1, Block.Properties.copy(Blocks.CAMPFIRE)));

    public static final RegistryObject<Block> VIOLET_AERCLOUD = register("violet_aercloud", () -> new VioletAercloudBlock(BlockBehaviour.Properties.copy(COLD_AERCLOUD.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> WIND_BLOWER = register("wind_blower", () -> new WindBlowerBlock(BlockBehaviour.Properties.copy(COLD_AERCLOUD.get())));
    public static final RegistryObject<Block> SLIDER_PROTOTYPE = register("slider_prototype", () -> new SliderPrototypeBlock(BlockBehaviour.Properties.copy(CARVED_STONE.get()).strength(5f).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_OBELISK = register("ancient_obelisk", () -> new ObeliskBlock(BlockBehaviour.Properties.copy(STONE).sound(SoundType.STONE).lightLevel(s -> 3).noLootTable().strength(-1.0F, 3600000.0F).noOcclusion()));
    public static final RegistryObject<Block> POWERED_OBELISK = register("powered_obelisk", () -> new Block(BlockBehaviour.Properties.copy(AEROGETIC_STONE.get()).strength(5f).lightLevel(s -> 12).noOcclusion()));

    public static final RegistryObject<VaseBlock> HOLYSTONE_VASE = register("holystone_vase", () -> new VaseBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().sound(SoundType.DECORATED_POT).noOcclusion().isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<VaseBlock> MOSSY_HOLYSTONE_VASE = register("mossy_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> FROZEN_HOLYSTONE_VASE = register("frozen_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> SENTRY_VASE = register("sentry_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> ANGELIC_VASE = register("angelic_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> HELLFIRE_VASE = register("hellfire_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> AEROGETIC_VASE = register("aerogetic_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<VaseBlock> GALE_VASE = register("gale_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));

    public static final RegistryObject<AncientVaseBlock> ANCIENT_HOLYSTONE_VASE = register("ancient_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get()).sound(SoundType.DECORATED_POT_CRACKED).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_MOSSY_HOLYSTONE_VASE = register("ancient_mossy_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_MOSSY_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_FROZEN_HOLYSTONE_VASE = register("ancient_frozen_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_FROZEN_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_SENTRY_VASE = register("ancient_sentry_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_SENTRY_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_ANGELIC_VASE = register("ancient_angelic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_ANGELIC_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_HELLFIRE_VASE = register("ancient_hellfire_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HELLFIRE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_AEROGETIC_VASE = register("ancient_aerogetic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_AEROGETIC_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<AncientVaseBlock> ANCIENT_GALE_VASE = register("ancient_gale_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_GALE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));

    public static final RegistryObject<FlowerPotBlock> POTTED_CRYSTAL_SKYROOT_SAPLING = BLOCKS.register("potted_crystal_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYSTAL_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_ENCHANTED_SKYROOT_SAPLING = BLOCKS.register("potted_divine_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ENCHANTED_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKYROOT_PINE_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_BLUE_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_blue_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_SKYROOT_PINE_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHSPROOT_SAPLING = BLOCKS.register("potted_highsproot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHSPROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SUNSET_ROSE = BLOCKS.register("potted_highland_cyclamen", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNSET_ROSE, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SKY_BLUES = BLOCKS.register("potted_sky_blues", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKY_BLUES, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_WYND_THISTLE = BLOCKS.register("potted_wynd_thistle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WYND_THISTLE, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_ELEVETIA = BLOCKS.register("potted_elevetia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ELEVETIA, Block.Properties.copy(Blocks.FLOWER_POT)));

    public static void registerFuels() {
        AltarBlockEntity.addItemEnchantingTime(AetherItems.AMBROSIUM_SHARD.get(), 250);
        AltarBlockEntity.addItemEnchantingTime(AetherBlocks.AMBROSIUM_BLOCK.get(), 2500);
        if (AncientAetherConfig.COMMON.experimental_features.get()) {
            AltarBlockEntity.addItemEnchantingTime(AncientAetherBlocks.ATMOSINE_CRYSTAL.get(), 500);
        }
    }

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

    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        AncientAetherItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    @SuppressWarnings("unchecked")
    private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block) {
        return (RegistryObject<B>) baseRegister(name, block, AncientAetherBlocks::registerBlockItem);
    }

    private static <B extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<B> blockRegistryObject) {
        return () -> {
            B block = Objects.requireNonNull(blockRegistryObject.get());
            if (block == HIGHSPROOT_SIGN.get()) {
                return new SignItem(new Item.Properties().stacksTo(16), HIGHSPROOT_SIGN.get(), HIGHSPROOT_WALL_SIGN.get());
            } else if (block == SAKURA_SIGN.get()) {
                return new SignItem(new Item.Properties().stacksTo(16), SAKURA_SIGN.get(), SAKURA_WALL_SIGN.get());
            } else if (block == HIGHSPROOT_HANGING_SIGN.get()) {
                return new SignItem(new Item.Properties().stacksTo(16), HIGHSPROOT_HANGING_SIGN.get(), HIGHSPROOT_WALL_HANGING_SIGN.get());
            } else if (block == SAKURA_HANGING_SIGN.get()) {
                return new SignItem(new Item.Properties().stacksTo(16), SAKURA_HANGING_SIGN.get(), SAKURA_WALL_HANGING_SIGN.get());
            } else if (block == HIGHSPROOT_PLANKS.get()
                    || block == SAKURA_PLANKS.get()) {
                return new BurnableBlockItem(block, new Item.Properties());
            } else {
                return new BlockItem(block, new Item.Properties());
            }
        };
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

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}