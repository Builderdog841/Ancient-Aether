package net.builderdog.aether_crystallium.worldgen.foliageplacer;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<HighlandsPineFoliagePlacer>> HIGHLANDS_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("highlands_pine_foliage_placer", () -> new FoliagePlacerType<>(HighlandsPineFoliagePlacer.CODEC));
}