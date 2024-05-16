package net.builderdog.ancient_aether.world.tree;

import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherTreeFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AncientAetherTreeGrowers {
    public static final TreeGrower CRYSTAL_SKYROOT = new TreeGrower(
            "crystal_skyroot",
            Optional.empty(),
            Optional.of(AncientAetherTreeFeatures.CRYSTAL_SKYROOT_TREE),
            Optional.empty()
    );

    public static final TreeGrower ENCHANTED_SKYROOT = new TreeGrower(
            "enchanted_skyroot",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(AncientAetherTreeFeatures.ENCHANTED_SKYROOT_TREE),
            Optional.of(AncientAetherTreeFeatures.FANCY_ENCHANTED_SKYROOT_TREE),
            Optional.empty(),
            Optional.empty()
    );

    public static final TreeGrower SKYROOT_PINE_TREE = new TreeGrower(
            "skyroot_pine",
            Optional.empty(),
            Optional.of(AncientAetherTreeFeatures.SKYROOT_PINE_TREE),
            Optional.empty()
    );

    public static final TreeGrower BLUE_SKYROOT_PINE_TREE = new TreeGrower(
            "blue_skyroot_pine",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("aether_genesis", "blue_skyroot_pine"))),
            Optional.empty()
    );

    public static final TreeGrower HIGHSPROOT = new TreeGrower(
            "highsproot",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(AncientAetherTreeFeatures.HIGHSPROOT_TREE),
            Optional.of(AncientAetherTreeFeatures.TALL_HIGHSPROOT_TREE),
            Optional.empty(),
            Optional.empty()
    );

    public static final TreeGrower SAKURA = new TreeGrower(
            "highsproot",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(AncientAetherTreeFeatures.SAKURA_TREE),
            Optional.of(AncientAetherTreeFeatures.TALL_SAKURA_TREE),
            Optional.empty(),
            Optional.empty()
    );
}