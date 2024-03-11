package net.builderdog.ancient_aether.client.renderer;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import com.aetherteam.aether.client.renderer.accessory.PendantRenderer;
import com.aetherteam.aether.client.renderer.entity.model.ValkyrieWingsModel;
import com.aetherteam.aether.client.renderer.player.layer.DartLayer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.client.renderer.entity.*;
import net.builderdog.ancient_aether.client.renderer.entity.model.*;
import net.builderdog.ancient_aether.client.renderer.player.layer.ValkyrumWingsLayer;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.projectile.AeronauticDart;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AncientAetherRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(AncientAetherBlockEntityTypes.CAMPFIRE.get(), CampfireRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, false));
        event.registerEntityRenderer(AncientAetherEntityTypes.CHEST_BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, true));
        event.registerEntityRenderer(AncientAetherEntityTypes.FLUFFALO.get(), FluffaloRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.FESTIVE_SWET.get(), FestiveSwetRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.ROOTHYRN.get(), RoothyrnRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.AERONAUTIC_LEAPER.get(), AeronauticLeaperRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT.get(), MutatedAechorPlantRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.AERONAUTIC_DART.get(), AeronauticDartRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.MUTATED_AECHOR_NEEDLE.get(), MutatedAechorNeedleRenderer::new);
        event.registerEntityRenderer(AncientAetherEntityTypes.WIND_BLOW.get(), (context) -> new ThrownItemRenderer<>(context, 2.0F, true));
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (AncientAetherBoatEntity.Type type : AncientAetherBoatEntity.Type.values()) {
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MODID, type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MODID, type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(AncientAetherModelLayers.FLUFFALO, FluffaloModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.FESTIVE_SWET, FestiveSwetModel::createInnerBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.FESTIVE_SWET_OUTER, FestiveSwetModel::createOuterBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.ROOTHYRN, RoothyrnModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.AERONAUTIC_LEAPER, AeronauticLeaperModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.MUTATED_AECHOR_PLANT, MutatedAechorPlantModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.VALKYRUM_WINGS, () -> ValkyrieWingsModel.createMainLayer(3.5F, 3.375F));
        }
    }
    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        EntityRenderDispatcher renderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        String[] types = new String[]{"default", "slim"};
        for (String type : types) {
            PlayerRenderer playerRenderer = event.getSkin(type);
            if (playerRenderer != null) {
                playerRenderer.addLayer(new DartLayer<>(renderDispatcher, playerRenderer, (entity) -> new AeronauticDart(AncientAetherEntityTypes.AERONAUTIC_DART.get(), entity.level()), AetherPlayer::getGoldenDartCount, 1.0F));
                playerRenderer.addLayer(new ValkyrumWingsLayer<>(playerRenderer, Minecraft.getInstance().getEntityModels()));
            }
        }
    }

    public static void registerCuriosRenderers() {
        CuriosRendererRegistry.register(AncientAetherItems.ANCIENT_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.HEALTH_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.HERMES_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.ARKENIUM_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.VALKYRUM_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientAetherItems.VALKYRUM_GLOVES.get(), GlovesRenderer::new);
    }
}