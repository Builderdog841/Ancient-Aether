package net.builderdog.ancient_aether.block;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.block.construction.QuicksoilGlassBlock;
import com.aetherteam.aether.block.dungeon.DoorwayBlock;
import com.aetherteam.aether.block.dungeon.TrappedBlock;
import com.aetherteam.aether.block.dungeon.TreasureDoorwayBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import com.aetherteam.aether.block.natural.AetherDoubleDropsOreBlock;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.ancient_aether.block.building.*;
import net.builderdog.ancient_aether.block.functional.AmbrosiumCampfireBlock;
import net.builderdog.ancient_aether.block.functional.CrackedSliderBlock;
import net.builderdog.ancient_aether.block.functional.TrappedFlowerBlock;
import net.builderdog.ancient_aether.block.functional.UnpoweredObeliskBlock;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.tree.HighsprootTreeGrower;
import net.builderdog.ancient_aether.world.tree.SakuraTreeGrower;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.aetherteam.aether.block.AetherBlocks.*;
import static net.minecraft.world.level.block.Blocks.AIR;

public class AncientAetherBlocks  {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AncientAether.MOD_ID);

    //Highsproot Wood
    public static final RegistryObject<Block> HIGHSPROOT_LOG = registerBlock("highsproot_log", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f)));
    public static final RegistryObject<Block> HIGHSPROOT_WOOD = registerBlock("highsproot_wood", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)));
    public static final RegistryObject<Block> STRIPPED_HIGHSPROOT_LOG = registerBlock("stripped_highsproot_log", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2f)));
    public static final RegistryObject<Block> STRIPPED_HIGHSPROOT_WOOD = registerBlock("stripped_highsproot_wood", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f)));
    public static final RegistryObject<Block> HIGHSPROOT_PLANKS = registerBlock("highsproot_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)));
    public static final RegistryObject<Block> HIGHSPROOT_STAIRS = registerBlock("highsproot_stairs", () -> new StairBlock(() -> HIGHSPROOT_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()))));
    public static final RegistryObject<Block> HIGHSPROOT_SLAB = registerBlock("highsproot_slab", () -> new SlabBlock(Block.Properties.copy(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()).strength(2.0F, 3.0F)));
    public static final RegistryObject<FenceBlock> HIGHSPROOT_FENCE = registerBlock("highsproot_fence", () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> HIGHSPROOT_FENCE_GATE = registerBlock("highsproot_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), AncientAetherWoodTypes.HIGHSPROOT));
    public static final RegistryObject<WallBlock> HIGHSPROOT_LOG_WALL = registerBlock("highsproot_log_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> HIGHSPROOT_WOOD_WALL = registerBlock("highsproot_wood_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_LOG_WALL = registerBlock("stripped_highsproot_log_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_WOOD_WALL = registerBlock("stripped_highsproot_wood_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<DoorBlock> HIGHSPROOT_DOOR = registerBlock("highsproot_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), AncientAetherWoodTypes.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> HIGHSPROOT_TRAPDOOR = registerBlock("highsproot_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), AncientAetherWoodTypes.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> HIGHSPROOT_BUTTON = registerBlock("highsproot_button", () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), AncientAetherWoodTypes.HIGHSPROOT_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> HIGHSPROOT_PRESSURE_PLATE = registerBlock("highsproot_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), AncientAetherWoodTypes.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<Block> HIGHSPROOT_WALL_SIGN = BLOCKS.register("highsproot_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), AncientAetherWoodTypes.HIGHSPROOT));
    public static final RegistryObject<Block> HIGHSPROOT_SIGN = BLOCKS.register("highsproot_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), AncientAetherWoodTypes.HIGHSPROOT));
    public static final RegistryObject<Block> HIGHSPROOT_LEAVES = registerBlock("highsproot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_BLUE).strength(0.2f).sound(SoundType.GRASS).noOcclusion().isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> HIGHSPROOT_SAPLING = registerBlock("highsproot_sapling", () -> new SaplingBlock(new HighsprootTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> FROSTED_HIGHSPROOT_LEAVES = registerBlock("frosted_highsproot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_LIGHT_BLUE).strength(0.2f).sound(SoundType.GRASS).noOcclusion().isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> FROSTED_HIGHSPROOT_SAPLING = registerBlock("frosted_highsproot_sapling", () -> new SaplingBlock(new HighsprootTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //Sakura Wood
    public static final RegistryObject<Block> SAKURA_LOG = registerBlock("sakura_log", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f)));
    public static final RegistryObject<Block> SAKURA_WOOD = registerBlock("sakura_wood", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)));
    public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = registerBlock("stripped_sakura_log", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2f)));
    public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = registerBlock("stripped_sakura_wood", () -> new AncientAetherLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f)));
    public static final RegistryObject<Block> SAKURA_PLANKS = registerBlock("sakura_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2f)));
    public static final RegistryObject<Block> SAKURA_STAIRS = registerBlock("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(AncientAetherBlocks.SAKURA_PLANKS.get()))));
    public static final RegistryObject<Block> SAKURA_SLAB = registerBlock("sakura_slab", () -> new SlabBlock(Block.Properties.copy(AncientAetherBlocks.SAKURA_PLANKS.get()).strength(2.0F, 3.0F)));
    public static final RegistryObject<FenceBlock> SAKURA_FENCE = registerBlock("sakura_fence", () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> SAKURA_FENCE_GATE = registerBlock("sakura_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), AncientAetherWoodTypes.SAKURA));
    public static final RegistryObject<WallBlock> SAKURA_LOG_WALL = registerBlock("sakura_log_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> SAKURA_WOOD_WALL = registerBlock("sakura_wood_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_LOG_WALL = registerBlock("stripped_sakura_log_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_WOOD_WALL = registerBlock("stripped_sakura_wood_wall", () -> new AncientAetherLogWallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<DoorBlock> SAKURA_DOOR = registerBlock("sakura_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), AncientAetherWoodTypes.SAKURA_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> SAKURA_TRAPDOOR = registerBlock("sakura_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), AncientAetherWoodTypes.SAKURA_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> SAKURA_BUTTON = registerBlock("sakura_button", () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), AncientAetherWoodTypes.SAKURA_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> SAKURA_PRESSURE_PLATE = registerBlock("sakura_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), AncientAetherWoodTypes.SAKURA_BLOCK_SET));
    public static final RegistryObject<Block> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), AncientAetherWoodTypes.SAKURA));
    public static final RegistryObject<Block> SAKURA_SIGN = BLOCKS.register("sakura_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), AncientAetherWoodTypes.SAKURA));
    public static final RegistryObject<Block> SAKURA_LEAVES = registerBlock("sakura_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PINK).strength(0.2f).sound(SoundType.GRASS).noOcclusion().isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> SAKURA_SAPLING = registerBlock("sakura_sapling", () -> new SaplingBlock(new SakuraTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //Stone Blocks
    public static final RegistryObject<RotatedPillarBlock> HOLYSTONE_BRICK_MOSAIC = registerBlock("holystone_brick_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HOLYSTONE_BRICKS.get())));
    public static final RegistryObject<Block> QUICKSTONE = registerBlock("quickstone", () -> new QuicksoilGlassBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.5F).friction(1.1F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUICKSTONE_STAIRS = registerBlock("quickstone_stairs", () -> new StairBlock(() -> QUICKSTONE.get().defaultBlockState(), (BlockBehaviour.Properties.copy(AncientAetherBlocks.QUICKSTONE.get()))));
    public static final RegistryObject<Block> QUICKSTONE_SLAB = registerBlock("quickstone_slab", () -> new QuickstoneSlabBlock(Block.Properties.copy(AncientAetherBlocks.QUICKSTONE.get()).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> AETHER_QUARTZ_ORE = registerBlock("aether_quartz_ore", () -> new AetherDoubleDropsOreBlock(Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(3.0F).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    //Dungeon Blocks
    public static final RegistryObject<Block> AEROTIC_STONE = registerBlock("aerotic_stone", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).strength(0.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AEROTIC_STAIRS = registerBlock("aerotic_stairs", () -> new StairBlock(() -> AEROTIC_STONE.get().defaultBlockState(), (Block.Properties.copy(AEROTIC_STONE.get()))));
    public static final RegistryObject<Block> AEROTIC_SLAB = registerBlock("aerotic_slab", () -> new SlabBlock(Block.Properties.copy(AEROTIC_STONE.get())));
    public static final RegistryObject<Block> AEROTIC_WALL = registerBlock("aerotic_wall", () -> new WallBlock(Block.Properties.copy(AEROTIC_STONE.get())));
    public static final RegistryObject<Block> LIGHT_AEROTIC_STONE = registerBlock("light_aerotic_stone", () -> new Block(Block.Properties.copy(AEROTIC_STONE.get()).lightLevel(s -> 11)));
    public static final RegistryObject<Block> CORRUPTED_LIGHT_AEROTIC_STONE = registerBlock("corrupted_light_aerotic_stone", () -> new Block(Block.Properties.copy(LIGHT_AEROTIC_STONE.get())));
    public static final RegistryObject<Block> LOCKED_AEROTIC_STONE = registerBlock("locked_aerotic_stone", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_LIGHT_AEROTIC_STONE = registerBlock("locked_light_aerotic_stone", () -> new Block(Block.Properties.copy(LOCKED_AEROTIC_STONE.get()).lightLevel(s -> 11).noLootTable()));
    public static final RegistryObject<Block> LOCKED_CORRUPTED_LIGHT_AEROTIC_STONE = registerBlock("locked_corrupted_light_aerotic_stone", () -> new Block(Block.Properties.copy(LOCKED_LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_AEROTIC_STONE = registerBlock("trapped_aerotic_stone", () -> new TrappedBlock(AncientAetherEntities.LEAPING_SENTRY::get, () -> AEROTIC_STONE.get().defaultBlockState(), Block.Properties.copy(AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_LIGHT_AEROTIC_STONE = registerBlock("trapped_light_aerotic_stone", () -> new TrappedBlock(AncientAetherEntities.LEAPING_SENTRY::get, () -> LIGHT_AEROTIC_STONE.get().defaultBlockState(), Block.Properties.copy(LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_CORRUPTED_LIGHT_AEROTIC_STONE = registerBlock("trapped_corrupted_light_aerotic_stone", () -> new TrappedBlock(AncientAetherEntities.LEAPING_SENTRY::get, () -> CORRUPTED_LIGHT_AEROTIC_STONE.get().defaultBlockState(), Block.Properties.copy(CORRUPTED_LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_AEROTIC_STONE = registerBlock("boss_doorway_aerotic_stone", () -> new DoorwayBlock(AncientAetherEntities.ANCIENT_GUARDIAN::get, BlockBehaviour.Properties.copy(LOCKED_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_LIGHT_AEROTIC_STONE = registerBlock("boss_doorway_light_aerotic_stone", () -> new DoorwayBlock(AncientAetherEntities.ANCIENT_GUARDIAN::get, BlockBehaviour.Properties.copy(LOCKED_LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_CORRUPTED_LIGHT_AEROTIC_STONE = registerBlock("boss_doorway_corrupted_light_aerotic_stone", () -> new DoorwayBlock(AncientAetherEntities.ANCIENT_GUARDIAN::get, BlockBehaviour.Properties.copy(LOCKED_CORRUPTED_LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_AEROTIC_STONE = registerBlock("treasure_doorway_aerotic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_LIGHT_AEROTIC_STONE = registerBlock("treasure_doorway_light_aerotic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_CORRUPTED_LIGHT_AEROTIC_STONE = registerBlock("treasure_doorway_corrupted_light_aerotic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(CORRUPTED_LIGHT_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> CARVED_STONE_MOSAIC = registerBlock("carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> ANGELIC_STONE_MOSAIC = registerBlock("angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.ANGELIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> HELLFIRE_STONE_MOSAIC = registerBlock("hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HELLFIRE_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> AEROTIC_STONE_MOSAIC = registerBlock("aerotic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AncientAetherBlocks.AEROTIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> GALE_STONE_MOSAIC = registerBlock("gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_CARVED_STONE_MOSAIC = registerBlock("locked_carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_ANGELIC_STONE_MOSAIC = registerBlock("locked_angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_ANGELIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_HELLFIRE_STONE_MOSAIC = registerBlock("locked_hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_HELLFIRE_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_GALE_STONE_MOSAIC = registerBlock("locked_gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_AEROTIC_STONE_MOSAIC = registerBlock("locked_aerotic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_AEROTIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> DEACTIVATED_ANCIENT_OBELISK = registerBlock("unpowered_ancient_obelisk", () -> new UnpoweredObeliskBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).lightLevel(s -> 3).noLootTable().strength(-1.0F, 3600000.0F).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_OBELISK = registerBlock("ancient_obelisk", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(5f).lightLevel(s -> 12).requiresCorrectToolForDrops().noOcclusion()));

    //Plants
    public static final RegistryObject<Block> HIGHLAND_TULIP = registerBlock("highland_tulip", () -> new FlowerBlock(() -> MobEffects.GLOWING, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> EDELWEISS = registerBlock("edelweiss", () -> new FlowerBlock(() -> MobEffects.LUCK, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> SAKURA_BLOSSOMS = registerBlock("sakura_blossoms", () -> new FlowerBlock(() -> MobEffects.HEALTH_BOOST, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> MOONLIT_WATERLILY = registerBlock("moonlit_waterlily", () -> new WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).lightLevel(s -> 10).noOcclusion()));

    //Potted Plants
    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHLAND_TULIP = BLOCKS.register("potted_highland_tulip", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHLAND_TULIP, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_EDELWEISS = BLOCKS.register("potted_edelweiss", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EDELWEISS, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SAKURA_BLOSSOMS = BLOCKS.register("potted_sakura_blossoms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_BLOSSOMS, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHSPROOT_SAPLING = BLOCKS.register("potted_highsproot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHSPROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));

    //Lanterns
    public static final RegistryObject<Block> HOLYSTONE_LANTERN = registerBlock("holystone_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 15)));
    public static final RegistryObject<Block> SENTRY_LANTERN = registerBlock("sentry_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 12)));
    public static final RegistryObject<Block> ANGELIC_LANTERN = registerBlock("angelic_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 12)));
    public static final RegistryObject<Block> HELLFIRE_LANTERN = registerBlock("hellfire_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 12)));
    public static final RegistryObject<Block> GALE_LANTERN = registerBlock("gale_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 12)));
    public static final RegistryObject<Block> AEROTIC_LANTERN = registerBlock("aerotic_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops().lightLevel(s -> 12)));

    //Misc Blocks
    public static final RegistryObject<Block> CRACKED_SLIDER = registerBlock("cracked_slider", () -> new CrackedSliderBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> TRAPPED_SAKURA_BLOSSOMS = registerBlock("trapped_sakura_blossoms", () -> new TrappedFlowerBlock(AncientAetherEntities.ROOTHYRN::get, () -> AIR.defaultBlockState(), Block.Properties.copy(SAKURA_BLOSSOMS.get())));
    public static final RegistryObject<Block> AMBROSIUM_CAMPFIRE = registerBlock("ambrosium_campfire", () -> new AmbrosiumCampfireBlock(true, 1, Block.Properties.copy(Blocks.CAMPFIRE)));

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(AncientAetherBlocks.HIGHLAND_TULIP.getId(), AncientAetherBlocks.POTTED_HIGHLAND_TULIP);
        pot.addPlant(AncientAetherBlocks.EDELWEISS.getId(), AncientAetherBlocks.POTTED_EDELWEISS);
        pot.addPlant(AncientAetherBlocks.SAKURA_BLOSSOMS.getId(), AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS);
        pot.addPlant(AncientAetherBlocks.HIGHSPROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.SAKURA_SAPLING.getId(), AncientAetherBlocks.POTTED_SAKURA_SAPLING);
    }

    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHLAND_TULIP.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.EDELWEISS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_BLOSSOMS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SAPLING.get(), 60, 100);
    }

    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        AncientAetherItems.ITEMS.register(name, item.apply(register));
        return register;
    }
    @SuppressWarnings("unchecked")
    private static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends Block> block) {
        return (RegistryObject<B>) baseRegister(name, block, AncientAetherBlocks::registerBlockItem);
    }
    private static <B extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<B> blockRegistryObject) {
        return () -> {
            B block = Objects.requireNonNull(blockRegistryObject.get());
            if (block == MOONLIT_WATERLILY.get()) {
                return new PlaceOnWaterBlockItem(MOONLIT_WATERLILY.get(),new Item.Properties());
            }
            return new BlockItem(block, new Item.Properties());
        };
    }
    public static void registerWoodTypes() {
        WoodType.register(AncientAetherWoodTypes.HIGHSPROOT);
        WoodType.register(AncientAetherWoodTypes.SAKURA);
    }
    private static boolean never(BlockState p_test_1_, BlockGetter p_test_2_, BlockPos p_test_3_) {
        return false;
    }

    private static boolean ocelotOrParrot(BlockState p_235441_0_, BlockGetter p_235441_1_, BlockPos p_235441_2_, EntityType<?> p_235441_3_) {
        return p_235441_3_ == EntityType.OCELOT || p_235441_3_ == EntityType.PARROT;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
