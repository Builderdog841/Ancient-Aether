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
    public static final ResourceKey<Biome> ICESTONE_CAVERNS = createKey("icestone_caverns");

    //QUICKSOIL DESERT
    public static final ResourceKey<Biome> QUICKSOIL_DESERT = createKey("quicksoil_desert");
    public static final ResourceKey<Biome> QUICKSOIL_DUNES = createKey("quicksoil_dunes");
    public static final ResourceKey<Biome> AEROGEL_CAVES = createKey("aerogel_caves");

    //SAKURA JUNGLE
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");
    public static final ResourceKey<Biome> DEEP_SAKURA_JUNGLE = createKey("deep_sakura_jungle");
    public static final ResourceKey<Biome> SPARSE_SAKURA_JUNGLE = createKey("sparse_sakura_jungle");
    public static final ResourceKey<Biome> OVERGROWN_CAVERNS = createKey("overgrown_caverns");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}