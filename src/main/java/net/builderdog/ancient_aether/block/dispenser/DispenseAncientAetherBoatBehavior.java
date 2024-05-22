package net.builderdog.ancient_aether.block.dispenser;

import com.aetherteam.aether.entity.miscellaneous.SkyrootBoat;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherBoat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public class DispenseAncientAetherBoatBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final boolean isChestBoat;

    public DispenseAncientAetherBoatBehavior() {
        this(false);
    }

    public DispenseAncientAetherBoatBehavior(boolean isChestBoat) {
        this.isChestBoat = isChestBoat;
    }

    public @NotNull ItemStack execute(BlockSource source, @NotNull ItemStack stack) {
        Direction direction = source.state().getValue(DispenserBlock.FACING);
        Level level = source.level();
        double width = 0.5625 + EntityType.BOAT.getWidth() / 2.0;
        double x = source.center().x() + direction.getStepX() * width;
        double y = source.center().y() + direction.getStepY() * 1.125F;
        double z = source.center().z() + direction.getStepZ() * width;
        BlockPos blockpos = source.pos().relative(direction);
        Boat boat = (isChestBoat ? new AncientAetherBoat(level, width, x, y) : new SkyrootBoat(level, width, x, y));
        boat.setYRot(direction.toYRot());
        double yOffset;
        if (boat.canBoatInFluid(level.getFluidState(blockpos))) {
            yOffset = 1.0D;
        } else {
            if (!level.getBlockState(blockpos).isAir() || !boat.canBoatInFluid(level.getFluidState(blockpos.below()))) {
                return defaultDispenseItemBehavior.dispense(source, stack);
            }
            yOffset = 0.0D;
        }
        boat.setPos(x, y + yOffset, z);
        level.addFreshEntity(boat);
        stack.shrink(1);
        return stack;
    }
}