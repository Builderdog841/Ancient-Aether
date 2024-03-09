package net.builderdog.ancient_aether;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {
    public static class Common {
        public final ConfigValue<Integer> ancient_aether_region_weight;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Worldgen");

            ancient_aether_region_weight = builder
                    .comment("The weighting of Ancient Aether Regions in the Aether")
                    .translation("config.ancient_aether.common.worldgen.ancient_aether_region_weight")
                    .define("Ancient Aether Region Weight", 30);

            builder.pop();
        }
    }

    public static class Client {
        public final ConfigValue<Boolean> rarity_system;
        public final ConfigValue<Boolean> moa_egg_tooltips;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("Tooltips");

            rarity_system = builder
                    .comment("Gives Aether Dungeon Loot a certain rarity in form of a tooltip")
                    .translation("config.ancient_aether.client.tooltips.rarity_system")
                    .define("Rarity System", true);

            moa_egg_tooltips = builder
                    .comment("Displays the Moas Mid-Air Jumps and Speed as a tooltip on the egg")
                    .translation("config.ancient_aether.client.tooltips.moa_egg_tooltips")
                    .define("Moa Egg Tooltips", true);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();

        final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
    }
}