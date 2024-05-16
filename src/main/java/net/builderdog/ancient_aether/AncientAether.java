package net.builderdog.ancient_aether;

import com.aetherteam.aether.AetherConfig;
import net.builderdog.ancient_aether.advancement.AncientAetherTriggers;
import net.builderdog.ancient_aether.attachments.AncientAetherDataAttachments;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.block.dispenser.DispenseAncientAetherBoatBehavior;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherClient;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.client.particle.AncientAetherParticleTypes;
import net.builderdog.ancient_aether.data.AncientAetherData;
import net.builderdog.ancient_aether.effect.AncientAetherEffects;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.event.listeners.*;
import net.builderdog.ancient_aether.event.listeners.ability.ArmorAbilityListener;
import net.builderdog.ancient_aether.event.listeners.ability.ToolAbilityListener;
import net.builderdog.ancient_aether.event.listeners.ability.WeaponAbilityListener;
import net.builderdog.ancient_aether.item.AncientAetherCreativeModeTabs;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.biome.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biome.AncientAetherSurfaceRules;
import net.builderdog.ancient_aether.world.feature.AncientAetherFeatures;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureProcessors;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.builderdog.ancient_aether.world.tree.AncientAetherFoliagePlacers;
import net.builderdog.ancient_aether.world.tree.AncientAetherTreeDecorators;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(AncientAether.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAether {
    public static final String MODID = "ancient_aether";

    public AncientAether(IEventBus bus, Dist dist) {
        bus.addListener(AncientAetherData::dataSetup);
        bus.addListener(this::serverSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::addPacks);

        DeferredRegister<?>[] registers = {
                AncientAetherBlocks.BLOCKS,
                AncientAetherItems.ITEMS,
                AncientAetherBlockEntityTypes.BLOCK_ENTITY_TYPES,
                AncientAetherEntityTypes.ENTITY_TYPES,
                AncientAetherEffects.EFFECTS,
                AncientAetherFeatures.FEATURES,
                AncientAetherFoliagePlacers.FOLIAGE_PLACERS,
                AncientAetherTreeDecorators.TREE_DECORATORS,
                AncientAetherStructureTypes.STRUCTURE_TYPES,
                AncientAetherStructureProcessors.STRUCTURE_PROCESSOR_TYPES,
                AncientAetherTriggers.TRIGGERS,
                AncientAetherSoundEvents.SOUNDS,
                AncientAetherParticleTypes.PARTICLES,
                AncientAetherDataAttachments.ATTACHMENTS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(bus);
        }

        eventSetup(bus);

        AncientAetherBlocks.registerWoodTypes();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AncientAetherConfig.SERVER_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientAetherConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, AncientAetherConfig.CLIENT_SPEC);

        if (dist == Dist.CLIENT) {
            AncientAetherClient.clientInit(bus);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AncientAetherBlocks.registerPots();
            AncientAetherBlocks.registerFlammability();

            registerComposting();
            registerDispenserBehaviors();

            Regions.register(new AncientAetherRegion(new ResourceLocation(MODID, "ancient_aether"), AncientAetherConfig.COMMON.ancient_aether_region_weight.get()));
            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MODID, AncientAetherSurfaceRules.makeRules());
        });
    }

    public void serverSetup(ServerAboutToStartEvent event) {
        if (AncientAetherConfig.SERVER.server_config_overrides.get()) {
            AetherConfig.SERVER.disable_eternal_day.set(true);
        }
    }

    public void eventSetup(IEventBus neoBus) {
        IEventBus bus = NeoForge.EVENT_BUS;

        ArmorAbilityListener.listen(bus);
        ToolAbilityListener.listen(bus);
        WeaponAbilityListener.listen(bus);
        AttachmentListener.listen(bus);
        EntityListener.listen(bus);
        ItemListener.listen(bus);
        LevelListener.listen(bus);
        MenuListener.listen(bus);

        neoBus.addListener(AncientAetherCreativeModeTabs::buildCreativeModeTabs);
        neoBus.addListener(AncientAetherEntityTypes::registerSpawnPlacements);
        neoBus.addListener(AncientAetherEntityTypes::registerEntityAttributes);
    }

    private void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(AncientAetherItems.HIGHSPROOT_BOAT.get(), new DispenseAncientAetherBoatBehavior());
        DispenserBlock.registerBehavior(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get(), new DispenseAncientAetherBoatBehavior(true));
        DispenserBlock.registerBehavior(AncientAetherItems.SAKURA_BOAT.get(), new DispenseAncientAetherBoatBehavior());
        DispenserBlock.registerBehavior(AncientAetherItems.SAKURA_CHEST_BOAT.get(), new DispenseAncientAetherBoatBehavior(true));
    }

    public void addPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_texture_tweaks");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_texture_tweaks", Component.translatable("pack.ancient_aether.texture_tweaks.title"), true,
                    new PathPackResources.PathResourcesSupplier(resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_programmer_art");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_programmer_art", Component.translatable("pack.ancient_aether.programmer_art.title"), false,
                    new PathPackResources.PathResourcesSupplier(resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }

        if (event.getPackType() == PackType.SERVER_DATA) {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/ancient_aether_worldgen_overrides");
            var pack = Pack.readMetaAndCreate("builtin/ancient_aether_worldgen_overrides", Component.translatable("pack.ancient_aether.worldgen_overrides.title"), true,
                    new PathPackResources.PathResourcesSupplier(resourcePath, true), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.SERVER);
            event.addRepositorySource(consumer -> consumer.accept(pack));
        }
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
        addCompost(0.65F, AncientAetherBlocks.ELEVETIA.get());
        addCompost(0.85F, AncientAetherItems.SLAMMBERRY.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}