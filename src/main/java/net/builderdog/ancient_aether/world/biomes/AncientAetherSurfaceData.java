package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
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
                )
                //SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                //        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                //                SurfaceRules.ifTrue(SurfaceRules.steep(),
               //                        SurfaceRules.state(AetherFeatureStates.HOLYSTONE)))
               // ),
                //SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.QUICKSOIL_COAST),
                //        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.QUICKSOIL))
                //),
                //SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.DIVINE_COAST),
                //        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherBlocks.DIVINE_GRAVEL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))
                //),
                //SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.ICY_COAST),
                //        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherBlocks.WYNDCAPS_ICE.get().defaultBlockState()))
                //)
         );
    }
}