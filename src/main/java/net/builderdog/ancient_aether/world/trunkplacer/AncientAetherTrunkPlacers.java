package net.builderdog.ancient_aether.world.trunkplacer;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherTrunkPlacers {

        public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AncientAether.MOD_ID);

        public static final RegistryObject<TrunkPlacerType<HookedTrunkPlacer>> HOOKED_TRUNK_PLACER = TRUNK_PLACERS.register("hooked_trunk_placer", () -> new TrunkPlacerType<>(HookedTrunkPlacer.CODEC));
    }