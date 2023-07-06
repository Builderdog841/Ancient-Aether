package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AncientCreativeModeTabs {
    public static CreativeModeTab ANCIENT_AETHER_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ANCIENT_AETHER_TAB = event.registerCreativeModeTab(new ResourceLocation(AncientAether.MOD_ID, "aether_crystallium_tab"),
                builder -> builder.icon(() -> new ItemStack(AncientAetherItems.AECHOR_ICE_CREAM_BUCKET.get()))
                        .title(Component.translatable("creatvemodetab.ancient_aether_tab")));
    }
}
