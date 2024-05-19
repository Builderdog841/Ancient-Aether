package net.builderdog.ancient_aether.world.tree.decorator;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.tree.decorator.GrapeVineDecorator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AncientTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, AncientAether.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<GrapeVineDecorator>> GRAPE_VINE_DECORATOR = TREE_DECORATORS.register("grape_vine_decorator", () -> new TreeDecoratorType<>(GrapeVineDecorator.CODEC));
}