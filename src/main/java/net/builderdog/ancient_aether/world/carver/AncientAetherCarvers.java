package net.builderdog.ancient_aether.world.carver;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherCarvers {

    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(Registries.CARVER, AncientAether.MOD_ID);

    //public static RegistryObject<WorldCarver<CaveCarverConfiguration>> GROTTO = CARVERS.register("grotto", () -> new GrottoCarver(CaveCarverConfiguration.CODEC));
}