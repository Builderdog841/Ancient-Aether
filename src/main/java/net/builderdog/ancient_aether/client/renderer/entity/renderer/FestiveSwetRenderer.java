package net.builderdog.ancient_aether.client.renderer.entity.renderer;

import com.aetherteam.aether.entity.monster.Swet;
import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.FestiveSwetOuterLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.FestiveSwetModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class FestiveSwetRenderer extends MobRenderer<Swet, FestiveSwetModel<Swet>> {

    private static final ResourceLocation FESTIVE_SWET_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/festive_swet.png");
    public FestiveSwetRenderer(EntityRendererProvider.Context context) {
        super(context, new FestiveSwetModel<>(context.bakeLayer(AncientAetherModelLayers.FESTIVE_SWET)), 0.3F);
        addLayer(new FestiveSwetOuterLayer(this, new FestiveSwetModel<>(context.bakeLayer(AncientAetherModelLayers.FESTIVE_SWET_OUTER))));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Swet swet) {
        return FESTIVE_SWET_TEXTURE;
    }

    @Override
    protected void scale(Swet swet, @NotNull PoseStack poseStack, float partialTicks) {
        float scale = 1.5F;
        if (!swet.getPassengers().isEmpty()) {
            scale += (swet.getPassengers().get(0).getBbWidth() + swet.getPassengers().get(0).getBbHeight()) * 0.75F;
        }

        float height = Mth.lerp(partialTicks, swet.getSwetHeightO(), swet.getSwetHeight());
        float width = Mth.lerp(partialTicks, swet.getSwetWidthO(), swet.getSwetWidth());

        poseStack.scale(width * scale, height * scale, width * scale);
        poseStack.scale(swet.getScale(), swet.getScale(), swet.getScale());
        shadowRadius = 0.3F * width;
    }
}