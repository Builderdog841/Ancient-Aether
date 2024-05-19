package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.data.resources.registries.AetherMoaTypes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.data.resources.registries.*;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientFeatureUtils;
import net.builderdog.ancient_aether.data.resources.registries.placement.AncientPlacementUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class AncientRegistrySets extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AncientFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, AncientPlacementUtils::bootstrap)
            .add(Registries.CONFIGURED_CARVER, AncientCarvers::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AncientBiomeModifiers::bootstrap)
            .add(Registries.PROCESSOR_LIST, AncientProcessorLists::bootstrap)
            .add(Registries.NOISE, AncientNoises::bootstrap)
            .add(Registries.TRIM_MATERIAL, AncientTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, AncientTrimPatterns::bootstrap)
            .add(AetherMoaTypes.MOA_TYPE_REGISTRY_KEY, AncientMoaTypes::bootstrap);

    public AncientRegistrySets(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(AncientAether.MODID));
    }
}