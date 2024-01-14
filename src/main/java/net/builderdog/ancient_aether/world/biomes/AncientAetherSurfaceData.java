package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.builderdog.ancient_aether.data.registries.AncientAetherBiomeRegistry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class AncientAetherSurfaceData {

    public static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomeRegistry.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D,0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomeRegistry.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomeRegistry.WYNDCAP_TAIGA, AncientAetherBiomeRegistry.FESTIVE_WYNDCAP_TAIGA, AncientAetherBiomeRegistry.WYNDCAP_HIGHLAND),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.AETHER_GRASS_BLOCK.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.FROZEN)))
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomeRegistry.ELEVATED_FOREST, AncientAetherBiomeRegistry.ELEVATED_CLEARING),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.AETHER_GRASS_BLOCK.setValue(AncientAetherBlockStateProperties.TYPE, AetherGrassType.PALE)))
                )
         );
    }
}