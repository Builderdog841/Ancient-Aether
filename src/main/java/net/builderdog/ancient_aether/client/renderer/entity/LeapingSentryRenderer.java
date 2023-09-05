package net.builderdog.ancient_aether.client.renderer.entity;

import com.aetherteam.aether.client.renderer.AetherModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.entity.layers.LeapingSentryLayer;
import net.builderdog.ancient_aether.entity.monster.LeapingSentry;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class LeapingSentryRenderer extends MobRenderer<LeapingSentry, SlimeModel<LeapingSentry>> {
	private static final ResourceLocation SENTRY_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/leaping_sentry/leaping_sentry.png");
	private static final ResourceLocation SENTRY_LIT_TEXTURE = new ResourceLocation(AncientAether.MOD_ID, "textures/entity/leaping_sentry/leaping_sentry_lit.png");

	public LeapingSentryRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel<>(context.bakeLayer(AetherModelLayers.SENTRY)), 0.3F);
		this.addLayer(new LeapingSentryLayer<>(this));
	}

	@Override
	protected void scale(LeapingSentry sentry, PoseStack poseStack, float partialTickTime) {
		float f = 0.879F;
		poseStack.scale(f, f, f);
		float f1 = sentry.getSize() + 1.0F;
		float f2 = 0.0F;
		float f3 = 1.0F / (f2 + 1.0F);
		poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(LeapingSentry sentry) {
		return sentry.isAwake() ? SENTRY_LIT_TEXTURE : SENTRY_TEXTURE;
	}
}
