package net.builderdog.ancient_aether.data.generators.worldgen;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherOrePlacements;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class AncientAetherBiomeModifierData {
    public static final ResourceKey<BiomeModifier> AEROGEL_BLOBS_BIOME_MODIFIER = createKey("aerogel_blobs_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_QUARTZ_ORE_BIOME_MODIFIER = createKey("aether_quartz_ore_biome_modifier");

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        context.register(AEROGEL_BLOBS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_AEROGEL_BLOBS),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherOrePlacements.AEROGEL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(AETHER_QUARTZ_ORE_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_QUARTZ_ORE),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherOrePlacements.AETHER_QUARTZ_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }
}