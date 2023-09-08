package net.builderdog.ancient_aether.item.loot;

import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import com.aetherteam.aether.item.combat.DartShooterItem;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.entity.misc.GravititeDart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GravititeDartShooterItem extends DartShooterItem {
    private final List<Component> dungeonTooltips = new ArrayList<>();
    public GravititeDartShooterItem(Supplier<? extends Item> dartType, Properties properties) {
        super(dartType, properties);
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> {
            return stack.is(AncientAetherTags.Items.DARTS);
        };
    }

    public AbstractDart customDart(AbstractDart dart) {
        GravititeDart gravititedart = new GravititeDart(dart.level);
        gravititedart.setOwner(dart.getOwner());
        if (gravititedart.getOwner() != null) {
            gravititedart.setPos(gravititedart.getOwner().getX(), gravititedart.getOwner().getEyeY() - 0.1, gravititedart.getOwner().getZ());
        }
        return gravititedart;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        if (flag.isCreative()) {
            components.addAll(dungeonTooltips);
        }
    }
}
