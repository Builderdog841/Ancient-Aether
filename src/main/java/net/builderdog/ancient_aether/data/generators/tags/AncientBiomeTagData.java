package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.data.resources.registries.AncientBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientBiomeTagData extends BiomeTagsProvider {
    public AncientBiomeTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper fileHelper) {
        super(output, registries, AncientAether.MODID, fileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientTags.Biomes.IS_SKYROOT_PLAINS).add(
                AetherBiomes.SKYROOT_MEADOW,
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientTags.Biomes.IS_SKYROOT_FOREST).add(
                AetherBiomes.SKYROOT_FOREST,
                AetherBiomes.SKYROOT_WOODLAND,
                AncientBiomes.SUN_FOREST,
                AncientBiomes.SKYROOT_JUNGLE
        );
        tag(AncientTags.Biomes.IS_SKYROOT).add(
                AncientBiomes.SKY_LAKE,
                AncientBiomes.HOLYSTONE_CAVERNS
                ).addTags(
                AncientTags.Biomes.IS_SKYROOT_PLAINS,
                AncientTags.Biomes.IS_SKYROOT_FOREST
        );
        tag(AncientTags.Biomes.IS_WYNDCAPS).add(
                AncientBiomes.WYNDCAP_TAIGA,
                AncientBiomes.FESTIVE_WYNDCAP_TAIGA,
                AncientBiomes.WYNDCAP_HIGHLAND,
                AncientBiomes.WYNDCAP_PEAKS,
                AncientBiomes.FROZEN_CAVERNS
        );
        tag(AncientTags.Biomes.IS_SAKURA).add(
                AncientBiomes.SAKURA_JUNGLE
        );
        tag(AncientTags.Biomes.IS_ELEVATED).add(
                AncientBiomes.ELEVATED_CLEARING,
                AncientBiomes.ELEVATED_FOREST,
                AncientBiomes.ELEVATED_CAVERNS
        );
        tag(AncientTags.Biomes.IS_AETHER_CAVE).add(
                AncientBiomes.HOLYSTONE_CAVERNS,
                AncientBiomes.FROZEN_CAVERNS,
                AncientBiomes.ELEVATED_CAVERNS
        );
        tag(AncientTags.Biomes.IS_ANCIENT_AETHER_BIOME).addTags(
                AncientTags.Biomes.IS_SKYROOT,
                AncientTags.Biomes.IS_WYNDCAPS,
                AncientTags.Biomes.IS_SAKURA,
                AncientTags.Biomes.IS_ELEVATED,
                AncientTags.Biomes.IS_AETHER_CAVE
        );
        tag(AncientTags.Biomes.HAS_QUICKSOIL_COASTS).addTags(
                AncientTags.Biomes.IS_SKYROOT
        ).remove(
                AncientBiomes.SKYROOT_JUNGLE
        );
        tag(AncientTags.Biomes.HAS_GRAVITY_GRAVEL_COASTS).addTags(
                AncientTags.Biomes.IS_ELEVATED
        );
        tag(AncientTags.Biomes.HAS_WYND_ICE_COASTS).addTags(
                AncientTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientTags.Biomes.HAS_CLOUDBED).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_AETHER_QUARTZ_ORE).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_VALKYRUM_ORE).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_AEROGEL_BLOBS).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_WATER_LAKE_UNDERGROUND).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_MEADOW_TREES).add(
                AetherBiomes.SKYROOT_MEADOW
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_GROVE_TREES).add(
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_FOREST_TREES).add(
                AetherBiomes.SKYROOT_FOREST
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_WOODLAND_TREES).add(
                AetherBiomes.SKYROOT_WOODLAND
        );
        tag(AncientTags.Biomes.HAS_AETHER_GRASS_PATCHES).addTags(
                AncientTags.Biomes.IS_SKYROOT
        ).remove(
                AncientBiomes.SKYROOT_JUNGLE
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_MEADOW_VEGETATION).add(
                AetherBiomes.SKYROOT_MEADOW
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_GROVE_VEGETATION).add(
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_FOREST_VEGETATION).add(
                AetherBiomes.SKYROOT_FOREST
        );
        tag(AncientTags.Biomes.HAS_SKYROOT_WOODLAND_VEGETATION).add(
                AetherBiomes.SKYROOT_WOODLAND
        );
        tag(AncientTags.Biomes.HAS_VIOLET_AERCLOUDS).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientTags.Biomes.HAS_CRYSTAL_ISLANDS).addTags(
                AncientTags.Biomes.IS_SKYROOT,
                AncientTags.Biomes.IS_SAKURA
        );
        tag(AncientTags.Biomes.HAS_WYNDCAPS_CRYSTAL_ISLANDS).addTags(
                AncientTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientTags.Biomes.HAS_ELEVATED_CRYSTAL_ISLANDS).addTags(
                AncientTags.Biomes.IS_ELEVATED
        );
        tag(AncientTags.Biomes.HAS_AETHER_CAVES).addTags(
                AncientTags.Biomes.IS_SKYROOT,
                AncientTags.Biomes.IS_WYNDCAPS
        ).remove(
                AncientBiomes.SKYROOT_JUNGLE
        );
        tag(AncientTags.Biomes.HAS_FROZEN_AETHER_GRASS).addTags(
                AncientTags.Biomes.IS_WYNDCAPS,
                Tags.Biomes.IS_COLD_OVERWORLD
        );
        tag(AncientTags.Biomes.HAS_PALE_AETHER_GRASS).addTags(
                AncientTags.Biomes.IS_ELEVATED,
                Tags.Biomes.IS_DRY_OVERWORLD,
                BiomeTags.IS_NETHER
        );
        tag(AncientTags.Biomes.HAS_ENCHANTED_AETHER_GRASS).add();
        tag(AncientTags.Biomes.HAS_STRUCTURE_HOLYSTONE_RUIN).addTags(
                AncientTags.Biomes.IS_SKYROOT_FOREST
        ).remove(
                AncientBiomes.SUN_FOREST
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_MYSTERIOUS_HENGE).addTags(
                AncientTags.Biomes.IS_ELEVATED
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_SUN_WELL).add(
                AncientBiomes.SUN_FOREST
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_VALKYRIE_CAMP_SKYROOT).addTags(
                AncientTags.Biomes.IS_SKYROOT_FOREST
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_VALKYRIE_SETTLEMENT_SKYROOT).addTags(
                AncientTags.Biomes.IS_SKYROOT_PLAINS
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_VALKYRIE_CAMP_WYNDCAPS).addTags(
                AncientTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_SENTRY_LABORATORY).addTags(
                AncientTags.Biomes.IS_WYNDCAPS
        ).remove(
                AncientBiomes.WYNDCAP_PEAKS
        );
        tag(AncientTags.Biomes.HAS_STRUCTURE_ANCIENT_DUNGEON).addTags(
                AncientTags.Biomes.IS_SAKURA
        );

        tag(AetherTags.Biomes.IS_AETHER).addTags(
                AncientTags.Biomes.IS_ANCIENT_AETHER_BIOME
        );
        tag(AetherTags.Biomes.HAS_BRONZE_DUNGEON).add(
                AncientBiomes.SKYROOT_JUNGLE
        ).addTags(
                AncientTags.Biomes.IS_SAKURA,
                AncientTags.Biomes.IS_AETHER_CAVE
        ).remove(
                AncientBiomes.FROZEN_CAVERNS
        ).replace();
    }
}