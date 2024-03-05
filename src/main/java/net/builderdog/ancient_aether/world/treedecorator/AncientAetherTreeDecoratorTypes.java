package net.builderdog.ancient_aether.world.treedecorator;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherTreeDecoratorTypes {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, AncientAether.MODID);

    public static final RegistryObject<TreeDecoratorType<GrapeVineDecorator>> GRAPE_VINE_DECORATOR = TREE_DECORATORS.register("grape_vine_decorator", () -> new TreeDecoratorType<>(GrapeVineDecorator.CODEC));
}