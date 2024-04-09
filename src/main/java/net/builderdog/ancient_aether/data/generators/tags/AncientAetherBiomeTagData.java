package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientAetherBiomeTagData extends BiomeTagsProvider {
    public AncientAetherBiomeTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, AncientAether.MODID, helper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientAetherTags.Biomes.IS_SKYROOT_PLAINS).add(
                AetherBiomes.SKYROOT_MEADOW,
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientAetherTags.Biomes.IS_SKYROOT_FOREST).add(
                AetherBiomes.SKYROOT_FOREST,
                AetherBiomes.SKYROOT_WOODLAND
        );
    }
}