package net.builderdog.ancient_aether.client.renderer;

import com.aetherteam.aether.entity.monster.AbstractWhirlwind;

import net.builderdog.ancient_aether.entity.mobs.AbstractVeloxWhirlwind;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

import javax.annotation.Nonnull;

public class VeloxWhirlwindRenderer extends EntityRenderer<AbstractVeloxWhirlwind> {
    public VeloxWhirlwindRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull AbstractVeloxWhirlwind whirlwind) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}