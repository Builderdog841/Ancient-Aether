package net.builderdog.ancient_aether.data.generators.tags;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AncientAetherItemTagData extends ItemTagsProvider {
    public AncientAetherItemTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper helper) {
        super(output, registries, blockTags, AncientAether.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        copy(AncientAetherTags.Blocks.HIGHSPROOT_LOGS, AncientAetherTags.Items.HIGHSPROOT_LOGS);
        copy(AncientAetherTags.Blocks.SAKURA_LOGS, AncientAetherTags.Items.SAKURA_LOGS);
        copy(AncientAetherTags.Blocks.MOSAIC_BLOCKS, AncientAetherTags.Items.MOSAIC_BLOCKS);
        copy(AncientAetherTags.Blocks.AEROGETIC_BLOCKS, AncientAetherTags.Items.AEROGETIC_BLOCKS);
        copy(AncientAetherTags.Blocks.VASES, AncientAetherTags.Items.VASES);

        tag(AncientAetherTags.Items.WINDBLOWER_INGREDIENTS).add(
                AetherBlocks.BLUE_AERCLOUD.get().asItem(),
                AncientAetherBlocks.VIOLET_AERCLOUD.get().asItem()
        );
        tag(AncientAetherTags.Items.VALKYRUM_REPAIRING).add(
                AncientAetherItems.VALKYRUM.get()
        );
        tag(AncientAetherTags.Items.ARKENZUS_REPAIRING);
        tag(AncientAetherTags.Items.ANCIENT_REPAIRING);
        tag(AncientAetherTags.Items.FLUFFALO_TEMPTATION_ITEMS).add(
                AncientAetherBlocks.WYND_THISTLE.get().asItem()
        );
        tag(AncientAetherTags.Items.COMMON_LOOT).add(
                AetherItems.HAMMER_OF_KINGBDOGZ.get(),
                AetherItems.LIGHTNING_KNIFE.get(),
                AetherItems.BLUE_GUMMY_SWET.get(),
                AetherItems.GOLDEN_GUMMY_SWET.get(),
                AetherItems.AGILITY_CAPE.get(),
                AetherItems.SWET_CAPE.get(),
                AetherItems.CLOUD_STAFF.get(),
                AncientAetherItems.FESTIVE_GUMMY_SWET.get(),
                AncientAetherItems.HERMES_RING.get(),
                AncientAetherItems.HERMES_PENDANT.get()
        );
        tag(AncientAetherTags.Items.RARE_LOOT).add(
                AetherItems.FLAMING_SWORD.get(),
                AetherItems.LIGHTNING_SWORD.get(),
                AetherItems.HOLY_SWORD.get(),
                AetherItems.CANDY_CANE_SWORD.get(),
                AetherItems.PHOENIX_BOW.get(),
                AetherItems.NEPTUNE_CHESTPLATE.get(),
                AetherItems.NEPTUNE_LEGGINGS.get(),
                AetherItems.NEPTUNE_BOOTS.get(),
                AetherItems.NEPTUNE_GLOVES.get(),
                AetherItems.SENTRY_BOOTS.get(),
                AetherItems.VALKYRIE_CAPE.get(),
                AetherItems.GOLDEN_FEATHER.get(),
                AetherItems.IRON_BUBBLE.get(),
                AetherItems.SHIELD_OF_REPULSION.get(),
                AncientAetherItems.AERONAUTIC_DART_SHOOTER.get(),
                AncientAetherItems.ANCIENT_RING.get(),
                AncientAetherItems.ARKENIUM_PENDANT.get(),
                AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()
        );
        tag(AncientAetherTags.Items.EPIC_LOOT).add(
                AetherItems.VAMPIRE_BLADE.get(),
                AetherItems.PIG_SLAYER.get(),
                AetherItems.PHOENIX_HELMET.get(),
                AetherItems.PHOENIX_CHESTPLATE.get(),
                AetherItems.PHOENIX_LEGGINGS.get(),
                AetherItems.PHOENIX_BOOTS.get(),
                AetherItems.PHOENIX_GLOVES.get(),
                AetherItems.INVISIBILITY_CLOAK.get(),
                AetherItems.REGENERATION_STONE.get(),
                AncientAetherItems.ARKENZUS_PICKAXE.get(),
                AncientAetherItems.HEALTH_RING.get(),
                AncientAetherItems.HEALTH_PENDANT.get(),
                AncientAetherItems.ANCIENT_RING.get(),
                AncientAetherItems.ANCIENT_PENDANT.get(),
                AncientAetherItems.STRENGTH_STONE.get(),
                AncientAetherItems.SHIELD_OF_INEBRIATION.get(),
                AncientAetherItems.SHIELD_OF_REMEDIATION.get(),
                AncientAetherItems.MYSTERIOUS_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.MOSAIC_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.ROYAL_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.SOLAR_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                AncientAetherItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get()
        );
        tag(AncientAetherTags.Items.MYTHIC_LOOT).add(
                AetherItems.OBSIDIAN_HELMET.get(),
                AetherItems.OBSIDIAN_CHESTPLATE.get(),
                AetherItems.OBSIDIAN_LEGGINGS.get(),
                AetherItems.OBSIDIAN_BOOTS.get(),
                AetherItems.OBSIDIAN_GLOVES.get(),
                AetherItems.LIFE_SHARD.get(),
                AncientAetherItems.ANCIENT_SWORD.get()
        );
    }
}