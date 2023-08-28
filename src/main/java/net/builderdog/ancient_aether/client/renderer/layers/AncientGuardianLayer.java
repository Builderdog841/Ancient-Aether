package net.builderdog.ancient_aether.client.renderer.layers;

import com.aetherteam.aether_genesis.client.renderer.entity.model.SentryGuardianModel;
import com.aetherteam.aether_genesis.entity.monster.boss.SentryGuardian;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nonnull;

import net.builderdog.ancient_aether.client.renderer.model.AncientGuardianModel;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class AncientGuardianLayer<T extends AncientGuardian, M extends AncientGuardianModel<T>> extends EyesLayer<T, M> {
    private static final RenderType GUARDIAN_EYE = RenderType.eyes(new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian.png"));
    private static final RenderType GUARDIAN_EYE_LIT = RenderType.eyes(new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian.png"));

    public AncientGuardianLayer(RenderLayerParent<T, M> entityRenderer) {
        super(entityRenderer);
    }

    public void render(@Nonnull PoseStack poseStack, MultiBufferSource buffer, int packedLight, @Nonnull SentryGuardian guardian, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer consumer = buffer.getBuffer(this.renderType(guardian));
        ((AncientGuardianModel)this.getParentModel()).renderToBuffer(poseStack, consumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Nonnull
    public RenderType renderType(SentryGuardian guardian) {
        return guardian.isAwake() ? GUARDIAN_EYE_LIT : this.renderType();
    }

    @Nonnull
    public RenderType renderType() {
        return GUARDIAN_EYE;
    }
}
