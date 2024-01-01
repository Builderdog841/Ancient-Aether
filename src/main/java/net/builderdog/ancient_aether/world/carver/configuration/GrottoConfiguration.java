package net.builderdog.ancient_aether.world.carver.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;

public class GrottoConfiguration extends ProbabilityFeatureConfiguration {
    public static final MapCodec<GrottoConfiguration> CODEC =
            RecordCodecBuilder.mapCodec((p_224839_)
                    -> p_224839_.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((p_159113_)
                    -> p_159113_.probability), HeightProvider.CODEC.fieldOf("y").forGetter((p_159111_)
                    -> p_159111_.y), FloatProvider.CODEC.fieldOf("yScale").forGetter((p_159109_)
                    -> p_159109_.yScale), VerticalAnchor.CODEC.fieldOf("water_level").forGetter((p_159107_)
                    -> p_159107_.waterLevel), CarverDebugSettings.CODEC.optionalFieldOf("debug_settings", CarverDebugSettings.DEFAULT).forGetter((p_190637_)
                    -> p_190637_.debugSettings), RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("replaceable").forGetter((p_224841_)
                    -> p_224841_.replaceable)).apply(p_224839_, GrottoConfiguration::new));
    public final HeightProvider y;
    public final FloatProvider yScale;
    public final VerticalAnchor waterLevel;
    public final CarverDebugSettings debugSettings;
    public final HolderSet<Block> replaceable;

    public GrottoConfiguration(float p_224832_, HeightProvider p_224833_, FloatProvider p_224834_, VerticalAnchor p_224835_, CarverDebugSettings p_224836_, HolderSet<Block> p_224837_) {
        super(p_224832_);
        y = p_224833_;
        yScale = p_224834_;
        waterLevel = p_224835_;
        debugSettings = p_224836_;
        replaceable = p_224837_;
    }
}