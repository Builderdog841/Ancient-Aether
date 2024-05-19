package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.data.generators.loot.AncientBlockLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientChestLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientEntityLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientSelectorLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class AncientLootTableData {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(AncientBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(AncientEntityLoot::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(AncientChestLoot::new, LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(AncientSelectorLoot::new, LootContextParamSets.SELECTOR)
        ));
    }
}