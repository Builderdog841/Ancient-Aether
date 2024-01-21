package net.builderdog.ancient_aether.data.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class AncientAetherLootRegistry {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();

    public static final ResourceLocation HOLYSTONE_VASE_LOOT = register("selectors/holystone_vase_loot");
    public static final ResourceLocation MOSSY_HOLYSTONE_VASE_LOOT = register("selectors/mossy_holystone_vase_loot");
    public static final ResourceLocation FROZEN_HOLYSTONE_VASE_LOOT = register("selectors/frozen_holystone_vase_loot");
    public static final ResourceLocation SENTRY_VASE_LOOT = register("selectors/sentry_vase_loot");
    public static final ResourceLocation ANGELIC_VASE_LOOT = register("selectors/angelic_vase_loot");
    public static final ResourceLocation HELLFIRE_VASE_LOOT = register("selectors/hellfire_vase_loot");
    public static final ResourceLocation AEROGETIC_VASE_LOOT = register("selectors/aerogetic_vase_loot");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(AncientAether.MOD_ID, id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }
}