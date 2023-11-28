package net.builderdog.ancient_aether.event.hooks;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.DataPackConfig;
import net.royawesome.jlibnoise.module.combiner.Min;

import java.util.ArrayList;

public class ServerHooks {
    public static ArrayList<String> datapacks = new ArrayList<>();

    public static void cacheDatapacks(MinecraftServer server) {
        datapacks = new ArrayList<>(server.getWorldData().getDataConfiguration().dataPacks().getEnabled());

    }

    public static void clearDatapacks() {
        if (datapacks != null) {
            datapacks.clear();
        } else {
            datapacks = new ArrayList<>();
        }
    }

}
