package net.builderdog.ancient_aether.client.renderer.entity.layers;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class AncientAetherModelLayers {
    public static final ModelLayerLocation ANCIENT_GUARDIAN = register("ancient_guardian");
    public static final ModelLayerLocation HIGHLAND_BUFFALO = register("highland_buffalo");
    public static final ModelLayerLocation ROOTHYRN = register("roothyrn");

    public AncientAetherModelLayers() {
    }

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String type) {
        return register(new ResourceLocation("ancient_aether", name), type);
    }

    private static ModelLayerLocation register(ResourceLocation identifier, String type) {
        return new ModelLayerLocation(identifier, type);
    }
}
