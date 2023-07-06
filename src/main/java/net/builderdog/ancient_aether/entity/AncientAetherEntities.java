package net.builderdog.ancient_aether.entity;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.custom.HighlandsBuffaloEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<EntityType<HighlandsBuffaloEntity>> HIGHLANDS_BUFFALO =
            ENTITY_TYPES.register("highlands_buffalo",
                    () -> EntityType.Builder.of(HighlandsBuffaloEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(AncientAether.MOD_ID, "highlands_buffalo").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
