package net.builderdog.aether_crystallium.world.trunkplacer;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AetherCrystallium.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<CrystalliumHookedTrunkPlacer>> CRYSTALLIUM_HOOKED_TRUNK_PLACER = TRUNK_PLACERS.register("crystallium_hooked_trunk_placer", () -> new TrunkPlacerType<>(CrystalliumHookedTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<CrystalliumSkinnyHookedTrunkPlacer>> CRYSTALLIUM_SKINNY_HOOKED_TRUNK_PLACER = TRUNK_PLACERS.register("crystallium_skinny_hooked_trunk_placer", () -> new TrunkPlacerType<>(CrystalliumSkinnyHookedTrunkPlacer.CODEC));
}