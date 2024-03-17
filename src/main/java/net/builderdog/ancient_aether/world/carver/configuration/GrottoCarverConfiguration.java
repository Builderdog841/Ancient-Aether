package net.builderdog.ancient_aether.world.carver.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;

public class GrottoCarverConfiguration extends CarverConfiguration {
    public static final Codec<GrottoCarverConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            CarverConfiguration.CODEC.forGetter((carver) -> carver),
            FloatProvider.CODEC.fieldOf("horizontal_radius_multiplier").forGetter((carver) -> carver.horizontalRadiusMultiplier),
            FloatProvider.CODEC.fieldOf("vertical_radius_multiplier").forGetter((carver) -> carver.verticalRadiusMultiplier),
            FloatProvider.codec(-1.0F, 1.0F).fieldOf("floor_level").forGetter((carver) -> carver.floorLevel)
    ).apply(instance, GrottoCarverConfiguration::new));

    public final FloatProvider horizontalRadiusMultiplier;
    public final FloatProvider verticalRadiusMultiplier;
    public final FloatProvider floorLevel;

    public GrottoCarverConfiguration(float p_224853_, HeightProvider p_224854_, FloatProvider p_224855_, VerticalAnchor p_224856_, CarverDebugSettings p_224857_, HolderSet<Block> p_224858_, FloatProvider horizontalRadiusMultiplier, FloatProvider verticalRadiusMultiplier, FloatProvider floorLevel) {
        super(p_224853_, p_224854_, p_224855_, p_224856_, p_224857_, p_224858_);
        this.horizontalRadiusMultiplier = horizontalRadiusMultiplier;
        this.verticalRadiusMultiplier = verticalRadiusMultiplier;
        this.floorLevel = floorLevel;
    }

    public GrottoCarverConfiguration(float p_224863_, HeightProvider p_224864_, FloatProvider p_224865_, VerticalAnchor p_224866_, HolderSet<Block> p_224867_, FloatProvider p_224868_, FloatProvider p_224869_, FloatProvider p_224870_) {
        this(p_224863_, p_224864_, p_224865_, p_224866_, CarverDebugSettings.DEFAULT, p_224867_, p_224868_, p_224869_, p_224870_);
    }

    public GrottoCarverConfiguration(CarverConfiguration config, FloatProvider p_159180_, FloatProvider p_159181_, FloatProvider p_159182_) {
        this(config.probability, config.y, config.yScale, config.lavaLevel, config.debugSettings, config.replaceable, p_159180_, p_159181_, p_159182_);
    }
}