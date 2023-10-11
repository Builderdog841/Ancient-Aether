package net.builderdog.ancient_aether.item.consumables;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BuffaloRib extends Item {
    public BuffaloRib(Properties properties) {
        super(properties);
    }
    @Override
    public int getUseDuration(@NotNull ItemStack itemstack) {
        return 16;
    }
}
