package net.builderdog.ancient_aether.block;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherWoodTypes {
    public static final BlockSetType HIGHLANDS_PINE_BLOCK_SET = new BlockSetType(AncientAether.MOD_ID + ":highlands_pine");
    public static final WoodType HIGHLANDS_PINE = new WoodType(AncientAether.MOD_ID + ":highlands_pine", HIGHLANDS_PINE_BLOCK_SET);
    public static final BlockSetType SAKURA_BLOCK_SET = new BlockSetType(AncientAether.MOD_ID + ":sakura");
    public static final WoodType SAKURA = new WoodType(AncientAether.MOD_ID + ":sakura", SAKURA_BLOCK_SET);
}