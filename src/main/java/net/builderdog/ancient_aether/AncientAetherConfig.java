package net.builderdog.ancient_aether;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {

    public static class Common {
        public final ConfigValue<Integer> ancient_aether_biome_weight;

        public Common(ForgeConfigSpec.Builder builder) {

            builder.push("Worldgen");
            ancient_aether_biome_weight = builder
                    .comment("The weighting of Ancient Aether regions in the Aether")
                    .translation("config.ancient_aether.common.worldgen.ancient_aether_region_weight")
                    .define("Ancient Aether Region Weight", 30);
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