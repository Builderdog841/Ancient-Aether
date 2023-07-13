package net.builderdog.ancient_aether.client.renderer.layers;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class AncientAetherModelLayers {

    public static final ModelLayerLocation VELOX_ZEPHYR = register("velox_zephyr");
    public static final ModelLayerLocation VELOX_ZEPHYR_TRANSPARENCY = register("velox_zephyr", "transparency");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String type) {
        return register(new ResourceLocation(AncientAether.MOD_ID, name), type);
    }

    private static ModelLayerLocation register(ResourceLocation identifier, String type) {
        return new ModelLayerLocation(identifier, type);
    }
}