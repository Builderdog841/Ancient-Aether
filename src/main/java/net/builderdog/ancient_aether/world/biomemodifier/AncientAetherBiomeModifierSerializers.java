package net.builderdog.ancient_aether.world.biomemodifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherBiomeModifierSerializers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, AncientAether.MOD_ID);

    static RegistryObject<Codec<CarverModifier>> CARVER_CODEC = BIOME_MODIFIER_SERIALIZERS.register("add_carver", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(CarverModifier::biomes),
                    ConfiguredWorldCarver.CODEC.fieldOf("carver").forGetter(CarverModifier::carver)
            ).apply(builder, CarverModifier::new)));
}