package net.builderdog.aether_crystallium;

import com.mojang.logging.LogUtils;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.item.ModCreativeModeTabs;
import net.builderdog.aether_crystallium.item.ModItems;
import net.builderdog.aether_crystallium.worldgen.foliageplacer.ModFoliagePlacerTypes;
import net.minecraft.world.item.CreativeModeTabs;
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

import static net.builderdog.aether_crystallium.worldgen.foliageplacer.ModFoliagePlacerTypes.*;

@Mod(AetherCrystallium.MOD_ID)
public class AetherCrystallium {
    public static final String MOD_ID = "aether_crystallium";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AetherCrystallium() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative) ;

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.AETHER_CRYSTALLIUM_TAB)  {
            event.accept(ModBlocks.FROSTPINE_LOG);
            event.accept(ModBlocks.FROSTPINE_WOOD);
            event.accept(ModBlocks.STRIPPED_FROSTPINE_LOG);
            event.accept(ModBlocks.STRIPPED_FROSTPINE_WOOD);
            event.accept(ModBlocks.FROSTPINE_PLANKS);
            event.accept(ModBlocks.FROSTPINE_STAIRS);
            event.accept(ModBlocks.FROSTPINE_SLAB);
            event.accept(ModBlocks.FROSTPINE_FENCE);
            event.accept(ModBlocks.FROSTPINE_FENCE_GATE);
            event.accept(ModBlocks.FROSTPINE_DOOR);
            event.accept(ModBlocks.FROSTPINE_TRAPDOOR);
            event.accept(ModBlocks.FROSTPINE_PRESSURE_PLATE);
            event.accept(ModBlocks.FROSTPINE_BUTTON);
            event.accept(ModBlocks.FROSTPINE_LEAVES);
            event.accept(ModBlocks.FROSTPINE_SAPLING);
            event.accept(ModBlocks.AETHER_CACTUS);
            event.accept(ModBlocks.PURPLE_AETHER_CACTUS_FLOWER);
            event.accept(ModBlocks.CRYSTAL_GOLD_ORE);
            event.accept(ModBlocks.RAW_CRYSTAL_GOLD_BLOCK);
            event.accept(ModBlocks.CRYSTAL_GOLD_BLOCK);
            event.accept(ModBlocks.ENCHANTED_SENTRY_STONE);
            event.accept(ModBlocks.BLIGHTED_SENTRY_STONE);
            event.accept(ModBlocks.QUICKSOIL_BRICKS);
            event.accept(ModBlocks.QUICKSOIL_BRICK_STAIRS);
            event.accept(ModBlocks.QUICKSOIL_BRICK_SLAB);
            event.accept(ModItems.CRYSTAL_GOLD_INGOT);
            event.accept(ModItems.RAW_CRYSTAL_GOLD);
            event.accept(ModItems.CRYSTAL_GOLD_NUGGET);
            event.accept(ModItems.AECHOR_PETAL_ICE_CREAM_BUCKET);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
