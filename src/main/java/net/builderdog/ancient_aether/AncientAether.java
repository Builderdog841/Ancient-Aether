package net.builderdog.ancient_aether;

import com.aetherteam.aether.AetherConfig;
import com.mojang.logging.LogUtils;
import com.aetherteam.cumulus.CumulusConfig;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.renderer.entity.AncientAetherEntityRenderers;
import net.builderdog.ancient_aether.datagen.generators.AncientAetherBlockStateData;
import net.builderdog.ancient_aether.datagen.generators.AncientAetherItemModelData;
import net.builderdog.ancient_aether.datagen.generators.AncientAetherRecipeData;
import net.builderdog.ancient_aether.datagen.providers.AncientAetherLootTableProvider;
import net.builderdog.ancient_aether.datagen.resources.AncientAetherWorldGenProvider;
import net.builderdog.ancient_aether.effects.AncientAetherEffects;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.gui.menu.AncientAetherMenus;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.particle.AncientAetherParticles;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatureRegistry;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacerTypes;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;
import teamrazor.aeroblender.AeroBlenderConfig;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

import static com.aetherteam.aether.Aether.DIRECTORY;

@Mod(AncientAether.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAether {
    public static final String MOD_ID = "ancient_aether";

    private static final Logger LOGGER = LogUtils.getLogger();

    public AncientAether() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::packSetup);
        modEventBus.addListener(this::dataSetup);

        DeferredRegister<?>[] registers = {

                AncientAetherItems.ITEMS,
                AncientAetherMoaTypes.MOA_TYPES,
                AncientAetherBlocks.BLOCKS,
                AncientAetherFoliagePlacerTypes.FOLIAGE_PLACERS,
                AncientAetherBlockEntityTypes.BLOCK_ENTITY_TYPES,
                AncientAetherStructureTypes.STRUCTURE_TYPES,
                AncientAetherEntities.ENTITY_TYPES,
                AncientAetherSoundEvents.SOUNDS,
                AncientAetherEffects.EFFECTS,
                AncientAetherBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS,
                AncientAetherParticles.PARTICLES,
                AncientAetherFeatureRegistry.FEATURES
                };

        MinecraftForge.EVENT_BUS.register(this);

        DIRECTORY.toFile().mkdirs();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientAetherConfig.COMMON_SPEC);

        AncientAetherBlocks.registerWoodTypes();

        for (DeferredRegister<?> register : registers) {
            register.register(modEventBus);
        }

        DistExecutor.unsafeRunForDist(() -> () -> {
            AncientAetherMenus.MENUS.register(modEventBus);
            return true;
        }, () -> () -> false);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
                AncientAetherEntityRenderers.registerCuriosRenderers();
                AetherConfig.COMMON.add_ruined_portal_automatically.set(true);
                AetherConfig.COMMON.add_temporary_freezing_automatically.set(true);
                AetherConfig.CLIENT.music_backup_min_delay.set(1);
                AetherConfig.CLIENT.music_backup_max_delay.set(2);
                AetherConfig.CLIENT.disable_music_manager.set(false);
                CumulusConfig.CLIENT.enable_menu_list_button.set(true);
                AeroBlenderConfig.COMMON.vanillaAetherRegionWeight.set(0);
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();
            registerComposting();
        });

        event.enqueueWork(() -> {
            Regions.register(new AncientAetherRegion(new ResourceLocation(MOD_ID, "ancient_aether"), AncientAetherConfig.COMMON.ancient_aether_biome_weight.get()));

            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MOD_ID, AncientAetherSurfaceData.makeRules());
        });
    }

    @SubscribeEvent
    public void serverSetup(ServerAboutToStartEvent event) {
        AetherConfig.SERVER.disable_eternal_day.set(true);
    }

 //   public void versionRefresh() {
  //      if (!(ReduxConfig.CLIENT.version_id.get()).equals("1.0") && ReduxConfig.CLIENT.reload_packs_after_update.get()) {
  //          Iterator var1 = Minecraft.getInstance().getResourcePackRepository().getAvailablePacks().iterator();
//
   //         while(var1.hasNext()) {
   //             Pack pack = (Pack)var1.next();
   //             if (pack.getPackSource() == ReduxPackSources.AUTO_APPLY_RESOURCE) {
   //                 Minecraft.getInstance().getResourcePackRepository().addPack(pack.getId());
    //            }
    //        }
//
     //       this.clientReload = true;
     //       LOGGER.info("Aether: Redux detected version change, reloading packs ");
     //       ReduxConfig.CLIENT.version_id.set("1.0");
     //   } else if (!(ReduxConfig.CLIENT.version_id.get()).equals("1.0") && !(Boolean)ReduxConfig.CLIENT.reload_packs_after_update.get()) {
    //        LOGGER.info("Aether: Redux Version ID changed after update but pack reload was disabled, ignoring");
    //        ReduxConfig.CLIENT.version_id.set("1.0");
    //    }
