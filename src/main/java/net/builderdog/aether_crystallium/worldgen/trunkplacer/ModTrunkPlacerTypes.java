package net.builderdog.aether_crystallium.worldgen.trunkplacer;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AetherCrystallium.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<SunrootTrunkPlacer>> SUNROOT_TRUNK_PLACER = TRUNK_PLACERS.register("sunroot_trunk_placer", () -> new TrunkPlacerType<>(SunrootTrunkPlacer.CODEC));
}