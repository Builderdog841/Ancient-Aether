package net.builderdog.ancient_aether.client.renderer.entity;

import net.builderdog.ancient_aether.entity.projectile.WindBlow;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import org.jetbrains.annotations.NotNull;

public class WindBlowRenderer extends EntityRenderer<WindBlow> {
    public WindBlowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WindBlow windBlow) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}