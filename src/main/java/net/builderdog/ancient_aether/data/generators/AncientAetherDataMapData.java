package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
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
public class AncientAetherDataMapData extends DataMapProvider {
    public AncientAetherDataMapData(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void gather() {
        var compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
        addCompost(compostables, AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.SKYROOT_PINE_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.BLUE_SKYROOT_PINE_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.HIGHSPROOT_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.SAKURA_LEAVES.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.SKYROOT_PINE_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.BLUE_SKYROOT_PINE_SAPLING.asItem(), 0.3F);
        addCompost(compostables, AncientAetherBlocks.HIGHSPROOT_SAPLING, 0.3F);
        addCompost(compostables, AncientAetherBlocks.SAKURA_SAPLING, 0.3F);
        addCompost(compostables, AncientAetherBlocks.SKY_GRASS, 0.3F);
        addCompost(compostables, AncientAetherItems.GRAPES, 0.5F);
        addCompost(compostables, AncientAetherBlocks.SUNSET_ROSE, 0.65F);
        addCompost(compostables, AncientAetherBlocks.SKY_BLUES, 0.65F);
        addCompost(compostables, AncientAetherBlocks.WYND_THISTLE, 0.65F);
        addCompost(compostables, AncientAetherBlocks.ELEVETIA, 0.65F);
        addCompost(compostables, AncientAetherItems.SLAMMBERRY, 0.85F);

        var fuels = builder(NeoForgeDataMaps.FURNACE_FUELS);
        fuels.add(AncientAetherBlocks.HIGHSPROOT_PLANKS.asItem().builtInRegistryHolder(), new FurnaceFuel(300), false);
        fuels.add(AncientAetherBlocks.SAKURA_PLANKS.asItem().builtInRegistryHolder(), new FurnaceFuel(300), false);
    }

    private void addCompost(Builder<Compostable, Item> map, ItemLike item, float chance) {
        map.add(item.asItem().builtInRegistryHolder(), new Compostable(chance), false);
    }
}