package net.builderdog.ancient_aether.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.layers.VeloxZephyrTransparencyLayer;
import net.builderdog.ancient_aether.client.renderer.layers.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.model.VeloxZephyrModel;
import net.builderdog.ancient_aether.entity.monster.VeloxZephyr;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nonnull;

public class VeloxZephyrRenderer extends MobRenderer<VeloxZephyr, EntityModel<VeloxZephyr>> {
    private static final ResourceLocation VELOX_ZEPHYR_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/velox_zephyr/velox_zephyr.png");

    public VeloxZephyrRenderer(EntityRendererProvider.Context context) {
        super(context, new VeloxZephyrModel(context.bakeLayer(AncientAetherModelLayers.VELOX_ZEPHYR)), 0.5F);
        this.addLayer(new VeloxZephyrTransparencyLayer(this, new VeloxZephyrModel(context.getModelSet().bakeLayer(AncientAetherModelLayers.VELOX_ZEPHYR_TRANSPARENCY))));
    }

    @Override
    public ResourceLocation getTextureLocation(VeloxZephyr pEntity) {
        return VELOX_ZEPHYR_TEXTURE;
    }

    protected void scale(VeloxZephyr veloxzephyr, @Nonnull PoseStack poseStack, float partialTickTime) {
        float f = Mth.lerp(partialTickTime, (float)veloxzephyr.scale, (float)(veloxzephyr.scale + veloxzephyr.scaleAdd));
        float f1 = f / 40.0F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        f1 = 1.0F / ((float)Math.pow((double)f1, 5.0D) * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        poseStack.scale(f3, f2, f3);
        poseStack.translate(0.0D, 0.5D, 0.0D);
        if (this.getModel() instanceof VeloxZephyrModel) {
            poseStack.scale(0.8F, 0.8F, 0.8F);
            poseStack.translate(0.0D, -0.1D, 0.0D);
        }
        float sin = Mth.sin((veloxzephyr.tickCount + partialTickTime) / 6);
        poseStack.translate(0.0D, sin / 15, 0.0D);
    }

    protected float getBob(@Nonnull VeloxZephyr veloxzephyr, float partialTicks) {
        return Mth.lerp(partialTicks, veloxzephyr.tailRot, veloxzephyr.tailRot + veloxzephyr.tailRotAdd);
    }
}