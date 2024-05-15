package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.data.resources.registries.AetherMoaTypes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.data.resources.registries.*;
import net.builderdog.ancient_aether.data.resources.registries.features.AncientAetherFeatureUtils;
import net.builderdog.ancient_aether.data.resources.registries.placement.AncientAetherPlacementUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class AncientAetherRegistrySets extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AncientAetherFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, AncientAetherPlacementUtils::bootstrap)
            .add(Registries.CONFIGURED_CARVER, AncientAetherConfiguredCarvers::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AncientAetherBiomeModifiers::bootstrap)
            .add(Registries.PROCESSOR_LIST, AncientAetherProcessorLists::bootstrap)
            .add(Registries.NOISE, AncientAetherNoises::bootstrap)
            .add(Registries.TRIM_MATERIAL, AncientAetherTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, AncientAetherTrimPatterns::bootstrap)
            .add(AetherMoaTypes.MOA_TYPE_REGISTRY_KEY, AncientAetherMoaTypes::bootstrap);

    public AncientAetherRegistrySets(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(AncientAether.MODID));
    }
}