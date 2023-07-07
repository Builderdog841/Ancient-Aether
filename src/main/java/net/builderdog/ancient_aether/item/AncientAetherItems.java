package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
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

    //SPAWN EGGS
    public static final RegistryObject<SpawnEggItem> HIGHLANDS_BUFFALO_SPAWN_EGG = ITEMS.register("highlands_buffalo_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.HIGHLANDS_BUFFALO, 0x4B6F89, 0x96C4D3, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
