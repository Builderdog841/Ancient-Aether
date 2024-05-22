package net.builderdog.ancient_aether.world.tree;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.tree.foliage.PineFoliagePlacer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientAetherFoliagePlacers {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, AncientAether.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<PineFoliagePlacer>> PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("pine_foliage_placer", () -> new FoliagePlacerType<>(PineFoliagePlacer.CODEC));
}