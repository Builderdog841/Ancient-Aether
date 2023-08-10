package net.builderdog.ancient_aether;

import com.aetherteam.aether.AetherConfig;
import com.mojang.logging.LogUtils;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.particle.AncientAetherParticleTypes;
import net.builderdog.ancient_aether.client.renderer.RootlingRenderer;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.client.renderer.HighlandsBuffaloRenderer;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.features.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacerTypes;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.builderdog.ancient_aether.world.structurepiece.AncientAetherStructurePieceTypes;
import net.builderdog.ancient_aether.world.tree_decorator.AncientAetherTreeDecoratorTypes;
import net.builderdog.ancient_aether.world.trunkplacer.AncientAetherTrunkPlacerTypes;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.nio.file.Path;

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
        //modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::packSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            this.registerComposting();
        });

        event.enqueueWork(() -> {
            Regions.register(new AncientAetherRegion(new ResourceLocation(MOD_ID, "ancient_aether"), 50));

            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MOD_ID, AncientAetherSurfaceData.makeRules());
        });
    }

   // private void clientSetup(FMLClientSetupEvent event) {
      //  event.enqueueWork(() -> {
       //     AeroblenderConfig.CONFIG.getSubConfig(“generator_settings”).
     //   });
    //}
    public void packSetup(AddPackFindersEvent event) {
        this.setupOptionalPack(event, "ancient_aether_programmer_art", "Programmer Art", "Changes the textures to the classic art style");
        this.setupDatapack(event, "ancient_aether_water_color", "Watercolor", "Changes the Watercolor of the Aether", PackSource.BUILT_IN);
        this.setupDatapack(event, "ancient_aether_lakes", "Lakes", "Adds cool new lakes to the Aether", PackSource.BUILT_IN);
        if (aetherGenesisCompat()) {
            this.setupMandatoryDataPack(event, "aether_genesis_compatibility", "Aether Genesis Compatibility", "Needed for Compatibility with Aether Genesis");
        }
    }

    private void setupOptionalPack(AddPackFindersEvent event, String path, String displayName, String desc) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource(new String[]{"packs/" + path});
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable(desc), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/" + path, Component.literal("Ancient Aether: " + displayName), false, (string) -> {
                    return pack;
                }, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.CLIENT_RESOURCES, Pack.Position.TOP, false, PackSource.BUILT_IN));
            });
        }
    }

    private void setupMandatoryDataPack(AddPackFindersEvent event, String path, String displayName, String desc) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource(new String[]{"packs/" + path});
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable(desc), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/" + path, Component.literal("Ancient Aether: " + displayName), true, (string) -> {
                    return pack;
                }, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.SERVER_DATA, Pack.Position.TOP, false, PackSource.BUILT_IN));
            });
        }

    }

    private void setupBuiltinDatapack(AddPackFindersEvent event, String path, String displayName, String desc) {
        this.setupDatapack(event, path, displayName, desc, PackSource.BUILT_IN);
    }

    private void setupFeatureDatapack(AddPackFindersEvent event, String path, String displayName, String desc) {
        this.setupDatapack(event, path, displayName, desc, PackSource.FEATURE);
    }

    private void setupDatapack(AddPackFindersEvent event, String path, String displayName, String desc, PackSource source) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource(new String[]{"packs/" + path});
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable(desc), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/" + path, Component.literal("Ancient Aether: " + displayName), false, (string) -> {
                    return pack;
                }, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.SERVER_DATA, Pack.Position.TOP, false, source));
            });
        }

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
        this.addCompost(0.65F,AncientAetherBlocks.MOONLIT_WATERLILY.get());
        this.addCompost(0.5F, AncientAetherBlocks.AETHER_CACTUS.get());
        this.addCompost(0.5F, AncientAetherBlocks.STRIPPED_AETHER_CACTUS.get());
        this.addCompost(0.85F,AncientAetherBlocks.CACTUS_FLOWER.get());
        this.addCompost(1.0F,AncientAetherBlocks.GOLDEN_CACTUS_FLOWER.get());
    }

    public static boolean deepAetherCompat() {
        return ModList.get().isLoaded("deep_aether");
    }

    public static boolean lostAetherCompat() {
        return ModList.get().isLoaded("lost_aether_content");
    }

    public static boolean aetherGenesisCompat() {
        return ModList.get().isLoaded("aether_genesis");
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
