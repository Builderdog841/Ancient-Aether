package net.builderdog.aether_crystallium.worldgen.foliageplacer;

import com.aetherteam.aether.world.foliageplacer.CrystalFoliagePlacer;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<CrystalliumPineFoliagePlacer>> CRYSTALLIUM_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("crystallium_pine_foliage_placer", () -> new FoliagePlacerType<>(CrystalliumPineFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<CrystalliumHookedFoliagePlacer>> CRYSTALLIUM_HOOKED_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("crystallium_hooked_foliage_placer", () -> new FoliagePlacerType<>(CrystalliumHookedFoliagePlacer.CODEC));
}