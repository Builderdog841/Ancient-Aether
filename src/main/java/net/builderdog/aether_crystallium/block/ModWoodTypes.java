package net.builderdog.aether_crystallium.block;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType HIGHLANDS_PINE_BLOCK_SET = new BlockSetType(AetherCrystallium.MOD_ID + "highlands_pine");
    public static final WoodType HIGHLANDS_PINE = new WoodType(AetherCrystallium.MOD_ID + "highlands_pine", HIGHLANDS_PINE_BLOCK_SET);
}