package net.builderdog.ancient_aether.data.resources;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class AncientAetherLoot {
    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();

    public static final ResourceLocation ENTITIES_FLUFFALO_SHEARED = register("entities/fluffalo_sheared");
    public static final ResourceLocation CHESTS_CAMP_GENERIC = register("chests/camp_generic");
    public static final ResourceLocation CHESTS_CAMP_SKYROOT = register("chests/camp_skyroot");
    public static final ResourceLocation CHESTS_CAMP_WYNDCAPS = register("chests/camp_wyndcaps");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_GENERIC = register("chests/settlement_skyroot_generic");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_SHOP = register("chests/settlement_skyroot_shop");
    public static final ResourceLocation CHESTS_SETTLEMENT_SKYROOT_LIBRARY = register("chests/settlement_skyroot_library");
    public static final ResourceLocation CHESTS_SETTLEMENT_SECRET = register("chests/settlement_secret");
    public static final ResourceLocation CHESTS_DUNGEON_ARMOR_TRIMS = register("chests/dungeon/armor_trims");
    public static final ResourceLocation CHESTS_DUNGEON_MOA_EGGS_COMMON = register("chests/dungeon/moa_eggs_common");
    public static final ResourceLocation CHESTS_DUNGEON_MOA_EGGS_UNCOMMON = register("chests/dungeon/moa_eggs_uncommon");
    public static final ResourceLocation CHESTS_DUNGEON_MOA_EGGS_RARE = register("chests/dungeon/moa_eggs_rare");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON = register("chests/dungeon/bronze/bronze_dungeon");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON_LOOT = register("chests/dungeon/bronze/bronze_dungeon_loot");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON_JUNK = register("chests/dungeon/bronze/bronze_dungeon_supplies");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON_SPECIAL = register("chests/dungeon/bronze/bronze_dungeon_miscellaneous");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON_LIBRARY = register("chests/dungeon/bronze/bronze_dungeon_library");
    public static final ResourceLocation CHESTS_DUNGEON_BRONZE_DUNGEON_REWARD = register("chests/dungeon/bronze/bronze_dungeon_reward");
    public static final ResourceLocation CHESTS_DUNGEON_SENTRY_LABORATORY = register("chests/dungeon/laboratory/sentry_laboratory");
    public static final ResourceLocation CHESTS_DUNGEON_SENTRY_LABORATORY_LOOT = register("chests/dungeon/laboratory/sentry_laboratory_loot");
    public static final ResourceLocation CHESTS_DUNGEON_SENTRY_LABORATORY_SUPPLIES = register("chests/dungeon/laboratory/sentry_laboratory_supplies");
    public static final ResourceLocation CHESTS_DUNGEON_SENTRY_LABORATORY_MISCELLANEOUS = register("chests/dungeon/laboratory/sentry_laboratory_miscellaneous");
    public static final ResourceLocation CHESTS_DUNGEON_SENTRY_LABORATORY_REWARD = register("chests/dungeon/laboratory/sentry_laboratory_reward");
    public static final ResourceLocation CHESTS_DUNGEON_ANCIENT_DUNGEON = register("chests/dungeon/ancient/ancient_dungeon");
    public static final ResourceLocation CHESTS_DUNGEON_ANCIENT_DUNGEON_REWARD = register("chests/dungeon/ancient/ancient_dungeon_reward");
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