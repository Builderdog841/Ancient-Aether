package net.builderdog.ancient_aether;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {
    public static class Common {
        public final ConfigValue<Integer> wind_blow_duration;
        public final ConfigValue<Integer> ancient_aether_region_weight;
        public final ConfigValue<Boolean> experimental_features;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Gameplay");

            wind_blow_duration = builder
                    .comment("The duration of how long Wind Blows fired by Wind Blowers last in ticks")
                    .translation("config.ancient_aether.common.gameplay.wind_blow_duration")
                    .define("Wind Blow Duration", 50);

            builder.pop();
            builder.push("Worldgen");

            ancient_aether_region_weight = builder
                    .comment("The weighting of Ancient Aether Regions in the Aether")
                    .translation("config.ancient_aether.common.worldgen.ancient_aether_region_weight")
                    .define("Ancient Aether Region Weight", 20);

            builder.pop();
            builder.push("Experimental");

            experimental_features = builder
                    .comment("Enables features of the mod that are work in progress")
                    .translation("config.ancient_aether.common.experimental.experimental_features")
                    .define("Experimental Features", false);

            builder.pop();
        }
    }

    public static class Client {
        public final ConfigValue<Boolean> rarity_system;
        public final ConfigValue<Boolean> moa_egg_tooltips;
        public final ConfigValue<Boolean> dungeon_block_tooltips;

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

            dungeon_block_tooltips = builder
                    .comment("Displays what mob is summoned by Trapped Dungeon Blocks as well as what boss is required to unlock Boss Doorway Blocks on the items themselves")
                    .translation("config.ancient_aether.client.tooltips.dungeon_block_tooltips")
                    .define("Dungeon Block Tooltips", true);

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