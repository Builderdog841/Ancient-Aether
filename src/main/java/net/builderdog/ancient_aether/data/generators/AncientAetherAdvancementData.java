package net.builderdog.ancient_aether.data.generators;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.advancement.ObeliskTrigger;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherBiomes;
import net.builderdog.ancient_aether.data.resources.registries.AncientAetherStructures;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AncientAetherAdvancementData extends ForgeAdvancementProvider {
    public AncientAetherAdvancementData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper helper) {
        super(output, registries, helper, List.of(new AncientAetherAdvancements()));
    }

    public static class AncientAetherAdvancements implements AdvancementGenerator {

        @Override
        public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper) {
            Advancement.Builder.advancement()
                    .parent(new ResourceLocation(Aether.MODID, "black_moa"))
                    .display(AetherItems.SENTRY_BOOTS.get(),
                            Component.translatable("advancement.ancient_aether.aether_biomes"),
                            Component.translatable("advancement.ancient_aether.aether_biomes.desc"),
                            null,
                            FrameType.GOAL, true, true, false)
                    .addCriterion("skyroot_meadow", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AetherBiomes.SKYROOT_MEADOW)))
                    .addCriterion("skyroot_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AetherBiomes.SKYROOT_GROVE)))
                    .addCriterion("skyroot_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AetherBiomes.SKYROOT_FOREST)))
                    .addCriterion("skyroot_woodland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AetherBiomes.SKYROOT_WOODLAND)))
                    .addCriterion("crystal_skyroot_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.CRYSTAL_SKYROOT_GROVE)))
                    .addCriterion("crystal_skyroot_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.CRYSTAL_SKYROOT_FOREST)))
                    .addCriterion("golden_skyroot_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.GOLDEN_SKYROOT_GROVE)))
                    .addCriterion("golden_skyroot_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.GOLDEN_SKYROOT_FOREST)))
                    .addCriterion("golden_thicket", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.GOLDEN_THICKET)))
                    .addCriterion("wyndcap_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.WYNDCAP_TAIGA)))
                    .addCriterion("festive_wyndcap_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA)))
                    .addCriterion("wyndcap_highland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.WYNDCAP_HIGHLAND)))
                    .addCriterion("wyndcap_peaks", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.WYNDCAP_PEAKS)))
                    .addCriterion("skyroot_jungle", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.WYNDCAP_HIGHLAND)))
                    .addCriterion("sakura_jungle", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.WYNDCAP_PEAKS)))
                    .addCriterion("elevated_clearing", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.ELEVATED_CLEARING)))
                    .addCriterion("elevated_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.ELEVATED_FOREST)))
                    .addCriterion("holystone_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.HOLYSTONE_CAVERNS)))
                    .addCriterion("frozen_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.FROZEN_CAVERNS)))
                    .addCriterion("elevated_caverns", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(AncientAetherBiomes.ELEVATED_CAVERNS)))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "aether_biomes"), existingFileHelper);

            Advancement.Builder.advancement()
                    .parent(new ResourceLocation(Aether.MODID, "obtain_egg"))
                    .display(AncientAetherItems.BURGUNDY_MOA_EGG.get(),
                            Component.translatable("advancement.ancient_aether.moa_eggs"),
                            Component.translatable("advancement.ancient_aether.moa_eggs.desc"),
                            null,
                            FrameType.GOAL, true, true, true)
                    .addCriterion("white_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.WHITE_MOA_EGG.get()))
                    .addCriterion("turquoise_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.TURQUOISE_MOA_EGG.get()))
                    .addCriterion("teal_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.TEAL_MOA_EGG.get()))
                    .addCriterion("blue_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.BLUE_MOA_EGG.get()))
                    .addCriterion("sky_blue_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.SKY_BLUE_MOA_EGG.get()))
                    .addCriterion("lavender_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.LAVENDER_MOA_EGG.get()))
                    .addCriterion("sakura_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.SAKURA_MOA_EGG.get()))
                    .addCriterion("violet_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.VIOLET_MOA_EGG.get()))
                    .addCriterion("burgundy_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.BURGUNDY_MOA_EGG.get()))
                    .addCriterion("black_moa_egg", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.BLACK_MOA_EGG.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "moa_eggs"), existingFileHelper);

            Advancement arkenzusPickaxeLoot = Advancement.Builder.advancement()
                    .parent(new ResourceLocation(Aether.MODID, "silver_dungeon"))
                    .display(AncientAetherItems.ARKENZUS_PICKAXE.get(),
                            Component.translatable("advancement.ancient_aether.arkenzus_pickaxe_loot"),
                            Component.translatable("advancement.ancient_aether.arkenzus_pickaxe_loot.desc"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("arkenzus_pickaxe_loot", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.ARKENZUS_PICKAXE.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "arkenzus_pickaxe_loot"), existingFileHelper);

            Advancement valkyrum = Advancement.Builder.advancement()
                    .parent(arkenzusPickaxeLoot)
                    .display(AncientAetherItems.VALKYRUM.get(),
                            Component.translatable("advancement.ancient_aether.valkyrum"),
                            Component.translatable("advancement.ancient_aether.valkyrum.desc"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("valkyrum", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.VALKYRUM.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "valkyrum"), existingFileHelper);

            Advancement.Builder.advancement()
                    .parent(valkyrum)
                    .display(AncientAetherItems.VALKYRUM_LANCE.get(),
                            Component.translatable("advancement.ancient_aether.valkyrum_lance"),
                            Component.translatable("advancement.ancient_aether.valkyrum_lance.desc"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("valkyrum_lance", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.VALKYRUM_LANCE.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "valkyrum_lance"), existingFileHelper);

            Advancement findSentryLaboratory = Advancement.Builder.advancement()
                    .parent(new ResourceLocation(Aether.MODID, "bronze_dungeon"))
                    .display(AncientAetherItems.LABORATORY_DUNGEON_KEY.get(),
                            Component.translatable("advancement.ancient_aether.find_sentry_laboratory"),
                            Component.translatable("advancement.ancient_aether.find_sentry_laboratory.desc"),
                            null,
                            FrameType.GOAL, true, true, false)
                    .addCriterion("sentry_laboratory", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(AncientAetherStructures.SENTRY_LABORATORY)))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "find_sentry_laboratory"), existingFileHelper);

            Advancement.Builder.advancement()
                    .parent(findSentryLaboratory)
                    .display(AncientAetherBlocks.SLIDER_PROTOTYPE.get(),
                            Component.translatable("advancement.ancient_aether.slider_prototype"),
                            Component.translatable("advancement.ancient_aether.slider_prototype.desc"),
                            null,
                            FrameType.GOAL, true, true, true)
                    .addCriterion("slider_prototype", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherBlocks.SLIDER_PROTOTYPE.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "slider_prototype"), existingFileHelper);

            Advancement laboratoryDungeon = Advancement.Builder.advancement()
                    .parent(findSentryLaboratory)
                    .display(AncientAetherItems.LABORATORY_DUNGEON_KEY.get(),
                            Component.translatable("advancement.ancient_aether.laboratory_dungeon"),
                            Component.translatable("advancement.ancient_aether.laboratory_dungeon.desc"),
                            null,
                            FrameType.GOAL, true, true, false)
                    .addCriterion("kill_mutated_aechor_plant", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get())))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "laboratory_dungeon"), existingFileHelper);

            Advancement.Builder.advancement()
                    .parent(laboratoryDungeon)
                    .display(AncientAetherItems.SHIELD_OF_INEBRIATION.get(),
                            Component.translatable("advancement.ancient_aether.shield_accessory_loot"),
                            Component.translatable("advancement.ancient_aether.shield_accessory_loot"),
                            null,
                            FrameType.GOAL, true, true, true)
                    .addCriterion("shield_of_inebriation", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.SHIELD_OF_INEBRIATION.get()))
                    .addCriterion("shield_of_remediation", InventoryChangeTrigger.TriggerInstance.hasItems(AncientAetherItems.SHIELD_OF_REMEDIATION.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "shield_accessory_loot"), existingFileHelper);


            Advancement vampireBlade = Advancement.Builder.advancement()
                    .parent(new ResourceLocation(Aether.MODID, "gold_dungeon"))
                    .display(AetherItems.VAMPIRE_BLADE.get(),
                            Component.translatable("advancement.ancient_aether.vampire_blade_loot"),
                            Component.translatable("advancement.ancient_aether.vampire_blade_loot.desc"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("vampire_blade_loot", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.VAMPIRE_BLADE.get()))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "vampire_blade_loot"), existingFileHelper);

            Advancement.Builder.advancement()
                    .parent(vampireBlade)
                    .display(AncientAetherItems.ANCIENT_RUNE.get(),
                            Component.translatable("advancement.ancient_aether.obelisk"),
                            Component.translatable("advancement.ancient_aether.obelisk.desc"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("obelisk", ObeliskTrigger.Instance.activate())
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "obelisk"), existingFileHelper);

            /*
            [Unimplemented]
            Advancement ancientDungeon = Advancement.Builder.advancement()
                    .parent(obelisk)
                    .display(AncientAetherItems.ANCIENT_DUNGEON_KEY.get(),
                            Component.translatable("advancement.ancient_aether.ancient_dungeon"),
                            Component.translatable("advancement.ancient_aether.ancient_dungeon.desc"),
                            null,
                            FrameType.GOAL, true, true, false)
                    .addCriterion("kill_ancient_dungeon_boss", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(AetherEntityTypes.SLIDER.get())))
                    .save(consumer, new ResourceLocation(AncientAether.MODID, "ancient_dungeon"), existingFileHelper);
             */
        }
    }
}