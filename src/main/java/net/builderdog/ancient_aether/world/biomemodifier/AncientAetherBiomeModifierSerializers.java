package net.builderdog.ancient_aether.world.biomemodifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.zepalesque.aether.world.biomemodifier.CarverModifier;
import net.zepalesque.aether.world.biomemodifier.WaterColorBiomeModifier;

public class AncientAetherBiomeModifierSerializers {

    //Credit for this code goes to Zepalesque
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS;
    static RegistryObject<Codec<net.zepalesque.aether.world.biomemodifier.CarverModifier>> CARVER_CODEC;

    public AncientAetherBiomeModifierSerializers() {
    }

    static {
        BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(Keys.BIOME_MODIFIER_SERIALIZERS, "ancient_aether");
        CARVER_CODEC = BIOME_MODIFIER_SERIALIZERS.register("add_carver", () -> {
            return RecordCodecBuilder.create((builder) -> {
                return builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(net.zepalesque.aether.world.biomemodifier.CarverModifier::biomes), ConfiguredWorldCarver.CODEC.fieldOf("carver").forGetter(net.zepalesque.aether.world.biomemodifier.CarverModifier::carver)).apply(builder, CarverModifier::new);
            });
        });
    }
}
