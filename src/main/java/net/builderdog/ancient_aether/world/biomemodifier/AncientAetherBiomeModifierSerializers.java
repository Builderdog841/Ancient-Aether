package net.builderdog.ancient_aether.world.biomemodifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class AncientAetherBiomeModifierSerializers {

    //Credit for this code goes to Zepalesque
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS;
    static RegistryObject<Codec<WaterColorModifier>> WATER_COLOR_CODEC;
    static RegistryObject<Codec<CarverModifier>> CARVER_CODEC;

    public AncientAetherBiomeModifierSerializers() {
    }

    static {
        BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(Keys.BIOME_MODIFIER_SERIALIZERS, "ancient_aether");
        CARVER_CODEC = BIOME_MODIFIER_SERIALIZERS.register("add_carver", () -> {
            return RecordCodecBuilder.create((builder) -> {
                return builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(CarverModifier::biomes), ConfiguredWorldCarver.CODEC.fieldOf("carver").forGetter(CarverModifier::carver)).apply(builder, CarverModifier::new);
            });
        });
        WATER_COLOR_CODEC = BIOME_MODIFIER_SERIALIZERS.register("water_color", () -> {
            return RecordCodecBuilder.create((builder) -> {
                return builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(WaterColorModifier::biomes), Codec.INT.fieldOf("water_color").forGetter(WaterColorModifier::water), Codec.INT.fieldOf("water_fog_color").forGetter(WaterColorModifier::fog)).apply(builder, WaterColorModifier::new);
            });
        });
    }
}
