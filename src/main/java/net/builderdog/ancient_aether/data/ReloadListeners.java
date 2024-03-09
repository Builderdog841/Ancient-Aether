package net.builderdog.ancient_aether.data;

import com.aetherteam.aether.blockentity.AltarBlockEntity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Mod.EventBusSubscriber(modid = AncientAether.MODID)
public class ReloadListeners {
    @SubscribeEvent
    public static void reloadListenerSetup(AddReloadListenerEvent event) {
        event.addListener(new FuelReloadListener());
    }

    public static class FuelReloadListener extends SimpleJsonResourceReloadListener {
        public static final Gson GSON_INSTANCE = Deserializers.createFunctionSerializer().create();

        public FuelReloadListener() {
            super(GSON_INSTANCE, "fuels");
        }

        @Override
        protected void apply(@NotNull Map<ResourceLocation, JsonElement> object, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profiler) {
            AltarBlockEntity.getEnchantingMap().clear();
            AncientAetherBlocks.registerFuels();
        }
    }
}