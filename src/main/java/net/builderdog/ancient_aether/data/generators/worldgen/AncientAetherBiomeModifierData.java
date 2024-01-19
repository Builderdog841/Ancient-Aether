package net.builderdog.ancient_aether.data.generators.worldgen;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherMiscPlacements;
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
    public static final ResourceKey<BiomeModifier> VALKYRUM_ORE_BIOME_MODIFIER = createKey("valkyrum_ore_biome_modifier");
    public static final ResourceKey<BiomeModifier> QUICKSOIL_COAST_BIOME_MODIFIER = createKey("quicksoil_coast_biome_modifier");
    public static final ResourceKey<BiomeModifier> VIOLET_AERCLOUD_BIOME_MODIFIER = createKey("violet_aercloud_biome_modifier");
    public static final ResourceKey<BiomeModifier> CLOUDBED_BIOME_MODIFIER = createKey("cloudbed_biome_modifier");

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        context.register(AEROGEL_BLOBS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_AEROGEL_BLOBS),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherOrePlacements.AEROGEL_BLOBS)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(AETHER_QUARTZ_ORE_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_AETHER_QUARTZ_ORE),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherOrePlacements.AETHER_QUARTZ_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(VALKYRUM_ORE_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_VALKYRUM_ORE),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherOrePlacements.VALKYRUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        //context.register(QUICKSOIL_COAST_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.IS_SKYROOT_WITHOUT_JUNGLE),
        //        HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherMisc)),
        //        GenerationStep.Decoration.RAW_GENERATION
        //));
        context.register(VIOLET_AERCLOUD_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_VIOLET_AERCLOUD),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherMiscPlacements.VIOLET_AERCLOUD)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION
        ));
        context.register(CLOUDBED_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(AncientAetherTags.Biomes.HAS_CLOUDBED),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(AncientAetherMiscPlacements.CLOUDBED)),
                GenerationStep.Decoration.RAW_GENERATION
        ));
    }
}