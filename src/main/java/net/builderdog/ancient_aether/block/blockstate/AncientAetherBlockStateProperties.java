package net.builderdog.ancient_aether.block.blockstate;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AncientAetherBlockStateProperties {
    public static final BooleanProperty CUT = BooleanProperty.create("cut");
    public static final BooleanProperty CHARGED = BooleanProperty.create("charged");
    public static final BooleanProperty CRITICAL = BooleanProperty.create("critical");
    public static final IntegerProperty LENGTH = IntegerProperty.create("length", 1, 5);
    public static final EnumProperty<AetherGrassType> TYPE = EnumProperty.create("type", AetherGrassType.class);
}