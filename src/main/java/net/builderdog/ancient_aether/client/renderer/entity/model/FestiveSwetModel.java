package net.builderdog.ancient_aether.client.renderer.entity.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class FestiveSwetModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;

    public FestiveSwetModel(ModelPart modelPart) {
        root = modelPart;
    }

    public static LayerDefinition createOuterBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("outer_layer", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public static LayerDefinition createInnerBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("inner_layer", CubeListBuilder.create().texOffs(32, 16).addBox(-8.0F, -18.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(32, 8).addBox(0.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 4).addBox(1.5F, -6.0F, -3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-3.5F, -6.0F, -3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public void setupAnim(@NotNull T p_103831_, float p_103832_, float p_103833_, float p_103834_, float p_103835_, float p_103836_) {
    }

    public @NotNull ModelPart root() {
        return root;
    }
}