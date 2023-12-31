package net.builderdog.ancient_aether.datagen.providers;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.datagen.generators.AncientAetherConfiguredFeatureData;
import net.builderdog.ancient_aether.datagen.generators.AncientAetherPlacedFeatureData;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AncientAetherWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AncientAetherConfiguredFeatureData::bootstrap)
            .add(Registries.PLACED_FEATURE, AncientAetherPlacedFeatureData::bootstrap);


    public AncientAetherWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AncientAether.MOD_ID));
    }
}
