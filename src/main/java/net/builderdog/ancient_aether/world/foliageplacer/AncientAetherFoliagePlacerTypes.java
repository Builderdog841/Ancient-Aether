package net.builderdog.ancient_aether.world.foliageplacer;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFoliagePlacerTypes {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<AncientAetherPineFoliagePlacer>> ANCIENT_AETHER_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("ancient_aether_pine_foliage_placer", () -> new FoliagePlacerType<>(AncientAetherPineFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<CrystalFoliagePlacer>> CRYSTAL_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("crystal_foliage_placer", () -> new FoliagePlacerType<>(CrystalFoliagePlacer.CODEC));
}