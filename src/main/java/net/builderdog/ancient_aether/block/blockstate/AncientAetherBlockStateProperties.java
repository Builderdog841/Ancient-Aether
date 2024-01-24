package net.builderdog.ancient_aether.block.blockstate;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AncientAetherBlockStateProperties extends BlockStateProperties {
    public static final IntegerProperty LENGTH = IntegerProperty.create("length", 1, 5);
    public static final EnumProperty<AetherGrassType> TYPE = EnumProperty.create("type", AetherGrassType.class);
}