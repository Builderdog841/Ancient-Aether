package net.builderdog.ancient_aether.data.generators.worldgen.features;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class AncientAetherOreFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_QUARTZ_ORE = AncientAetherFeatureUtil.registerKey("aether_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VALKYRUM_ORE = AncientAetherFeatureUtil.registerKey("valkyrum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AEROGEL_BLOBS = AncientAetherFeatureUtil.registerKey("aerogel_blobs");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVITY_GRAVEL_ORE = AncientAetherFeatureUtil.registerKey("gravity_gravel_ore");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest holystone = new TagMatchTest(AetherTags.Blocks.HOLYSTONE);

        List<OreConfiguration.TargetBlockState> aetherQuartzOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.AETHER_QUARTZ_ORE.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> aerogelOre = List.of(OreConfiguration.target(holystone, AetherBlocks.AEROGEL.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> gravityGravelOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.GRAVITY_GRAVEL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)));
        List<OreConfiguration.TargetBlockState> valkyrumOre = List.of(OreConfiguration.target(holystone, AncientAetherBlocks.VALKYRUM_ORE.get().defaultBlockState()));

        AncientAetherFeatureUtil.register(context, AETHER_QUARTZ_ORE, Feature.ORE, new OreConfiguration(aetherQuartzOre, 6, 0f));
        AncientAetherFeatureUtil.register(context, GRAVITY_GRAVEL_ORE, Feature.ORE, new OreConfiguration(gravityGravelOre, 64, 0f));
        AncientAetherFeatureUtil.register(context, AEROGEL_BLOBS, Feature.ORE, new OreConfiguration(aerogelOre, 32, 0f));
        AncientAetherFeatureUtil.register(context, VALKYRUM_ORE, Feature.ORE, new OreConfiguration(valkyrumOre, 6, 0.5f));
    }
}