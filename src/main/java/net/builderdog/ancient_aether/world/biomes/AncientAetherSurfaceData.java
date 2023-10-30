package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.block.AetherBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

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

                //SurfaceRules.ifTrue(SurfaceRules.hole(),
                        SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(80), 80), SurfaceRules.state(AetherBlocks.COLD_AERCLOUD.get().defaultBlockState()))//)
         );
    }
}