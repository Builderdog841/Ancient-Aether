package net.builderdog.ancient_aether.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
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
        //Biome stuff here
    }
}
