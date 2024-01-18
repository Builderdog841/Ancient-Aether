package net.builderdog.ancient_aether.data.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientAetherBiomeRegistry {

    public static final ResourceKey<Biome> GOLDEN_SKYROOT_GROVE = createKey("golden_skyroot_grove");
    public static final ResourceKey<Biome> CRYSTAL_SKYROOT_GROVE = createKey("crystal_skyroot_grove");
    public static final ResourceKey<Biome> ENCHANTED_SKYROOT_GROVE = createKey("enchanted_skyroot_grove");
    public static final ResourceKey<Biome> GOLDEN_SKYROOT_FOREST = createKey("golden_skyroot_forest");
    public static final ResourceKey<Biome> CRYSTAL_SKYROOT_FOREST = createKey("crystal_skyroot_forest");
    public static final ResourceKey<Biome> ENCHANTED_SKYROOT_FOREST = createKey("enchanted_skyroot_forest");
    public static final ResourceKey<Biome> GOLDEN_THICKET = createKey("golden_thicket");
    public static final ResourceKey<Biome> WYNDCAP_TAIGA = createKey("wyndcap_taiga");
    public static final ResourceKey<Biome> FESTIVE_WYNDCAP_TAIGA = createKey("festive_wyndcap_taiga");
    public static final ResourceKey<Biome> WYNDCAP_HIGHLAND = createKey("wyndcap_highland");
    public static final ResourceKey<Biome> WYNDCAP_PEAKS = createKey("wyndcap_peaks");
    public static final ResourceKey<Biome> SKYROOT_JUNGLE = createKey("skyroot_jungle");
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");
    public static final ResourceKey<Biome> ELEVATED_CLEARING = createKey("elevated_clearing");
    public static final ResourceKey<Biome> ELEVATED_FOREST = createKey("elevated_forest");
    //public static final ResourceKey<Biome> CRYSTAL_GROTTO = createKey("crystal_grotto");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}