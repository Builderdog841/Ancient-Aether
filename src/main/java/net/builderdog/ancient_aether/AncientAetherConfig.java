package net.builderdog.ancient_aether;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {


    public static class Common {

        public final ConfigValue<Integer> ancient_aether_biome_weight;
        public final ConfigValue<Boolean> worldgen_overrides;
        public final ConfigValue<Boolean> compat_packs;
        public Common(ForgeConfigSpec.Builder builder) {

            builder.push("Worldgen");
            ancient_aether_biome_weight = builder
                    .comment("The weighting of Ancient Aether regions in the Aether")
                    .translation("config.ancient_aether.common.worldgen.ancient_aether_region_weight")
                    .define("Ancient Aether Region Weight", 30);
            builder.pop();

            builder.push("Worldgen");
            worldgen_overrides = builder
                    .comment("Enables the New Worldgen Datapack by default")
                    .translation("config.ancient_aether.common.worldgen.new_worldgen_datapack")
                    .define("Enables New Worldgen by default", true);
            builder.pop();

            builder.push("Compatibility");
            compat_packs = builder
                    .comment("Automatically activates Compatibility Datapacks")
                    .translation("config.ancient_aether.common.compatibility.compat_packs")
                    .define("Automatically activates Compatibility Datapacks", true);
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