package net.builderdog.ancient_aether;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {


    public static class Common {

        public final ConfigValue<Integer> ancient_aether_biome_weight;
        public final ConfigValue<Boolean> default_biome_datapack;
        public final ConfigValue<Boolean> new_worldgen_datapack;
        public Common(ForgeConfigSpec.Builder builder) {

            builder.push("Gameplay");
            ancient_aether_biome_weight = builder
                    .comment("The weighting of Ancient Aether regions in the Aether")
                    .translation("config.ancient_aether.common.gameplay.ancient_aether_region_weight")
                    .define("Ancient Aether Region Weight", 30);
            builder.pop();

            builder.push("Gameplay");
            default_biome_datapack = builder
                    .comment("Enables the Default Biome Improvement Datapack by default")
                    .translation("config.ancient_aether.common.gameplay.default_biome_datapack")
                    .define("Enable Biome Improvement Datapack by default", true);
            builder.pop();

            builder.push("Gameplay");
            new_worldgen_datapack = builder
                    .comment("Enables the New Worldgen Datapack by default")
                    .translation("config.ancient_aether.common.gameplay.new_worldgen_datapack")
                    .define("Enable Biome New Worldgen by default", true);
            builder.pop();
        }
}

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}