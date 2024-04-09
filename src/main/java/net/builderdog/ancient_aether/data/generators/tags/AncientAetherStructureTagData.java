package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherStructures;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientAetherStructureTagData extends StructureTagsProvider {
    public AncientAetherStructureTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, AncientAether.MODID, helper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientAetherTags.Structures.ANCIENT_RUINS).add(
                AncientAetherStructures.HOLYSTONE_RUIN,
                AncientAetherStructures.MYSTERIOUS_HENGE,
                AncientAetherStructures.SUN_WELL
        );
        tag(AncientAetherTags.Structures.VALKYRIE_SETTLEMENTS).add(
                AncientAetherStructures.VALKYRIE_CAMP_SKYROOT,
                AncientAetherStructures.VALKYRIE_CAMP_WYNDCAPS,
                AncientAetherStructures.VALKYRIE_SETTLEMENT_SKYROOT
        );
        tag(AncientAetherTags.Structures.BRONZE_DUNGEONS_AVOID).add(
                AetherStructures.SILVER_DUNGEON,
                AetherStructures.GOLD_DUNGEON
        ).addTags(
                AncientAetherTags.Structures.ANCIENT_RUINS,
                AncientAetherTags.Structures.VALKYRIE_SETTLEMENTS
        );

        tag(AetherTags.Structures.DUNGEONS).addTags(
                AncientAetherTags.Structures.VALKYRIE_SETTLEMENTS
        )
        .remove(
                AetherStructures.BRONZE_DUNGEON
        );
    }
}