package net.builderdog.ancient_aether.world.biome;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.AncientFeatureStates;
import net.builderdog.ancient_aether.data.resources.registries.AncientBiomes;
import net.builderdog.ancient_aether.data.resources.registries.AncientNoises;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AncientSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.WYNDCAP_TAIGA, AncientBiomes.FESTIVE_WYNDCAP_TAIGA, AncientBiomes.WYNDCAP_HIGHLAND),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientFeatureStates.FROZEN_AETHER_GRASS_BLOCK))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.ELEVATED_FOREST, AncientBiomes.ELEVATED_CLEARING),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientFeatureStates.PALE_AETHER_GRASS_BLOCK))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.HOLYSTONE_CAVERNS, AncientBiomes.FROZEN_CAVERNS, AncientBiomes.ELEVATED_CAVERNS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.WYNDCAP_PEAKS, AncientBiomes.HOLYSTONE_CAVERNS, AncientBiomes.FROZEN_CAVERNS, AncientBiomes.ELEVATED_CAVERNS),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                ),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.35D, 0.35D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(101), VerticalAnchor.absolute(101)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.39D, 0.39D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(102), VerticalAnchor.absolute(102)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.43D, 0.43D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(103), VerticalAnchor.absolute(103)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.47D, 0.47D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(104), VerticalAnchor.absolute(104)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.5D, 0.5D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(105), VerticalAnchor.absolute(105)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.6D, 0.6D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(106), VerticalAnchor.absolute(106)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.75D, 0.75D)),
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.VALKYRIE_CLAY, -0.2D, 0.2D)),
                                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("valkyrie_clay", VerticalAnchor.absolute(107), VerticalAnchor.absolute(107)), SurfaceRules.state(AncientFeatureStates.VALKYRIE_CLAY))))
                ),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_bottom", VerticalAnchor.absolute(96), VerticalAnchor.absolute(96)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.08D, 0.08D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(97), VerticalAnchor.absolute(97)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.175D, 0.175D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(98), VerticalAnchor.absolute(98)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.25D, 0.25D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(99), VerticalAnchor.absolute(99)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.3D, 0.3D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(100), VerticalAnchor.absolute(100)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.35D, 0.35D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(101), VerticalAnchor.absolute(101)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.39D, 0.39D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(102), VerticalAnchor.absolute(102)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.43D, 0.43D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(103), VerticalAnchor.absolute(103)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.47D, 0.47D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(104), VerticalAnchor.absolute(104)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.5D, 0.5D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(105), VerticalAnchor.absolute(105)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.6D, 0.6D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(106), VerticalAnchor.absolute(106)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -0.75D, 0.75D)),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_layer", VerticalAnchor.absolute(107), VerticalAnchor.absolute(107)), SurfaceRules.state(AetherFeatureStates.AETHER_DIRT)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -1.0D, 1.0D),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("lake_top", VerticalAnchor.absolute(108), VerticalAnchor.absolute(108)), SurfaceRules.state(Blocks.WATER.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.SKY_LAKE),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(AncientNoises.SKYLANDS_AQUIFER, -1.0D, 1.0D),
                                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("above_lake", VerticalAnchor.absolute(256), VerticalAnchor.absolute(256)), SurfaceRules.state(Blocks.AIR.defaultBlockState())))
                )
        );
    }
}