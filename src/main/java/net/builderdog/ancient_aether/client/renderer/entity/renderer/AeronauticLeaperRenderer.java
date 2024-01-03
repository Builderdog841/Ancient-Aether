package net.builderdog.ancient_aether.client.renderer.entity.renderer;


import net.builderdog.ancient_aether.client.renderer.AncientAetherModelLayers;
import net.builderdog.ancient_aether.client.renderer.entity.model.AeronauticLeaperModel;
import net.builderdog.ancient_aether.entity.monster.AeronauticLeaper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class AeronauticLeaperRenderer extends MobRenderer<AeronauticLeaper, AeronauticLeaperModel<AeronauticLeaper>> {
	private static final ResourceLocation AERONAUTIC_LEAPER_TEXTURE = new ResourceLocation("ancient_aether", "textures/entity/aeronautic_leaper.png");

	public AeronauticLeaperRenderer(EntityRendererProvider.Context context) {
		super(context, new AeronauticLeaperModel<>(context.bakeLayer(AncientAetherModelLayers.AERONAUTIC_LEAPER)), 0.7F);
	}

	@Nonnull
	public ResourceLocation getTextureLocation(@Nonnull AeronauticLeaper aeronauticLeaper) {
		return AERONAUTIC_LEAPER_TEXTURE;
	}
}
