package net.builderdog.ancient_aether.world.foliageplacer;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFoliagePlacers {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AncientAether.MODID);

    public static final RegistryObject<FoliagePlacerType<PineFoliagePlacer>> PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("pine_foliage_placer", () -> new FoliagePlacerType<>(PineFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<HighsprootFoliagePlacer>> HIGHSPROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("highsproot_foliage_placer", () -> new FoliagePlacerType<>(HighsprootFoliagePlacer.CODEC));
}