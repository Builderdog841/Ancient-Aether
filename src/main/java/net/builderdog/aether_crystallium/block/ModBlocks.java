package net.builderdog.aether_crystallium.block;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.item.ModItems;
import net.builderdog.aether_crystallium.worldgen.tree.HighlandsPineTreeGrower;
import net.builderdog.aether_crystallium.worldgen.tree.SunrootTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.Luminance;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AetherCrystallium.MOD_ID);
    public static final RegistryObject<Block> CACTUS_FLOWER =  registerBlock("cactus_flower",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT)
                    .instabreak().noOcclusion()));
    public static final RegistryObject<Block> AETHER_QUARTZ_ORE =  registerBlock("aether_quartz_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_SLIDER =  registerBlock("cracked_slider",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()
                    .lightLevel((state) -> state.getValue( RedstoneLampBlock.LIT ) == true ? 15 : 0)));
    public static final RegistryObject<Block> QUICKSTONE =  registerBlock("quickstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ENCHANTED_SENTRY_STONE =  registerBlock("enchanted_sentry_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(0.5f, 6f).lightLevel(s -> 11).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLIGHTED_SENTRY_STONE =  registerBlock("blighted_sentry_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(0.5f, 6f).lightLevel(s -> 11).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AETHER_CACTUS =  registerBlock("aether_cactus",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL)
                    .strength(0.5f, 6f)));
    public static final RegistryObject<StandingSignBlock> HIGHLANDS_PINE_SIGN = registerBlock("highlands_pine_sign",
            () -> new HighlandsPineSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodTypes.HIGHLANDS_PINE));
    public static final RegistryObject<WallSignBlock> HIGHLANDS_PINE_WALL_SIGN = registerBlock("highlands_pine_wall_sign",
            () -> new HighlandsPineWallSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(HIGHLANDS_PINE_SIGN), ModWoodTypes.HIGHLANDS_PINE));
    public static final RegistryObject<Block> MOONLIT_TULIP = registerBlock("moonlit_tulip",
            () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> SMALL_AETHER_CACTUS = registerBlock("small_aether_cactus",
            () -> new DeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)) {
                @Override
                public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
                    return groundState.is(AetherBlocks.QUICKSOIL.get());
                }
            });
    public static final RegistryObject<Block> QUICKSOIL_BRICKS =  registerBlock("quicksoil_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5F).friction(1.1F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HIGHLANDS_PINE_LOG =  registerBlock("highlands_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));
    public static final RegistryObject<Block> HIGHLANDS_PINE_WOOD =  registerBlock("highlands_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));
    public static final RegistryObject<Block> STRIPPED_HIGHLANDS_PINE_LOG =  registerBlock("stripped_highlands_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));
    public static final RegistryObject<Block> STRIPPED_HIGHLANDS_PINE_WOOD =  registerBlock("stripped_highlands_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));
    public static final RegistryObject<Block> HIGHLANDS_PINE_PLANKS =  registerBlock("highlands_pine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2f)));
    public static final RegistryObject<Block> HIGHLANDS_PINE_STAIRS =  registerBlock("highlands_pine_stairs",
            () -> new StairBlock(() -> HIGHLANDS_PINE_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(ModBlocks.HIGHLANDS_PINE_PLANKS.get()))));
    public static final RegistryObject<Block> HIGHLANDS_PINE_SLAB = registerBlock("highlands_pine_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.HIGHLANDS_PINE_PLANKS.get())
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<FenceBlock> HIGHLANDS_PINE_FENCE = registerBlock("highlands_pine_fence",
            () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> HIGHLANDS_PINE_FENCE_GATE = registerBlock("highlands_pine_fence_gate",
            () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.HIGHLANDS_PINE));
    public static final RegistryObject<WallBlock> HIGHLANDS_PINE_LOG_WALL = registerBlock("highlands_pine_log_wall",
            () -> new WallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> HIGHLANDS_PINE_WOOD_WALL = registerBlock("highlands_pine_wood_wall",
            () -> new WallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHLANDS_PINE_LOG_WALL = registerBlock("stripped_highlands_pine_log_wall",
            () -> new WallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHLANDS_PINE_WOOD_WALL = registerBlock("stripped_highlands_pine_wood_wall",
            () -> new WallBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> HIGHLANDS_PINE_LEAVES =  registerBlock("highlands_pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));

    public static final RegistryObject<Block> SUNROOT_LEAVES =  registerBlock("sunroot_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));
    public static final RegistryObject<Block> HIGHLANDS_PINE_SAPLING =  registerBlock("highlands_pine_sapling",
            () -> new SaplingBlock(new HighlandsPineTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SUNROOT_SAPLING =  registerBlock("sunroot_sapling",
            () -> new SaplingBlock(new SunrootTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<FlowerPotBlock> POTTED_MOONLIT_TULIP = BLOCKS.register("potted_moonlit_tulip",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MOONLIT_TULIP, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SMALL_AETHER_CACTUS = BLOCKS.register("potted_small_aether_cactus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SMALL_AETHER_CACTUS, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHLANDS_PINE_SAPLING = BLOCKS.register("potted_highlands_pine_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHLANDS_PINE_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));

    public static final RegistryObject<FlowerPotBlock> POTTED_SUNROOT_SAPLING = BLOCKS.register("potted_sunroot_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<Block> QUICKSOIL_BRICK_STAIRS =  registerBlock("quicksoil_brick_stairs",
            () -> new StairBlock(() -> QUICKSOIL_BRICKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get()))));
    public static final RegistryObject<Block> QUICKSOIL_BRICK_SLAB = registerBlock("quicksoil_brick_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get()).strength(2.0F, 3.0F)));
    public static final RegistryObject<DoorBlock> HIGHLANDS_PINE_DOOR = registerBlock("highlands_pine_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), ModWoodTypes.HIGHLANDS_PINE_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> HIGHLANDS_PINE_TRAPDOOR = registerBlock("highlands_pine_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), ModWoodTypes.HIGHLANDS_PINE_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> HIGHLANDS_PINE_BUTTON = registerBlock("highlands_pine_button", () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), ModWoodTypes.HIGHLANDS_PINE_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> HIGHLANDS_PINE_PRESSURE_PLATE = registerBlock("highlands_pine_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModWoodTypes.HIGHLANDS_PINE_BLOCK_SET));
    public static final RegistryObject<WallBlock> QUICKSOIL_BRICK_WALL = registerBlock("quicksoil_brick_wall", () -> new WallBlock(Block.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get())));

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(ModBlocks.MOONLIT_TULIP.getId(), ModBlocks.POTTED_MOONLIT_TULIP);
        pot.addPlant(ModBlocks.SMALL_AETHER_CACTUS.getId(), ModBlocks.POTTED_SMALL_AETHER_CACTUS);
        pot.addPlant(ModBlocks.HIGHLANDS_PINE_SAPLING.getId(), ModBlocks.POTTED_HIGHLANDS_PINE_SAPLING);
        pot.addPlant(ModBlocks.SUNROOT_SAPLING.getId(), ModBlocks.POTTED_SUNROOT_SAPLING);
    }
    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(ModBlocks.SUNROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(ModBlocks.MOONLIT_TULIP.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(ModBlocks.SMALL_AETHER_CACTUS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(ModBlocks.HIGHLANDS_PINE_SLAB.get(), 5, 20);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item>  registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    private static boolean never(BlockState p_test_1_, BlockGetter p_test_2_, BlockPos p_test_3_) {
        return false;
    }

    private static boolean always(BlockState p_test_1_, BlockGetter p_test_2_, BlockPos p_test_3_) {
        return true;
    }

    private static <A> boolean never(BlockState p_test_1_, BlockGetter p_test_2_, BlockPos p_test_3_, A p_test_4_) {
        return false;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
