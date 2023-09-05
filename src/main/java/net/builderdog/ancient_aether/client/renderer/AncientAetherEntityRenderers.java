package net.builderdog.ancient_aether.client.renderer;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.renderer.entity.*;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.AncientGuardianModel;
import net.builderdog.ancient_aether.client.renderer.entity.model.GravititeDartRenderer;
import net.builderdog.ancient_aether.client.renderer.entity.model.HighlandBuffaloModel;
import net.builderdog.ancient_aether.client.renderer.entity.model.RoothyrnModel;
import net.builderdog.ancient_aether.client.renderer.player.layers.GravititeDartLayer;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AncientAetherEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.CAMPFIRE.get(), CampfireRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, false));
        event.registerEntityRenderer(AncientAetherEntities.CHEST_BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, true));
        event.registerEntityRenderer(AncientAetherEntities.LEAPING_SENTRY.get(), LeapingSentryRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.ANCIENT_GUARDIAN.get(), AncientGuardianRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.HIGHLAND_BUFFALO.get(), HighlandBuffaloRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.ROOTHYRN.get(), RoothyrnRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.GRAVITITE_DART.get(), GravititeDartRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (AncientAetherBoatEntity.Type type : AncientAetherBoatEntity.Type.values()) {
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MOD_ID, type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MOD_ID, type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(AncientAetherModelLayers.ANCIENT_GUARDIAN, AncientGuardianModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.HIGHLAND_BUFFALO, HighlandBuffaloModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.ROOTHYRN, RoothyrnModel::createBodyLayer);
        }
    }
    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        EntityRenderDispatcher renderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        String[] types = new String[]{"default", "slim"};
        String[] var3 = types;
        int var4 = types.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String type = var3[var5];
            PlayerRenderer playerRenderer = event.getSkin(type);
            if (playerRenderer != null) {
                playerRenderer.addLayer(new GravititeDartLayer(renderDispatcher, playerRenderer));
            }
        }
    }
}