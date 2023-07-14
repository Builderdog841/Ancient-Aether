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
        if (itemstack.getItem() == AncientAetherBlocks.HIGHLANDS_PINE_PLANKS.get().asItem())
            event.setBurnTime(300);
        else if (itemstack.getItem() == AncientAetherBlocks.SAKURA_PLANKS.get().asItem())
            event.setBurnTime(300);
    }
}
