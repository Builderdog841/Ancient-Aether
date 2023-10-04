package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class AncientAetherSurfaceData {

    public static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D,0.58D),
                                        SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                ),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                ),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AetherBiomes.SKYROOT_MEADOW, AetherBiomes.SKYROOT_GROVE, AetherBiomes.SKYROOT_FOREST, AetherBiomes.SKYROOT_WOODLAND, AncientAetherBiomes.SKYROOT_PINE_FOREST, AncientAetherBiomes.SKYROOT_JUNGLE),
                       // SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.belowTop(256),256),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.QUICKSOIL)))
                //)
        );
    }
}