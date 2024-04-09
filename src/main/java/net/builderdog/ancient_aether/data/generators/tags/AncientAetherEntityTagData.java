package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientAetherEntityTagData extends EntityTypeTagsProvider {
    public AncientAetherEntityTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, AncientAether.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AncientAetherTags.Entities.ACTIVATES_WIND_BLOWER).add(
                AncientAetherEntityTypes.WIND_BLOW.get()
        );

        tag(AetherTags.Entities.DUNGEON_ENTITIES).add(
                AncientAetherEntityTypes.AERONAUTIC_LEAPER.get(),
                AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get()
        );
        tag(AetherTags.Entities.UNHOOKABLE).add(
                AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get()
        );
        tag(AetherTags.Entities.UNLAUNCHABLE).add(
                AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get()
        );

        tag(Tags.EntityTypes.BOSSES).add(
                AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get()
        );

        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(
                AncientAetherEntityTypes.FLUFFALO.get()
        );
        tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS).add(
                AncientAetherEntityTypes.FLUFFALO.get()
        );
    }
}