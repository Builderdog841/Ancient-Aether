package net.builderdog.ancient_aether.world.biomes;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientAetherBiomes {

    //HIGHLAND TAIGA
    public static final ResourceKey<Biome> HIGHLAND_TAIGA = createKey("highland_taiga");
    public static final ResourceKey<Biome> FESTIVE_HIGHLAND_TAIGA = createKey("festive_highland_taiga");
    public static final ResourceKey<Biome> HIGHLAND_CLEARING = createKey("highland_clearing");

    //CAVE BIOMES
    public static final ResourceKey<Biome> AEROGEL_CAVES = createKey("aerogel_caves");

    //SAKURA JUNGLE
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");
    public static final ResourceKey<Biome> SPARSE_SAKURA_JUNGLE = createKey("sparse_sakura_jungle");
    public static final ResourceKey<Biome> OVERGROWN_CAVERNS = createKey("overgrown_caverns");

    //WYNDCAPS
    public static final ResourceKey<Biome> QUICKSOIL_DESERT = createKey("quicksoil_desert");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}