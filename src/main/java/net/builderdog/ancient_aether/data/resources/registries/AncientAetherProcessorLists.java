package net.builderdog.ancient_aether.data.resources.registries;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class AncientAetherProcessorLists {
    public static final ResourceKey<StructureProcessorList> HOLYSTONE_RUIN = createKey("holystone_ruin");
    public static final ResourceKey<StructureProcessorList> MYSTERIOUS_HENGE = createKey("mysterious_henge");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_SKYROOT = createKey("valkyrie_camp_skyroot");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_CAMP_WYNDCAPS = createKey("valkyrie_camp_wyndcaps");
    public static final ResourceKey<StructureProcessorList> VALKYRIE_SETTLEMENT_SKYROOT = createKey("valkyrie_settlement_skyroot");
    public static final ResourceKey<StructureProcessorList> SENTRY_LABORATORY = createKey("mysterious_henge");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_ENTRANCE = createKey("bronze_dungeon_entrance");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_TUNNEL = createKey("bronze_dungeon_tunnel");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_ROOM = createKey("bronze_dungeon_room");
    public static final ResourceKey<StructureProcessorList> BRONZE_DUNGEON_BOSS_ROOM = createKey("bronze_dungeon_boss_room");
    public static final ResourceKey<StructureProcessorList> ANCIENT_DUNGEON = createKey("ancient_dungeon");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(name));
    }

    private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> list) {
        context.register(resourceKey, new StructureProcessorList(list));
    }

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);
    }
}