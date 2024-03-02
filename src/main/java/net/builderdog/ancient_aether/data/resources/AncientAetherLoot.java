package net.builderdog.ancient_aether.data.resources;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class AncientAetherLoot {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();

    public static final ResourceLocation HOLYSTONE_VASE_LOOT = register("selectors/holystone_vase_loot");
    public static final ResourceLocation MOSSY_HOLYSTONE_VASE_LOOT = register("selectors/mossy_holystone_vase_loot");
    public static final ResourceLocation FROZEN_HOLYSTONE_VASE_LOOT = register("selectors/frozen_holystone_vase_loot");
    public static final ResourceLocation SENTRY_VASE_LOOT = register("selectors/sentry_vase_loot");
    public static final ResourceLocation ANGELIC_VASE_LOOT = register("selectors/angelic_vase_loot");
    public static final ResourceLocation HELLFIRE_VASE_LOOT = register("selectors/hellfire_vase_loot");
    public static final ResourceLocation AEROGETIC_VASE_LOOT = register("selectors/aerogetic_vase_loot");
    public static final ResourceLocation GALE_VASE_LOOT = register("selectors/gale_vase_loot");
    public static final ResourceLocation ACCESSORIES_GENERIC = register("selectors/accessories/generic");
    public static final ResourceLocation ACCESSORIES_BRONZE_DUNGEON = register("selectors/accessories/bronze_dungeon");
    public static final ResourceLocation ACCESSORIES_SILVER_DUNGEON = register("selectors/accessories/silver_dungeon");
    public static final ResourceLocation ACCESSORIES_GOLD_DUNGEON = register("selectors/accessories/gold_dungeon");
    public static final ResourceLocation ACCESSORIES_ANCIENT_DUNGEON = register("selectors/accessories/ancient_dungeon");
    public static final ResourceLocation ACCESSORIES_SENTRY_LABORATORY = register("selectors/accessories/sentry_laboratory");
    public static final ResourceLocation TRIMS_GENERIC = register("selectors/trims/generic");
    public static final ResourceLocation TRIMS_MYSTERIOUS = register("selectors/trims/mysterious");
    public static final ResourceLocation TRIMS_MECHANICAL = register("selectors/trims/mechanical");
    public static final ResourceLocation ENTITIES_FLUFFALO_SHEARED = register("entities/fluffalo_sheared");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(AncientAether.MODID, id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }
}