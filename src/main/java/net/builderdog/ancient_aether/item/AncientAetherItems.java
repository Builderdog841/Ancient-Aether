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
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherTrimPatterns;
import net.builderdog.ancient_aether.effect.AncientAetherEffects;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherBoat;
import net.builderdog.ancient_aether.item.equipment.AncientAetherArmorTiers;
import net.builderdog.ancient_aether.item.equipment.accessories.miscellaneous.StrengthStoneItem;
import net.builderdog.ancient_aether.item.equipment.accessories.pendants.*;
import net.builderdog.ancient_aether.item.equipment.accessories.rings.*;
import net.builderdog.ancient_aether.item.equipment.accessories.shields.ShieldAccessoryItem;
import net.builderdog.ancient_aether.item.equipment.accessories.shields.ShieldOfRemediationItem;
import net.builderdog.ancient_aether.item.equipment.armor.AncientAetherArmorItem;
import net.builderdog.ancient_aether.item.equipment.tools.divine.DivineAxeItem;
import net.builderdog.ancient_aether.item.equipment.tools.divine.DivineHoeItem;
import net.builderdog.ancient_aether.item.equipment.tools.divine.DivinePickaxeItem;
import net.builderdog.ancient_aether.item.equipment.tools.divine.DivineShovelItem;
import net.builderdog.ancient_aether.item.equipment.tools.valkyrum.*;
import net.builderdog.ancient_aether.item.equipment.weapons.AeronauticDartShooterItem;
import net.builderdog.ancient_aether.item.equipment.weapons.AncientSwordItem;
import net.builderdog.ancient_aether.item.miscellaneous.AncientAetherBoatItem;
import net.builderdog.ancient_aether.item.miscellaneous.SlammrootFruitItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AncientAether.MODID);

    public static final Component COMMON = Component.translatable("tooltip.ancient_aether.common").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY));
    public static final Component RARE = Component.translatable("tooltip.ancient_aether.rare").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.AQUA));
    public static final Component EPIC = Component.translatable("tooltip.ancient_aether.epic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.DARK_PURPLE));
    public static final Component MYTHIC = Component.translatable("tooltip.ancient_aether.mythic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GOLD));

    public static final DeferredItem<Item> VALKYRUM = ITEMS.register("valkyrum", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VALKYRIE_CLAY_BALL = ITEMS.register("valkyrie_clay_ball", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VALKYRIE_BRICK = ITEMS.register("valkyrie_brick", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GRAPES = ITEMS.register("grapes", () -> new ItemNameBlockItem(AncientAetherBlocks.GRAPE_VINE.get(), (new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build()))));
    public static final DeferredItem<Item> SLAMMBERRY = ITEMS.register("slammberry", () -> new SlammrootFruitItem(new Item.Properties().food((new FoodProperties.Builder()).alwaysEat().effect(() -> new MobEffectInstance(AncientAetherEffects.NATURES_BOOST.get(), 60, 0), 1.0F).build())));
    public static final DeferredItem<Item> FESTIVE_GUMMY_SWET = ITEMS.register("festive_gummy_swet", GummySwetItem::new);

    public static final DeferredItem<SwordItem> VALKYRUM_SWORD = ITEMS.register("valkyrum_sword", ValkyrumSwordItem::new);
    public static final DeferredItem<SwordItem> VALKYRUM_LANCE = ITEMS.register("valkyrum_lance", ValkyrumLanceItem::new);
    public static final DeferredItem<ShovelItem> VALKYRUM_SHOVEL = ITEMS.register("valkyrum_shovel", ValkyrumShovelItem::new);
    public static final DeferredItem<PickaxeItem> VALKYRUM_PICKAXE = ITEMS.register("valkyrum_pickaxe", ValkyrumPickaxeItem::new);
    public static final DeferredItem<AxeItem> VALKYRUM_AXE = ITEMS.register("valkyrum_axe", ValkyrumAxeItem::new);
    public static final DeferredItem<HoeItem> VALKYRUM_HOE = ITEMS.register("valkyrum_hoe", ValkyrumHoeItem::new);

    public static final DeferredItem<ShovelItem> DIVINE_SHOVEL = ITEMS.register("divine_shovel", DivineShovelItem::new);
    public static final DeferredItem<PickaxeItem> DIVINE_PICKAXE = ITEMS.register("divine_pickaxe", DivinePickaxeItem::new);
    public static final DeferredItem<AxeItem> DIVINE_AXE = ITEMS.register("divine_axe", DivineAxeItem::new);
    public static final DeferredItem<HoeItem> DIVINE_HOE = ITEMS.register("divine_hoe", DivineHoeItem::new);

    public static final DeferredItem<Item> VALKYRUM_HELMET = ITEMS.register("valkyrum_helmet", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> VALKYRUM_CHESTPLATE = ITEMS.register("valkyrum_chestplate", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> VALKYRUM_LEGGINGS = ITEMS.register("valkyrum_leggings", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> VALKYRUM_BOOTS = ITEMS.register("valkyrum_boots", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> VALKYRUM_GLOVES = ITEMS.register("valkyrum_gloves", () -> new GlovesItem(AncientAetherArmorTiers.VALKYRUM, 1.0, "valkyrum_gloves", AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, new Item.Properties().stacksTo(1).durability(1561)));

    public static final DeferredItem<SwordItem> ANCIENT_SWORD = ITEMS.register("ancient_sword", AncientSwordItem::new);
    public static final DeferredItem<Item> AERONAUTIC_DART_SHOOTER = ITEMS.register("aeronautic_dart_shooter", () -> new AeronauticDartShooterItem(AetherItems.GOLDEN_DART, (new Item.Properties().stacksTo(1))));

    public static final DeferredItem<Item> VALKYRUM_RING = ITEMS.register("valkyrum_ring", () -> new ValkyrumRingItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HERMES_RING = ITEMS.register("hermes_ring", () -> new HermesRingItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WARRIOR_RING = ITEMS.register("warrior_ring", () -> new WarriorRingItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GROWTH_RING = ITEMS.register("growth_ring", () -> new GrowthRingItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ANCIENT_RING = ITEMS.register("ancient_ring", () -> new AncientRingItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> VALKYRUM_PENDANT = ITEMS.register("valkyrum_pendant", () -> new ValkyrumPendantItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HERMES_PENDANT = ITEMS.register("hermes_pendant", () -> new HermesPendantItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WARRIOR_PENDANT = ITEMS.register("warrior_pendant", () -> new WarriorPendantItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GROWTH_PENDANT = ITEMS.register("growth_pendant", () -> new GrowthPendantItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ANCIENT_PENDANT = ITEMS.register("ancient_pendant", () -> new AncientPendantItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PINK_CAPE = ITEMS.register("pink_cape", () -> new CapeItem("pink_cape", new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SHIELD_OF_INEBRIATION = ITEMS.register("shield_of_inebriation", () -> new ShieldAccessoryItem(new Item.Properties().stacksTo(1), new ResourceLocation(AncientAether.MODID, "shield_of_inebriation")));
    public static final DeferredItem<Item> SHIELD_OF_REMEDIATION = ITEMS.register("shield_of_remediation", () -> new ShieldOfRemediationItem(new Item.Properties().stacksTo(1), new ResourceLocation(AncientAether.MODID, "shield_of_remediation")));
    public static final DeferredItem<Item> STRENGTH_STONE = ITEMS.register("strength_stone", () -> new StrengthStoneItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> WYND_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("wynd_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WYND));
    public static final DeferredItem<Item> WHALE_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("whale_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.WHALE));
    public static final DeferredItem<Item> ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ascended_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ASCENDED));
    public static final DeferredItem<Item> MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mysterious_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MYSTERIOUS));
    public static final DeferredItem<Item> MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mechanical_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MECHANICAL));
    public static final DeferredItem<Item> MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("mosaic_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.MOSAIC));
    public static final DeferredItem<Item> ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("royal_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ROYAL));
    public static final DeferredItem<Item> SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("solar_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.SOLAR));
    public static final DeferredItem<Item> ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("ancient_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(AncientAetherTrimPatterns.ANCIENT));

    public static final DeferredItem<Item> ANCIENT_RUNE = ITEMS.register("ancient_rune", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LABORATORY_DUNGEON_KEY = ITEMS.register("laboratory_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MODID, "laboratory"), new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> ANCIENT_DUNGEON_KEY = ITEMS.register("ancient_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MODID, "ancient"), new Item.Properties().stacksTo(1).fireResistant()));

    public static final DeferredItem<Item> HIGHSPROOT_BOAT = ITEMS.register("highsproot_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoat.Type.HIGHLANDS_PINE));
    public static final DeferredItem<Item> HIGHSPROOT_CHEST_BOAT = ITEMS.register("highsproot_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoat.Type.HIGHLANDS_PINE));
    public static final DeferredItem<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoat.Type.SAKURA));
    public static final DeferredItem<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoat.Type.SAKURA));

    public static final DeferredItem<Item> TURQUOISE_MOA_EGG = ITEMS.register("turquoise_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TURQUOISE, 0xD2DDB3, new Item.Properties()));
    public static final DeferredItem<Item> TEAL_MOA_EGG = ITEMS.register("teal_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.TEAL, 0x85A3A5, new Item.Properties()));
    public static final DeferredItem<Item> SKY_BLUE_MOA_EGG = ITEMS.register("sky_blue_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SKY_BLUE, 0xABD1DA, new Item.Properties()));
    public static final DeferredItem<Item> LAVENDER_MOA_EGG = ITEMS.register("lavender_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.LAVENDER, 0xBAAED0, new Item.Properties()));
    public static final DeferredItem<Item> SAKURA_MOA_EGG = ITEMS.register("sakura_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SAKURA, 0xD09FA9, new Item.Properties()));
    public static final DeferredItem<Item> VIOLET_MOA_EGG = ITEMS.register("violet_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.VIOLET, 0x6C5A7F, new Item.Properties()));
    public static final DeferredItem<Item> BURGUNDY_MOA_EGG = ITEMS.register("burgundy_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.BURGUNDY, 0x965C62, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> FLUFFALO_SPAWN_EGG = ITEMS.register("fluffalo_spawn_egg", () -> new DeferredSpawnEggItem(AncientAetherEntityTypes.FLUFFALO, 0x697B9E, 0xACCBE5, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> FESTIVE_SWET_SPAWN_EGG = ITEMS.register("festive_swet_spawn_egg", () -> new DeferredSpawnEggItem(AncientAetherEntityTypes.FESTIVE_SWET, 0x29405B, 0xFF6363, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> SLAMMROOT_SPAWN_EGG = ITEMS.register("slammroot_spawn_egg", () -> new DeferredSpawnEggItem(AncientAetherEntityTypes.SLAMMROOT, 0x87856E, 0xCDEAB2, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> AERONAUTIC_LEAPER_SPAWN_EGG = ITEMS.register("aeronautic_leaper_spawn_egg", () -> new DeferredSpawnEggItem(AncientAetherEntityTypes.AERONAUTIC_LEAPER, 0x41404A, 0xB5B0E8, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> MUTATED_AECHOR_PLANT_SPAWN_EGG = ITEMS.register("mutated_aechor_plant_spawn_egg", () -> new DeferredSpawnEggItem(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT, 0x675D82, 0xB9F7CD, new Item.Properties()));
}