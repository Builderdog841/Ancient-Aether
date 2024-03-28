package net.builderdog.ancient_aether.data.resources.registries;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.processor.BossRoomProcessor;
import com.aetherteam.aether.world.processor.DoubleDropsProcessor;
import com.aetherteam.aether.world.processor.SurfaceRuleProcessor;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.AncientAetherTags;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.AncientAetherFeatureStates;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class AncientAetherProcessorLists {
    public static final ResourceKey<StructureProcessorList> HOLYSTONE_RUIN = createKey("holystone_ruin");
    public static final ResourceKey<StructureProcessorList> SOLAR_RUIN = createKey("solar_ruin");
    public static final ResourceKey<StructureProcessorList> MYSTERIOUS_HENGE = createKey("mysterious_henge");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_SKYROOT = createKey("valkyrie_camp_skyroot");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_WYNDCAPS = createKey("valkyrie_camp_wyndcaps");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_SETTLEMENT_SKYROOT = createKey("valkyrie_settlement_skyroot");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_ENTRANCE = createKey("bronze_dungeon_entrance");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON = createKey("bronze_dungeon");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_BOSS_ROOM = createKey("bronze_dungeon_boss_room");
    public static final ResourceKey<StructureProcessorList> ANCIENT_DUNGEON = createKey("ancient_dungeon");
    public static final ResourceKey<StructureProcessorList> SENTRY_LABORATORY = createKey("sentry_laboratory");
    public static final ResourceKey<StructureProcessorList> SENTRY_LABORATORY_BOSS_ROOM = createKey("sentry_laboratory_boss_room");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        register(context, HOLYSTONE_RUIN, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.4F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.5F), AlwaysTrueTest.INSTANCE, AetherBlocks.HOLYSTONE_BRICKS.get().defaultBlockState()),
        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE_BRICKS.get(), 0.05F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE)
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, SOLAR_RUIN, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CYAN_WOOL, 0.8F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.HELLFIRE_STONE_MOSAIC.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), 0.45F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.3F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.LIME_WOOL, 0.15F), AlwaysTrueTest.INSTANCE, AetherBlocks.HELLFIRE_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE_BRICKS.get(), 0.1F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HELLFIRE_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AetherBlocks.LIGHT_HELLFIRE_STONE.get().defaultBlockState()),
                        new ProcessorRule(new BlockMatchTest(Blocks.CYAN_WOOL), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new BlockMatchTest(Blocks.LIME_WOOL), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                )),
                new DoubleDropsProcessor()
        ));
        register(context, MYSTERIOUS_HENGE, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), 0.5F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.ORANGE_WOOL, 0.25F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.2F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new BlockMatchTest(Blocks.ORANGE_WOOL), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, VALKYRIE_CAMP_SKYROOT, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.75F), AlwaysTrueTest.INSTANCE, AetherBlocks.AETHER_DIRT_PATH.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_PURPLE_FLOWER.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_HIGHLAND_CYCLAMEN.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_SKY_BLUES.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_BERRY_BUSH.get().defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, VALKYRIE_CAMP_WYNDCAPS, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.75F), AlwaysTrueTest.INSTANCE, AetherBlocks.AETHER_DIRT_PATH.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.POTTED_WYND_THISTLE.get(), 0.3F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_SKY_BLUES.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.POTTED_WYND_THISTLE.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_BERRY_BUSH.get().defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, VALKYRIE_SETTLEMENT_SKYROOT, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_DIRT_PATH.get(), 0.05F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.AETHER_GRASS_BLOCK),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.4F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE_BRICKS.get(), 0.1F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.BERRY_BUSH_STEM.get(), 0.5F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.BERRY_BUSH),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_PURPLE_FLOWER.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_HIGHLAND_CYCLAMEN.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_SKY_BLUES.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_BERRY_BUSH.get().defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, BRONZE_DUNGEON_ENTRANCE, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.CARVED_STONE.get(), 0.01F), AlwaysTrueTest.INSTANCE, AetherBlocks.SENTRY_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.4F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(), 0.75F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                ))));
        register(context, BRONZE_DUNGEON, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new TagMatchTest(AncientAetherTags.Blocks.BRONZE_DUNGEON_BLOCKS), new BlockMatchTest(Blocks.AIR), Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new TagMatchTest(AncientAetherTags.Blocks.BRONZE_DUNGEON_BLOCKS), new BlockMatchTest(AetherBlocks.COLD_AERCLOUD.get()), AetherBlocks.COLD_AERCLOUD.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.CARVED_STONE.get(), 0.01F), AlwaysTrueTest.INSTANCE, AetherBlocks.SENTRY_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.CARVED_TILES.get(), 0.03F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.TRAPPED_CARVED_TILES.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.4F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_SENTRY_VASE.get(), 0.75F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.3F), AlwaysTrueTest.INSTANCE, AetherBlocks.CHEST_MIMIC.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.4F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                )),
                new DoubleDropsProcessor()
        ));
        register(context, BRONZE_DUNGEON_BOSS_ROOM, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.LOCKED_CARVED_STONE.get(), 0.01F), AlwaysTrueTest.INSTANCE, AetherBlocks.LOCKED_SENTRY_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.TREASURE_DOORWAY_CARVED_STONE.get(), 0.01F), AlwaysTrueTest.INSTANCE, AetherBlocks.TREASURE_DOORWAY_SENTRY_STONE.get().defaultBlockState())
                )),
                new BossRoomProcessor()
        ));
        register(context, SENTRY_LABORATORY, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new TagMatchTest(AncientAetherTags.Blocks.SENTRY_LABORATORY_BLOCKS), new BlockMatchTest(Blocks.AIR), Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new TagMatchTest(AncientAetherTags.Blocks.SENTRY_LABORATORY_BLOCKS), new BlockMatchTest(AetherBlocks.COLD_AERCLOUD.get()), AetherBlocks.COLD_AERCLOUD.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.25F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.ICESTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_FROZEN_HOLYSTONE_VASE.get(), 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.CARVED_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.WYND_SENTRY_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE_BRICKS.get(), 0.05F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE)
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, SENTRY_LABORATORY_BOSS_ROOM, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.LOCKED_CARVED_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.LOCKED_WYND_SENTRY_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.TREASURE_DOORWAY_CARVED_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.TREASURE_DOORWAY_WYND_SENTRY_STONE.get().defaultBlockState())
                )),
                new BossRoomProcessor()
        ));
        register(context, ANCIENT_DUNGEON, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.VINE, 0.9F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                ))));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(AncientAether.MODID, name));
    }

    private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> list) {
        context.register(resourceKey, new StructureProcessorList(list));
    }
}