package net.builderdog.ancient_aether.item.loot;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import com.aetherteam.aether.item.combat.DartShooterItem;
import net.builderdog.ancient_aether.entity.misc.GravititeDart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GravititeDartShooterItem extends DartShooterItem {
    public GravititeDartShooterItem(Supplier<? extends Item> dartType, Properties properties) {
        super(dartType, properties);
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> {
            return stack.is(AetherTags.Items.DARTS);
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
}
