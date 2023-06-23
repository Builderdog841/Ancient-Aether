package net.builderdog.aether_crystallium.worldgen.foliageplacer;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<HighlandsPineFoliagePlacer>> HIGHLANDS_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("highlands_pine_foliage_placer", () -> new FoliagePlacerType<>(HighlandsPineFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<SunrootFoliagePlacer>> SUNROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("sunroot_foliage_placer", () -> new FoliagePlacerType<>(SunrootFoliagePlacer.CODEC));
}