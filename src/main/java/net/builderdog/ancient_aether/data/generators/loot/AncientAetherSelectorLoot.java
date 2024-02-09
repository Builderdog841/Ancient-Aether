package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
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
        builder.accept(AncientAetherLoot.HOLYSTONE_VASE_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(15))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_GENERIC).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_GENERIC).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.MOSSY_HOLYSTONE_VASE_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(7))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.BLUE_AERCLOUD.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.VIOLET_AERCLOUD.get()).setWeight(5))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_MYSTERIOUS).setWeight(3))
                        .add(LootItem.lootTableItem(AetherBlocks.GOLDEN_AERCLOUD.get()).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_GENERIC).setWeight(2))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.SENTRY_VASE_LOOT, LootTable.lootTable()
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
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(5))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_BLOCK.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_GUMMY_SWET.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_BRONZE_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_GENERIC).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_DART_SHOOTER.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ANGELIC_VASE_LOOT, LootTable.lootTable()
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
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_SILVER_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_GENERIC).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART_SHOOTER.get()).setWeight(1))
                        .add(LootItem.lootTableItem(Items.NAME_TAG).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.HELLFIRE_VASE_LOOT, LootTable.lootTable()
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
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_GOLD_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_GENERIC).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_DART_SHOOTER.get()).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SADDLE).setWeight(1))
                        .add(LootItem.lootTableItem(AetherBlocks.ENCHANTED_GRAVITITE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.AEROGETIC_VASE_LOOT, LootTable.lootTable()
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
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_ANCIENT_DUNGEON).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_GENERIC).setWeight(1))
                        .add(LootItem.lootTableItem(AetherBlocks.ENCHANTED_GRAVITITE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.FROZEN_HOLYSTONE_VASE_LOOT, LootTable.lootTable()
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
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.TRIMS_MECHANICAL).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.FESTIVE_GUMMY_SWET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_POISON_BUCKET.get()).setWeight(1))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.ACCESSORIES_SENTRY_LABORATORY).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.IRON_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_BRONZE_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.YELLOW_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.RED_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AncientAetherItems.PINK_CAPE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.AGILITY_CAPE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.SWET_CAPE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_SILVER_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.IRON_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_RING.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_PENDANT.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_ASCENDING_DAWN.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_GOLD_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.CHAINMAIL_GLOVES.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_RING.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_PENDANT.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_ANCIENT_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.AERONAUTIC_DART_SHOOTER.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.ACCESSORIES_SENTRY_LABORATORY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()).setWeight(8))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.COLD_PARACHUTE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()).setWeight(1))
                ));

        builder.accept(AncientAetherLoot.TRIMS_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                ));

        builder.accept(AncientAetherLoot.TRIMS_MYSTERIOUS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(9))
                ));

        builder.accept(AncientAetherLoot.TRIMS_MECHANICAL, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.ANCIENT_RUNE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(9))
                ));
    }
}