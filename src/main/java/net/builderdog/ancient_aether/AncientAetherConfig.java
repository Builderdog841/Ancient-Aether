package net.builderdog.ancient_aether;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class AncientAetherConfig {

    public static class Server {
        public final ConfigValue<Boolean> server_config_overrides;

        public Server(ModConfigSpec.Builder builder) {
            builder.push("Modpack");

            server_config_overrides = builder
                    .comment("Allows Ancient Aether to override Server Config default values, should not be disabled normally")
                    .translation("config.ancient_aether.server.modpack.server_config_overrides")
                    .define("Server Config Overrides", true);

            builder.pop();
        }
    }

    public static class Common {
        public final ConfigValue<Integer> wind_blow_duration;
        public final ConfigValue<Integer> ancient_aether_region_weight;
        public final ConfigValue<Boolean> experimental_features;

        public Common(ModConfigSpec.Builder builder) {
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
        public final ConfigValue<Boolean> custom_boss_bars;
        public final ConfigValue<Boolean> title_screen_override;
        public final ConfigValue<Boolean> the_aether_title;
        public final ConfigValue<Boolean> config_overrides;

        public Client(ModConfigSpec.Builder builder) {
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
                    .comment("Displays what mob is summoned by Trapped Dungeon Blocks as well as what boss is required to unlock Boss Doorway Blocks on the item")
                    .translation("config.ancient_aether.client.tooltips.dungeon_block_tooltips")
                    .define("Dungeon Block Tooltips", true);

            builder.pop();
            builder.push("GUI");

            custom_boss_bars = builder
                    .comment("Gives Ancient Aether Bosses custom boss bar designs")
                    .translation("config.ancient_aether.client.gui.custom_boss_bars")
                    .define("Custom Boss Bars", true);

            title_screen_override = builder
                    .comment("Changes the Title Screen to the Ancient Aether Theme on start-up")
                    .translation("config.ancient_aether.client.gui.title_screen_override")
                    .define("Title Screen Override", true);

            the_aether_title = builder
                    .comment("Changes the title in the Ancient Aether Title Screen to: The Aether")
                    .translation("config.ancient_aether.client.gui.the_aether_title")
                    .define("The Aether Title", false);

            builder.pop();
            builder.push("Modpack");

            config_overrides = builder
                    .comment("Allows Ancient Aether to override Config default values, should not be disabled normally")
                    .translation("config.ancient_aether.client.modpack.config_overrides")
                    .define("Config Overrides", true);

            builder.pop();
        }
    }

    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Server, ModConfigSpec> serverSpecPair = new ModConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = serverSpecPair.getRight();
        SERVER = serverSpecPair.getLeft();

        final Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();

        final Pair<Client, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
    }
}