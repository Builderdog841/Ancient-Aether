package net.builderdog.aether_crystallium.item;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AetherCrystallium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab AETHER_CRYSTALLIUM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        AETHER_CRYSTALLIUM_TAB = event.registerCreativeModeTab(new ResourceLocation(AetherCrystallium.MOD_ID, "aether_crystallium_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.AECHOR_PETAL_ICE_CREAM_BUCKET.get()))
                        .title(Component.translatable("creatvemodetab.ancient_aether_tab")));
    }
}
