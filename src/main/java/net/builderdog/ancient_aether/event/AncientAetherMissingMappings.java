package net.builderdog.ancient_aether.event;

import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

@Mod.EventBusSubscriber(modid = AncientAether.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AncientAetherMissingMappings {
    @SubscribeEvent
    public static void missingMappings(MissingMappingsEvent event) {

        //v0.8.0
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("divine_gravel")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.GRAVITY_GRAVEL.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("divine_skyroot_leaves")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("divine_skyroot_sapling")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("potted_divine_skyroot_sapling")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING.get()));

        //v0.8.6
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("wyndcaps_ice")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.WYND_ICE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("crystal_aercloud")).forEach(blockMapping -> blockMapping.remap(AetherBlocks.COLD_AERCLOUD.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("frosted_highsproot_leaves")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("frosted_highsproot_sapling")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("frosted_holystone_vase")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.FROZEN_HOLYSTONE_VASE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("ancient_frosted_holystone_vase")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get()));

        //v0.8.7
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("buffalo_wool")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.FLUFFALO_WOOL.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("buffalo_carpet")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.FLUFFALO_CARPET.get()));

        //v0.8.9
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("holystone_lantern")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.AMBROSIUM_LANTERN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("sentry_lantern")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.AMBROSIUM_LANTERN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("angelic_lantern")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.AMBROSIUM_LANTERN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("hellfire_lantern")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.SUN_LANTERN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("gale_lantern")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.AMBROSIUM_LANTERN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MODID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("cracked_slider")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.SLIDER_PROTOTYPE.get()));
    }
}