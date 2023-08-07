package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AncientAetherSurfaceData {

    public static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.QUICKSOIL_DESERT),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.QUICKSOIL_DESERT),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.GILDED_QUICKSOIL_DESERT),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.GILDED_QUICKSOIL_DESERT),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.QUICKSOIL_DUNES),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.QUICKSOIL_DUNES),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true))))
        );
    }
}