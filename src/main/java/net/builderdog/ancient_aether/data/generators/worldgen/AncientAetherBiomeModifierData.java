package net.builderdog.ancient_aether.data.generators.worldgen;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherMiscPlacements;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherOrePlacements;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherVegetationPlacements;
import net.builderdog.ancient_aether.world.biomemodifier.CarverModifier;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class AncientAetherBiomeModifierData {
    public static final ResourceKey<BiomeModifier> AEROGEL_BLOBS_BIOME_MODIFIER = createKey("aerogel_blobs_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_QUARTZ_ORE_BIOME_MODIFIER = createKey("aether_quartz_ore_biome_modifier");
    public static final ResourceKey<BiomeModifier> VALKYRUM_ORE_BIOME_MODIFIER = createKey("valkyrum_ore_biome_modifier");
    public static final ResourceKey<BiomeModifier> QUICKSOIL_COAST_BIOME_MODIFIER = createKey("quicksoil_coast_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_GRASS_PATCH_MODIFIER = createKey("aether_grass_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> BONUS_BERRY_BUSH_PATCH_MODIFIER = createKey("bonus_berry_bush_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> VIOLET_AERCLOUD_BIOME_MODIFIER = createKey("violet_aercloud_biome_modifier");
    public static final ResourceKey<BiomeModifier> CLOUDBED_BIOME_MODIFIER = createKey("cloudbed_biome_modifier");
    public static final ResourceKey<BiomeModifier> WATER_LAKE_UNDERGROUND_BIOME_MODIFIER = createKey("water_lake_underground_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_CAVE_BIOME_MODIFIER = createKey("aether_cave_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_SURFACE_CAVE_BIOME_MODIFIER = createKey("aether_surface_cave_biome_modifier");

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biome = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placement = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(AEROGEL_BLOBS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AEROGEL_BLOBS),
                HolderSet.direct(placement.getOrThrow(AncientAetherOrePlacements.AEROGEL_BLOBS)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(AETHER_QUARTZ_ORE_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_QUARTZ_ORE),
                HolderSet.direct(placement.getOrThrow(AncientAetherOrePlacements.AETHER_QUARTZ_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(VALKYRUM_ORE_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_VALKYRUM_ORE),
                HolderSet.direct(placement.getOrThrow(AncientAetherOrePlacements.VALKYRUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(QUICKSOIL_COAST_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_QUICKSOIL_COASTS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.QUICKSOIL_COAST)),
                GenerationStep.Decoration.RAW_GENERATION
        ));
        context.register(AETHER_GRASS_PATCH_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_GRASS_PATCHES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.AETHER_GRASS_PATCH)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(BONUS_BERRY_BUSH_PATCH_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.IS_SKYROOT_FOREST),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.BONUS_BERRY_BUSH_PATCH)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(VIOLET_AERCLOUD_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_VIOLET_AERCLOUD),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.VIOLET_AERCLOUD)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION
        ));
        context.register(CLOUDBED_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_CLOUDBED),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.CLOUDBED)),
                GenerationStep.Decoration.RAW_GENERATION
        ));
        context.register(WATER_LAKE_UNDERGROUND_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_WATER_LAKE_UNDERGROUND),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.WATER_LAKE_UNDERGROUND)),
                GenerationStep.Decoration.LAKES
        ));

        context.register(AETHER_CAVE_BIOME_MODIFIER, new CarverModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_CAVES),
                carver.getOrThrow(AncientAetherConfiguredCarverData.AETHER_CAVE)
        ));
        context.register(AETHER_SURFACE_CAVE_BIOME_MODIFIER, new CarverModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_CAVES),
                carver.getOrThrow(AncientAetherConfiguredCarverData.AETHER_SURFACE_CAVE)
        ));
    }
}