package net.builderdog.ancient_aether.event;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AncientAetherMissingEntries {
    @SubscribeEvent
    public static void missingMappings(MissingMappingsEvent event) {
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_planks")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_PLANKS.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_button")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_BUTTON.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_fence")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_FENCE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_fence_gate")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_leaves")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_LEAVES.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_log")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_LOG.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_pressure_plate")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_sapling")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_SAPLING.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_sign")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_SIGN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_slab")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_SLAB.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_stairs")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_STAIRS.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_trapdoor")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_door")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_DOOR.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_log_wall")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_wood_wall")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_wall_sign")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("highlands_pine_wood")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHSPROOT_WOOD.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("potted_highlands_pine_sapling")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("stripped_highlands_pine_log")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("stripped_highlands_pine_wood")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("stripped_highlands_pine_log_wall")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("stripped_highlands_pine_wood_wall")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get()));

        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("potted_small_aether_cactus")).forEach(blockMapping -> blockMapping.remap(Blocks.FLOWER_POT));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("moonlit_tulip")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.HIGHLAND_TULIP.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("potted_moonlit_tulip")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.POTTED_HIGHLAND_TULIP.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("potted_moonlit_tulip")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.POTTED_HIGHLAND_TULIP.get()));

        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("enchanted_sentry_stone")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.ANCIENT_SENTRY_STONE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("broken_enchanted_obelisk")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("enchanted_obelisk")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.SENTRY_OBELISK.get()));

        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("blighted_sentry_stone")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.ANCIENT_SENTRY_STONE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("broken_blighted_obelisk")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("blighted_obelisk")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.SENTRY_OBELISK.get()));

        event.getMappings(ForgeRegistries.Keys.ITEMS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("enchanted_sentry_rune")).forEach(blockMapping -> blockMapping.remap(AncientAetherItems.ANCIENT_RUNE.get()));
        event.getMappings(ForgeRegistries.Keys.ITEMS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("blighted_sentry_rune")).forEach(blockMapping -> blockMapping.remap(AncientAetherItems.ANCIENT_RUNE.get()));
        event.getMappings(ForgeRegistries.Keys.ITEMS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("ancient_sentry_rune")).forEach(blockMapping -> blockMapping.remap(AncientAetherItems.ANCIENT_RUNE.get()));
        event.getMappings(ForgeRegistries.Keys.ITEMS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("aechor_ice_cream_bucket")).forEach(blockMapping -> blockMapping.remap(AetherItems.SKYROOT_BUCKET.get()));

        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("quicksoil_bricks")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.QUICKSTONE.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("quicksoil_brick_stairs")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.QUICKSTONE_STAIRS.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("quicksoil_brick_slab")).forEach(blockMapping -> blockMapping.remap(AncientAetherBlocks.QUICKSTONE_SLAB.get()));
        event.getMappings(ForgeRegistries.Keys.BLOCKS, AncientAether.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("quicksoil_brick_wall")).forEach(blockMapping -> blockMapping.remap(AetherBlocks.HOLYSTONE_WALL.get()));
    }
}