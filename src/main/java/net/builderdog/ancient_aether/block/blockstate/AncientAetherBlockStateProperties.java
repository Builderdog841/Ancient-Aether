package net.builderdog.ancient_aether.block.blockstate;

import net.minecraft.world.level.block.state.properties.EnumProperty;

public class AncientAetherBlockStateProperties {
    public static final EnumProperty<AetherTallGrassLength> LENGTH = EnumProperty.create("length", AetherTallGrassLength.class);
    public static final EnumProperty<AetherGrassType> TYPE = EnumProperty.create("type", AetherGrassType.class);
}