package net.builderdog.ancient_aether.entity.moa;

import com.aetherteam.aether.api.registers.MoaType;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

public class AncientAetherMoaTypes {
    public static final ResourceKey<Registry<MoaType>> MOA_TYPE_REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation("aether", "moa_type"));
    public static final DeferredRegister<MoaType> MOA_TYPES;
    public static final Supplier<IForgeRegistry<MoaType>> MOA_TYPE_REGISTRY;
    public static final RegistryObject<MoaType> SAKURA;
    public AncientAetherMoaTypes() {
    }

    public static MoaType get(String id) {
        return (MoaType)((IForgeRegistry)MOA_TYPE_REGISTRY.get()).getValue(new ResourceLocation(id));
    }

    static {
        MOA_TYPES = DeferredRegister.create(MOA_TYPE_REGISTRY_KEY, "aether");
        MOA_TYPE_REGISTRY = MOA_TYPES.makeRegistry(RegistryBuilder::new);
        SAKURA = MOA_TYPES.register("sakura", () -> {
            return new MoaType((new MoaType.Properties()).egg(AncientAetherItems.SAKURA_MOA_EGG).maxJumps(10).speed(0.155F).spawnChance(0).texture("textures/entity/mob/moa/sakura_moa.png"));
        });
    }
}
