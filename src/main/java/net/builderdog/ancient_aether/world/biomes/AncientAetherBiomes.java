package net.builderdog.ancient_aether.world.biomes;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientAetherBiomes {

    //Highland
    public static final ResourceKey<Biome> WYNDCAP_TAIGA = createKey("wyndcap_taiga");
    public static final ResourceKey<Biome> FESTIVE_WYNDCAP_TAIGA = createKey("festive_wyndcap_taiga");
    public static final ResourceKey<Biome> WYNDCAP_HIGHLAND = createKey("wyndcap_highland");
    public static final ResourceKey<Biome> WYNDCAP_PEAKS = createKey("wyndcap_peaks");

    //Cave Biomes
    public static final ResourceKey<Biome> AEROGEL_CAVES = createKey("aerogel_caves");
    public static final ResourceKey<Biome> OVERGROWN_CAVERNS = createKey("overgrown_caverns");

    //Default Biomes
    public static final ResourceKey<Biome> SKYROOT_PINE_FOREST = createKey("skyroot_pine_forest");
    public static final ResourceKey<Biome> SKYROOT_JUNGLE = createKey("skyroot_jungle");

    //Sakura Jungle
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");

    //Upper Isles
    public static final ResourceKey<Biome> GOLDEN_FOREST = createKey("golden_forest");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}