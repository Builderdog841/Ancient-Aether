package net.builderdog.aether_crystallium.block;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType FROSTPINE_BLOCK_SET = new BlockSetType(AetherCrystallium.MOD_ID + ":frostpine");
    public static final WoodType FROSTPINE = new WoodType(AetherCrystallium.MOD_ID + ":frostpine", FROSTPINE_BLOCK_SET);
}