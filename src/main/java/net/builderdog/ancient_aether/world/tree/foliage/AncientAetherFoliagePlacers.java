package net.builderdog.ancient_aether.world.tree.foliage;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherFoliagePlacers {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, AncientAether.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<AetherPineFoliagePlacer>> AETHER_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("aether_pine_foliage_placer", () -> new FoliagePlacerType<>(AetherPineFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<HighsprootFoliagePlacer>> HIGHSPROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("highsproot_foliage_placer", () -> new FoliagePlacerType<>(HighsprootFoliagePlacer.CODEC));
}