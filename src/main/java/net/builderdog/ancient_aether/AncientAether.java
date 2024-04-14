package net.builderdog.ancient_aether;

import com.aetherteam.aether.AetherConfig;
import net.builderdog.ancient_aether.advancement.AncientAetherAdvancementTriggers;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.dispenser.DispenseAncientAetherBoatBehaviour;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.gui.AncientAetherMenus;
import net.builderdog.ancient_aether.client.particle.AncientAetherParticleTypes;
import net.builderdog.ancient_aether.data.AncientAetherData;
import net.builderdog.ancient_aether.effect.AncientAetherEffects;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.biome.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biome.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.carver.AncientAetherCarvers;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacers;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructurePoolElements;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.builderdog.ancient_aether.world.treedecorator.AncientAetherTreeDecoratorTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(AncientAether.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAether {
    public static final String MODID = "ancient_aether";

    public AncientAether() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(AncientAetherData::dataSetup);

        DeferredRegister<?>[] registers = {

                AncientAetherBlocks.BLOCKS,
                AncientAetherItems.ITEMS,
                AncientAetherBlockEntityTypes.BLOCK_ENTITY_TYPES,
                AncientAetherEntityTypes.ENTITY_TYPES,
                AncientAetherMoaTypes.MOA_TYPES,
                AncientAetherEffects.EFFECTS,
                AncientAetherFeatures.FEATURES,
                AncientAetherFoliagePlacers.FOLIAGE_PLACERS,
                AncientAetherTreeDecoratorTypes.TREE_DECORATORS,
                AncientAetherCarvers.CARVERS,
                AncientAetherBiomeModifierSerializers.BIOME_MODIFIER_SERIALIZERS,
                AncientAetherStructureTypes.STRUCTURE_TYPES,
                AncientAetherStructurePoolElements.STRUCTURE_POOL_ELEMENT,
                AncientAetherSoundEvents.SOUNDS,
                AncientAetherParticleTypes.PARTICLES,
        };

        MinecraftForge.EVENT_BUS.register(this);

        for (DeferredRegister<?> register : registers) {
            register.register(modEventBus);
        }

        DistExecutor.unsafeRunForDist(() -> () -> {
            AncientAetherMenus.MENUS.register(modEventBus);
            return true;
        }, () -> () -> false);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AncientAetherConfig.SERVER_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientAetherConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, AncientAetherConfig.CLIENT_SPEC);

        AncientAetherBlocks.registerWoodTypes();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AncientAetherBlocks.registerFuels();
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            registerComposting();
            registerDispenserBehaviors();

            AncientAetherAdvancementTriggers.init();

            Regions.register(new AncientAetherRegion(new ResourceLocation(MODID, "ancient_aether"), AncientAetherConfig.COMMON.ancient_aether_region_weight.get()));
            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MODID, AncientAetherSurfaceData.makeRules());
        });
    }

    @SubscribeEvent
    public static void addPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_texture_tweaks");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_texture_tweaks", Component.translatable("pack.ancient_aether.texture_tweaks.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_programmer_art");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_programmer_art", Component.translatable("pack.ancient_aether.programmer_art.title"), false,
                    path -> new PathPackResources(path, resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (event.getPackType() == PackType.SERVER_DATA) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_worldgen_overrides");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_worldgen_overrides", Component.translatable("pack.ancient_aether.worldgen_overrides.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (ModList.get().isLoaded("aether_emissivity") && event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/aether_emissivity");
            var pack = Pack.readMetaAndCreate("builtin/aether_emissivity_compat", Component.translatable("pack.ancient_aether.aether_emissivity_compat.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (ModList.get().isLoaded("aether_genesis") && event.getPackType() == PackType.SERVER_DATA) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/aether_genesis");
            var pack = Pack.readMetaAndCreate("builtin/compat_packs/aether_genesis", Component.translatable("pack.ancient_aether.aether_genesis_compat.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (ModList.get().isLoaded("lost_aether_content") && event.getPackType() == PackType.SERVER_DATA) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/lost_content");
            var pack = Pack.readMetaAndCreate("builtin/compat_packs/lost_content", Component.translatable("pack.ancient_aether.lost_content_compat.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);

            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (ModList.get().isLoaded("aether_redux") && event.getPackType() == PackType.SERVER_DATA) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/aether_redux");
            var pack = Pack.readMetaAndCreate("builtin/compat_packs/aether_redux", Component.translatable("pack.ancient_aether.aether_redux_compat.title"), true,
                    path -> new PathPackResources(path, resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (ModList.get().isLoaded("deep_aether")) {
            if (event.getPackType() == PackType.SERVER_DATA) {
                var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/deep_aether");
                var pack = Pack.readMetaAndCreate("builtin/compat_packs/deep_aether", Component.translatable("pack.ancient_aether.deep_aether_compat.title"), true,
                        path -> new PathPackResources(path, resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);

                event.addRepositorySource(consumer -> consumer.accept(pack));
            }
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/compat_packs/deep_aether_assets");
                var pack = Pack.readMetaAndCreate("builtin/compat_packs/deep_aether_assets", Component.translatable("pack.ancient_aether.deep_aether_asset_compat.title"), true,
                        path -> new PathPackResources(path, resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
                event.addRepositorySource(consumer -> consumer.accept(pack));
            }
        }
    }

    @SubscribeEvent
    public void serverSetup(ServerAboutToStartEvent event) {
        if (AncientAetherConfig.SERVER.server_config_overrides.get()) {
            AetherConfig.SERVER.disable_eternal_day.set(true);
        }
    }

    private void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(AncientAetherItems.HIGHSPROOT_BOAT.get(), new DispenseAncientAetherBoatBehaviour());
        DispenserBlock.registerBehavior(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), new DispenseAncientAetherBoatBehaviour(true));
        DispenserBlock.registerBehavior(AncientAetherItems.SAKURA_BOAT.get(), new DispenseAncientAetherBoatBehaviour());
        DispenserBlock.registerBehavior(AncientAetherItems.SAKURA_CHEST_BOAT.get(), new DispenseAncientAetherBoatBehaviour(true));
    }

    private void registerComposting() {
        addCompost(0.3F, AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.SKYROOT_PINE_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.BLUE_SKYROOT_PINE_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SKYROOT_PINE_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SKY_GRASS.get());
        addCompost(0.5F, AncientAetherItems.GRAPES.get());
        addCompost(0.65F, AncientAetherBlocks.SUNSET_ROSE.get());
        addCompost(0.65F, AncientAetherBlocks.SKY_BLUES.get());
        addCompost(0.65F, AncientAetherBlocks.WYND_THISTLE.get());
        addCompost(0.65F, AncientAetherBlocks.ELEVATIA.get());
        addCompost(0.85F, AncientAetherItems.SLAMMROOT_FRUIT.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}