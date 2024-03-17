package net.builderdog.ancient_aether.world.carver;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherCarvers {

    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(Registries.CARVER, AncientAether.MODID);

    public static RegistryObject<WorldCarver<CaveCarverConfiguration>> SKYLANDS_CAVE = CARVERS.register("skylands_cave", () -> new SkylandsCarver(CaveCarverConfiguration.CODEC));
}