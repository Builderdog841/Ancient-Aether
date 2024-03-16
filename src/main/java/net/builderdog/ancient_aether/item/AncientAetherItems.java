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
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.item.equipment.AncientAetherArmorTiers;
import net.builderdog.ancient_aether.item.equipment.accessories.miscellaneous.StrengthStoneItem;
import net.builderdog.ancient_aether.item.equipment.accessories.pendants.*;
import net.builderdog.ancient_aether.item.equipment.accessories.rings.*;
import net.builderdog.ancient_aether.item.equipment.accessories.shields.ShieldOfInebriationItem;
import net.builderdog.ancient_aether.item.equipment.accessories.shields.ShieldOfRemediationItem;
import net.builderdog.ancient_aether.item.equipment.armor.AncientAetherArmorItem;
import net.builderdog.ancient_aether.item.equipment.tools.arkenzus.ArkenzusPickaxeItem;
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
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MODID);

    public static final Component COMMON = Component.translatable("tooltip.ancient_aether.common").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY));
    public static final Component RARE = Component.translatable("tooltip.ancient_aether.rare").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.AQUA));
    public static final Component EPIC = Component.translatable("tooltip.ancient_aether.epic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.DARK_PURPLE));
    public static final Component MYTHIC = Component.translatable("tooltip.ancient_aether.mythic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GOLD));

    public static final RegistryObject<Item> VALKYRUM = ITEMS.register("valkyrum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new ItemNameBlockItem(AncientAetherBlocks.GRAPE_VINE.get(), (new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build()))));
    public static final RegistryObject<Item> FESTIVE_GUMMY_SWET = ITEMS.register("festive_gummy_swet", GummySwetItem::new);

    public static final RegistryObject<SwordItem> VALKYRUM_SWORD = ITEMS.register("valkyrum_sword", ValkyrumSwordItem::new);
    public static final RegistryObject<SwordItem> VALKYRUM_LANCE = ITEMS.register("valkyrum_lance", ValkyrumLanceItem::new);
    public static final RegistryObject<PickaxeItem> VALKYRUM_PICKAXE = ITEMS.register("valkyrum_pickaxe", ValkyrumPickaxeItem::new);
    public static final RegistryObject<AxeItem> VALKYRUM_AXE = ITEMS.register("valkyrum_axe", ValkyrumAxeItem::new);
    public static final RegistryObject<ShovelItem> VALKYRUM_SHOVEL = ITEMS.register("valkyrum_shovel", ValkyrumShovelItem::new);
    public static final RegistryObject<HoeItem> VALKYRUM_HOE = ITEMS.register("valkyrum_hoe", ValkyrumHoeItem::new);

    public static final RegistryObject<Item> VALKYRUM_HELMET = ITEMS.register("valkyrum_helmet", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_CHESTPLATE = ITEMS.register("valkyrum_chestplate", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_LEGGINGS = ITEMS.register("valkyrum_leggings", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_BOOTS = ITEMS.register("valkyrum_boots", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_GLOVES = ITEMS.register("valkyrum_gloves", () -> new GlovesItem(AncientAetherArmorTiers.VALKYRUM, 1.0, "valkyrum_gloves", AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, new Item.Properties().stacksTo(1).durability(1561)));

    public static final RegistryObject<SwordItem> ANCIENT_SWORD = ITEMS.register("ancient_sword", AncientSwordItem::new);
    public static final RegistryObject<PickaxeItem> ARKENZUS_PICKAXE = ITEMS.register("arkenzus_pickaxe", ArkenzusPickaxeItem::new);
    public static final RegistryObject<Item> AERONAUTIC_DART_SHOOTER = ITEMS.register("aeronautic_dart_shooter", () -> new AeronauticDartShooterItem(AetherItems.GOLDEN_DART, (new Item.Properties().stacksTo(1))));

    public static final RegistryObject<Item> VALKYRUM_RING = ITEMS.register("valkyrum_ring", () -> new ValkyrumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_RING = ITEMS.register("hermes_ring", () -> new HermesRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_RING = ITEMS.register("arkenium_ring", () -> new ArkeniumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_RING = ITEMS.register("health_ring", () -> new HealthRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_RING = ITEMS.register("ancient_ring", () -> new AncientRingItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VALKYRUM_PENDANT = ITEMS.register("valkyrum_pendant", () -> new ValkyrumPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_PENDANT = ITEMS.register("hermes_pendant", () -> new HermesPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_PENDANT = ITEMS.register("arkenium_pendant", () -> new ArkeniumPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_PENDANT = ITEMS.register("health_pendant", () -> new HealthPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_PENDANT = ITEMS.register("ancient_pendant", () -> new AncientPendantItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PINK_CAPE = ITEMS.register("pink_cape", () -> new CapeItem("pink_cape", new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SHIELD_OF_INEBRIATION = ITEMS.register("shield_of_inebriation", () -> new ShieldOfInebriationItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SHIELD_OF_REMEDIATION = ITEMS.register("shield_of_remediation", () -> new ShieldOfRemediationItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STRENGTH_STONE = ITEMS.register("strength_stone", () -> new StrengthStoneItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WYND_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("wynd_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WYND));
    public static final RegistryObject<Item> WHALE_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("whale_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WHALE));
    public static final RegistryObject<Item> ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ascended_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ASCENDED));
    public static final RegistryObject<Item> MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mysterious_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MYSTERIOUS));
    public static final RegistryObject<Item> MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mechanical_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MECHANICAL));
    public static final RegistryObject<Item> MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mosaic_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MOSAIC));
    public static final RegistryObject<Item> ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("royal_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ROYAL));
    public static final RegistryObject<Item> SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("solar_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.SOLAR));
    public static final RegistryObject<Item> ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ancient_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ANCIENT));

    public static final RegistryObject<Item> ANCIENT_RUNE = ITEMS.register("ancient_rune", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LABORATORY_DUNGEON_KEY = ITEMS.register("laboratory_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MODID, "laboratory"), new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> ANCIENT_DUNGEON_KEY = ITEMS.register("ancient_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MODID, "ancient"), new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> HIGHSPROOT_SIGN = ITEMS.register("highsproot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get()));
    public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()));
    public static final RegistryObject<Item> HIGHSPROOT_HANGING_SIGN = ITEMS.register("highsproot_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SAKURA_HANGING_SIGN = ITEMS.register("sakura_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HIGHSPROOT_BOAT = ITEMS.register("highsproot_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> HIGHSPROOT_CHEST_BOAT = ITEMS.register("highsproot_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));
    public static final RegistryObject<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));

    public static final RegistryObject<Item> TURQUOISE_MOA_EGG = ITEMS.register("turquoise_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TURQUOISE, 0xD2DDB3, new Item.Properties()));
    public static final RegistryObject<Item> TEAL_MOA_EGG = ITEMS.register("teal_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TEAL, 0x85A3A5, new Item.Properties()));
    public static final RegistryObject<Item> SKY_BLUE_MOA_EGG = ITEMS.register("sky_blue_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SKY_BLUE, 0xABD1DA, new Item.Properties()));
    public static final RegistryObject<Item> LAVENDER_MOA_EGG = ITEMS.register("lavender_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.LAVENDER, 0xBAAED0, new Item.Properties()));
    public static final RegistryObject<Item> SAKURA_MOA_EGG = ITEMS.register("sakura_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SAKURA, 0xD09FA9, new Item.Properties()));
    public static final RegistryObject<Item> VIOLET_MOA_EGG = ITEMS.register("violet_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.VIOLET, 0x6C5A7F, new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_MOA_EGG = ITEMS.register("burgundy_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.BURGUNDY, 0x965C62, new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> FLUFFALO_SPAWN_EGG = ITEMS.register("fluffalo_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntityTypes.FLUFFALO, 0x697B9E, 0xC0CAF7, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> FESTIVE_SWET_SPAWN_EGG = ITEMS.register("festive_swet_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntityTypes.FESTIVE_SWET, 0x29405B, 0xFF6363, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ROOTHYRN_SPAWN_EGG = ITEMS.register("roothyrn_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntityTypes.ROOTHYRN, 0x737558, 0x6FA871, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> AERONAUTIC_LEAPER_SPAWN_EGG = ITEMS.register("aeronautic_leaper_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntityTypes.AERONAUTIC_LEAPER, 0x35343D, 0xB7B2FF, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> MUTATED_AECHOR_PLANT_SPAWN_EGG = ITEMS.register("mutated_aechor_plant_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT, 0x675D82, 0xB9F7CD, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}