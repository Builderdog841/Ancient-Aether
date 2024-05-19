package net.builderdog.ancient_aether.client.renderer.entity;

import com.aetherteam.aether.client.renderer.entity.AbstractCrystalRenderer;
import com.aetherteam.aether.client.renderer.entity.model.CrystalModel;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.client.renderer.AncientModelLayers;
import net.builderdog.ancient_aether.entity.projectile.RemedyCrystal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RemedyCrystalRenderer<T extends RemedyCrystal> extends AbstractCrystalRenderer<T> {
    private static final ResourceLocation REMEDY_CRYSTAL_TEXTURE = new ResourceLocation(AncientAether.MODID, "textures/entity/projectile/remedy_crystal.png");

    public RemedyCrystalRenderer(EntityRendererProvider.Context context) {
        super(context, new CrystalModel<>(context.bakeLayer(AncientModelLayers.REMEDY_CRYSTAL)));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull T crystal) {
        return REMEDY_CRYSTAL_TEXTURE;
    }
}