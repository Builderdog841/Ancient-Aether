package net.builderdog.ancient_aether.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.zepalesque.redux.world.biome.ReduxRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;

import java.util.function.Consumer;
@Pseudo //make mixin optional
@Mixin(value = ReduxRegion.class, remap = false) //We don't need to remap since redux's code isn't obfuscated
public class ReduxRegionMixin {

    /**
     * @author TunefulTurnip
     * @reason I don't see why any other mod would overwrite redux's region, so we should be fine. Needed to change Redux's default region for better compat.
     */
    @Overwrite
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        //Biome stuff here
    }
}
