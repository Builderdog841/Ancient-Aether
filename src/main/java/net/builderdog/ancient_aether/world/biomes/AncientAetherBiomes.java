package net.builderdog.ancient_aether.world.biomes;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AncientAetherBiomes {
    public static final ResourceKey<Biome> FROSTY_HIGHLANDS = createKey("frosty_highlands");
    public static final ResourceKey<Biome> QUICKSOIL_DESERT = createKey("quicksoil_desert");
    public static final ResourceKey<Biome> SAKURA_JUNGLE = createKey("sakura_jungle");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}