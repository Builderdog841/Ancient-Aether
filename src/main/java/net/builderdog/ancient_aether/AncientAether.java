package net.builderdog.ancient_aether;

import com.mojang.logging.LogUtils;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.renderer.AncientGuardianRenderer;
import net.builderdog.ancient_aether.client.renderer.RoothyrnRenderer;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.client.renderer.HighlandBuffaloRenderer;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacerTypes;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
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
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.nio.file.Path;

import static com.aetherteam.aether.Aether.DIRECTORY;

@Mod(AncientAether.MOD_ID)
public class AncientAether {
    public static final String MOD_ID = "ancient_aether";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AncientAether() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AncientAetherBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        AncientAetherItems.ITEMS.register(modEventBus);
        AncientAetherMoaTypes.MOA_TYPES.register(modEventBus);
        AncientAetherBlocks.BLOCKS.register(modEventBus);
        AncientAetherFoliagePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);
        AncientAetherBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        AncientAetherStructureTypes.STRUCTURE_TYPES.register(modEventBus);
        AncientAetherBlocks.registerWoodTypes();
        AncientAetherEntities.ENTITY_TYPES.register(modEventBus);
        AncientAetherSoundEvents.SOUNDS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::packSetup);

        MinecraftForge.EVENT_BUS.register(this);

        DIRECTORY.toFile().mkdirs();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientAetherConfig.COMMON_SPEC);
    }
    private void commonSetup(
            final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            this.registerComposting();
        });

        event.enqueueWork(() -> {
            Regions.register(new AncientAetherRegion(new ResourceLocation(MOD_ID, "ancient_aether"), AncientAetherConfig.COMMON.ancient_aether_biome_weight.get()));

            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MOD_ID, AncientAetherSurfaceData.makeRules());
        });
    }
    public void packSetup(AddPackFindersEvent event) {
        this.setupOptionalPack(event, "ancient_aether_programmer_art", "Programmer Art", "Changes the textures to the classic art style");
        this.setupDatapack(event, "ancient_aether_water_color", "Watercolor", "Changes the Watercolor of the Aether", PackSource.BUILT_IN);
        this.setupDatapack(event, "ancient_aether_new_worldgen", "New World Generation", "Adds larger Islands, Mountains and a lot more", PackSource.BUILT_IN);
        this.setupDatapack(event, "ancient_aether_default_biome_improvements", "Default Biome Improvements", "Adds more flowers and tree variation to the Default Aether Biomes", PackSource.BUILT_IN);

        if (ModList.get().isLoaded("aether_genesis")) {
            this.setupDatapack(event, "aether_genesis_compat", "Aether Genesis Compatibility", "Makes Log and Wood Walls from Ancient Aether craftable", PackSource.BUILT_IN);
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
        this.addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        this.addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        this.addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        this.addCompost(0.65F,AncientAetherBlocks.HIGHLAND_TULIP.get());
        this.addCompost(0.65F,AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        this.addCompost(0.65F,AncientAetherBlocks.EDELWEISS.get());
        this.addCompost(0.65F,AncientAetherBlocks.MOONLIT_WATERLILY.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(AncientAetherEntities.HIGHLAND_BUFFALO.get(), HighlandBuffaloRenderer::new);
            EntityRenderers.register(AncientAetherEntities.ROOTHYRN.get(), RoothyrnRenderer::new);
            EntityRenderers.register(AncientAetherEntities.ANCIENT_GUARDIAN.get(), AncientGuardianRenderer::new);
        }
    }
}
