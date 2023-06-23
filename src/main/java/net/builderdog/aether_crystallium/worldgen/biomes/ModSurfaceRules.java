package net.builderdog.aether_crystallium.worldgen.biomes;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = AetherCrystallium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSurfaceRules {

    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        MinecraftServer server = event.getServer();
        RegistryAccess registryAccess = server.registryAccess();
        Registry<LevelStem> levelStemRegistry = registryAccess.registryOrThrow(Registries.LEVEL_STEM);
        LevelStem levelStem = levelStemRegistry.get(AetherDimensions.AETHER_LEVEL_STEM);
        ChunkGenerator chunkGenerator = levelStem.generator();

        if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
            NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
            SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
            if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
                List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
                surfaceRules.add(0, SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.QUICKSOIL_DESERT),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))));
                surfaceRules.add(0, SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.QUICKSOIL_DESERT),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AetherBlocks.QUICKSOIL.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true)))));

                surfaceRules.add(1, SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ENCHANTED_WOODS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AetherBlocks.ENCHANTED_AETHER_GRASS_BLOCK.get().defaultBlockState()))));

                NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(),
                        noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(), noiseGeneratorSettings.noiseRouter(),
                        SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(),
                       noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(),
                        noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(),
                        noiseGeneratorSettings.useLegacyRandomSource());
                noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
            }
        }
    }
}