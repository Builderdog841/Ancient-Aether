package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.AetherTags;
import net.builderdog.ancient_aether.world.AncientAetherFeatureStates;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class AncientAetherOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AEROGEL_BLOBS = AncientAetherFeatureUtils.registerKey("aerogel_blobs");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYND_ICE_BLOBS = AncientAetherFeatureUtils.registerKey("gravity_gravel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE = AncientAetherFeatureUtils.registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VALKYRUM_ORE = AncientAetherFeatureUtils.registerKey("valkyrum_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);

        List<OreConfiguration.TargetBlockState> aerogelBlobs = List.of(OreConfiguration.target(holystone, AncientAetherFeatureStates.AEROGEL));
        List<OreConfiguration.TargetBlockState> wyndIceBlobs = List.of(OreConfiguration.target(holystone, AncientAetherFeatureStates.WYND_ICE));
        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone, AncientAetherFeatureStates.AETHER_QUARTZ_ORE));
        List<OreConfiguration.TargetBlockState> valkyrumOre = List.of(OreConfiguration.target(holystone, AncientAetherFeatureStates.VALKYRUM_ORE));

        AncientAetherFeatureUtils.register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelBlobs, 32, 0f));
        AncientAetherFeatureUtils.register(context, WYND_ICE_BLOBS, Feature.ORE, new OreConfiguration(wyndIceBlobs, 64, 0f));
        AncientAetherFeatureUtils.register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 16, 0f));
        AncientAetherFeatureUtils.register(context, VALKYRUM_ORE, Feature.ORE, new OreConfiguration(valkyrumOre, 6, 0.5f));
    }
}