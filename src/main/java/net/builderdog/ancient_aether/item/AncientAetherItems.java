package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.accessories.cape.CapeItem;
import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import com.aetherteam.aether.item.food.GummySwetItem;
import com.aetherteam.aether.item.miscellaneous.DungeonKeyItem;
import com.aetherteam.aether.item.miscellaneous.MoaEggItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.passive.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.equipment.AncientAetherArmorTiers;
import net.builderdog.ancient_aether.item.equipment.accessories.*;
import net.builderdog.ancient_aether.item.equipment.armor.AncientAetherArmorItem;
import net.builderdog.ancient_aether.item.equipment.tools.arkzenus.ArkzenusPickaxeItem;
import net.builderdog.ancient_aether.item.equipment.tools.valkyrum.*;
import net.builderdog.ancient_aether.item.equipment.weapons.AeronauticDartShooterItem;
import net.builderdog.ancient_aether.item.equipment.weapons.AncientSwordItem;
import net.builderdog.ancient_aether.item.miscellaneous.AncientAetherBoatItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MOD_ID);

    //Tooltips
    public static final Component COMMON = Component.translatable("ancient_aether.tooltip.common").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY));
    public static final Component RARE = Component.translatable("ancient_aether.tooltip.rare").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.AQUA));
    public static final Component EPIC = Component.translatable("ancient_aether.tooltip.epic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.DARK_PURPLE));
    public static final Component LEGENDARY = Component.translatable("ancient_aether.tooltip.legendary").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GOLD));

    //Misc
    public static final RegistryObject<Item> ANCIENT_RUNE = ITEMS.register("ancient_rune", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ANCIENT_DUNGEON_KEY = ITEMS.register("ancient_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MOD_ID, "ancient"), new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> VALKYRUM = ITEMS.register("valkyrum", () -> new Item(new Item.Properties()));

    //Signs
    public static final RegistryObject<Item> HIGHSPROOT_SIGN = ITEMS.register("highsproot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get()));
    public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()));
    public static final RegistryObject<Item> HIGHSPROOT_HANGING_SIGN = ITEMS.register("highsproot_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SAKURA_HANGING_SIGN = ITEMS.register("sakura_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    //Food
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> FESTIVE_GUMMY_SWET = ITEMS.register("festive_gummy_swet", GummySwetItem::new);

    //Boats
    public static final RegistryObject<Item> HIGHSPROOT_BOAT = ITEMS.register("highsproot_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> HIGHSPROOT_CHEST_BOAT = ITEMS.register("highsproot_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));
    public static final RegistryObject<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));

    //Weapons
    public static final RegistryObject<SwordItem> VALKYRUM_SWORD = ITEMS.register("valkyrum_sword", ValkyrumSwordItem::new);
    public static final RegistryObject<SwordItem> VALKYRUM_LANCE = ITEMS.register("valkyrum_lance", ValkyrumLanceItem::new);
    public static final RegistryObject<SwordItem> ANCIENT_SWORD = ITEMS.register("ancient_sword", AncientSwordItem::new);
    public static final RegistryObject<Item> AERONAUTIC_DART_SHOOTER = ITEMS.register("aeronautic_dart_shooter", () -> new AeronauticDartShooterItem(AetherItems.GOLDEN_DART, (new Item.Properties().stacksTo(1))));

    //Tools
    public static final RegistryObject<PickaxeItem> VALKYRUM_PICKAXE = ITEMS.register("valkyrum_pickaxe", ValkyrumPickaxeItem::new);
    public static final RegistryObject<AxeItem> VALKYRUM_AXE = ITEMS.register("valkyrum_axe", ValkyrumAxeItem::new);
    public static final RegistryObject<ShovelItem> VALKYRUM_SHOVEL = ITEMS.register("valkyrum_shovel", ValkyrumShovelItem::new);
    public static final RegistryObject<HoeItem> VALKYRUM_HOE = ITEMS.register("valkyrum_hoe", ValkyrumHoeItem::new);
    public static final RegistryObject<PickaxeItem> ARKZENUS_PICKAXE = ITEMS.register("arkzenus_pickaxe", ArkzenusPickaxeItem::new);

    //Armor
    public static final RegistryObject<Item> VALKYRUM_HELMET = ITEMS.register("valkyrum_helmet", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_CHESTPLATE = ITEMS.register("valkyrum_chestplate", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_LEGGINGS = ITEMS.register("valkyrum_leggings", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_BOOTS = ITEMS.register("valkyrum_boots", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_GLOVES = ITEMS.register("valkyrum_gloves", () -> new GlovesItem(AncientAetherArmorTiers.VALKYRUM, 1.0, "valkyrum_gloves", AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, new Item.Properties().stacksTo(1).durability(1561)));

    //Accessories
    public static final RegistryObject<Item> ANCIENT_RING = ITEMS.register("ancient_ring", () -> new AncientRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_PENDANT = ITEMS.register("ancient_pendant", () -> new AncientPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_RING = ITEMS.register("health_ring", () -> new HealthRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_PENDANT = ITEMS.register("health_pendant", () -> new HealthPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_RING = ITEMS.register("hermes_ring", () -> new HermesRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_PENDANT = ITEMS.register("hermes_pendant", () -> new HermesPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_RING = ITEMS.register("arkenium_ring", () -> new ArkeniumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_PENDANT = ITEMS.register("arkenium_pendant", () -> new ArkeniumPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VALKYRUM_RING = ITEMS.register("valkyrum_ring", () -> new ValkyrumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VALKYRUM_PENDANT = ITEMS.register("valkyrum_pendant", () -> new ValkyrumPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STRENGTH_STONE = ITEMS.register("strength_stone", () -> new StrengthStoneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PINK_CAPE = ITEMS.register("pink_cape", () -> new CapeItem("pink_cape", new Item.Properties().stacksTo(1)));

    //Moa Eggs
    public static final RegistryObject<Item> BURGUNDY_MOA_EGG = ITEMS.register("burgundy_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.BURGUNDY, 0x965C62, new Item.Properties()));
    public static final RegistryObject<Item> TURQUOISE_MOA_EGG = ITEMS.register("turquoise_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TURQUOISE, 0xD2DDB3, new Item.Properties()));
    public static final RegistryObject<Item> TEAL_MOA_EGG = ITEMS.register("teal_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TEAL, 0x85A3A5, new Item.Properties()));
    public static final RegistryObject<Item> SKY_BLUE_MOA_EGG = ITEMS.register("sky_blue_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SKY_BLUE, 0xABD1DA, new Item.Properties()));
    public static final RegistryObject<Item> LAVENDER_MOA_EGG = ITEMS.register("lavender_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.LAVENDER, 0xBAAED0, new Item.Properties()));
    public static final RegistryObject<Item> SAKURA_MOA_EGG = ITEMS.register("sakura_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SAKURA, 0xD09FA9, new Item.Properties()));
    public static final RegistryObject<Item> VIOLET_MOA_EGG = ITEMS.register("violet_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.VIOLET, 0x6C5A7F, new Item.Properties()));

    //Spawn Eggs
    public static final RegistryObject<SpawnEggItem> FESTIVE_SWET_SPAWN_EGG = ITEMS.register("festive_swet_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.FESTIVE_SWET, 0x29405B, 0xFF6363, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> FLUFFALO_SPAWN_EGG = ITEMS.register("fluffalo_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.FLUFFALO, 0x697B9E, 0xC0CAF7, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ROOTHYRN_SPAWN_EGG = ITEMS.register("roothyrn_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.ROOTHYRN, 0x737558, 0x6FA871, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> AERONAUTIC_LEAPER_SPAWN_EGG = ITEMS.register("aeronautic_leaper_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.AERONAUTIC_LEAPER, 0x35343D, 0xB7B2FF, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ANCIENT_GUARDIAN_SPAWN_EGG = ITEMS.register("ancient_guardian_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.ANCIENT_GUARDIAN, 0xB7B2FF, 0x35343D, new Item.Properties()));

    //Armor Trims
    public static final RegistryObject<Item> WYND_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("wynd_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WYND));
    public static final RegistryObject<Item> WHALE_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("whale_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WHALE));
    public static final RegistryObject<Item> ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ascended_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ASCENDED));
    public static final RegistryObject<Item> MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mysterious_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MYSTERIOUS));
    public static final RegistryObject<Item> MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mechanical_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MECHANICAL));
    public static final RegistryObject<Item> MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mosaic_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MOSAIC));
    public static final RegistryObject<Item> ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("royal_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ROYAL));
    public static final RegistryObject<Item> SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("solar_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.SOLAR));
    public static final RegistryObject<Item> ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ancient_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ANCIENT));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
