package net.builderdog.ancient_aether.datagen.resources;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.AncientAetherConfiguredFeatures;
import net.builderdog.ancient_aether.world.AncientAetherPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AncientAetherWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AncientAetherConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, AncientAetherPlacedFeatures::bootstrap);


    public AncientAetherWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AncientAether.MOD_ID));
    }
}
