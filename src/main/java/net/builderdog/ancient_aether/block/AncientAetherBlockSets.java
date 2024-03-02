package net.builderdog.ancient_aether.block;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AncientAetherBlockSets {
    public static final BlockSetType HIGHSPROOT_BLOCK_SET = new BlockSetType(AncientAether.MODID + ":highsproot");
    public static final BlockSetType SAKURA_BLOCK_SET = new BlockSetType(AncientAether.MODID + ":sakura");
    public static final BlockSetType AEROGEL_GLASS_BLOCK_SET = new BlockSetType(AncientAether.MODID + ":aerogel_glass");

    public static final WoodType HIGHSPROOT = new WoodType(AncientAether.MODID + ":highsproot", HIGHSPROOT_BLOCK_SET);
    public static final WoodType SAKURA = new WoodType(AncientAether.MODID + ":sakura", SAKURA_BLOCK_SET);
}