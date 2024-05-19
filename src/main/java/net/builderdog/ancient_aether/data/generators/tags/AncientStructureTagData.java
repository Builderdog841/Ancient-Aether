package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherStructures;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.data.resources.registries.AncientStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientStructureTagData extends StructureTagsProvider {
    public AncientStructureTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper fileHelper) {
        super(output, registries, AncientAether.MODID, fileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientTags.Structures.ANCIENT_RUINS).add(
                AncientStructures.HOLYSTONE_RUIN,
                AncientStructures.MYSTERIOUS_HENGE,
                AncientStructures.SUN_WELL
        );
        tag(AncientTags.Structures.VALKYRIE_SETTLEMENTS).add(
                AncientStructures.VALKYRIE_CAMP_SKYROOT,
                AncientStructures.VALKYRIE_CAMP_WYNDCAPS,
                AncientStructures.VALKYRIE_SETTLEMENT_SKYROOT
        );
        tag(AncientTags.Structures.BRONZE_DUNGEONS_AVOID).add(
                AetherStructures.SILVER_DUNGEON,
                AetherStructures.GOLD_DUNGEON
        ).addTags(
                AncientTags.Structures.ANCIENT_RUINS,
                AncientTags.Structures.VALKYRIE_SETTLEMENTS
        );

        tag(AetherTags.Structures.DUNGEONS).addTags(
                AncientTags.Structures.VALKYRIE_SETTLEMENTS
        )
        .remove(
                AetherStructures.BRONZE_DUNGEON
        );
    }
}