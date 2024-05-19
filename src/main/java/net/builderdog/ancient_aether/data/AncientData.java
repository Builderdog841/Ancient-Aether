package net.builderdog.ancient_aether.data;

import net.builderdog.ancient_aether.data.generators.*;
import net.builderdog.ancient_aether.data.generators.tags.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class AncientData {
    public static void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeClient(), new AncientBlockStateData(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new AncientItemModelData(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new AncientLanguageData(packOutput));
        generator.addProvider(event.includeClient(), new AncientSoundData(packOutput, fileHelper));

        generator.addProvider(event.includeServer(), new AncientAdvancementData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new AncientDataMapData(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), AncientLootTableData.create(packOutput));
        generator.addProvider(event.includeServer(), new AncientRegistrySets(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new AncientRecipeData(packOutput, lookupProvider));

        AncientBlockTagData blockTags = new AncientBlockTagData(packOutput, lookupProvider, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new AncientItemTagData(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new AncientEntityTagData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new AncientBiomeTagData(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new AncientStructureTagData(packOutput, lookupProvider, fileHelper));
    }
}