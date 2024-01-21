package net.builderdog.ancient_aether.data.generators;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.data.generators.worldgen.AncientAetherBiomeModifierData;
import net.builderdog.ancient_aether.data.generators.worldgen.AncientAetherConfiguredCarverData;
import net.builderdog.ancient_aether.data.generators.worldgen.AncientAetherNoiseData;
import net.builderdog.ancient_aether.data.generators.worldgen.features.AncientAetherFeatureUtils;
import net.builderdog.ancient_aether.data.generators.worldgen.placement.AncientAetherPlacementUtils;
import net.builderdog.ancient_aether.mixin.accessor.RegistrySetBuilderAccessor;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class AncientAetherRegistrySets extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder() {
        public HolderLookup.@NotNull Provider buildPatch(@NotNull RegistryAccess registries, HolderLookup.@NotNull Provider lookup) {
            RegistrySetBuilder setBuilder = this;
            BuildState state = ((RegistrySetBuilderAccessor) setBuilder).callCreateState(registries);
            Map<ResourceKey<? extends Registry<?>>, RegistryContents<?>> map = new HashMap<>();
            state.collectReferencedRegistries().forEach((element) -> map.put(element.key(), element));
            ((RegistrySetBuilderAccessor) setBuilder).ancient_aether$getEntries().stream().map((RegistryStub<?> stub) -> stub.collectChanges(state)).forEach((contents) -> map.put(contents.key(), contents));
            Stream<HolderLookup.RegistryLookup<?>> stream = registries.registries().map((entry) -> entry.value().asLookup());
            HolderLookup.Provider provider = HolderLookup.Provider.create(Stream.concat(stream, map.values().stream().map(RegistryContents::buildAsLookup).peek(state::addOwner)));
            state.fillMissingHolders(lookup);
            state.throwOnError();
            return provider;
        }
    }
            .add(Registries.CONFIGURED_FEATURE, AncientAetherFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, AncientAetherPlacementUtils::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, AncientAetherBiomeModifierData::bootstrap)
            .add(Registries.NOISE, AncientAetherNoiseData::bootstrap)
            .add(Registries.CONFIGURED_CARVER, AncientAetherConfiguredCarverData::bootstrap);

    public AncientAetherRegistrySets(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AncientAether.MOD_ID));
    }
}