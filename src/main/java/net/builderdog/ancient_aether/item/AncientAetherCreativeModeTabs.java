package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientAetherCreativeModeTabs {
    public static CreativeModeTab ANCIENT_AETHER_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ANCIENT_AETHER_TAB = event.registerCreativeModeTab(new ResourceLocation(AncientAether.MOD_ID, "aether_crystallium_tab"),
                builder -> builder.icon(() -> new ItemStack(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET.get()))
                        .title(Component.translatable("creatvemodetab.ancient_aether_tab"))
                        .displayItems((features, output) -> {
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_LOG.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_WOOD.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHLANDS_PINE_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_STAIRS.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_SLAB.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_FENCE.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_FENCE_GATE.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_DOOR.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_TRAPDOOR.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_PRESSURE_PLATE.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_BUTTON.get());
                            output.accept(AncientAetherItems.HIGHLANDS_PINE_SIGN.get());
                            output.accept(AncientAetherItems.HIGHLANDS_PINE_BOAT.get());
                            output.accept(AncientAetherItems.HIGHLANDS_PINE_CHEST_BOAT.get());
                            output.accept(AncientAetherBlocks.SAKURA_LOG.get());
                            output.accept(AncientAetherBlocks.SAKURA_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.SAKURA_WOOD.get());
                            output.accept(AncientAetherBlocks.SAKURA_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get());
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get());
                            output.accept(AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.SAKURA_PLANKS.get());
                            output.accept(AncientAetherBlocks.SAKURA_STAIRS.get());
                            output.accept(AncientAetherBlocks.SAKURA_SLAB.get());
                            output.accept(AncientAetherBlocks.SAKURA_FENCE.get());
                            output.accept(AncientAetherBlocks.SAKURA_FENCE_GATE.get());
                            output.accept(AncientAetherBlocks.SAKURA_DOOR.get());
                            output.accept(AncientAetherBlocks.SAKURA_TRAPDOOR.get());
                            output.accept(AncientAetherBlocks.SAKURA_PRESSURE_PLATE.get());
                            output.accept(AncientAetherBlocks.SAKURA_BUTTON.get());
                            output.accept(AncientAetherItems.SAKURA_SIGN.get());
                            output.accept(AncientAetherItems.SAKURA_BOAT.get());
                            output.accept(AncientAetherItems.SAKURA_CHEST_BOAT.get());
                            output.accept(AncientAetherBlocks.AETHER_CACTUS.get());
                            output.accept(AncientAetherBlocks.STRIPPED_AETHER_CACTUS.get());
                            output.accept(AncientAetherBlocks.CACTUS_FLOWER.get());
                            output.accept(AncientAetherBlocks.GOLDEN_CACTUS_FLOWER.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_LEAVES.get());
                            output.accept(AncientAetherBlocks.SAKURA_LEAVES.get());
                            output.accept(AncientAetherBlocks.HIGHLANDS_PINE_SAPLING.get());
                            output.accept(AncientAetherBlocks.SAKURA_SAPLING.get());
                            output.accept(AncientAetherBlocks.SMALL_AETHER_CACTUS.get());
                            output.accept(AncientAetherBlocks.SKYROOT_THORN_BUSH.get());
                            output.accept(AncientAetherBlocks.EDELWEISS.get());
                            output.accept(AncientAetherBlocks.MOONLIT_TULIP.get());
                            output.accept(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
                            output.accept(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get());
                            //output.accept(AncientAetherBlocks.MOONLIT_WATERLILY.get());
                            output.accept(AncientAetherBlocks.AETHER_QUARTZ_ORE.get());
                            output.accept(AncientAetherBlocks.QUICKSTONE.get());
                            output.accept(AncientAetherBlocks.QUICKSOIL_BRICKS.get());
                            output.accept(AncientAetherBlocks.QUICKSOIL_BRICK_STAIRS.get());
                            output.accept(AncientAetherBlocks.QUICKSOIL_BRICK_SLAB.get());
                            output.accept(AncientAetherBlocks.QUICKSOIL_BRICK_WALL.get());
                            output.accept(AncientAetherBlocks.HOLYSTONE_BRICK_MOSAIC.get());
                            output.accept(AncientAetherBlocks.CARVED_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.ANGELIC_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.GALE_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.HOLYSTONE_LANTERN.get());
                            output.accept(AncientAetherBlocks.SENTRY_LANTERN.get());
                            output.accept(AncientAetherBlocks.ANGELIC_LANTERN.get());
                            output.accept(AncientAetherBlocks.HELLFIRE_LANTERN.get());
                            output.accept(AncientAetherBlocks.GALE_LANTERN.get());
                            output.accept(AncientAetherBlocks.ENCHANTED_SENTRY_STONE.get());
                            output.accept(AncientAetherBlocks.BLIGHTED_SENTRY_STONE.get());
                            output.accept(AncientAetherBlocks.BROKEN_ENCHANTED_OBELISK.get());
                            output.accept(AncientAetherBlocks.BROKEN_BLIGHTED_OBELISK.get());
                            output.accept(AncientAetherBlocks.ENCHANTED_OBELISK.get());
                            output.accept(AncientAetherBlocks.BLIGHTED_OBELISK.get());
                            output.accept(AncientAetherBlocks.CRACKED_SLIDER.get());
                            output.accept(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.LOCKED_ENCHANTED_SENTRY_STONE.get());
                            output.accept(AncientAetherBlocks.LOCKED_BLIGHTED_SENTRY_STONE.get());
                            output.accept(AncientAetherItems.ENCHANTED_SENTRY_RUNE.get());
                            output.accept(AncientAetherItems.BLIGHTED_SENTRY_RUNE.get());
                            output.accept(AncientAetherItems.RAW_BUFFALO_RIBS.get());
                            output.accept(AncientAetherItems.COOKED_BUFFALO_RIBS.get());
                            output.accept(AncientAetherItems.BUFFALO_RIB.get());
                            output.accept(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET.get());
                            output.accept(AncientAetherItems.CACTUS_FLOWER_ICE_CREAM_BUCKET.get());
                            output.accept(AncientAetherItems.HIGHLANDS_BUFFALO_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.ROOTLING_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.VELOX_WHIRLWIND_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.VELOX_ZEPHYR_SPAWN_EGG.get());
                        }));
    }
}
