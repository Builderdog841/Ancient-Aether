package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientBiomes {
    public static final ResourceKey<Biome> SUN_FOREST = createKey("sun_forest");
    public static final ResourceKey<Biome> WYNDCAP_TAIGA = createKey("wyndcap_taiga");
    public static final ResourceKey<Biome> FESTIVE_WYNDCAP_TAIGA = createKey("festive_wyndcap_taiga");
    public static final ResourceKey<Biome> WYNDCAP_HIGHLAND = createKey("wyndcap_highland");
    public static final ResourceKey<Biome> WYNDCAP_PEAKS = createKey("wyndcap_peaks");
    public static final ResourceKey<Biome> SKYROOT_JUNGLE = createKey("skyroot_jungle");
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");
    public static final ResourceKey<Biome> ELEVATED_CLEARING = createKey("elevated_clearing");
    public static final ResourceKey<Biome> ELEVATED_FOREST = createKey("elevated_forest");
    public static final ResourceKey<Biome> SKY_LAKE = createKey("sky_lake");
    public static final ResourceKey<Biome> HOLYSTONE_CAVERNS = createKey("holystone_caverns");
    public static final ResourceKey<Biome> FROZEN_CAVERNS = createKey("frozen_caverns");
    public static final ResourceKey<Biome> ELEVATED_CAVERNS = createKey("elevated_caverns");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MODID, name));
    }
}