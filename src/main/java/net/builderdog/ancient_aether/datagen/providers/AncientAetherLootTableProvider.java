package net.builderdog.ancient_aether.datagen.providers;

import net.builderdog.ancient_aether.datagen.generators.loot.AncientAetherBlockLootTableData;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class AncientAetherLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(AncientAetherBlockLootTableData::new, LootContextParamSets.BLOCK)));
    }
}
