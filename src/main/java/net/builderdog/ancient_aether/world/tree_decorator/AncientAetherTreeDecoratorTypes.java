package net.builderdog.ancient_aether.world.tree_decorator;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherTreeDecoratorTypes {

    //Credit for this code goes to the Aether Team
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, AncientAether.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<TrunkDecorator>> TRUNK_DECORATOR = TREE_DECORATORS.register("trunk_decorator", () -> new TreeDecoratorType<>(TrunkDecorator.CODEC));
}