package net.builderdog.ancient_aether.item.miscellaneous;

import com.aetherteam.aether.item.miscellaneous.ConsumableItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ValkyrumWineItem extends Item implements ConsumableItem {
    private static final String NBT = "Wine";
    private static final int MAX_WINE = 8;
    private static final int BAR_COLOR = 7804719;

    public ValkyrumWineItem(Properties properties) {
        super(properties);
    }

    static CompoundTag createCompoundFor(ItemStack stack) {
        return stack.hasTag() ? stack.getOrCreateTag().copy() : new CompoundTag();
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        FoodProperties foodProperties = getFoodProperties(heldStack, player);
        if (foodProperties != null && player.canEat(foodProperties.canAlwaysEat())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(heldStack);
        }
        else {
            return InteractionResultHolder.fail(heldStack);
        }
    }

    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity user) {

        return user.eat(level, stack);
    }

    public boolean isBarVisible(@NotNull ItemStack stack) {
        return true;
    }

    public int getBarWidth(@NotNull ItemStack stack) {
        return MAX_WINE;
    }

    public int getBarColor(@NotNull ItemStack stack) {
        return BAR_COLOR;
    }
}
