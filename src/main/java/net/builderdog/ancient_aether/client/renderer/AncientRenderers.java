package net.builderdog.ancient_aether.client.renderer;

import com.aetherteam.aether.attachment.AetherPlayerAttachment;
import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import com.aetherteam.aether.client.renderer.accessory.PendantRenderer;
import com.aetherteam.aether.client.renderer.entity.model.CrystalModel;
import com.aetherteam.aether.client.renderer.entity.model.ValkyrieWingsModel;
import com.aetherteam.aether.client.renderer.player.layer.DartLayer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.blockentity.AncientBlockEntityTypes;
import net.builderdog.ancient_aether.client.renderer.accessory.ShieldRenderer;
import net.builderdog.ancient_aether.client.renderer.entity.*;
import net.builderdog.ancient_aether.client.renderer.entity.model.*;
import net.builderdog.ancient_aether.client.renderer.player.layer.ValkyrumWingsLayer;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.builderdog.ancient_aether.entity.miscellaneous.AncientBoat;
import net.builderdog.ancient_aether.entity.projectile.AeronauticDart;
import net.builderdog.ancient_aether.item.AncientItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.CampfireRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class AncientRenderers {

    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AncientEntityTypes.FLUFFALO.get(), FluffaloRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.FESTIVE_SWET.get(), FestiveSwetRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.SLAMMROOT.get(), SlammrootRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.AERONAUTIC_LEAPER.get(), AeronauticLeaperRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.MUTATED_AECHOR_PLANT.get(), MutatedAechorPlantRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.WIND_BLOW.get(), WindBlowRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.AERONAUTIC_DART.get(), AeronauticDartRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.MUTATED_AECHOR_NEEDLE.get(), MutatedAechorNeedleRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.SPORE_BOMB.get(), SporeBombRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.REMEDY_CRYSTAL.get(), RemedyCrystalRenderer::new);
        event.registerEntityRenderer(AncientEntityTypes.BOAT.get(), context -> new AncientBoatRenderer<>(context, false));
        event.registerEntityRenderer(AncientEntityTypes.CHEST_BOAT.get(), context -> new AncientBoatRenderer<>(context, true));

        event.registerBlockEntityRenderer(AncientBlockEntityTypes.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(AncientBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(AncientBlockEntityTypes.CAMPFIRE.get(), CampfireRenderer::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (AncientBoat.Type type : AncientBoat.Type.values()) {
            event.registerLayerDefinition(AncientModelLayers.FLUFFALO, FluffaloModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.FESTIVE_SWET, FestiveSwetModel::createInnerBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.FESTIVE_SWET_OUTER, FestiveSwetModel::createOuterBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.SLAMMROOT, SlammrootModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.AERONAUTIC_LEAPER, AeronauticLeaperModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.MUTATED_AECHOR_PLANT, MutatedAechorPlantModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.SPORE_BOMB, SporeBombModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.REMEDY_CRYSTAL, CrystalModel::createBodyLayer);
            event.registerLayerDefinition(AncientModelLayers.VALKYRUM_WINGS, () -> ValkyrieWingsModel.createMainLayer(3.5F, 3.375F));

            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MODID, type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MODID, type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
        }
    }

    public static void addEntityLayers(EntityRenderersEvent.AddLayers event) {
        EntityRenderDispatcher renderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        for (PlayerSkin.Model type : event.getSkins()) {
            PlayerRenderer playerRenderer = event.getSkin(type);
            if (playerRenderer != null) {
                playerRenderer.addLayer(new DartLayer<>(renderDispatcher, playerRenderer, (entity) -> new AeronauticDart(AncientEntityTypes.AERONAUTIC_DART.get(), entity.level()), AetherPlayerAttachment::getGoldenDartCount, 1.0F));
                playerRenderer.addLayer(new ValkyrumWingsLayer<>(playerRenderer, Minecraft.getInstance().getEntityModels()));
            }
        }
    }

    public static void registerCuriosRenderers() {
        CuriosRendererRegistry.register(AncientItems.VALKYRUM_GLOVES.get(), GlovesRenderer::new);

        CuriosRendererRegistry.register(AncientItems.VALKYRUM_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientItems.HERMES_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientItems.WARRIOR_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientItems.GROWTH_PENDANT.get(), PendantRenderer::new);
        CuriosRendererRegistry.register(AncientItems.ANCIENT_PENDANT.get(), PendantRenderer::new);

        CuriosRendererRegistry.register(AncientItems.SHIELD_OF_INEBRIATION.get(), ShieldRenderer::new);
        CuriosRendererRegistry.register(AncientItems.SHIELD_OF_REMEDIATION.get(), ShieldRenderer::new);
    }
}