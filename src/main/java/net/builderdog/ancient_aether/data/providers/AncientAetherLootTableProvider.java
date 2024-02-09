package net.builderdog.ancient_aether.data.providers;

import net.builderdog.ancient_aether.data.generators.loot.AncientAetherBlockLoot;
import net.builderdog.ancient_aether.data.generators.loot.AncientAetherEntityLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class AncientAetherLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(AncientAetherBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(AncientAetherEntityLoot::new, LootContextParamSets.ENTITY)
        ));
    }
}