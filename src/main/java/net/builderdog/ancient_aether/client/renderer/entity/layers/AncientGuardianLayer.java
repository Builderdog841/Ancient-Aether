package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nonnull;

import net.builderdog.ancient_aether.client.renderer.entity.model.AncientGuardianModel;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class AncientGuardianLayer<T extends AncientGuardian, M extends AncientGuardianModel<T>> extends EyesLayer<T, M> {
    private static final RenderType GUARDIAN_EYE = RenderType.eyes(new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian_glow.png"));
    private static final RenderType GUARDIAN_EYE_LIT = RenderType.eyes(new ResourceLocation("ancient_aether", "textures/entity/boss/ancient_guardian/ancient_guardian_glow.png"));

    public AncientGuardianLayer(RenderLayerParent<T, M> entityRenderer) {
        super(entityRenderer);
    }

    public void render(@Nonnull PoseStack poseStack, MultiBufferSource buffer, int packedLight, @Nonnull AncientGuardian guardian, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer consumer = buffer.getBuffer(renderType(guardian));
        ((AncientGuardianModel)getParentModel()).renderToBuffer(poseStack, consumer, 15728640, OverlayTexture.NO_OVERLAY, 0.65F, 0.65F, 0.65F, 0.1F);
    }

    @Nonnull
    public RenderType renderType(AncientGuardian guardian) {
        return guardian.isAwake() ? GUARDIAN_EYE_LIT : renderType();
    }

    @Nonnull
    public RenderType renderType() {
        return GUARDIAN_EYE;
    }
}
