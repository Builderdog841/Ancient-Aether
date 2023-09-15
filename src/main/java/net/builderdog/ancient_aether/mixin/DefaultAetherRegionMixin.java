    //package net.builderdog.ancient_aether.mixin;

//import com.mojang.datafixers.util.Pair;
//import net.builderdog.ancient_aether.world.biomes.AncientAetherBiomes;
//import net.minecraft.core.Registry;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.Climate;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import teamrazor.aeroblender.aether.DefaultAetherRegion;

//import java.util.function.Consumer;

//import static net.minecraftforge.common.BiomeManager.addBiome;

//@Mixin({DefaultAetherRegion.class})
//public class DefaultAetherRegionMixin {
    //public DefaultAetherRegionMixin() {
   // }
    
  //  @Inject(
        //    at = {@At("RETURN")},
         //   method = {"addBiomes"},
          //  cancellable = true,
          //  remap = false
  //  )

  //  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
    //    addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, fullRange, fullRange, Climate.Parameter.span(-2.0F, -1.8F), fullRange, 0),
        //        AncientAetherBiomes.GOLDEN_FOREST);
  //  }
//}
