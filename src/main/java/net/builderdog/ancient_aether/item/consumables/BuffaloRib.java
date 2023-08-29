package net.builderdog.ancient_aether.item.consumables;

import com.aetherteam.aether.item.AetherItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BuffaloRib extends Item {
    public BuffaloRib(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 16;
    }
}
