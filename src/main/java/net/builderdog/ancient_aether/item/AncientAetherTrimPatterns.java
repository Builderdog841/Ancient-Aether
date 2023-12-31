package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimPattern;

public class AncientAetherTrimPatterns {

    public static final ResourceKey<TrimPattern> WYND = createKey("wynd");
    public static final ResourceKey<TrimPattern> WHALE = createKey("whale");
    public static final ResourceKey<TrimPattern> ASCENDED = createKey("ascended");
    public static final ResourceKey<TrimPattern> MYSTERIOUS = createKey("mysterious");
    public static final ResourceKey<TrimPattern> MECHANICAL = createKey("mechanical");
    public static final ResourceKey<TrimPattern> MOSAIC = createKey("mosaic");
    public static final ResourceKey<TrimPattern> ROYAL = createKey("royal");
    public static final ResourceKey<TrimPattern> SOLAR = createKey("solar");
    public static final ResourceKey<TrimPattern> ANCIENT = createKey("ancient");

    private static ResourceKey<TrimPattern> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(AncientAether.MOD_ID, name));
    }
}