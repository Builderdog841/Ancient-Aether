package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.aetherteam.aether.entity.monster.Swet;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.client.renderer.entity.model.FestiveSwetModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import org.jetbrains.annotations.NotNull;

public class FestiveSwetOuterLayer extends RenderLayer<Swet, FestiveSwetModel<Swet>> {
    private final FestiveSwetModel<Swet> outer;

    public FestiveSwetOuterLayer(RenderLayerParent<Swet, FestiveSwetModel<Swet>> entityRenderer, FestiveSwetModel<Swet> outerModel) {
        super(entityRenderer);
        this.outer = outerModel;
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull Swet swet, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = minecraft.shouldEntityAppearGlowing(swet) && swet.isInvisible();
        if (!swet.isInvisible() || flag) {
            VertexConsumer consumer;
            if (flag) {
                consumer = buffer.getBuffer(RenderType.outline(getTextureLocation(swet)));
            } else {
                consumer = buffer.getBuffer(RenderType.entityTranslucent(getTextureLocation(swet)));
            }

            (getParentModel()).copyPropertiesTo(outer);
            outer.prepareMobModel(swet, limbSwing, limbSwingAmount, partialTicks);
            outer.setupAnim(swet, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            outer.renderToBuffer(poseStack, consumer, packedLight, LivingEntityRenderer.getOverlayCoords(swet, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}