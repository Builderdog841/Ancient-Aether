package net.builderdog.ancient_aether;

import net.builderdog.ancient_aether.advancement.AncientAdvancementTriggers;
import net.builderdog.ancient_aether.attachments.AncientDataAttachments;
import net.builderdog.ancient_aether.block.AncientBlockSets;
import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.block.dispenser.DispenseAncientBoatBehavior;
import net.builderdog.ancient_aether.blockentity.AncientBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientClient;
import net.builderdog.ancient_aether.client.AncientSoundEvents;
import net.builderdog.ancient_aether.client.particle.AncientParticleTypes;
import net.builderdog.ancient_aether.data.AncientData;
import net.builderdog.ancient_aether.effect.AncientEffects;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.builderdog.ancient_aether.event.listeners.*;
import net.builderdog.ancient_aether.event.listeners.ability.ArmorAbilityListener;
import net.builderdog.ancient_aether.event.listeners.ability.ToolAbilityListener;
import net.builderdog.ancient_aether.event.listeners.ability.WeaponAbilityListener;
import net.builderdog.ancient_aether.item.AncientCreativeModeTabs;
import net.builderdog.ancient_aether.item.AncientItems;
import net.builderdog.ancient_aether.world.biome.AncientRegion;
import net.builderdog.ancient_aether.world.biome.AncientSurfaceRules;
import net.builderdog.ancient_aether.world.feature.AncientFeatures;
import net.builderdog.ancient_aether.world.structure.processor.AncientStructureProcessors;
import net.builderdog.ancient_aether.world.structure.AncientStructureTypes;
import net.builderdog.ancient_aether.world.tree.foliage.AncientFoliagePlacers;
import net.builderdog.ancient_aether.world.tree.decorator.AncientTreeDecorators;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
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
import net.neoforged.neoforge.registries.DeferredRegister;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(AncientAether.MODID)
public class AncientAether {
    public static final String MODID = "ancient_aether";

    public AncientAether(IEventBus bus, Dist dist) {
        bus.addListener(AncientData::dataSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::packSetup);

        DeferredRegister<?>[] registers = {
                AncientBlocks.BLOCKS,
                AncientItems.ITEMS,
                AncientBlockEntityTypes.BLOCK_ENTITY_TYPES,
                AncientEntityTypes.ENTITY_TYPES,
                AncientEffects.EFFECTS,
                AncientFeatures.FEATURES,
                AncientFoliagePlacers.FOLIAGE_PLACERS,
                AncientTreeDecorators.TREE_DECORATORS,
                AncientStructureTypes.STRUCTURE_TYPES,
                AncientStructureProcessors.STRUCTURE_PROCESSOR_TYPES,
                AncientAdvancementTriggers.TRIGGERS,
                AncientSoundEvents.SOUNDS,
                AncientParticleTypes.PARTICLES,
                AncientDataAttachments.ATTACHMENTS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(bus);
        }

        eventSetup(bus);

        AncientBlockSets.registerWoodTypes();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AncientConfig.SERVER_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, AncientConfig.CLIENT_SPEC);

        if (dist == Dist.CLIENT) {
            AncientClient.clientInit(bus);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AncientBlocks.registerPots();
            AncientBlocks.registerFlammability();
            registerDispenserBehaviors();

            Regions.register(new AncientRegion(new ResourceLocation(MODID, "ancient_aether"), AncientConfig.COMMON.ancient_aether_region_weight.get()));
            SurfaceRuleManager.addSurfaceRules(AetherRuleCategory.THE_AETHER, MODID, AncientSurfaceRules.makeRules());
        });
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
        ServerListener.listen(bus);

        neoBus.addListener(AncientCreativeModeTabs::buildCreativeModeTabs);
        neoBus.addListener(AncientEntityTypes::registerSpawnPlacements);
        neoBus.addListener(AncientEntityTypes::registerEntityAttributes);
    }

    private void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(AncientItems.HIGHSPROOT_BOAT.get(), new DispenseAncientBoatBehavior());
        DispenserBlock.registerBehavior(AncientItems.HIGHSPROOT_CHEST_BOAT.get(), new DispenseAncientBoatBehavior(true));
        DispenserBlock.registerBehavior(AncientItems.SAKURA_BOAT.get(), new DispenseAncientBoatBehavior());
        DispenserBlock.registerBehavior(AncientItems.SAKURA_CHEST_BOAT.get(), new DispenseAncientBoatBehavior(true));
    }

    public void packSetup(AddPackFindersEvent event) {
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
}