//
    //}

    public void packSetup(AddPackFindersEvent event) {
        setupProgrammerArtPack(event);
        setupOverridesPack(event);
        setupWorldgenOverridesDatapack(event);
        setupCompatDatapack(event, "ancient_aether_asset_overrides", "Ancient Aether Asset Overrides", "Some Tweaks to the Aether's Textures");

        if (ModList.get().isLoaded("aether_genesis")) {
            setupCompatDatapack(event, "aether_genesis_compat", "Aether Genesis Compatibility", "Better Compatibility with Aether Genesis");
        }
        if (ModList.get().isLoaded("lost_aether_content")) {
            setupCompatDatapack(event, "lost_content_compat", "Lost Content Compatibility", "Better Compatibility with Lost Content");
        }
        if (ModList.get().isLoaded("aether_redux")) {
            setupCompatDatapack(event, "aether_redux_compat", "Aether Redux Compatibility", "Better Compatibility with Aether Redux");
        }
    }

    private void setupProgrammerArtPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource("packs/ancient_aether_programmer_art");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.literal("Changes the textures to the classic art style"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/ancient_aether_programmer_art",
                        Component.literal("Ancient Aether Programmer Art"),
                        false,
                        (string) -> pack,
                        new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        create(decorateWithSource("built-in"), false)));
            });
        }
    }

    private void setupOverridesPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource("packs/ancient_aether_tweaks");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.literal("Some tweaks to the Aether's Textures"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/ancient_aether_tweaks",
                        Component.literal("Ancient Aether Tweaks"),
                        false,
                        (string) -> pack,
                        new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        create(decorateWithSource("built-in"), true)));
            });
        }
    }

    private void setupCompatDatapack(AddPackFindersEvent event, String path, String displayName, String desc) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource("packs/" + path);
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable(desc), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
            event.addRepositorySource((packConsumer) -> packConsumer.accept(Pack.create("builtin/" + path, Component.literal(displayName), false, (string) -> pack, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.CLIENT_RESOURCES), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.SERVER_DATA, Pack.Position.TOP, false, PackSource.BUILT_IN)));
        }
    }

    private void setupWorldgenOverridesDatapack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById(AncientAether.MOD_ID).getFile().findResource("packs/ancient_aether_worldgen_overrides");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById(AncientAether.MOD_ID).getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable("pack.ancient_aether.ancient_aether_worldgen_overrides.description"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource((source) ->
                    source.accept(Pack.create(
                            "packs/ancient_aether_worldgen_overrides",
                            Component.translatable("pack.ancient_aether.ancient_aether_worldgen_overrides.title"),
                            false,
                            (string) -> pack,
                            new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()),
                            PackType.SERVER_DATA,
                            Pack.Position.TOP,
                            false,
                            create(decorateWithSource("built-in"), AncientAetherConfig.COMMON.worldgen_overrides.get()))
                    )
            );
        }
    }

    static PackSource create(final UnaryOperator<Component> decorator, final boolean shouldAddAutomatically) {
        return new PackSource() {
            public Component decorate(Component component) {
                return decorator.apply(component);
            }

            public boolean shouldAddAutomatically() {
                return shouldAddAutomatically;
            }
        };
    }

    private static UnaryOperator<Component> decorateWithSource(String translationKey) {
        Component component = Component.translatable(translationKey);
        return (name) -> Component.translatable("pack.nameAndSource", name, component).withStyle(ChatFormatting.GRAY);
    }

    public void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true, AncientAetherLootTableProvider.create(packOutput));
        generator.addProvider(true, new AncientAetherBlockStateData(packOutput, fileHelper));
        generator.addProvider(true, new AncientAetherRecipeData(packOutput));
        generator.addProvider(true, new AncientAetherItemModelData(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new AncientAetherWorldGenProvider(packOutput, lookupProvider));
    }

    private void registerComposting() {
        addCompost(0.3F, AncientAetherBlocks.SKYROOT_PINE_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.DIVINE_SKYROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SKYROOT_PINE_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.DIVINE_SKYROOT_SAPLING.get());
        addCompost(0.5F, AncientAetherItems.GRAPES.get());
        addCompost(0.65F, AncientAetherBlocks.SKY_BLUES.get());
        addCompost(0.65F, AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        addCompost(0.65F, AncientAetherBlocks.WYND_THISTLE.get());
        addCompost(0.65F, AncientAetherBlocks.HIGHLAND_VIOLA.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
    }
}
