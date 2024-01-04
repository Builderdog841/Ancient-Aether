package net.builderdog.ancient_aether.entity.moa;

import com.aetherteam.aether.api.AetherMoaTypes;
import com.aetherteam.aether.api.registers.MoaType;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraftforge.registries.*;

public class AncientAetherMoaTypes {
    public static final DeferredRegister<MoaType> MOA_TYPES = DeferredRegister.create(AetherMoaTypes.MOA_TYPE_REGISTRY_KEY, AncientAether.MOD_ID);

    public static final RegistryObject<MoaType> TURQUOISE = MOA_TYPES.register("turquoise",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.TURQUOISE_MOA_EGG)
                    .maxJumps(6).speed(0.155F).spawnChance(40)
                    .texture("textures/entity/mob/moa/turquoise_moa.png")));
    public static final RegistryObject<MoaType> TEAL = MOA_TYPES.register("teal",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.TEAL_MOA_EGG)
                    .maxJumps(5).speed(0.17F).spawnChance(20)
                    .texture("textures/entity/mob/moa/teal_moa.png")));
    public static final RegistryObject<MoaType> SKY_BLUE = MOA_TYPES.register("sky_blue",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.SKY_BLUE_MOA_EGG)
                    .maxJumps(3).speed(0.17F).spawnChance(40)
                    .texture("textures/entity/mob/moa/sky_blue_moa.png")));

    public static final RegistryObject<MoaType> LAVENDER = MOA_TYPES.register("lavender",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.LAVENDER_MOA_EGG)
                    .maxJumps(2).speed(0.2F).spawnChance(20)
                    .texture("textures/entity/mob/moa/lavender_moa.png")));

    public static final RegistryObject<MoaType> SAKURA = MOA_TYPES.register("sakura",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.SAKURA_MOA_EGG)
                    .maxJumps(10).speed(0.14F).spawnChance(5)
                    .texture("textures/entity/mob/moa/sakura_moa.png")));

    public static final RegistryObject<MoaType> VIOLET = MOA_TYPES.register("violet",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.VIOLET_MOA_EGG)
                    .maxJumps(3).speed(0.2F).spawnChance(10)
                    .texture("textures/entity/mob/moa/violet_moa.png")));

    public static final RegistryObject<MoaType> BURGUNDY = MOA_TYPES.register("burgundy",
            () -> new MoaType((new MoaType.Properties())
                    .egg(AncientAetherItems.BURGUNDY_MOA_EGG)
                    .maxJumps(7).speed(0.155F).spawnChance(30)
                    .texture("textures/entity/mob/moa/burgundy_moa.png")));
}
