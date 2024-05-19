package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.block.AncientBlocks;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("deprecation")
public class AncientDataMapData extends DataMapProvider {
    public AncientDataMapData(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void gather() {
        var compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
        addCompost(compostables, AncientBlocks.CRYSTAL_SKYROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.ENCHANTED_SKYROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.SKYROOT_PINE_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.BLUE_SKYROOT_PINE_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.HIGHSPROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.SAKURA_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.CRYSTAL_SKYROOT_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.ENCHANTED_SKYROOT_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.SKYROOT_PINE_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientBlocks.HIGHSPROOT_SAPLING, 0.3F);
        addCompost(compostables, AncientBlocks.SAKURA_SAPLING, 0.3F);
        addCompost(compostables, AncientBlocks.SKY_GRASS, 0.3F);
        addCompost(compostables, AncientItems.GRAPES, 0.5F);
        addCompost(compostables, AncientBlocks.SUNSET_ROSE, 0.65F);
        addCompost(compostables, AncientBlocks.SKY_BLUES, 0.65F);
        addCompost(compostables, AncientBlocks.WYND_THISTLE, 0.65F);
        addCompost(compostables, AncientBlocks.ELEVETIA, 0.65F);
        addCompost(compostables, AncientItems.SLAMMBERRY, 0.85F);

        var fuels = builder(NeoForgeDataMaps.FURNACE_FUELS);
        fuels.add(AncientBlocks.HIGHSPROOT_PLANKS.asItem().builtInRegistryHolder(), new FurnaceFuel(300), false);
        fuels.add(AncientBlocks.SAKURA_PLANKS.asItem().builtInRegistryHolder(), new FurnaceFuel(300), false);
    }

    private void addCompost(Builder<Compostable, Item> map, ItemLike item, float chance) {
        map.add(item.asItem().builtInRegistryHolder(), new Compostable(chance), false);
    }
}