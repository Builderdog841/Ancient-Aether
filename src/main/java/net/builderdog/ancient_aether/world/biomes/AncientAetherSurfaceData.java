package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.AetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.fml.ModList;

public class AncientAetherSurfaceData {

    public static SurfaceRules.RuleSource makeRules() {
        if (!ModList.get().isLoaded("deep_aether")) {
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
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
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                    )
            );
        } else {
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                                            SurfaceRules.state(Blocks.POWDER_SNOW.defaultBlockState())))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_PEAKS),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.WYNDCAP_TAIGA, AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA, AncientAetherBiomes.WYNDCAP_HIGHLAND),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherFeatureStates.FROZEN_AETHER_GRASS_BLOCK))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.ELEVATED_FOREST, AncientAetherBiomes.ELEVATED_CLEARING,
                                    ResourceKey.create(Registries.BIOME, new ResourceLocation("deep_aether", "aerglow_forest")),
                                    ResourceKey.create(Registries.BIOME, new ResourceLocation("deep_aether", "blue_aerglow_forest")),
                                    ResourceKey.create(Registries.BIOME, new ResourceLocation("deep_aether", "mystic_aerglow_forest"))),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AncientAetherFeatureStates.PALE_AETHER_GRASS_BLOCK))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS),
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                    ),
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherFeatureStates.HOLYSTONE))
                    )
            );
        }
    }
}