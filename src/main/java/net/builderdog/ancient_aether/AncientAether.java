package net.builderdog.ancient_aether;

import com.aetherteam.aether.AetherConfig;
//import com.mojang.logging.LogUtils;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.biomemodifier.AncientAetherBiomeModifierSerializers;
import net.builderdog.ancient_aether.world.biomes.AncientAetherRegion;
import net.builderdog.ancient_aether.world.biomes.AncientAetherSurfaceData;
import net.builderdog.ancient_aether.world.foliageplacer.AncientAetherFoliagePlacerTypes;
import net.builderdog.ancient_aether.world.structure.AncientAetherStructureTypes;
import net.minecraft.SharedConstants;
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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
//import org.slf4j.Logger;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.nio.file.Path;

import static com.aetherteam.aether.Aether.DIRECTORY;

@Mod(AncientAether.MOD_ID)
public class AncientAether {
    public static final String MOD_ID = "ancient_aether";

    //private static final Logger LOGGER = LogUtils.getLogger();

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
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::packSetup);

        MinecraftForge.EVENT_BUS.register(this);

        DIRECTORY.toFile().mkdirs();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AncientAetherConfig.COMMON_SPEC);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
                AetherConfig.COMMON.add_ruined_portal_automatically.set(true);
                AetherConfig.COMMON.add_temporary_freezing_automatically.set(true);
                AetherConfig.CLIENT.music_backup_min_delay.set(1);
                AetherConfig.CLIENT.music_backup_max_delay.set(2);
                AetherConfig.CLIENT.disable_music_manager.set(false);
        });
    }

    private void commonSetup(
            final FMLCommonSetupEvent event) {

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

    public void packSetup(AddPackFindersEvent event) {
        setupOptionalPack(event);
        setupDatapack(event, "ancient_aether_new_worldgen", "New World Generation", "Adds larger Islands, Mountains and a lot more");
        setupDatapack(event, "ancient_aether_default_biome_improvements", "Default Biome Improvements", "Adds more flowers and tree variation to the Default Aether Biomes. It also gives the Aether a new Watercolor.");

        if (ModList.get().isLoaded("aether_genesis")) {
            setupDatapack(event, "aether_genesis_compat", "Aether Genesis Compatibility", "Makes Log and Wood Walls from Ancient Aether craftable");
        }
    }

    private void setupOptionalPack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource("packs/" + "ancient_aether_programmer_art");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable("Changes the textures to the classic art style"), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/" + "ancient_aether_programmer_art", Component.literal("Ancient Aether: " + "Programmer Art"), false, (string) -> {
                    return pack;
                }, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.CLIENT_RESOURCES, Pack.Position.TOP, false, PackSource.BUILT_IN));
            });
        }
    }

    private void setupDatapack(AddPackFindersEvent event, String path, String displayName, String desc) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById("ancient_aether").getFile().findResource("packs/" + path);
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById("ancient_aether").getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            PackMetadataSection metadata = new PackMetadataSection(Component.translatable(desc), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA));
            event.addRepositorySource((packConsumer) -> {
                packConsumer.accept(Pack.create("builtin/" + path, Component.literal("Ancient Aether: " + displayName), false, (string) -> pack, new Pack.Info(metadata.getDescription(), metadata.getPackFormat(PackType.SERVER_DATA), metadata.getPackFormat(PackType.CLIENT_RESOURCES), FeatureFlagSet.of(), pack.isHidden()), PackType.SERVER_DATA, Pack.Position.TOP, false, PackSource.BUILT_IN));
            });
        }
    }

    private void registerComposting() {
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.FROSTED_HIGHSPROOT_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_LEAVES.get().asItem());
        addCompost(0.3F, AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.FROSTED_HIGHSPROOT_SAPLING.get());
        addCompost(0.3F, AncientAetherBlocks.SAKURA_SAPLING.get());
        addCompost(0.65F,AncientAetherBlocks.HIGHLAND_TULIP.get());
        addCompost(0.65F,AncientAetherBlocks.SAKURA_BLOSSOMS.get());
        addCompost(0.65F,AncientAetherBlocks.EDELWEISS.get());
        addCompost(0.65F,AncientAetherBlocks.MOONLIT_WATERLILY.get());
    }

    private void addCompost(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
    }
}
