package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.registries.AetherDensityFunctions;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientAetherBiomes extends AetherDensityFunctions {

    public static final ResourceKey<Biome> CLOUD_OCEAN = createKey("cloud_ocean");
    public static final ResourceKey<Biome> QUICKSOIL_COAST = createKey("quicksoil_coast");
    public static final ResourceKey<Biome> DIVINE_COAST = createKey("divine_coast");
    public static final ResourceKey<Biome> SNOWY_DIVINE_COAST = createKey("snowy_divine_caoast");
    public static final ResourceKey<Biome> WYNDCAP_TAIGA = createKey("wyndcap_taiga");
    public static final ResourceKey<Biome> FESTIVE_WYNDCAP_TAIGA = createKey("festive_wyndcap_taiga");
    public static final ResourceKey<Biome> WYNDCAP_HIGHLAND = createKey("wyndcap_highland");
    public static final ResourceKey<Biome> WYNDCAP_PEAKS = createKey("wyndcap_peaks");
    public static final ResourceKey<Biome> SKYROOT_JUNGLE = createKey("skyroot_jungle");
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");
    public static final ResourceKey<Biome> MYTHICAL_FOREST = createKey("mythical_forest");
    public static final ResourceKey<Biome> MYTHICAL_CLEARING = createKey("mythical_clearing");
    public static final ResourceKey<Biome> CRYSTAL_HOLLOWS = createKey("crystal_hollows");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}