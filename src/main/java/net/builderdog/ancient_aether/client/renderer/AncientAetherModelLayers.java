package net.builderdog.ancient_aether.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class AncientAetherModelLayers {
    public static final ModelLayerLocation ANCIENT_GUARDIAN = register("ancient_guardian");
    public static final ModelLayerLocation MUTATED_AECHOR_PLANT = register("mutated_aechor_plant");
    public static final ModelLayerLocation FLUFFALO = register("fluffalo");
    public static final ModelLayerLocation ROOTHYRN = register("roothyrn");
    public static final ModelLayerLocation AERONAUTIC_LEAPER = register("aeronautic_leaper");
    public static final ModelLayerLocation VALKYRUM_WINGS = register("valkyrum_wings");
    public static final ModelLayerLocation FESTIVE_SWET = register("festive_swet");
    public static final ModelLayerLocation FESTIVE_SWET_OUTER = register("festive_swet","outer");

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
