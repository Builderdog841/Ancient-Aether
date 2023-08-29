package net.builderdog.ancient_aether.world.carver;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherCarvers {

    //Credit for this code goes to Zepalesque
    public static final DeferredRegister<WorldCarver<?>> CARVERS;
    public static RegistryObject<WorldCarver<?>> CLOUD_BED_CARVER;

    public AncientAetherCarvers() {
    }

    static {
        CARVERS = DeferredRegister.create(Registries.CARVER, "ancient_aether");
        CLOUD_BED_CARVER = CARVERS.register("cloudbed", () -> {
            return new CloudBedCarver(CaveCarverConfiguration.CODEC);
        });
    }
}
