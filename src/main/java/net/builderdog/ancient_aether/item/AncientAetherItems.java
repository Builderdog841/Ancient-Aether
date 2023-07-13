package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MOD_ID) ;

    //MATERIALS
    public static final RegistryObject<Item> CACTUS_FLOWER_PETAL = ITEMS.register("cactus_flower_petal",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    //MISC
    public static final RegistryObject<Item> ENCHANTED_SENTRY_RUNE = ITEMS.register("enchanted_sentry_rune",
            () -> new EnchantedSentryRuneItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> BLIGHTED_SENTRY_RUNE = ITEMS.register("blighted_sentry_rune",
            () -> new BlightedSentryRuneItem(new Item.Properties().rarity(Rarity.COMMON)));

    //SIGNS
    public static final RegistryObject<Item> HIGHLANDS_PINE_SIGN = ITEMS.register("highlands_pine_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.HIGHLANDS_PINE_SIGN.get(), AncientAetherBlocks.HIGHLANDS_PINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()));

    //FOOD
    public static final RegistryObject<Item> AECHOR_ICE_CREAM_BUCKET = ITEMS.register("aechor_ice_cream_bucket",
            () -> new AncientAetherIceCreamBucket(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.8f).build())));
    public static final RegistryObject<Item> CACTUS_FLOWER_ICE_CREAM_BUCKET = ITEMS.register("cactus_flower_ice_cream_bucket",
            () -> new AncientAetherIceCreamBucket(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> RAW_BUFFALO_RIBS = ITEMS.register("raw_buffalo_ribs",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).build())));
    public static final RegistryObject<Item> COOKED_BUFFALO_RIBS = ITEMS.register("cooked_buffalo_ribs",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(1.2f).build())));
    public static final RegistryObject<Item> BUFFALO_RIB = ITEMS.register("buffalo_rib",
            () -> new BuffaloRib(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.25f).build())));

    //BOATS
    public static final RegistryObject<Item> HIGHLANDS_PINE_BOAT = ITEMS.register("highlands_pine_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> HIGHLANDS_PINE_CHEST_BOAT = ITEMS.register("highlands_pine_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));
    public static final RegistryObject<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));


    //SPAWN EGGS
    public static final RegistryObject<SpawnEggItem> HIGHLANDS_BUFFALO_SPAWN_EGG = ITEMS.register("highlands_buffalo_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.HIGHLANDS_BUFFALO, 0x4B6F89, 0x96C4D3, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> VELOX_ZEPHYR_SPAWN_EGG = ITEMS.register("velox_zephyr_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.VELOX_ZEPHYR, 0xFFF9D1, 0xBCB484, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
