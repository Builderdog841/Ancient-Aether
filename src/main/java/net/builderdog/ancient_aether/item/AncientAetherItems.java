package net.builderdog.ancient_aether.item;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MOD_ID) ;

    public static final RegistryObject<Item> AECHOR_PETAL_ICE_CREAM_BUCKET = ITEMS.register("aechor_petal_ice_cream_bucket",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.8f).build())));
    public static final RegistryObject<Item> CACTUS_FLOWER_PETAL_ICE_CREAM_BUCKET = ITEMS.register("cactus_flower_petal_ice_cream_bucket",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> CACTUS_FLOWER_PETAL = ITEMS.register("cactus_flower_petal",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
