package net.builderdog.ancient_aether.client.renderer;

import com.aetherteam.aether.client.renderer.entity.WhirlwindRenderer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.blockentity.AncientAetherBlockEntityTypes;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.client.renderer.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.model.VeloxZephyrModel;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
        event.registerEntityRenderer(AncientAetherEntities.BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, false));
        event.registerEntityRenderer(AncientAetherEntities.CHEST_BOAT.get(), context -> new AncientAetherBoatRenderer<>(context, true));
        event.registerEntityRenderer(AncientAetherEntities.VELOX_ZEPHYR.get(), VeloxZephyrRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.VELOX_WHIRLWIND.get(), VeloxWhirlwindRenderer::new);
        event.registerEntityRenderer(AncientAetherEntities.VELOX_ZEPHYR_SNOWBALL.get(), (context) -> new ThrownItemRenderer<>(context, 3.0F, true));
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (AncientAetherBoatEntity.Type type : AncientAetherBoatEntity.Type.values()) {
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MOD_ID, type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(AncientAether.MOD_ID, type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(AncientAetherModelLayers.VELOX_ZEPHYR, VeloxZephyrModel::createBodyLayer);
            event.registerLayerDefinition(AncientAetherModelLayers.VELOX_ZEPHYR_TRANSPARENCY, VeloxZephyrModel::createBodyLayer);
        }
    }
}