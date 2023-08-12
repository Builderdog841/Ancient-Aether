package net.builderdog.ancient_aether.fuels;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AncientAetherFuels {
    @SubscribeEvent
    public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemstack = event.getItemStack();
        if (itemstack.getItem() == AncientAetherBlocks.HIGHSPROOT_PLANKS.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.SAKURA_PLANKS.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.HIGHSPROOT_LOG_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.HIGHSPROOT_WOOD_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.SAKURA_LOG_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.SAKURA_WOOD_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.STRIPPED_SAKURA_LOG_WALL.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.STRIPPED_SAKURA_WOOD_WALL.get().asItem())
            event.setBurnTime(300);
    }
}
