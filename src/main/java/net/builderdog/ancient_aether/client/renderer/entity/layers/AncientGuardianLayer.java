package net.builderdog.ancient_aether.client.renderer.entity.layers;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.model.AncientGuardianModel;
import net.builderdog.ancient_aether.entity.monster.dungeon.boss.AncientGuardian;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AncientGuardianLayer<T extends AncientGuardian, M extends AncientGuardianModel<T>> extends EyesLayer<T, M> {
    private static final RenderType ANCIENT_GUARDIAN_GLOW = RenderType.eyes(new ResourceLocation(AncientAether.MOD_ID, "textures/entity/boss/ancient_guardian/ancient_guardian_glow.png"));

    public AncientGuardianLayer(RenderLayerParent<T, M> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public @NotNull RenderType renderType() {
        return ANCIENT_GUARDIAN_GLOW;
    }
}