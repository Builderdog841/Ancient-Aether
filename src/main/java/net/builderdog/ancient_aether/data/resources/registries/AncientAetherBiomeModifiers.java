package net.builderdog.ancient_aether.data.resources.registries;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherPlacedFeatures;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.resources.registries.placement.AncientAetherMiscPlacements;
import net.builderdog.ancient_aether.data.resources.registries.placement.AncientAetherOrePlacements;
import net.builderdog.ancient_aether.data.resources.registries.placement.AncientAetherVegetationPlacements;
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

import java.util.Set;

public class AncientAetherBiomeModifiers {
    public static final ResourceKey<BiomeModifier> AEROGEL_BLOBS_BIOME_MODIFIER = createKey("aerogel_blobs_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_QUARTZ_ORE_BIOME_MODIFIER = createKey("aether_quartz_ore_biome_modifier");
    public static final ResourceKey<BiomeModifier> VALKYRUM_ORE_BIOME_MODIFIER = createKey("valkyrum_ore_biome_modifier");
    public static final ResourceKey<BiomeModifier> QUICKSOIL_COAST_BIOME_MODIFIER = createKey("quicksoil_coast_biome_modifier");
    public static final ResourceKey<BiomeModifier> GRAVITY_GRAVEL_COAST_BIOME_MODIFIER = createKey("gravity_gravel_coast_biome_modifier");
    public static final ResourceKey<BiomeModifier> WYND_ICE_COAST_BIOME_MODIFIER = createKey("wynd_ice_coast_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_GRASS_PATCH_MODIFIER = createKey("aether_grass_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_MEADOW_FLOWERS_BIOME_MODIFIER = createKey("skyroot_meadow_flowers_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_GROVE_FLOWERS_BIOME_MODIFIER = createKey("skyroot_grove_flowers_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_FOREST_FLOWERS_BIOME_MODIFIER = createKey("skyroot_forest_flowers_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_WOODLAND_FLOWERS_BIOME_MODIFIER = createKey("skyroot_woodland_flowers_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_MEADOW_TREES_BIOME_MODIFIER = createKey("skyroot_meadow_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_GROVE_TREES_BIOME_MODIFIER = createKey("skyroot_grove_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_FOREST_TREES_BIOME_MODIFIER = createKey("skyroot_forest_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> SKYROOT_WOODLAND_TREES_BIOME_MODIFIER = createKey("skyroot_woodland_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> BONUS_BERRY_BUSH_PATCH_MODIFIER = createKey("bonus_berry_bush_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> VIOLET_AERCLOUD_BIOME_MODIFIER = createKey("violet_aercloud_biome_modifier");
    public static final ResourceKey<BiomeModifier> CLOUDBED_BIOME_MODIFIER = createKey("cloudbed_biome_modifier");
    public static final ResourceKey<BiomeModifier> WATER_LAKE_UNDERGROUND_BIOME_MODIFIER = createKey("water_lake_underground_biome_modifier");
    public static final ResourceKey<BiomeModifier> CRYSTAL_ISLAND_BIOME_MODIFIER = createKey("crystal_island_biome_modifier");
    public static final ResourceKey<BiomeModifier> WYNDCAPS_CRYSTAL_ISLAND_BIOME_MODIFIER = createKey("wyndcaps_crystal_island_biome_modifier");
    public static final ResourceKey<BiomeModifier> ELEVATED_CRYSTAL_ISLAND_BIOME_MODIFIER = createKey("elevated_crystal_island_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_QUICKSOIL_SHELF_BIOME_MODIFIER = createKey("remove_quicksoil_shelf_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_GRASS_PATCH_BIOME_MODIFIER = createKey("remove_grass_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_TALL_GRASS_PATCH_BIOME_MODIFIER = createKey("remove_tall_grass_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_WHITE_FLOWER_PATCH_BIOME_MODIFIER = createKey("remove_white_flower_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_PURPLE_FLOWER_PATCH_BIOME_MODIFIER = createKey("remove_purple_flower_patch_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_SKYROOT_MEADOW_TREES_BIOME_MODIFIER = createKey("remove_skyroot_meadow_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_SKYROOT_GROVE_TREES_BIOME_MODIFIER = createKey("remove_skyroot_grove_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_SKYROOT_FOREST_TREES_BIOME_MODIFIER = createKey("remove_skyroot_forest_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_SKYROOT_WOODLAND_TREES_BIOME_MODIFIER = createKey("remove_skyroot_woodland_trees_biome_modifier");
    public static final ResourceKey<BiomeModifier> REMOVE_CRYSTAL_ISLAND_BIOME_MODIFIER = createKey("remove_crystal_island_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_CAVE_BIOME_MODIFIER = createKey("aether_cave_biome_modifier");
    public static final ResourceKey<BiomeModifier> AETHER_SURFACE_CAVE_BIOME_MODIFIER = createKey("aether_surface_cave_biome_modifier");

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(AncientAether.MODID, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biome = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placement = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(AEROGEL_BLOBS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AEROGEL_BLOBS),
                HolderSet.direct(placement.getOrThrow(AncientAetherOrePlacements.AEROGEL_BLOBS)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION
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
        context.register(GRAVITY_GRAVEL_COAST_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_GRAVITY_GRAVEL_COASTS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.GRAVITY_GRAVEL_COAST)),
                GenerationStep.Decoration.RAW_GENERATION
        ));
        context.register(WYND_ICE_COAST_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_WYND_ICE_COASTS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.WYND_ICE_COAST)),
                GenerationStep.Decoration.RAW_GENERATION
        ));
        context.register(AETHER_GRASS_PATCH_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_GRASS_PATCHES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.AETHER_GRASS_PATCH)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_MEADOW_FLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_MEADOW_VEGETATION),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_MEADOW_FLOWERS)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_GROVE_FLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_GROVE_VEGETATION),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_GROVE_FLOWERS)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_FOREST_FLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_FOREST_VEGETATION),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_FOREST_FLOWERS)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_WOODLAND_FLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_WOODLAND_VEGETATION),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_WOODLAND_FLOWERS)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_MEADOW_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_MEADOW_TREES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_MEADOW_TREES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_GROVE_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_GROVE_TREES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_GROVE_TREES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_FOREST_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_FOREST_TREES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_FOREST_TREES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(SKYROOT_WOODLAND_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_WOODLAND_TREES),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.SKYROOT_WOODLAND_TREES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(BONUS_BERRY_BUSH_PATCH_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.IS_SKYROOT_FOREST),
                HolderSet.direct(placement.getOrThrow(AncientAetherVegetationPlacements.BONUS_BERRY_BUSH_PATCH)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(VIOLET_AERCLOUD_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_VIOLET_AERCLOUDS),
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
        context.register(CRYSTAL_ISLAND_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_CRYSTAL_ISLANDS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.CRYSTAL_ISLAND)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION
        ));
        context.register(WYNDCAPS_CRYSTAL_ISLAND_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_WYNDCAPS_CRYSTAL_ISLANDS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.WYNDCAPS_CRYSTAL_ISLAND)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION
        ));
        context.register(ELEVATED_CRYSTAL_ISLAND_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_ELEVATED_CRYSTAL_ISLANDS),
                HolderSet.direct(placement.getOrThrow(AncientAetherMiscPlacements.ELEVATED_CRYSTAL_ISLAND)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION
        ));

        context.register(REMOVE_QUICKSOIL_SHELF_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.QUICKSOIL_SHELF_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_GRASS_PATCH_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.GRASS_PATCH_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_TALL_GRASS_PATCH_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.TALL_GRASS_PATCH_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_WHITE_FLOWER_PATCH_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.WHITE_FLOWER_PATCH_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_PURPLE_FLOWER_PATCH_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.PURPLE_FLOWER_PATCH_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_SKYROOT_MEADOW_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_MEADOW_TREES),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.SKYROOT_MEADOW_TREES_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_SKYROOT_GROVE_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_GROVE_TREES),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.SKYROOT_GROVE_TREES_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_SKYROOT_FOREST_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_FOREST_TREES),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.SKYROOT_FOREST_TREES_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_SKYROOT_WOODLAND_TREES_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_SKYROOT_WOODLAND_TREES),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.SKYROOT_WOODLAND_TREES_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));
        context.register(REMOVE_CRYSTAL_ISLAND_BIOME_MODIFIER, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                biome.getOrThrow(AetherTags.Biomes.IS_AETHER),
                HolderSet.direct(placement.getOrThrow(AetherPlacedFeatures.CRYSTAL_ISLAND_PLACEMENT)),
                Set.of(GenerationStep.Decoration.values())
        ));

        context.register(AETHER_CAVE_BIOME_MODIFIER, new CarverModifier(
                biome.getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_CAVES),
                carver.getOrThrow(AncientAetherConfiguredCarvers.AETHER_CAVE)
        ));
    }
}