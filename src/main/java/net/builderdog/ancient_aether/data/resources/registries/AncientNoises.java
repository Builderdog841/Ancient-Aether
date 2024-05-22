package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class AncientNoises {
    public static final ResourceKey<NormalNoise.NoiseParameters> TEMPERATURE = createKey("temperature");
    public static final ResourceKey<NormalNoise.NoiseParameters> VEGETATION = createKey("vegetation");
    public static final ResourceKey<NormalNoise.NoiseParameters> EROSION = createKey("erosion");
    public static final ResourceKey<NormalNoise.NoiseParameters> JAGGED = createKey("jagged");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_CAVES = createKey("noise_caves");
    public static final ResourceKey<NormalNoise.NoiseParameters> NOISE_CAVE_FACTOR = createKey("noise_cave_factor");
    public static final ResourceKey<NormalNoise.NoiseParameters> AMPLIFIER = createKey("amplifier");
    public static final ResourceKey<NormalNoise.NoiseParameters> AMPLIFIER_FACTOR = createKey("amplifier_factor");
    public static final ResourceKey<NormalNoise.NoiseParameters> SKYLANDS_AQUIFER = createKey("skylands_aquifer");
    public static final ResourceKey<NormalNoise.NoiseParameters> SKYLANDS_AQUIFER_FACTOR = createKey("skylands_aquifer_factor");
    public static final ResourceKey<NormalNoise.NoiseParameters> UPPER_ISLANDS_FACTOR = createKey("upper_islands_factor");
    public static final ResourceKey<NormalNoise.NoiseParameters> VALKYRIE_CLAY = createKey("valkyrie_clay");

    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String name) {
        return ResourceKey.create(Registries.NOISE, new ResourceLocation(AncientAether.MODID, name));
    }

    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
        register(context, TEMPERATURE, -9, 1.5, 0.0, 1.0, 0.0, 0.0, 0.0);
        register(context, VEGETATION, -8, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0);
        register(context, EROSION, -9, 1.5, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        register(context, JAGGED, -16, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        register(context, NOISE_CAVES, -6, 1.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0);
        register(context, NOISE_CAVE_FACTOR, -7, 0.3, 0.0, 0.0);
        register(context, AMPLIFIER, -7, 1.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0);
        register(context, AMPLIFIER_FACTOR, -8, 0.8, 0.6, 0.25, 0.0, 0.0, 0.0, 0.0);
        register(context, SKYLANDS_AQUIFER, -6, 1.5, 0.5, 0.0, 0.0, 0.0);
        register(context, SKYLANDS_AQUIFER_FACTOR, -8, 1.25, 0.0, 0.25, 0.0);
        register(context, UPPER_ISLANDS_FACTOR, -8, 0.5, 0.0, 0.5, 0.0, 0.0);
        register(context, VALKYRIE_CLAY, -4, 1.0, 0.25, 0.0, 0.0);
    }

    public static void register(BootstapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int firstOctave, double firstAmplitude, double... amplitudes) {
        context.register(key, new NormalNoise.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
    }
}