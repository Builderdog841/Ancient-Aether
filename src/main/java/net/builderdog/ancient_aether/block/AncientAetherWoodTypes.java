package net.builderdog.ancient_aether.block;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherWoodTypes {
    public static final BlockSetType HIGHSPROOT_BLOCK_SET = new BlockSetType(AncientAether.MOD_ID + ":highsproot");
    public static final WoodType HIGHSPROOT = new WoodType(AncientAether.MOD_ID + ":highsproot", HIGHSPROOT_BLOCK_SET);
    public static final BlockSetType SAKURA_BLOCK_SET = new BlockSetType(AncientAether.MOD_ID + ":sakura");
    public static final WoodType SAKURA = new WoodType(AncientAether.MOD_ID + ":sakura", SAKURA_BLOCK_SET);
    public static final BlockSetType AEROGEL_GLASS_BLOCK_SET = new BlockSetType(AncientAether.MOD_ID + ":aerogel_glass");
}