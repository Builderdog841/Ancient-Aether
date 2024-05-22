package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public class AncientAetherSelectorLoot implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> builder) {
        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.IRON_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_BRONZE_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.YELLOW_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.RED_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AncientAetherItems.PINK_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                        .add(LootItem.lootTableItem(AetherItems.AGILITY_CAPE.get()))
                        .add(LootItem.lootTableItem(AetherItems.SWET_CAPE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_SILVER_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_ASCENDING_DAWN.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_RING.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_PENDANT.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_GOLD_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.CHAINMAIL_GLOVES.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_RING.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_PENDANT.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_ANCIENT_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ACCESSORIES_SENTRY_LABORATORY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()).setWeight(8))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_TRIMS_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_TRIMS_MYSTERIOUS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(9))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_TRIMS_MECHANICAL, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(9))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_HOLYSTONE_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(12))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(5))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_GENERIC).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_GENERIC).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_MOSSY_HOLYSTONE_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.BLUE_AERCLOUD.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.VIOLET_AERCLOUD.get()).setWeight(5))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_MYSTERIOUS).setWeight(3))
                        .add(LootItem.lootTableItem(AetherBlocks.GOLDEN_AERCLOUD.get()).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_GENERIC).setWeight(2))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_FROZEN_HOLYSTONE_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(20))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART.get()).setWeight(15))
                        .add(LootItem.lootTableItem(AetherItems.GINGERBREAD_MAN.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.AECHOR_PETAL.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherBlocks.BLUE_AERCLOUD.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.VIOLET_AERCLOUD.get()).setWeight(7))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(7))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(Items.QUARTZ).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_MECHANICAL).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.FESTIVE_GUMMY_SWET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_POISON_BUCKET.get()))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_SENTRY_LABORATORY))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_SENTRY_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(15))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_DART.get()).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(5))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_BRONZE_DUNGEON).setWeight(3))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_BLOCK.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_GUMMY_SWET.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_GENERIC))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_DART_SHOOTER.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_ANGELIC_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(20))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(15))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.AECHOR_PETAL.get()).setWeight(7))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(7))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.GOLDEN_AERCLOUD.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_BLOCK.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_GUMMY_SWET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.SADDLE).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_SILVER_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_GENERIC))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART_SHOOTER.get()))
                        .add(LootItem.lootTableItem(Items.NAME_TAG))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_HELLFIRE_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(15))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(10))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_GUMMY_SWET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_GUMMY_SWET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_BLOCK.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_WATER_BUCKET.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_GOLD_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_GENERIC))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART_SHOOTER.get()))
                        .add(LootItem.lootTableItem(Items.SADDLE))
                        .add(LootItem.lootTableItem(AetherBlocks.ENCHANTED_GRAVITITE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_AEROGETIC_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(7))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AncientAetherItems.FESTIVE_GUMMY_SWET.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_BLOCK.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_ACCESSORIES_ANCIENT_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.SELECTORS_TRIMS_GENERIC))
                        .add(LootItem.lootTableItem(AetherBlocks.ENCHANTED_GRAVITITE.get()))
                ));

        builder.accept(AncientAetherLoot.SELECTORS_GALE_VASE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART.get()).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART_SHOOTER.get()))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_CAPE.get()))
                ));
    }
}