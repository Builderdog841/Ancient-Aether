package net.builderdog.ancient_aether.data.resources;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class AncientAetherLoot {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();

    public static final ResourceLocation ENTITIES_FLUFFALO_SHEARED = register("entities/fluffalo_sheared");
    public static final ResourceLocation CHESTS_ARMOR_TRIMS = register("chests/armor_trims");
    public static final ResourceLocation CHESTS_CAMP_GENERIC = register("chests/camp_generic");
    public static final ResourceLocation CHESTS_CAMP_SKYROOT = register("chests/camp_skyroot");
    public static final ResourceLocation CHESTS_CAMP_WYNDCAPS = register("chests/camp_wyndcaps");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_GENERIC = register("chests/settlement_skyroot_generic");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_SHOP = register("chests/settlement_skyroot_shop");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_LIBRARY = register("chests/settlement_skyroot_library");
    public static final ResourceLocation CHESTS_SETTLEMENT_SECRET = register("chests/settlement_secret");
    public static final ResourceLocation SELECTORS_ACCESSORIES_GENERIC = register("selectors/accessories/generic");
    public static final ResourceLocation SELECTORS_ACCESSORIES_BRONZE_DUNGEON = register("selectors/accessories/bronze_dungeon");
    public static final ResourceLocation SELECTORS_ACCESSORIES_SILVER_DUNGEON = register("selectors/accessories/silver_dungeon");
    public static final ResourceLocation SELECTORS_ACCESSORIES_GOLD_DUNGEON = register("selectors/accessories/gold_dungeon");
    public static final ResourceLocation SELECTORS_ACCESSORIES_ANCIENT_DUNGEON = register("selectors/accessories/ancient_dungeon");
    public static final ResourceLocation SELECTORS_ACCESSORIES_SENTRY_LABORATORY = register("selectors/accessories/sentry_laboratory");
    public static final ResourceLocation SELECTORS_TRIMS_GENERIC = register("selectors/trims/generic");
    public static final ResourceLocation SELECTORS_TRIMS_MYSTERIOUS = register("selectors/trims/mysterious");
    public static final ResourceLocation SELECTORS_TRIMS_MECHANICAL = register("selectors/trims/mechanical");
    public static final ResourceLocation SELECTORS_HOLYSTONE_VASE = register("selectors/holystone_vase");
    public static final ResourceLocation SELECTORS_MOSSY_HOLYSTONE_VASE = register("selectors/mossy_holystone_vase");
    public static final ResourceLocation SELECTORS_FROZEN_HOLYSTONE_VASE = register("selectors/frozen_holystone_vase");
    public static final ResourceLocation SELECTORS_SENTRY_VASE = register("selectors/sentry_vase");
    public static final ResourceLocation SELECTORS_ANGELIC_VASE = register("selectors/angelic_vase");
    public static final ResourceLocation SELECTORS_HELLFIRE_VASE = register("selectors/hellfire_vase");
    public static final ResourceLocation SELECTORS_AEROGETIC_VASE = register("selectors/aerogetic_vase");
    public static final ResourceLocation SELECTORS_GALE_VASE = register("selectors/gale_vase");

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