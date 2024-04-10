package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.Tags;
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
                AetherBiomes.SKYROOT_WOODLAND,
                AncientAetherBiomes.SUN_FOREST,
                AncientAetherBiomes.SKYROOT_JUNGLE
        );
        tag(AncientAetherTags.Biomes.IS_SKYROOT).add(
                AncientAetherBiomes.HOLYSTONE_CAVERNS
                ).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT_PLAINS,
                AncientAetherTags.Biomes.IS_SKYROOT_FOREST
        );
        tag(AncientAetherTags.Biomes.IS_WYNDCAPS).add(
                AncientAetherBiomes.WYNDCAP_TAIGA,
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA,
                AncientAetherBiomes.WYNDCAP_HIGHLAND,
                AncientAetherBiomes.WYNDCAP_PEAKS,
                AncientAetherBiomes.FROZEN_CAVERNS
        );
        tag(AncientAetherTags.Biomes.IS_SAKURA).add(
                AncientAetherBiomes.SAKURA_JUNGLE
        );
        tag(AncientAetherTags.Biomes.IS_ELEVATED).add(
                AncientAetherBiomes.ELEVATED_CLEARING,
                AncientAetherBiomes.ELEVATED_FOREST,
                AncientAetherBiomes.ELEVATED_CAVERNS
        );
        tag(AncientAetherTags.Biomes.IS_AETHER_CAVE).add(
                AncientAetherBiomes.HOLYSTONE_CAVERNS,
                AncientAetherBiomes.FROZEN_CAVERNS,
                AncientAetherBiomes.ELEVATED_CAVERNS,
                AncientAetherBiomes.ATMOSINE_GROTTO
        );
        tag(AncientAetherTags.Biomes.IS_ANCIENT_AETHER_BIOME).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT,
                AncientAetherTags.Biomes.IS_WYNDCAPS,
                AncientAetherTags.Biomes.IS_SAKURA,
                AncientAetherTags.Biomes.IS_ELEVATED,
                AncientAetherTags.Biomes.IS_AETHER_CAVE
        );
        tag(AncientAetherTags.Biomes.HAS_QUICKSOIL_COASTS).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT
        ).remove(
                AncientAetherBiomes.SKYROOT_JUNGLE
        );
        tag(AncientAetherTags.Biomes.HAS_GRAVITY_GRAVEL_COASTS).addTags(
                AncientAetherTags.Biomes.IS_ELEVATED
        );
        tag(AncientAetherTags.Biomes.HAS_WYND_ICE_COASTS).addTags(
                AncientAetherTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientAetherTags.Biomes.HAS_CLOUDBED).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_AETHER_QUARTZ_ORE).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_VALKYRUM_ORE).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_AEROGEL_BLOBS).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_WATER_LAKE_UNDERGROUND).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_MEADOW_TREES).add(
                AetherBiomes.SKYROOT_MEADOW
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_GROVE_TREES).add(
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_FOREST_TREES).add(
                AetherBiomes.SKYROOT_FOREST
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_WOODLAND_TREES).add(
                AetherBiomes.SKYROOT_WOODLAND
        );
        tag(AncientAetherTags.Biomes.HAS_AETHER_GRASS_PATCHES).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT
        ).remove(
                AncientAetherBiomes.SKYROOT_JUNGLE
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_MEADOW_VEGETATION).add(
                AetherBiomes.SKYROOT_MEADOW
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_GROVE_VEGETATION).add(
                AetherBiomes.SKYROOT_GROVE
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_FOREST_VEGETATION).add(
                AetherBiomes.SKYROOT_FOREST
        );
        tag(AncientAetherTags.Biomes.HAS_SKYROOT_WOODLAND_VEGETATION).add(
                AetherBiomes.SKYROOT_WOODLAND
        );
        tag(AncientAetherTags.Biomes.HAS_VIOLET_AERCLOUDS).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_CRYSTAL_ISLANDS).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT,
                AncientAetherTags.Biomes.IS_SAKURA
        );
        tag(AncientAetherTags.Biomes.HAS_WYNDCAPS_CRYSTAL_ISLANDS).addTags(
                AncientAetherTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientAetherTags.Biomes.HAS_ELEVATED_CRYSTAL_ISLANDS).addTags(
                AncientAetherTags.Biomes.IS_ELEVATED
        );
        tag(AncientAetherTags.Biomes.HAS_AETHER_CAVES).addTags(
                AetherTags.Biomes.IS_AETHER
        );
        tag(AncientAetherTags.Biomes.HAS_FROZEN_AETHER_GRASS).addTags(
                AncientAetherTags.Biomes.IS_WYNDCAPS,
                Tags.Biomes.IS_COLD_OVERWORLD
        );
        tag(AncientAetherTags.Biomes.HAS_PALE_AETHER_GRASS).addTags(
                AncientAetherTags.Biomes.IS_ELEVATED,
                Tags.Biomes.IS_DRY_OVERWORLD,
                BiomeTags.IS_NETHER
        );
        tag(AncientAetherTags.Biomes.HAS_ENCHANTED_AETHER_GRASS).add();
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_HOLYSTONE_RUIN).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT_FOREST
        ).remove(
                AncientAetherBiomes.SUN_FOREST
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_MYSTERIOUS_HENGE).addTags(
                AncientAetherTags.Biomes.IS_ELEVATED
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_SUN_WELL).add(
                AncientAetherBiomes.SUN_FOREST
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_VALKYRIE_CAMP_SKYROOT).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT_FOREST
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_VALKYRIE_SETTLEMENT_SKYROOT).addTags(
                AncientAetherTags.Biomes.IS_SKYROOT_PLAINS
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_VALKYRIE_CAMP_WYNDCAPS).addTags(
                AncientAetherTags.Biomes.IS_WYNDCAPS
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_SENTRY_LABORATORY).addTags(
                AncientAetherTags.Biomes.IS_WYNDCAPS
        ).remove(
                AncientAetherBiomes.WYNDCAP_PEAKS
        );
        tag(AncientAetherTags.Biomes.HAS_STRUCTURE_ANCIENT_DUNGEON).addTags(
                AncientAetherTags.Biomes.IS_SAKURA
        );

        tag(AetherTags.Biomes.IS_AETHER).addTags(
                AncientAetherTags.Biomes.IS_ANCIENT_AETHER_BIOME
        );
        tag(AetherTags.Biomes.HAS_BRONZE_DUNGEON).add(
                AncientAetherBiomes.SKYROOT_JUNGLE
        ).addTags(
                AncientAetherTags.Biomes.IS_SAKURA,
                AncientAetherTags.Biomes.IS_AETHER_CAVE
        ).remove(
                AncientAetherBiomes.FROZEN_CAVERNS
        ).replace();
    }
}