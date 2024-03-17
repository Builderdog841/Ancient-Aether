package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.world.carver.AncientAetherCarvers;
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
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class AncientAetherConfiguredCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> AETHER_CAVE = createKey("aether_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> AETHER_SURFACE_CAVE = createKey("aether_surface_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> ELEVATED_ISLANDS_CAVE = createKey("elevated_islands_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> GROTTO_CARVER = createKey("grotto_carver");

    private static ResourceKey<ConfiguredWorldCarver<?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(AncientAether.MODID, name));
    }

    private static ConfiguredWorldCarver<?> createBaseAetherCave(HolderGetter<Block> blocks, float probability, int maxY, float minYScale, float maxYScale, float minHorizontal, float maxHorizontal, float minVertical, float maxVertical) {
        CaveCarverConfiguration config = new CaveCarverConfiguration(
                probability,
                UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(maxY)),
                UniformFloat.of(minYScale, maxYScale),
                VerticalAnchor.aboveBottom(-64),
                blocks.getOrThrow(AncientAetherTags.Blocks.AETHER_CARVER_REPLACEABLES),
                UniformFloat.of(minHorizontal, maxHorizontal),
                UniformFloat.of(minVertical, maxVertical),
                UniformFloat.of(-0.8F, -0.4F));

        return new ConfiguredWorldCarver<>(AncientAetherCarvers.SKYLANDS_CAVE.get(), config);
    }

    private static ConfiguredWorldCarver<?> createAetherCave(HolderGetter<Block> blocks, int maxY) {
        return createBaseAetherCave(blocks, 0.1F, maxY, 0.1F, 0.6F, 1.75F, 3.5F, 1.0F, 1.5F);
    }

    private static ConfiguredWorldCarver<?> createAetherSurfaceCave(HolderGetter<Block> blocks) {
        return createBaseAetherCave(blocks, 0.15F,256, 0.4F, 0.9F, 0.75F, 2.5F, 0.25F, 1.0F);
    }

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        context.register(AETHER_CAVE, createAetherCave(blocks, 96));
        context.register(AETHER_SURFACE_CAVE, createAetherSurfaceCave(blocks));
        context.register(ELEVATED_ISLANDS_CAVE, createAetherCave(blocks, 106));
    }
}