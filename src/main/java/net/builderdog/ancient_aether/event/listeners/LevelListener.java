package net.builderdog.ancient_aether.event.listeners;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.event.hooks.LevelHooks;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AncientAether.MODID)
public class LevelListener {
    @SubscribeEvent
    public static void onPlayerTraveling(SaplingGrowTreeEvent event) {
        RandomSource random = event.getRandomSource();
        Holder<ConfiguredFeature<?, ?>> feature = event.getFeature();
        if (!ModList.get().isLoaded("aether_genesis")) {
            ResourceKey<ConfiguredFeature<?, ?>> newFeature = LevelHooks.modifyGrownSapling(random, feature);
            if (newFeature != null) {
                event.setFeature(newFeature);
            }
        }
    }
}