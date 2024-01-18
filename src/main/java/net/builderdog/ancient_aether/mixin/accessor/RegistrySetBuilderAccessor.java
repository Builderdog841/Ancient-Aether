package net.builderdog.ancient_aether.mixin.accessor;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(RegistrySetBuilder.class)
public interface RegistrySetBuilderAccessor {
    @Accessor("entries")
    List<RegistrySetBuilder.RegistryStub<?>> ancient_aether$getEntries();

    @Invoker
    RegistrySetBuilder.BuildState callCreateState(RegistryAccess registryAccess);
}