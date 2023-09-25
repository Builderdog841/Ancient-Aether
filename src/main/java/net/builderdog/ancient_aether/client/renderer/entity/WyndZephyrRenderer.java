package net.builderdog.ancient_aether.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.layers.WyndZephyrTransparencyLayer;
import net.builderdog.ancient_aether.client.renderer.entity.model.WyndZephyrModel;
import net.builderdog.ancient_aether.entity.monster.WyndZephyr;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class WyndZephyrRenderer extends MobRenderer<WyndZephyr, EntityModel<WyndZephyr>> {
    private static final ResourceLocation WYND_ZEPHYR_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/wynd_zephyr/wynd_zephyr.png");

    public WyndZephyrRenderer(EntityRendererProvider.Context context) {
        super(context, new WyndZephyrModel(context.bakeLayer(AncientAetherModelLayers.WYND_ZEPHYR)), 0.5F);
        this.addLayer(new WyndZephyrTransparencyLayer(this, new WyndZephyrModel(context.getModelSet().bakeLayer(AncientAetherModelLayers.WYND_ZEPHYR_TRANSPARENCY))));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(WyndZephyr pEntity) {
        return WYND_ZEPHYR_TEXTURE;
    }

    protected void scale(WyndZephyr wyndZephyr, @Nonnull PoseStack poseStack, float partialTickTime) {
        float f = Mth.lerp(partialTickTime, (float)wyndZephyr.scale, (float)(wyndZephyr.scale + wyndZephyr.scaleAdd));
        float f1 = f / 40.0F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        f1 = 1.0F / ((float)Math.pow(f1, 5.0D) * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        poseStack.scale(f3, f2, f3);
        poseStack.translate(0.0D, 0.5D, 0.0D);
        if (this.getModel() instanceof WyndZephyrModel) {
            poseStack.scale(0.8F, 0.8F, 0.8F);
            poseStack.translate(0.0D, -0.1D, 0.0D);
        }
        float sin = Mth.sin((wyndZephyr.tickCount + partialTickTime) / 6);
        poseStack.translate(0.0D, sin / 15, 0.0D);
    }

    protected float getBob(@Nonnull WyndZephyr veloxzephyr, float partialTicks) {
        return Mth.lerp(partialTicks, veloxzephyr.tailRot, veloxzephyr.tailRot + veloxzephyr.tailRotAdd);
    }
}