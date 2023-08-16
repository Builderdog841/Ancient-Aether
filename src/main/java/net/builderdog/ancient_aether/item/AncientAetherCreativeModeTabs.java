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
                        .title(Component.translatable("creativemodetab.ancient_aether_tab"))
                        .displayItems((features, output) -> {
                            output.accept(AncientAetherBlocks.HIGHSPROOT_LOG.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_WOOD.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get());
                            output.accept(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_PLANKS.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_STAIRS.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_SLAB.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_FENCE.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_DOOR.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_TRAPDOOR.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_PRESSURE_PLATE.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_BUTTON.get());
                            output.accept(AncientAetherItems.HIGHSPROOT_SIGN.get());
                            output.accept(AncientAetherItems.HIGHSPROOT_BOAT.get());
                            output.accept(AncientAetherItems.HIGHSPROOT_CHEST_BOAT.get());
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
                            output.accept(AncientAetherBlocks.HIGHSPROOT_LEAVES.get());
                            output.accept(AncientAetherBlocks.SAKURA_LEAVES.get());
                            output.accept(AncientAetherBlocks.HIGHSPROOT_SAPLING.get());
                            output.accept(AncientAetherBlocks.SAKURA_SAPLING.get());
                            output.accept(AncientAetherBlocks.EDELWEISS.get());
                            output.accept(AncientAetherBlocks.HIGHLAND_TULIP.get());
                            output.accept(AncientAetherBlocks.SAKURA_BLOSSOMS.get());
                            output.accept(AncientAetherBlocks.TRAPPED_SAKURA_BLOSSOMS.get());
                            output.accept(AncientAetherBlocks.MOONLIT_WATERLILY.get());
                            output.accept(AncientAetherBlocks.AETHER_QUARTZ_ORE.get());
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
                            output.accept(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get());
                            output.accept(AncientAetherBlocks.ANCIENT_SENTRY_STONE.get());
                            output.accept(AncientAetherBlocks.BROKEN_SENTRY_OBELISK.get());
                            output.accept(AncientAetherBlocks.SENTRY_OBELISK.get());
                            output.accept(AncientAetherBlocks.CRACKED_SLIDER.get());
                            output.accept(AncientAetherBlocks.LOCKED_CARVED_STONE_MOSAIC.get());
                            output.accept(AncientAetherBlocks.LOCKED_ANCIENT_SENTRY_STONE.get());
                            output.accept(AncientAetherItems.ANCIENT_SENTRY_RUNE.get());
                            output.accept(AncientAetherItems.RAW_BUFFALO_RIBS.get());
                            output.accept(AncientAetherItems.COOKED_BUFFALO_RIBS.get());
                            output.accept(AncientAetherItems.BUFFALO_RIB.get());
                            output.accept(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET.get());
                            output.accept(AncientAetherItems.ANCIENT_DUNGEON_KEY.get());
                            output.accept(AncientAetherItems.ANCIENT_SWORD.get());
                            output.accept(AncientAetherItems.MUSIC_DISC_LABYRINTHS_VENGEANCE_BUILDERDOG_REMIX.get());
                            output.accept(AncientAetherItems.SAKURA_MOA_EGG.get());
                            output.accept(AncientAetherItems.HIGHLAND_BUFFALO_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.LEAPING_SENTRY_SPAWN_EGG.get());
                            output.accept(AncientAetherItems.ROOTHYRN_SPAWN_EGG.get());
                        }));
    }
}
