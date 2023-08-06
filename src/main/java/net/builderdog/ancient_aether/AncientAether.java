package net.builderdog.ancient_aether;

import com.mojang.logging.LogUtils;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.particle.AncientAetherParticleTypes;
import net.builderdog.ancient_aether.client.renderer.RootlingRenderer;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.client.renderer.HighlandsBuffaloRenderer;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.item.AncientCreativeModeTabs;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
//import net.builderdog.ancient_aether.world.carver.AncientAetherCarvers;
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

        AncientAetherBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
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
        AncientAetherParticleTypes.PARTICLES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            this.registerComposting();
        });

        event.enqueueWork(() -> {
            Regions.register(new AncientAetherRegion(new ResourceLocation(MOD_ID, "ancient_aether"), 5));

            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MOD_ID, AncientAetherSurfaceData.makeRules());
        });
    }

    private void registerComposting() {
        this.addCompost(0.3F, AncientAetherBlocks.HIGHLANDS_PINE_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.HIGHLANDS_PINE_SAPLING.get());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        this.addCompost(0.65F,AncientAetherBlocks.SMALL_AETHER_CACTUS.get());
        this.addCompost(0.65F,AncientAetherBlocks.MOONLIT_TULIP.get());
        this.addCompost(0.65F,AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        this.addCompost(0.65F,AncientAetherBlocks.EDELWEISS.get());
        this.addCompost(0.65F,AncientAetherBlocks.MOONLIT_WATER_LILY.get());
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
