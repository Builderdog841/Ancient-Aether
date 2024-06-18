package net.builderdog.ancient_aether.world.density;

import com.mojang.serialization.Codec;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherDensityFunctionTypes {
    public static final DeferredRegister<Codec<? extends DensityFunction>> DENSITY_FUNCTION_TYPES = DeferredRegister.create(BuiltInRegistries.DENSITY_FUNCTION_TYPE, AncientAether.MODID);

    public static DeferredHolder<Codec<? extends DensityFunction>, ? extends Codec<? extends DensityFunction>> PERLIN_NOISE =
            DENSITY_FUNCTION_TYPES.register("perlin_noise", PerlinNoiseFunction.CODEC::codec);

}