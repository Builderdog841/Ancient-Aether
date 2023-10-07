package net.builderdog.ancient_aether.client.renderer.entity.layers;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.model.AncientCoreModel;
import net.builderdog.ancient_aether.entity.monster.boss.ancient_core.AncientCore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AncientCoreLayer<T extends AncientCore, M extends AncientCoreModel<T>> extends EyesLayer<T, M> {
    private static final RenderType ANCIENT_CORE_GLOW = RenderType.eyes(new ResourceLocation(AncientAether.MOD_ID, "textures/entity/boss/ancient_core/ancient_core_glow.png"));

    public AncientCoreLayer(RenderLayerParent<T, M> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public @NotNull RenderType renderType() {
        return ANCIENT_CORE_GLOW;
    }
}