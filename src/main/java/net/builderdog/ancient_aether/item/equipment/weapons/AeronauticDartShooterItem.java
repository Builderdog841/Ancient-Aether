package net.builderdog.ancient_aether.item.equipment.weapons;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import com.aetherteam.aether.item.combat.DartShooterItem;
import net.builderdog.ancient_aether.entity.projectile.AeronauticDart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class AeronauticDartShooterItem extends DartShooterItem {
    public AeronauticDartShooterItem(Supplier<? extends Item> dartType, Properties properties) {
        super(dartType, properties);
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> stack.is(AetherTags.Items.DARTS);
    }

    public AbstractDart customDart(AbstractDart dart) {
        AeronauticDart aeronauticDart = new AeronauticDart(dart.level());
        aeronauticDart.setOwner(dart.getOwner());
        if (aeronauticDart.getOwner() != null) {
            aeronauticDart.setPos(aeronauticDart.getOwner().getX(), aeronauticDart.getOwner().getEyeY() - 0.1, aeronauticDart.getOwner().getZ());
        }
        return aeronauticDart;
    }
}
