package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class AncientAetherChestLoot implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> builder) {

        builder.accept(AncientAetherLoot.CHESTS_ARMOR_TRIMS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_CAMP_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_SHOVEL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_AXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_SHOVEL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_AXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BOAT.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_CHEST_BOAT.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER_HELMET))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE))
                        .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS))
                        .add(LootItem.lootTableItem(Items.LEATHER_BOOTS))
                        .add(LootItem.lootTableItem(AetherItems.LEATHER_GLOVES.get()))
                        .add(LootItem.lootTableItem(Items.SADDLE))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_MILK_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_CAMP_SKYROOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_CAMP_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(Blocks.WHITE_WOOL).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_CAMP_WYNDCAPS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_CAMP_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.FLUFFALO_WOOL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                )
        );
    }
}