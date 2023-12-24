package net.builderdog.ancient_aether.client.renderer.entity;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.client.renderer.accessory.PendantRenderer;
import com.aetherteam.aether.client.renderer.player.layer.DartLayer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.*;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.misc.GravititeDart;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AncientAetherEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.CAMPFIRE.get(), CampfireRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, false));
        event.registerEntityRenderer(AncientAetherEntities.CHEST_BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, true));
        event.registerEntityRenderer(AncientAetherEntities.AERONAUTIC_LEAPER.get(), AeronauticLeaperRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.ANCIENT_GUARDIAN.get(), AncientGuardianRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.ANCIENT_CORE.get(), AncientCoreRenderer::new);
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
            event.registerLayerDefinition(AncientAetherModelLayers.ANCIENT_CORE, AncientCoreModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.HIGHLAND_BUFFALO, HighlandBuffaloModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.ROOTHYRN, RoothyrnModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.AERONAUTIC_LEAPER, AeronauticLeaperModel::createBodyLayer);
        }
    }
    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        EntityRenderDispatcher renderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        String[] types = new String[]{"default", "slim"};
        for (String type : types) {
            PlayerRenderer playerRenderer = event.getSkin(type);
            if (playerRenderer != null) {
                playerRenderer.addLayer(new DartLayer<>(renderDispatcher, playerRenderer, (entity) -> new GravititeDart(AncientAetherEntities.GRAVITITE_DART.get(), entity.level()), AetherPlayer::getGoldenDartCount, 1.0F));
            }
        }
    }

    public static void registerCuriosRenderers() {
        CuriosRendererRegistry.register(AncientAetherItems.ANCIENT_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.HEALTH_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.HERMES_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.ARKENIUM_PENDANT.get(), PendantRenderer::new);
    }
}