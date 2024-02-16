package net.builderdog.ancient_aether.data.resources.registries;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.world.processor.DoubleDropsProcessor;
import com.aetherteam.aether.world.processor.SurfaceRuleProcessor;
import com.google.common.collect.ImmutableList;
import net.builderdog.ancient_aether.AncientAether;
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
    public static final ResourceKey<StructureProcessorList> MYSTERIOUS_HENGE = createKey("mysterious_henge");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_SKYROOT = createKey("valkyrie_camp_skyroot");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_WYNDCAPS = createKey("valkyrie_camp_wyndcaps");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_SETTLEMENT_SKYROOT = createKey("valkyrie_settlement_skyroot");
    public static final ResourceKey<StructureProcessorList> SENTRY_LABORATORY_ENTRANCE = createKey("sentry_laboratory_entrance");
    public static final ResourceKey<StructureProcessorList> SENTRY_LABORATORY = createKey("sentry_laboratory");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_ENTRANCE = createKey("bronze_dungeon_entrance");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_TUNNEL = createKey("bronze_dungeon_tunnel");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_ROOM = createKey("bronze_dungeon_room");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_BOSS_ROOM = createKey("bronze_dungeon_boss_room");
    public static final ResourceKey<StructureProcessorList> ANCIENT_DUNGEON = createKey("ancient_dungeon");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> list) {
        context.register(resourceKey, new StructureProcessorList(list));
    }

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        register(context, HOLYSTONE_RUIN, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE_BRICKS.get(), 0.05F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.4F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_HOLYSTONE_VASE.get(), 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.5F), AlwaysTrueTest.INSTANCE, AetherBlocks.HOLYSTONE_BRICKS.get().defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, MYSTERIOUS_HENGE, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.HOLYSTONE.get(), 0.2F), AlwaysTrueTest.INSTANCE, AncientAetherFeatureStates.MOSSY_HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.ANCIENT_MOSSY_HOLYSTONE_VASE.get(), 0.5F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.2F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.ORANGE_WOOL, 0.25F), AlwaysTrueTest.INSTANCE, AetherFeatureStates.HOLYSTONE),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.ORANGE_WOOL, 1.0F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                )),
                new DoubleDropsProcessor(),
                new SurfaceRuleProcessor()
        ));
        register(context, VALKYRIE_CAMP_SKYROOT, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.AETHER_GRASS_BLOCK.get(), 0.75F), AlwaysTrueTest.INSTANCE, AetherBlocks.AETHER_DIRT_PATH.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.CHEST, 0.25F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AetherBlocks.POTTED_PURPLE_FLOWER.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AetherBlocks.POTTED_WHITE_FLOWER.get(), 0.15F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.POTTED_HIGHLAND_VIOLA.get().defaultBlockState()),
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
        register(context, ANCIENT_DUNGEON, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.LOCKED_AEROGETIC_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.LIGHT_AEROGETIC_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get(), 0.05F), AlwaysTrueTest.INSTANCE, AncientAetherBlocks.TREASURE_DOORWAY_AEROGETIC_STONE.get().defaultBlockState()),
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.VINE, 0.9F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())
                ))));
    }
}