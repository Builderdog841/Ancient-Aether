package net.builderdog.ancient_aether;

import com.mojang.logging.LogUtils;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.renderer.RootlingRenderer;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.client.renderer.HighlandsBuffaloRenderer;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.item.AncientCreativeModeTabs;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.features.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacerTypes;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.builderdog.ancient_aether.world.structurepiece.AncientAetherStructurePieceTypes;
import net.builderdog.ancient_aether.world.tree_decorator.AncientAetherTreeDecoratorTypes;
import net.builderdog.ancient_aether.world.trunkplacer.AncientAetherTrunkPlacerTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(AncientAether.MOD_ID)
public class AncientAether {
    public static final String MOD_ID = "ancient_aether";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AncientAether() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AncientAetherItems.ITEMS.register(modEventBus);
        AncientAetherBlocks.BLOCKS.register(modEventBus);
        AncientAetherFoliagePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);
        AncientAetherTrunkPlacerTypes.TRUNK_PLACERS.register(modEventBus);
        AncientAetherBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        AncientAetherFeatures.FEATURES.register(modEventBus);
        AncientAetherStructureTypes.STRUCTURE_TYPES.register(modEventBus);
        AncientAetherStructurePieceTypes.STRUCTURE_PIECE_TYPES.register(modEventBus);
        AncientAetherTreeDecoratorTypes.TREE_DECORATORS.register(modEventBus);
        AncientAetherBlocks.registerWoodTypes();
        AncientAetherEntities.ENTITY_TYPES.register(modEventBus);
        AncientAetherSoundEvents.SOUNDS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative) ;
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            this.registerComposting();
        });

        event.enqueueWork(() -> {
            Regions.register(new AncientAetherRegion(new ResourceLocation(MOD_ID, "ancient_aether"), 4));

            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MOD_ID, AncientAetherSurfaceData.makeRules());
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == AncientCreativeModeTabs.ANCIENT_AETHER_TAB)  {
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_LOG);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_LOG_WALL);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_WOOD);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_WOOD_WALL);
            event.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG);
            event.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG_WALL);
            event.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD);
            event.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD_WALL);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_PLANKS);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_STAIRS);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_SLAB);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_FENCE);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_FENCE_GATE);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_DOOR);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_PRESSURE_PLATE);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_BUTTON);
            event.accept(AncientAetherItems.HIGHLANDS_PINE_SIGN);
            event.accept(AncientAetherItems.HIGHLANDS_PINE_BOAT);
            event.accept(AncientAetherItems.HIGHLANDS_PINE_CHEST_BOAT);
            event.accept(AncientAetherBlocks.SAKURA_LOG);
            event.accept(AncientAetherBlocks.SAKURA_LOG_WALL);
            event.accept(AncientAetherBlocks.SAKURA_WOOD);
            event.accept(AncientAetherBlocks.SAKURA_WOOD_WALL);
            event.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG);
            event.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL);
            event.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD);
            event.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL);
            event.accept(AncientAetherBlocks.SAKURA_PLANKS);
            event.accept(AncientAetherBlocks.SAKURA_STAIRS);
            event.accept(AncientAetherBlocks.SAKURA_SLAB);
            event.accept(AncientAetherBlocks.SAKURA_FENCE);
            event.accept(AncientAetherBlocks.SAKURA_FENCE_GATE);
            event.accept(AncientAetherBlocks.SAKURA_DOOR);
            event.accept(AncientAetherBlocks.SAKURA_TRAPDOOR);
            event.accept(AncientAetherBlocks.SAKURA_PRESSURE_PLATE);
            event.accept(AncientAetherBlocks.SAKURA_BUTTON);
            event.accept(AncientAetherItems.SAKURA_SIGN);
            event.accept(AncientAetherItems.SAKURA_BOAT);
            event.accept(AncientAetherItems.SAKURA_CHEST_BOAT);
            event.accept(AncientAetherBlocks.AETHER_CACTUS);
            event.accept(AncientAetherBlocks.STRIPPED_AETHER_CACTUS);
            event.accept(AncientAetherBlocks.CACTUS_FLOWER);
            event.accept(AncientAetherBlocks.GOLDEN_CACTUS_FLOWER);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_LEAVES);
            event.accept(AncientAetherBlocks.SAKURA_LEAVES);
            event.accept(AncientAetherBlocks.HIGHLANDS_PINE_SAPLING);
            event.accept(AncientAetherBlocks.SAKURA_SAPLING);
            event.accept(AncientAetherBlocks.SMALL_AETHER_CACTUS);
            event.accept(AncientAetherBlocks.EDELWEISS);
            event.accept(AncientAetherBlocks.MOONLIT_TULIP);
            event.accept(AncientAetherBlocks.SAKURA_BLOSSOMS);
            event.accept(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS);
            event.accept(AncientAetherBlocks.AETHER_QUARTZ_ORE);
            event.accept(AncientAetherBlocks.QUICKSTONE);
            event.accept(AncientAetherBlocks.QUICKSOIL_BRICKS);
            event.accept(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS);
            event.accept(AncientAetherBlocks.QUICKSOIL_BRICK_SLAB);
            event.accept(AncientAetherBlocks.QUICKSOIL_BRICK_WALL);
            event.accept(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC);
            event.accept(AncientAetherBlocks.CARVED_STONE_MOSAIC);
            event.accept(AncientAetherBlocks.ANGELIC_STONE_MOSAIC);
            event.accept(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC);
            event.accept(AncientAetherBlocks.GALE_STONE_MOSAIC);
            event.accept(AncientAetherBlocks.HOLYSTONE_LANTERN);
            event.accept(AncientAetherBlocks.SENTRY_LANTERN);
            event.accept(AncientAetherBlocks.ANGELIC_LANTERN);
            event.accept(AncientAetherBlocks.HELLFIRE_LANTERN);
            event.accept(AncientAetherBlocks.GALE_LANTERN);
            event.accept(AncientAetherBlocks.ENCHANTED_SENTRY_STONE);
            event.accept(AncientAetherBlocks.BLIGHTED_SENTRY_STONE);
            event.accept(AncientAetherBlocks.BROKEN_ENCHANTED_OBELISK);
            event.accept(AncientAetherBlocks.BROKEN_BLIGHTED_OBELISK);
            event.accept(AncientAetherBlocks.ENCHANTED_OBELISK);
            event.accept(AncientAetherBlocks.BLIGHTED_OBELISK);
            event.accept(AncientAetherBlocks.CRACKED_SLIDER);
            //event.accept(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC);
            //event.accept(AncientAetherBlocks.LOCKED_ENCHANTED_SENTRY_STONE);
            //event.accept(AncientAetherBlocks.LOCKED_BLIGHTED_SENTRY_STONE);
            event.accept(AncientAetherItems.ENCHANTED_SENTRY_RUNE);
            event.accept(AncientAetherItems.BLIGHTED_SENTRY_RUNE);
            event.accept(AncientAetherItems.CACTUS_FLOWER_PETAL);
            event.accept(AncientAetherItems.RAW_BUFFALO_RIBS);
            event.accept(AncientAetherItems.COOKED_BUFFALO_RIBS);
            event.accept(AncientAetherItems.BUFFALO_RIB);
            event.accept(AncientAetherItems.CACTUS_FLOWER_ICE_CREAM_BUCKET);
            event.accept(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET);
            event.accept(AncientAetherItems.HIGHLANDS_BUFFALO_SPAWN_EGG);
            event.accept(AncientAetherItems.ROOTLING_SPAWN_EGG);
            event.accept(AncientAetherItems.VELOX_ZEPHYR_SPAWN_EGG);
        }
    }

    private void registerComposting() {
        this.addCompost(0.3F, AncientAetherBlocks.HIGHLANDS_PINE_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.HIGHLANDS_PINE_SAPLING.get());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        this.addCompost(0.65F,AncientAetherBlocks.SMALL_AETHER_CACTUS.get());
        this.addCompost(0.65F,AncientAetherBlocks.MOONLIT_TULIP.get());
        this.addCompost(0.65F,AncientAetherBlocks.EDELWEISS.get());
        this.addCompost(0.5F, AncientAetherBlocks.AETHER_CACTUS.get());
        this.addCompost(0.5F, AncientAetherBlocks.STRIPPED_AETHER_CACTUS.get());
        this.addCompost(0.85F,AncientAetherBlocks.CACTUS_FLOWER.get());
        this.addCompost(1.0F,AncientAetherBlocks.GOLDEN_CACTUS_FLOWER.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(AncientAetherEntities.HIGHLANDS_BUFFALO.get(), HighlandsBuffaloRenderer::new);
            EntityRenderers.register(AncientAetherEntities.ROOTLING.get(), RootlingRenderer::new);
        }
    }
}
