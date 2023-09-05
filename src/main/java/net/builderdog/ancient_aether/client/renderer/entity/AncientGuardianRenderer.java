package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientGuardianLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.AncientGuardianModel;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class AncientGuardianRenderer extends MobRenderer<AncientGuardian, AncientGuardianModel<AncientGuardian>> {
    private static final ResourceLocation ANCIENT_GUARDIAN_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian.png");
    private static final ResourceLocation ANCIENT_GUARDIAN_TEXTURE_GLOW = new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian.png");

    public AncientGuardianRenderer(EntityRendererProvider.Context context) {
        super(context, new AncientGuardianModel(context.bakeLayer(AncientAetherModelLayers.ANCIENT_GUARDIAN)), 0.5F);
        addLayer(new AncientGuardianLayer(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull AncientGuardian ancientGuardian) {
        return ancientGuardian.isAwake() ? ANCIENT_GUARDIAN_TEXTURE_GLOW : ANCIENT_GUARDIAN_TEXTURE;
    }
}
