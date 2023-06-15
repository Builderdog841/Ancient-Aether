package net.builderdog.aether_crystallium.worldgen.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> QUICKSOIL_DESERT = register("quicksoil_desert");
    public static final ResourceKey<Biome> FROSTPINES = register("frostpines");

    private static ResourceKey<Biome> register(String p_48229_) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(p_48229_));

    }
}