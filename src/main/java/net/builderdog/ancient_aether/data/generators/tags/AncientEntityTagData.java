package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientTags;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientEntityTagData extends EntityTypeTagsProvider {
    public AncientEntityTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper fileHelper) {
        super(output, registries, AncientAether.MODID, fileHelper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientTags.Entities.ACTIVATES_WIND_BLOWER).add(
                AncientEntityTypes.WIND_BLOW.get()
        );

        tag(AetherTags.Entities.DUNGEON_ENTITIES).add(
                AncientEntityTypes.AERONAUTIC_LEAPER.get(),
                AncientEntityTypes.MUTATED_AECHOR_PLANT.get()
        );
        tag(AetherTags.Entities.UNHOOKABLE).add(
                AncientEntityTypes.MUTATED_AECHOR_PLANT.get()
        );
        tag(AetherTags.Entities.UNLAUNCHABLE).add(
                AncientEntityTypes.MUTATED_AECHOR_PLANT.get()
        );

        tag(Tags.EntityTypes.BOSSES).add(
                AncientEntityTypes.MUTATED_AECHOR_PLANT.get()
        );

        tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(
                AncientEntityTypes.SLAMMROOT.get()
        );
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(
                AncientEntityTypes.FLUFFALO.get()
        );
        tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS).add(
                AncientEntityTypes.FLUFFALO.get()
        );
    }
}