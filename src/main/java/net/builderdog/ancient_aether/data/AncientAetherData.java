package net.builderdog.ancient_aether.data;

import net.builderdog.ancient_aether.data.generators.*;
import net.builderdog.ancient_aether.data.generators.tags.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class AncientAetherData {
    public static void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeClient(), new AncientAetherBlockStateData(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new AncientAetherItemModelData(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new AncientAetherLanguageData(packOutput));
        generator.addProvider(event.includeClient(), new AncientAetherSoundData(packOutput, fileHelper));

        generator.addProvider(event.includeServer(), new AncientAetherAdvancementData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), AncientAetherLootTableData.create(packOutput));
        generator.addProvider(event.includeServer(), new AncientAetherRegistrySets(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new AncientAetherRecipeData(packOutput));

        AncientAetherBlockTagData blockTags = new AncientAetherBlockTagData(packOutput, lookupProvider, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new AncientAetherItemTagData(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new AncientAetherEntityTagData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new AncientAetherBiomeTagData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new AncientAetherStructureTagData(packOutput, lookupProvider, fileHelper));
    }
}