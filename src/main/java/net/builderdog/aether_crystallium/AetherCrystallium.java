package net.builderdog.aether_crystallium;

import com.aetherteam.aether.item.AetherItems;
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

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModFoliagePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative) ;

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.AETHER_CRYSTALLIUM_TAB)  {
            event.accept(ModBlocks.HIGHLANDS_PINE_LOG);
            event.accept(ModBlocks.HIGHLANDS_PINE_WOOD);
            event.accept(ModBlocks.STRIPPED_HIGHLANDS_PINE_LOG);
            event.accept(ModBlocks.STRIPPED_HIGHLANDS_PINE_WOOD);
            event.accept(ModBlocks.HIGHLANDS_PINE_PLANKS);
            event.accept(ModBlocks.HIGHLANDS_PINE_STAIRS);
            event.accept(ModBlocks.HIGHLANDS_PINE_SLAB);
            event.accept(ModBlocks.HIGHLANDS_PINE_FENCE);
            event.accept(ModBlocks.HIGHLANDS_PINE_FENCE_GATE);
            event.accept(ModBlocks.HIGHLANDS_PINE_DOOR);
            event.accept(ModBlocks.HIGHLANDS_PINE_TRAPDOOR);
            event.accept(ModBlocks.HIGHLANDS_PINE_PRESSURE_PLATE);
            event.accept(ModBlocks.HIGHLANDS_PINE_BUTTON);
            event.accept(ModBlocks.HIGHLANDS_PINE_LEAVES);
            event.accept(ModBlocks.HIGHLANDS_PINE_SAPLING);
            event.accept(ModBlocks.AETHER_CACTUS);
            event.accept(ModBlocks.SMALL_AETHER_CACTUS);
            event.accept(ModBlocks.CACTUS_FLOWER);
            event.accept(ModBlocks.MOONLIT_TULIP);
            event.accept(ModBlocks.AETHER_QUARTZ_ORE);
            event.accept(ModBlocks.ENCHANTED_SENTRY_STONE);
            event.accept(ModBlocks.BLIGHTED_SENTRY_STONE);
            event.accept(ModBlocks.QUICKSTONE);
            event.accept(ModBlocks.QUICKSOIL_BRICKS);
            event.accept(ModBlocks.QUICKSOIL_BRICK_STAIRS);
            event.accept(ModBlocks.QUICKSOIL_BRICK_SLAB);
            event.accept(ModBlocks.QUICKSOIL_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_SLIDER);
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
