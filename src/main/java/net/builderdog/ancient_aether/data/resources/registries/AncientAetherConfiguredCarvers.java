package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class AncientAetherConfiguredCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> AETHER_CAVE = createKey("aether_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> AETHER_CAVE_ELEVATED = createKey("aether_cave_elevated");
    public static final ResourceKey<ConfiguredWorldCarver<?>> AETHER_CAVE_SAKURA = createKey("aether_cave_sakura");

    private static ResourceKey<ConfiguredWorldCarver<?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(AncientAether.MODID, name));
    }

    private static ConfiguredWorldCarver<?> createBaseAetherCave(HolderGetter<Block> blocks, float probability, int minHeight) {
        CaveCarverConfiguration config = new CaveCarverConfiguration(
                probability,
                UniformHeight.of(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(256)),
                UniformFloat.of(0.6F, 1.2F),
                VerticalAnchor.aboveBottom(-64),
                blocks.getOrThrow(AncientAetherTags.Blocks.AETHER_CARVER_REPLACEABLES),
                UniformFloat.of(1.0F, 2.5F),
                UniformFloat.of(0.75F, 1.5F),
                UniformFloat.of(-0.6F, -0.2F)
        );
        return new ConfiguredWorldCarver<>(WorldCarver.CAVE, config);
    }

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        context.register(AETHER_CAVE, createBaseAetherCave(blocks, 0.15F, 72));
        context.register(AETHER_CAVE_ELEVATED, createBaseAetherCave(blocks, 0.15F, 88));
        context.register(AETHER_CAVE_SAKURA, createBaseAetherCave(blocks, 0.2F, 0));
    }
}