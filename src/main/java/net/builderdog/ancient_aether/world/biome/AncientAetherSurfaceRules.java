package net.builderdog.ancient_aether.world.biome;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherNoises;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AncientAetherSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_TAIGA, AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA, AncientAetherBiomes.WYNDCAP_HIGHLAND),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherFeatureStates.FROZEN_AETHER_GRASS_BLOCK))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.ELEVATED_FOREST, AncientAetherBiomes.ELEVATED_CLEARING),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherFeatureStates.PALE_AETHER_GRASS_BLOCK))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS, AncientAetherBiomes.FROZEN_CAVERNS, AncientAetherBiomes.ELEVATED_CAVERNS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS, AncientAetherBiomes.HOLYSTONE_CAVERNS, AncientAetherBiomes.FROZEN_CAVERNS, AncientAetherBiomes.ELEVATED_CAVERNS),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                ),

                valkyrieClay(0.35D, 101),
                valkyrieClay(0.39D, 102),
                valkyrieClay(0.43D, 103),
                valkyrieClay(0.47D, 104),
                valkyrieClay(0.5D, 105),
                valkyrieClay(0.6D, 106),
                valkyrieClay(0.75D, 107),

                lakeLayer(0.08D, 97),
                lakeLayer(0.175D, 98),
                lakeLayer(0.25D, 99),
                lakeLayer(0.3D, 100),
                lakeLayer(0.35D, 101),
                lakeLayer(0.39D, 102),
                lakeLayer(0.43D, 103),
                lakeLayer(0.47D, 104),
                lakeLayer(0.5D, 105),
                lakeLayer(0.6D, 106),
                lakeLayer(0.75D, 107),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_bottom", VerticalAnchor.absolute(96), VerticalAnchor.absolute(96)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(AncientAetherNoises.SKYLANDS_AQUIFER, -1.0D, 1.0D),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_top", VerticalAnchor.absolute(108), VerticalAnchor.absolute(108)), SurfaceRules.state(Blocks.WATER.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(AncientAetherNoises.SKYLANDS_AQUIFER, -1.0D, 1.0D),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("above_lake", VerticalAnchor.absolute(256), VerticalAnchor.absolute(256)), SurfaceRules.state(Blocks.AIR.defaultBlockState())))
                )
        );
    }

    public static SurfaceRules.RuleSource valkyrieClay(double noise, int y) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.SKY_LAKE),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientAetherNoises.SKYLANDS_AQUIFER, -noise, noise)),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientAetherNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(y), VerticalAnchor.absolute(y)), SurfaceRules.state(AncientAetherFeatureStates.VALKYRIE_CLAY))))
        );
    }

    public static SurfaceRules.RuleSource lakeLayer(double noise, int y) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.SKY_LAKE),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientAetherNoises.SKYLANDS_AQUIFER, -noise, noise)),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(y), VerticalAnchor.absolute(y)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
        );
    }
}