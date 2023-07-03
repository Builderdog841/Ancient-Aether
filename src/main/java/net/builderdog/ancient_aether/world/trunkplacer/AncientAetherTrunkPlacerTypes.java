package net.builderdog.ancient_aether.world.trunkplacer;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherTrunkPlacerTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AncientAether.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<AncientAetherHookedTrunkPlacer>> ANCIENT_AETHER_HOOKED_TRUNK_PLACER = TRUNK_PLACERS.register("ancient_aether_hooked_trunk_placer", () -> new TrunkPlacerType<>(AncientAetherHookedTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<AncientAetherSkinnyHookedTrunkPlacer>> ANCIENT_AETHER_SKINNY_HOOKED_TRUNK_PLACER = TRUNK_PLACERS.register("ancient_aether_skinny_hooked_trunk_placer", () -> new TrunkPlacerType<>(AncientAetherSkinnyHookedTrunkPlacer.CODEC));
}