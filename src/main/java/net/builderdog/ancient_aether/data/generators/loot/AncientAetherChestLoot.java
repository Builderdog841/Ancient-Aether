package net.builderdog.ancient_aether.data.generators.loot;

import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
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
    }
}
