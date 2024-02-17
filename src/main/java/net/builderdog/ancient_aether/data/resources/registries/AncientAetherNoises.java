package net.builderdog.ancient_aether.data.resources.registries;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class AncientAetherNoises {
    public static final ResourceKey<NormalNoise.NoiseParameters> AMPLIFICATION_FACTOR = createKey("amplification_factor");
    public static final ResourceKey<NormalNoise.NoiseParameters> AMPLIFIED = createKey("amplified");
    public static final ResourceKey<NormalNoise.NoiseParameters> EROSION = createKey("erosion");
    public static final ResourceKey<NormalNoise.NoiseParameters> FOREST_DISTRIBUTION = createKey("forest_distribution");
    public static final ResourceKey<NormalNoise.NoiseParameters> JAGGED = createKey("jagged");
    public static final ResourceKey<NormalNoise.NoiseParameters> TEMPERATURE = createKey("temperature");
    public static final ResourceKey<NormalNoise.NoiseParameters> VEGETATION = createKey("vegetation");

    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String name) {
        return ResourceKey.create(Registries.NOISE, new ResourceLocation(AncientAether.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
        register(context, AMPLIFICATION_FACTOR, -8, 1.5, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        register(context, AMPLIFIED, -7, 1.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0);
        register(context, EROSION, -9, 1.5, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        register(context, FOREST_DISTRIBUTION, -9, 1.0, 1.5, 1.0, 0.0, 0.0, 0.0, 0.0);
        register(context, JAGGED, -16, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        register(context, TEMPERATURE, -9, 1.5, 0.0, 1.0, 0.0, 0.0, 0.0);
        register(context, VEGETATION, -8, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0);
    }

    public static void register(BootstapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int firstOctave, double firstAmplitude, double... amplitudes) {
        context.register(key, new NormalNoise.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
    }
}