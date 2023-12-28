package net.builderdog.ancient_aether.mixin;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.builderdog.ancient_aether.world.biomes.AncientAetherBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import teamrazor.deepaether.world.biomes.DABiomes;
import teamrazor.deepaether.world.biomes.DARegion;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;
@Pseudo //make mixin optional
@Mixin(value = DARegion.class, remap = false) //We don't need to remap since deep aether's code isn't obfuscated
public abstract class DARegionMixin extends Region {
    public DARegionMixin(ResourceLocation name, RegionType type, int weight) {
        super(name, type, weight);
    }

    /**
     * @author TunefulTurnip
     * @reason I don't see why any other mod would overwrite redux's region, so we should be fine. Needed to change Deep Aether's default region for better compat.
     */
    @Overwrite
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.5F, 1.5F);
        Climate.Parameter tempWyndcaps = Climate.Parameter.span(-1.5F, -0.5F);
        Climate.Parameter tempSkyroot1 = Climate.Parameter.span(-0.5F, -0.25F);
        Climate.Parameter tempSkyroot2 = Climate.Parameter.span(-0.25F, 0.25F);
        Climate.Parameter tempSkyroot3 = Climate.Parameter.span(0.25F, 0.5F);
        Climate.Parameter tempSakura = Climate.Parameter.span(0.5F, 1.5F);
        Climate.Parameter erosionDefault = Climate.Parameter.span(-1.5F, 0.5F);
        Climate.Parameter erosionElevated = Climate.Parameter.span(0.5F, 1.5F);

        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(-1.5F, 0.25F), fullRange, erosionDefault, Climate.Parameter.span(0.05F, 1.5F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, Climate.Parameter.span(0.05F, 1.5F), fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-0.15F, 0.05F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_HIGHLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempWyndcaps, fullRange, fullRange, erosionDefault, Climate.Parameter.span(-1.5F, -0.15F), fullRange, 0),
                AncientAetherBiomes.WYNDCAP_PEAKS);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot1, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                DABiomes.AERLAVENDER_FIELDS);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-1.5F, -0.2F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(-0.2F, 0F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(0F, 0.2F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot2, Climate.Parameter.span(0.2F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AncientAetherBiomes.SKYROOT_GRASSLAND);

        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-1.5F, -0.1F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(-0.1F, 0.2F), fullRange, erosionDefault, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(tempSkyroot3, Climate.Parameter.span(0.2F, 1.5F), fullRange, erosionDefault, fullRange, fullRange, 0),
                DABiomes.AERLAVENDER_FIELDS);

        addBiome(mapper, new Climate.ParameterPoint(tempSakura, fullRange, fullRange, erosionDefault, fullRange, fullRange, 0),
                DABiomes.YAGROOT_SWAMP);

        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-1.5F, -0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                DABiomes.MYSTIC_AERGLOW_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(-0.25F, 0.25F), fullRange, erosionElevated, fullRange, fullRange, 0),
                DABiomes.AERGLOW_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(fullRange, Climate.Parameter.span(0.25F, 1.5F), fullRange, erosionElevated, fullRange, fullRange, 0),
                DABiomes.BLUE_AERGLOW_FOREST);
    }
}
