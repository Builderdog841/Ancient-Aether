package net.builderdog.aether_crystallium.world.tree_decorator;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTreeDecoratorTypes {

    //This code was written by the Aether Team and not by me
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, AetherCrystallium.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<TrunkDecorator>> TRUNK_DECORATOR = TREE_DECORATORS.register("trunk_decorator", () -> new TreeDecoratorType<>(TrunkDecorator.CODEC));
}