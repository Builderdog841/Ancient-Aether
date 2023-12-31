package net.builderdog.ancient_aether.datagen.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class AncientAetherLootRegistry {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();

    public static final ResourceLocation ANCIENT_HOLYSTONE_VASE_LOOT = register();

    private static ResourceLocation register() {
        return register(new ResourceLocation(AncientAether.MOD_ID, "selectors/holystone_vase_loot"));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }
}